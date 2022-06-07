/*
Enter your query here.
*/
WITH RECURSIVE seq AS (
    SELECT 20 AS num
    UNION ALL
    SELECT num - 1 FROM seq WHERE num > 1
)
SELECT REPEAT('* ', seq.num) FROM seq
