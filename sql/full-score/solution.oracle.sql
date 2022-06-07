/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT th.hacker_id, th.name
FROM hackers th
JOIN submissions ts ON ts.hacker_id = th.hacker_id
JOIN challenges tc ON tc.challenge_id = ts.challenge_id
JOIN difficulty td ON td.difficulty_level = tc.difficulty_level
WHERE ts.score = td.score
GROUP BY th.hacker_id, th.name
HAVING COUNT(1) > 1
ORDER BY COUNT(1) DESC, th.hacker_id;
