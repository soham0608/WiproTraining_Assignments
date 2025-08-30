CREATE DATABASE IF NOT EXISTS userdb;
USE userdb;

-- 1. Roles Table
CREATE TABLE roles (
    rid INT PRIMARY KEY AUTO_INCREMENT,
    rname VARCHAR(50) NOT NULL
);

-- 2. Users Table
CREATE TABLE users (
    uid INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    rid INT,
    name VARCHAR(100),
    address VARCHAR(200),
    phoneno VARCHAR(10),
    enabled BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (rid) REFERENCES roles(rid)
);
