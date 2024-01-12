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

-- 위의 사원들 이외의 사원들 조회
-- 논리부정연산자 : NOT (NOT의 위치는 어느정도 자유가 있다)
SELECT emp_id, emp_name, email
FROM employee
WHERE email NOT LIKE '___$_%' ESCAPE '$';

-- eMployee 테이블에 직급코드(job_code) 중복없이 조회
SELECT DISTINCT job_code
FROM employee
ORDER BY 1;

-- 실습문제 ------------------------------
-- 1. 직급코드가(job_code) J7 이거나 J2인 사원들 중 급여가 200만원 이상인 사원들의 모든 컬럼 조회
SELECT *
FROM employee
WHERE job_code IN ('J7', 'J2') AND salary >= 2000000;

-- 2. 사수가 없고 부서배치도 받지 않은 사원들의 사원명, 사수사번(manager_id), 부서코드 조회 
SELECT emp_name, manager_id, dept_code
FROM employee
WHERE dept_code IS NULL AND manager_id IS NULL;

-- 3. 연봉(보너스포함x)이 3000만원 이상이고 보너스를 받지 않은 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT emp_id, emp_name, salary, bonus
FROM employee
WHERE (salary * 12) >= 30000000 AND bonus IS NULL;
-- 4. 입사일이 '1995-01-01' 이상이고 부서배치를 받은 사원들의 사번, 사원명, 입사일, 부서코드 조회
SELECT emp_id, emp_name, hire_date, dept_code
FROM employee
WHERE hire_date >= '1995-01-01' AND dept_code IS NOT NULL;

-- 5. 급여가 200만원 이상이고 500만원 이하고 입사일이 '2001-01-01' 이상이고 
--    보너스를 받지 않는 사원들의  사번, 사원명, 급여, 입사일, 보너스 조회
SELECT emp_id, emp_name, salary, hire_date, bonus
FROM employee
WHERE salary BETWEEN 2000000 AND 5000000
AND hire_date >= '2001-01-01'
AND bonus IS NULL;

-- 6. 보너스 포함 연봉이 NULL이 아니고 이름에 '하'가 
--    포함되어 있는 사원들의 사번, 사원명, 급여, 보너스 포함 연봉 조회(별칭 사용)
--    보너스 포함 연봉 : (SALARY + SALARY * BONUS) * 12
SELECT emp_id, emp_name, salary, (salary + salary * bonus) * 12 as '연봉'
FROM employee
WHERE (salary + salary * bonus) * 12 IS NOT NULL
AND emp_name LIKE '%하%';
-- WHERE 절에는 별칭 사용 불가

SELECT *
FROM employee;
-- 연봉이 높은 다섯 명의 사원의 사원명, 급여 조회
SELECT emp_name, salary
FROM employee
ORDER BY 2 DESC
LIMIT 5; 

-- 연봉이 높은 순에서 6등부터 10등까지 5명 조회
SELECT emp_name, salary
FROM employee
ORDER BY 2 DESC
LIMIT 5, 5;

-- 사원명, 사원명의 글자수, 이메일, 이메일의 글자수 조회
SELECT emp_name , char_length(emp_name), email, char_length(email)
FROM employee;

-- 's'가 포함되어 있는 이메일 중 이메일, 이메일의 @ 위치 조회
SELECT email ,INSTR(email, '@') as '@의 위치'
FROM employee
WHERE email LIKE '%s%';


SELECT *
FROM employee;
-- 종합 실습 문제 ---------------------------------------------------
-- 1. 직급이 대리면서 ASIA 지역에서 근무하는 직원들의
--    사번, 직원명, 직급명, 부서명, 근무지역, 급여를 조회
SELECT emp_id, emp_name, job_name, dept_title, salary
FROM employee
JOIN job USING(job_code)
JOIN department ON(dept_code = dept_id)
JOIN location ON(local_code = location_id)
WHERE job_name = '대리' 
AND local_name LIKE '%ASIA%';

-- 2. 70년대생 이면서 여자이고, 성이 전 씨인 직원들의 직원명, 주민번호, 부서명, 직급명 조회
SELECT emp_name, emp_no, dept_title, job_name
FROM employee
JOIN department ON(dept_code = dept_id)
JOIN job USING(job_code)
WHERE substr(emp_no, 1, 2) LIKE '7%'
AND substr(emp_no,8,1) = 2
AND emp_name LIKE '전%';

-- 3. 보너스를 받은 직원들의 직원명, 보너스, 연봉, 부서명, 근무지역 조회
--    단, 부서 코드가 없는 사원도 출력될 수 있게! OUTER JOIN 사용!
SELECT emp_name, bonus, salary*12 as '연봉', dept_title, local_name
FROM employee
LEFT JOIN department ON(dept_code = dept_id)
LEFT JOIN location ON(location_id = local_code)
WHERE bonus IS NOT NULL;

-- 4. 한국과 일본에서 근무하는 직원들의 직원명, 부서명, 근무지역, 근무 국가를 조회
SELECT emp_name, dept_title, local_name, national_name
FROM employee
JOIN department ON(dept_code = dept_id)
JOIN location ON(location_id = local_code)
JOIN national USING(national_code)
WHERE national_name IN('한국','일본');

-- 5. 각 부서별 평균 급여를 조회하여 부서명, 평균 급여(format 사용)를 조회
--    단, 부서 코드가 없는 사원들의 평균도 같이 나오게끔! OUTER JOIN 필요
SELECT dept_title, format(AVG(ifnull(salary,0)),0)
FROM employee
LEFT JOIN department ON(dept_code = dept_id)
GROUP BY dept_code;

-- 6. 각 부서별 총 급여의 합이 1000만원 이상인 부서명, 급여의 합을 조회  ------------------다시보기-------------------
SELECT dept_title, SUM(salary)
FROM employee
JOIN department ON(dept_code = dept_id)
GROUP BY dept_code
HAVING SUM(salary) >= 10000000;
-- 그룹함수 조건 걸때는 having


-- 7. 사번, 직원명, 직급명, 급여 등급, 구분을 조회                  ------------------다시보기-------------------
--    이때 구분에 해당하는 값은 아래와 같이 조회 되도록!
--    급여 등급이 S1, S2인 경우 '고급'
--    급여 등급이 S3, S4인 경우 '중급'
--    급여 등급이 S5, S6인 경우 '초급'
SELECT emp_id, emp_name, job_name, sal_level, 
		CASE WHEN sal_level IN ('S1', 'S2') THEN '고급'
			 WHEN sal_level IN ('S3', 'S4') THEN '중급'
             ELSE '초급'
             END AS '구분'
FROM employee
JOIN job USING(job_code)
JOIN sal_grade ON (salary between min_sal AND max_sal);

-- 8. 보너스를 받지 않은 직원들 중 직급 코드가 J4 또는 J7인 직원들의 직원명, 직급명, 급여를 조회
SELECT emp_name, job_name, salary
FROM employee
JOIN job USING(job_code)
WHERE bonus IS NULL
AND job_code IN ('J4', 'J7');

SELECT * FROM employee;
SELECT * FROM department;
SELECT * FROM job;
SELECT * FROM location;
SELECT * FROM national;
SELECT * FROM sal_grade;

-- 9. 부서가 있는 직원들의 직원명, 직급명, 부서명, 근무 지역을 조회
SELECT emp_name, job_name, dept_title, local_name
FROM employee
JOIN job USING(job_code)
JOIN department ON(dept_code = dept_id)
JOIN location ON(local_code = location_id);

-- 10. 해외영업팀에 근무하는 직원들의 직원명, 직급명, 부서코드, 부서명을 조회
SELECT emp_name, job_name, dept_code, dept_title
FROM employee
JOIN job USING(job_code)
JOIN department ON(dept_code = dept_id)
WHERE dept_title LIKE '해외영업%';

-- 11. 이름에 '형'자가 들어있는 직원들의 사번, 직원명, 직급명을 조회
SELECT emp_id, emp_name, job_name
FROM employee
JOIN job USING(job_code)
WHERE emp_name LIKE '%형%';

-- 실습 문제
-- 도서관리 프로그램을 만들기 위한 테이블 만들기

CREATE schema practice;
-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블(TB_PUBLISHER) 
--    컬럼 : pub_no(출판사번호) -- 기본 키
--           pub_name(출판사명) -- NOT NULL
--           phone(전화번호)
CREATE TABLE TB_PUBLISHER (
	pub_no INT auto_increment PRIMARY KEY,
    pub_name VARCHAR(20) NOT NULL,
    phone VARCHAR(20)
);
INSERT INTO TB_PUBLISHER(pub_name, phone) VALUES('천그루숲', '010-8748-0784');
INSERT INTO TB_PUBLISHER(pub_name, phone) VALUES('골든래빗', '0505-398-0505');
INSERT INTO TB_PUBLISHER(pub_name, phone) VALUES('윌북', '031-955-3777');

-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블 (tb_book)
--    컬럼 : bk_no (도서번호) -- 기본 키
--           bk_title (도서명) -- NOT NULL
--           bk_author(저자명) -- NOT NULL
--           bk_price(가격)
--           bk_pub_no(출판사 번호) -- 외래 키(tb_publisher 테이블을 참조하도록)
--    조건 : 이때 참조하고 있는 부모 데이터 삭제 시 자식 데이터도 삭제 되도록 옵션 지정
SELECT * FROM tb_book;
DROP TABLE tb_book;
CREATE TABLE tb_book (
	bk_no INT auto_increment PRIMARY KEY,
    bk_title VARCHAR(20) NOT NULL,
    bk_author VARCHAR(20) NOT NULL,
    bk_price INT,
    bk_pub_no INT,
    FOREIGN KEY(bk_pub_no) REFERENCES TB_PUBLISHER(pub_no) ON DELETE CASCADE
);

INSERT INTO tb_book VALUES(6,'집에 갈래', '끄아앙', 36000, 3);

UPDATE tb_book
SET bk_title = '집에 갈래 2'
WHERE bk_title = '집에 갈래';

DELETE FROM tb_book
WHERE bk_title = '집에 갈래 2';


INSERT INTO tb_book(bk_title, bk_author, bk_price, bk_pub_no) VALUES('오늘부터 개발자', '김병욱', 16800, 1);
INSERT INTO tb_book(bk_title, bk_author, bk_price, bk_pub_no) VALUES('요즘 우아한 개발', '우아한 형제들', 24000, 2);
INSERT INTO tb_book(bk_title, bk_author, bk_price, bk_pub_no) VALUES('프로덕트 매니저 원칙', '장홍석', 22000, 2);
INSERT INTO tb_book(bk_title, bk_author, bk_price, bk_pub_no) VALUES('코딩 좀 아는 사람', '제러미 키신', 17800, 3);
INSERT INTO tb_book(bk_title, bk_author, bk_price, bk_pub_no) VALUES('그렇게 쓰면 아무도 안 읽습니다', '전주경', 19800, 3);


-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블 (tb_member)
--    컬럼 : member_no(회원번호) -- 기본 키
--           member_id(아이디)   -- 중복 금지
--           member_pwd(비밀번호) -- NOT NULL
--           member_name(회원명) -- NOT NULL
--           gender(성별)        -- 'M' 또는 'F'로 입력되도록 제한
--           address(주소)       
--           phone(연락처)       
--           status(탈퇴여부)     -- 기본값 'N' / 'Y' 혹은 'N'만 입력되도록 제약조건
--           enroll_date(가입일)  -- 기본값 현재날짜
SELECT * FROM tb_member;
DROP TABLE tb_member;

CREATE TABLE tb_member (
	member_no INT auto_increment PRIMARY KEY,
    member_id VARCHAR(20) UNIQUE,
    member_pwd VARCHAR(20) NOT NULL,
    member_name VARCHAR(10) NOT NULL,
    gender VARCHAR(1) CHECK(gender IN('M', 'F')) NOT NULL,
    address VARCHAR(50),
    phone VARCHAR(20),
    status CHAR(1) CHECK(status IN('N','Y')) DEFAULT 'N',
    enroll_date DATE DEFAULT(current_date)
);
INSERT INTO tb_member(member_id, member_pwd, member_name, gender, address, phone)
	   VALUES('user01', 'pass01', '홍길동', 'M', '서울시 강서구', '010-1111-2222');
INSERT INTO tb_member(member_id, member_pwd, member_name, gender, address, phone)
	   VALUES('user02', 'pass02', '김말똥', 'M', '서울시 강남구', '010-3333-4444');
INSERT INTO tb_member(member_id, member_pwd, member_name, gender, address, phone)
	   VALUES('user03', 'pass03', '강길순', 'F', '경기도 광주시', '010-4444-5555');

-- 4. 도서를 대여한 회원에 대한 데이터를 담기 위한 대여 목록 테이블(tb_rent)
--    컬럼 : rent_no(대여번호) -- 기본 키
--           rent_mem_no(대여 회원번호) -- 외래 키(tb_member와 참조)
--           rent_book_no(대여 도서번호) -- 외래 키(tb_book와 참조)
--           rent_date(대여일) -- 기본값 현재날짜
--    조건 : 이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정
SELECT * FROM tb_rent;
DROP TABLE tb_rent;

CREATE TABLE tb_rent (
	rent_no INT PRIMARY KEY,
    rent_mem_no INT,
    rent_book_no INT,
    rent_date DATE DEFAULT(current_date),
    FOREIGN KEY (rent_mem_no) REFERENCES tb_member(member_no) ON DELETE SET NULL,
    FOREIGN KEY (rent_book_no) REFERENCES tb_book(bk_no) ON DELETE SET NULL
);

INSERT INTO tb_rent VALUES(1, 1, 2, default);
INSERT INTO tb_rent VALUES(2, 1, 3, default);
INSERT INTO tb_rent VALUES(3, 2, 1, default);
INSERT INTO tb_rent VALUES(4, 2, 2, default);
INSERT INTO tb_rent VALUES(5, 1, 5, default);



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
SELECT * FROM tb_rent;

UPDATE tb_rent
SET rent_date = '2000-10-10'
WHERE rent_no = 1;

DELETE FROM tb_rent
WHERE rent_date = '2000-10-10';

/*
	DELETE
    - 테이블에 기록된 데이터를 삭제하는 구문
    
    DELETE FROM 테이블명
    WHERE 조건식;
    
    - WHERE 절을 제시하지 않으면 전체 행이 삭제된다.
*/

-- 5. 2번 도서를 대여한 회원의 이름, 아이디, 대여일, 반납 예정일(대여일 + 7일)을 조회하시오.


-- 6. 회원번호가 1번인 회원이 대여한 도서들의 도서명, 출판사명, 대여일, 반납예정일을 조회하시오.

-- 부서별 평균 급여가 300만원 이상인 부서의 평균 급여 조회
SELECT dept_code ,format(avg(ifnull(salary,0)),0) as '평균 급여'
FROM employee
GROUP BY dept_code
HAVING avg(ifnull(salary,0)) >= 3000000;

-- 직급별 총 급여의 합이 1000만원 이상인 직급만 조회
SELECT job_code, SUM(salary)
FROM employee
GROUP BY job_code
HAVING SUM(salary) >= 10000000;

-- 부서별 보너스를 받는 사원이 없는 부서만 조회
SELECT dept_code , count(bonus)
FROM employee
GROUP BY dept_code
HAVING count(bonus) = 0;

