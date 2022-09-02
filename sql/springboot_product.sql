--���̺�, ������ ���
DROP TABLE product;
DROP SEQUENCE product_product_id_seq;

--��ǰ��ȣ ������ ����
CREATE SEQUENCE product_product_id_seq;

--product ���̺� ����
CREATE TABLE product(
    product_id  NUMBER(10),
    pname       VARCHAR2(30),
    quantity    NUMBER(10),
    price       NUMBER(10)
);

--�⺻Ű
ALTER TABLE product
ADD CONSTRAINT product_product_id_pk
PRIMARY KEY(product_id);

--����--
INSERT INTO product(product_id,pname,quantity,price)
     VALUES(product_product_id_seq.nextval, '��ǻ��', 5, 1000000);

INSERT INTO product(product_id,pname,quantity,price)
     VALUES(product_product_id_seq.nextval, '�����', 3, 500000);

INSERT INTO product(product_id,pname,quantity,price)
     VALUES(product_product_id_seq.nextval, '������', 1, 300000);
     
commit;     

--��ȸ--
SELECT product_id, pname, quantity, price
  FROM product
 WHERE product_id = 2;
 
commit;

--����--
UPDATE product
   SET pname = '�÷�������',
       price = 700000
 WHERE pname = '������'; 

commit;

--����
DELETE
  FROM product
 WHERE product_id = 1;
 
rollback;

--��ü��ȸ-
SELECT product_id, pname, quantity, price
  FROM product;

commit;

--SELECT product_product_id_seq.currval
--FROM dual;
--SELECT 'm-' || product_product_id_seq.currval
--FROM dual;
--SELECT 'nm' || product_product_id_seq.currval
--FROM dual;