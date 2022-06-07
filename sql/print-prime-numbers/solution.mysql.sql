/*
Enter your query here.
*/
WITH RECURSIVE seq(n) AS
(
   SELECT 2
   UNION ALL
   SELECT n + 1 FROM seq WHERE n < 1000
)
SELECT GROUP_CONCAT(t1.n SEPARATOR'&')
FROM seq AS t1
WHERE t1.n NOT IN (
    SELECT t2.n
    FROM seq AS t2
    JOIN seq AS t3
    WHERE t2.n <> t3.n AND t3.n < t2.n AND t2.n % t3.n = 0
    ORDER BY t2.n
)
