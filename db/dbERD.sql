Create Database test_db;
use test_db;
CREATE TABLE `user` (
    id int(10) NOT NULL AUTO_INCREMENT,
    email varchar(255),
    password varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    reset_password_token varchar(255),
    role varchar(255),
    PRIMARY KEY (id)
);
CREATE TABLE `order` (
    id int(10) NOT NULL AUTO_INCREMENT,
    order_time timestamp NULL,
    status varchar(255),
    total int(10),
    user_id int(10) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE order_detail (
    id int(10) NOT NULL AUTO_INCREMENT,
    order_id int(10) NOT NULL,
    product_name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE product (
    id int(10) NOT NULL AUTO_INCREMENT,
    name varchar(255),
    description varchar(255),
    image varchar(255),
    price int(10),
    category_id int(10) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE cart_item (
    id int(10) NOT NULL AUTO_INCREMENT,
    quantity int(10),
    user_id int(10) NOT NULL,
    product_id int(10) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE category (
    id int(10) NOT NULL AUTO_INCREMENT,
    name varchar(255),
    img_path varchar(255),
    PRIMARY KEY (id)
);
ALTER TABLE `order`
ADD CONSTRAINT FKorder523938 FOREIGN KEY (user_id) REFERENCES `user` (id);
ALTER TABLE order_detail
ADD CONSTRAINT FKorder_deta945545 FOREIGN KEY (order_id) REFERENCES `order` (id);
ALTER TABLE order_detail
ADD CONSTRAINT FKorder_deta169041 FOREIGN KEY (product_name) REFERENCES product (name);
ALTER TABLE cart_item
ADD CONSTRAINT FKcart_item248255 FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE cart_item
ADD CONSTRAINT FKcart_item178380 FOREIGN KEY (user_id) REFERENCES `user` (id);
ALTER TABLE product
ADD CONSTRAINT FKproduct822402 FOREIGN KEY (category_id) REFERENCES category (id);
