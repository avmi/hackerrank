/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT DISTINCT t1.*
FROM FUNCTIONS t1, FUNCTIONS t2
WHERE t1.ROWID <> t2.ROWID AND t1.x = t2.y AND t1.y = t2.x AND t1.x <= t1.y
ORDER BY t1.x, t1.y ;
