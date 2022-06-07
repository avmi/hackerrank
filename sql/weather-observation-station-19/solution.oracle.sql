/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT ROUND(SQRT(POWER(MAX(long_w) - MIN(long_w), 2) + POWER(MAX(lat_n) - MIN(lat_n), 2)), 4)
FROM station;
