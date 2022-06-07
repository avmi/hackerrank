/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT t1.n, (
    CASE
        WHEN t1.p IS NULL THEN 'Root'
        WHEN t1.n IN (SELECT t2.p FROM bst t2) THEN 'Inner'
        ELSE 'Leaf'
    END
)
FROM bst t1
ORDER BY t1.n;
