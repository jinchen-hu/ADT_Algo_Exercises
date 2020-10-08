# Hibernate

## What is Hibernate

A framework for persisting/saving Java objects in a database

## Benefits of Hibernate

* Hibernate handles all of the low-level SQL
* Minimizes the amount of JDBC code you have to develop
  * Hibernate uses JDBC for all database communications
* Hibernate provides the Object-to-Retional Mapping (ORM)
  * define mappign between Java class and database class

## Development Process

1. Add Hibernate Configuration file
2. Annotate Java class
   1. Map class to database table
   2. Map fields to database columns
3. Develop Java Code to perform database operations

## Two Key Players

|     CLASS      |                         DESCRIPTION                          |
| :------------: | :----------------------------------------------------------: |
| SessionFactory | Reads the Hibernate config file<br>Creates Session objects<br>Heavy-weight object<br>Only create once in your app |
|    Session     | Wraps a JDBC connection<br>Main object used to save/retrieve objects<br>Short-lived object<br>Retrieved from SessionFactory |

## ID Generation Strategies

|          NAME           |                         DESCRIPTION                          |
| :---------------------: | :----------------------------------------------------------: |
|   GenerationType.AUTO   |   Pick an appropriate strategy for the particular database   |
| GenerationType.IDENTITY |     Assigan primary keys using database identity column      |
| GenerationType.SEQUENCE |        Assign primary keys using a database sequence         |
|  GenerationType.TABLE   | Assign primary keys using an underlying database table to ensure uniqueness |

#### Create your own CUSTOM Strategy

* Create implementation of org.hibernate.id.IdentifierGenerator
* Override the method: public Serializable generate(...)