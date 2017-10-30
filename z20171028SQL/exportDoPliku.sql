-- tworzy nowy
SELECT name, sum(price) as 'cena maks'
INTO OUTFILE "c:\\temp\\poducts2.csv"
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
ESCAPED BY '\\'
LINES TERMINATED BY '\n'
FROM product group by name order by sum(price);
