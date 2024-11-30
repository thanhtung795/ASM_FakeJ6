use lab8java6;

-- 1. Thêm dữ liệu vào bảng accounts
INSERT INTO accounts (username, email, fullname, password, photo) VALUES
('dinhquochuy', 'dinhquochuy@example.com', 'Đinh Quốc Huy', '$2a$12$gcehIK9MyNHe.byHrITf7uchHjoCyJuCrrjDTQZodiGzVvsGNjA26', 'photo1.jpg'),
('dinhquoctien', 'dinhquoctien@example.com', 'Đinh Quốc Tiên', '$2a$12$gcehIK9MyNHe.byHrITf7uchHjoCyJuCrrjDTQZodiGzVvsGNjA26', 'photo2.jpg'),
('vothanhtung', 'vothanhtung@example.com', 'Võ Thanh Tùng', '$2a$12$gcehIK9MyNHe.byHrITf7uchHjoCyJuCrrjDTQZodiGzVvsGNjA26', 'photo3.jpg'),
('vudangquang', 'vudangquang@example.com', 'Vũ Đăng Quang', '$2a$12$gcehIK9MyNHe.byHrITf7uchHjoCyJuCrrjDTQZodiGzVvsGNjA26', 'photo4.jpg'),
('buiminhquang', 'buiminhquang@example.com', 'Bùi Minh Quang', '$2a$12$gcehIK9MyNHe.byHrITf7uchHjoCyJuCrrjDTQZodiGzVvsGNjA26', 'photo5.jpg'); 

INSERT INTO roles (name) VALUES
('STAF'),
('DIRE'),
('CUSTOMER'); 


INSERT INTO authorities (username, Roleid) VALUES
('vothanhtung', 1),
('dinhquochuy', 3),
('dinhquoctien', 2),
('vudangquang', 2),
('buiminhquang', 3);

-- 3. Thêm dữ liệu vào bảng categories trước
INSERT INTO categories (name) VALUES
('Electronics'),
('Books'),
('Clothing'),
('Home Appliances'),
('Toys'),
('Groceries'),
('Stationery'),
('Beauty Products'),
('Footwear'),
('Accessories');
-- Danh sách tên sản phẩm mẫu cho từng loại category
INSERT INTO products (avaliable, created_date, image, name, price, Category_Id) VALUES
-- Electronics (Category ID 1)
(1, NOW(), '1001.jpg', 'Laptop', 12000000, 1),
(1, NOW(), '1002.jpg', 'Smartphone', 7200000, 1),
(1, NOW(), '1003.jpg', 'Tablet', 4800000, 1),
(1, NOW(), '1004.jpg', 'Smartwatch', 3600000, 1),
(1, NOW(), '1005.jpg', 'Bluetooth Speaker', 1800000, 1),
(1, NOW(), '1006.jpg', 'Wireless Earbuds', 1200000, 1),
(1, NOW(), '1007.jpg', 'Gaming Console', 9600000, 1),
(1, NOW(), '1008.jpg', 'Camera', 14400000, 1),
(1, NOW(), '1009.jpg', 'Drone', 19200000, 1),
(1, NOW(), '1010.jpg', 'VR Headset', 6000000, 1),

-- Books (Category ID 2)
(1, NOW(), '1011.jpg', 'Science Fiction Novel', 240000, 2),
(1, NOW(), '1012.jpg', 'Historical Fiction', 360000, 2),
(1, NOW(), '1013.jpg', 'Mystery Thriller', 288000, 2),
(1, NOW(), '1014.jpg', 'Self-Help Guide', 480000, 2),
(1, NOW(), '1015.jpg', 'Biography', 432000, 2),
(1, NOW(), '1016.jpg', 'Fantasy Adventure', 288000, 2),
(1, NOW(), '1017.jpg', 'Romance Novel', 192000, 2),
(1, NOW(), '1018.jpg', 'Children’s Book', 120000, 2),
(1, NOW(), '1019.jpg', 'Cookbook', 600000, 2),
(1, NOW(), '1020.jpg', 'Graphic Novel', 360000, 2),

-- Clothing (Category ID 3)
(1, NOW(), '1021.jpg', 'T-Shirt', 240000, 3),
(1, NOW(), '1022.jpg', 'Jeans', 480000, 3),
(1, NOW(), '1023.jpg', 'Jacket', 720000, 3),
(1, NOW(), '1024.jpg', 'Sweater', 600000, 3),
(1, NOW(), '1025.jpg', 'Dress', 960000, 3),
(1, NOW(), '1026.jpg', 'Shorts', 360000, 3),
(1, NOW(), '1027.jpg', 'Cap', 192000, 3),
(1, NOW(), '1028.jpg', 'Shoes', 1200000, 3),
(1, NOW(), '1029.jpg', 'Socks', 120000, 3),
(1, NOW(), '1030.jpg', 'Belt', 288000, 3),

-- Home Appliances (Category ID 4)
(1, NOW(), '1031.jpg', 'Vacuum Cleaner', 2400000, 4),
(1, NOW(), '1032.jpg', 'Microwave Oven', 3600000, 4),
(1, NOW(), '1033.jpg', 'Refrigerator', 12000000, 4),
(1, NOW(), '1034.jpg', 'Air Conditioner', 9600000, 4),
(1, NOW(), '1035.jpg', 'Washing Machine', 7200000, 4),
(1, NOW(), '1036.jpg', 'Water Heater', 2880000, 4),
(1, NOW(), '1037.jpg', 'Toaster', 600000, 4),
(1, NOW(), '1038.jpg', 'Coffee Maker', 1920000, 4),
(1, NOW(), '1039.jpg', 'Iron', 960000, 4),
(1, NOW(), '1040.jpg', 'Blender', 1440000, 4),

-- Toys (Category ID 5)
(1, NOW(), '1041.jpg', 'Action Figure', 360000, 5),
(1, NOW(), '1042.jpg', 'Building Blocks', 720000, 5),
(1, NOW(), '1043.jpg', 'Puzzle', 240000, 5),
(1, NOW(), '1044.jpg', 'Remote Control Car', 960000, 5),
(1, NOW(), '1045.jpg', 'Doll', 288000, 5),
(1, NOW(), '1046.jpg', 'Board Game', 600000, 5),
(1, NOW(), '1047.jpg', 'Stuffed Animal', 432000, 5),
(1, NOW(), '1048.jpg', 'Model Airplane', 840000, 5),
(1, NOW(), '1049.jpg', 'Yo-Yo', 120000, 5),
(1, NOW(), '1050.jpg', 'Kite', 168000, 5),

-- Groceries (Category ID 6)
(1, NOW(), '1051.jpg', 'Apples', 72000, 6),
(1, NOW(), '1052.jpg', 'Bananas', 36000, 6),
(1, NOW(), '1053.jpg', 'Carrots', 48000, 6),
(1, NOW(), '1054.jpg', 'Milk', 24000, 6),
(1, NOW(), '1055.jpg', 'Bread', 48000, 6),
(1, NOW(), '1056.jpg', 'Rice', 120000, 6),
(1, NOW(), '1057.jpg', 'Pasta', 96000, 6),
(1, NOW(), '1058.jpg', 'Eggs', 60000, 6),
(1, NOW(), '1059.jpg', 'Cheese', 84000, 6),
(1, NOW(), '1060.jpg', 'Chicken', 168000, 6);
