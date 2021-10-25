CREATE DATABASE IF NOT EXISTS www;
USE www;
CREATE TABLE users ( 
	id int AUTO_INCREMENT,
	username varchar(20),
	fullname varchar(20),
	password varchar(128),
	PRIMARY KEY (id)
);


ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'toidayeu';
flush privileges;