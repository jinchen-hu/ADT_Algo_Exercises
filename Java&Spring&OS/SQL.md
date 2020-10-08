# SQL

## SQL Database

### Create DB

```mysql
CREATE DATABASE databaseName;
```

### Drop DB

```mysql
DROP DATABASE databaseName;
```

### Backup DB

```mysql
BACKUP DATABASE databasename
TO DISK = 'filepath'
WITH DIFFERENTIAL (optional, back up the parts of the DB has changed)
```

### Create Table

Data types: int, varchar(size), bool, float, date

* Create a new table in database

```mysql
CREATE TABLE table_name{
	col1 datatype,
	col2 datatype,
	col3 datatype,
	...
};
```

* Create table using another table

```mysql
CREATE TABLE new_table AS
	SELECT col1, col2, ...
	FROM existing_table
	WHERE ...;
```

### Drop Table

```mysql
DROP TABLE table_name;
```

* Delete all data inside a table but not the table itself

```mysql
TRUNCATE TABLE table_name;
```

### Alter Table

* Add a column in a table

```mysql
ALTER TABLE table_name
	ADD col_name datatype;
```

* Delete a column in a table

```mysql
ALTER TABLE table_name
	DROP COLUMN col_name;
```

* Change the datatype of a column in a table

```mysql
ALTER TABLE table_name
	MODIFY COLUMN col_name datatype;
```

### Costraints

Constraints can be specified when the table is created with **CREATE TABLE** or **ALTER TABLE**

```mysql
CREATE TABLE table_name{
	col1 datatype constraint,
	col2 datatype constraint,
	col3 datatype constraint,
	...
};
```

* NOT NULL: the column cannot have a NULL value
* UNIQUE: all values in the column are different
* PRIMARY KEY: A combination of NOT NULL and UNIQUE, can only have **one** primary key
* FOREIGN KEY: Uniquely identifies a row/record in another table
* CHECK: 
* DEFAULT:
* INDEX:

### Primary Key

Primary key is a combination of NOT NULL and UNIQUE, can only have **one** primary key

```mysql
CREATE TABLE table_name{
	col1 datatype,
	col2 datatype,
	col3 datatype,
	...
	PRIMARY KEY (col_name)
};
```



### Foreign Key

A foreign key is used to link two tables together, and a field in one table that refers to the **primary key** in another table

```mysql
CREATE TABLE table_name{
	col1 datatype,
	col2 datatype,
	col3 datatype,
	...
	FOREIGN KEY (col_name) REFERENCES table_name(col_name)
};
```



## SQL Table

### SELECT

```mysql
# Select and return specified data
SELECT col1, col1, ...
FROM table_name;

# Return all data
SELECT * FROM table_name;

# Slect and return only distinct values
SELECT DISTINCT col1, col2, ...
FROM table_name
```

### Where

* Used to extract only those records that fulfill a specified condition, can be used in SELECT, UPDATE, DELETE

```mysql
SELECT col1, col2, ...
FROM table_name
Where condition;

# AND
SELECT col1, col2, ...
FROM table_name
Where condition1 AND condition2 ...;

SELECT col1, col2, ...
FROM table_name
Where condition1 OR condition2 ...;

SELECT col1, col2, ...
FROM table_name
Where NOT condition;
```

* =, <, >, <=, >=, <>(not equal), BETWEEN, LIKE, IN

### Order by

```mysql
# If col has same value, then order by col2
SELECT col1, col2, ...
FROM table_name
ORDER BY col1, col2, ...;

# Ascending by col1, descending by col2
SELECT col1, col2, ...
FROM table_name
ORDER BY col1 ASC, col2 DESC;
```

### Insert

```mysql
INSERT INTO table_name (col1, col2, ...)
VALUES (v1, v2, ...)
```

### Update

```mysql
UPDATE table_name
SET col1 = v1, col2 = v2, ...
WHERE condition;
```

### Delete

```mysql
DELETE FROM table_name WHERE condition;
```

### Mi, Max, Average, Sum, Count

```mysql
SELECT MIN(col_name)
FROM table_name
WHERE condition;

SELECT MAX(col_name)
FROM table_name
WHERE condition;

SELECT AVG(col_name)
FROM table_name
WHERE condition;

SELECT COUNT(col_name)
FROM table_name
WHERE condition;

SELECT SUM(col_name)
FROM table_name
WHERE condition;
```

### In, Between

```mysql
SELECT col_name
FROM table_name
WHERE col_name IN (v1, v2, ...);

SELECT col_name
FROM table_name
WHERE col_name BETWEEN v1 AND v2;
```

### Joins

* **Inner join** selects records that have matching values in both tables

```mysql
SELECT col1, col2, ...
FROM table1
INNER JOIN table2
ON table1.col_name = table2.col_name;
```

![SQL INNER JOIN](https://www.w3schools.com/sql/img_innerjoin.gif)

* **Left Join** returns all records from the left table, and matched records from right table

```mysql
SELECT col1, col2, ...
FROM table1
LEFT JOIN table2
ON table1.col_name = table2.col_name;
```

![SQL LEFT JOIN](https://www.w3schools.com/sql/img_leftjoin.gif)

* **Right join** returns all records right right table, and matched records from left table

```mysql
SELECT col1, col2, ...
FROM table1
RIGHT JOIN table2
ON table1.col_name = table2.col_name;
```

![SQL RIGHT JOIN](https://www.w3schools.com/sql/img_rightjoin.gif)

* **Full join** returns all records when there is a match in left and right table