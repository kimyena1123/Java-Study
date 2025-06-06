SHOW DATABASES;
USE simple_board;
SHOW tables;

-- -------------------------------
-- Table simple_board. 'board'
-- -------------------------------
CREATE TABLE IF NOT EXISTS `simple_board`.`board`(
    `id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
    `board_name` VARCHAR(100) NOT NULL COMMENT '게시판 이름',
    `status` VARCHAR(50) NOT NULL,
PRIMARY KEY(`id`))
ENGINE = innoDB;

-- -------------------------------
-- TABLE `simple_board`. `post`
-- -------------------------------

CREATE TABLE IF NOT EXISTS `simple_board`.`post`(
    `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
    `board_id` BIGINT(32) NOT NULL,
    `user_name` VARCHAR(50) NOT NULL,
    `password` VARCHAR(4) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `title` VARCHAR(100) NOT NULL,
    `content` TEXT NULL,
    `posted_at` DATETIME NOT NULL,
PRIMARY KEY(`id`))
ENGINE = innoDB;

-- -------------------------------
-- TABLE `simple_board`. `reply`
-- -------------------------------
CREATE TABLE IF NOT EXISTS `simple_board`.`reply`(
    `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
    `post_id` BIGINT(32) NOT NULL,
    `user_name` VARCHAR(50) NOT NULL,
    `password` VARCHAR(4) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `title` VARCHAR(100) NOT NULL,
    `content` TEXT NOT NULL,
    `replied_at` DATETIME NOT NULL,
PRIMARY KEY(`id`))
ENGINE = innoDB;