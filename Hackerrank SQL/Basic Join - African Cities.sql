SELECT city.NAME 
from city 
inner join 
country on
city.countrycode = country.code 
where country.continent = 'Africa'