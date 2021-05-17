CREATE DATABASE attendance;

USE attendance;

CREATE TABLE users(
userId INT NOT NULL auto_increment,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
status VARCHAR(100) NOT NULL,
last_updated timestamp default current_timestamp,
created_at timestamp default current_timestamp,
Primary key(userId)
);