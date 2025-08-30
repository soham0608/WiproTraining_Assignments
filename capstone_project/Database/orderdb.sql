CREATE DATABASE IF NOT EXISTS orderdb;
USE orderdb;

-- Orders table
CREATE TABLE orders (
    oid INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    status ENUM('CREATED','CANCELLED') DEFAULT 'CREATED',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_order_user FOREIGN KEY (user_id) REFERENCES userdb.users(uid)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Order Items table
CREATE TABLE order_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    product_name VARCHAR(100),
    price DECIMAL(10,2),
    quantity INT NOT NULL,
    CONSTRAINT fk_orderitem_order FOREIGN KEY (order_id) REFERENCES orders(oid)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Cart Items table
CREATE TABLE cart_items (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    CONSTRAINT fk_cart_user FOREIGN KEY (user_id) REFERENCES userdb.users(uid)
        ON DELETE CASCADE ON UPDATE CASCADE
);
