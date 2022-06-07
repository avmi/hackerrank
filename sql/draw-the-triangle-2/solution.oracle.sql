/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
WITH seq(num) AS (
    SELECT 1 FROM dual
    UNION ALL
    SELECT num + 1 FROM seq WHERE num < 20
)
SELECT RPAD('* ', seq.num * 2, '* ') FROM seq;
