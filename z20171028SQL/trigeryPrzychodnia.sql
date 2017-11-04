delimiter $$
create trigger ustaw_jako_internista
after insert on doctor
for each row 
begin
insert into doctor_has_specialization values (new.id, 1);
end;


delimiter $$
insert into doctor values (4,'Bardzo','Wazny');