SELECT t2.continent, FLOOR(AVG(t1.population))
FROM CITY t1
JOIN COUNTRY t2 ON t1.countrycode = t2.code
GROUP BY t2.continent;
