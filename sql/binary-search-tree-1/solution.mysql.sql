/*
Enter your query here.
*/
SELECT n, (
    CASE
        WHEN t1.p IS NULL THEN 'Root'
        WHEN EXISTS (SELECT * FROM bst t2 WHERE t2.p = t1.n) THEN 'Inner'
        ELSE 'Leaf'
    END
)
FROM bst t1
ORDER BY t1.n ASC
