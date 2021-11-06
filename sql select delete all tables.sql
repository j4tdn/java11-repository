-- SELECT clause
SELECT * FROM chitietdonhang;
SELECT * FROM chitietmathang;
SELECT * FROM chitiettinhtrangdonhang;
SELECT * FROM chucvu;
SELECT * FROM donhang;
SELECT * FROM hoadon;
SELECT * FROM khachhang;
SELECT * FROM kichco;
SELECT * FROM loaihang;
SELECT * FROM loaihinhthanhtoan;
SELECT * FROM mathang;
SELECT * FROM nhanvien;
SELECT * FROM tinhtrangdonhang;

-- DELETE clause
SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM chitietdonhang;
DELETE FROM chitietmathang;
DELETE FROM chitiettinhtrangdonhang;
DELETE FROM chucvu;
DELETE FROM donhang;
DELETE FROM hoadon;
DELETE FROM khachhang;
DELETE FROM kichco;
DELETE FROM loaihang;
DELETE FROM loaihinhthanhtoan;
DELETE FROM mathang;
DELETE FROM nhanvien;
DELETE FROM tinhtrangdonhang;
SET FOREIGN_KEY_CHECKS = 1;