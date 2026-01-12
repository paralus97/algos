## Database Types

## Relational Databases

 - A type of database that organises data into rows and columns, which collectively form a table where the data points are related to each other. 
 - Data is typically structured across multiple tables, which can be joined together via a primary key or a foreign key
 - The columns (or fields) for the customer table might be Customer ID, Company Name, Company Address, Industry etc
 - columns for a transaction table might be Transaction Date, Customer ID, Transaction Amount, Payment Method, etc
 - The tables can be joined together with the common Customer ID field
 - Relational databases are also typically associated with transactional databases. This means that transactions are ACID compliant
    - Atomicity: All changes performed to the data are performed as a single op. If anything is unsuccessful, no changes performed. All changes are performed or none of them are.
    - Consistency: Data remains in a consistent state from start to finish.
    - Isolation: Intermediate state of a transaction or transactions effects are not visible to other transactions. Concurrent transactions appear to be serialized.
    - Durability: After transaction completion, changes to data persist, even in event of system failure.

ACID properties ensure reliable transaction processing.

### Relational Database Management System (RDBMS)

Organizes data based off a relational data model. A more specific refference to underlying DB software. Examples include MYSQL, POSTGRESQL, ORACLEDB.

They provide:
 - Data Structure
 - Multi-user access
 - Privilege Control
 - Network Access

### SQL

Sequel. Structured Query Language. Used to query RDBMS.

```sql
SELECT COMPANY_NAME, SUM(TRANSACTION_AMOUNT)

FROM TRANSACTION_TABLE A

LEFT JOIN CUSTOMER_TABLE B

ON A.CUSTOMER_ID = B.CUSTOMER_ID

WHERE YEAR(DATE) = 2022

GROUP BY 1

ORDER BY 2 DESC

```

## Relational vs. Non-Relational Databases

Main difference is that non relationals do not have a strict scema usually. They range from totally unstructured to semi-structured data.

NoSQL prioritises availability over consistency. Relational Databases always ensure in-sync info and consistency. NoSQL prefers always having a response over consistency, received response may be out of date/incorrect.  CAP theory, a DB usually has to be two of these only: Consistency, Availabilty or Partition Tolerance.

 - Key-value store
    - *Redis & Memcached* are examples of this kind of model. Data organised into a dictionary of key-value pairs, like a hash map. Not good for large dataset pulls
 - Document store
    - *MongoDB & Firebase* are examples. Stores data as documents, typically JSON, BSON, XML, YML etc. Ranges from unstructured to semi-structured but mostly semi-structured in practice.
    - Keeps data together, reduces the amount of translation required. Data schemas are *not* strict and do not need to match across documents i.e. name and firstname
    - Good for content management, profiles
    - Extra flexibility can lead to data corruption.
    - MEAN stack
 - Wide-column store
    - *Apache HBase & Apache Cassandra* are examples.
    - HBase is built on top of Hadoop Distibuted Files System, designed for storing sparse data sets. Common in Big Data apps.
    - Cassandra is made to manage large amounts of data across multiple servers and clustering that spans multiple data centers. Commonly used in realtime data analytics, social networking.
    - Stores information in columns. Enables users to only access the specific columns of info they need, more memory efficient but complex.
 - Graph store
    - *Neo4j, Aerospike, Microsoft Azure Cosmos DB & Amazon Neptune* are examples
    - Houses data from a knowledge graph. Data elements are stored as Nodes, Edges and Properties. Any object, person or place can be node.
    - Useful for applications where a network of connections between nodes needs to be maintained.
    - Neo4j is a java based graph database.


## Data Warehousing

A Data warehouse aggregates data from various sources into a central data store, optimised for query and analysis. Two processes: Extract, Transform and Load (ETL) or Extract, Load & Transform (ELT) are for cleaning, preparing, organizing data for business intelligence.

Data warehouses could ingest data from... Databases, Transactional Systems, CRM, anything. Business analytics is the key theme here. 

Warehouses are configured and designed for real-time analytics. Therfore, huge amounts of raw unstructured big data can cause issues in performance (latency, complexity, cost)


### How do Data Warehouses work?

Three tier architecture. Bottom, Middle and Top Tier

 - Bottom Tier (Ingesting and Transforming data (and loading))
    - Data flows from various sources into bottom tier. Cleaned and organised before storage in warehouse via ETL.
    - DWs primarily store structured data when possible. Data transformation occurs before loading in most cases.
    - Data lakes use ELT but we'll get to that. This is cause they can work with unstructured data better.
 - Middle Tier (Analytics Layer)
    - This tier contains the analytics engine. Can be powered by a custom Online Analytical Processing System (OLAP).
    - OLAP system helps for data mining, financial analysis etc.
 - Top Tier (End user, frontend)
    - Contains a frontend for users to interact with data warehouse by communicating with the Middle & Bottom Tiers.

Solutions for Warehouses are generally in 3 possible forms.
 - On-prem
    - Expensive and good for compliance
 - Cloud
    - Easy to set up and offers massive storage.
 - Hybrid
   - Best of both worlds!


### 3 Types of Data Warehouse Schema

Like regular SQL or NoSQL databases, schemas define how Warehouses organise data. Schemas are all dimensional data models to optimise retrieval speeds in OLAP systems.

2 parts of each schema
 - Fact Table
    - Stores Quantitative Data, for eample revenue amounts or number of products sold
 - Dimension Table
    - Stores contextual & descriptive information for facts. Examples might include product sold category, date of sale, who sold it etc.

Three core types of Schema. They are named in a way which makes them easy to remember. Star Schema, Snowflake Schema and Galaxy Schema.

 - Star Schema
    - Consists of a single central fact table surounded by Dimension Tables. Simplest, Fastest & most common.
 - Snowflake Schema
    - Has a central fact table connected to many normalised dimension tables, which may then connect to other dimension tables through many-to-one relationships. Low levels of redundancy but big performance cost.
 - Galaxy Schema
    - A Galaxy contains many star schemas that share links with dimension tables. Good for very complex warehouses.

### Other Warehouse Misc notes

Common ETL/ELT tools include either straight up Apache Spark for transformation or tooling built on top of Spark. Kafka can be part of the process too or introduce a means by which warehousing can take place.

## Snowflake (the warehouse solution, not schema)

Cloud-based data warehousing solution, scalable & Flexible. Seperates storage and compute resources (so thats likely the bottom tier and mid tier are highly independent). Its cloud native so it has pretty easy plugability with existing cloud infrastructure. Other classic cloud solutions for warehousing include *Amazon Redshift and Google BigQuery*
