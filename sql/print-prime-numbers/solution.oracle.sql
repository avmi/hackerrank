/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT LISTAGG(n, '&') WITHIN GROUP ( ORDER BY N )
FROM (
    SELECT level as n FROM dual WHERE Level > 1 CONNECT BY level < 1001
    MINUS
    SELECT n1.n * n2.n
    FROM
        (SELECT level as n FROM dual WHERE Level > 1 CONNECT BY level < 501) n1,
        (SELECT level as n FROM dual WHERE Level > 1 CONNECT BY level < 501) n2
);
