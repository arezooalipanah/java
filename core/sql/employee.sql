select name, salary
from employee
where salary > 500000
  and age < 30;


update employee
set address="test test"
where id = 5;


select *
from employee
where salary like '200%';
