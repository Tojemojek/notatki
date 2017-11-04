select * from patient p join address a on p.address_id = a.id;

select p.name, p.surname, a.city, ap.date from patient p join address a on p.address_id = a.id join appointment ap on p.id = ap.patient_id;

select d.name, count(distinct h.specialization_id) from doctor_has_specialization h join doctor d on d.id = h.doctor_id group by d.name;


-- usuwanie funkcji z bazy danych
drop function CustomerLevel;

-- usuwanie procedury
drop procedure mysql_test_repeat_loop;

-- wywołanie funckji 
select CustomerLevel(1000);

-- wywołanie procedury
call test_mysql_while_loop();

-- wywołanie procedury
call mysql_test_repeat_loop;

-- wywołanie procedury
call get_appointments('Suwała');
call get_appointments('Kowalski');

call get_specialization('chirurg');
call get_specialization('internista');

call find_if_possible_to_add_appointment('Mucha', '2017-11-05 10:00:00');
call find_if_possible_to_add_appointment('Mucha', '2017-11-05 10:01:00');



