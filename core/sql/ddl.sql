-- create
crete table employee(name nvarchar(20), email varchar(100), dob date);


-- drop
drop table employee;

-- alter
alter table employee add(address varchar(20));
alter table employee modify(name nvarchar(30));

-- truncate
truncate table employee;