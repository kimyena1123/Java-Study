SHOW DATABASES;
USE delivery;

CREATE DATABASE delivery DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

CREATE TABLE `account`(
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

DROP table account;

SELECT * FROM `account`;
desc account;

## ---------------------------------------------------------------------------------------------
SHOW TABLES;

CREATE TABLE IF NOT EXISTS `user`(
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `address` VARCHAR(150) NOT NULL,
    `registered_at` DATETIME NULL,
    `unregistered_at` DATETIME NULL,
    `last_login_at` DATETIME NULL
)ENGINE = InnoDB;

DESC user;