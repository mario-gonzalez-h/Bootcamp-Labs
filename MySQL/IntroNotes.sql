#Comment
/* 
< > <= >= = <> !=
*/
SELECT *
FROM northwind.products
WHERE UnitsInStock < 30;

SELECT *
FROM products
WHERE CategoryID <> 1;

#Compound Where clauses AND/OR
#I want products that are dairy products or beverages

SELECT *
FROM products
WHERE CategoryID = 1 OR CategoryID = 4;

#If you have a list of options
#I want all products that are beverages, dairy productsm or produce
SELECT *
FROM products
WHERE CategoryID IN (1,4,7);

SELECT *
FROM orders
WHERE ShipCountry = 'France';

SELECT *
FROM orders
WHERE ShippedDate > '1996-09-01';

#I want orders shipped between September and October of 1996
SELECT *
FROM orders
WHERE ShippedDate BETWEEN '1996-09-01' AND '1996-10-01';

#I want orders where the shipping name starts with R
SELECT *
FROM orders
WHERE ShipName LIKE 'R%o';

#I want orders where the shipping name contains the word Super
SELECT *
FROM orders
WHERE ShipName LIKE '%Super%';

#Ordering things
SELECT *
FROM orders
ORDER BY ShipCountry DESC;

#Ordering things
SELECT *
FROM orders
WHERE Freight > 20
ORDER BY ShipCountry;

# For null     we have to use IS or IS NOT keyword
SELECT *
FROM customers
WHERE region IS null;

#To get rid of duplicates
SELECT DISTINCT (Country)
FROM customers
ORDER BY Country;