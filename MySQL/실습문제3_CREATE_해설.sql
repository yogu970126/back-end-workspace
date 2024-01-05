CREATE SCHEMA Library2;
DROP TABLE tb_rent;
DROP TABLE tb_member;
DROP TABLE tb_book;
DROP TABLE tb_publisher;

CREATE TABLE tb_publisher(
	pub_no INT AUTO_INCREMENT PRIMARY KEY,
    pub_name VARCHAR(20) NOT NULL,
    phone VARCHAR(13) 
);
INSERT INTO tb_publisher(pub_name, phone) VALUES( '천그루숲', '010-8748-0784');
INSERT INTO tb_publisher(pub_name, phone) VALUES( '골든래빗', '0505-398-0505');
INSERT INTO tb_publisher(pub_name, phone) VALUES( '천그루숲', '031-955-3777');

CREATE TABLE tb_book(
	bk_no INT AUTO_INCREMENT PRIMARY KEY,
    bk_title VARCHAR(50) NOT NULL,
    bk_author VARCHAR(20) NOT NULL,
    bk_price INT,
    pub_no INT
);
INSERT INTO tb_book(bk_title, bk_author, bk_price, pub_no) VALUES('오늘부터 개발자', '김병욱', 16800, 1);
INSERT INTO tb_book(bk_title, bk_author, bk_price, pub_no) VALUES('요즘 우아한 개발', '우아한 형제들', 24000, 2);
INSERT INTO tb_book(bk_title, bk_author, bk_price, pub_no) VALUES('프로덕트 매니저 원칙', '장홍석', 22000, 2);
INSERT INTO tb_book(bk_title, bk_author, bk_price, pub_no) VALUES('코딩 좀 아는 사람', '제러미 키신', 17800, 3);
INSERT INTO tb_book(bk_title, bk_author, bk_price, pub_no) VALUES('그렇게 쓰면 아무도 안 읽습니다', '전주경', 19800, 3);



CREATE TABLE tb_member(
	member_no INT AUTO_INCREMENT PRIMARY KEY,
    member_id VARCHAR(30) UNIQUE NOT NULL,
    member_pwd VARCHAR(30) NOT NULL,
    member_name VARCHAR(30) NOT NULL,
    gender VARCHAR(1) CHECK(gender IN('M','F')) NOT NULL,
    address VARCHAR(20),
    phone VARCHAR(20),
    status VARCHAR(1) CHECK(status IN ('Y', 'N')) DEFAULT 'N',
    enroll_date DATE DEFAULT(current_date)    
);
INSERT INTO tb_member (member_id, member_pwd, member_name, gender, address, phone)
VALUES('user01', 'pass01', '홍길동', 'M', '서울시 강서구', '010-1111-2222');
INSERT INTO tb_member (member_id, member_pwd, member_name, gender, address, phone)
VALUES('user02', 'pass02', '김말똥', 'M', '서울시 강남구', '010-3333-4444');
INSERT INTO tb_member (member_id, member_pwd, member_name, gender, address, phone)
VALUES('user03', 'pass03', '강길순', 'F', '경기도 광주시', '010-4444-5555');



CREATE TABLE tb_rent(
	rent_no INT AUTO_INCREMENT PRIMARY KEY,
    member_no INT, 
    bk_no INT, 
    rent_date DATE DEFAULT(current_date)
);

ALTER TABLE tb_book ADD CONSTRAINT pub_no_fk
	FOREIGN KEY (pub_no) REFERENCES tb_publisher(pub_no);
ALTER TABLE tb_rent ADD CONSTRAINT member_no_fk
	FOREIGN KEY(member_no) REFERENCES tb_member(member_no);
ALTER TABLE tb_rent ADD CONSTRAINT bk_no_fk
	FOREIGN KEY(bk_no) REFERENCES tb_book(bk_no);

INSERT INTO tb_rent VALUES(1, 1, 2, default);
INSERT INTO tb_rent VALUES(2, 1, 3, default);
INSERT INTO tb_rent VALUES(3, 2, 1, default);
INSERT INTO tb_rent VALUES(4, 2, 2, default);
INSERT INTO tb_rent VALUES(5, 1, 5, default);

SELECT * FROM tb_rent;

-- 5. 2번 도서를 대여한 회원의 이름, 아이디, 대여일, 반납 예정일(대여일 + 7일)을 조회하시오.
SELECT member_name as '회원 이름', 
	   member_id as '아이디', 
       rent_date as '대여일', 
       adddate(rent_date, INTERVAL 7 DAY) as '반납 예정일'
FROM tb_rent
	JOIN tb_member USING(member_no)
WHERE bk_no = 2;

-- 6. 회원번호가 1번인 회원이 대여한 도서들의 도서명, 출판사명, 대여일, 반납예정일을 조회하시오.
SELECT bk_title as '도서명',
	   pub_name as '출판사명',
       rent_date as '대여일',
       adddate(rent_date, 7) as '반납 예정일'
FROM tb_rent
	JOIN tb_book USING(bk_no)
    JOIN tb_publisher USING(pub_no)
WHERE member_no = 1;





