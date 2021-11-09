-- ======================= REFRESH DATA =======================

-- B. DELETE
-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
DELETE FROM NhanVien
WHERE TenNV LIKE '%Hoàng%'; 
-- =      equals
-- LIKE
-- xyz%   startsWidth
-- %xyz   endsWidth
-- %xyz%  contains

-- 2. Xóa bộ phận giao hàng trong hệ thống
DELETE FROM ChucVu
WHERE TenCV LIKE 'Nhân viên giao hàng';

-- 3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ
-- SUB QUERY
DELETE FROM MatHang
WHERE MaLH = (SELECT MaLH 
			  FROM LoaiHang
			  WHERE TenLH = 'Mũ');

-- 4. Xóa tất cả các mặt hàng trong hệ thống
DELETE FROM MatHang;

-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 18.12.2020
--    Thực hiện xóa các đơn hàng bị lỗi
-- ThoiGianDatHang: DateTime = Date + Time
-- ThoiGianDatHang = 'VARCHAR'
-- ThoiGianDatHang LIKE '2020-12-18%'
-- CAST(ThoiGianDatHang AS DATE) = STR_TO_DATE('17-12-2020', '%d-%m-%Y')
-- LOOSED, DYNAMIC TYPE

SELECT CAST(ThoiGianDatHang AS DATE) ThoiGianDathang FROM DonHang;
DELETE FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) = '2021-01-05'; -- default format: y-m-d

-- ======================= REFRESH DATA =======================
-- C. UPDATE
-- 1. Cập nhật tên mới cho chức vụ có MaCV = 2 thành 'Bộ phận quản lý'
UPDATE ChucVu
SET TenCV = 'Bộ phận quản lý'
WHERE MaCV = 2;

-- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'
ALTER TABLE DonHang ADD GhiChu TEXT;
SELECT * FROM DonHang;
UPDATE DonHang
SET GhiChu = 'Giao hàng sau 10H sáng'
WHERE MaDH = 1;

-- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật trạng thái
SELECT * FROM DonHang WHERE MaDH = 1;
SELECT * FROM TinhTrangDonHang;
SELECT * FROM ChiTietTinhTrangDonHang;

INSERT INTO ChiTietTinhTrangDonHang(MaDH, MaTT, MaNV, ThoiGian)
VALUES(1, 5, 2, '2020-12-16 20:20:40');

-- 4. Xóa hóa đơn cho đơn hàng 01 với số tiền cần thanh toán là 890
SELECT * FROM HoaDon;
INSERT INTO HoaDon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
VALUES(1, 1, current_timestamp(), 890);

-- 5. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng là 'mũ' thành 199K
UPDATE ChiTietMatHang
SET GiaBan = 199
WHERE MaMH IN (SELECT MaMH
			   FROM MatHang 
			   WHERE MaLH = (SELECT MaLH FROM LoaiHang WHERE TenLH LIKE 'Áo'));
SELECT * FROM ChiTietMatHang;

-- 6. Tạo 1 bảng SaoLuuDonHang. Copy toàn bộ dữ liệu từ bảng DonHang bỏ vào SaoLuuDonHang
-- Cấu trúc 2 bảng giống nhau

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

-- copy data
INSERT INTO SaoLuuDonHang
(
	MaDH,
	DiaChiGiaoHang,
    SDTNguoiNhan,
    ThoiGianDatHang,
    PhiVanChuyen,
    TongTien,
    MaNV,
    MaKH,
    MaLHTT
)
SELECT 
(
	MaDH,
	DiaChiGiaoHang,
    SDTNguoiNhan,
    ThoiGianDatHang,
    PhiVanChuyen,
    TongTien,
    MaNV,
    MaKH,
    MaLHTT
)
FROM DonHang;


-- 1. Toàn bộ thông tin các loại hàng
SELECT * FROM LoaiHang;

-- Mặt hàng thuộc loại hàng là 'Thắt lưng'
SELECT * 
FROM loaihang lh
JOIN mathang mh
ON lh.MaLH = mh.MaLH
WHERE lh.TenLH LIKE '%Thắt lưng%';

SELECT *
FROM MatHang
WHERE MaLH = (SELECT MaLH 
              FROM LoaiHang
              WHERE TenLH LIKE '%Thắt lưng%');

-- Top 5 mặt hàng có giá bán cao nhất
SELECT mh.*,
       ctmh.GiaBan 
FROM chitietmathang ctmh
JOIN mathang mh
ON ctmh.MaMH = mh.MaMH
ORDER BY ctmh.GiaBan DESC
LIMIT 5;


-- 2. Đơn hàng
-- Được bán trong ngày 28/11/2019
SELECT * 
FROM DonHang
WHERE CAST(thoigiandathang AS DATE) = '2021-11-28'; 

-- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
SELECT * 
FROM DonHang
WHERE CAST(thoigiandathang AS DATE) BETWEEN '2021-11-28' AND '2021-12-02';

-- Được bán trong tháng 11/2019
SELECT * 
FROM DonHang
WHERE MONTH(ThoiGianDatHang) = 11 
AND YEAR(ThoiGianDatHang) = 2019;

-- Được giao hàng tại Hòa Khánh
SELECT * 
FROM DonHang
WHERE DiaChiGiaoHang LIKE 'Hòa Khánh';

-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân

-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
SELECT mh.MaMH,
       ctmh.GiaBan,
       ctmh.GiaBan * 0.8 GiaBanKhuyenMai,
       curdate() NgayBan
FROM MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
WHERE curdate() = '2021-11-06';


-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)

-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
-- MaLoai  TenLoai SoLuong
--   1      Giày    20
--   2       Áo     28
SELECT  lh.MaLH,
		lh.TenLH,
        SUM(ctmh.SoLuong) SoLuongMatHang
        -- mh.TenMH,
        -- ctmh.MaKC,
        -- ctmh.SoLuong
FROM LoaiHang lh
JOIN MatHang mh
	ON lh.MaLH = mh.MaLH
JOIN ChiTietMatHang ctmh
	ON mh.MaMH = ctmh.MaMH
GROUP BY lh.MaLH;

-- 18. Tìm thông tin mặt hàng có giá bán cao nhất của mỗi loại hàng
SELECT  lh.MaLH,
		lh.TenLH,
        mh.TenMH,
        ctmh.MaKC,
        ctmh.SoLuong,
        ctmh.GiaBan
FROM LoaiHang lh
JOIN MatHang mh
	ON lh.MaLH = mh.MaLH
JOIN ChiTietMatHang ctmh
	ON mh.MaMH = ctmh.MaMH;
    
-- OUTPUT
-- CTE: COMMON TABLE EXPRESSION
WITH CTE_LoaiHang AS (
	SELECT  lh.MaLH,
			lh.TenLH,
			MAX(ctmh.GiaBan) GiaBanCaoNhat
	FROM LoaiHang lh
	JOIN MatHang mh
		ON lh.MaLH = mh.MaLH
	JOIN ChiTietMatHang ctmh
		ON mh.MaMH = ctmh.MaMH
	GROUP BY lh.MaLH
)
SELECT lh.MaLH,
       lh.TenLH,
       mh.MaMH,
       mh.TenMH,
       ctmh.GiaBan,
       ctmh.MaKC,
       lh.GiaBanCaoNhat
FROM CTE_LoaiHang lh
JOIN MatHang mh
	ON mh.MaLH = lh.MaLH
JOIN ChiTietMatHang ctmh
	ON mh.MaMH = ctmh.MaMH 
WHERE ctmh.GiaBan = lh.GiaBanCaoNhat;

WITH TEST1 AS (
   SELECT 'ROW1' as ROWX
),
TEST2 AS (
   SELECT 'ROW2' as ROWX
)
SELECT * FROM TEST1
UNION 
SELECT * FROM TEST2;

-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
-- B1: Tìm tổng số lượng nhiều nhất của mỗi loại hàng
WITH CTE_MatHang AS (
-- Số lượng mặt hàng lớn nhất của mỗi mặt hàng
   SELECT mh.MaMH,
          mh.TenMH,
          sum(ctmh.SoLuong) SoLuongMatHang
   FROM MatHang mh
   JOIN ChiTietMatHang ctmh
   ON mh.MaMH = ctmh.MaMH
   GROUP BY mh.MaMH
),
CTE_LoaiHang AS (
-- Số lượng mặt hàng lớn nhất của mỗi loại hàng
SELECT mh.MaLH,
       max(cte.SoLuongMatHang) SoLuongCaoNhat
FROM MatHang mh
JOIN CTE_MatHang cte
ON mh.MaMH = cte.MaMH
GROUP BY mh.MaLH
)
SELECT * 
FROM CTE_MatHang ctemh
JOIN MatHang mh
	ON ctemh.MaMH = mh.MaMH
JOIN CTE_LoaiHang ctelh
	ON mh.MaLH = ctelh.MaLH
WHERE ctemh.SoLuongMatHang = ctelh.SoLuongCaoNhat;

-- 23
SELECT mh.MaLH,
       lh.TenLH,
	   SUM(ctmh.SoLuong) SoLuong
FROM LoaiHang lh
JOIN MatHang mh
	ON lh.MaLH = mh.MaLH
JOIN ChiTietMatHang ctmh
    ON mh.MaMH = ctmh.MaMH
GROUP BY mh.MaLH
ORDER BY SoLuong DESC
LIMIT 3;

-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
UPDATE ChiTietMatHang
SET GiaBan = 199
WHERE MaMH IN (SELECT MaMH 
               FROM MatHang WHERE MaLH = (SELECT MaLH 
                                          FROM LoaiHang
                                          WHERE TenLH = 'Áo'));
                                          
-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'
-- B1: Tìm số lượng hàng còn lại của mỗi mặt hàng thuộc loại hàng 'Áo', 'Quần'
-- B2: ORDER BY SoLuongTon DESC
-- B3: LIMIT 2
SELECT mh.MaMH,
       mh.TenMH,
       SUM(ctmh.SoLuong) SoLuong
FROM MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
WHERE mh.MaLH IN (SELECT MaLH FROM LoaiHang
                  WHERE TenLH IN ('Áo', 'Quần'))
GROUP BY mh.MaMH
ORDER BY SoLuong DESC
LIMIT 2;

-- 31. Tính tổng tiền cho đơn hàng 02
-- Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng

SELECT dh.MaDH,
       SUM(ctdh.SoLuong * ctmh.GiaBan) + dh.PhiVanChuyen TongTien
FROM ChiTietMatHang ctmh
JOIN ChiTietDonHang ctdh
	ON ctmh.MaMH = ctdh.MaMH
JOIN DonHang dh
    ON dh.MaDH = ctdh.MaDH
WHERE dh.MaDH = 2;
