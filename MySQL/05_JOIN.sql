/*
	JOIN
    - 두 개 이상의 테이블에서 데이터를 조회하고자 할 때 사용하는 구문
    - 조회 결과는 하나의 결과물(RESULT SET)으로 나옴
    
    - 관계형 데이터베이스는 최소한의 데이터로 각각의 테이블에 담고 있음
      (중복을 최소화히기 위해 최대한 쪼개서 관리)
      부서 데이터는 부서 테이블, 사원에 대한 데이터는 사원 테이블, 직급 테이블 ...
      만약 어떤 사원이 어떤 부서에 속해있는지 부서명과 같이 조회하고 싶다면?
      만약 어떤 사원이 어떤 직급인지 직급명과 같이 조회하고 싶다면?
      
      => 즉, 관계형 데이터베이스에서 SQL 문을 이용한 테이블 간에 "관계"를 맺어
         원하는 데이터만 조회하는 방법 (JOIN)
*/
/*
	1. 내부 조인 (INNER JOIN)
    - 연결시키는 컬럼의 값이 일치하는 행들만 조인되어 조회 (일치하는 값이 없는 행은 조회 X)
    
    1) WHERE 구문
    SELECT 컬럼, 컬럼, ... 
    FROM 테이블1, 테이블2
    WHERE 테이블1.컬럼명 = 테이블2.컬럼명;
    
    - FROM 절에 조회하고자 하는 테이블들을 콤마로(,) 구분하여 나열
    - WHERE 절에 매칭시킬 컬럼명에 대한 조건 제시
    
    2) ANSI(미국국립표준협회, 산업표준을 제정하는 단체) 표준구문 -> 다른 DB에서도 사용 가능
    SELECT 컬럼, 컬럼, ...
    FROM 테이블1
    [INNER] JOIN 테이블2 ON (테이블1.컬럼명 = 테이블2.컬럼명);  // INNER << 생략가능
    
    - FROM 절에서 기준이 되는 테이블을 기술
    - JOIN 절에서 같이 조회하고자 하는 테이블을 기술 후 매칭 시킬 컬럼에 대한 조건을 기술 (ON, USING)
	- 연결에 사용하려는 컬럼명이 같은 경우 ON구문 대신 USING(컬럼명) 구문 사용

*/
-- 1) 연결할 두 컬럼명이 다른 경우 (employee : dept_code - department : dept_id 연결)
-- 사번, 사원명, 부서코드, 부서명을 같이 조회
SELECT emp_id, emp_name, dept_code, dept_title
FROM employee, department
WHERE dept_code = dept_id;

-- >> ANSI 구문 (기능은 위랑 똑같음, 편한거 사용)
SELECT emp_id, emp_name, dept_code, dept_title
FROM employee
JOIN department ON(dept_code = dept_id);

-- 일치하는 값이 없는 행은 조회에서 제외된 것 확인
-- dept-code가 null인 사원 조회 x

-- 2) 연결할 두 컬럼명이 같은 경우 (employee : job_code - job : job_code 연결)
-- 사번, 사원명, 직급코드, 직급명 조회
SELECT emp_id, emp_name, job_code, job_name
FROM employee, job
WHERE job_code = job_code; -- ambiguous : 애매한, 모호한 / 에러 코드

-- 해결방법 1) 테이블명을 이용하는 방법
SELECT emp_id, emp_name, job.job_code, job_name -- WHERE절 말고 SELECT절에도 테이블명 달아줘야함
FROM employee, job
WHERE employee.job_code = job.job_code; 

-- 해결방법 2) 테이블에 별칭을 부여해서 이용하는 방법
SELECT emp_id, emp_name, e.job_code, job_name
FROM employee e, job j
WHERE e.job_code = j.job_code;

-- >> ANSI 구문
-- ON 구문 사용
SELECT emp_id, emp_name, e.job_code, job_name
FROM employee e
JOIN job j ON (e.job_code = j.job_code);

-- USING 구문 사용 (두 컬럼명이 같을 때만)
SELECT emp_id, emp_name, job_code, job_name
FROM employee
JOIN job USING(job_code);

-- 참고사항 자연조인(NATURAL JOIN) : 각 테이블마다 동일한 컬럼이 한 개만 존재할 경우만 사용 가능
-- 실제로 추천하지 않음. 가급적으로 절대 사용 X
SELECT emp_id, emp_name, job_code, job_name
FROM employee
NATURAL JOIN job;

-- 직급이 대리인 사원의 사번, 이름, 직급명(job_name), 급여를 조회
SELECT emp_id, emp_name, j.job_name, salary
FROM employee e
JOIN job j ON(e.job_code = j.job_code) 
WHERE job_name = '대리';

SELECT emp_id, emp_name, job_name, salary
FROM employee
JOIN job USING(job_code)
WHERE job_name = '대리';

-- 1) where 구문
SELECT emp_id, emp_name, job_name, salary
FROM employee e, job j
WHERE e.job_code = j.job_code AND job_name = '대리';

-- 2) ANSI 구문
SELECT emp_id, emp_name, job_name, format(salary,0)
FROM employee e
JOIN job j USING(job_code)
WHERE job_name = '대리';

-- 실습문제 ----------------------------------------
-- 1. 부서가 인사관리부인 사원들의 사번, 이름, 보너스 조회 (employee, department)
SELECT emp_id, emp_name, bonus
FROM employee e
JOIN department d on(e.dept_code = d.dept_id)
WHERE dept_title = '인사관리부';
-- where 구문
SELECT emp_id, emp_name, bonus
FROM employee, department
WHERE dept_code = dept_id AND dept_title = '인사관리부'; 

-- 2. 전체 부서의 부서코드, 부서명, 지역코드, 지역명 조회 (department, location)
SELECT dept_id, dept_title, local_code, local_name
FROM department d
JOIN location l ON(d.location_id = l.local_code);
-- where 구문
SELECT dept_id, dept_title, local_code, local_name
FROM department, location
WHERE location_id = local_code;

-- 3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명 조회 (employee, department)
SELECT emp_id, emp_name, bonus, dept_title
FROM employee e
JOIN department d ON(e.dept_code = d.dept_id)
WHERE bonus IS NOT NULL;
-- where 구문
SELECT emp_id, emp_name, bonus, dept_title
FROM employee, department
WHERE dept_code = dept_id AND bonus IS NOT NULL;

-- 4. 부서가 총무부가 아닌 사원들의 사원명, 급여 조회 (employee, department)
SELECT emp_name, salary
FROM employee e
JOIN department d ON(e.dept_code = d.dept_id)
WHERE dept_title <> '총무부';
-- where 구문
SELECT emp_name, salary
FROM employee, department
WHERE dept_code = dept_id AND dept_title <> '총무부';

/*
	2. 외부 조인 (OUTER JOIN)
    - 두 테이블 간의 JOIN 시 일치하지 않는 행도 포함시켜서 조회가 가능하다.
    - 단, 반드시 기준이 되는 테이블(컬럼)을 지정해야 한다. (LEFT, RIGHT, FULL)
*/
-- 사원명, 부서명, 급여, 연봉(급여 * 12) 조회 (내부조인 사용)
SELECT emp_name, dept_title, salary, (salary * 12)
FROM employee JOIN department ON(dept_code = dept_id);
-- > 부서 배치가 안된 사원 2명에 대한 정보 조회 X
-- > 부처에 배정된 사원이 없는 부서도 정보 조회 X

-- 1) LEFT [OUTER] JOIN : 두 테이블 중 왼편에 기술된 테이블을 기준으로 JOIN
SELECT emp_name, dept_title, salary, (salary * 12)
FROM employee LEFT JOIN department ON(dept_code = dept_id);

-- 2) RIGHT [OUTER] JOIN : 두 테이블 중 오른편에 기술된 테이블을 기준으로 JOIN
SELECT emp_name, dept_title, salary, (salary * 12)
FROM employee RIGHT JOIN department ON(dept_code = dept_id);

-- 3) FULL [OUTER] JOIN : 두 테이블이 가진 모든 행을 조회할 수 있음 - MySQL에서 작동 X
SELECT emp_name, dept_title, salary, (salary * 12)
FROM employee FULL JOIN department ON(dept_code = dept_id);

/*
	3. 비등가 조인 (NON EQUAL JOIN)
    - 매칭시킬 컬럼에 대한 조건 작성시 '='(등호)를 사용하지 않는 조인문
    - 값의 범위에 포함되는 행들을 연결하는 방식
    - ANSI 구문으로는 JOIN ON만 사용 가능 (USING 사용 불가)
*/
SELECT * FROM employee; -- salary
SELECT * FROM sal_grade; -- 급여 등급 테이블 : sal_level, min_sal, max_sal - salary와 연관

-- 사원명, 급여, 급여 레벨 조회
-- >> ANSI 구문
SELECT emp_name, salary, sal_level
FROM employee JOIN sal_grade ON(min_sal <= salary AND salary <= max_sal);
-- >> where 구문
SELECT emp_name, salary, sal_level
FROM employee, sal_grade
-- WHERE min_sal <= salary AND salary <= max_sal;
WHERE salary BETWEEN min_sal AND max_sal;

/*
	4. 자체 조인 (SLEF JOIN)
    - 같은 테이블을 다시 한번 조인하는 경우 (자기 자신과 조인)
*/
SELECT * FROM employee;

-- 전체 사원의 사원사번, 사원명, 사원부서코드, 
--          사수사번, 사수명, 사수부서코드
SELECT e.emp_id '사원사번', e.emp_name '사원명', e.dept_code '사원부서코드', 
	   m.emp_id '사수사번', m.emp_name '사수명', m.dept_code '사수부서코드'
FROM employee e LEFT JOIN employee m  ON(e.manager_id = m.emp_id);

/*
	5. 카테시안곱(CARTESIAN PRODUCT) / 교차 조인(CROSS JOIN)
    - 조인되는 모든 테이블의 각 행들이 서로서로 모두 매핑된 데이터가 검색된다. (곱집합)
    - 두 테이블의 행들이 모두 곱해진 행들의 조합이 출력 -> 방대한 데이터 출력 -> 과부화 위험 있음
*/
-- 사원명, 부서명 조회 (employee, department)
-- >> ANSI 구문 
SELECT emp_name, dept_title
FROM employee CROSS JOIN department;

/*
	6. 다중 JOIN
    - 여러 개의 테이블을 조인하는 경우
*/
-- 사번, 사원명, 부서명, 직급명 조회
SELECT * FROM employee;   -- emp_id, emp_name, dept_code, job_code
SELECT * FROM department; -- dept_title,       dept_id
SELECT * FROM job;		  -- job_name,                    job_code

-- where 구문
SELECT emp_id, emp_name, dept_title, job_name
FROM employee e, department d, job j
WHERE e.dept_code = d.dept_id 
AND e.job_code = j.job_code;

-- >> ANSI 구문
SELECT emp_id, emp_name, dept_title, job_name
FROM employee
JOIN department ON(dept_code = dept_id) 
JOIN job USING(job_code);

-- 사번, 사원명, 부서명, 직급명, 지역명, 국가명, 급여등급 조회 (employee, department, job,location, national, sal_grade)
SELECT * FROM employee; -- dept_code jobcode
SELECT * FROM department; -- dept_id
SELECT * FROM job; -- job_code
SELECT * FROM location; -- national_code
SELECT * FROM national; -- national_code
SELECT * FROM sal_grade; 

-- ANSI 구문
SELECT emp_id, emp_name, dept_title, job_name ,local_name, national_name, sal_level
FROM employee
	JOIN department ON(dept_code = dept_id)
	JOIN job USING(job_code)
	JOIN location ON(location_id = local_code)
	JOIN national USING(national_code)
	JOIN sal_grade ON(salary BETWEEN min_sal AND max_sal);



-- where 구문
SELECT emp_id, emp_name, dept_title, job_name, local_name, national_name, sal_level
FROM employee e, department, job j, location l, national n, sal_grade
WHERE dept_id = dept_code 
	AND e.job_code = j.job_code
	AND location_id = local_code 
	AND l.national_code = n.national_code
	AND salary BETWEEN min_sal AND max_sal;
    
    
    
SELECT * FROM employee; -- dept_code job_code
SELECT * FROM department; -- dept_id
SELECT * FROM job; -- job_code
SELECT * FROM location; -- national_code
SELECT * FROM national; -- national_code
SELECT * FROM sal_grade; 
-- 1. 직급이 대리면서 ASIA 지역에서 근무하는 직원들의
-- 사번, 직원명, 직급명, 부서명 , 근무지역, 급여 조회
SELECT emp_id, emp_name , job_name, dept_title, local_name, salary
FROM employee 
	JOIN job USING(job_code)
    JOIN department ON(dept_code = dept_id)
    JOIN location ON(location_id = local_code)
    WHERE job_name = '대리' AND local_name LIKE 'ASIA%';
 
 -- where 구문
 SELECT emp_id, emp_name , job_name, dept_title, local_name, salary
 FROM employee e, job j, department, location 
 WHERE e.job_code = j.job_code
 AND dept_code = dept_id
 AND location_id = local_code
 AND job_name = '대리'
 AND local_name LIKE 'ASIA%';

-- 2. 70년대생 이면서 여자이고, 성이 전씨인 직원들의 
-- 직원명, 주민번호, 부서명, 직급명 조회
SELECT emp_name, emp_no, dept_title, job_name
FROM employee
	JOIN department ON(dept_code = dept_id)
	JOIN job USING(job_code)
	WHERE substr(emp_no, 1, 2) BETWEEN 70 AND 79
		AND substr(emp_no, 8, 1) = 2
        AND emp_name LIKE '전%';
        
-- where 구문
SELECT emp_name, emp_no, dept_title, job_name
FROM employee e, department, job j
WHERE dept_code = dept_id
AND e.job_code = j.job_code
-- AND emp_no LIKE '7%'
-- AND substr(emp_no, 8, 1) = 2
AND emp_no LIKE '7_____-2%'
AND emp_name LIKE '전%';

-- 3. 보너스를 받은 직원들의 직원명, 보너스, 연봉(salary + salary * bonus) * 12, 부서명, 근무지역 조회
-- 단, 부서 코드가 없는 사원도 출력 / OUTER JOIN 사용
SELECT emp_name, bonus, (salary + salary * ifnull(bonus, 0)) * 12 as '연봉', dept_title, local_name
FROM employee
	LEFT JOIN department ON(dept_code = dept_id)
	LEFT JOIN location ON(location_id = local_code)
    WHERE bonus IS NOT NULL;
    
-- where 구문 (부서 코드가 없는 사원은 출력 X)
SELECT emp_name, bonus, (salary + salary * ifnull(bonus, 0)) * 12 as '연봉', dept_title, local_name
FROM employee, department, location
WHERE dept_code = dept_id
AND location_id = local_code
AND bonus IS NOT NULL;

-- 4. 한국과 일본에서 근무하는 직원들의 직원명, 부서명, 근무지역, 근무 국가를 조회
SELECT emp_name, dept_title, local_name, national_name
FROM employee
	JOIN department ON(dept_code = dept_id)
	JOIN location ON(location_id = local_code)
    JOIN national USING(national_code)
WHERE national_name IN('한국', '일본');
    
-- where 구문
SELECT emp_name, dept_title, local_name, national_name
FROM employee, department, location, national
WHERE dept_code = dept_id
	AND location_id = local_code
	AND location.national_code = national.national_code
	AND national_name IN('한국', '일본');

-- 5. 각 부서별 평균 급여를 조회하여 부서명, 평균 급여(소수점 제거)를 조회
-- 단, 부서 코드가 없는 사원들의 평균도 같이 나오게 / OUTER JOIN 사용
SELECT dept_title, format(avg(salary), 0) as '평균 급여'
FROM employee LEFT JOIN department ON(dept_code = dept_id)
GROUP BY dept_code;

-- 6. 각 부서별 총 급여의 합이 1000만원 이상인 부서명, 급여의 합을 조회
SELECT dept_title, sum(salary)
FROM employee JOIN department ON(dept_code = dept_id)
GROUP BY dept_code
HAVING sum(salary) >= 10000000;

-- where 구문
SELECT dept_title, sum(salary)
FROM employee, department
WHERE dept_code = dept_id
GROUP BY dept_title
HAVING sum(salary) >= 10000000;

-- 7. 사번, 직원명, 직급명, 급여 등급, 급여 등급 구분을 조회
-- 이때 구분에 해당하는 값은 아래와 같이 조회 되도록
-- 급여 등급이 s1, s2인 경우 '고급'
-- 급여 등급이 s3, s4인 경우 '중급'
-- 급여 등급이 s5, s6인 경우 '초급'
SELECT emp_id, emp_name, job_name, sal_level, 
	   CASE WHEN sal_level IN('S1', 'S2') THEN '고급'
			WHEN sal_level IN('S3', 'S4') THEN '중급'
			ELSE '초급' END as '급여 등급 구분'
FROM employee
	JOIN job USING(job_code)
	JOIN sal_grade ON(salary BETWEEN min_sal AND max_sal);

-- where 구문
SELECT emp_id, emp_name, job_name, sal_level, 
	   CASE WHEN sal_level IN('S1', 'S2') THEN '고급'
			WHEN sal_level IN('S3', 'S4') THEN '중급'
			ELSE '초급' END as '급여 등급 구분'
FROM employee, job, sal_grade
WHERE job.job_code = employee.job_code
	AND salary BETWEEN min_sal AND max_sal ;

-- 8. 보너스를 받지 않은 직원들 중 직급 코드가 J4 또는 J7인 직원들의 직원명, 직급명, 급여를 조회
SELECT emp_name, job_name, salary
FROM employee
	JOIN job USING(job_code)
WHERE bonus IS NULL 
AND job_code IN('J4', 'J7');

-- where 구문
SELECT emp_name, job_name, salary
FROM employee, job
WHERE job.job_code = employee.job_code
AND employee.job_code IN('J4', 'J7');

-- 9. 부서가 있는 직원들의 직원명, 직급명, 부서명, 근무 지역을 조회
SELECT emp_name, job_name, dept_title, local_name
FROM employee
	JOIN department ON(dept_code = dept_id)
	JOIN job USING(job_code)
	JOIN location ON(location_id = local_code);
    
-- where 구문
SELECT emp_name, job_name, dept_title, local_name
FROM employee, department, job, location
WHERE dept_code = dept_id
	AND employee.job_code = job.job_code
	AND location_id = local_code;

-- 10. 해외영업팀에 근무하는 직원들의 직원명, 직급명, 부서코드, 부서명을 조회
SELECT emp_name, job_name, dept_code, dept_title
FROM employee 
JOIN department ON(dept_code = dept_id)
JOIN job USING(job_code)
WHERE dept_title LIKE '해외영업%';

-- where
SELECT emp_name, job_name, dept_code, dept_title
FROM employee, department, job
WHERE dept_code = dept_id
	AND employee.job_code = job.job_code
    AND dept_title LIKE '해외영업%';

-- 11. 이름에 '형'자가 들어있는 직원들의 사번, 직원명, 직급명을 조회
SELECT emp_id, emp_name, job_name
FROM employee
	JOIN job USING(job_code)
WHERE emp_name LIKE '%형%';

--  where 구문
SELECT emp_id, emp_name, job_name
FROM employee, job
WHERE employee.job_code = job.job_code
	AND emp_name LIKE '%형%';































































