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

--drop table dbo.employees;
create table dbo.employees
(
    id   integer not null
        primary key,
    name varchar(255),
    role varchar(10),
    department_id integer not null
);

-- Insert data
INSERT INTO dbo.employees (id, name, role, department_id) VALUES (1, N'Employee 1', N'Boss', 1);
INSERT INTO dbo.employees (id, name, role, department_id) VALUES (2, N'Employee 2', N'Dev', 1);
INSERT INTO dbo.employees (id, name, role, department_id) VALUES (3, N'Employee 3', N'Test', 1);
