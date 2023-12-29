/*
	서브쿼리(SUBQUERY), 중첩쿼리
    - 하나의 SQL문 안에 포함된 또 다른 SQL문
    - 서브쿼리를 수행한 결과값이 몇 행 몇 열이냐에 따라 분류
    - 서브쿼리 종류에 따라 서브쿼리와 사용하는 연산자가 달라짐
    
    1. 단일행 서브쿼리 (SINGLE ROW SUBQUERY)
    - 서브쿼리의 조회 결과값의 개수가 오로지 1개일 때 (한 행 한 열)
    - 일반 비교연산자 사용 가능 : =, !=, ^=, <>, >, <, >=, <=, ...
*/
-- 노옹철 사원과 같은 부서원들을 조회
-- 1) 노옹철 사원의 부서코드 조회
SELECT dept_code
FROM employee
WHERE emp_name = '노옹철'; -- D9

-- 2) 부서 코드가 D9인 사원들을 조회
SELECT emp_name
FROM employee
WHERE dept_code = 'D9';

-- 3) 위의 2단계를 하나의 쿼리문으로 합치기
SELECT emp_name FROM employee WHERE dept_code = (SELECT dept_code
												 FROM employee
												 WHERE emp_name = '노옹철');
                                                 
-- 전 직원의 평균 급여보다 더 많은 급여를 받는 사원들의 사번, 사원명, 직급코드 조회
-- 1) 평균 급여 
SELECT format(avg(salary),0) FROM employee;

-- 2)  (SELECT format(avg(salary),0) FROM employee) 보다 더 많은 급여를 받는 사원들의 사번, 직원명, 직급코드, 급여 조회 
SELECT emp_id, emp_name, job_code, format(salary,0)
FROM employee
WHERE format(salary, 0) > (SELECT format(avg(salary),0) FROM employee);

-- 최저 급여를 받는 사원의 사번, 이름, 직급코드, 급여, 입사일 조회
-- 1) 최저 급여 찾기
SELECT min(salary) FROM employee;

-- 2) 최저 급여 사원 찾기
SELECT emp_id, emp_name, job_code, salary, hire_date
FROM employee
WHERE salary = (SELECT min(salary) FROM employee);

-- 전지연 사원이 속해있는 부서원들의 사번, 직원명, 전화번호, 직급명, 부서명, 입사일 조회
-- 단, 전지연 사원은 제외
-- 1) 전지연 사원의 부서 찾기
SELECT dept_title FROM employee JOIN department ON(dept_code = dept_id)
WHERE emp_name = '전지연'; 

-- 2)전지연 사원이 속해있는 부서원들의 사번, 직원명, 전화번호, 직급명, 부서명, 입사일 조회
SELECT emp_id ,emp_name, phone, job_name, dept_title, hire_date
FROM employee
	JOIN job USING(job_code)
	JOIN department ON(dept_code = dept_id)
WHERE dept_title = (SELECT dept_title FROM employee JOIN department ON(dept_code = dept_id) WHERE emp_name = '전지연')
AND emp_name <> '전지연';

-- 부서별 급여의 합이 가장 큰 부서의 부서 코드, 급여의 합을 조회
-- 1) 부서별 급여 합이 가장 큰 부서의 부서 코드 조회
SELECT dept_code, sum(salary) FROM employee GROUP BY dept_code ORDER BY 2 DESC LIMIT 1;

-- 2) 부서별 급여의 합이 가장 큰 부서의 부서 코드, 급여의 합을 조회
SELECT (SELECT dept_code FROM employee GROUP BY dept_code LIMIT 1), sum(salary)
FROM employee
GROUP BY dept_code
LIMIT 1;

-- 서브쿼리 사용
SELECT dept_code, sum(salary) as sum_sal
FROM employee
GROUP BY dept_code; -- > 결과값이 테이블인 상태

-- 부서별 합이 가장 큰 값
SELECT max(sum_sal)
FROM (SELECT dept_code, sum(salary) as sum_sal
	  FROM employee
	  GROUP BY dept_code) as dept_sal;
      
-- 이 문제는 서브쿼리 다 배우고 나서 다시 볼 예정
-- 서브쿼리 특징! 쿼리 자체는 직관적
-- 현업에서는 쿼리 속도를 중요시, 서브 쿼리는 느리다
-- 가급적으로 서브쿼리를 사용하지 않아도 되는 거면 안 쓰고 하는걸 추천
SELECT dept_code, sum(salary)
FROM employee
GROUP BY dept_code
HAVING sum(salary) = (SELECT max(sum_sal)
					  FROM (SELECT dept_code, sum(salary) as sum_sal
							FROM employee
							GROUP BY dept_code) as dept_sal);


/*
	2. 다중행 서브쿼리
    - 서브쿼리의 조회 결과값의 개수가 여러 행 일 때 (여러행 한열)
    
    IN 서브쿼리 : 여러개의 결과값 중에서 한개라도 일치하는 값이 있다면 
*/
-- 각 부서별 최고 급여를 받는 직원의 이름, 직급코드, 부서코드, 급여 조회

-- 각 부서별 최고 급여 (조건)
SELECT max(salary) FROM employee GROUP BY dept_code;

-- 직원의 이름, 직급코드, 부서코드, 급여 조회
SELECT emp_name, job_code ,dept_code, salary
FROM employee
WHERE salary IN(SELECT max(salary) FROM employee GROUP BY dept_code);

-- 직원에 대해 사번, 이름, 부서코드, 구분(사수/사원) 조회
-- 누군가의 사수인 사람들의 id! --> 이 사람들이 사수!
SELECT distinct manager_id 
FROM employee 
WHERE manager_id is not null;

-- 사수 테이블 조회
SELECT emp_id, emp_name, dept_code, '사수' as "구분"
FROM employee
WHERE emp_id IN (SELECT distinct manager_id 
				FROM employee 
				WHERE manager_id is not null)
UNION
-- 사원 테이블 조회 
SELECT emp_id, emp_name, dept_code, '사원' as "구분"
FROM employee
WHERE emp_id NOT IN (SELECT distinct manager_id 
				FROM employee 
				WHERE manager_id is not null);
                
-- >> 오로지 서브쿼리로만 사용하는 방법! 힌트 : SELECT절에서도 서브쿼리를 사용할 수 있다
-- manager_id 에서 중복 안되는 값만 뽑아서 사수 목록 테이블 생성
SELECT DISTINCT manager_id FROM employee WHERE manager_id IS NOT NULL;

-- 사번이 위에서 뽑은 사수 목록 안에 있으면 사수, 아니면 사원
SELECT emp_id, emp_name, dept_code, 
	   IF(emp_id IN(SELECT DISTINCT manager_id FROM employee WHERE manager_id IS NOT NULL), '사수', '사원') as '구분'
FROM employee;

/*
	비교대상 > ANY (서브쿼리) : 여러개의 결과값 중에서 '한개라도' 클 경우
							(여러개의 결과값 중에서 가장 작은 값 보다 클 경우)
    비교대상 < ANY (서브쿼리) : 여러개의 결과값 중에서 '한개라도' 작을 경우
							(여러개의 결과값 중에서 가장 큰 값 보다 작을 경우)
*/


SELECT * FROM employee; -- dept_code job_code
SELECT * FROM department; -- dept_id
SELECT * FROM job; -- job_code
SELECT * FROM location; -- national_code
SELECT * FROM national; -- national_code
SELECT * FROM sal_grade;
-- 대리 직급임에도 과장 직급들의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급, 급여 조회
-- 1) 과장 직급의 최소급여
SELECT  min(salary)
FROM employee
JOIN job USING(job_code)
WHERE job_name = '과장';

-- 2) 직급이 대리인 사원들의 월급을 구해 위 구문과 비교
SELECT emp_id, emp_name, job_name, salary
FROM employee JOIN job USING(job_code)
WHERE job_name = '대리' 
AND salary > ANY (SELECT  min(salary)
				  FROM employee
					JOIN job USING(job_code)
				  WHERE job_name = '과장');
-- salary > 2200000 OR salary > 2500000 OR salary > 3760000


/*
	컬럼 > ALL (서브쿼리) : 여러개의 "모든" 결과값들 보다 클 경우 
    컬럼 < ALL (서브쿼리) : 여러개의 "모든" 결과값들 보다 작을 경우
*/
-- 과장 직급임에도 차장 직급의 최대 급여보다 더 많이 받는 직원들의 사번, 이름, 직급, 급여 조회
SELECT  salary
FROM employee
JOIN job USING(job_code)
WHERE job_name = '차장';

SELECT emp_id, emp_name, job_name, salary
FROM employee JOIN job USING(job_code)
WHERE job_name = '과장' 
AND salary > ALL(SELECT  salary
				 FROM employee
					JOIN job USING(job_code)
				 WHERE job_name = '차장');

/*	
서브쿼리의 조회 결과값이 한 행이지만 컬럼이 여러개일 때 (한 행 여러 열)
*/
-- 하이유 사원과 같은 부서 코드, 같은 직급 코드에 해당되는 사원들의 사원명, 부서코드, 직급 코드 조회
SELECT dept_code
FROM employee
WHERE emp_name = '하이유';

SELECT job_code
FROM employee
WHERE emp_name = '하이유';

SELECT emp_name, dept_code, job_code
FROM employee
WHERE dept_code = (SELECT dept_code
					FROM employee
					WHERE emp_name = '하이유')
	AND job_code = (SELECT job_code
					FROM employee
					WHERE emp_name = '하이유');
-- >> 다중열 서브쿼리
SELECT emp_name, dept_code, job_code
FROM employee
WHERE (dept_code, job_code) = (SELECT dept_code, job_code
					FROM employee
					WHERE emp_name = '하이유');
                    
-- 박나라 사원과 직급 코드가 일치하면서 같은 사수를 가지고 있는 사원의 사번, 이름, 직급 코드, 사수 사번 조회
-- 1) 박나라 사원의 직급 코드, 사수 사번
SELECT job_code, manager_id
FROM employee
WHERE emp_name = '박나라';

-- 2)
SELECT emp_id, emp_name, job_code, manager_id
FROM employee
WHERE (job_code, manager_id) = (SELECT job_code, manager_id
								FROM employee
								WHERE emp_name = '박나라');

/*
	4. 다중행 다중열 서브쿼리
     - 서브쿼리의 조회 결과값이 여러 행, 여러 열일 경우
*/
--  각 직급별로 최소 급여를 받는 사원들의 사번, 이름, 직급코드, 급여
-- 1) 각 직급별 최소급여
SELECT job_code ,min(salary)
FROM employee
GROUP BY job_code
ORDER BY 1;

SELECT emp_id, emp_name, job_code, format(salary,0)
FROM employee
WHERE (job_code, salary) IN (SELECT job_code, min(salary)
							FROM employee
							GROUP BY job_code) 
ORDER BY 3;

-- 각 부서별 최대 급여를 받는 사원들의 사번, 이름, 부서코드, 급여 조회(부서 없음 명시)
-- 1) 각 부서별 최대급여 (부서 없는 사람도 표기)
SELECT ifnull(dept_code,'부서없음'), max(salary)
FROM employee
GROUP BY dept_code
ORDER BY 1;

-- 2)
SELECT emp_id, emp_name, ifnull(dept_code,'부서없음') as '부서별 최대급여', salary
FROM employee
WHERE (ifnull(dept_code,'부서없음'), salary) IN (SELECT ifnull(dept_code,'부서없음'), max(salary)
												FROM employee
												GROUP BY dept_code)
ORDER BY 3 DESC;

/*
	RANK 함수
    - RANK () OVER () (정렬 기준) : 동일한 순위 이후의 등수를 동일한 인원수만큼 건너뛰고 순위를 계산한다.
								 (ex. 공동 1위가 2명이면 다음 순위는 3위)
    - DENSE_RANK() OVER (정렬 기준) : 동일한 순위 이후의 등수를 무조건 1씩 증가한다.
									(ex. 공동 1위가 2명이면 다음 순위는 2위)
*/
-- 사원별 급여가 높은 순서대로 순위를 매겨서 순위, 사원명, 급여 조회
SELECT 
		rank() over(ORDER BY salary DESC) as '급여 순위',
		emp_name, salary
FROM employee;

-- 1 ~ 10위 까지만
SELECT 
		dense_rank() over(ORDER BY salary DESC) as '급여 순위',
		emp_name, salary
FROM employee
LIMIT 10;
















