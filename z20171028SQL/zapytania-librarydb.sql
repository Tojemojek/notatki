select a.name, a.surname, b.title from book b join join_book_author jba on b.id = jba.book_id join author a on a.id = jba.author_id;

select c.name, c.surname, b.title from book b join rent r on b.id = r.book_id join client c on c.id = r.client_id;

-- sql-mode = only-full-group-by
select c.name, c.surname, sum(r.quantity) from book b join rent r on b.id = r.book_id join client c on c.id = r.client_id group by c.surname;

select b.title, bq.quantity from book b join book_quantity bq on b.id = bq.id;

select sum(quantity) as 'Suma w bibliotece'  from book_quantity;

select p.city, b.title from book b join place p on b.id = p.book_id; 

select p.city, b.title from book b join place p on b.id = p.book_id where p.city like 'W%'; 

select p.city, b.title, bq.quantity from book b join place p on b.id = p.book_id join book_quantity bq on b.id = bq.book_id where p.city like 'W%'; 

select c.name, c.surname, b.title from `client` c join rent r on c.id = r.client_id join book b on r.book_id = b.id where b.title = 'Lalka';

select a.name, a.surname, count(jba.id) as 'Napisał tyle książek' from author a join join_book_author jba on a.id = jba.author_id group by a.surname;
