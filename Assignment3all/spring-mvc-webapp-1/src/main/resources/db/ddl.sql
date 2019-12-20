CREATE USER IF NOT EXISTS 'prospring5'@'localhost' IDENTIFIED BY 'prospring5';

DROP DATABASE IF EXISTS BOOKSDB_MVC;
CREATE DATABASE BOOKSDB_MVC;
USE BOOKSDB_MVC;
GRANT ALL PRIVILEGES ON BOOKSDB_MVC.* TO 'prospring5'@'localhost';
FLUSH PRIVILEGES;

/*in case of java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. */
SET GLOBAL time_zone = '+5:00';