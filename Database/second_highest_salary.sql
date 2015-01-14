/*
Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the second highest salary is 200. If there is no second highest salary, then the query should return null.
 */

# solution 1
select max(salary)
from Employee
where salary < (select max(salary) from Employee);


# solution 2
select max(salary)
from Employee
where salary not in (select max(salary) from Employee);


# solution 3
select max(salary)
from Employee
where salary <> (select max(salary) from Employee);