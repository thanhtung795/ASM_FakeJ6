-- 1. Bảng accounts
CREATE TABLE IF NOT EXISTS accounts (
    username VARCHAR(50) PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    fullname VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    photo VARCHAR(255)
);

-- 2. Bảng roles
CREATE TABLE IF NOT EXISTS roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- 3. Bảng authorities (quyền)
CREATE TABLE IF NOT EXISTS authorities (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    Roleid INT NOT NULL,
    FOREIGN KEY (username) REFERENCES accounts(username) ON DELETE CASCADE,
    FOREIGN KEY (Roleid) REFERENCES roles(id) ON DELETE CASCADE
);

-- 4. Bảng categories
CREATE TABLE IF NOT EXISTS categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

-- 5. Bảng products
CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    avaliable TINYINT(1) NOT NULL DEFAULT 1, -- 1: Còn hàng, 0: Hết hàng
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    image VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    id_category INT NOT NULL,
    FOREIGN KEY (id_category) REFERENCES categories(id) ON DELETE CASCADE
);
-- 6. Bảng Orders
CREATE TABLE IF NOT EXISTS Orders (
    id INT AUTO_INCREMENT PRIMARY KEY,               -- Khoá chính
    username VARCHAR(50),                            -- Khoá ngoại tham chiếu đến bảng accounts
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,  -- Ngày tạo
    address VARCHAR(255),                            -- Địa chỉ giao hàng
    FOREIGN KEY (username) REFERENCES accounts(username) ON DELETE SET NULL
);

-- 7. Bảng OrderDetails
CREATE TABLE IF NOT EXISTS OrderDetails (
    id INT AUTO_INCREMENT PRIMARY KEY,               -- Khoá chính
    id_order INT,                                    -- Khoá ngoại tham chiếu đến bảng Orders
    id_product INT,                                  -- Khoá ngoại tham chiếu đến bảng products
    price DECIMAL(10, 2) NOT NULL,                   -- Giá sản phẩm
    quantity INT NOT NULL,                           -- Số lượng sản phẩm
    FOREIGN KEY (id_order) REFERENCES Orders(id) ON DELETE CASCADE,
    FOREIGN KEY (id_product) REFERENCES products(id) ON DELETE CASCADE
);

