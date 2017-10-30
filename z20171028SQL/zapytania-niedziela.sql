select city, count(city) as 'ilość' from address group by city order by city;

select city, count(city) as 'ilość' from address group by city order by count(city) desc;

select city, count(city) as 'ilość' from address group by city having city like '%a' order by count(city) desc, city;

select city, count(city) as 'ilość' from address group by city having city like '%a' order by city, count(city) desc;

-- ALTER SCHEMA `mojeallegro`  DEFAULT COLLATE utf8_polish_ci ;

select city, count(city) as 'ilość' from address group by city having city like '%a' order by city, count(city) desc;

select city, count(city) as 'ilość' from address group by city having city like '%a' order by city, count(city) desc;

select city, count(city) as 'ilość' from address group by city order by  count(city) desc, city collate utf8_polish_ci;

-- ALTER TABLE `mojeallegro`.`address` 
-- COLLATE = utf8_polish_ci ;

select city, count(city) as 'ilość' from address group by city having city like '%a' order by city, count(city) desc;

select name, max(price) as 'cena maks' from product group by name having name = 'cider';

select name, avg(price) as 'cena maks' from product group by name having name = 'cider';

select name, sum(price) as 'cena maks' from product group by name order by sum(price);




