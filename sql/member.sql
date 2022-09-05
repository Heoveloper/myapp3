--drop
drop table member;
drop sequence member_member_id_seq;

--member Å×ÀÌºí »ý¼º
create table member (
    member_id   number(8),
    email       varchar2(40),
    pw          varchar2(10),
    nickname    varchar2(30),
    cdate       timestamp default systimestamp,
    udate       timestamp default systimestamp
);
--primary key
alter table member add constraint member_member_id_pk primary key (member_id);
--unique
alter table member add constraint member_email_un unique (email);
--not null
alter table member modify nickname constraint member_nickname_nn not null;
alter table member modify cdate constraint member_cdate_nn not null;
alter table member modify udate constraint member_udate_nn not null;

--È¸ï¿½ï¿½ï¿½ï¿½È£ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
create sequence member_member_id_seq;

--»ý¼º (create)
insert into member (member_id, email, pw, nickname)
values (member_member_id_seq.nextval, 'test1@test.com', '1234', 'º°Äª1');
insert into member (member_id, email, pw, nickname)
values (member_member_id_seq.nextval, 'test2@test.com', '1234', 'º°Äª2');
insert into member (member_id, email, pw, nickname)
values (member_member_id_seq.nextval, 'test3@test.com', '1234', 'º°Äª3');

--Á¶È¸ (read)
select member_id, email, pw, nickname, cdate, udate
  from member
 where member_id = '2';

--¼öÁ¤ (update)
update member
   set nickname = 'º°Äª22',
       udate = systimestamp
 where member_id = '2'
   and pw = 5678;
--commit
commit; 

--»èÁ¦ (delete)
delete from member
 where member_id = '2';
--rollback
rollback;

--È¸¿ø¸ñ·Ï Á¶È¸
select * from member;

--È¸¿ø¹øÈ£ »ý¼º
--select member_member_id_seq.nextval from dual;
--select member_member_id_seq.currval from dual;