-- to wyłącza analizę białych znaków przy kompilacji
-- tu jest definicja funkcji po jej wykonaniu jest wpisywana do bazy danych 
Delimiter $$

create function CustomerLevel(p_creditLimit integer) returns varchar(10)
begin 
	declare lvl varchar(10);

	if p_creditLimit > 500 then
		set lvl = 'Platinum';
	elseif (p_creditLimit <= 500 and p_creditLimit >= 300) then
		set lvl = 'Gold';
	elseif p_creditLimit < 300 then
		set lvl = 'Silver';
	end if;
return (lvl);

end;



 -- ------------petla while----------------------
 -- tu jest definicja procedury
 DELIMITER $$
 DROP PROCEDURE IF EXISTS test_mysql_while_loop;
 
DELIMITER $$
 CREATE PROCEDURE test_mysql_while_loop()
 BEGIN
 DECLARE x INT;
 DECLARE str VARCHAR(255);
 
 SET x = 1;
 SET str =  '';
 
 WHILE x  <= 5 DO
   SET  str = CONCAT(str,x,',');
   SET  x = x + 1; 
 END WHILE;
 
SELECT str;
 END;
 
 
-- ------petla repeat-----------------------
-- tu jest definicja procedury
 DELIMITER $$
 DROP PROCEDURE IF EXISTS mysql_test_repeat_loop;
 
  DELIMITER $$
 CREATE PROCEDURE mysql_test_repeat_loop()
 BEGIN
 DECLARE x INT;
 DECLARE str VARCHAR(255);
        
 SET x = 1;
 SET str =  '';
        
 REPEAT
   SET  str = CONCAT(str,x,',');
   SET  x = x + 1; 
 UNTIL x  > 5
 END REPEAT;
 
SELECT str;
 END;



DELIMITER $$
CREATE PROCEDURE get_appointments(surname varchar(100))
BEGIN
 
 select d.name, d.surname, a.date from patient p join appointment a on p.id = a.patient_id join doctor d on d.id = a.doctor_id where p.surname = surname;
 
 
END;


DELIMITER $$
CREATE PROCEDURE get_specialization(specialization varchar(100))
BEGIN
 
 select 
	d.name, d.surname 
 from 
	doctor_has_specialization dhs join doctor d on d.id = dhs.doctor_id join specialization s on s.id = dhs.specialization_id 
    where s.name = specialization;
  
END;


DELIMITER $$
Create procedure find_if_possible_to_add_appointment(doc_surname varchar(100), app_date datetime)
begin

declare is_app boolean;

set is_app = exists (
select * from doctor d join appointment a where d.surname = doc_surname and a.date = app_date
);

select is_app;
end;