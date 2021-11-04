USE java11_shopping;
SET FOREIGN_KEY_CHECKS = 0;

-- 1 -----------------------------------------
-- ChiTietMatHang
INSERT INTO `chitietmathang`
VALUES
(1, 'S', 'undefined.png', 120, 80, 20),
(1, 'M', 'undefined.png', 280, 190, 40),
(1, 'L', 'undefined.png', 240, 220, 80),
(2, 'S', 'undefined.png', 150, 130, 60),
(2, 'M', 'undefined.png', 200, 180, 120),
(3, 'L', 'undefined.png', 620, 550, 10),
(3, 'XL', 'undefined.png', 190, 130, 20),
(4, 'XL', 'undefined.png', 630, 580, 40),
(4, 'XXL', 'undefined.png', 200, 180, 60),
(5, 'S', 'undefined.png', 120, 80, 80),
(6, 'S', 'undefined.png', 140, 120, 10),
(6, 'M', 'undefined.png', 410, 350, 20),
(7, 'S', 'undefined.png', 180, 170, 60),
(7, 'M', 'undefined.png', 230, 200, 40),
(8, 'S', 'undefined.png', 230, 180, 200),
(9, 'M', 'undefined.png', 140, 120, 30),
(9, 'L', 'undefined.png', 320, 190, 50),
(10, 'S', 'undefined.png', 560, 520, 70),
(10, 'M', 'undefined.png', 80, 60, 90);

INSERT INTO `mathang` 
VALUES 
(1,'Áo sơ mi Nam','Trắng',1),(2,'Áo sơ mi Nữ','Đen',1), 
(3,'Quần tây Nam','Xanh',2),(4,'Quần jean Nam','Nâu',2),(5,'Quần jean Nữ','Trắng',2),
(6,'Giày da Nam','Đen',3),(7,'Giày thể thao Nữ','Vàng',3),
(8,'Thắt lưng Nam','Hồng',4),(9,'Thắt lưng Nữ','Xanh',4),
(10,'Mũ thể thao Nam','Trắng',5), (11,'Áo khoác','Hồng',1),(12,'Áo khoác','Trắng',1);

INSERT INTO `loaihang` 
VALUES (1,'Áo'),(2,'Quần'),
(3,'Giày dép'),
(4,'Thắt lưng'),
(5,'Mũ');

-- 2 -----------------------------------------

INSERT INTO `kichco`
VALUES ('L','L - Nam Nữ 41 - 50KG'),
('M','M - Nam Nữ 31 - 40KG'),
('S','S - Nam Nữ 21 - 30KG'),
('XL','XL - Nam Nữ 51 - 60KG'),
('XXL','XXL - Nam Nữ 61 - 70KG');

INSERT INTO `chitietdonhang` 
VALUES (1,1,1),(1,3,2),(1,4,1),(2,6,2),(2,8,2),(3,1,4),(3,2,2);

INSERT INTO `nhanvien` 
VALUES (1,'Lê Tèo','com1.default.tp@gmail.com','Nam Cao - Hòa Khánh - Đà Nẵng','0936 978 033','827ccb0eea8a706c4c34a16891f84e7b', 1),
(2,'Lê Na','com2.default.tp@gmail.com','Âu Cơ - Hòa Khánh - Đà Nẵng','0936 978 033','adcaec3805aa912c0d0b14a81bedb6ff', 2),
(3,'Hoàng Bửi','com3.default.tp@gmail.com','Nam Cao - Hòa Khánh - Đà Nẵng','0936 978 033','992a6d18b2a148cf20d9014c3524aa11', 2),
(4,'Ngọc Thành','com4.default.tp@gmail.com','Lê Độ - Hòa Khánh - Đà Nẵng','0936 978 033','c4ded2b85cc5be82fa1d2464eba9a7d3', 3),
(5,'Công Danh','com5.default.tp@gmail.com','Nam Cao - Hòa Khánh - Đà Nẵng','0936 978 033','099ebea48ea9666a7da2177267983138', 3);

-- ChucVu
INSERT INTO `chucvu`
VALUES(1, 'Quản lý'),
(2, 'Nhân viên bán hàng'),
(3, 'Nhân viên giao hàng');

-- 3 --------------------------------------------
INSERT INTO `khachhang` 
VALUES (1,'Lê Văn Khách','defaul.com.tp@gmail.com','Nam Cao - Hòa Khánh - Đà nẵng','0936 126 363','nf'),
(2,'Hoàng Văn Nam','defaul.com.tp@gmail.com','Phan Chu Trinh - Hải Châu 1 - Đà nẵng','036 126 363','nf'),
(3,'Nguyễn Nam Bằng','defaul.com.tp@gmail.com','Phan Chu Trinh - Hải Châu 1 - Đà nẵng','097 126 363','nf');

INSERT INTO `donhang` 
VALUES (1,'Âu Cơ - Hòa Khánh','034 767 2514','2020-12-18 16:33:20',20,0,1,1,1,''),
(2,'Nam Cao - Hòa Khánh','034 167 2514','2020-12-18 20:12:44',50,0,2,2,1,''),
(3,'Phan Chu Trinh - Hải Châu','034 267 2514','2020-12-17 18:19:24',0,0,3,1,1,''),
(4,'Lê Lai - Hải Châu','034 367 2514','2021-01-05 21:07:53',120,0,3,2,1,'');

INSERT INTO `chitiettinhtrangdonhang` 
VALUES (1,3,2,'2020-12-14 18:20:20'),(1,4,2,'2020-12-15 18:20:20'),(1,5,2,'2020-12-16 18:20:20'),(2,3,2,'2020-12-14 18:20:20'),(2,4,2,'2020-12-15 18:20:20'),(2,5,2,'2020-12-16 18:20:20'),(3,3,2,'2020-12-14 18:20:20'),(3,4,2,'2020-12-15 18:20:20'),(3,5,2,'2020-12-16 18:20:20');

INSERT INTO `tinhtrangdonhang` 
VALUES (1,'Yêu cầu đặt hàng'),(2,'Đặt hàng thành công'),(3,'Đang đóng gói'),(4,'Đang vận chuyển'),(5,'Giao hàng thành công');
-- 4 --------------------------------------------

INSERT INTO `loaihinhthanhtoan` VALUES (1,'Cash'),(2,'Visa Card');

-- HoaDon

SET FOREIGN_KEY_CHECKS = 1;