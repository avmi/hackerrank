/*
Enter your query here.
*/
SELECT x, y
FROM functions t1
WHERE x <> y AND EXISTS(
        SELECT * FROM functions t2 WHERE t2.y = t1.x AND t2.x = t1.y AND t2.x > t1.x
    )
UNION
SELECT x, y
FROM functions t1
WHERE x = y AND (
        (SELECT COUNT(*) FROM functions t2 WHERE t2.x = t1.x AND t2.y = t1.x) > 1
    )
ORDER BY x;
