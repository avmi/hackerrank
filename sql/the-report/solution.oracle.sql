/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT
    CASE WHEN t2.grade >= 8 THEN t1.name END,
    t2.grade, t1.marks
FROM students t1
         LEFT JOIN grades t2
                   ON (t1.marks BETWEEN t2.min_mark AND t2.max_mark)
ORDER BY
    t2.grade DESC,
    (CASE WHEN t2.grade >= 8 THEN t1.name END) ASC,
    (CASE WHEN t2.grade < 8 THEN t1.marks END) ASC;
