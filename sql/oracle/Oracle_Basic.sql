show user;
--USER이(가) "KOSA"입니다.
/*
RDBMS (Relational Database Management System) 정의
관계형 데이터베이스 관리 시스템(RDBMS, Relational Database Management System)은 
데이터를 테이블(Table) 형식으로 관리하는 데이터베이스 시스템입니다.

1. RDBMS 특징
테이블 기반 데이터 저장: 데이터를 행(Row)과 열(Column)로 구성된 테이블 형태로 저장

관계(Relation) 형성: 테이블 간 키(Key) 를 이용하여 관계를 설정

SQL (Structured Query Language) 사용: 데이터를 조작하고 조회하는 표준 언어 제공 : CRUD (개발자)
>> DDL (데이터 정의어) : create , alter , drop 
>> DML (데이터 조작어) : insert , update , delete , select (개발자)
>> DCL (데이터 제어어) : grant , revoke  (DBA)
>> TCL (트랜잭션) ..... (개발자)

데이터 [무결성] 유지: 제약 조건(Constraints) 을 통해 데이터의 정확성 보장
>> PK , FK , UK , Check  >> Default, null

트랜잭션 지원: ACID (원자성, 일관성, 고립성, 지속성) 원칙 준수

2. RDBMS 주요 개념
테이블(Table): 데이터를 저장하는 기본 단위 (엑셀의 시트와 유사)
레코드(Record) / 행(Row): 테이블의 한 줄 (한 개의 데이터 항목)
속성(Attribute) / 열(Column): 데이터의 속성을 나타내는 필드
기본 키(Primary Key, PK): 테이블에서 각 행을 유일하게 식별하는 키
외래 키(Foreign Key, FK): 다른 테이블의 기본 키를 참조하여 관계 설정

3. RDBMS의 대표적인 시스템
-MySQL: 오픈 소스 RDBMS, 웹 애플리케이션에서 널리 사용됨
-PostgreSQL: 강력한 기능을 제공하는 오픈 소스 RDBMS(스프링 AI할때 쓴다고함)
-Oracle Database: 기업 환경에서 많이 사용되는 고성능 RDBMS
-Microsoft SQL Server: 마이크로소프트에서 개발한 RDBMS
-MariaDB: MySQL의 포크로 높은 성능과 안정성을 제공
ETC : DB2 , SYSBASE , 티베로 ...


4. RDBMS의 장점
 데이터 정합성 보장: 키와 관계를 통해 데이터의 일관성 유지
 중복 최소화: [정규화]를 통해 데이터 중복을 방지  >>     반정규화(역정규화)
 강력한 쿼리 기능: SQL을 사용하여 복잡한 데이터 검색 가능
 데이터 보안: 사용자 권한 관리 및 접근 제어 가능

5. RDBMS의 단점
 확장성 제한: 대량의 데이터를 처리하는 데 한계가 있음 (수직 확장 필요)
 복잡한 스키마: 변경이 어려워 유연성이 낮음
 고비용: 일부 상용 RDBMS는 라이선스 비용이 높음
 
 객체 형태의 데이터 관리가 안되요 ( ORDB ) >> NO SQL 
*/


/*
1. 오라클 소프트웨어 다운로드
https://www.oracle.com/technetwork/database/enterprise-edition/downloads/index.html

2. Oracle Database 11g Release 2 Express Edition for Windows 64 (무료설치)
   현재 최신: Oracle Database 21c Express Edition  (계정 생성 관리 .. 클라우드 환경 지원)
   
3. Oracle 설치(SYS, SYSTEM 계정의 대한 암호 : 1004)

4.Sqlplus 프로그램 제공(CMD) : GUI 환경 일반개발자 사용 불편

5.별도의 Tool 설치 무료(SqlDeveloper , https://dbeaver.io/)  ,
                  유료(토드 , 오렌지 , SqlGate) 프로젝트시 설치 활용 ^^

6. SqlDeveloper 툴을 통해서 Oracle Server 접속 ....
   >> HR 계정 : 암호 1004 , Unlock 2가지 사용가능 .... (사원관리 실습 테이블)
   >> 새로운 계정 : KOSA , 1004 

-- USER SQL
ALTER USER "HR" IDENTIFIED BY 1004 
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP"
ACCOUNT UNLOCK ;

-- QUOTAS
ALTER USER "HR" QUOTA UNLIMITED ON USERS;

-- ROLES
ALTER USER "HR" DEFAULT ROLE "RESOURCE","CONNECT";

-- SYSTEM PRIVILEGES


7. 현재 접속 계정 확인 : show user;   >> USER이(가) "KOSA"입니다.


-- USER SQL
CREATE USER "KOSA" IDENTIFIED BY "1004"  
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

-- QUOTAS

-- ROLES
GRANT "CONNECT" TO "KOSA" WITH ADMIN OPTION;
GRANT "RESOURCE" TO "KOSA" WITH ADMIN OPTION;
ALTER USER "KOSA" DEFAULT ROLE "CONNECT","RESOURCE";

-- SYSTEM PRIVILEGES
*/

/*
실습코드
CREATE TABLE EMP
(EMPNO number not null,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR number ,
HIREDATE date,
SAL number ,
COMM number ,
DEPTNO number );
--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,200,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,'1981-04-02',2975,30,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,300,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,'1981-04-01',2850,null,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,'1981-06-01',2450,null,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,'1982-10-09',3000,null,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',null,'1981-11-17',5000,3500,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,'1983-01-12',1100,null,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,'1981-10-03',950,null,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,'1981-10-3',3000,null,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);

COMMIT;

CREATE TABLE DEPT
(DEPTNO number,
DNAME VARCHAR2(14),
LOC VARCHAR2(13) );

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

COMMIT;



CREATE TABLE SALGRADE
( GRADE number,
LOSAL number,
HISAL number );

INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);
COMMIT;

*/
--DB잘하는 법  : 테이블 분석 + 컬럼 내용알기
select * from emp;
select * from dept;
select * from salgrade;

---

-- 사원 테이블의 모든 데이터를 가져오기
select * from emp;

-- 특정 컬럼의 데이터만 출력하기
select empno, ename, sal
from emp;

desc emp; -- 약식 테이블 정보 확인(컬럼명, 타입확인 가능)

select ename from emp;

-- 별칭 aslias
select empno 사번 , ename 이름
from emp;

-- 공백 별칭은 ""로 묶어야 한다
select empno "사 번" , ename "이 름"
from emp;

-- 표준 문법(AN-SI) 
select empno as "사 번", ename as "이 름"
from emp;

-- 오라클은 문자열 데이터에 대해서 엄격하게
-- 대소문자를 구별한다.
/*
자바는 문자('')와 문자열("")로 나누어짐
오라클은 문자와 문자열의 구분이 없다
전부 ''안에 표현함

오라클 : 'A' 와 'a'는 다르게 인식(대소문자 구분)
문자열 데이터에 대해서 대소문자를 구분
*/

-- 초급자 실수 예
select *
from emp
where ename = 'king';
-- 결과 나오지 않음 : 이유? KING 데이터가 대문자여서

select *
from emp
where ename = 'KING';
-- 분석 순서 : from -> where -> select

-- 오라클 쿼리(질의어) 언어
-- 자바처럼 연산자(산술, 논리, 관계)를 가지고 있음

-- 오라클
-- 오라클의 결합 연산자 : ||
-- 산술 연산자 : +
-- 자바는 +로 결합, 연산
-- MS-SQL : +로 산술, 결합 (자바와 같음)

select '사원의 이름은 ' || ename || ' 입니다' as "사원 정보"
from emp;

/*
JAVA : class emp {private int empno; private String name;}
Oracle : create table emp(empno number, ename varchar2(20));

varchar2(20) : 가변길이, 캐릭터 셋에 따라 다름, 20바이트
*/

select empno || ename -- empno는 number타입
--ename은 varchar2(문자) -> 자동(암시적) 형변환 됨
from emp;

desc emp;

select empno + 10000 from emp;
-- 10000씩 더한 값이 나옴

select empno + ename from emp;
-- 오류 발생 : ORA-01722: invalid number

-- 우리 회사에 직종이 몇 개
select job from emp;
-- 이렇게 하면 불려감
-- 중복 제거하고 보여주기 
-- 키워드 : distinct
select distinct job from emp;
-- 내부적 수행 원리 : 그룹으로 묶음(그룹핑으로 처리함)
-- 묶어서 뽑아냄

select distinct job, deptno --그룹의 그룹
from emp
order by job;

-- job으로 묶고, deptno로 다시 묶음

-- 오라클 SQL 언어
-- 자바는 + - * / % 연산 
-- 오라클은 %를 나머지 연산자로 사용하지 않는다.
-- %를 누가 사용하고 있음(문자열 검색의 패턴(like)으로 사용함)
-- mod() : 나머지 구하는 함수
-- mod()함수를 사용한다.

-- 문자열 검색(%) : where ename like '%김%'
-- 이름에 김이 앞뒤로 들어가있는걸 찾음

-- DML을 잘하는 방법 :
-- 테이블 구조 파악, 컬럼 구조 파악, 문제를 많이 만들어본다
-- 질의를 통해서, select모양이 보이면 된다고 함

-- 사원테이블에서 사원의 급여를 100달라 인상한 사원의 결과를 출력
select empno, ename, sal , sal + 100 "급여 인상분" 
from emp;

--오라클은 print기능이 없다
-- 자바는 System.out.println();
-- 그래서 임시, 가상의 테이블을 만들어서 데이터를 처리함
-- dual;
-- 가상의 더미테이블

select 100 + 100
from dual; -- 가상의 테이블 안에 넣고 출력해줌

select 100 || 100 from dual;
-- 100100

select '100' + 100 
from dual; -- 200(암시적 형변환)
-- 숫자형 문자 : (문자)껍질을 벗기면 숫자

select '100A' + 100 from dual;
-- 안됨 : ORA-01722: invalid number

-- 비교 연산자
-- < > <=
-- 자바에서는 같다 ==, = 할당
-- 오라클은 = 같다, != 같지 않다
-- 자바 스크립트 ==, ===

-- 논리 연산 and, or , not
select empno, ename, sal
from emp
where sal >= 2000;
-- emp 테이블에서 급여가 2000이상인 사원의 사번,이름,급여를 출력

--사번이 7788번인 사원의 사번, 이름, 직종, 입사일 출력
select empno, ename, job, hiredate
from emp
where empno = 7788;
-- TIP : 먼저 * 로 뽑은 다음 뽑을 컬럼을 추린다

-- 날짜를 한국형식으로 바꿈
-- 현재 접속한 사용자 환경 바꿈
alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';
-- 데이터 베이스의 실제 데이터를 바꾼것은 아니다(현재 접속한 세션의 날짜 형식을 바꾼것)
-- sqlplus로 select하면 세션이 달라서 다른 형식으로 출력됨
-- 서버입장에서는 세션이 다르면 다른 사용자로 봄
-- 귀찮으니까 도구 - 환경설정 - 데이터베이스 - NLS - 날짜 형식 YYYY-MM-DD HH24:MI:SS 해둠
-- 이것도 실제 데이터 변경은 아님(디벨로퍼 껏다 켜도 YYYY-MM-DD HH24:MI:SS로 나오게 한 것)
-- 세션이 다르면 또 달라짐
select * from emp;

-- 오라클은 복습하지 않는다.
-- 수업시간에 끝난다.
-- 6시 이후에는 웹공부, 다른 공부하기

-- 급여가 2000이상이면서 직종이 manager인 사원의 모든정보를 출력하세요
select *
from emp
where sal >= 2000 and job = 'MANAGER';-- 소문자로 하면 안나옴

-- 급여가 2000이상이거나 직종이 manager인 사원의 모든정보를 출력하세요
select *
from emp
where sal >= 2000 or job = 'MANAGER';

-- 급여가 2000 초과이면서 manager인 사원의 모든정보를 출력하세요
select *
from emp
where sal > 2000 and job = 'MANAGER';

select sysdate from dual;
select * from nls_session_parameters;
-- DBA허락이 있다면 날짜 포맷 확인 변경 가능
/*
이정도 볼 수 있으면 좋다
NLS_LANGUAGE	KOREAN
NLS_DATE_LANGUAGE	KOREAN
NLS_DATE_FORMAT	YYYY-MM-DD HH24:MI:SS
*/

select hiredate from emp;
-- 날짜 데이터 검색은 문자열 검색과 동일함
-- '날짜'
-- 유연(날짜 형식)
select *
from emp where hiredate = '1980-12-17';
select *
from emp where hiredate = '1980/12/17';
select *
from emp where hiredate = '1980.12.17';
select *
from emp where hiredate = '19801217';

select *
from emp where hiredate = '80-12-17';
-- 안나옴
-- 검색 RR-MM-DD 날짜 포맷이 되어야 검색됨
-- 지금은 YYYY-MM-DD로 맞췄기 때문

--사원의 급여가 2000달러 이상이면서 4000이하인 사원의 모든 정보를 출력
select *
from emp
where sal >= 2000 and sal <= 4000;

--사원의 급여가 2000달러 초과이면서 4000미만인 사원의 모든 정보를 출력
select *
from emp
where sal > 2000 and sal < 4000;
-- DB는 데이터 검증이 필수!!!
-- 데이터가 나온다고 해서 다 맞는것은 아니라..

-- 부서 번호가 10번 또는 20번 또는 30번인 
-- 사원의 사번, 이름, 급여, 부서번호출력하기
select empno, ename, sal, deptno
from emp
where deptno in (10,20,30);
-- in연산자 (외우기)

-- 동적쿼리로 만들수있다(mybatis)
-- 다이나믹쿼리

--사원의 급여가 2000달러 이상이면서 4000이하인 사원의 모든 정보를 출력
select *
from emp
where sal >= 2000 and sal <= 4000;

-- 이것도 줄일 수 있음
select *
from emp
where sal between 2000 and 4000;
-- 이건 무조건 = 을 포함한다(A이상, B이하)
-- betwenn A and B

-- 부서 번호가 10번 또는 20번이 아닌 사원 출력하기
select empno, ename, sal, deptno
from emp
where deptno not in (10,20);
-- not in

-- 입사 시험 문제. 이걸 풀어서 풀어라
-- not in을 풀면 != and 사용

-- Today Point
-- null : 값을 모른다(알 수 없는 값)
-- 비교 : is , is not로 비교함
-- nvl(값, 대체값), nvl2(값, null아니면대체값, null이면대체값)
-- mysql에서는 ifnull()

--테이블 만들기
create table member(
    userid varchar2(20) not null,
    name   varchar2(20) not null,
    hobby  varchar2(50) -- 기본 null허용
);

desc member;
--암기 하지 않으면 욕먹는다고..
insert into member(userid, name, hobby)
values('hong', '길동', '도둑..');
select * from member;
/*
DB에 DML(insert, update, delete)
기본 트랜젝션 동반.
commit; rollback;
*/
-- 실제로 반영할거면 DML은 commit;
commit;

--트랜젝션의 정의 : 여러개의 작업들을 하나의 논리적인 작업단위로 묶는것
-- 가장 좋은 예) 은행 업무 계좌 인출
-- A계좌를 인출해서 B계좌로 송금
-- A계좌 update (금액빼감)
-- B계좌 update (금액 추가)
-- 돈을 인출, 이체 2개의 작업을 1개의 작업으로 묶음
-- 둘 다 성공해야 commit;(실 반영)
-- 한 개라도 실패하면 rollback;(취소하고 되돌림)

--오라클은 default로 insert, update, delete 작업 트랜잭션 강제 수함
-- 완료 commit, rollback 강제
-- 트랜잭션 작업에 완료(commit) 또는 취소(rollback)하지 않으면 rock(락)이 걸림
-- 그래서 트랜잭션을 길게 잡지 말아야.. 짧게 해야된다고,, 성능 튜닝..
-- 커밋된 데이터만 읽을거냐, 커밋안된 데이터를 읽을거냐..
-- 고스트 데이터라는 용어가 있다고
-- 고립화..

-- 주의) DB마다 다르다
-- MS-SQL은 무조건 실반영(트랜젝션 걸지 않음)
-- (트랜젝션 걸고 싶으면 명시적으로)begin tran 구문을 실행해야 된다 
-- MS-SQL은 기본값이 자동 auto-commit

-- 수당(comm) 받지 않는 모든 사원의 정보 출력하기
select *
from emp
where comm is null;

-- 수당 받는 사람을 찾으세요
select * from emp where comm is not null and comm != 0;

-- 사원 테이블에서 사번, 이름, 급여, 수당, 총 급여(급여  + 수당)
select empno, ename, sal, comm, sal + nvl(comm, 0) "총 급여"
from emp;

-- null과의 모든 연산 결과는 null
-- null값을 처리하기 위한 함수 : nvl(), nvl2()
-- nvl(컬럼명,대체값) nvl2(컬럼명,null이 아닐떄 대체값, null일때 대체값)

--샘플
select 1000 + null from dual; -- null
select 1000 + nvl(null,0) from dual; -- 1000
select nvl(null,'hello world') from dual;

-- 종합 문제
-- 사원의 급여가 1000이상이고 수당을 받지 않는
-- 사원의 사번, 이름, 직종, 급여, 수당, 총급여(급여 + 수당) 출력
select empno, ename, job, sal, comm, sal + nvl(comm, 0) "총급여"
from emp
where sal >= 1000 and comm is null;

-- 문자열 검색
-- 패턴 검색 like 문자열 패턴 검색
-- 와일드 카드와 같이 사용
-- % : 모든 것
-- _ : 한 문자
-- 부족하면 정규표현식
select *
from emp
where ename like '%A%'; -- 모든 이름에 A가 포함되면 다 찾아라(A로 시작하는것도 찾음)

select *
from emp
where ename like 'A%'; --A로 시작하는

select *
from emp
where ename like '%E'; --E로 끝나는

select * 
from emp
where ename like '%LL%'; -- LL로 붙어있는걸 포함하는

select *
from emp
where ename like '%A%A%'; -- 문자데이터에 A가 2개있는 데이터를 찾음

select *
from emp
where ename like '_A%'; -- 2번째에 위치한 글자가 A인 문자데이터를 찾음

-- 정규 표현식 : regexp_like()
select * from emp where regexp_like(ename, '^[A-C]');
-- 이름이 A~C로 시작하는 직원 검색

-- 정규 표현식 사례 5개를 만들어 올리기
-- 실행 캡쳐 올리기
/*
문법
SELECT *
FROM 테이블명
WHERE REGEXP_LIKE(컬럼명, '정규표현식');
*/

-- 데이터 정렬하기
--order by
-- DB입장에서 가장 성능이 떨어지는 작업
-- 정렬
-- CPU를 가장 많이 먹는다.
-- 문자열 정렬, 숫자 정렬, 날짜 정렬 등...
-- 오름차순(ASC, 기본값), 내림차순(DESC)
-- 정렬은 서버 입장에서 cost 비용 많이 든다

select * from emp order by sal;
-- 급여 낮은 순으로 정렬
select * from emp order by sal desc;

--입사일이 가장 늦은 순으로 정렬해서 출력하되
-- 사번, 급여, 입사일 출력
select empno, sal, hiredate
from emp
order by hiredate desc;

/*
select절 3
from절 1
where절 2
order by절 4(select 한 결과를 정렬)
*/

select empno, ename, sal, job, hiredate
from emp
where job = 'MANAGER'
order by hiredate desc;
-- 쿼리 해석을 분석 순서로 이해라기
-- emp테이블에서 업무가 MANAGER인 사원의 사번, 이름, 급여, 업무, 입사일을
-- 입사일 내림차순으로 출력해라

select job, deptno
from emp
order by job asc, deptno desc;
-- 의미 업무순으로 묶어서 오름차순하고 그 안에서 부서번호로 묶어서 내림차순
-- 그룹안의 그룹 정렬

--연산자
--합집합(union) : 테이블과 테이블의 데이터를 합치는 것(중복 배제)
--합집합(union all) : 중복 허용
-- 조인은 옆으로 붙임
-- union은 밑으로 붙음
/*
create table uta(name varchar2(20));
insert into uta(name) values('AAA');
insert into uta(name) values('BBB');
insert into uta(name) values('CCC');
insert into uta(name) values('DDD');
commit

create table ut(name varchar2(20));
insert into ut(name) values('AAA');
insert into ut(name) values('BBB');
insert into ut(name) values('CCC');
commit;
*/
select * from uta;
select * from ut;

-- 중복 제거 합집합 결과 나옴
select * from ut
union
select * from uta;
/*
AAA
BBB
CCC
DDD
*/

select * from ut
union ALL
select * from uta; --밑으로 붙는다
/*
AAA
BBB
CCC
AAA
BBB
CCC
DDD
AAA
BBB
CCC
DDD
*/

-- union 조건(2가지)
-- 1. 대응 되는 컬럼의 (데이터)타입이 동일해야한다
select empno, ename from emp
union
select dname, deptno from dept;
-- Use the TO_NUMBER, TO_CHAR, and TO_DATE
-- 데이터 타입이 맞지 않음
-- ORA-01790: expression must have same datatype as corresponding expression
select empno, ename from emp
union
select deptno, dname from dept;

--정렬하고 싶으면 subquery(가상테이블) 사용해서
select *
from ( --인라인 뷰(from절에 들어가는 서브쿼리)
select empno, ename from emp
union
select deptno, dname from dept
) m
order by m.empno desc; 

-- 2. 대응 되는 컬럼의 개수가 동일해야 함
select empno, ename, job, sal from emp
union 
select deptno, dname, loc from dept;
-- ORA-01789: query block has incorrect number of result columns
-- 컬럼 개수 에러
-- 이럴 때 어떻게 사용할까?
-- 보통은 null사용(또는 들어갈 다른 데이터로 대체)
select empno, ename, job, sal from emp
union 
select deptno, dname, loc, null from dept;

select empno, ename, job, sal from emp
union 
select deptno, dname, loc, 10 from dept;
-- 10으로 채움
-------------------------------------------------
-- 여기까지가 초급개발자가 의무적으로 
-- 단일 테이블 대상으로 쿼리문장을 쓸 수 있는 정도
-------------------------------------------------

create table M (M1 char(6) , M2 char(10));
create table S (S1 char(6) , S2 char(10));
create table X (X1 char(6) , X2 char(10));

insert into M values('A','1');
insert into M values('B','1');
insert into M values('C','3');
insert into M values(null,'3');
commit;

insert into S values('A','X');
insert into S values('B','Y');
insert into S values(null,'Z');
commit;

insert into X values('A','DATA');
commit;

-- 과제
-- 1. XSS(크로스사이트 스크립팅, Cross-Site Scripting) 공격 방지
-- 댓글에서 <script> 태그 탐지

WITH comments AS (
    SELECT '안녕하세요~ 좋은 하루 되세요' AS content FROM dual
    UNION ALL
    SELECT '<script>alert("해킹")</script>' FROM dual
    UNION ALL
    SELECT '이 사이트 짱짱 👍' FROM dual
    UNION ALL
    SELECT '<SCRIPT>malicious code</SCRIPT>' FROM dual
)
SELECT *
FROM comments
WHERE REGEXP_LIKE(content, '<script.*?>', 'i');  
-- i는 대소문자구분안함 옵션

--2. SQL Injection 패턴 탐지
WITH inputs AS (
    SELECT '정상적인 검색어' AS content FROM dual
    UNION ALL
    SELECT '1 OR 1=1' FROM dual
    UNION ALL
    SELECT 'DROP TABLE users;' FROM dual
    UNION ALL
    SELECT 'Union SELECT * FROM accounts' FROM dual
    UNION ALL
    SELECT 'hello world' FROM dual
)
SELECT *
FROM inputs
WHERE REGEXP_LIKE(content, '(DROP|UNION|SELECT)', 'i');  -- 대소문자 무시(i)



/*
1.2.2 단일 행 함수의 종류
1) 문자형 함수 : 문자를 입력 받고 문자와 숫자 값 모두를 RETURN 할 수 있다.
2) 숫자형 함수 : 숫자를 입력 받고 숫자를 RETURN 한다.
3) 날짜형 함수 : 날짜형에 대해 수행하고 숫자를 RETURN 하는 MONTHS_BETWEEN 함수를
제외하고 모두 날짜 데이터형의 값을 RETURN 한다.
4) 변환형 함수 : 어떤 데이터형의 값을 다른 데이터형으로 변환한다.
5) 일반적인 함수 : NVL, DECODE

*/

select initcap('the super man') from dual;
-- 각 단어의 첫 글자를 대문자로 나머지는 소문자
-- The Super Man

select lower('AAA'), upper('aaa') from dual;
select ename, lower(ename) as "ename" from emp;

select * from emp
where lower(ename) = 'king';

select length('abcd') from dual; -- 4
select concat('a','b') from dual; -- 문자열 합침
-- 파라미터 2개 밖에 못합침

select 'a' || 'b' || 'c' from daul;
-- 유연성은 ||가 좋다

select concat(ename, job) from emp;

-- 자바 : substring 부분 문자열
-- 오라클 : substr()
select substr('ABCDE',2,3) from dual;
-- BCD
-- 2번 위치부터 3개 가져와라

select substr('ABCDE',1,1) from dual; --A
select substr('ABCDE',3,1) from dual; --C
--오라클의 문자열 시작점은 0이 아님(1부터 시작)

select substr('sfjhkjashfkjh',3) from dual;
-- 3번째 위치부터 끝까지

-- 사원테이블에서 ename컬럼의 데이터에 대해서
-- 첫글자는 소문자로 나머지 글자는 대문자로 출력하되
-- 하나의 컬럼으로 만들어서 출력하고 컬럼의 별칭 fullname
-- 첫글자와 나머지 문자 사이에는 공백하나를 넣어서 출력

select lower(substr(ename,1,1)) || ' ' || upper(substr(ename,2)) "fullname"
from emp;

select lpad('ABC', 10, '*') -- 10칸을 쓸건데 왼쪽 빈공간은 *로 채워라
from dual;

select rpad('ABC', 10, '*')
from dual;
-- 활용 : 사용자 개인정보 마스킹에 사용함(보안)

-- 사용자 비번 hong1004 또는 k123
-- 화면에 출력하는데 앞의 2글자만 보여주고
-- 나머지는 특수문자 처리하기
select rpad(substr('hong1004', 1, 2), length('hong1004'), '*')
from dual;

--emp 테이블에 적용하면
select rpad(substr(ename, 1, 2), length(ename), '*')
from emp;

select rtrim('MILLER','ER') from dual;
-- 오른쪽에서 ER찾아서 버린다
select ltrim('MILllllllLER','MIL') from dual;
--오른쪽에서 MIL제거
select '>' || rtrim('MILLER      ',' ') || '<' from dual;
-- 양쪽공백제거

select ename, replace(ename, 'A', '와우') from emp;

--문자열 함수 end
-- 숫자 함수
--round() 반올림 함수
--trunc() 절삭 함수
-- mod()

-- -3 -2 -1 - 1 2 3
select round(12.345, 0) from dual;
-- 12 정수부분만(소수점 1째자리에서 반올림)

select round(12.545, 0) from dual;
-- 13 정수부분만(소수점 1째자리에서 반올림)

select round(12.345,1) from dual;
-- 12.3 소수점 1번째 자리까지(소수점 2번째에서 반올림)
select round(12.567,1) from dual;
-- 12.6

select round(12.345,-1) from dual;
-- 10
select round(15.567,-1) from dual;
-- 20

select round(12.567,-2) from dual;
-- 0

select trunc(12.345, 0) from dual;
-- 12 

select trunc(12.545, 0) from dual;
-- 12

select trunc(12.345,1) from dual;
-- 12.3
select trunc(12.567,1) from dual;
-- 12.5

select trunc(12.345,-1) from dual;
-- 10
select trunc(15.567,-1) from dual;
-- 10

select trunc(12.567,-2) from dual;
-- 0


--나머지 구하기
select 12/10 from dual;--1.2
select mod(12,10) from dual; --2

select mod(0,0) from dual;
-- 0

--------------------------------------------
--날짜 함수 : 날짜 연산 가능함
select sysdate from dual;
--POINT
--1. Date + Number -> Date
--2. Date - Number -> Date
--3. Date - Date -> Number(일수)

select sysdate + 100 from dual;
select sysdate + 1000 from dual;
select sysdate - 1000 from dual;

select hiredate from emp;

select months_between('2022-01-01', '2020-01-01')
from dual; -- 24
-- 개월의 차이

select months_between(sysdate, '2020-01-01')
from dual;
-- 68.31165733273596176821983273596176821983

select trunc(months_between(sysdate, '2020-01-01'), 0)
from dual;

--초급 개발자의 실수
select '2025-01-01' + 100 
from dual;

-- 날짜 타입 변환 함수를 사용해야함
select to_date('2025-01-01', 'yyyy-MM-dd') + 100 
from dual;
-- 2025-04-11 00:00:00
-- to_date('2025-01-01') + 100도 가능

--사원 테이블에서 사원들의 입사일에서 
-- 현재 날짜까지의 근속 월수를 구하세요
-- 사원이름, 입사일, 근속월수 출력
-- 근속 월수는 정수만 출력(반올림 X)
select ename, hiredate, trunc(months_between(sysdate, hiredate), 0) "근속월수"
from emp;

desc emp
-- hiredate 컬럼 데이터 타입이 date라서
-- to_date를 사용한 변환이 필요없다

----------------------------------------------------------
--문자 함수, 숫자 함수, 날짜 함수 기본 끝

-----------------------------------------------------------
-- 변환 함수
-- 오라클 데이터베이스 데이터 유형 : 숫자, 문자열, 날짜
-- to_char() : 문자열 변환함수
-- 숫자를 형식문자로 바꾸기 위해서 사용함(천단위 구분기호), 포맷팅
-- 100000 -> $100,000
-- to_char 날짜 -> 형식문자로 포맷팅하기 위해서 사용
-- '2025-01-01' -> 2025년 01월 01일

--to_date() : 문자열을 날짜로 변환
select to_date('2025-01-01', 'yyyy-MM-dd') + 100 from dual;

--to_number()
-- 안쓰는 이유 : 굳이 안써도 암시적 형변환이 되기 때문 
select '100' + 100 from dual;
-- 200(암시적 형변환)
-- select to_number('100') + 100 from dual;
-- 서버 프로세스가 암시적으로 to_number를 씌운다고 함

--format은 표를 보고 찾아서
-- 오라클 PDF 70 ~ 71
select sysdate, to_char(sysdate, 'YYYY') || '년' "YYYY",
to_char(sysdate, 'YEAR') "세기",
to_char(sysdate, 'MM') || '월' "MM",
to_char(sysdate, 'DD') || '일' "DD",
to_char(sysdate, 'DAY') "DAY" 
from emp;


-- 입사일이 12월인 사원의 사번, 이름, 입사일, 입사년도, 입사월을 출력하세요
select empno, ename, hiredate, to_char(hiredate,'MM') "입사년도"
from emp
where to_char(hiredate, 'MM') = '12';
--12(숫자) 보다 문자'12'비교가 낫다고
-- 12로 쓰면 암시적 형변환으로 '12'로 바꿔서 비교하기때문에

--여기까지 kosa 계정으로 했음

-------------------------------

--여기부터 hr로 접속함
show user;
--USER이(가) "HR"입니다.
select * from employees;

select employee_id, first_name, last_name, hire_date, salary
from employees;

/*
사원테이블(employees)에서 사원의 이름은 last_name , 
first_name 합쳐서 fullname 별칭 
부여해서 출력하고 입사일은  YYYY-MM-DD 형식으로 출력하고 연봉(급여 *12)을 구하고 
연봉의 10%(연봉 * 1.1)인상한 값을
출력하고 그 결과는 1000단위 콤마 처리해서 출력하세요
단 2005년 이후 입사자들만 출력하세요 그리고 연봉이 높은 순으로  출력하세요
*/

select last_name || ' ' || first_name "fullname",
to_char(hire_date, 'YYYY-MM-DD') "입사일",
(salary * 12) "연봉",
to_char((salary * 12) * 1.1, '$999,999,999') "연봉 인상" --to_char()천단위 포맷팅
from employees
where hire_date >= to_date('2005-01-01','YYYY-MM-DD')
order by 연봉 desc; -- alias 사용해서 정렬에 이용(컬럼 나열한 숫자로도 가능)
-- hire_date >= to_date('2005-01-01','YYYY-MM-DD')
-- to_char(hire_date,'YYYY') >= '2005'
/*
1. EMPLOYEES 테이블을 이용하여 다음 조건에 만족하는 행을 검색하세요. 
2005년이후에 입사한 사원 중에 부서번호가 있고, 
급여가 5000~10000 사이인 사원을 검색합니다. 
가) 테이블 : employees 
나) 검색 : employee_id, last_name, hire_date, j
ob_id, salary, department_id 
다) 조건
    ① 2005년 1월 1일 이후 입사한 사원
    ② 부서번호가 NULL이 아닌 사원 
    ③ 급여가 5,000보다 크거나 같고, 10,000 보다 작거나 같은 사원 
    ④ 위의 조건을 모두 만족하는 행을 검색 
라) 정렬: department_id 오름차순, salary 내림차순
*/
select employee_id, last_name, hire_date, job_id, salary, department_id 
from employees
where hire_date > '2005-01-01' --to_date('2005-01-01','YYYY-MM-DD') 
and DEPARTMENT_ID is not null and
salary between 5000 and 10000
order by department_id, salary desc; 

----------------------------------------------------
show user;
-- kosa 계정으로 옮김

----------------------------------------------------


