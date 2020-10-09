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

## Entity LifeCycle

| Operations |                         Description                          |
| :--------: | :----------------------------------------------------------: |
|   Detach   | If entity is detached, it is not associated with a Hibernate session |
|   Merge    | If instance is detached from session, then merge will reattach to session |
|  Persist   | Transitions new instances to managed state. Nex flush/commit will save in db |
|   Remove   | Transitions managed entity to be removed. Next flush/commit will delete from db |
|  Refresh   |  Reload/synch object with data from db. Prevents stale data  |

## Cascade Types

| Cascade Types |                         Description                          |
| :-----------: | :----------------------------------------------------------: |
|    PERSIST    | If entity is persisted/saved, related entity will also be persisted |
|    REMOVE     | If entity is removed/deleted, related entity will be removed |
|    REFRESH    | If entity is refreshed, related entity will also be refreshed |
|    DETACH     | If entity is detached, then related entity will also be detached |
|     MERGE     | If entity is merged, then related entity will also be merged |
|      ALL      |                  All of above cascade types                  |

## Fetch Types: Eager vs Lazy Loading

* **Eage** will retrieve everything
* **Lazy** will retrieve on request
  * Load the main entity first
  * Load dependent entities on demand

## @JoinColumn

* If the join is for a OneToOne or ManyToOne mapping using a foreign key mapping strategy, the foreign key column is in the table of the source entity or embeddable.
* If the join is for a unidirectional OneToMany mapping using a foreign key mapping strategy, the foreign key is in the table of the target entity.
* If the join is for a ManyToMany mapping or for a OneToOne or bidirectional ManyToOne/OneToMany mapping using a join table, the foreign key is in a join table.
* If the join is for an element collection, the foreign key is in a collection table.