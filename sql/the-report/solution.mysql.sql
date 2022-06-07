/*
Enter your query here.
*/
SELECT
    CASE WHEN t2.grade >= 8 THEN t1.name END,
    t2.grade, t1.marks
FROM students AS t1
LEFT JOIN grades AS t2
ON (t1.marks BETWEEN t2.min_mark AND t2.max_mark)
ORDER BY
    t2.grade DESC,
    (CASE WHEN t2.grade >= 8 THEN t1.name END) ASC,
    (CASE WHEN t2.grade < 8 THEN t1.marks END) ASC
