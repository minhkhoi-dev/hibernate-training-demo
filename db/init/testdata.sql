--drop table dbo.departments;
create table dbo.departments
(
    dept_id   integer not null
        primary key,
    dept_name varchar(255)
);

INSERT INTO dbo.departments (dept_id, dept_name) VALUES (1, 'Test department 1');
INSERT INTO dbo.departments (dept_id, dept_name) VALUES (2, 'Test department 2');
INSERT INTO dbo.departments (dept_id, dept_name) VALUES (3, 'Test department 3');
INSERT INTO dbo.departments (dept_id, dept_name) VALUES (4, 'Test department 4');
INSERT INTO dbo.departments (dept_id, dept_name) VALUES (5, 'Test department 5');

