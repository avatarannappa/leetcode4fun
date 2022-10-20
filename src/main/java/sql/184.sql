-- 184. 部门工资最高的员工 2020/06/30
select
    b.Name as Department,
    a.Name as Employee,
    a.Salary as Salary
from
    Employee a join
    Department b on a.DepartmentId = b.Id
where
    (a.DepartmentId,a.Salary) in (
    select
    DepartmentId,
    MAX(Salary)
    FROM
        Employee
    GROUP BY DepartmentId
    )