/*
The Employee table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who have the highest salary in each of the departments. For the above tables, Max has the highest salary in the IT department and Henry has the highest salary in the Sales department.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+
 */
 # (e.DepartmentId, e.Salary) is the primary key pair
select d.Name as Department, e.Name as Employee, e.Salary as Salary
from Employee e, Department d
where (e.DepartmentId, e.Salary) in (
    select e.DepartmentId, max(e.Salary)
    from Employee e
    group by e.DepartmentId
)
and e.DepartmentId = d.Id;

/*
#Wrong solution
select d.Name as Department, e.Name as Employee, e.Salary as Salary
from Employee e, Department d
where (e.Id, e.Salary) in (
    select e.Id, max(e.Salary)
    from Employee e
    group by e.DepartmentId
)
and e.DepartmentId = d.Id;

*/

