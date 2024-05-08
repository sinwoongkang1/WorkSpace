package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
/*
show tables; #테이블 전체를 본다

    desc SALGRADE; #해당 테이블은 본다

    select GRADE, LOSAL, HISAL from SALGRADE; #원하는 컬럼을 본다 (~~테이블에 속한 컬럼)
    select * from SALGRADE;
    select LOSAL, HISAL, GRADE from SALGRADE; #순서 상관없이 조회가능

    desc emp;
    select mgr from emp;
    select distinct mgr from emp; #중복을 제거하고 보여준다

    select distinct emp.deptno from emp;

    select empno 사번, ename 사원이름 from emp; #Alias 지정 (원하는 목록명으로 변경)
    select empno 사번, ename "사원 이름" from emp; #공백을 추가하고 싶으면 ""로 묶어서 처리

    select concat('test','hello',empno) from emp; #내용에 문자열을 합성해서 보여준다
    select concat(ename, ' 사원의 매니져는 ' , mgr , ' 입니다.. ' )from emp;

    show tables ;
    desc emp;
    select empno, ename, job,mgr,hiredate,sal,comm,deptno from emp;
    desc dept;
    select deptno from dept;
    select dname from dept;

    select * from emp where ename = 'king';
    select * from emp where sal > 2000; #조건을 붙어셔 검색가능

    select * from emp where sal>=2000 or deptno=20; #조건 2개 인데 하나만 만족하는 경우
    select * from emp where sal>=2000 and deptno=20; # 조건 2개 인데 모두 만족하는 경우

    select * from emp where comm is null;
    select * from emp where comm is not null;

    select * from emp where deptno =10 or deptno=20;
    select * from emp where deptno in (10,20); #    = 을 연결해주는 방법

    select * from emp where job = 'manager';
# like 와일드 카드를 이용해서 검색 _ 문자 하나, % 문자 여러개
    select * from emp where job like  '_anager';
    select * from emp where emp.ename  like  '_____'; #이름이 5글자
    select * from emp where emp.ename  like  '__rd'; #이름이 4글자 끝이 RD
    select * from emp where emp.ename  like  's%'; #이름이 s로 시작하는 것 검색
    select * from emp where emp.ename  like  '%t'; #이름이 t로 끝나는 것 검색
    select * from emp where emp.ename  like  '__A%'; #이름이 세번째는 A 인 것 검색
    select * from emp where hiredate like '19%'; #이름이 세번째는 A 인 것 검색

    select upper('SeoUl');
    select ucase('SeoUl');
    select upper(ename) from emp;
    select * from emp where upper(ename) = 'SMITH';
    select substring('Happy Day',3,2); #인덱스롤 1부터 시작!

    select * from emp where substring(hiredate,3,2) = 81; #입사일이 81년도인 사람의 모든정보 검색
    select trim(' test   ');
    select rtrim(' test   ') ;
    select ltrim(' test   ') ;

    select lpad('hi',5,'*'); #문자열을 5자리 출력하고 왼쪽 남는자리에는 *
    select rpad('hi',5,'$'); #문자열을 5자리 출력하고 오른쪽 남는자리에는 $
    select lpad(ename,10,'-') from emp; #문자열을 5자리 출력하고 오른쪽 남는자리에는 $

#숫자형함수
    select abs(-2),abs(2); # 절대값
    select mod(34,10); #나눠서 나머지 값 (모듈러 연산)
    select  6%5 ;# 위와 같다
    select floor(1.23); #입력값에서 가까운 가장 작은 정수값
    select ceiling(1.23); #입력값에서 가까운 가장 큰 정수값
    select  round(1.534); #반올림(반내림) 하여 정수로
    select  round(1.536,2); #반올림(반내림) 하여 정수로, 소수점 2번째 자리까지 보여줘
    select  pow(2,2); # 2의 2제곱
    select  sign(20),cos(10),tan(23); #삼각함수
    select greatest(1,2,3,35,6), least(3,6,8,9); #숫자중에 최대값 최소값

#날짜형 함수
    select curdate(), current_date;
    select current_time,current_timestamp;
    select now(),sysdate();
    select date_format(current_date,'%w %M %y'); #날짜형 데이터를 다양한 형태로 포멧하여 출력.
    select date_format(current_date,'%Y %m %d'); #날짜형 데이터를 다양한 형태로 포멧하여 출력.

            #형변환 함수 cast
    select now();
    select cast(now() as date);
    select cast(123 as char );

#그룹함수
    select upper(emp.ename) from emp; #단일행 함수 -  행 하나에 함수가 각각 적용
    select sum(sal) from emp; #그룹함수 : 모든 행에 대해서 하나의 함수가 실행되어 결과값 리턴
    select deptno, sum(sal) from emp group by deptno ; #부서 번호별(그룹핑) 급여의 총합
    select deptno, round(avg(sal)) from emp group by deptno ; #부서 번호별(그룹핑) 급여의 평군
    select count(*) from emp; #전체사원으 수를 셀 수 있다 (널을 세지 않는다)
    select deptno, count(*) from emp group by deptno; #부서별 사원수
    select deptno, round(max(sal)) from emp group by deptno; #부서별 최대급여

#그룹별로 묶고 조건추가 가능
    select emp.deptno, avg(sal) from emp group by deptno having avg(sal)>2000; #그룹별 평균급여에, 2000이하인 부서는 제외
    select deptno, avg(sal) from emp where sal < 4500 and sal > 1000 group by deptno having avg(sal) > 2000;
    */


    //h2
    /*
    show tables ;
desc countries;
select countries.country_name from countries;
desc employees;
select employees.first_name,employees.last_name,employees.hire_date from employees;
select employees.first_name,employees.last_name,employees.hire_date from employees order by 3 asc;

show tables ;
select * from employees;
select * from employees where commission_pct is not null;
select * from employees where employees.first_name like '_____';
select * from employees where employees.last_name like '_____';
select * from employees where employees.phone_number like '5%' and hire_date like '199%' order by hire_date;
select * from employees where employees.hire_date like '199%' order by hire_date desc ;

select concat(employees.first_name,' ',employees.last_name) AS name,
       period_diff(date_format(current_date,'%y%m'),
                    date_format(employees.hire_date,'%y%m')
    ) AS Period from employees order by Period asc;
     */
}