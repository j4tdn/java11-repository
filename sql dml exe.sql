DELETE FROM nhanvien
WHERE TenNV = 'Văn Hoàng';

DELETE FROM chucvu
WHERE MaCV = 3;

DELETE FROM mathang
WHERE MaLH = (SELECT MaLH FROM loaihang
			  WHERE TenLH = 'Mũ');

DELETE FROM mathang;

DELETE FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) = STR_TO_DATE('18-12-2020', '%d-%m-%y');

UPDATE chucvu
SET TenCV = 'Bộ phận quản lý'
WHERE MaCV = 2;

ALTER TABLE donhang
ADD GhiChu TEXT;

UPDATE donhang
SET GhiChu = 'Giao hàng sau 10h sáng'
WHERE MaDH = 1;

SELECT * FROM chitiettinhtrangdonhang;
INSERT INTO chitiettinhtrangdonhang (MaDH, MaTT, MaNV, ThoiGian)
VALUES(1, 5, 2, '2020-12-16 20:20:40');

INSERT INTO hoadon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
VALUES(1, 1, current_timestamp(), 890);

UPDATE chitietmathang
SET GiaBan = 199
WHERE MaMH IN (SELECT MaMH 
			   FROM mathang 
               WHERE MaLH = (SELECT MaLH FROM loaihang WHERE TenLH LIKE 'áo'));
SELECT * FROM chitietmathang;

-- 6. Tạo 1 bảng SaoLuu_DonHang. Copy toàn bộ dữ liệu từ bảng donhang bỏ vào SaoLuuDonHang
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
);

SELECT * FROM donhang;
SELECT * FROM SaoLuuDonHang;

-- copy data
INSERT INTO saoluudonhang
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
    MaLHTT) 
FROM donhang;

USE java11_shopping;
-- SELECT
-- 1. Toàn bộ thông tin các loại hàng
SELECT * FROM loaihang;

-- Mặt hàng thuộc loại hàng là 'Thắt lưng'
SELECT * 
FROM mathang
WHERE MaLH in (SELECT MaLH 
			   FROM loaihang 
			   WHERE TenLH LIKE '%Thắt lưng%');

SELECT *
FROM mathang mh 
JOIN loaihang lh 
ON mh.MaLH = lh.MaLH
WHERE lh.TenLH LIKE '%Thắt lưng%';

-- Top 5 mặt hàng có giá bán cao nhất
SELECT mh.* , GiaBan 
FROM mathang mh 
JOIN chitietmathang ctmh 
ON mh.MaMH = ctmh.MaMH
ORDER BY ctmh.GiaBan DESC
LIMIT 5;

-- 2. Đơn hàng
-- Được bán trong ngày 28/11/2019
SELECT * FROM donhang
WHERE MaDH = (SELECT MaDH FROM hoadon 
WHERE CAST(NgayXuatHoaDon AS DATE) = STR_TO_DATE('28/11/2019', '%d/%m/%y'));

-- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
SELECT * FROM donhang
WHERE MaDH = (SELECT MaDH FROM hoadon 
WHERE CAST(NgayXuatHoaDon AS DATE) >= STR_TO_DATE('28/11/2019', '%d/%m/%y') 
AND CAST(NgayXuatHoaDon AS DATE) <= STR_TO_DATE('02/12/2019', '%d/%m/%y'));

-- Được bán trong tháng 11/2019
SELECT * FROM donhang
WHERE MaDH = (SELECT MaDH FROM hoadon
WHERE CAST(NgayXuatHoaDon AS DATE) >= STR_TO_DATE('1/11/2019', '%d/%m/%y')
AND CAST(NgayXuatHoaDon AS DATE) <= STR_TO_DATE('30/11/2019', '%d/%m/%y'));

-- Được giao hàng tại Hòa Khánh
SELECT * FROM donhang
WHERE DiaChiGiaoHang LIKE '%Hòa KHánh%';

-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
SELECT mh.MaMH,
	   ctmh.GiaBan,
       ctmh.GiaBan * 0.8 GiaBanKhuyenMai,
       curdate() NgayBan
FROM mathang mh 
JOIN chitietmathang ctmh
ON mh.MaMH = ctmh.MaMH
WHERE curdate() = '2019-11-25';

-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
SELECT DISTINCT MauSac FROM mathang;

-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
SELECT m.MaMH, TenMH, ThoiGianDatHang
FROM mathang m JOIN chitietdonhang c ON m.MaMH = c.MaMH
JOIN donhang d ON c.MaDH = d.MaDH
WHERE CAST(ThoiGianDatHang AS DATE) = STR_TO_DATE('23/11/2019', '%d/%m/%y');

-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
SELECT m.MaMH, TenMH, GiaBan 
FROM mathang m JOIN chitietmathang c ON m.MaMH = c.MaMH
WHERE GiaBan >=100 AND GiaBan <= 300;

-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
SELECT m.MaMH, TenMH, TenLH
FROM mathang m JOIN loaihang l ON m.MaLH = l.MaLH
WHERE TenLH LIKE '%Mũ%' OR TenLH LIKE '%Thắt lưng%';

-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
SELECT * FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) = STR_TO_DATE('28/11/2019', '%d/%m/%y')
OR CAST(ThoiGianDatHang AS DATE) = STR_TO_DATE('14/12/2019', '%d/%m/%y');

-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
SELECT m.MaMH, TenMH, GiaBan 
FROM mathang m JOIN chitietmathang c ON m.MaMH = c.MaMH
ORDER BY GiaBan ASC;

-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT m.MaMH, TenMH, GiaMua
FROM mathang m JOIN chitietmathang c ON m.MaMH = c.MaMH
ORDER BY GiaMua DESC;

-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
SELECT m.MaMH, TenMH, GiaBan, GiaMua
FROM mathang m JOIN chitietmathang c ON m.MaMH = c.MaMH
ORDER BY GiaBan ASC, GiaMua DESC;

-- 14. Đếm số lượng các mặt hàng trong hệ thống
SELECT COUNT(MaMH) FROM mathang;

-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
SELECT COUNT(MaMH)
FROM mathang
WHERE TenMH LIKE '%Giày da Nam%';

-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
--   MaLoai  TenLoai SoLuong
--    1       Giày    20
--    2       Áo      28

SELECT lh.MaLH,
	   lh.TenLH,
       sum(ctmh.SoLuong) SoLuongMatHang
       -- mh.TenMH,
       -- ctmh.MaKC,
       -- ctmh.SoLuong
FROM loaihang lh
JOIN mathang mh
ON lh.MaLH = mh.MaLH
JOIN chitietmathang ctmh
ON ctmh.MaMH = mh.MaMH
GROUP BY lh.MaLH;

-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT m.MaMH, TenMH, TenLH, MAX(GiaBan)
FROM loaihang l JOIN mathang m ON l.MaLH = m.MaLH
JOIN chitietmathang c ON m.MaMH = c.MaMH
WHERE TenLH LIKE '%Giày%';

-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
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
SELECT TenLH, SUM(SoLuong) 
FROM loaihang l JOIN mathang m ON l.MaLH = m.MaMH
JOIN chitietmathang c ON m.MaMH = c.MaMH
GROUP BY l.MaLH;

-- 20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
--     Điều kiện tổng số lượng > 20 mặt hàng
SELECT TenLH, SUM(SoLuong) 
FROM loaihang l JOIN mathang m ON l.MaLH = m.MaMH
JOIN chitietmathang c ON m.MaMH = c.MaMH
GROUP BY l.MaLH 
HAVING SUM(SoLuong) > 20;

-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
WITH CTE_mathang AS (
-- SoLuongMatHang của mỗi mặt hàng
	SELECT mh.MaMH,
		   mh.TenMH,
           SUM(ctmh.SoLuong) SoLuongMatHang
    FROM mathang mh
    JOIN chitietmathang ctmh
    ON mh.MaMH = ctmh.MaMH
    GROUP BY mh.MaMH
),
CTE_loaihang AS (
-- Số lượng mặt hàng lớn nhất của mỗi loại hàng
SELECT mh.MaLH,
	   MAX(cte.SoLuongMatHang) SoLuongCaoNhat
FROM mathang mh
JOIN CTE_mathang cte
ON mh.MaMH = cte.MaMH
GROUP BY mh.MaLH
)
SELECT *
FROM CTE_mathang ctemh
JOIN mathang mh
ON ctemh.MaMH = mh.MaMH
JOIN CTE_loaihang ctelh
ON ctelh.MaLH = mh.MaLH
WHERE ctemh.SoLuongMatHang = ctelh.SoLuongCaoNhat;
 
-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT m.MaMH, TenMH, TenLH, AVG(GiaBan)
FROM loaihang l JOIN mathang m ON l.MaLH = m.MaLH
JOIN chitietmathang c ON m.MaMH = c.MaMH
GROUP BY l.MaLH;

-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
SELECT l.TenLH, c.SoLuong
FROM loaihang l JOIN mathang m ON l.MaLH = m.MaLH
JOIN chitietmathang c ON m.MaMH = c.MaMH
ORDER BY c.SoLuong DESC
LIMIT 3;
	
-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
SELECT mh.*
FROM mathang mh JOIN chitietdonhang ctdh ON mh.MaMH = ctdh.MaMH
	 JOIN donhang dh ON dh.MaDH = ctdh.MaDH
     JOIN loaihang lh ON lh.MaLH = mh.MaLH
WHERE TenLH LIKE 'Mũ' AND CAST(ThoiGianDatHang AS DATE) = '2019/02/14';

-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
-- 31. Tính tổng tiền cho đơn hàng 02
--     Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
SELECT *
FROM 
										