SHOW databases;
USE user;

CREATE TABLE `user`
(
    `id`    bigint(32)   NOT NULL AUTO_INCREMENT COMMENT 'index',
    `name`  varchar(40)  NOT NULL COMMENT '사용자 이름',
    `age`   int          NULL DEFAULT 1 COMMENT '사용자 나이',
    `email` varchar(100) NULL DEFAULT '' COMMENT '이메일 주소',
    PRIMARY KEY (`id`)
);

INSERT INTO `user` (`name`, `age`, `email`) VALUE ('홍길동', 20, 'hong@gmail.com');
INSERT INTO `user` (`name`, `age`) VALUE ('나길동', 22);
INSERT INTO `user` (`name`, `age`, `email`) VALUE ('박길동', 1, 'park@gmail.com');

select * from user;

# TRUNCATE user;
