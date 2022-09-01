DROP TABLE product;
CREATE TABLE product(
    product_id  NUMBER(10),
    pname       VARCHAR2(30),
    quantity    NUMBER(10),
    price       NUMBER(10)
);
--기본키
ALTER TABLE product ADD CONSTRAINT product_product_id_pk PRIMARY KEY(product_id);

--시퀀스생성
DROP SEQUENCE product_product_id_seq;
CREATE SEQUENCE product_product_id_seq;


--생성--
INSERT INTO product(product_id,pname,quantity,price)
     VALUES(product_product_id_seq.nextval, '컴퓨터', 5, 1000000);

INSERT INTO product(product_id,pname,quantity,price)
     VALUES(product_product_id_seq.nextval, '모니터', 5, 500000);

INSERT INTO product(product_id,pname,quantity,price)
     VALUES(product_product_id_seq.nextval, '프린터', 1, 300000);

--조회--
SELECT product_id, pname, quantity, price
  FROM product
 WHERE product_id = 2;

--수정--
UPDATE product
   SET pname = '컴퓨터2',
       quantity = 10,
       price = 1200000;

--삭제
DELETE FROM product WHERE product_id = 1;

--전체조회-
SELECT product_id,pname,quantity,price FROM product;

commit;