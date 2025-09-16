--20250915
create table dmlemp
as
    select * from emp;
    
--단점 : 제약조건은 복제가 안되서.. 따로 적용필요
alter table dmlemp
add constraint pk_dmlemp_empno primary key(empno);

select * from dmlemp;

		create table trans_A( -- pk 없음
    		num number,
    		name varchar2(20)
		);

		create table trans_B( -- pk
    		num number constraint pk_trans_B_num primary key,
    		name varchar2(20)
		);
        
select * from trans_A;
select * from trans_B;

select * from dept;

--20250916
select * from emp;

-- 분석 함수
--직종별 , 월별 입사 건수
/*
    1월  2월  3월 ,,,,,
IT   0    1
MA   2    0
*/

--pivot (컬럼 -> 행)

--기준 데이터
select job , to_char(hiredate,'FMMM') || '월' as hire_month 
from emp;

select *
from (
        select job , to_char(hiredate,'FMMM') || '월' as hire_month 
        from emp
      )
pivot (
        count(*) for hire_month IN('1월','2월','3월','4월','5월','6월','7월','8월','9월','11월','12월')
);      

--decode

  select job , to_char(hiredate,'FMMM') as hire_month ,hiredate
  from emp;


--데이터 만들기 1 - pivot없이 decode로 만듬
select job ,  decode(to_char(hiredate,'FMMM'),'1',1,0) "1월"
           ,  decode(to_char(hiredate,'FMMM'),'2',1,0) "2월"
           ,  decode(to_char(hiredate,'FMMM'),'3',1,0) "3월"
           ,  decode(to_char(hiredate,'FMMM'),'4',1,0) "4월"
           ,  decode(to_char(hiredate,'FMMM'),'5',1,0) "5월"
           ,  decode(to_char(hiredate,'FMMM'),'6',1,0) "6월"
           ,  decode(to_char(hiredate,'FMMM'),'7',1,0) "7월"
           ,  decode(to_char(hiredate,'FMMM'),'8',1,0) "8월"
           ,  decode(to_char(hiredate,'FMMM'),'9',1,0) "9월"
           ,  decode(to_char(hiredate,'FMMM'),'10',1,0) "10월"
           ,  decode(to_char(hiredate,'FMMM'),'11',1,0) "11월"
           ,  decode(to_char(hiredate,'FMMM'),'12',1,0) "12월"
from emp


--데이터 만들기 2
select job ,  sum(decode(to_char(hiredate,'FMMM'),'1',1,0)) "1월"
           ,  sum(decode(to_char(hiredate,'FMMM'),'2',1,0)) "2월"
           ,  sum(decode(to_char(hiredate,'FMMM'),'3',1,0)) "3월"
           ,  sum(decode(to_char(hiredate,'FMMM'),'4',1,0)) "4월"
           ,  sum(decode(to_char(hiredate,'FMMM'),'5',1,0)) "5월"
           ,  sum(decode(to_char(hiredate,'FMMM'),'6',1,0)) "6월"
           ,  sum(decode(to_char(hiredate,'FMMM'),'7',1,0)) "7월"
           ,  sum(decode(to_char(hiredate,'FMMM'),'8',1,0)) "8월"
           ,  sum(decode(to_char(hiredate,'FMMM'),'9',1,0)) "9월"
           ,  sum(decode(to_char(hiredate,'FMMM'),'10',1,0)) "10월"
           ,  sum(decode(to_char(hiredate,'FMMM'),'11',1,0)) "11월"
           ,  sum(decode(to_char(hiredate,'FMMM'),'12',1,0)) "12월"
from emp
group by job;

/*
문법

SELECT *
FROM (
    SELECT 열1, 열2, 값열
    FROM 테이블명
)
PIVOT (
    집계함수(값열)
    FOR 피벗할열 IN (열값1 AS 별칭1, 열값2 AS 별칭2, ...)
);

집계함수(값열)	SUM, AVG, COUNT, MAX, MIN 등 사용 가능
FOR 피벗할열	행에서 열로 변환할 기준 열
IN (열값1, 열값2...)	행 값을 열로 바꿀 값 목록 (고정되어 있어야 함)
*/

/*
CREATE TABLE sales (
    dept   VARCHAR2(10),
    year   NUMBER(4),
    amount NUMBER
);

INSERT INTO sales (dept, year, amount) VALUES ('A', 2022, 100);
INSERT INTO sales (dept, year, amount) VALUES ('A', 2023, 150);
INSERT INTO sales (dept, year, amount) VALUES ('B', 2022, 200);
INSERT INTO sales (dept, year, amount) VALUES ('B', 2023, 250);
COMMIT;

*/
select * from sales;

select *
from (
        select dept, year , amount
        from sales
     )
pivot (
      sum(amount)
      for year IN( 2022 as "Y2022" , 2023 as "Y2023" )
);
--------------------------------------------------------------------------------

--직종별 , 부서별 급여 합계

select job , deptno , sum(sal) 
from emp
group by job , deptno
order by job;

select *
from (
          select job , deptno ,sal from emp
     )
pivot (
        sum(sal) for deptno in('10' as d10 , '20' as d20 , '30' as d30)
);     
--------------------------------------------------------------------------------
-- 업무별 급여의 합
select *
from (
        select deptno , job , sal from emp
     )
pivot(
    sum(sal) for job 
    in('PRESIDENT' as PRESIDENT ,'ANALYST' as  ANALYST, 
       'MANAGER' as MANAGER , 'SALESMAN' as  SALESMAN ,'CLERK' as CLERK));    

--위와 동일한 결과를 만드는 decode 생성하세요

--동일한 결과 decode 생성하세요
SELECT DEPTNO, SUM(DECODE(JOB,'PRESIDENT',SAL)) AS E_PRESIDENT
             , SUM(DECODE(JOB,'ANALYST',SAL)) AS E_ANALYST
             , SUM(DECODE(JOB,'MANAGER',SAL)) AS E_MANAGER
             , SUM(DECODE(JOB,'SALESMAN',SAL)) AS E_SALESMAN
             , SUM(DECODE(JOB,'CLERK',SAL)) AS E_CLERK
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO DESC;


--동일한 결과 case 생성하세요
SELECT DEPTNO, SUM(CASE WHEN JOB='PRESIDENT' THEN SAL END) AS E_PRESIDENT
             , SUM(CASE WHEN JOB='ANALYST' THEN SAL END) AS E_ANALYST
             , SUM(CASE WHEN JOB='MANAGER' THEN SAL END) AS E_MANAGER
             , SUM(CASE WHEN JOB='SALESMAN' THEN SAL END) AS E_SALESMAN
             , SUM(CASE WHEN JOB='CLERK' THEN SAL END) AS E_CLERK
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO DESC;
--------------------------------------------------------------------------------
--Rollup , cube , rank 관련 함수....

/*
Rollup Cube (OLAP) 데이터 분석 
다차원 분석 쿼리 (레포팅 , 출력)

OLTP 환경 에서 잘 쓰지 않아요 ...
*/

select job , sum(sal)
from emp
group by rollup(job);
--직종별 급여의 합 구하고 ,,,모든 직종 급여의 합(union해도 된다고함)

select job , deptno, sum(sal) , count(sal)
from emp
group by job , deptno
order by job ,deptno;


select job ,deptno , sum(sal)
from emp
group by rollup(job,deptno); --   컬럼의 순서가 중요하다
/*
CLERK	10	1300
CLERK	20	1900
CLERK	30	950
CLERK		4150  --소계  CLERK 직종 급여합
ANALYST	20	6000
ANALYST		6000  --소계
MANAGER	10	2450
MANAGER	20	2975
MANAGER	30	2850
MANAGER		8275  --소계
SALESMAN	30	5600
SALESMAN		5600  --소계
PRESIDENT	10	5000
PRESIDENT		5000   --소계
		       29025  --합계

*/

select job ,deptno , sum(sal)
from emp
group by rollup(deptno,job); 

--------------------------------------------------------------------------------
--rollup의 원리
select deptno, job , sum(sal)
from emp
group by deptno,job
    union all
select deptno , null, sum(sal)
from emp
group by deptno
    union all
select null , job, sum(sal)
from emp
group by job
    union all
select null , null, sum(sal)
from emp;

--소계 , 총계 쿼리  union 통해서 작업하면 .... rollup , cube(모든 컬럼의 소개)
-- OLAP 분석 데이터 처리하는 사람들이 많이 한다고..
--------------------------------------------------------------------------------
select deptno ,job , sum(sal)
from emp
group by cube(deptno ,job)
order by deptno , job;
--------------------------------------------------------------------------------
--순위함수 
--rownum ( select 결과 순번 처리) >> 정렬하고 싶은 데이터 먼저 만들고 ( subquery) >>  순번
--RANK
--DENSE_RANK
-- 시험  A:100 , B:90  , C:50 , D:90  (동률 처리)

select ename, sal , 
rank() over(order by sal desc) as 순위 , -- 급여가 많은 순으로 순위
dense_rank() over(order by sal desc) as 순위2 -- over가 기준. 
from emp 
order by sal desc;
--rank는 동률 처리하고 그 인원 만큼 다음 순위 내려감
--  ex) 2등이 2명이면 둘 다 2등 주고 다음 순위가 4등
--dense_rank는 동률처리하고 동률 인원에 상관없이 순차적으로 다음 순위 매김
--  ex) 2등이 2명이면 둘다 2등 주고 다음 순위 3등
/*
rank() 같은 데이터 count

FORD	3000	2
SCOTT	3000	2

JONES	2975	4  3등이 아니고 4등
*/

/*
dense_rank()

KING	5000	1	1
FORD	3000	2	2
SCOTT	3000	2	2
JONES	2975	4	3  -- 3등처리 dense_rank()
*/

/*
만약 동률을 줄일 수 있는 방법 ... 동률이 되었을 때 하위 기준을 더 만드세요
쇼핑몰 : 포인트 많은 3사람 선물

10명 ....  100,98,97,97,97,97.....
가입순 , 나이순 , 중복값 제거 ....
쪼개서 기준을 늘리기
안그럼 고객이 따질수도 있음
순위 매기는 명분이 있어야 한다.
*/

-- rank의 장점 : 그룹으로 안묶어도 된다.
select ename , sal  ,comm 
, rank() over(order by sal desc, comm desc) as 순위
from emp
order by sal desc;
--------------------------------------------------------------------------------
--집계 함수 최대단점 ( 사번 , 급여 , 직종 , sum(sal) ....
    -- 그룹바이로 자꾸 묶거나 인라인뷰써야함
--다른 컬럼도  (in lin view (서브쿼리) , create view 가상테이블 )
--------------------------------------------------------------------------------