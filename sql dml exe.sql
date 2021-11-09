DELETE FROM NhanVien
WHERE TenNV LIKE '%Hoàng%';
-- = equals
-- xyz% startsWidth
-- %xyz endsWidth
-- %xyz% contains

DELETE FROM ChucVu
WHERE TenCV LIKE 'Nhân viên giao hàng';

-- SUB QUERY
DELETE FROM MatHang
WHERE MaLH = (SELECT MaLH FROM LoaiHang WHERE TenLH = 'Mũ');

DELETE FROM MatHang;

SELECT * FROM DonHang;
DELETE FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) = STR_TO_DATE('17-12-2020', '%d-%m-%y');
-- C2: WHERE CAST(ThoiGianDatHang AS DATE) = '2021-01-05'; -- default format y-m-d

UPDATE ChucVu
Set tenCV = 'Bộ phận quản lý'
WHERE MaCV = 2;

ALTER TABLE DonHang ADD GhiChu TEXT;
SELECT * FROM DonHang;
UPDATE DonHang
SET GhiChu = 'Giao hàng sau 10h sáng'
WHERE MaDH = 1;

SELECT * FROM DonHang WHERE MaDH = 1;
SELECT * FROM TinhTrangDonHang;
SELECT * FROM ChiTietTinhTrangDonHang;

INSERT INTO ChiTietTinhTrangDonHang(MaDH, MaTT, MaNV, ThoiGian)
VALUES(1, 5, 2, '2020-12-16 20:20:40');

SELECT * FROM HoaDon;
INSERT INTO HoaDon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
VALUES(1,1,current_timestamp(),890);

UPDATE ChiTietMatHang
SET GiaBan = 199
WHERE MaMH IN (SELECT MaMH FROM MatHang
				WHERE MaLH = (SELECT MaLH FROM LoaiHang WHERE TenLH LIKE 'Áo'));
                
SELECT * FROM ChiTietMatHang;



