-- 177. 第N高的薪水 2020/06/28
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N := N-1;
  RETURN (
      # Write your MySQL query statement below.
    SELECT
            salary
      FROM
            employee
      GROUP BY
            salary
      ORDER BY
            salary DESC
      LIMIT N, 1
  );
END