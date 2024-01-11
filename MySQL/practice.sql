-- 실습문제 (테이블 : employee) --------------------
-- 1. 부서코드(dept_code)가 'D1'인 사원들의 사원명, 급여, 부서코드만 조회
SELECT *
FROM employee;

SELECT emp_name, emp_id, salary, dept_code
FROM employee
WHERE dept_code = 'D1';

-- 2. 부서코드가 'D1'이 아닌 사원들의 사번, 사원명, 부서코드 조회
SELECT emp_id, emp_name, dept_code
FROM employee
WHERE dept_code != 'D1';

-- 3. 급여가 400만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT emp_name, dept_code, salary
FROM employee
WHERE salary >= 4000000;

-- 4. 재직중(ent_yn 컬럼값이 'N')인 사원들의 사번, 사원명, 입사일(hire_date) 조회
SELECT emp_id, emp_name, hire_date
FROM employee
WHERE ent_yn = 'N';


SELECT *
FROM employee;
-- 사원들 중 성이 전씨인 사원들의 사원명, 급여, 입사일 조회
SELECT emp_name, salary, hire_date
FROM employee
WHERE emp_name LIKE '전%';

-- 이름 중에 하 가 포함된 사원들의 사원명, 주민번호(emp_no), 전화번호(phone) 조회
SELECT emp_name, emp_no, phone
FROM employee
WHERE emp_name LIKE '%하%';

-- 전화번호의 3번째 자리가 1인 사원들의 사번, 사원명, 전화번호, 이메일 조회
SELECT emp_id, emp_name, phone, email
FROM employee
WHERE phone LIKE '__1%';

-- 이메일 중 _ 앞글자가 3글자인 사원들의 사번, 이름, 이메일 조회
-- ex) sim_bs@kh.or.kr
-- ESCAPE OPTION : 나만의 와일드 카드를 만들어서 사용
SELECT emp_id, emp_name, email
FROM employee
WHERE email LIKE '___$_%' ESCAPE '$';

-- eMployee 테이블에 직급코드(job_code) 중복없이 조회
SELECT DISTINCT job_code
FROM employee
ORDER BY 1;