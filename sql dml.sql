INSERT INTO LoaiHang(MaLH,TenLoai)
VALUES(1,"Áo sơ mi nam");



INSERT INTO MatHang(MaMH, TenMH,MauSac, MaLH) VALUES(2,"Áo sơ mi nữ","Đen",1);

SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO MatHang(MaMH, TenMH,MauSac, MaLH) VALUES(3,"Mũ RedHat","Đỏ",1),
(4,"Mũ WhiteHat","Trắng",3);

SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO LoaiHang(MaLH,TenLoai)
VALUES(3,"Mũ");