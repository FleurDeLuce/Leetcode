/*
Write a SQL query to get the nth highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the nth highest salary where n = 2 is 200. If there is no nth highest salary, then the query should return null.
 */

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select ifnull(Emp1.Salary 
      from Employee Emp1
      where (N - 1) = (
      select count(distinct(Emp2.Salary))
      from Employee Emp2
      where Emp2.Salary > Emp1.Salary
      ), null)
  );
END


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select ifnull(
      select distinct Emp1.Salary 
      from Employee Emp1
      where (N - 1) = (select count(distinct(Emp2.Salary)) from Employee Emp2 where Emp2.Salary > Emp1.Salary), null)
  );
END



CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select ifnull(
      select distinct Salary 
      from Employee 
      order by Salary desc limit n-1, 1
      ), null)
  );
END

