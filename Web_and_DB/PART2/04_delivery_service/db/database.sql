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

## ---------------------------------------------------------------------------------------------
# 어떤 카테고리에 어떤 가게가 생겼는지. ex) COFFEE_TEA 카테고리에 메가커피 생김, 햄버거 카테고리에 노브랜드 버거 가게 생김 등등

CREATE TABLE IF NOT EXISTS `delivery`.`store`(
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `address` VARCHAR(150) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `category` VARCHAR(50) NOT NULL,
    `star` DOUBLE DEFAULT 0,
    `thumbnail_url` VARCHAR(200) NOT NULL,
    `minimum_amount` DECIMAL(11,4) NOT NULL,
    `minimum_delivery_amount` DECIMAL(11,4) NOT NULL,
    `phone_number` VARCHAR(20) NOT NULL
)ENGINE = InnoDB;

## ---------------------------------------------------------------------------------------------
# 한 가게가 갖고 있는 메뉴들(1:N 관계) -> store가 1, store_menu가 N이다.

CREATE TABLE IF NOT EXISTS `delivery`.`store_menu`(
    `id` BIGINT(32) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `store_id` BIGINT(32) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `amount` DECIMAL(11,4) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `thumbnail_url` VARCHAR(200),
    `like_count` INT DEFAULT 0,
    `sequence` INT DEFAULT 0
)ENGINE = InnoDB;

##--------- INDEX -----------
# 인덱스는 책의 목차처럼, DB에서 데이터를 더 빠르게 찾기 위한 자료구조
# 성능 최적화를 위한 **인덱스(index)**를 추가하는 명령어
ALTER TABLE `delivery`.`store_menu` # delivery 데이터베이스의 store_menu 테이블을 수정하겠다는 뜻
ADD INDEX `idx_store_id` # 	idx_store_id라는 이름의 인덱스를 추가함
    (`store_id` ASC) VISIBLE; #	store_id 컬럼을 기준으로 오름차순 정렬로 인덱스를 생성, 인덱스를 보이게(VISIBLE) 설정


## ---------------------------------------------------------------------------------------------
# 상품 주문: 사용자가 상품을 주문하기 위한 테이블(1:N) <- user가 1, user_order가 N이다. 사용자는 여러개의 주문을 가질 수 있기 떄문.
CREATE TABLE IF NOT EXISTS `delivery`.`user_order`(
    `id` BIGINT(32) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` BIGINT(32) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `amount` DECIMAL(11,4) NOT NULL, # 가격
    `ordered_at` DATETIME, # 주문한 시간
    `accepted_at` DATETIME,  # 가맹점쪽에서 주문 수락한 시간
    `cooking_started_ at` DATETIME, # 가게에서 요리를 시작한 시간
    `delivery_started_at` DATETIME, # 배달원이 배달 시작한 시간
    `received_at` DATETIME, # 사용자가 배달 받은 시간
INDEX `idx_user_id`(`user_id` ASC) VISIBLE
)ENGINE = InnoDB;

ALTER TABLE user_order
    MODIFY COLUMN ordered_at DATETIME NULL,
    MODIFY COLUMN accepted_at DATETIME NULL,
    MODIFY COLUMN cooking_started_at DATETIME NULL,
    MODIFY COLUMN delivery_started_at DATETIME NULL,
    MODIFY COLUMN received_at DATETIME NULL;

desc user_order;

select * from user_order where user_id = 1;

CREATE TABLE IF NOT EXISTS `delivery`.`user_order_menu`(
    `id` BIGINT(32) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_order_id` BIGINT(32) NOT NULL,
    `store_menu_id` BIGINT(32) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
INDEX `idx_user_order_id`(`user_order_id` ASC) VISIBLE,
INDEX `idx_store_menu_id`(`store_menu_id`ASC) VISIBLE
)ENGINE = InnoDB;


# 스타벅스가 갖고 있는 메뉴 다 출력
select * from store_menu where store_id = 1;

# user1이 주문한 내역
select * from user_order where user_id = 1;

# user1이 주문한 상세내역 => 출력예시: 유저이름, 주문한 가게 이름, 총주문금액, 상세 주문 메뉴 이름, 상세 메뉴 가격
select * from user
                  JOIN user_order ON user.id = user_order.user_id
                  JOIN user_order_menu ON user_order.id = user_order_menu.user_order_id
                  JOIN store_menu ON store_menu.id = user_order_menu.store_menu_id
                  JOIN store ON store.id = store_menu.store_id
WHERE user.id = 1;


select * from user_order_menu where user_order_id = 1;
select * from user_order where id = 2 and user_id = 1;