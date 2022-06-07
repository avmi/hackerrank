/*
Enter your query here.
*/
WITH RECURSIVE seq AS (
    SELECT 1 AS num
    UNION ALL
    SELECT num + 1 FROM seq WHERE num < 20
)
SELECT REPEAT('* ', seq.num) FROM seq
