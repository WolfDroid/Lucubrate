SELECT country.continent, 
floor ( avg(city.population) ) as avg_city_population
from city
inner join 
country on 
city.countrycode = country.code 
group by country.continent