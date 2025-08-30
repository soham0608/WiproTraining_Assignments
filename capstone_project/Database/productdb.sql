CREATE DATABASE IF NOT EXISTS productdb;
USE productdb;

CREATE TABLE products (
    pid INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL
);
