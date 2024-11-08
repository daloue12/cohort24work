use gravel_family;

-- Solve each task by writing a query below the task description.
-- Each task describes the expected result.
-- Unfortunately, tasks must be verified manually. :(

-- Example: 
-- Count the number of customer in Toronto
-- Expected: 14
select count(*)
from customer
where city = 'Toronto';

-- How many employees have the last_name 'Soyle'?
-- Expected: 12
select count(last_name) from employee where last_name = 'Soyle';
-- How many projects are there in the database?
-- Expected: 1121
select count(project_id) from project;
-- What's the earliest project start_date?
-- Expected: 2017-09-23
select min(start_date) from project;
-- What's the latest employee start_date?
-- Expected: 2020-08-25
select max(start_date) from project;
-- Count customers per city.
-- Expected: 88 Rows
select count(customer_id) from customer group by city;
-- Count customers per postal_code.
-- Expected: 84 Rows
select count(customer_id) from customer group by postal_code;
-- Count employees per last_name.
-- Expected: 3 Rows
select count(last_name) from employee;
-- Count the number of projects per city.
-- Expected: 88 Rows
select count(project_id) from project inner join customer c on project.customer_id = c.customer_id group by c.city;
-- Count the number of projects per city.
-- Sort by the count descending and select the top 10 rows.
-- Expected: 10 Rows
select count(project_id) from project inner join customer c on project.customer_id = c.customer_id group by c.city order by count(project_id) desc limit 10;
-- Which postal_code has the most projects?
-- Expected: M3H
select count(project_id), c.postal_code from project inner join customer c on project.customer_id = c.customer_id group by c.postal_code order by count(project_id) desc limit 1;
-- Count the number of projects per start_date year.
-- Expected: 4 Rows

-- not sure what this question is asking?

-- Count the number of employees per project in the M3H postal_code.
-- Group by project_id, sort by count descending.
-- Expected: 39 Rows
select count(*) from employee e inner join project_employee pe on e.employee_id = pe.employee_id
inner join project p on pe.project_id = p.project_id 
inner join customer c on p.customer_id = c.customer_id where c.postal_code = 'M3H' group by p.project_id order by count(*) desc;
-- Calculate the total cost per project in the 'M3H' postal_code.
-- (Hint: sum a calculation)
-- Expected: 39 Rows
select sum(pi.quantity * pi.item_id) from project p 
-- What's the most expensive project in the 'M3H' postal_code?
-- Expected: 18828.00

-- How many projects did each employee work on?
-- Expected: 33 Rows

-- How many employees worked on more than 140 projects?
-- Expected: 10 Rows

-- How many projects cost more than $20,000?
-- Expected: 55 Rows

-- Across all projects, what are the total costs per item?
-- Select the item name and sum.
-- Sort by the sum desc;
-- Expected: 18 Rows

-- Across all projects, what are the total costs per item category?
-- Select the category name and sum.
-- Sort by the sum desc;
-- Expected: 7 Rows

-- What's the average 'Standard Labor' cost per city?
-- Expected: 88 Rows

-- Challenge: Which customer has the first project of 2019?
-- (Requires a subquery.)
-- Expected: Starkie 2019-01-01