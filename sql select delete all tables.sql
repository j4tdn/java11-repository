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
SET FOREGIN_KEY_CHECKS = 0;
TRUNCATE chitietdonhang;
TRUNCATE chitietmathang;
TRUNCATE chitiettinhtrangdonhang;
TRUNCATE chucvu;
TRUNCATE donhang;
TRUNCATE hoadon;
TRUNCATE khachhang;
TRUNCATE kichco;
TRUNCATE loaihang;
TRUNCATE loaihinhthanhtoan;
TRUNCATE mathang;
TRUNCATE nhanvien;
TRUNCATE tinhtrangdonhang;
SET FOREGIN_KEY_CHECKS = 1;