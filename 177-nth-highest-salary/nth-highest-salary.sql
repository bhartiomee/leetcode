CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select DISTINCT(A.salary) as getNthHighestSalary from Employee A where N-1 = (select count(DISTINCT B.salary) from Employee B where B.salary>A.salary)

  );
END