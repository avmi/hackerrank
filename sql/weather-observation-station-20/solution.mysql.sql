/*
Enter your query here.
*/
SELECT ROUND(t1.lat_n, 4)
FROM station t1, station t2
GROUP BY t1.lat_n
HAVING SUM(SIGN(1 - SIGN(t2.lat_n - t1.lat_n))) = (COUNT(*) + 1) / 2
