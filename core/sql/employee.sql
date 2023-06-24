SELECT * FROM dbo.projects;
select * from dbo.employees;

select *
from dbo.employees
where employee_id not in (select employee_id from dbo.projects);


select employees.name
from dbo.employees
         left join dbo.projects on employees.employee_id = projects.employee_id
where projects.project_id is null

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


select *
from employee limit 3;

select *
from emoployee rounum <= 3;

select top 3
from employee;

select *
from employee
order by asc;

select name, sum(salary)
from employee
group by name;


select c.id, c.name, c.age, o.amount
from employee as c,
     order as o
where c.id = o.customer_id;


select id as employee_id, name as name_id
from employee
where salary is not null;





