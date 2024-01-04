/*
	DML(Data Manipulation Language)
    - 데이터 조작 언어로 테이블에 값을 삽입(INSERT)하거나, 수정(UPDATE)하거나,
    삭제(DELETE)하는 구문
    
    INSERT 
    - 테이블에 새로운 행을 추가하는 구문
     
    1) INSERT INTO 테이블명 VALUES(값, 값, ...);
		- 테이블에 모든 컬럼에 대한 값을 INSERT 하고자 할 때 사용
        - 컬럼 순번을 지켜서 VALUES에 값을 나열해야 한다.
        
    2) INSERT INTO 테이블명(컬럼명, 컬럼명, ...) VALUES(값, 값, ...);
		- 테이블에 특정 컬럼에 대한 값만 INSERT 하고자 할 때 사용한다.
        - 선택이 안된 컬럼들은 기본적으로 NULL값이 들어간다.
          (NOT NULL조건이 걸려있는 컬럼은 반드시 값을 입력해야 한다.)
		- 기본값(DEFAULT)이 지정되어 있으면 NULL이 아닌 기본값이 들어간다.
        
    3) INSERT INTO 테이블명 서브쿼리;
		- VALUES 대신 서브쿼리 조회한 결과값이 통쩨로 INSERT 한다.
        - 서브쿼리 결과값이 INSERT문에 지정된 테이블 컬럼 개수와 같아야 한다.
*/
-- 사용할 테이블 생성
CREATE TABLE emp(
	emp_id INT PRIMARY KEY,
    emp_name VARCHAR(30) NOT NULL,
    dept_title VARCHAR(30) DEFAULT '개발팀',
    hire_date DATE DEFAULT (current_date)
);

-- 1) 
INSERT INTO emp
VALUES(100, '강지원', '서비스개발팀', default);

-- 모든 컬럼 값을 지정하지 않아서 에러 발생
INSERT INTO emp
VALUES(200, '유지혁', '개발 지원팀');

-- 에러는 발생하지 않지만 데이터가 잘못 저장
INSERT INTO emp
VALUES(300, '유아지원팀', '박민환', default);

-- 데이터 타입이 맞지 않아서 에러 발생
INSERT INTO emp
VALUES('유아지원팀', 400, '정수민', default);

-- 2)
INSERT INTO emp(emp_id, emp_name, dept_title, hire_date)
VALUES(400, '백은호', '인사팀', NULL);

INSERT INTO emp(emp_name, dept_title, emp_id)
VALUES('양주란', '보안팀', 500);

INSERT INTO emp(emp_id, emp_name)
VALUES(600, '유희연');

-- emp_name 컬럼에 not null 제약조건으로 인해 에러 발생
INSERT INTO emp(emp_id, dept_title)
VALUES(700, '마케팅팀');

-- 3)
-- kh.employee 테이블에서 사번, 이름, 부서명, 입사일을 그대로 가지고오기

-- 컬럼명을 명시하면 순서가 상관이 없음
INSERT INTO emp(emp_name, emp_id, dept_title, hire_date)
SELECT emp_id, emp_name, dept_title, hire_date
FROM kh.employee
LEFT JOIN kh.department ON(dept_code = dept_id);

INSERT INTO emp 
SELECT emp_id,emp_name, dept_title, hire_date
FROM kh.employee
LEFT JOIN kh.department ON(dept_code = dept_id);

INSERT INTO emp 
SELECT emp_id,emp_name, dept_title, hire_date, dept_code
FROM kh.employee
LEFT JOIN kh.department ON(dept_code = dept_id);

ALTER TABLE emp
ADD dept_code CHAR(2);

SELECT * FROM emp;
DELETE FROM emp;

-- 테이블 구조만 복사
CREATE TABLE emp_dept
SELECT emp_id, emp_name, dept_code, hire_date
FROM kh.employee
WHERE 1=0;

CREATE TABLE emp_manager
SELECT emp_id, emp_name, manager_id
FROM kh.employee
WHERE 1=0;

-- emp_dept 테이블에 employee에서 부서 코드가 D1인 직원의 사번, 이름, 부서코드, 입사일 추가
INSERT INTO emp_dept
SELECT emp_id, emp_name, dept_code, hire_date
FROM kh.employee
WHERE dept_code = 'D1';

-- emp_manager 테이블에 employee에서 부서 코드가 D1인 직원의 사번, 이름, 관리자 사번을 추가
INSERT INTO emp_manager
SELECT emp_id, emp_name, manager_id
FROM kh.employee
WHERE dept_code = 'D1';

SELECT * FROM emp_dept;
SELECT * FROM emp_manager;

/*
	UPDATE
    - 테이블에 기록된 데이터를 수정하는 구문
    
    UPDATE 테이블명
    SET 컬럼명 = 변경하려는 값, 
		컬럼명 = 변경하려는 값,
        ...
	WHERE 조건;
    
    - SET 절에서 여러 개의 컬럼을 콤마(,)로 나열해서 값을 동시에 변경할 수 있다.
    - WHERE 절을 생략하면 모든 행의 데이터가 변경된다. (MySQL이 방지할수도 있음)
    - 사실 서브쿼리 사용 가능, 하지만 잘 쓰이지 않고 버전마다 상황이 다름
    
*/
SELECT * FROM dept_copy;
SELECT * FROM emp_salary;

START transaction;

-- emp_salary에서 선동일 사장의 급여를 7000000으로, 보너스를 0.2로 하락
UPDATE emp_salary
SET salary = 7000000,
	bonus = 0.2
WHERE emp_name = '선동일';

-- 모든 사원의 급여를 기존 급여에서 10프로 인상한 금액(기존급여*1.1)으로 변경
UPDATE emp_salary
SET salary = salary * 1.1;

-- 사번이 200인 사원의 사원번호를 null로 변경
UPDATE emp_salary
SET emp_id IS NULL
WHERE emp_id = 200;
-- > 해당 컬럼에 대한 제약조건이 위배되면 수정 X 

-- 아시아 지역에 근무하는 직원들의 보너스를 0.3으로 변경
UPDATE emp_salary
SET bonus = 0.3
WHERE emp_id IN(
				SELECT emp_id
				FROM kh.employee
					JOIN kh.department ON (dept_code = dept_id)
					JOIN kh.location ON (location_id = local_code)
				WHERE local_name LIKE 'ASIA%');

DESC emp_salary;

-- JOIN으로 묶으면 어떻게 보이는지 확인해보기
SELECT *
FROM kh.employee
	JOIN kh.department ON (dept_code = dept_id)
	JOIN kh.location ON (location_id = local_code)
WHERE local_name LIKE 'ASIA%';

ROLLBACK;

/*
	DELETE
    - 테이블에 기록된 데이터를 삭제하는 구문
    
    DELETE FROM 테이블명
    WHERE 조건식;
    
    - WHERE 절을 제시하지 않으면 전체 행이 삭제된다.
*/
-- emp_salary에서 dept_code가 D5인 직원들을 삭제
SELECT * FROM emp_salary;

DELETE FROM emp_salary
WHERE dept_code='D5';

ROLLBACK;

/*
	TRUNCATE 
	- 테이블의 전체 행을 삭제할 때 사용하는 구문
	- DELETE 보다 수행 속도가 더 빠르다.
    - 별도의 조건을 제시할 수 없고 ROLLBACK이 불가능하다.
    - DML과 관련된 것만 ROLLBACK 가능하다고 보면 됨
    
    TRUNCATE TABLE 테이블명;
*/
START transaction;

SELECT * FROM dept_copy;
SELECT * FROM emp_salary;

DELETE FROM dept_copy; -- DELETE는 ROLLBACK 가능
DELETE FROM emp_salary; -- DELETE는 ROLLBACK 가능
ROLLBACK; 

TRUNCATE TABLE dept_copy; -- TRUNCATE는 ROLLBACK 불가능
TRUNCATE TABLE emp_salary; -- TRUNCATE는 ROLLBACK 불가능

DROP TABLE dept_copy; -- DROP도 ROLLBACK 불가능
DROP TABLE emp_salary; -- DROP도 ROLLBACK 불가능




















