
SELECT ( MONTHS*SALARY ) AS employee_earnings, COUNT(*) as number_of_occurence
FROM employee
GROUP BY employee_earnings 
ORDER BY employee_earnings desc
limit 1;
