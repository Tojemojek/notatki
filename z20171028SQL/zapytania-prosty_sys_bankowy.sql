select c.name, c.surname, ur.role from user u join client c on u.id = c.user_id join user_roles ur on u.id = ur.user_id where ur.role = "admin";

select c.name, c.surname , ca.number, ca.amount from client c join client_account ca on c.id = ca.client_id;

select c.name, c.surname, sum(ca.amount) from client c join client_account ca on c.id = ca.client_id group by c.id;

select CONCAT_WS(' ',c.name, c.surname) as 'Całe imie i nazwisko' , sum(ca.amount) from client c join client_account ca on c.id = ca.client_id group by c.id;

select c.name, c.surname, sum(ca.amount) from client c join client_account ca on c.id = ca.client_id group by c.id order by sum(ca.amount) desc;

select c.name, c.surname, ha.amount as 'Tyle wytransferowano',  ha.number as 'Numer konta na', ha.transfer_date from client c join client_account ca on c.id = ca.client_id join history_account ha on ha.account_id = ca.id;

select c.name, c.surname, ha.amount as 'Tyle wytransferowano',  ha.number as 'Numer konta na', ha.transfer_date from client c join client_account ca on c.id = ca.client_id join history_account ha on ha.account_id = ca.id where ha.transfer_date > '2016-11-01' and ha.transfer_date < '2016-11-05';

select c.name, c.surname, ha.amount as 'Tyle wytransferowano',  ha.number as 'Numer konta na', ha.transfer_date from client c join client_account ca on c.id = ca.client_id join history_account ha on ha.account_id = ca.id where ha.transfer_date between '2016-11-01' and '2016-11-05 23:59:59';

select c.name, c.surname, ca.amount from client c join client_account ca on c.id = ca.client_id where ca.amount>=500;

select c.name, c.surname, ha.amount, a.city from client c join client_account ca on c.id = ca.client_id join history_account ha on ha.account_id = ca.id join address  a on a.client_id = c.id where a.city = 'Warszawa';

update user u join client c on u.id = c.user_id set u.enabled = 0 where c.surname = 'kowalski';

update user u join user_roles ur on u.id =ur.user_id join client c on c.user_id = u.id join client_account ca on ca.client_id = c.id set ca.amount = ca.amount *1.1 where ur.role = 'Admin';
