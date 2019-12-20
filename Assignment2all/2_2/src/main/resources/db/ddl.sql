CREATE USER IF NOT EXISTS 'Vitaly'@'localhost' IDENTIFIED BY 'YES';

DROP DATABASE IF EXISTS BOOKSDB_HIBERNATE;
CREATE DATABASE BOOKSDB_HIBERNATE;
USE BOOKSDB_HIBERNATE;
GRANT ALL PRIVILEGES ON BOOKSDB_HIBERNATE.* TO 'prospring5'@'localhost';
FLUSH PRIVILEGES;

/*in case of java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. */
SET GLOBAL time_zone = '+5:00';