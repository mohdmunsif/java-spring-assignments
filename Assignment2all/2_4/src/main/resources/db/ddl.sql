CREATE USER IF NOT EXISTS 'prospring5'@'localhost' IDENTIFIED BY 'prospring5';

DROP DATABASE IF EXISTS BOOKSDB_JPA;
CREATE DATABASE BOOKSDB_JPA;
USE BOOKSDB_JPA;
GRANT ALL PRIVILEGES ON BOOKSDB_JPA.* TO 'prospring5'@'localhost';
FLUSH PRIVILEGES;

/*in case of java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. */
SET GLOBAL time_zone = '+5:00';
 