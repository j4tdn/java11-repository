DELETE FROM nhanvien
WHERE TenNV LIKE '%Văn Hoàng';

DELETE FROM ChucVu
WHERE TenMH LIKE 'Nhân viên giao hàng'; 

DELETE FROM mathang
WHERE MaLH = (SELECT MaLH
			  FROM loaihang
              WHERE TenLH = 'Mũ');

DELETE FROM mathang;

-- 5 
DELETE FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-17';

DELETE FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) = STR_TO_DATE('17-12-2020', '%d-%m-%Y');

-- UPDATE
UPDATE chucvu
SET TenCV = 'Bộ phận quản lý'
WHERE MaCV = 2;

-- 2
ALTER TABLE donhang
ADD GhiChu TEXT NULL;

UPDATE donhang
SET GhiChu = 'Giao hàng sau 10h sáng'
WHERE MaDH = 1;

-- 3
INSERT INTO ChiTietTinhTrangDonHang(MaDH, MaTT, MaNV, ThoiGian)
VALUE(1, 5, 2, '2020-12-16 20:20:40');

-- 4
SELECT * FROM hoadon;
INSERT INTO hoadon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
VALUE(1, 1, current_timestamp(), 890);

-- 5
UPDATE chitietmathang
SET GiaBan = 199
WHERE MaMH IN (SELECT MH.MaMH
			  FROM mathang AS MH JOIN loaihang AS LH ON MH.MaLH = LH.MaLH
              WHERE TenLH LIKE 'Mũ');
              
-- 6. Tạo 1 bảng SaoLuuDonHang. Copy toàn bộ dữ liệu từ bảng DonHang bỏ vào SaoLuuDonHang
CREATE TABLE `SaoLuuDonHang` (
  `MaDH` int(11) NOT NULL,
  `DiaChiGiaoHang` text NOT NULL,
  `SDTNguoiNhan` varchar(255) NOT NULL,
  `ThoiGianDatHang` datetime NOT NULL,
  `PhiVanChuyen` double NOT NULL,
  `TongTien` double NOT NULL,
  `MaNV` int(11) NOT NULL,
  `MaKH` int(11) NOT NULL,
  `MaLHTT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SELECT * FROM DonHang;
SELECT * FROM SaoLuuDonHang;

INSERT INTO saoluudonhang(
		MaDH,
		DiaChiGiaoHang,
		SDTNguoiNhan,
		ThoiGianDatHang,
		PhiVanChuyen,
		TongTien,
		MaNV,
		MaKH,
		MaLHTT)
SELECT  MaDH,
        DiaChiGiaoHang,
        SDTNguoiNhan,
        ThoiGianDatHang,
        PhiVanChuyen,
        TongTien,
        MaNV,
        MaKH,
        MaLHTT 
FROM donhang;