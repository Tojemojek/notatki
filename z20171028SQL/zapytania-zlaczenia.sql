select * from user u join address a on u.address_id = a.id;

select u.name, a.city from user u join address a on u.address_id = a.id;

select u.name, a.city from user u join address a on u.address_id = a.id where a.city='Kraków';

select * from address where city='Kraków';

select u.name, a.city from user u join address a on u.address_id = a.id where a.city='Kraków' and a.street = 'ul. Bażanki ';

select * from `order` o join user u on o.user_id = u.id;

select * from `order` o join user u on o.user_id = u.id where o.status = 'OK';

select * from `order` o join user u on o.user_id = u.id join address a on u.address_id = a.id where o.status = 'OK' ;

select u.name, u.surname, a.city, a.street, o.date from `order` o join user u on o.user_id = u.id join address a on u.address_id = a.id where o.status = 'OK' ;

select * from product p join product_has_category h on p.id = h.product_id join category c on c.id =h.category_id where c.name = 'bread' order by p.price;

select o.date, o.id, u.name, u.surname, p.name, p.price, oh.count from `order` o join order_has_product oh on o.id = oh.order_id join product p on p.id = oh.product_id join user u on o.user_id=u.id;

select o.date, o.id, u.name, u.surname, p.name, p.price, oh.count from `order` o join order_has_product oh on o.id = oh.order_id join product p on p.id = oh.product_id join user u on o.user_id=u.id where o.date < '2017-09-30';

select o.id, sum(p.price*oh.count) as 'Wartosc' from product p join order_has_product oh on p.id = oh.order_id join `order` o on o.id = oh.order_id group by o.id;

select o.id, sum(p.price*oh.count) as 'Wartosc' from product p join order_has_product oh on p.id = oh.order_id join `order` o on o.id = oh.order_id where o.user_id = 1 group by o.id;

select c.name, count(phc.product_id) as 'Liczba produktów w kategorii' from category c join product_has_category phc on c.id = phc.category_id group by c.name;

select CONCAT_WS('-',c.name, count(phc.product_id)) as 'Liczba produktów - ilość produktów w tej kategorii' from category c join product_has_category phc on c.id = phc.category_id group by c.name;



