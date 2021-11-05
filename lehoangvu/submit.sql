-- 1. Toàn bộ thông tin các loại hàng
    -- Mặt hàng thuộc loại hàng là 'Thắt lưng'
SELECT *
FROM MatHang
JOIN LoaiHang ON Mathang.MaLH = LoaiHang.MaLH
WHERE TenLH = 'Thắt lưng';

    -- Top 5 mặt hàng có giá bán cao nhất
SELECT *
FROM MatHang
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
ORDER BY GiaBan DESC 
LIMIT 5;

-- 2. Đơn hàng
	-- Được bán trong ngày 2020-12-18
SELECT *
FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18';

    -- Được bán từ ngày 2020-12-17 đến ngày 2020-12-18
SELECT *
FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) BETWEEN '2020-12-17' AND '2020-12-18';

    -- Được bán trong tháng 12/2020
SELECT *
FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) BETWEEN '2020-12-1' AND '2020-12-31';


    -- Được giao hàng tại Hòa Khánh
SELECT *
FROM DonHang
WHERE DiaChiGiaoHang LIKE '%Hòa Khánh';

-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân


SELECT TenMH, GiaBan, ROUND(GiaBan * 0.8, 2) as GiaBanSauKhiKM
FROM MatHang
JOIN ChiTietMatHang ON MatHang.MaMH = ChiTietMatHang.MaMH;

-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 2020-12-18


SELECT DonHang.MaDH, DonHang.ThoiGianDatHang, MatHang.TenMH, GiaBan, ROUND((ChiTietMatHang.GiaBan * 0.8), 2) as GiaBanSauKhiKM
FROM DonHang
JOIN ChiTietDonHang ON DonHang.MaDH = ChiTietDonHang.MaDH 
JOIN MatHang ON MatHang.MaMH = ChiTietDonHang.MaMH
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18';

-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.


SELECT MauSac
FROM MatHang
GROUP BY MauSac;

-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 2020-12-18

SELECT MatHang.MaMH, TenMH, ThoiGianDatHang
FROM MatHang
JOIN ChiTietDonHang ON MatHang.MaMH = ChiTietDonHang.MaMH
JOIN DonHang ON DonHang.MaDH = ChiTietDonHang.MaDH
WHERE CAST(ThoiGianDatHang as DATE) = '2020-12-18';

-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300

SELECT MatHang.MaMH, TenMH, GiaBan 
FROM MatHang
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
WHERE GiaBan BETWEEN 100 AND 300;

-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'

SELECT * 
FROM MatHang
JOIN LoaiHang ON MatHang.MaLH = LoaiHang.MaLH
WHERE LoaiHang.TenLH = 'Thắt Lưng' OR LoaiHang.TenLH = 'Mũ';

-- 10. Liệt kê các đơn hàng được đặt trong ngày (2020-12-17, 2020-12-18)

SELECT *
FROM DonHang 
WHERE CAST(ThoiGianDatHang AS DATE) BETWEEN '2020-12-17' AND '2020-12-18';

-- 11. Sắp xếp các mặt hàng với giá bán tăng dần

SELECT TenMH, GiaBan
FROM ChiTietMatHang 
JOIN MatHang ON MatHang.MaMH = ChiTietMatHang.MaMH
ORDER BY GiaBan ASC;

-- 12. Sắp xếp các mặt hàng với giá mua giảm dần

SELECT TenMH, GiaMua
FROM ChiTietMatHang 
JOIN MatHang ON MatHang.MaMH = ChiTietMatHang.MaMH
ORDER BY GiaMua DESC;

-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần

SELECT TenMH, GiaBan, GiaMua
FROM ChiTietMatHang 
JOIN MatHang ON MatHang.MaMH = ChiTietMatHang.MaMH
ORDER BY GiaBan ASC, GiaMua DESC;

-- 14. Đếm số lượng các mặt hàng trong hệ thống

SELECT COUNT(*) AS SoLuongMatHang
FROM MatHang;

-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019

SELECT COUNT(*) AS SoLuongGiayDaNamBan
FROM DonHang 
JOIN ChiTietDonHang ON ChiTietDonHang.MaDH = DonHang.MaDH
JOIN MatHang ON MatHang.MaMH = ChiTietDonHang.MaMH
WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18' AND TenMH = 'Giày da Nam';

-- 16. Đếm số lượng các mặt hàng theo từng loại hàng

--     MaLoai  TenLoai SoLuong
-- 	1       Giày    20
-- 	2       Áo      28


SELECT MatHang.MaLH AS MaLoai, TenLH AS TenLoai, SUM(ChiTietMatHang.SoLuong) AS SoLuong
FROM MatHang 
JOIN LoaiHang ON MatHang.MaLH = LoaiHang.MaLH
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
GROUP BY MatHang.MaLH;

--  17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'


SELECT * 
FROM MatHang 
JOIN LoaiHang ON LoaiHang.MaLH = MatHang.MaLH
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
WHERE TenLH = 'Giày dép'
ORDER BY GiaBan DESC
LIMIT 1;

--  18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng

SELECT TenLH, TenMH, MAX(GiaBan) AS GiaBanCaoNhat
FROM MatHang
JOIN LoaiHang ON LoaiHang.MaLH = MatHang.MaLH
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH 
GROUP BY MatHang.MaLH;

--  19. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống

SELECT TenMH AS TenMatHang, SUM(ChiTietMatHang.SoLuong) AS SoLuong
FROM MatHang 
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
GROUP BY ChiTietMatHang.MaMH;

--  20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
--      Điều kiện tổng số lượng > 20 mặt hàng


SELECT TenMH AS TenMatHang, SUM(ChiTietMatHang.SoLuong) AS SoLuong
FROM MatHang 
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
GROUP BY ChiTietMatHang.MaMH
HAVING SoLuong > 30;


--  21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng




--  22. Hiển thị giá bán trung bình của mỗi loại hàng


SELECT TenLH, SUM(ChiTietMatHang.GiaBan)/COUNT(ChiTietMatHang.MaMH) AS GiaBanTB
FROM LoaiHang
JOIN MatHang ON LoaiHang.MaLH = MatHang.MaLH
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
GROUP BY TenLH;

--  23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại (Có trừ số lượng đơn hàng người khác đặt mua?)


SELECT MatHang.MaLH AS MaLoai, TenLH AS TenLoai, SUM(ChiTietMatHang.SoLuong) AS SoLuong
FROM MatHang 
JOIN LoaiHang ON MatHang.MaLH = LoaiHang.MaLH
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
GROUP BY MatHang.MaLH
ORDER BY SoLuong DESC
LIMIT 3;

--  24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100


SELECT *
FROM MatHang
JOIN ChiTietDonHang ON MatHang.MaMH = ChiTietDonHang.MaMH
WHERE MaLH = 2 AND ChiTietDonHang.MaDH = 1;

--  25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11


SELECT *
FROM MatHang
JOIN ChiTietDonHang ON MatHang.MaMH = ChiTietDonHang.MaMH
JOIN DonHang ON DonHang.MaDH = ChiTietDonHang.MaDH
WHERE MaLH = 2 AND date_format(ThoiGianDatHang, '%d/%m') = '18/12';

--  26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019


SELECT * 
FROM MatHang 
JOIN LoaiHang ON LoaiHang.MaLH = MatHang.MaLH 
WHERE LoaiHang.TenLH = 'Áo' AND MaMH NOT IN (SELECT MaMH
											 FROM DonHang
                                             JOIN ChiTietDonHang ON ChiTietDonHang.MaDH = DonHang.MaDH
											 WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18');

--  27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199


UPDATE ChiTietMatHang 
SET GiaBan = 199
WHERE MaMH IN (
				SELECT MaMH 
				FROM MatHang
				JOIN LoaiHang ON LoaiHang.MaLH = MatHang.MaLH
				WHERE TenLH = 'Áo'
			  );

--  28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)


CREATE TABLE LoaiHang_BACKUP(
	MaLH int,
    TenLH VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
--      Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP

INSERT INTO LoaiHang_BACKUP(MaLH, TenLH)
SELECT MaLH, TenLH 
FROM LoaiHang;

--  29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11

SELECT *
FROM MatHang 
JOIN ChiTietDonHang ON MatHang.MaMH = ChiTietDonHang.MaMH
JOIN DonHang ON DonHang.MaDH = ChiTietDonHang.MaDH
WHERE MaLH = 2 AND DATE_FORMAT(ThoiGianDatHang, '%d/%m') = '18/12';

--  30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'

SELECT TenLH, TenMH, MAX(TongSoLuong)
FROM (
	SELECT TenLH, TenMH, SUM(SoLuong) AS TongSoLuong
	FROM MatHang
	JOIN LoaiHang ON LoaiHang.MaLH = MatHang.MaLH
	JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
	WHERE TenLH = 'Áo' OR TenLH = 'Quần'
	GROUP BY ChiTietMatHang.MaMH
) AS TEMP
GROUP BY TenLH;

--  31. Tính tổng tiền cho đơn hàng 02
--      Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
SELECT DonHang.MaDH, SUM(ChiTietMatHang.GiaBan * ChiTietDonHang.SoLuong) AS TongTien
FROM DonHang
JOIN ChiTietDonHang ON ChiTietDonHang.MaDH = DonHang.MaDH
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = ChiTietDonHang.MaMH
GROUP BY DonHang.MaDH;



--  32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
--  	SoDH ChiTietDonHang           TongTien
--      02   TenMH:GiaBan:SoLuong     100
SELECT d.MaDH AS  SoDH, concat(m.TenMH,':', n.GiaBan,':',p.SoLuong) AS ChiTietDonHang, 
(n.GiaBan * p.SoLuong) AS TongTien from hoadon d
			JOIN chitietdonhang p ON d.MaDH = p.MaDH
			JOIN chitietmathang n ON p.maMH = n.maMH
            JOIN mathang m ON n.MaMH = m.MaMH
            GROUP BY d.MaDH;