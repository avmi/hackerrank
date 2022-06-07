SELECT t1.continent, FLOOR(AVG(t2.population))
FROM country t1
INNER JOIN city t2
ON t1.code = t2.countrycode
GROUP BY t1.continent;
