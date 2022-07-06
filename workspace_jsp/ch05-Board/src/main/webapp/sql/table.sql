--게시판
create table mboard(
	num number primary key,
	title varchar2(150) not null,
	name varchar2(30) not null,
	passwd varchar2(12) not null,
	content clob not null,
	ip varchar2(30) not null,
	reg_date date not null
);

create sequence mboard_seq;

--페이징
--SELECT rownum, num, name, content FROM mboard ORDER BY num DESC (X)
-- -> rownum을 포함해서 정렬하면 rownum이 뒤죽박죽 설정되기 때문에 서브쿼리 이용 : 정렬이된 결과행에 rownum 설정

--SELECT *, rownum rnum FROM (SELECT * FROM mboard ORDER BY num DESC)  (X)
--SELECT a.*, rownum rnum FROM (SELECT * FROM mboard ORDER BY num DESC) a
-- -> *를 사용할때 컬럼을 따로 지정할 수 없기때문에 alias 부여

--alias는 where절에서 사용 불가 -> rnum을 일반컬럼으로 인식하게 만드는 방법 : 서브쿼리속 alias는 본 쿼리에서 컬럼으로 인식

--등록된 게시글을 내림차순으로 정렬하고, 그 정렬을 기준으로 모든행에 rownum을 부여하고
--지정된 rownum 범위의 결과행의 모든 컬럼을 보여준다 
SELECT *
FROM (SELECT a.*, rownum rnum 
	  FROM (SELECT * 
	  		FROM mboard 
	  		ORDER BY num DESC) a)
WHERE rnum >=1 and rnum <= 10
