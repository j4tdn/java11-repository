DELETE FROM NhanVien
WHERE TenNV = 'Văn Hoàng';

DELETE FROM ChucVu
WHERE TenCV LIKE 'Nhân viên giao hàng';

-- SUB QUERY 
DELETE FROM MatHang		
WHERE MaLH = (SELECT MaLH FROM LoaiHang WHERE TenLH = 'Mũ');


DELETE FROM MatHang;

DELETE FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) = STR_TO_DATE('17-12-2021', '%d-%m-%Y');
-- WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-17';

UPDATE ChucVu
Set TenCV = 'Bộ phận quản lý'
WHERE MaCV = 2;

ALTER TABLE DonHang ADD GhiChu TEXT;
SELECT * FROM DonHang;
UPDATE DonHang
Set GhiChu = 'Giao hàng sau 10h sáng'
WHERE MaDH = 1;

INSERT INTO chitiettinhtrangdonhang(MaDH, MaTT, MaNV, ThoiGian)
VALUES(1, 5, 2, '2020-12-16 20:20:40');
SELECT * FROM chitiettinhtrangdonhang;

SELECT * FROM HoaDon;
INSERT INTO HoaDon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
VALUES(1, 1, current_timestamp(), 890);

UPDATE chitietmathang 
SET GiaBan = 199
WHERE MaMH IN (SELECT MaMH FROM MatHang 
               WHERE MaLH = (SELECT MaLH From LoaiHang WHERE TenLH LIKE 'Áo'));
SELECT * FROM chitietmathang;

-- 6. BACKUP Tạo 1 bảng SaoLuu_DonHang: Copy toàn bộ dữ liệu từ bảng DonHang bỏ vào SaoLuu_DonHang
-- Cấu truc 2 bảng giống nhau
CREATE TABLE `SaoLuu_DonHang` (
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
SELECT * FROM SaoLuu_DonHang;

-- copy data
INSERT INTO SaoLuu_DonHang(MaDH, DiaChiGiaoHang, SDTNguoiNhan, ThoiGianDatHang, PhiVanChuyen, TongTien, MaNV, MaKH, MaLHTT)
SELECT MaDH, DiaChiGiaoHang, SDTNguoiNhan, ThoiGianDatHang, PhiVanChuyen, TongTien, MaNV, MaKH, MaLHTT FROM DonHang;

-- SELECT - EXERCISE
-- 1.
SELECT *
FROM MatHang
WHERE MatHang.MaLH = (SELECT MaLH FROM LoaiHang WHERE TenLH = 'Thắt Lưng');

SELECT MH.*, CT.GiaBan
FROM MatHang AS MH
LEFT JOIN ChiTietMatHang AS CT
ON MH.MaMH = CT.MaMH
ORDER BY CT.GiaBan DESC
LIMIT 5;

-- 2.
SELECT * FROM DonHang;
SELECT *
FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) = ('2020-12-18');

SELECT *
FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) BETWEEN ('2019-11-28') AND ('2019-12-2');

SELECT *
FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) BETWEEN ('2019-11-1') AND ('2019-11-30');

SELECT *
FROM DonHang
WHERE DiaChiGiaoHang Like ('%Hòa Khánh');

-- 3.
SELECT * FROM ChiTietMatHang;
SELECT *, ROUND(GiaBan*0.8, 2) AS GiaBanSauKhuyenMai
FROM ChiTietMatHang;
-- 4
SELECT * FROM DonHang;
SELECT * FROM chitietdonhang;
SELECT dh.*, ctdh.MaMH, ctdh.SoLuong, ROUND(ctmh.GiaBan*0.8, 2) AS GiaBan
FROM DonHang AS dh
JOIN ChiTietDonHang AS ctdh
ON dh.MaDH = ctdh.MaDH
JOIN ChiTietMatHang AS ctmh
ON ctdh.MaMH = ctmh.MaMH
WHERE CAST(dh.ThoiGianDatHang AS DATE) = ('2020-12-18'); 

-- 5.
SELECT DISTINCT MauSac
FROM MatHAng;

-- 7.
SELECT mh.MaMH, mh.TenMH, ThoiGianDatHang
FROM MatHang mh
JOIN ChiTietDonHang AS ctdh
ON mh.MaMH = ctdh.MaMH
JOIN DonHang AS dh
ON dh.MaDH = ctdh.MaDH
WHERE CAST(ThoiGianDatHang AS DATE) = ('2020-12-18');

-- 8.
SELECT * FROM ChiTietMatHang;
SELECT *
FROM MatHang
WHERE MatHang.MaMH IN (SELECT MaMH FROM ChiTietMatHang WHERE GiaBan BETWEEN 100 AND 300);

-- 9.
SELECT *
FROM MatHang
WHERE MatHang.MaLH IN (SELECT MaLH FROM LoaiHang WHERE TenLH IN ('Mũ', 'Thắt Lưng'));

-- 10
SELECT *
FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) IN ('2019-11-28', '2019-12-14');

-- 11.
SELECT *
FROM ChiTietMatHang
ORDER BY GiaBan ASC;

-- 12.
SELECT *
FROM ChiTietMatHang
ORDER BY GiaMua DESC;

-- 13.
SELECT *
FROM ChiTietMatHang
ORDER BY GiaBan ASC, GiaMua DESC;

-- 14.
SELECT COUNT(*) AS SoLuongMatHang
FROM MatHang;

-- 15.
SELECT SUM(ctdh.SoLuong) AS SoLuong
FROM MatHang AS mh
JOIN ChiTietDonHang AS ctdh
ON mh.MaMH = ctdh.MaMH
JOIN DonHang AS dh
ON ctdh.MaDH = dh.MaDH
WHERE mh.TenMH Like 'Giày da Nam' And CAST(dh.ThoiGianDatHang AS DATE) = '2020-12-18';

-- 16.
SELECT * FROM ChiTietMatHang;
SELECT * FROM LoaiHang;
SELECT * FROM MatHang;
SELECT lh.MaLH, lh.TenLH, SUM(ctmh.SoLuong)
FROM LoaiHang AS lh
JOIN MatHang AS mh
ON lh.MaLH = mh.MaLH
JOIN ChiTietMatHang AS ctmh
ON ctmh.MaMH = mh.MaMH
GROUP BY mh.MaLH;

-- 17.
SELECT * FROM chitietmathang;
SELECT mh.*, ctmh.MAKC, ctmh.GiaBan
FROM MatHang mh
JOIN LoaiHang lh
ON mh.MaLH = lh.MaLH
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
WHERE lh.TenLH = 'Giày dép'
ORDER BY ctmh.GiaBan ASC
LIMIT 1;

-- 18.
SELECT * FROM chitietmathang;
SELECT * FROM mathang;
SELECT lh.Malh, mh.*, ctmh.MAKC, MAX(GiaBan) AS GiaBan
FROM MatHang mh
JOIN LoaiHang lh
ON mh.MaLH = lh.MaLH
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
GROUP BY mh.MaLH;

-- 19.
SELECT * FROM chitietmathang;
SELECT mh.*, SUM(ctmh.SoLuong) AS TongSoLuong
FROM MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
GROUP BY MaMH;

-- 20.
SELECT * FROM chitietmathang;
SELECT mh.*, SUM(ctmh.SoLuong) AS TongSoLuong
FROM MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
GROUP BY MaMH
HAVING TongSoLuong > 20;

-- 21.
SELECT * FROM chitietmathang;
SELEcT * FRoM MatHang;
SELECT lh.Malh, mh.*, ctmh.MAKC, MAX(ctmh.SoLuong) AS SoLuong
FROM MatHang mh
JOIN LoaiHang lh
ON mh.MaLH = lh.MaLH
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
GROUP BY lh.MaLH;

-- 22.
SELECT lh.Malh, AVG(ctmh.GiaBan) AS GiaBanTrungBinh
FROM MatHang mh
JOIN LoaiHang lh
ON mh.MaLH = lh.MaLH
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
GROUP BY lh.MaLH;

-- 23.
SELECT lh.Malh, SUM(ctmh.SoLuong) as SoLuong
FROM MatHang mh
JOIN LoaiHang lh
ON mh.MaLH = lh.MaLH
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
GROUP BY lh.MaLH
ORDER BY SUM(ctmh.SoLuong) DESC
LIMIT 3;

-- 24.
SELECT * FROM Donhang;
SELECT mh.*, lh.MaLH, ctdh.MaDH
FROM LoaiHang lh
JOIN MatHang mh
ON lh.MaLH = mh.MaLH
JOIN ChiTietDonHang ctdh
ON ctdh.MaMH = mh.MaMH
WHERE lh.MaLH = 2 AND ctdh.MaDH = 100100;

-- 25.
SELECT mh.*, dh.ThoiGianDatHang
FROM MatHang mh 
JOIN ChiTietDonHang ctdh
On mh.MaMH = ctdh.MaMH
JOIN donhang dh
On dh.MaDH = ctdh.MaDH
where mh.MaLH = 2 and CAST(dh.ThoiGianDatHang AS DATE) LIKE "%11-28%";
-- 26.
SELECT mh.*, dh.ThoiGianDatHang
FROM MatHang mh
JOIN ChitietDonHang ctdh
ON mh.MaMH = ctdh.MaMH
JOIN Donhang dh
ON ctdh.MaDH = dh.MaDH
WHERE mh.TenMH = 'Mũ' AND CAST(dh.ThoiGianDatHang AS DATE) <> '2019-02-14';

-- 27.
UPDATE chitietmathang 
SET GiaBan = 199
WHERE MaMH IN (SELECT MaMH FROM MatHang 
               WHERE MaLH = (SELECT MaLH From LoaiHang WHERE TenLH LIKE 'Áo'));

-- 28.
CREATE TABLE LoaiHang_BACKUP(
	MaLH int,
    TenLH VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO LoaiHang_BACKUP(MaLH, TenLH)
SELECT MaLH, TenLH 
FROM LoaiHang;

-- 29
SELECT mh.*, dh.ThoiGianDatHang
FROM MatHang mh 
JOIN ChiTietDonHang ctdh
On mh.MaMH = ctdh.MaMH
JOIN donhang dh
On dh.MaDH = ctdh.MaDH
where mh.MaLH = 2 and CAST(dh.ThoiGianDatHang AS DATE) LIKE "%11-23%";

-- 30.
SELECT mh.*, MAX(ctmh.SoLuong) AS SoLuong
FROM MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
JOIN LoaiHang lh
ON mh.MaLH = lh.MaLH
WHERE lh.TenLH IN ('Áo', 'Quần')
GROUP BY mh.MaLH; 

-- 31. 
SELECT SUM(ctdh.SoLuong*ctmh.GiaBan) AS TongTien
FROM ChiTietDonHang ctdh
JOIN ChiTietMatHang ctmh
ON ctdh.MaMH = ctmh.MaMH
WHERE ctdh.MaDH = 2;

-- 32.
SELECT * FROM Donhang;
SELECT * FROM chitietdonhang;
SELECT * FROM chitietMatHang;
SELECT ctdh.MaDH, concat(mh.TenMH,':', ctmh.GiaBan, ':', ctmh.MaKC, ':',ctdh.SoLuong) as ChiTietDonHang, (ctdh.SoLuong*ctmh.GiaBan) AS TongTien
FROM ChiTietDonHang ctdh
JOIN ChiTietMatHang ctmh
ON ctdh.MaMH = ctmh.MaMH
JOIN MatHang mh
ON ctmh.MaMH = mh.MaMH
WHERE ctdh.MaDH = 2;
