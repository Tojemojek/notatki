-- create schema i create database to synonimy

-- stwórz nowy schemat bazy danych
-- drop SCHEMA `docwiczenia`;
-- stwórz nowy schemat bazy danych
-- CREATE SCHEMA `docwiczenia` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci ;

drop DATABASE `moja`;
CREATE DATABASE `moja` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci ;

-- ustawienie jakiej ma używać bazy danych
use `moja`;

-- wyświetlenie aktywnej bazy danych
select database();

-- pokazanie tabelek
show tables;


-- usuwanie tabelki
drop table ludkowie;

-- tworzenie tabelki 
create table ludkowie (
id int primary key auto_increment not null,
imie varchar(15) not null,
nazwisko varchar(25) not null
);

-- wyświetlenie jej atrybutów
describe ludkowie;

-- usunięcie kolumny
Alter table ludkowie 
drop id;

-- dodanie kolumny
Alter table ludkowie 
add id int not null;

-- ustawienie kolumny jako klucza głównego
Alter table ludkowie 
add primary key (id);

-- zmiana nazwy tabeli
alter table ludkowie
rename as `nowi_ludkowie`;

-- zmiana nazwy tabeli
alter table `nowi_ludkowie`
rename as ludkowie;

-- usunięcie kolumny
Alter table ludkowie 
drop id;


-- dodanie kolumny
Alter table ludkowie 
add id int not null;

-- zmiana kolumny
alter table ludkowie
change id nowe_id int primary key auto_increment not null;

-- wpisywanie wartości - po nazwie tablicy wypisana kolejność kolumn
insert into ludkowie (imie, nazwisko, nowe_id) 
values ('K', 'O', 1);

-- wpisywanie wartości - po nazwie tablicy wypisana kolejność kolumn
insert into ludkowie (nowe_id, nazwisko, imie) 
values (2, 'S', 'J');

-- wpisywanie wartości - bez wypisania kolejności kolumn wstawiane po kolei
insert into ludkowie
values ('JK','OS',3);

-- modyfikacja rekodrów z warunkiem (warunek jest opcjonalny)
update ludkowie
set imie = 'Krz' where imie = 'K';

-- usunięcie rekordu z warunkiem (warunek jest opcjonalny)
delete from ludkowie
where imie = 'JK';

-- usuń wszystkie dane z tabelki
truncate ludkowie;



-- kwerendy select 
select * from ludkowie;

select imie, nazwisko from ludkowie;

select imie, nazwisko from ludkowie where imie = 'Krz';

select CONCAT_WS(' ', imie, nazwisko) as `Imię i nazwisko` from ludkowie where imie = 'Krz';

-- operatory

select 2+3;
select 3-2;
select 2*3;
select 3/2;

select 8 mod 3;
select 8 % 3;
select 8 div 3;

select pi();

select pow(2,8);
select power(2,8);

-- operatory logiczne
-- and, or
-- in (ty wymień elementy zbioru po przecinku) (czy zawiera się w zbiorze)
-- between wartosc_A and wartosc_B (sprawdza czy mieści się w przedziale domkniętym)
-- not 

-- operatory porównania 
-- >, >=, <, <=, =, <>, !=
-- is null, is not null

-- matematyczne
select abs(-56);
select cos(pi()/2);
select sin(pi()/2);

-- zaokrągla w górę do całkowitej
select ceil (0.32);

-- zaokrągla w dół do całkowitej
select floor (0.32);

-- zaokrągla 
select round (123.55584,2);
-- obcina
select truncate(123.55584,2);

select rand();

-- zwraca +1, -1, 0 zależnie od znaku liczby
select sign(-1225);
select sign(1225);
select sign(0);



-- konwersja między systemami pozycyjnymi
select conv (9,10,2)




