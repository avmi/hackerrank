/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT Start_Date, End_Date
FROM (
    SELECT
        MIN(Start_Date) AS Start_Date,
        MAX(End_Date) AS End_Date,
        (MAX(End_Date) - MIN(Start_Date)) as Date_Distance
    FROM (
        SELECT
            End_Date - 1 AS Start_Date,
            End_Date AS End_Date,
            End_Date - ROW_NUMBER() OVER (ORDER BY End_Date) AS End_Date_Aggregate
        FROM projects
    )
    GROUP BY End_Date_Aggregate
    ORDER BY Date_Distance, Start_Date
);
