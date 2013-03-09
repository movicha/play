PlayCassie is an open-source library built to speed up developer productivity of developing a noSQL scalable solution.  PlayCassie leverages the schemaless concept of noSQL and embraces it, while speeding up developer productivity by allowing some partially structured data.

PlayCassie also embraces embedding information in rows so you can do quick one key lookups unlike JPA(which is for RDBMS system, not noSQL systems). On top of that, we still support relations between these datasets as well allowing you to do joins all while scaling to billions of users.

PlayCassie Feature List

Inheritance class hierarchy in one table is supported like hibernate
@NoSqlEmbedded for List<Integer>, List<LocalDate>, List<String>, etc. etc. (something NOT in JPA)
Support for queries on subclasses AND indices are only the size of the number of subclasses in the table as well so indices are kept small.
In PlayCassie, Entity can have a Cursor instead of List which is lazy read to prevent out of memory on VERY wide rows(another noSQL pattern not found in JPA)
PlayCassie Queries use way less resources from Cassandra cluster than CQL queries
Scalabla JQL(SJQL) supported which is modified JQL that scales(SQL doesn’t scale well)
Partitioning so you can query a one trillion row table in just ms with SJQL(Scalable Java Query Language)
Typical query support of <=, <, >, >= and = and no limitations here
Typical query support of AND and OR as well as parenthesis
Inner Join and Left Outer Join support (Must keep your very very large tables partitioned so you get very fast access times here)
Return Database cursor on query. See an example how it works
OneToMany, ManyToMany, OneToOne, and ManyToOne but the ToMany’s are NoSQL fashion not like RDBMS
Support of a findAll(Class c, List keys) as is typical in NoSQL to parallel the reads
flush() support – We protect you from failures!!!
First level read cache
Automatically creates ColumnFamilies at runtime. Check this example to know how easy it is to create an entity using PlayCassie
Includes it’s own in-memory database for TDD in your unit tests!!!!!
Saves you MORE data storage compared to other solutions
logging interface below the first level cache so you can see the raw operations on cassandra and optimize just like when you use hibernate’s logging
Log all your webservers logs to a fixed number of rows in cassandra so you can have one view into your webserver logs
A raw interface using only BigDecimal, BigInteger, and String types which is currently used to upload user defined datasets through a web interface(and we wire that into generating meta data so they can ad-hoc query on the NoSQL system)
An ad-hoc query interface that can query on any table that was from an Entity object. To us on other tables, you can also code up and save DboTableMeta objects and the ad-hoc query interface gets you query support into those tables
If you have some noSQL data and some Relational data, use PlayCassie and store your relational data in noSQL now and just maintain one database in production! As PlayCassie supports SQL, and many relations like *ToOne and *ToMany
Support for joda-time LocalDateTime, LocalDate, LocalTime which works way better than java’s Date object and is less buggy than java’s Date and Calendar objects
Command Line tool
Plugins for both PlayFramework 1.2.x and Playframework 2.x
Support for all major data types with an option to create your own custom converter
@NoSqlIndexed on subclass fields that create smaller indexes(only subclasses in the index)
 

Features soon to be added

Ability to index fields inside Embedded objects even if embedded object is a list so you can query them still
Map/Reduce tasks for re-indexing, or creating new indexes from existing data
MANY MANY optimizations can be made to increase performance like a nested lookahead loop join and other tricks that only work in noSQL
We are considering a stateless server that exposes JDBC BUT requires S-SQL commands (OR just SQL commands for non-partitioned tables)
Adding JDBC such legacy apps can work with non-partitioned tables AND other apps can be modified to prefix queries with the partition ids and still use JDBC so they can just make minor changes to their applications(ie. keep track of partition ids)!!!  NOTE: This is especially useful for reporting tools