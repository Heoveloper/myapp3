DROP TABLE product;
CREATE TABLE product(
    product_id  NUMBER(10),
    pname       VARCHAR2(30),
    quantity    NUMBER(10),
    price       NUMBER(10)
);
--�⺻Ű
ALTER TABLE product ADD CONSTRAINT product_product_id_pk PRIMARY KEY(product_id);

--����������
DROP SEQUENCE product_product_id_seq;
CREATE SEQUENCE product_product_id_seq;


--����--
INSERT INTO product(product_id,pname,quantity,price)
     VALUES(product_product_id_seq.nextval, '��ǻ��', 5, 1000000);

INSERT INTO product(product_id,pname,quantity,price)
     VALUES(product_product_id_seq.nextval, '�����', 5, 500000);

INSERT INTO product(product_id,pname,quantity,price)
     VALUES(product_product_id_seq.nextval, '������', 1, 300000);

--��ȸ--
SELECT product_id, pname, quantity, price
  FROM product
 WHERE product_id = 2;

--����--
UPDATE product
   SET pname = '��ǻ��2',
       quantity = 10,
       price = 1200000;

--����
DELETE FROM product WHERE product_id = 1;

--��ü��ȸ-
SELECT product_id,pname,quantity,price FROM product;

commit;