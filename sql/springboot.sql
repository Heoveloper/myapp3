--���
INSERT INTO product
VALUES (product_product_id_seq.nextval, '��ǻ��', 10, 1000000);

select * from product;

INSERT INTO product (product_id, pname, quantity, price)
VALUES (product_product_id_seq.nextval, '�����', 20, 900000);

select * from product;
rollback;

--��ȸ
SELECT product_id, pname, quantity, price
FROM product
WHERE product_id = 28;

select * from product;
commit;

--����
UPDATE product
SET pname = '���콺�е�',
quantity = 10,
price = 10000
WHERE product_id = 28;

select * from product;
commit;

--����
DELETE
FROM product
WHERE product_id = 27;
rollback;

--���
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