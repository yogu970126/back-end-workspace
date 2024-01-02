-- Sakila : DVD 대여 및 영화 정보와 관련된 데이터 포함

-- 1. customer 테이블의 first_name이 TRACY인 사람들 조회 
SELECT country, city, address ,district, first_name, last_name
FROM customer
	JOIN address USING(address_id)
    JOIN city USING(city_id)
    JOIN country USING(country_id)
WHERE first_name = 'TRACY';

-- 2. 배우 JULIA MCQUEEN이 찍은 영화 제목 조회 (title 기준 정렬 10개까지)
-- JULIA MCQUEEN 의 actor_id
SELECT actor_id
FROM actor
WHERE (first_name, last_name) = ('JULIA','MCQUEEN');

-- JULIA MCQUEEN이 출연한 영화 조회
-- 서브쿼리 사용 
SELECT first_name, last_name, title
FROM film
	JOIN film_actor USING(film_id)
    JOIN actor USING(actor_id)
WHERE actor_id = (SELECT actor_id
					FROM actor
					WHERE (first_name, last_name) = ('JULIA','MCQUEEN'))
LIMIT 10;

-- JOIN 사용
SELECT first_name, last_name, title
FROM film
	JOIN film_actor USING(film_id)
    JOIN actor USING(actor_id)
WHERE (first_name, last_name) = (('JULIA'),('MCQUEEN'))
LIMIT 10;

-- 3. 영화 NOON PAPI에 나오는 배우들의 이름 조회
-- 'NOON PAPI'의 film_id 조회
SELECT *
FROM film
WHERE title = 'NOON PAPI';

-- 'NOON PAPI'의  actor_id 조회
SELECT actor_id
FROM film_actor
WHERE film_id = (SELECT film_id
					FROM film
					WHERE title = 'NOON PAPI');
-- 조회환 film_id와 actor_id를 결합하여 출연한 배우 조회
-- 서브쿼리 사용 
SELECT first_name, last_name
FROM actor
WHERE actor_id IN (SELECT actor_id FROM film_actor WHERE film_id = (SELECT film_id
																	FROM film
																	WHERE title = 'NOON PAPI'));
															
-- JOIN 사용
SELECT first_name, last_name
FROM actor
	JOIN film_actor USING(actor_id)
	JOIN film USING(film_id)
WHERE title = 'NOON PAPI';


SELECT * FROM category; -- 영화 카테고리 정보 : category_id
SELECT * FROM rental; -- DVD 대여 정보 : customer_id, inventory_id
SELECT * FROM inventory; -- DVD 대여점에서 관리하는 정보 : inventory_id, film_id
SELECT * FROM customer; -- DVD 대여 고객 정보 : customer_id, address_id
SELECT * FROM film; -- 영화 정보 : film_id
SELECT * FROM actor; -- 영화 배우 정보 : actor_id

SELECT * FROM film_category; -- film과 category 연결 : film_id, category_id
SELECT * FROM film_actor; -- film과 actor 연결 : film_id, actor_id

SELECT * FROM address; -- 고객 주소 정보 : address_id, city_id, address, district
SELECT * FROM city; -- city_id, country_id, city
SELECT * FROM country; -- country_id, country


-- 4. 각 카테고리별 이메일이 JOYCE.EDWARDS@sakilacustomer.org인 고객이 빌린 DVD 대여 수 조회 
-- id 검색  


-- 5. 이메일이 JOYCE.EDWARDS@sakilacustomer.org인 고객이 가장 최근에 빌린 영화 제목과 영화 내용을 조회
-- JOYCE.EDWARDS@sakilacustomer.org 가 빌린 영화 렌탈 목록
SELECT title, description, rental_date
FROM film
JOIN inventory USING(film_id)
JOIN rental  USING(inventory_id)
JOIN customer USING(customer_id)
WHERE email ='JOYCE.EDWARDS@sakilacustomer.org'
ORDER BY 3 DESC
LIMIT 1;





