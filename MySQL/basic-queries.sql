#1. Products

#2. 
SELECT ProductID, ProductName, UnitPrice
FROM products;

#3.
SELECT ProductID, ProductName, UnitPrice
FROM products
ORDER BY UnitPrice ASC;

#4. 
SELECT ProductID, ProductName, UnitPrice
FROM products
WHERE UnitPrice <= 7.50;

#5.
SELECT ProductID, ProductName, UnitPrice, UnitsInStock
FROM products
WHERE UnitsInStock >= 100
ORDER BY UnitPrice DESC;

#6. Needs work
SELECT ProductID, ProductName, UnitPrice, UnitsInStock
FROM products
WHERE UnitsInStock >= 100
ORDER BY UnitPrice DESC, ProductName ASC;

#7. 
SELECT ProductID, ProductName, UnitPrice, UnitsInStock, UnitsOnOrder
FROM products
WHERE UnitsInStock = 0 AND UnitsOnOrder >= 1
ORDER BY ProductName; 

#8. Categories

#9. 
SELECT *
FROM categories;
# CategoryID 8 SeaFood

#10. The Products table uses the CategoryID column to identify the category ff each item
SELECT Description
FROM categories
WHERE CategoryID = 8;

#11. 
SELECT FirstName, LastName
FROM employees;

#12. 
SELECT FirstName, LastName
FROM employees
WHERE Title LIKE '%manager%';

#13. 
SELECT DISTINCT (Title)
FROM employees;

#14. 
SELECT FirstName, LastName, Salary
FROM employees
WHERE Salary BETWEEN 200 AND 2500;

#15. 
SELECT *
FROM suppliers;

#16. The Products table uses the SupplierID column to identify the Supplier that supplies the product
SELECT ProductID, ProductName
FROM products
WHERE SupplierID = 4;