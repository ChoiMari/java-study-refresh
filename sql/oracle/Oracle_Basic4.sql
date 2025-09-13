--20250913
--개발자 관점에서 FK 보기
--master - detail 관계 (FK) 
--부모 - 자식 관계 (FK)

-- c_dept , c_emp (FK : deptno) 관계
-- c_dept (master , 부모)

--1. c_emp 테이블 있는 신입이 삭제
select * from c_emp; --ok

--2. c_dept 테이블 있는 100 부서 삭제
delete from c_dept where deptno=100;  --  이미 100을 사용하고 (c_emp)
--ORA-02292: integrity constraint (KOSA.FK_C_EMP_DEPTNO) violated - child record found

delete from c_dept where deptno=200;  -- 200 는 참조당하고 있지 않아요 ...

rollback;

--2. c_dept 에 있는 100 데이터 삭제하고 싶어요
--2.1 참조하는 ... c_emp  100 데이터 삭제 , 변경 다른 값

--------------------------------------------------------------------------------
/*
column datatype [CONSTRAINT constraint_name]
 REFERENCES table_ name (column1[,column2,..] [ON DELETE CASCADE])
column datatype,
. . . . . . . ,
[CONSTRAINT constraint_name] FOREIGN KEY (column1[,column2,..])
 REFERENCES table_name (column1[,column2,..] [ON DELETE CASCADE]


ON DELETE CASCADE 부모 테이블과 생명을 같이 하겠다

alter table c_emp
add constraint fk_c_emp_deptno foreign key(deptno) 
references c_dept(deptno) ON DELETE CASCADE; 


delete from c_emp where empno=1  >> deptno >> 100번
delete from c_dept where deptno=100; 삭제 안되요 (참조 하고 있으니까)

ON DELETE CASCADE 걸면 삭제되요 
delete from c_dept where deptno=100;  --> c_emp 1 번 사원데이터 삭제 
부모삭제 >> 참조하고 있는 자식도 삭제


MS-SQL , my-sql
ON DELETE CASCADE
ON UPDATE CASCADE
*/
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

--------------------------------------------------------------
--개발자에 필요한 SQL
/*
 SEQUENCE 특징 
1) 자동적으로 유일 번호를 생성합니다. 
2) 공유 가능한 객체 (여러개의 테이블이 같이 사용한다)
3) 주로 기본 키 값을 생성하기 위해 사용됩니다. 
4) 어플리케이션 코드를 대체합니다. 
5) 메모리에 CACHE되면 SEQUENCE 값을 액세스 하는 효율성을 향상시킵니다.

CREATE  SEQUENCE  sequence_name 
[INCREMENT  BY  n] 
[START  WITH  n] 
[{MAXVALUE n | NOMAXVALUE}] 
[{MINVALUE n | NOMINVALUE}] 
[{CYCLE | NOCYCLE}] 
[{CACHE | NOCACHE}];

sequence_name  SEQUENCE 의 이름입니다. 
INCREMENT  BY  n  정수 값인 n으로 SEQUENCE번호 사이의 간격을 지정. 
                    이 절이 생략되면 SEQUENCE는 1씩 증가. 
START  WITH  n  생성하기 위해 첫번째 SEQUENCE를 지정. 
                    이 절이 생략되면 SEQUENCE는 1로 시작.
MAXVALUE n  SEQUENCE 를 생성할 수 있는 최대 값을 지정. 
NOMAXVALUE  오름차순용 10^27 최대값과 내림차순용-1의 최소값을 지정. 
MINVALUE n  최소 SEQUENCE 값을 지정. 
NOMINVALUE  오름차순용 1과 내림차순용-(10^26)의 최소값을 지정. 
CYCLE | NOCYCLE 최대 또는 최소값에 도달한 후에 계속 값을 생성할 지의 여부를 
                지정. NOCYCLE 이 디폴트. 
CACHE | NOCACHE  얼마나 많은 값이 메모리에 오라클 서버가 미리 할당하고 유지 
                    하는가를 지정. 디폴트로 오라클 서버는 20을 CACHE. 
*/

desc board; -- 확인

create table board(
    board_id    number  constraint pk_board_board_id primary key,
    title   nvarchar2(50)
);

select * from user_constraints where table_name = 'BOARD';
--대문자로 검색해야지 나온다

--글쓰기
-- pk notnull+unique+index
-- 인덱스 사용이유 : 검색속도 향상위해
-- 인덱스페이지 찾아가서 검색
--PK와 unique설정 시에 자동으로 적용됨

insert into board(board_id, title) values (1,'방가');
insert into board(board_id, title) values (2,'방가');

select * from board;

rollback;

--처음 글을 쓰면
-- 글번호가 1번이길 원함
-- 다음 글은 2번, 3,4,5, ...
-- 순차적 증가를 원함

insert into board(board_id, title)
values((select count(board_id) + 1 from board),'방가1');
-- 글 삭제 시 번호 생성에 중복값 발생 에러.
insert into board()
values((select nvl(max(board_id),0)+1 from board)'방가2');

----------------------------------------------------------

-- count, max 순번 만드는 논리
-- 시퀀스 객체 (순번) 채번기(번호표 뽑기)
-- 공유 객체
create sequence board_num;

--채번
select board_num.nextval from dual;

--현재 채번한 마지막 번호 확인(마지막으로 뽑은 번호 확인)
select board_num.currval from dual;

--공유 객체(여러개의 테이블이 서로 공유 할 수 있음)
/*
A테이블            B테이블
insert : 1          insert : 2
                    insert : 3
insert : 4
insert : 5
                    insert : 6
이렇게 공유됨
*/

create table kboard(
    num number constraint pk_kboard_num primary key,
    title nvarchar2(20)
);

create sequence tboard_num;

insert into kboard(num, title)
values (kboard_num.nextval,'1번');

insert into kboard(num, title)
values (kboard_num.nextval,'2번');

insert into kboard(num, title)
values (kboard_num.nextval,'3번');

select * from kboard where num =3;

insert into kboard(num, title)
values (kboard_num.nextval,'4번');

select * from kboard;

-------------------------------------
--시퀀스
-- Oracle 있음
-- MS-SQL 2012버전부터 있음
-- mysql 없음(전체 공유가 아니라 테이블에 붙는건 있다)
-- mariaDB 있음
-- PostgreSQL 있음
-------------------------------------
/*
순번을 생성(테이블에 종속되어서)
MS-SQL
    create table board(boardnum int indentiy(1,1) ...)
    insert into board(title) values('제목');

MY-SQL 
    create table board(boardnum int auto_increment, title);
     insert into board(title) values('제목');
*/

-----------------------------------------
/*
시퀀스 객체 옵션
*/
------------------------------------------
-- 시작값 10 부터 시작, 2씩 증가
create sequence seq_num
start with 10
increment by 2;

--채번
select seq_num.nextval from dual;

-------------------------------------------

/*
가장 나중에 쓴글(최신글) 순으로 보고 싶음
select * from board order by num desc;
*/


--------------------------------------------
--rownum
-- 1. 의사 컬럼 : 실제 물리적으로 존재하는 컬럼은 아니다.
-- 논리적으로 존재함
-- create table 할 때 생성 되지 않는 컬럼을 의사컬럼이라고 함
-- rownum : 실제 테이블에 컬럼으로 존재하진 않지만
-- 내부적으로 행번호를 부여하는 컬럼
select * from emp;

select rownum, empno, ename
from emp;
--select한 결과에 순번을 부여함

select rownum, empno, ename, sal
from emp
order by sal;

--from, select, order by
-- rownum은 select한 결과에 붙임
-- 근데 그 후에 order by를 하면...

-------------------------------

--통계데이터를 만듬
--월별 매출액, 차트, 등
/*
 기준데이터가 있어야함 -> 그걸로 순번처리

*/

-- 먼저 인라인뷰로 정렬해놓고 순번붙이기
select rownum, e.* 
from (
    select empno, ename, sal
    from emp
    order by sal --기준을 정함
) e;

-------------------------------------

--업무
-- 상위 순번 3명 뽑겠다
-- 중복 순위는 일단 나중 문제
-- Top-n쿼리(기준이 되는 데이터 생성, (정렬)... 상위 n개만 가져오기)
/*
MS-SQL
select top 10, * from emp order by sal asc; 
*/

-- 오라클은 rownum 등(rank 분석함수(윈도우함수)) 사용
--1. 인라인 뷰로 먼저 정렬
--2. rownum 값으로 조건을 검

-- 급여를 많이 받는 순으로 정렬된 데이터 만들기
select empno, ename, sal 
from emp
order by sal desc;

-- 정렬시킨 데이터로 몇번까지로 뽑기
-- 급여 상위 5명
-- 대용량 데이터 조회(페이징 처리)
select *
from (
select rownum as num, e.empno, e.ename, e.sal
from (  select empno, ename, sal 
        from emp
        order by sal desc) e
    ) n where num <= 5;

-- between A and b 써도 된다고

-- 게시판 10만건
-- 건수로 묶어서 가져옴
/*
게시판 102건
totaldata = 102건
pagesize = 10(한 화면에 보여지는 데이터(row)를 10개씩)

pagecount가 나옴(나머지가 있으면 그것도 페이지로 처리해야됨 +1)
11개
[1][2][3][4][5][6][7][8][9][10][11]
<a href="list.do?page=1"></a>
1번 페이지 1~10
num between 1 and 10
2번 페이지 11~20
num between 11 and 20
[이전][1][2][3][4][5][다음]
[이전][6][7][8][9][10][다음]
[이전][11]
*/

-------------------------------------------------
--hr계정 접속
select user from dual; --HR
select * from employees; -- 107건

/*
total 데이터 건수 107건
pagesize 10개씩
page 개수 
[1][2][3][4][5][6][7][8][9][10][11]

1번 클릭 1~10 게시글 가져오기
11번 클릭 나머지
*/

--TOP_N쿼리(옛날 방식)
--1단계(데이터 정렬의 기준) : 사번
select * from employees
order by employee_id;

--2단계 - 기준데이터에 순번 부여하기
select rownum as num, e.*
from (select * from employees
order by employee_id) e
where rownum <= 50; 
--걸러진거에 대한 rownum을 따로 붙인거라고 함(select한 rownum과 다르다고)
-- 분석 순서 from, where, select

-- 3단계
select *
from (
select rownum as num, e.*
from (select * from employees
order by employee_id) e
where rownum <= 50
) n where num >= 41;

-----------------
--1번 페이지 클릭
select *
from (
select rownum as num, e.*
from (select * from employees
order by employee_id) e
where rownum <= 10
) n where num >= 1;
-- rownum <= ?, where num >= ?에서
-- ? 들어갈 값(비교값)은 자바코드에서 논리를 생성해서 집어 넣는다

-------------------------------------------------
select *
from (
    select row_number() over (order by employee_id) as num, e.*
    from employees e
) n
where n.num between 1 and 10;

--오라클 12c버전 이상(이게 편하다)
select *
from employees 
order by employee_id
offset 0 rows fetch next 10 rows only;
/*
offset : 시작 위치 지정(0부터 시작)
fetch next : 가져올 개수
예) offset 10 rows fetch next 10 rows only; -- 11번째부터 20번째까지
*/

-------------------------------------------------
-- VIEW 가상 테이블 
-- 오라클.pdf 185
-- 가상 테이블, 물리적인 테이블을 골라서 볼 수 있는 가상 테이블
-- 물리적 테이블을 볼 수 있는 쿼리문을 가지고 있는 객체
-- 사용 방법은 테이블 처럼
/*
CREATE  [OR  REPLACE]  [FORCE | NOFORCE]  VIEW view_name [(alias[,alias,...])] 
AS Subquery  
[WITH  CHECK  OPTION  [CONSTRAINT  constraint ]] 
[WITH  READ  ONLY] 

OR  REPLACE : 이미 존재한다면 다시 생성한다
FORCE : Base Table 유무에 관계없이 VIEW을 만든다.
NOFORCE : 기본 테이블이 존재할 경우에만 VIEW를 생성한다.
view_name : VIEW 의 이름
Alias : Subquery 를 통해 선택된 값에 대한 Column명이 된다. 
Subquery : SELECT 문장을 기술한다. 
WITH CHECK OPTION  : VIEW 에 의해 액세스 될 수 있는 행만이 입력,갱신될 수 있다.  
Constraint : CHECK OPTON 제약 조건에 대해 지정된 이름이다.
WITH READ ONLY : 이VIEW 에서 DML이 수행될 수 없게 한다.
*/

-- 사용 목적 : 1.보안
--  신입 사원이 입사하면 특정 컬럼만 볼 수 있게 view제공
-- 2. 편리성 : in line view를 등록하는거랑 비슷
--  인라인뷰 대신에 뷰 객체를 만들어서 영속적으로 등록해서 사용 가능
--단, 뷰가 볼 수 있는 데이터에 한해서
-------------------------------------------------------
--kosa로 변경
create view view001
as
    select empno, ename, sal
    from emp;
-- 오류 : 권한 없음
-- system 권한에서 뷰 만드는 권한 부여함

select * from view001;
--뷰가 가지고 있는 select문(쿼리문)이 실행됨
--------------------------------------------------------

create view dept_date
    as select deptno, trunc(avg(sal),0) as avg_sal
        from emp 
        group by deptno;
        
select * from dept_date;
-- 많이 쓰는 쿼리문이 있다면 뷰를 만들어 둔다.
select e.empno, e.ename, e.deptno, e.sal, d.avg_sal
from emp e join dept_date d
on e.deptno = d.deptno
where e.sal > d.avg_sal;

-----------------------------------------------------
--view 쿼리 문장을 가지고 있는 객체
select * from view001 where sal > 1000;

select comm from view001; -- comm이 없음
-- ORA-00904: "COMM": invalid identifier
-- view가 볼 수 있는 데이터만 처리 가능

-----------------------------------------------------

create or replace view v_001
as 
    select empno, ename, job
    from emp;

select * from v_001
where empno = 7788;

-- 조인
-- 부서 이름
-- 편리성

create or replace view view_002
as
    select e.empno, e.ename, e.deptno, d.dname 
    from emp e join dept d
    on e.deptno = d.deptno;
    
select * from view_002;

-- view는 sql 문장 덩어리
-- 테이블처럼 사용 가능

--in line view를 사용하는 것 보다 
-- 자주 사용되는건 view 객체로 만들어서 사용하는 것이 편하다

-- 활용은 복잡한 쿼리에 인라인 뷰처럼..쓸때 사용함

--직종별 평균 급여를 볼 수 있는 뷰를 만드시오
-- view_003
create or replace view view_003
as
 select job, trunc(avg(sal))
 from emp
 group by job;
-- 안만들어짐..
--trunc(avg(sal)) 이거에 컬럼 이름 달라고
-- 조작되는 컬럼에는 별명있어야 함
-- 해결
create or replace view view_003
as
 select job, trunc(avg(sal)) as avg_sal
 from emp
 group by job;

select * from view_003;

--view를 통해서 DML 작업이 가능함(insert, update, delete)
-- 하지만, 되도록이면 view는 조회(select)를 목적으로 써라..
select * from copy_emp;

create or replace view v_emp
as
    select empno, ename, job, sal
    from copy_emp;
--뷰를 통한 DML작업

update v_emp
set sal = 0;
select * from v_emp;
-- 실제 copy_emp테이블의 데이터가 변경됨

-- 뷰 변경
create or replace view v_emp
as
    select empno, ename, sal
    from copy_emp;
    
update v_emp
set job = 'IT';
-- SQL 오류: ORA-00904: "JOB": invalid identifier
-- view에 job이 없어서 update불가
-- view를 통해 볼수있는 데이터만 DML이 가능
-- 단 권장하지 않음.. 조회(select)목적으로 쓰자
commit;
-- 보통 DB작업으로 뷰를 만듬(어플리케이션 코드에서는 X)
-------------------------------------------

create or replace view view101
as
    select job "직종", ename "사원이름", sal "월급"
    from emp
    where deptno = 30 and sal > 300;
    
select * from view101;

--view 끝
-------------------------------------------

--분석 함수
-- 주로, 통계 데이터 만들 때 사용함

-- PIVOT 함수
-- 집계 행 데이터를 열 데이터로 바꾸고
-- 열 데이터를 행데이터로 바꾸는 방법
--11g부터는 pivot 기능 생김
-- 행데이터를 열데이터로 전환
/*
deptno, cnt
10      3
20      5
30      6

차트화 분석용으로 만들기

deptno_10   deptno_20   deptno_30
    3           5           6
이렇게 바꾸면 데이터 처리가 용이(차트)
*/

select deptno, count(*) as cnt
from emp
group by deptno
order by deptno;

--case문 활용
-- 행 데이터를 열 데이터로 전환
select deptno, (case when deptno = 10 then 1 else 0 end) dept_10
    ,(case when deptno = 20 then 1 else 0 end) dept_20
    ,(case when deptno = 30 then 1 else 0 end) dept_30
from emp
order by deptno;

-- case문 1개가 컬럼 1개

---------------------------------------------------------------

select deptno, sum(case when deptno = 10 then 1 else 0 end) dept_10
    , sum(case when deptno = 20 then 1 else 0 end) dept_20
    , sum(case when deptno = 30 then 1 else 0 end) dept_30
from emp
group by deptno
order by deptno;

--deptno 컬럼은 의미가 없다..
-- 컬럼 이름에 집중.. 의미를 부여..
-- 어떻게?
select sum(case when deptno = 10 then 1 else 0 end) dept_10
     , sum(case when deptno = 20 then 1 else 0 end) dept_20
     , sum(case when deptno = 30 then 1 else 0 end) dept_30
from emp
order by deptno;

----------------------------------------------------------
--통계 집계 데이터 만들기
select deptno, count(*) as ecount
from emp
group by deptno;

-- max()로 null을 버림
select max(case when deptno = 10 then ecount else null end) dept_10,
       max(case when deptno = 20 then ecount else null end) dept_20,
       max(case when deptno = 30 then ecount else null end) dept_30
from (
    select deptno, count(*) as ecount
    from emp
    group by deptno
) x;

-- 이렇게 뽑아도 되고, 저렇게 뽑아도 되고,
--------------------------------------------------------------

-- pivot
/*
select * from 피벗 대상 쿼리문
pivot (그룹함수(집계컬럼)) for 피벗컬럼 in(피벗컬럼값) as 별칭
*/

-- 직종별, 월별 입사 건수를 원함
/*
직종      1월      2월      3월      ...
IT        0       1        2
MANAGER   1       2        5 

row데이터를 컬럼 데이터로 바꿈
차트(그래프)를 그릴 수 있음
분석 데이터
*/

select job, to_char(hiredate, 'FMMM') || '월' as hire_month
from emp;

select *
from (
    select job, to_char(hiredate, 'FMMM') || '월' as hire_month
    from emp -- 피벗할 원본 데이터를 만듬
) 
pivot (
-- 집계 함수(집계할 대상 컬럼)
    count(*) for hire_month in ('1월', '2월', '3월', '4월', '5월',
    '6월','7월','8월','9월','10월','11월','12월') --hire_month에 나오는 데이터를 넣어야..
);






























