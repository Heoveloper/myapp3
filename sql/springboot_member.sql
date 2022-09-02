--��� ���̺�, ��� ������
drop table member;
drop sequence member_member_id_seq;

--���ΰ����� ���̵� ������
create sequence member_member_id_seq
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;

--ȸ�����̺�
create table member (
    member_id number(8) default member_member_id_seq.nextval,
    email varchar2(40),
    pw varchar2(10),
    nickname varchar2(30),
    cdate timestamp default systimestamp,
    udate timestamp default systimestamp
);

--primary key(���ΰ����� ���̵�)
alter table member
add constraint member_member_id_pk
primary key (member_id);

--unique
alter table member
add constraint member_email_un
unique (email);

--not null
alter table member
modify nickname constraint member_nickname_nn not null;
alter table member
modify cdate constraint member_cdate_nn not null;
alter table member
modify udate constraint member_udate_nn not null;

--����
insert into member (email, pw, nickname)
values ('wldus123@gmail.com', 'pw@dus123', '����');
insert into member (email, pw, nickname)
values ('wlsdnr123@gmail.com', 'pw@dnr123', '����'); 
insert into member (email, pw, nickname)
values ('tjdqls123@gmail.com', 'pw@qls123', '����'); 
insert into member (email, pw, nickname)
values ('rldnjs123@gmail.com', 'pw@njs123', '�⺰'); 
insert into member (email, pw, nickname)
values ('wnsgur123@gmail.com', 'pw@gur123', '�غ�');

--��ȸ
select member_id, email, pw, nickname, cdate, udate
from member
where email='wnsgur123@gmail.com';

--����
update member
set pw='pw@gur456',
    nickname='����',
    udate=systimestamp
where email='wnsgur123@gmail.com';

--���� �� Ȯ��
select *
from member;

--����
delete
from member
where email='wnsgur123@gmail.com';

--Ȯ��
select *
from member;

--ȸ����ȣ ����
select member_member_id_seq.nextval from dual;
select member_member_id_seq.nextval from dual;