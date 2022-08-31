--등록
INSERT INTO product
VALUES (product_product_id_seq.nextval, '컴퓨터', 10, 1000000);

select * from product;

INSERT INTO product (product_id, pname, quantity, price)
VALUES (product_product_id_seq.nextval, '모니터', 20, 900000);

select * from product;
rollback;

--조회
SELECT product_id, pname, quantity, price
FROM product
WHERE product_id = 28;

select * from product;
commit;

--수정
UPDATE product
SET pname = '마우스패드',
quantity = 10,
price = 10000
WHERE product_id = 28;

select * from product;
commit;

--삭제
DELETE
FROM product
WHERE product_id = 27;
rollback;

--목록
SELECT product_id, pname, quantity, price
FROM product;

--
select * from product;
delete from product;
commit;
--

SELECT product_product_id_seq.currval
FROM dual;
SELECT 'm-' || product_product_id_seq.currval
FROM dual;
SELECT 'nm' || product_product_id_seq.currval
FROM dual;