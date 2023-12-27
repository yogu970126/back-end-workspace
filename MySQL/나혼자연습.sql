-- 1. 직급코드가(job_code) J7 이거나 J2인 사원들 중 급여가 200만원 이상인 사원들의 모든 컬럼 조회
SELECT *
FROM employee
WHERE job_code IN('J7', 'J2') AND salary >= 2000000;

-- 2. 사수가 없고 부서배치도 받지 않은 사원들의 사원명, 사수사번(manager_id), 부서코드 조회 
SELECT emp_name, manager_id, dept_code
FROM employee
WHERE manager_id IS NULL AND dept_code IS NULL;

-- 3. 연봉(보너스포함x)이 3000만원 이상이고 보너스를 받지 않은 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT emp_id, emp_name, salary,salary*12 as '연봉', bonus
FROM employee
WHERE (salary*12) >= 30000000 AND bonus IS NULL;

-- 4. 입사일이 '1995-01-01' 이상이고 부서배치를 받은 사원들의 사번, 사원명, 입사일, 부서코드 조회
SELECT emp_id, emp_name, hire_date, dept_code
FROM employee
WHERE hire_date >= '1995-01-01' AND dept_code IS NOT NULL;

-- 5. 급여가 200만원 이상이고 500만원 이하고 입사일이 '2001-01-01' 이상이고 
--    보너스를 받지 않는 사원들의  사번, 사원명, 급여, 입사일, 보너스 조회
SELECT emp_id, emp_name, salary, hire_date, bonus
FROM employee
WHERE salary BETWEEN 2000000 AND 5000000 AND hire_date >= '2001-01-01' AND bonus IS NULL;

-- 6. 보너스 포함 연봉이 NULL이 아니고 이름에 '하'가 
--    포함되어 있는 사원들의 사번, 사원명, 급여, 보너스 포함 연봉 조회(별칭 사용)
--    보너스 포함 연봉 : (SALARY + SALARY * BONUS) * 12
SELECT emp_id, emp_name, salary, (salary + salary * bonus) * 12 as '보너스 포함 연봉'
FROM employee
WHERE (salary + salary * bonus) * 12 IS NOT NULL AND emp_name LIKE '%하%';

