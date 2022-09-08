--drop
drop table member;
drop sequence member_member_id_seq;

--member 테이블 생성
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
alter table member modify email constraint member_email_nn not null;
alter table member modify pw constraint member_pw_nn not null;
alter table member modify cdate constraint member_cdate_nn not null;
alter table member modify udate constraint member_udate_nn not null;

--회원번호 시퀀스 생성
create sequence member_member_id_seq;

--생성 (create)
insert into member (member_id, email, pw, nickname)
values (member_member_id_seq.nextval, 'test1@test.com', '1234', '별칭1');
insert into member (member_id, email, pw, nickname)
values (member_member_id_seq.nextval, 'test2@test.com', '1234', '별칭2');
insert into member (member_id, email, pw, nickname)
values (member_member_id_seq.nextval, 'test3@test.com', '1234', '별칭3');

--조회 (read)
select member_id, email, pw, nickname, cdate, udate
  from member
 where member_id = '2';

--수정 (update)
update member
   set nickname = '별칭22',
       udate = systimestamp
 where member_id = '2'
   and pw = 5678;
--commit
commit; 

--삭제 (delete)
delete from member
 where member_id = '2';
--rollback
rollback;

--회원목록 조회
select * from member;

--회원번호 생성
--select member_member_id_seq.nextval from dual;
--select member_member_id_seq.currval from dual;