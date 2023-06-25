CREATE TABLE Student
(
    id    INT          NOT NULL,
    name  VARCHAR(50)  NOT NULL,
    marks VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
INSERT INTO Student (id, name, marks)
VALUES (1, 'Rohit', '87,92,76,89');

SELECT id, name, marks, LENGTH(marks) - LENGTH(REPLACE(marks, ',', '')) + 1 AS num_marks
FROM Student
WHERE id = 1;