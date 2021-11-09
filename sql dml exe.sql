-- B. DELETE

-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
DELETE FROM nhanvien
WHERE TenNV LIKE '%Hoàng%';
-- = equals
-- LIKE
-- xyz% startsWidth
-- %xyz endWidth
-- %xyz% contains

-- 2. Xóa bộ phận giao hàng trong hệ thống
DELETE FROM chucvu
WHERE TenCV LIKE 'Nhân viên giao hàng';

-- 3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ

-- SUB QUERY
DELETE FROM mathang
WHERE MaLH = ( SELECT MaLH
			   FROM LoaiHang
			   WHERE TenLH = 'Mũ');

-- 4. Xóa tất cả các mặt hàng trong hệ thống
DELETE FROM mathang;

-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 18/12/2020
  -- Thực hiện xóa các đơn hàng bị lỗi
-- ThoiGianDatHang: DateTime = Date + Time
-- ThoiGianDatHang LIKE '2020-12-18%'
-- ThoiGianDatHang = 'VARCHAR'
-- CAST(ThoiGianDatHang AS DATE) = STR_TO_DATE('18-12-2020', '%d-%m-%Y');
-- LOSSED, DYNAMIC TYPE
 
DELETE FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) = '2021-01-05';
-- default format: y-m-d  

-- C. UPDATE

-- 1. Cập nhật tên mới cho chức vụ có MaCV = 2 thành 'Bộ phận quản lý'

UPDATE ChucVu
SET TenCV = 'Bộ phận quản lý'
WHERE MaCV = 2;

-- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'
ALTER TABLE DonHang
ADD GhiChu TEXT;

UPDATE DonHang
SET GhiChu = 'Giao hàng sau 10h sáng'
WHERE MaDH = 1;

-- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật 

INSERT INTO ChiTietTinhTrangDonHang (MaDH, MaTT, MaNV, ThoiGian)
VALUES (1, 5, 2, '2020-12-16 20:40:40');

-- 4. Cập nhật số tiền cần thanh toán trong bảng hóa đơn thành 890 cho đơn hàng 01

INSERT INTO HoaDon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
VALUES(1, 1, current_timestamp(), 890);


-- 5. Cập nhật giá bán tất cả các mặt hàng thuộc loại hàng là 'Áo' thành 199K
UPDATE ChiTietMatHang
SET GiaBan = 199
WHERE MaLH IN ( SELECT MaLH 
			    FROM MatHang
			    WHERE MaLH = (SELECT MaLH FROM LoaiHang WHERE TenLH LIKE 'Áo'));
                
-- 6. Tạo 1 bảng SaoLuu_DonHang. Copy toàn bộ dữ liệu từ bảng DonHang bỏ vào SaoLuuDonHang
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

-- copy data
INSERT INTO SaoLuuDonHang(MaDH, DiaChiGiaoHang, SDTNguoiNhan, ThoiGianDatHang, PhiVanChuyen, TongTien, MaNV, MaKH, MaLHTT)
SELECT MaDH, DiaChiGiaoHang, SDTNguoiNhan, ThoiGianDatHang, PhiVanChuyen, TongTien, MaNV, MaKH, MaLHTT 
FROM DonHang;

-- D. SELECT 
-- 1. Toàn bộ thông tin các loại hàng
SELECT *
FROM LoaiHang;

-- Mặt hàng thuộc loại hàng là 'Thắt lưng'
SELECT *
FROM MatHang
WHERE MaLH = ( SELECT MaLH
			   FROM LoaiHang
			   WHERE TenLH LIKE '%Thắt Lưng%' );
-- Top 5 mặt hàng có giá bán cao nhất
SELECT mh.*,
	   ctmh.GiaBan
FROM MatHang mh 
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
ORDER BY ctmh.GiaBan DESC
LIMIT 0,5;

-- 2. Đơn hàng

-- Được bán trong ngày 18/12/2019
SELECT *
FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18';

-- Được bán từ ngày 16/12/2020 đến ngày 18/12/2020
SELECT *
FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) BETWEEN '2020-12-17'
					                AND '2020-12-19';
 
-- Được bán trong tháng 12/2020
SELECT *
FROM DonHang
WHERE MONTH(ThoiGianDatHang) = '12'
      AND YEAR(ThoiGianDatHang) = '2020';
                      
-- Được giao hàng tại Hòa Khánh
SELECT *
FROM DonHang
WHERE DiaChiGiaoHang LIKE '%Hòa Khánh';

-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%
SELECT mh.MaMH,
       mh.TenMH,
       ctmh.GiaBan,
       ctmh.GiaBan * 0.8 AS GiaKhuyenMai
FROM MatHang mh 
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH;

-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 18/12/2020
SELECT mh.MaMH, 
       ctmh.GiaBan,
       ctmh.GiaBan * 0.8 AS GiaBanKhuyenMai,
       curdate() NgayBan
FROM MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
WHERE curdate() = '2021-11-08';

-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
SELECT DISTINCT MauSac
FROM MatHang
WHERE NOT MauSac IS NULL;

-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 18/12/2020
SELECT mh.MaMH, GROUP_CONCAT(mh.TenMH) AS TenCacMH, dh.ThoiGianDatHang
FROM MatHang mh
JOIN DonHang dh
JOIN ChiTietDonHang ctdh
ON dh.MaDH = ctdh.MaDH
ON   ctdh.MaMH = mh.MaMH
WHERE CAST(dh.ThoiGianDatHang AS DATE) LIKE '2020-12-18%'
GROUP BY dh.MaDH;

-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
SELECT mh.MaMH, mh.TenMH, ctmh.GiaBan
FROM MatHang mh 
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
WHERE ctmh.GiaBan >= 100 AND ctmh.GiaBan <= 300;

-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
SELECT *
FROM MatHang
WHERE MaLH IN ( SELECT MaLH
			    FROM LoaiHang
			    WHERE TenLH IN ('Mũ', 'Thắt Lưng') );

-- 10. Liệt kê các đơn hàng được đặt trong ngày (18/12/2019, 05/01/2021)
SELECT *
FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) IN ('2020-12-18%', '2021-01-05%');

-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
SELECT *
FROM ChiTietMatHang
ORDER BY GiaBan ASC;

-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT *
FROM ChiTietMatHang
ORDER BY GiaMua DESC;

-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
SELECT *
FROM ChiTietMatHang
ORDER BY GiaBan ASC, GiaMua DESC;

-- 14. Đếm số lượng các mặt hàng trong hệ thống
SELECT COUNT(MaMH)
FROM MatHang;

-- 15. Số lượng 'Giày da Nam' được bán trong ngày 18/12/2020
SELECT dh.ThoiGianDatHang ,mh.MaMH, mh.TenMH, ctdh.SoLuong
FROM MatHang mh
JOIN DonHang dh
JOIN ChiTietDonHang ctdh
ON dh.MaDH = ctdh.MaDH
ON ctdh.MaMH = mh.MaMH
WHERE mh.TenMH = 'Giày da nam';

-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
   -- MaLoai  TenLoai SoLuong
   -- 1       Giày    20
   -- 2       Áo      28  
SELECT lh.MaLH,
	   lh.TenLH,
       SUM(ctmh.SoLuong) AS SoLuongMatHang
FROM LoaiHang lh
JOIN MatHang mh
ON mh.MaLH = lh.MaLH
JOIN ChiTietMatHang ctmh
ON ctmh.MaMH = mh.MaMH
GROUP BY mh.MaLH;

-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT mh.TenMH, lh.TenLH, MAX(ctmh.GiaBan) AS GiaBan
FROM LoaiHang lh
JOIN MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
ON mh.MaLH = lh.MaLH
WHERE lh.TenLH = 'Giày dép';

-- 18. Tìm thông tin mặt hàng có giá bán cao nhất của mỗi loại hàng
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

-- 19. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
SELECT lh.MaLH, lh.TenLH, SUM(ctmh.SoLuong) AS SoLuong 
FROM LoaiHang lh
JOIN MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
ON mh.MaLH = lh.MaLH
GROUP BY lh.MaLH;

-- 20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
--    Điều kiện tổng số lượng > 20 mặt hàng
SELECT lh.MaLH, lh.TenLH, SUM(ctmh.SoLuong) AS SoLuong 
FROM LoaiHang lh
JOIN MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
ON mh.MaLH = lh.MaLH
GROUP BY lh.MaLH
HAVING SoLuong > 200;

-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
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

-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT lh.MaLH, lh.TenLH, AVG(ctmh.GiaBan) AS GiaBanTrungBinh 
FROM LoaiHang lh
JOIN MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
ON mh.MaLH = lh.MaLH
GROUP BY lh.MaLH;

-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
SELECT lh.MaLH, lh.TenLH, SUM(ctmh.SoLuong) AS SoLuong 
FROM LoaiHang lh
JOIN MatHang mh
ON mh.MaLH = lh.MaLH
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
GROUP BY lh.MaLH
ORDER BY SoLuong DESC
LIMIT 3;

-- 24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 1
SELECT dh.MaDH, mh.MaLH, GROUP_CONCAT(mh.TenMH) AS TenMH
FROM DonHang dh
JOIN ChiTietDonHang ctdh 
ON dh.MaDH = ctdh.MaDH
JOIN MatHang mh
ON ctdh.MaMH = mh.MaMH
WHERE dh.MaDH = 1 AND mh.MaLH = 2
GROUP BY mh.MaLH; 

-- 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 18/12/2020
SELECT dh.ThoiGianDatHang, mh.MaLH, GROUP_CONCAT(mh.TenMH) AS TenMH
FROM DonHang dh
JOIN ChiTietDonHang ctdh 
ON dh.MaDH = ctdh.MaDH
JOIN MatHang mh
ON ctdh.MaMH = mh.MaMH
WHERE mh.MaLH = 2 AND CAST(dh.ThoiGianDatHang AS DATE) LIKE '2020-12-18%' 
GROUP BY mh.MaLH; 

-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
SELECT * 
FROM MatHang mh 
JOIN LoaiHang lh 
ON mh.maLH = lh.MaLH
WHERE lh.TenLH = "Mũ" 
AND mh.MaMH NOT IN (
            SELECT MaMH 
            FROM DonHang dh
            JOIN ChiTietDonHang ctdh
            ON dh.maDH = ctdh.maDH
			WHERE dh.ThoiGianDatHang LIKE "2020-02-14%"	);
-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
UPDATE ChiTietMatHang
SET GiaBan = 199
WHERE MaMH IN (SELECT MaMH FROM MatHang 
			   WHERE MaLH = (SELECT MaLH
							 FROM LoaiHang
							 WHERE TenLH = 'Áo'));
            

-- 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)
--    Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
-- 29. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 18/12
SELECT dh.ThoiGianDatHang, mh.MaLH, GROUP_CONCAT(mh.TenMH) AS TenMH
FROM DonHang dh
JOIN ChiTietDonHang ctdh 
ON dh.MaDH = ctdh.MaDH
JOIN MatHang mh
ON ctdh.MaMH = mh.MaMH
WHERE mh.MaLH = 2 AND CAST(dh.ThoiGianDatHang AS DATE) LIKE '%12-18%' 
GROUP BY mh.MaLH; 

-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'
SELECT mh.MaMH, mh.TenMH, SUM(ctmh.SoLuong) SoLuong 
FROM LoaiHang lh
JOIN MatHang mh
ON mh.MaLH = lh.MaLH
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
WHERE mh.MaLH IN (SELECT MaLH FROM LoaiHang WHERE TenLH IN ('Áo', 'Quần'))
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
-- 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
-- 	SoDH ChiTietDonHang           TongTien
--    02   TenMH:GiaBan:SoLuong     100
--    02   TenMH:GiaBan:SoLuong     100
SELECT dh.MaDH,
       GROUP_CONCAT(concat(mh.TenMH,':',ctmh.MaKC,':',ctmh.GiaBan,':',ctdh.SoLuong) SEPARATOR ' - ') ThongTinDonHang, 
       dh.PhiVanChuyen,
       SUM(ctdh.SoLuong * ctmh.GiaBan) + dh.PhiVanChuyen TongTien
FROM ChiTietMatHang ctmh
JOIN ChiTietDonHang ctdh
	ON ctmh.MaMH = ctdh.MaMH
JOIN DonHang dh
    ON dh.MaDH = ctdh.MaDH
JOIN MatHang mh
    ON mh.MaMH = ctdh.MaMH    
WHERE dh.MaDH = 2
GROUP BY dh.MaDH;