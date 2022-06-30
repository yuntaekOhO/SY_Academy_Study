create table salary(
	name varchar2(10) primary key,
	pay number not null
);

insert into salary values('kim',1000);
insert into salary values('lee',2000);
insert into salary values('park',3000);
commit;

create or replace procedure adjust(n in varchar2, rate in float)
is
	newpay float;
begin
	-- 급여 읽기
	select pay 
	into newpay
	from salary
	where name=n;
	
	--새로운 급여 연산
	newpay := newpay + newpay*rate;
	
	--새로운 급여로 갱신
	update salary set pay = newpay where name=n;
	commit;
	
	exception when others then
	dbms_output.put_line('error occurred');
	rollback;

end ;