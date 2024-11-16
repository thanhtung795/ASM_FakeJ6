
-- 1. Thêm dữ liệu vào bảng accounts
INSERT INTO accounts (username, email, fullname, password, photo) VALUES
('dinhquochuy', 'dinhquochuy@example.com', 'Đinh Quốc Huy', '$2a$12$gcehIK9MyNHe.byHrITf7uchHjoCyJuCrrjDTQZodiGzVvsGNjA26', 'photo1.jpg'),
('dinhquoctien', 'dinhquoctien@example.com', 'Đinh Quốc Tiên', '$2a$12$gcehIK9MyNHe.byHrITf7uchHjoCyJuCrrjDTQZodiGzVvsGNjA26', 'photo2.jpg'),
('vothanhtung', 'vothanhtung@example.com', 'Võ Thanh Tùng', '$2a$12$gcehIK9MyNHe.byHrITf7uchHjoCyJuCrrjDTQZodiGzVvsGNjA26', 'photo3.jpg'),
('vudangquang', 'vudangquang@example.com', 'Vũ Đăng Quang', '$2a$12$gcehIK9MyNHe.byHrITf7uchHjoCyJuCrrjDTQZodiGzVvsGNjA26', 'photo4.jpg'),
('buiminhquang', 'buiminhquang@example.com', 'Bùi Minh Quang', '$2a$12$gcehIK9MyNHe.byHrITf7uchHjoCyJuCrrjDTQZodiGzVvsGNjA2 6', 'photo5.jpg');

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
INSERT INTO products (avaliable, created_date, image, name, price, id_category) VALUES
-- Electronics (Category ID 1)
(1, NOW(), '1001.jpg', 'Laptop', 500.0, 1),
(1, NOW(), '1002.jpg', 'Smartphone', 300.0, 1),
(1, NOW(), '1003.jpg', 'Tablet', 200.0, 1),
(1, NOW(), '1004.jpg', 'Smartwatch', 150.0, 1),
(1, NOW(), '1005.jpg', 'Bluetooth Speaker', 75.0, 1),
(1, NOW(), '1006.jpg', 'Wireless Earbuds', 50.0, 1),
(1, NOW(), '1007.jpg', 'Gaming Console', 400.0, 1),
(1, NOW(), '1008.jpg', 'Camera', 600.0, 1),
(1, NOW(), '1009.jpg', 'Drone', 800.0, 1),
(1, NOW(), '1010.jpg', 'VR Headset', 250.0, 1),

-- Books (Category ID 2)
(1, NOW(), '1011.jpg', 'Science Fiction Novel', 10.0, 2),
(1, NOW(), '1012.jpg', 'Historical Fiction', 15.0, 2),
(1, NOW(), '1013.jpg', 'Mystery Thriller', 12.0, 2),
(1, NOW(), '1014.jpg', 'Self-Help Guide', 20.0, 2),
(1, NOW(), '1015.jpg', 'Biography', 18.0, 2),
(1, NOW(), '1016.jpg', 'Fantasy Adventure', 12.0, 2),
(1, NOW(), '1017.jpg', 'Romance Novel', 8.0, 2),
(1, NOW(), '1018.jpg', 'Children’s Book', 5.0, 2),
(1, NOW(), '1019.jpg', 'Cookbook', 25.0, 2),
(1, NOW(), '1020.jpg', 'Graphic Novel', 15.0, 2),

-- Clothing (Category ID 3)
(1, NOW(), '1021.jpg', 'T-Shirt', 10.0, 3),
(1, NOW(), '1022.jpg', 'Jeans', 20.0, 3),
(1, NOW(), '1023.jpg', 'Jacket', 30.0, 3),
(1, NOW(), '1024.jpg', 'Sweater', 25.0, 3),
(1, NOW(), '1025.jpg', 'Dress', 40.0, 3),
(1, NOW(), '1026.jpg', 'Shorts', 15.0, 3),
(1, NOW(), '1027.jpg', 'Cap', 8.0, 3),
(1, NOW(), '1028.jpg', 'Shoes', 50.0, 3),
(1, NOW(), '1029.jpg', 'Socks', 5.0, 3),
(1, NOW(), '1030.jpg', 'Belt', 12.0, 3),

-- Home Appliances (Category ID 4)
(1, NOW(), '1031.jpg', 'Vacuum Cleaner', 100.0, 4),
(1, NOW(), '1032.jpg', 'Microwave Oven', 150.0, 4),
(1, NOW(), '1033.jpg', 'Refrigerator', 500.0, 4),
(1, NOW(), '1034.jpg', 'Air Conditioner', 400.0, 4),
(1, NOW(), '1035.jpg', 'Washing Machine', 300.0, 4),
(1, NOW(), '1036.jpg', 'Water Heater', 120.0, 4),
(1, NOW(), '1037.jpg', 'Toaster', 25.0, 4),
(1, NOW(), '1038.jpg', 'Coffee Maker', 80.0, 4),
(1, NOW(), '1039.jpg', 'Iron', 40.0, 4),
(1, NOW(), '1040.jpg', 'Blender', 60.0, 4),

-- Toys (Category ID 5)
(1, NOW(), '1041.jpg', 'Action Figure', 15.0, 5),
(1, NOW(), '1042.jpg', 'Building Blocks', 30.0, 5),
(1, NOW(), '1043.jpg', 'Puzzle', 10.0, 5),
(1, NOW(), '1044.jpg', 'Remote Control Car', 40.0, 5),
(1, NOW(), '1045.jpg', 'Doll', 12.0, 5),
(1, NOW(), '1046.jpg', 'Board Game', 25.0, 5),
(1, NOW(), '1047.jpg', 'Stuffed Animal', 18.0, 5),
(1, NOW(), '1048.jpg', 'Model Airplane', 35.0, 5),
(1, NOW(), '1049.jpg', 'Yo-Yo', 5.0, 5),
(1, NOW(), '1050.jpg', 'Kite', 7.0, 5),

-- Groceries (Category ID 6)
(1, NOW(), '1051.jpg', 'Apples', 3.0, 6),
(1, NOW(), '1052.jpg', 'Bananas', 1.5, 6),
(1, NOW(), '1053.jpg', 'Carrots', 2.0, 6),
(1, NOW(), '1054.jpg', 'Milk', 1.0, 6),
(1, NOW(), '1055.jpg', 'Bread', 2.0, 6),
(1, NOW(), '1056.jpg', 'Rice', 5.0, 6),
(1, NOW(), '1057.jpg', 'Pasta', 4.0, 6),
(1, NOW(), '1058.jpg', 'Eggs', 2.5, 6),
(1, NOW(), '1059.jpg', 'Cheese', 3.5, 6),
(1, NOW(), '1060.jpg', 'Chicken', 7.0, 6);
