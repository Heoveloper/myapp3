--드랍 테이블, 드랍 시퀀스
drop table member;
drop sequence member_member_id_seq;

--내부관리용 아이디 시퀀스
create sequence member_member_id_seq
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;

--회원테이블
create table member (
    member_id number(8) default member_member_id_seq.nextval,
    email varchar2(40),
    pw varchar2(10),
    nickname varchar2(30),
    cdate timestamp default systimestamp,
    udate timestamp default systimestamp
);

--primary key(내부관리용 아이디)
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

--생성
insert into member (email, pw, nickname)
values ('wldus123@gmail.com', 'pw@dus123', '지별');
insert into member (email, pw, nickname)
values ('wlsdnr123@gmail.com', 'pw@dnr123', '진별'); 
insert into member (email, pw, nickname)
values ('tjdqls123@gmail.com', 'pw@qls123', '성별'); 
insert into member (email, pw, nickname)
values ('rldnjs123@gmail.com', 'pw@njs123', '기별'); 
insert into member (email, pw, nickname)
values ('wnsgur123@gmail.com', 'pw@gur123', '준별');

--조회
select member_id, email, pw, nickname, cdate, udate
from member
where email='wnsgur123@gmail.com';

--수정
update member
set pw='pw@gur456',
    nickname='허준',
    udate=systimestamp
where email='wnsgur123@gmail.com';

--삭제 전 확인
select *
from member;

--삭제
delete
from member
where email='wnsgur123@gmail.com';

--확인
select *
from member;

--회원번호 생성
select member_member_id_seq.nextval from dual;
select member_member_id_seq.nextval from dual;