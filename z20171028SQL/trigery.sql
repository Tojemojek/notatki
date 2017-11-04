-- używamy systembankowydb

delimiter $$
create trigger dodaj_role
after insert on user
for each row
begin
insert user_roles (user_id, Role) values (new.id, 'user');
end;

delimiter $$
INSERT INTO `systembankowydb`.`user` (`id`, `password`, `enabled`) VALUES ('6', '1052635', '1');


delimiter $$
create trigger dodaj_konto
after insert on client
for each row
begin
insert client_account (client_id, number, amount) values (NEW.id, uuid_short(), 0);
end;

