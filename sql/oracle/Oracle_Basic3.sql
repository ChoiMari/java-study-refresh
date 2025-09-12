-- 2025-09-12
--1. 'SMITH'보다 월급을 많이 받는 사원들의 이름과 월급을 출력하라.
-- select sal from emp where ename = 'SMITH';
select ename, sal
from emp 
where sal > (select sal from emp where ename = 'SMITH');

 
--2. 10번 부서의 사원들과 같은 월급을 받는 사원들의 이름, 월급,
-- 부서번호를 출력하라.
--select sal from emp where deptno = 10;
select ename, sal, deptno
from emp
where sal = ANY(select sal from emp where deptno = 10);

select ename, sal, deptno
from emp
where sal in(select sal from emp where deptno = 10);
 
--3. 'BLAKE'와 같은 부서에 있는 사원들의 이름과 고용일을 뽑는데
-- 'BLAKE'는 빼고 출력하라.
--select deptno from emp where ename = 'BLAKE';
select ename, hiredate
from emp
where deptno = (select deptno from emp where ename = 'BLAKE')
and ename != 'BLAKE';

--4. 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을
-- 출력하되, 월급이 높은 사람 순으로 출력하라.
-- 평균 급여 : select avg(sal) from emp;
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
order by sal desc;
 
--5. 이름에 'T'를 포함하고 있는 사원들과 같은 부서에서 근무하고
-- 있는 사원의 사원번호와 이름을 출력하라.
-- select deptno from emp where ename like '%T%'; 

select empno, ename
from emp
where deptno in (select deptno from emp where ename like '%T%');

select empno, ename
from emp
where deptno =ANY (select deptno from emp where ename like '%T%');

--6. 30번 부서에 있는 사원들 중에서 가장 많은 월급을 받는 사원보다
-- 많은 월급을 받는 사원들의 이름, 부서번호, 월급을 출력하라.
--(단, ALL(and) 또는 ANY(or) 연산자를 사용할 것)
-- 30번 부서의 월급 가장 많은 사원 select max(sal)from emp where deptno = 30; 
select ename, deptno, sal
from emp
where sal > ANY (select max(sal)from emp where deptno = 30);
 
 
--7. 'DALLAS'에서 근무하고 있는 사원과 같은 부서에서 일하는 사원의
-- 이름, 부서번호, 직업을 출력하라.
select deptno from dept where loc = 'DALLAS';

select ename, deptno, job
from emp
where deptno = (select deptno from dept where loc = 'DALLAS');

 
--8. SALES 부서에서 일하는 사원들의  같은 부서번호, 이름, 직업을 갖는 사원정보를 출력하라.
select deptno from dept where dname = 'SALES';

select deptno, ename, job
from emp
where deptno = (select deptno from dept where dname = 'SALES');
 
--9. 'KING'에게 보고하는 모든 사원의 이름과 급여를 출력하라
--king 이 사수인 사람 (mgr 데이터가 king 사번)

--select empno from emp where ename = 'KING';

select ename, sal
from emp 
where mgr = (select empno from emp where ename = 'KING');
 
--10. 자신의 급여가 평균 급여보다 많고, 이름에 'S'가 들어가는
-- 사원과 동일한 부서에서 근무하는 모든 사원의 사원번호, 이름,
-- 급여를 출력하라.
--select avg(sal) from emp;
--select deptno from emp where ename like '%S%';

select empno, ename, sal       
from emp
where sal > (select avg(sal) from emp) 
and deptno in (select deptno from emp where ename like '%S%');

 
--11. 커미션을 받는 사원과 부서번호, 월급이 같은 사원의
-- 이름, 월급, 부서번호를 출력하라.
--select deptno from emp where comm is not null;
--select sal from emp where comm is not null;
select ename, sal, deptno
from emp
where deptno in (select deptno from emp where comm is not null) 
and sal in (select sal from emp where comm is not null);
 
--12. 30번 부서 사원들과 월급과 커미션이 같지 않은
-- 사원들의 이름, 월급, 커미션을 출력하라.
select sal from emp where deptno = 30;
select nvl(comm,0) from emp where deptno = 30;

select ename, sal, comm
from emp
where sal not in (select sal from emp where deptno = 30)
and comm not in (select nvl(comm,0) from emp where deptno = 30);


------------------------------------------------------

/*
1. DDL (데이터 정의어)
create, alter, drop, truncate, rename, modify

2. DML (데이터 조작어)
insert, update, delete -> commit 또는 rollback 필요(오라클은)
-> 작업 시 락이 걸림(트랜젝션을 해야 풀린다) 
-> commit과 rollback을 명시적으로 해야한다

누군가 commit 작업에 대해서 커밋이나 롤백을 하지 않으면
insert, update, delete가 안된다(락이 걸려서)
select는 됨

또 다른 이유 : log write기록이 안 써지는 경우가 있음
    DML -> log write 선행 -> 디스크 반영
    log 파일이 가득찰 수 있다.
    주기적 백업이 필요함
    로그를 못쓰면 DML작업이 안된다

3. DQL : select
4. DCL : grant, revoke
5. TCL : commit, rollback, savepoint
*/


--DML
-- insert
-- 접속 계정의 테이블 목록 볼 수 있음
select * from tab; 

select * from tab where tname = 'BOARD';
select * from tab where tname = 'EMP';

-- create table 테이블명();
create table temp(
    id      number  primary key, -- not null, unique
    name    varchar2(20)
);

--insert into 테이블명() values();
insert into temp(id, name) values(100, '홍길동');

commit;

-- 테이블에 정의한 컬럼 순서대로 나열해야함(생략 안하는걸 권장 - 가독성 떨어짐)
insert into temp values(200,'김유신');
rollback; -- 이전 커밋 전까지 되돌림

insert into temp(name) values ('아무개');
-- PK 컬럼에 값 넣지 않아서 오류
-- ORA-01400: cannot insert NULL into ("KOSA"."TEMP"."ID")

insert into temp(id, name)
values (100, '흑흑');
-- pk컬럼이라서 중복데이터 불가
-- ORA-00001: unique constraint (KOSA.SYS_C007001) violated

insert into temp (id) values (200);
-- 1 행 이(가) 삽입되었습니다.

select * from temp;
commit;
---------------------------------------------------------

-- Tip
-- PL/SQL : 배치 프로그램
-- 스케줄러(프로시저로 만듬)
-- 예) 출결관리 프로그램 - 출결 표현
-- 아침 6시 자동으로 insert돌아가고 빈 행을 만들고
-- 출석누르면 들어가고 안오면 null

create table temp2(
    id  varchar2(50) 
);

desc temp2
/*
begin
    for i in 1..100 loop -- 1~100까지 반복
        insert into temp2(id) values('A' || to_char(i));
    end loop;
end;
*/

select * from temp2;

create table temp3(
    member_id   number(3) not null,
    name        varchar2(10), -- 기본 null허용
    regdate     date    default sysdate -- DB 서버날짜
);

insert into temp3(member_id, name, regdate) values(100, '홍길동', '2025-09-12');
select * from temp3;
commit;

insert into temp3(member_id, name) values(200, '김유신');

-----------------------------------------------
create table temp4(
    id number
);

create table temp5(num number);

insert into temp4(id) values(1);
insert into temp4(id) values(2);
insert into temp4(id) values(3);
insert into temp4(id) values(4);
insert into temp4(id) values(5);
insert into temp4(id) values(6);
insert into temp4(id) values(7);
insert into temp4(id) values(8);
insert into temp4(id) values(9);
commit;
----------------------------------------------
-- 대량 데이터 삽입하기
-- temp4에 있는 모든 데이터를 한 번에 temp5에 넣고 싶음
--insert into 테이블명(컬럼리스트) values ();
--insert into 테이블명(컬럼리스트) select절
insert into temp5 (num) (select id from temp4);
select * from temp5;
commit;

-- 대량 데이터 삽입
-- 데이터 담을 테이블 존재 X, 
-- 테이블의 구조(스키마) 복제, 데이터 삽입 작업 한번에 할 수 있음
-- 단, 제약 조건 정보는 복제되지 않는다.
-- 데이터를 지우기 불안하면 복제해놓고 작업
create table copy_emp 
as
    (select empno, ename, job, sal
        from emp
    where deptno = 20);

select * from copy_emp;

------------------------------------

-- 대량 데이터 삽입
/*
1. insert into 테이블명 (select절);
2. create table as (select절);
*/

-- 조건을 거짓으로 만들어서 스키마만 복제(데이터 X, 구조만 복제함)
create table copy_emp3 as (select * from emp where 1=2);

select * from copy_emp3;


----------------------------------------------
/*
update 테이블명
set 컬럼명 = 값, 컬럼명 = 값

update 테이블명
set 컬럼명 = (서브쿼리)
where (서브쿼리)
*/

select * from copy_emp;
update copy_emp
set sal = 0;
rollback;

update copy_emp
set sal = 1111
where empno = 7369;

select * from copy_emp;
commit;

update copy_emp
set sal = (select sum(sal) from emp);

rollback;

update copy_emp
set ename = 'AAA' , job = 'IT', 
sal = 1000
where empno = 7369;

select * from copy_emp
where empno = 7369;

commit;

---------------------------------------

delete from copy_emp;
select * from copy_emp
rollback;

delete from copy_emp
where job = 'IT';

--------------------------------------

/*
개발자(SQL)
1. CRUD(insert, select, update, delete)
2. 어플리케이션(APP) 
    -> 표준 JDBC API
    -> DB작업을 한다
3. insert, update, delete, select(70%)

JAVA 어플리케이션이 DB에 있는 EMP테이블에 접근해서
데이터를 조회, 수정, 삭제, ...
    -> MVC 패턴 사용
분업화
Model : DTO(VO), DAO, SERVICE -> DAO(DB연결, CRUD 메서드 구현)
View : 1차 때는 콘솔, 2차는 jsp 또는 html
Controller : 중앙 통제(요청, 응답) 서블릿(servlet) : 웹 용 자바파일(요청, 응답 가능한 객체)

DAO 클래스 만듬(데이터 접근 오브젝트)
기본적인 CRUD 메서드 만드는 것이 목적

1. 전체 조회 : public List<Emp> getEmpList(){};
    select * from emp;
2. 조건 조회 : public Emp getEmpListByEmpno(int empno)
    select * from emp where empno = empno;
3. 데이터 삽입 :public int insertEmp(Emp emp){} 
    insert into emp(empno, ...) values(...);
4. 삭제 : public int deleteEmp(int empno){}
    delete from emp where empno = empno;
5. 수정 : public int updateEmp(Emp emp) {}
    update emp set ename = '...';

Java에서 이 5개의 메서드를 만들 수 있다
DB에서 이 5개의 쿼리문을 작성할 수 있다
*/

/*
Tip
*/
select * from tab; -- 접속한 계정이 쓸 수 있는 테이블 목록
select * from col
where tname = 'EMP'; -- 접속한 계정의 EMP테이블의 컬럼 목록

--제약 조건 확인
select * from user_constraints;
select * from user_constraints
where table_name = 'EMP'; 

---------------------------------------------
--DDL
-- 가상 컬럼(조합 컬럼)
-- 학생 성적 테이블
-- 학번, 국어, 영어, 수학, 합계, 평균
-- 합계, 평균은 데이터 무결성 우려가 있음
-- 자주 사용되면 만들기도 함
-- 해결법 : 가상 컬럼(조합 컬럼)
-- -> 국어점수가 변경되면, 평균과 합계가 변화되어야 함

create table vtab1(
    no1 number, --만약 이거하려면 default 0을 해놓는게 좋다.(null입력 대비)
    no2 number,
    no3 number GENERATED ALWAYS as (no1 + no2) VIRTUAL -- 가상 컬럼
    -- 자동으로 삽입(no1 + no2)값으로
);

insert into vtab1 (no1, no2)
values(100, 50);

select * from vtab1; -- 확인

insert into vtab1 (no1, no2, no3)
values(100, 50, 50);
-- SQL 오류: ORA-54013: INSERT operation disallowed on virtual columns
-- 가상 컬럼의 데이터는 직접 insert 불가

update vtab1
set no1 = 200;

select * from vtab1; -- 확인
-- 자동으로 바뀜
-- 무결성 문제 해결

-------------------------------------------------------------------
commit;

--실무 코드
-- 제품 (입고) : 분기별 데이터를 추출
create table vtable2(
    no number, -- 순번
    p_code char(4), -- 제품 코드(A001, B003)
    p_date char(8), -- 입고일(20250101, 20251010)
    --실무에서 필요에 따라서 날짜 데이터를 date로 하지않고 문자데이터로 설정한다
    p_qty number, -- 수량
    p_bungi number(1) generated always as (
        case when substr(p_date,5,2) in ('01','02','03') then 1
             when substr(p_date,5,2) in ('04','05','06') then 2
             when substr(p_date,5,2) in ('07','08','09') then 3
        else 4
        end
    ) VIRTUAL
    -- 되게 많이 사용되는 데이터면 설계 시에 아예 분기 데이터 컬럼을 만듬
    --(이건 사실 역정규화)
);

insert into vtable2(p_date) values ('20240101');
insert into vtable2(p_date) values ('20240501');
insert into vtable2(p_date) values ('20240601');
insert into vtable2(p_date) values ('20241201');
commit;

select * from vtable2; -- 확인
select * from vtable2 where p_bungi = 2;
-- 2분기 데이터 검색

--------------------------------------------------
--테이블 생성 수정 문법

-- 1. 테이블 생성
--create table 테이블명 (컬럼 데이터타입);
create table temp6(id number);

-- 2. 테이블 생성 후에 컬럼 추가하기
alter table temp6
add ename varchar2(20);
-- alter table 테이블명 add 컬럼명 데이터 타입;

desc temp6;

--3. 기존 테이블에 있는 컬럼 이름 변경하기
-- ename->username으로 변경 해봄
alter table temp6
rename column ename to username; 
-- 이건 안 외워도 됨(필요 시에 찾아서 하기)

desc temp6; --확인

--4. 데이터 타입 변경하기
-- 이미 데이터가 있는데 작게 줄이면 안됨
alter table temp6
modify (username varchar2(2000));

desc temp6; -- 확인

--5. 기존 테이블의 기존 컬럼 삭제하기
-- 회원가입 페이지에 남여 컬럼 만듬(업무에 사용되지 않는 컬럼을 굳이 만듬)
-- 업무에 사용되지 않으면 굳이 필요없다.(리소스 낭비)
alter table temp6
drop column username; -- 컬럼 & 데이터 삭제

desc temp6;

--6. 고민
-- 테이블의 데이터가 필요 없어짐
-- delete from emp;
-- truncate -> 테이블 데이터 삭제 : 크기도 줄음
-- auto commit되므로 주의해서 사용
-- truncate table emp;

--drop table 테이블명; -- 테이블 삭제
drop table temp6;

-- 기본 DDL 끝
-------------------------------------------------------

-- 데이터 베이스는 무결성이 중요함
--  -> 제약이 필요

/*
1.2.2 데이터 무결성 제약 조건의 종류 

PRIMARY KEY(PK) 유일하게 테이블의 각행을 식별(NOT NULL과 UNIQUE조건을 만족) 
FOREIGN KEY(FK) 열과 참조된 열 사이의 외래키 관계를 적용하고 설정합니다. 
UNIQUE key(UK) 테이블의 모든 행을 유일하게 하는 값을 가진 열(NULL을 허용) 
NOT NULL(NN) 열은 NULL값을 포함할 수 없습니다. 
CHECK(CK) 참이어야 하는 조건을 지정함(대부분 업무 규칙을 설정)

제약은 아니지만 default 키워드도 알고 있어야 한다
    ex) defulat sysdate
*/

/*
1. primary key(PK) : not null, unique 
emp empno pk where조건에 empno = 7788
    -> 고유한 데이터 1건 보장
    -> 성능상 조회르 많이 하는 컬럼
    -> 인덱스 설정
    -> pk는 기본으로 인덱스 설정함
테이블 당 pk 1개만 가능(복합 컬럼(컬럼묶음) 설정 허용)

pk 제약은? 
    -> create table 생성 시 한다
*/


select * from user_constraints;
select * from user_constraints
where table_name = 'EMP';

create table temp7(
    id number primary key -- 권장 X
    -- 제약 조건 이름 자동 생성 - 구분 어려움
);

-- 제약 조건에 이름 부여
-- 관습적 약속 : 제약조건_테이블명_컬럼명
create table temp7(
    id      number  constraint pk_temp7_id primary key,
    name    varchar2(20) not null,
    addr    varchar2(50)
);

select * from user_constraints where table_name = 'TEMP7';

insert into temp7(id, name, addr) values(1, '홍길동', '서울시 강남구');

select * from temp7;

-----------------------------------------------------------------
--unique
-- 테이블의 모든 행을 유일하게 하는 값을 가진 컬럼(null 허용)
-- 테이블 당 컬럼 수 만큼 가능
-- ename not null unique 

create table temp8(
    id      number  constraint pk_temp8_id primary key,
    name    varchar2(20) not null,
    addr    varchar2(50),
    jumin   nvarchar2(6) constraint uk_temp8_jumin unique -- null은 여러개 가능
);

select * from user_constraints where table_name = 'TEMP7';

insert into temp8(id, name, addr, jumin) 
values(1, '홍길동', '한양', '123456');

insert into temp8(id, name, addr, jumin) 
values(2, '길동', '강남', '123456');
-- ORA-00001: unique constraint (KOSA.UK_TEMP8_JUMIN) violated

insert into temp8(id, name, addr) 
values(2, '길동', '강남');
-- 1 행 이(가) 삽입되었습니다.
-- 이게 싫으면 not null 추가하기

--------------------------------------------------------------
commit;

--------------------------------------------------------------
select * from user_constraints
where table_name = 'TEMP9';

create table temp9(id number);
alter table temp9
add constraint pk_temp9_id primary key(id);

-- 만약 컬럼 3개를 묶어서 기본키로 설명하면?
/*
alter table temp9
add constraint pk_temp9_id primary key(id, num, regdate);

3개의 조합으로 묶어서 유일 값을 냄(순번)
where id = and num = and refdate = 
이렇게 3개를 찾아야 pk를 찾음
*/

drop table temp10;
create table temp10(id number, userid number);
alter table temp10
add constraint pk_temp10_id primary key(id, userid);
-- 복합키는 쓰는 순서가 중요하다

select * from user_constraints where table_name = 'TEMP10';
/*
튜닝 측면 : 복합키는 예민하다, 설정 시 순서가 중요함
1. 성능 : where id = 1 and userid = 'hong'
2. where id = 1
3. where userid = 'hong'
    성능에서 제일 느린건 3번 : 인덱스 적용 안됨
    복합키 쓸 때 가장 좋은건 순서
    1번은 pk라서 인덱스 쓰고
    복합키는 1번째 나열한 컬럼은 인덱스 생겨서 2번도 인덱스 씀
    3번은 인덱스 안써서 풀스캔
*/

alter table temp9
modify(ename not null);
-- ms시퀄은 not null을 제약조건으로 안보고 옵션으로 본다.

--check제약
--where gender in ('남','여');
create table temp11(
    id      number  constraint pk_temp11_id primary key,
    name    varchar2(20) not null,
    addr    varchar2(50),
    jumin   nvarchar2(6) constraint uk_temp11_jumin unique, -- null은 여러개 가능
    age number  constraints ck_temp11_age check(age >= 19)
);

select * from user_constraints where table_name = 'TEMP11';

insert into temp11(id, name, jumin, addr, age)
values (1,'홍길동','123456','서울시 강남구',18);
-- ORA-02290: check constraint (KOSA.CK_TEMP11_AGE) violated
--check 제약 조건 위배

insert into temp11(id, name, jumin, addr, age)
values (1,'홍길동','123456','서울시 강남구',19);
commit;

--------------------------------------------------------
--forein key
--1. 관계를 정의(1:1, 1:N, M:N)
--2. 관계 안에서 참조 제약 emp(deptno) dept(deptno) 참조
create table c_emp 
as 
select empno, ename, deptno from emp where 1=2; -- 구조만 복사

select * from c_emp;

create table c_dept
as
    select deptno, dname from dept where 1=2;
    
--확인
select * from c_emp;
select * from c_dept;

alter table c_dept
add constraint pk_c_dept_deptno primary key(deptno);

--fk
alter table c_emp
add constraint fk_c_emp_deptno foreign key(deptno)
references c_dept(deptno);
-- ORA-02270: no matching unique or primary key for this column-list
-- 참조키를 걸려면 거는 테이블의 테이블의 키는 unique or primary key여야 한다고
-- 보통 fk는 pk에 검

-- 삭제할 때는 참조 먼저 지워야 pk삭제 가능함

select * from user_constraints where table_name = 'C_DEPT';
select * from user_constraints where table_name = 'C_EMP';

--부서
insert into c_dept(deptno, dname) values(100, '인사팀');
insert into c_dept(deptno, dname) values(200, '관리팀');
insert into c_dept(deptno, dname) values(300, '회계팀');
commit;

select * from c_dept;

--신입 입사
insert into c_emp(empno, ename, deptno)
values(1, '신입이', 400);
-- ORA-02291: integrity constraint (KOSA.FK_C_EMP_DEPTNO) violated - parent key not found

select * from c_emp;
commit;

/* 사원 */
CREATE TABLE EMP (
	empno NUMBER NOT NULL, /* 사번 */
	ename VARCHAR2(20), /* 이름 */
	sal NUMBER, /* 급여 */
	deptno NUMBER /* 부서번호 */
);

/* 부서 */
CREATE TABLE DEPT (
	deptno NUMBER, /* 부서번호 */
	dname VARCHAR2(20) /* 부서명 */
);

ALTER TABLE EMP
ADD CONSTRAINT PK_EMP_EMPNO	PRIMARY KEY (empno);

ALTER TABLE DEPT
ADD CONSTRAINT PK_DEPT_DEPTNO 	PRIMARY KEY (deptno);

ALTER TABLE EMP
ADD CONSTRAINT FK_DEPT_TO_EMP 	FOREIGN KEY (deptno)	REFERENCES DEPT (deptno);

--제약 조건 끝
---------------------------------------------------------------

--영문테이블 , 영문 컬럼명

--[학생 성적 테이블] 생성하기
--학번의 데이터는 중복되거나 NULL 값을 허용하면 안된다
--이름 NULL 값을 허용하지 않는다
--국어--영어--수학 점수 컬럼은 숫자 타입이고 NULL 값을 허용
--값을 입력하지 않으면 default로 0값을 갖는다
--총점 ,평균 컬럼은 가상컬럼으로(조합컬럼) 생성한다
--학과코드는 학과 테이블에 학과코드를 참조한다
--학번 , 이름 , 국어 , 영어 , 수학 , 총점 , 평균 , 학과코드
create table student_grades(
    id      number   constraint pk_stu_grades primary key, -- not null + unique해도 됨
    name    varchar2(10 char)   not null,
    korean_score   number(3) default 0,
    english_score  number(3) default 0,
    math_score     number(3) default 0,
    total_score    number(3)  GENERATED ALWAYS as
         (korean_score + english_score + math_score) VIRTUAL,
    score_avg number(5)  GENERATED ALWAYS AS 
        ((korean_score + english_score + math_score) / 3) -- 이거 3넣은게 맘에 안듬
        VIRTUAL,
    dept_code   number
);

--학과 테이블
--학과코드 데이터는 중복되거나 NULL 값을 허용하면 안된다,
--학과명 은 null값을 허락하지 않는다
--학과코드 , 학과명
create table department(
    code        number  constraint pk_dept_code primary key,
    dept_name   varchar2(30 char)   not null
);


-- 참조 제약 조건 추가
alter table student_grades
add constraint fk_stu_grades_dept_code foreign key(dept_code)
references department(code);


--샘플 데이터 insert ..
-- 학과 테이블 insert
insert into department(code, dept_name) values(10, '컴퓨터공학과');
insert into department(code, dept_name) values(20, '영어영문학과');
insert into department(code, dept_name) values(30, '중어중문학과');
commit;

--학생 성적 테이블 insert
insert into student_grades(id, name, dept_code) values(1, '홍길동', 10);
insert into student_grades(id, name, dept_code, korean_score , english_score, math_score) 
values(2, '김유신', 20, 50, 100, 10);
insert into student_grades(id, name, dept_code, korean_score , english_score, math_score) 
values(3, '춘향이', 10, 100, 100, 100);
insert into student_grades(id, name, dept_code, korean_score , english_score, math_score) 
values(4, '이몽룡', 30, 80, 70, 50);
insert into student_grades(id, name, dept_code, korean_score , english_score, math_score) 
values(5, '변사또', 20, 20, 10, 10);
commit;

--그리고 select 결과는
--학번 , 이름 , 총점, 평균 , 학과코드 , 학과명 을 출력하세요
select s.id, s.name, s.total_score, s.score_avg, s.dept_code, d.dept_name 
from student_grades s join department d
on s.dept_code = d.code;

----------------------------------------------------
-- 카페에 개별 문제 품
​-- USERS 테이블 (사용자)
CREATE TABLE USERS (
    USER_ID NUMBER PRIMARY KEY,
    USER_NAME VARCHAR2(50) NOT NULL,
    EMAIL VARCHAR2(100) UNIQUE NOT NULL,
    REGISTER_DATE DATE DEFAULT SYSDATE
);

-- PRODUCTS 테이블 (상품)
CREATE TABLE PRODUCTS (
    PRODUCT_ID NUMBER PRIMARY KEY,
    PRODUCT_NAME VARCHAR2(100) NOT NULL,
    CATEGORY_ID NUMBER NOT NULL,
    PRICE NUMBER(10,2) NOT NULL CHECK (PRICE >= 0),
    STOCK_QUANTITY NUMBER NOT NULL CHECK (STOCK_QUANTITY >= 0)
);

-- ORDERS 테이블 (주문)
CREATE TABLE ORDERS (
    ORDER_ID NUMBER PRIMARY KEY,
    USER_ID NUMBER NOT NULL,
    ORDER_DATE DATE DEFAULT SYSDATE,
    TOTAL_AMOUNT NUMBER(10,2) NOT NULL CHECK (TOTAL_AMOUNT >= 0),
    CONSTRAINT FK_ORDERS_USERS FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);

-- ORDER_DETAILS 테이블 (주문 상세)
CREATE TABLE ORDER_DETAILS (
    ORDER_DETAIL_ID NUMBER PRIMARY KEY,
    ORDER_ID NUMBER NOT NULL,
    PRODUCT_ID NUMBER NOT NULL,
    QUANTITY NUMBER NOT NULL CHECK (QUANTITY > 0),
    SUB_TOTAL NUMBER(10,2) NOT NULL CHECK (SUB_TOTAL >= 0),
    CONSTRAINT FK_ORDER_DETAILS_ORDERS FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ORDER_ID),
    CONSTRAINT FK_ORDER_DETAILS_PRODUCTS FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCTS(PRODUCT_ID)
);

---------------------------------------------------------------------------------
/*
-- USERS 테이블 (사용자)
CREATE TABLE USERS (
    USER_ID NUMBER PRIMARY KEY,
    USER_NAME VARCHAR2(50) NOT NULL,
    EMAIL VARCHAR2(100) UNIQUE NOT NULL,
    REGISTER_DATE DATE DEFAULT SYSDATE
);

-- PRODUCTS 테이블 (상품)
CREATE TABLE PRODUCTS (
    PRODUCT_ID NUMBER PRIMARY KEY,
    PRODUCT_NAME VARCHAR2(100) NOT NULL,
    CATEGORY_ID NUMBER NOT NULL,
    PRICE NUMBER(10,2) NOT NULL CHECK (PRICE >= 0),
    STOCK_QUANTITY NUMBER NOT NULL CHECK (STOCK_QUANTITY >= 0)
);

-- ORDERS 테이블 (주문)
CREATE TABLE ORDERS (
    ORDER_ID NUMBER PRIMARY KEY,
    USER_ID NUMBER NOT NULL,
    ORDER_DATE DATE DEFAULT SYSDATE,
    TOTAL_AMOUNT NUMBER(10,2) NOT NULL CHECK (TOTAL_AMOUNT >= 0),
    CONSTRAINT FK_ORDERS_USERS FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);

-- ORDER_DETAILS 테이블 (주문 상세)
CREATE TABLE ORDER_DETAILS (
    ORDER_DETAIL_ID NUMBER PRIMARY KEY,
    ORDER_ID NUMBER NOT NULL,
    PRODUCT_ID NUMBER NOT NULL,
    QUANTITY NUMBER NOT NULL CHECK (QUANTITY > 0),
    SUB_TOTAL NUMBER(10,2) NOT NULL CHECK (SUB_TOTAL >= 0),
    CONSTRAINT FK_ORDER_DETAILS_ORDERS FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ORDER_ID),
    CONSTRAINT FK_ORDER_DETAILS_PRODUCTS FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCTS(PRODUCT_ID)
);

INSERT INTO USERS (USER_ID, USER_NAME, EMAIL, REGISTER_DATE) VALUES (1, '김철수', 'chulsoo@example.com', TO_DATE('2023-01-15', 'YYYY-MM-DD'));
INSERT INTO USERS (USER_ID, USER_NAME, EMAIL, REGISTER_DATE) VALUES (2, '이영희', 'younghee@example.com', TO_DATE('2023-02-10', 'YYYY-MM-DD'));
INSERT INTO USERS (USER_ID, USER_NAME, EMAIL, REGISTER_DATE) VALUES (3, '박민수', 'minsoo@example.com', TO_DATE('2023-03-05', 'YYYY-MM-DD'));
INSERT INTO USERS (USER_ID, USER_NAME, EMAIL, REGISTER_DATE) VALUES (4, '정지훈', 'jihoon@example.com', TO_DATE('2023-04-20', 'YYYY-MM-DD'));
INSERT INTO USERS (USER_ID, USER_NAME, EMAIL, REGISTER_DATE) VALUES (5, '최지연', 'jiyoun@example.com', TO_DATE('2023-05-25', 'YYYY-MM-DD'));


INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME, CATEGORY_ID, PRICE, STOCK_QUANTITY) VALUES (101, '아이폰 15', 1, 1500000, 50);
INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME, CATEGORY_ID, PRICE, STOCK_QUANTITY) VALUES (102, '갤럭시 S23', 1, 1400000, 30);
INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME, CATEGORY_ID, PRICE, STOCK_QUANTITY) VALUES (103, '맥북 프로 16', 2, 3200000, 20);
INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME, CATEGORY_ID, PRICE, STOCK_QUANTITY) VALUES (104, 'LG 그램 17', 2, 1900000, 15);
INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME, CATEGORY_ID, PRICE, STOCK_QUANTITY) VALUES (105, '에어팟 프로', 3, 350000, 100);
INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME, CATEGORY_ID, PRICE, STOCK_QUANTITY) VALUES (106, '갤럭시 버즈2', 3, 250000, 80);

INSERT INTO ORDERS (ORDER_ID, USER_ID, ORDER_DATE, TOTAL_AMOUNT) VALUES (1001, 1, TO_DATE('2024-01-10', 'YYYY-MM-DD'), 1500000);
INSERT INTO ORDERS (ORDER_ID, USER_ID, ORDER_DATE, TOTAL_AMOUNT) VALUES (1002, 2, TO_DATE('2024-02-15', 'YYYY-MM-DD'), 3200000);
INSERT INTO ORDERS (ORDER_ID, USER_ID, ORDER_DATE, TOTAL_AMOUNT) VALUES (1003, 3, TO_DATE('2024-03-05', 'YYYY-MM-DD'), 1900000);
INSERT INTO ORDERS (ORDER_ID, USER_ID, ORDER_DATE, TOTAL_AMOUNT) VALUES (1004, 4, TO_DATE('2024-03-20', 'YYYY-MM-DD'), 250000);
INSERT INTO ORDERS (ORDER_ID, USER_ID, ORDER_DATE, TOTAL_AMOUNT) VALUES (1005, 1, TO_DATE('2024-04-01', 'YYYY-MM-DD'), 350000);

INSERT INTO ORDER_DETAILS (ORDER_DETAIL_ID, ORDER_ID, PRODUCT_ID, QUANTITY, SUB_TOTAL) VALUES (2001, 1001, 101, 1, 1500000);
INSERT INTO ORDER_DETAILS (ORDER_DETAIL_ID, ORDER_ID, PRODUCT_ID, QUANTITY, SUB_TOTAL) VALUES (2002, 1002, 103, 1, 3200000);
INSERT INTO ORDER_DETAILS (ORDER_DETAIL_ID, ORDER_ID, PRODUCT_ID, QUANTITY, SUB_TOTAL) VALUES (2003, 1003, 104, 1, 1900000);
INSERT INTO ORDER_DETAILS (ORDER_DETAIL_ID, ORDER_ID, PRODUCT_ID, QUANTITY, SUB_TOTAL) VALUES (2004, 1004, 106, 1, 250000);
INSERT INTO ORDER_DETAILS (ORDER_DETAIL_ID, ORDER_ID, PRODUCT_ID, QUANTITY, SUB_TOTAL) VALUES (2005, 1005, 105, 1, 350000);

commit;
*/

-- USERS 테이블 확인
SELECT * FROM USERS;

-- PRODUCTS 테이블 확인
SELECT * FROM PRODUCTS;

-- ORDERS 테이블 확인
SELECT * FROM ORDERS;

-- ORDER_DETAILS 테이블 확인
SELECT * FROM ORDER_DETAILS;
--------------------------------------------------------------------------------
--1. 전체 상품의 평균 가격보다 비싼 상품의 상품명, 가격을 조회하세요.
--(사용 테이블: PRODUCTS)
-- select avg(price) from products; --평균 가격
select product_name, price
from products
where price > (select avg(price) from products);

--2. 한 번이라도 주문한 적이 있는 사용자의 이름, 이메일을 조회하세요.
--(사용 테이블: USERS, ORDERS)
select u.user_name, u.email
from users u join orders o
on u.user_id = o.user_id; 
--조인만 해도 걸러짐

--3. 쇼핑몰에서 가장 많이 팔린 상품의 상품명, 총 판매량을 조회하세요.
--(사용 테이블: ORDER_DETAILS, PRODUCTS)
-- select product_id, max(QUANTITY) from ORDER_DETAILS group by PRODUCT_ID;
select p.product_name, o.max_q "총 판매량"
from PRODUCTS p 
join (select product_id, max(QUANTITY) as max_q from ORDER_DETAILS group by PRODUCT_ID) o
on p.PRODUCT_ID = o.PRODUCT_ID;


--4. 2024년에 주문한 적이 있는 사용자의 이름, 이메일을 조회하세요.
--(사용 테이블: USERS, ORDERS)
-- select USER_ID from ORDERS where to_char(ORDER_DATE, 'YYYY') = '2024';
select u.user_name, u.email
from users u join (select USER_ID from ORDERS where to_char(ORDER_DATE, 'YYYY') = '2024') o
on u.USER_ID = o.USER_ID;


--5. 가장 총 주문 금액이 높은 주문을 한 사용자의 이름, 이메일, 주문 금액을 조회하세요.
--(사용 테이블: ORDERS, USERS)
--select user_id, TOTAL_AMOUNT from ORDERS where TOTAL_AMOUNT = (select max(TOTAL_AMOUNT) from ORDERS);

select u.user_name, u.email, o.total_amount
from USERS u join (select user_id, TOTAL_AMOUNT from ORDERS where TOTAL_AMOUNT = (select max(TOTAL_AMOUNT) from ORDERS)) o
on u.user_id = o.user_id;



--6. 한 번도 주문한 적이 없는 사용자의 이름, 이메일을 조회하세요.
--(사용 테이블: USERS, ORDERS)
--select user_id from ORDERS;
--  한 번도 주문한 적이 없다 = ORDERS 테이블에 저장된 user_id가 없다
select user_name, email
from users
where user_id not in (select user_id from ORDERS);

--7. 각 카테고리별로 가장 비싼 상품의 카테고리 ID, 상품명, 가격을 조회하세요.
--(사용 테이블: PRODUCTS)
select CATEGORY_ID, max(price) from PRODUCTS group by CATEGORY_ID; 

select p.CATEGORY_ID, p.PRODUCT_NAME, p.PRICE
from PRODUCTS p 
join (select CATEGORY_ID, max(price) max_p from PRODUCTS group by CATEGORY_ID) c
on p.CATEGORY_ID = c.CATEGORY_ID and p.PRICE = c.max_p;

--8. 쇼핑몰에서 가장 많은 주문을 한 사용자의 이름, 총 주문 수를 조회하세요.
--(사용 테이블: USERS, ORDERS)
select user_id, count(user_id) from ORDERS group by USER_ID;

select u.user_name, o.o_count "총 주문 수"
from users u join (select user_id, count(user_id) as o_count from ORDERS group by USER_ID) o
on u.user_id = o.user_id
where o.o_count >= ALL(select count(user_id) from ORDERS group by USER_ID);


--9. '아이폰 15' 상품을 구매한 적이 있는 사용자의 이름, 이메일을 조회하세요.
--(사용 테이블: USERS, ORDERS, ORDER_DETAILS, PRODUCTS)
--select PRODUCT_ID from PRODUCTS where PRODUCT_NAME = '아이폰 15';
​
select u.user_name, u.email
from users u join ORDERS o
on u.user_id = o.user_id
join ORDER_DETAILS od
on o.ORDER_ID = od.ORDER_ID
join (select PRODUCT_ID from PRODUCTS where PRODUCT_NAME = '아이폰 15') p
on od.PRODUCT_ID = p.PRODUCT_ID;















