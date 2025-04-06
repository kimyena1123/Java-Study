SHOW DATABASES;
DROP DATABASE user;
CREATE DATABASE book_store;
USE book_store;
SHOW tables;


CREATE TABLE `user`(
    `id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT 'primary key이다',
    `name` varchar(50) NOT NULL,
    `score` int NULL default 0,
PRIMARY KEY (`id`)
);

CREATE TABLE `book`(
    `id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT 'primary key이다',
    `name` varchar(50) NOT NULL,
    `category` varchar(50) NOT NULL,
    `amount` DECIMAL(14,0) NULL DEFAULT 0,
PRIMARY KEY (`id`)
);

SHOW tables;
DROP TABLE user;

