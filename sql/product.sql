--drop
drop table member;
drop sequence product_product_id_seq;

--product ���̺� ����
create table product(
    product_id  NUMBER(10),
    pname       VARCHAR2(30),
    quantity    NUMBER(10),
    price       NUMBER(10)
);
--primary key
alter table product add constraint product_product_id_pk primary key (product_id);

--��ǰ��ȣ ������ ����
create sequence product_product_id_seq;

--���� (create)
insert into product (product_id, pname, quantity, price)
values (product_product_id_seq.nextval, '��ǻ��', 5, 1000000);
insert into product (product_id, pname, quantity, price)
values (product_product_id_seq.nextval, '�����', 3, 500000);
insert into product (product_id, pname, quantity, price)
values (product_product_id_seq.nextval, '������', 1, 300000);

--��ȸ (read)
select product_id, pname, quantity, price
  from product
 where product_id = 2;
 
--���� (update)
update product
   set pname = '�÷�������',
       price = 200000
 where pname = '������';
--commit
commit;  

--���� (delete)
delete from product
 where product_id = '3';
--rollback
rollback;

--��ǰ��� ��ȸ
select product_id, pname, quantity, price
  from product;

--SELECT product_product_id_seq.currval
--FROM dual;
--SELECT 'm-' || product_product_id_seq.currval
--FROM dual;
--SELECT 'nm' || product_product_id_seq.currval
--FROM dual;