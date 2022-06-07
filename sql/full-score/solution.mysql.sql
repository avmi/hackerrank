/*
Enter your query here.
*/
SELECT th.hacker_id, th.name
FROM hackers th, challenges tc, difficulty td, submissions ts
WHERE
    tc.challenge_id = ts.challenge_id
    AND th.hacker_id = ts.hacker_id
    AND tc.difficulty_level = td.difficulty_level
    AND ts.score = td.score
GROUP BY th.hacker_id, th.name
HAVING COUNT(th.hacker_id) > 1
ORDER BY COUNT(tc.challenge_id) DESC, th.hacker_id ASC
