--drop
drop table member;
drop sequence product_product_id_seq;

--product 테이블 생성
create table product(
    product_id  NUMBER(10),
    pname       VARCHAR2(30),
    quantity    NUMBER(10),
    price       NUMBER(10)
);
--primary key
alter table product add constraint product_product_id_pk primary key (product_id);

--상품번호 시퀀스 생성
create sequence product_product_id_seq;

--생성 (create)
insert into product (product_id, pname, quantity, price)
values (product_product_id_seq.nextval, '컴퓨터', 5, 1000000);
insert into product (product_id, pname, quantity, price)
values (product_product_id_seq.nextval, '모니터', 3, 500000);
insert into product (product_id, pname, quantity, price)
values (product_product_id_seq.nextval, '프린터', 1, 300000);

--조회 (read)
select product_id, pname, quantity, price
  from product
 where product_id = 2;
 
--수정 (update)
update product
   set pname = '컬러프린터',
       price = 200000
 where pname = '프린터';
--commit
commit;  

--삭제 (delete)
delete from product
 where product_id = '3';
--rollback
rollback;

--상품목록 조회
select product_id, pname, quantity, price
  from product;

--SELECT product_product_id_seq.currval
--FROM dual;
--SELECT 'm-' || product_product_id_seq.currval
--FROM dual;
--SELECT 'nm' || product_product_id_seq.currval
--FROM dual;