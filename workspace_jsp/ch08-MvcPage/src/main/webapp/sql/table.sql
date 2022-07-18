--회원관리
create table zmember(
	mem_num number not null,
	id varchar2(12) unique not null,
	auth number(1) default 2 not null, --회원등급:0->탈퇴, 1->정지, 2->일반, 3->관리자
	constraint zmember_pk primary key (mem_num)
);

--회원관리 상세정보
create table zmember_detail(
	mem_num number not null,
	name varchar2(30) not null,
	passwd varchar2(12) not null,
	phone varchar2(15) not null,
	email varchar2(50) not null,
	zipcode varchar2(5) not null,
	address1 varchar2(90) not null,
	address2 varchar2(90) not null,
	photo varchar2(150),
	reg_date date default sysdate not null,
	modify_date date,
	constraint zmember_detail_pk primary key(mem_num),
	constraint zmember_detail_fk foreign key(mem_num) references zmember (mem_num)
);

create sequence zmember_seq;


--게시판
create table zboard(
 board_num number not null,
 title varchar2(150) not null,
 content clob not null,
 hit number(5) default 0 not null,
 reg_date date default sysdate not null,
 modify_date date,
 filename varchar2(150),
 ip varchar2(40) not null,
 mem_num number not null,
 constraint zboard_pk primary key (board_num),
 constraint zboard_fk foreign key (mem_num) references zmember (mem_num)
);

create sequence zboard_seq;

--게시판 좋아요

--게시판 댓글