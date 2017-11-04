delimiter $$
create trigger count_book_quantity
after insert on rent
for each row 
begin
update book_quantity set quantity = quantity - new.quantity where new.book_id = book_quantity.book_id;
end;

delimiter $$
INSERT INTO `librarydb`.`rent` (`id`, `book_id`, `client_id`, `date`, `quantity`) VALUES ('5', '4', '3', '2017-10-10', '4000');


delimiter $$
CREATE PROCEDURE kto_ma_ksiazke(tytul varchar(100))
 BEGIN
SELECT * from rent r join client c on r.client_id = c.id join book b on r.book_id = b.id where b.title = tytul;
 END;
