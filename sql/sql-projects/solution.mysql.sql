/*
Enter your query here.
*/
SELECT Start_Date, MIN(End_Date)
FROM (
    (
        SELECT Start_Date
        FROM projects
        WHERE Start_Date NOT IN (
            SELECT End_Date FROM projects
        )
    ) AS t1,
    (
        SELECT End_Date
        FROM projects
        WHERE End_Date NOT IN (
            SELECT Start_Date FROM projects
        )
    ) AS t2
)
WHERE Start_Date < End_Date
GROUP BY Start_Date
ORDER BY DATEDIFF(Start_Date, MIN(End_Date)) DESC, Start_Date
