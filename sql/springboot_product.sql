--테이블, 시퀀스 드랍
DROP TABLE product;
DROP SEQUENCE product_product_id_seq;

--상품번호 시퀀스 생성
CREATE SEQUENCE product_product_id_seq;

--product 테이블 생성
CREATE TABLE product(
    product_id  NUMBER(10),
    pname       VARCHAR2(30),
    quantity    NUMBER(10),
    price       NUMBER(10)
);

--기본키
ALTER TABLE product
ADD CONSTRAINT product_product_id_pk
PRIMARY KEY(product_id);

--생성--
INSERT INTO product(product_id,pname,quantity,price)
     VALUES(product_product_id_seq.nextval, '컴퓨터', 5, 1000000);

INSERT INTO product(product_id,pname,quantity,price)
     VALUES(product_product_id_seq.nextval, '모니터', 3, 500000);

INSERT INTO product(product_id,pname,quantity,price)
     VALUES(product_product_id_seq.nextval, '프린터', 1, 300000);
     
commit;     

--조회--
SELECT product_id, pname, quantity, price
  FROM product
 WHERE product_id = 2;
 
commit;

--수정--
UPDATE product
   SET pname = '컬러프린터',
       price = 700000
 WHERE pname = '프린터'; 

commit;

--삭제
DELETE
  FROM product
 WHERE product_id = 1;
 
rollback;

--전체조회-
SELECT product_id, pname, quantity, price
  FROM product;

commit;

--SELECT product_product_id_seq.currval
--FROM dual;
--SELECT 'm-' || product_product_id_seq.currval
--FROM dual;
--SELECT 'nm' || product_product_id_seq.currval
--FROM dual;