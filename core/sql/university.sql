use university;
-- q1
SELECT *
FROM university.student
ORDER BY math_score DESC
    LIMIT 1;

SELECT *
FROM university.student
WHERE math_score = (SELECT MAX(math_score) FROM university.student);

-- q2
SELECT first_name, last_name, math_score, chemistry_score, AVG((math_score + chemistry_score) / 2)
FROM university.student
GROUP BY id;

-- q3
SELECT grade, AVG(math_score) as math_average
FROM university.student
GROUP BY grade;

-- q4
SELECT *
FROM university.student
WHERE math_score > 65
ORDER BY math_score ASC;

-- q5
SELECT COUNT(*) as a_grades
FROM university.student
WHERE grade = 'A'
GROUP BY grade;

-- q6
SELECT *
FROM university.student
WHERE first_name LIKE '%ali%';

-- q7
SELECT UPPER(emp_fname) as EmpName
FROM university.employee_info;

-- q8
SELECT COUNT(*)
FROM university.employee_info
WHERE department = 'HR';

-- q9
SELECT CURDATE() as Today;

-- q10
SELECT LEFT(emp_lname, 4)
FROM university.employee_info;

-- q11
SELECT SUBSTRING_INDEX(address, '(', 1)
FROM university.employee_info;

-- q12
CREATE TABLE university.copied_table AS
SELECT *
FROM university.student;

-- q13
SELECT position.emp_id, info.emp_fname, info.emp_lname
FROM university.employee_info AS info
         INNER JOIN university.employee_position as position
ON info.emp_id = position.emp_id
WHERE position.salary > 50000
  AND position.salary < 100000
GROUP BY position.emp_id;

-- q14
SELECT *
FROM university.employee_info
WHERE emp_fname LIKE 'S%';

-- q15
SELECT *
FROM university.employee_position
ORDER BY salary DESC
    limit 3;

-- q16
SELECT CONCAT(emp_fname, ' ', emp_lname) AS FullName
FROM university.employee_info;

-- q17
SELECT *
FROM university.employee_info
WHERE dob BETWEEN '1980-05-02'
          AND '1994-12-31';

SELECT *
FROM university.employee_info
WHERE dob > '1980-05-02'
  AND dob < '1994-12-31';

-- q18
SELECT *
FROM university.employee_info
ORDER BY emp_lname;

-- q19
SELECT *
FROM university.employee_info
WHERE emp_lname LIKE '%a'
  AND CHAR_LENGTH(emp_lname) = 5;

-- q20
SELECT *
FROM university.employee_info
WHERE emp_fname <> 'Sanjay';

-- q21
SELECT *
FROM university.employee_info
WHERE emp_fname <> 'Sanjay';

-- q22
SELECT *
FROM university.employee_info
WHERE employee_info.address = 'DELHI(DEL)';


select max(a.age) from table.a, table.b where a.age < b.age


select a.age from table.a , table.b 
group by a.age 
having count(*) = 1
