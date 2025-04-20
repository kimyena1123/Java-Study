SHOW DATABASES;
USE delivery;

CREATE DATABASE delivery DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

CREATE TABLE `account`(
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

DROP table account;

SELECT * FROM `account`;
desc account;

