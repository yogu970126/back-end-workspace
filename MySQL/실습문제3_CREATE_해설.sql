CREATE SCHEMA Library2;

CREATE TABLE tb_publisher(
	pub_no INT AUTO_INCREMENT PRIMARY KEY,
    pub_name VARCHAR(20) NOT NULL,
    phone VARCHAR(13) 
);

CREATE TABLE tb_book(
	bk_no INT AUTO_INCREMENT PRIMARY KEY,
    bk_title VARCHAR(50) NOT NULL,
    bk_author VARCHAR(20) NOT NULL,
    bk_price INT,
    pub_no INT
);

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

CREATE TABLE tb_rent(
	rent_no INT AUTO_INCREMENT PRIMARY KEY,
    member_no INT, 
    bk_no INT, 
    rent_date DATE DEFAULT(current_date)
);

INSERT INTO tb_rent VALUES(1, 1, 2, default);
INSERT INTO tb_rent VALUES(2, 1, 3, default);
INSERT INTO tb_rent VALUES(3, 2, 1, default);
INSERT INTO tb_rent VALUES(4, 2, 2, default);
INSERT INTO tb_rent VALUES(5, 1, 5, default);

SELECT * FROM tb_rent;