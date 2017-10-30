select * from user where id = 3; 

select * from user where address_id = 1; 

select * from user where surname like '%k';

select * from user where surname like '%k' and name like 'Z%';

select * from address where street_number between 7 and 10;

select street from address where city = 'Warszawa';

-- tym usuwaliśmy kolumnę z tabeli
-- order jest w ` bo order to też słowo kluczowe
-- alter table `order` drop column total_price;

select min(price) from product;

select avg(price) from product;

select max(price) from product;

select sum(price) from product;

select distinct name from user;

select * from user order by surname asc;

select * from user order by surname desc;

select * from `order` where date < '2017-09-28';

select min(date) from `order`; 

-- to zmienia nazwiska 
-- update user set surname = 'Keller' where name = 'Zbigniew';

-- uwaga na dokładność obliczeń
update product set price = price * 1.10;


ALTER TABLE `mojeallegro`.`product` 
CHANGE COLUMN `price` `price` DECIMAL UNSIGNED NOT NULL ;

ALTER TABLE `mojeallegro`.`product` 
CHANGE COLUMN `price` `price` DECIMAL(10,2) UNSIGNED NOT NULL ;

select name from category;
