-- 181. 超过经理收入的员工
SELECT a.Name as 'Employee'
FROM Employee AS a, Employee AS b
where
a.ManagerId = b.Id
and
a.Salary > b.Salary
