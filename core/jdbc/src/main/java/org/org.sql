CREATE DATABASE org;
SHOW DATABASES;
USE org;

-- create worker table
CREATE TABLE Worker
(
    WORKER_ID    INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME   CHAR(25),
    LAST_NAME    CHAR(25),
    SALARY       INT(15),
    JOINING_DATE DATETIME,
    DEPARTMENT   CHAR(25)
);

INSERT INTO Worker (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT)
VALUES (001, 'Monika', 'Arora', 100000, '14-02-20 09.00.00', 'HR'),
       (002, 'Niharika', 'Verma', 80000, '14-06-11 09.00.00', 'Admin'),
       (003, 'Vishal', 'Singhal', 300000, '14-02-20 09.00.00', 'HR'),
       (004, 'Amitabh', 'Singh', 500000, '14-02-20 09.00.00', 'Admin'),
       (005, 'Vivek', 'Bhati', 500000, '14-06-11 09.00.00', 'Admin'),
       (006, 'Vipul', 'Diwan', 200000, '14-06-11 09.00.00', 'Account'),
       (007, 'Satish', 'Kumar', 75000, '14-01-20 09.00.00', 'Account'),
       (008, 'Geetika', 'Chauhan', 90000, '14-04-11 09.00.00', 'Admin');


-- create bonus table
CREATE TABLE Bonus
(
    WORKER_REF_ID INT,
    BONUS_AMOUNT  INT(10),
    BONUS_DATE    DATETIME,
    FOREIGN KEY (WORKER_REF_ID)
        REFERENCES Worker (WORKER_ID)
        ON DELETE CASCADE
);

INSERT INTO Bonus
(WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE)
VALUES (001, 5000, '16-02-20'),
       (002, 3000, '16-06-11'),
       (003, 4000, '16-02-20'),
       (001, 4500, '16-02-20'),
       (002, 3500, '16-06-11');

-- create title table
CREATE TABLE Title
(
    WORKER_REF_ID INT,
    WORKER_TITLE  CHAR(25),
    AFFECTED_FROM DATETIME,
    FOREIGN KEY (WORKER_REF_ID)
        REFERENCES Worker (WORKER_ID)
        ON DELETE CASCADE
);

INSERT INTO Title
(WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM)
VALUES (001, 'Manager', '2016-02-20 00:00:00'),
       (002, 'Executive', '2016-06-11 00:00:00'),
       (008, 'Executive', '2016-06-11 00:00:00'),
       (005, 'Manager', '2016-06-11 00:00:00'),
       (004, 'Asst. Manager', '2016-06-11 00:00:00'),
       (007, 'Executive', '2016-06-11 00:00:00'),
       (006, 'Lead', '2016-06-11 00:00:00'),
       (003, 'Lead', '2016-06-11 00:00:00');

-- q1 Write an SQL query to print details of the Workers who have joined in Feb’2014.
SELECT *
FROM Worker
WHERE YEAR(JOINING_DATE) = 2014
  AND MONTH(JOINING_DATE) = 2;

-- q2 Write an SQL query to report duplicated rows  including counter:
SELECT WORKER_TITLE, AFFECTED_FROM, COUNT(*) AS COUNT
FROM Title
GROUP BY WORKER_TITLE, AFFECTED_FROM
HAVING COUNT > 1;

-- q3   Write an SQL query to clone a new table from worker table and call it update_worker.
--      And add 5 new records to it. And remove first 3 rows.
CREATE TABLE update_worker AS
SELECT *
FROM Worker;

INSERT INTO update_worker (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT)
VALUES (009, 'MonikaNEW', 'AroraNEW', 100000, '14-02-20 09.00.00', 'HR'),
       (010, 'NiharikaNEW', 'VermaNEW', 80000, '14-06-11 09.00.00', 'Admin'),
       (011, 'VishalNEW', 'SinghalNEW', 300000, '14-02-20 09.00.00', 'HR'),
       (012, 'AmitabhNEW', 'SinghNEW', 500000, '14-02-20 09.00.00', 'Admin'),
       (013, 'VivekNEW', 'BhatiNEW', 500000, '14-06-11 09.00.00', 'Admin');

DELETE
FROM update_worker
         LIMIT 3;

-- q4 Write an SQL query to fetch common rows of new_worker table and worker table.
SELECT w.*
FROM Worker as w
         INNER JOIN update_worker uw on w.WORKER_ID = uw.WORKER_ID;

-- q5 Write an SQL query to show records from table new_worker that worker table does not have.
SELECT *
FROM update_worker AS uw
WHERE NOt EXISTS(SELECT * FROM Worker AS w WHERE uw.WORKER_ID = w.WORKER_ID);

-- q6 Write an SQL query to determine the nth (say n=5) highest salary from a table.
SELECT *
FROM Worker
ORDER BY SALARY DESC
    LIMIT 4,1;

-- q7 Write an SQL query to fetch the first 50% records from worker table.
SELECT *
FROM (SELECT *, NTILE(2) OVER (ORDER BY null) nt FROM Worker) AS t
WHERE nt = 1;

-- q8 Write an SQL query to fetch the departments that have less than five people in it
SELECT DEPARTMENT, COUNT(*)
FROM Worker
GROUP BY DEPARTMENT
HAVING COUNT(*) < 5;

-- q9 Write an SQL query to print the name of employees having the highest salary in each department.
SELECT *
FROM Worker
WHERE SALARY IN (
    SELECT MAX(SALARY)
    FROM Worker
    GROUP BY DEPARTMENT
) ORDER BY SALARY DESC;

