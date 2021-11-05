-- D. SELECT - SLIDE 25-44
-- 1. Toàn bộ thông tin các loại hàng
    -- Mặt hàng thuộc loại hàng là 'Thắt lưng'
    -- Top 5 mặt hàng có giá bán cao nhất
SELECT * FROM LoaiHang;

SELECT * FROM MatHang
WHERE MaLH = (SELECT MaLH FROM LoaiHang WHERE TenLH = 'Thắt lưng');

SELECT * FROM MatHang
LEFT JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
ORDER BY GiaBan DESC
LIMIT 5;
-- 2. Đơn hàng
	-- Được bán trong ngày 28/11/2019
    -- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
    -- Được bán trong tháng 11/2019
    -- Được giao hàng tại Hòa Khánh
    
SELECT * FROM donhang
WHERE CAST(thoigiandathang AS DATE) = '2020-12-18';

SELECT * FROM donhang
WHERE CAST(thoigiandathang AS DATE) > '2021-01-04' AND CAST(thoigiandathang AS DATE) < '2021-01-06';

SELECT * FROM donhang
WHERE CAST(thoigiandathang AS DATE) > '2019-11-01' AND CAST(thoigiandathang AS DATE) < '2019-11-30';

-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
UPDATE MatHang
LEFT JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
SET GiaBan = GiaBan*0.8
WHERE GiaBan;
SELECT * FROM MatHang
LEFT JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH;
-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
SELECT * FROM DonHang;
-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
SELECT DISTINCT MauSac FROM MatHang;
-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
SELECT MatHang.MaMH, MatHang.TenMH, DonHang.ThoiGianDatHang FROM MatHang
LEFT JOIN chitietdonhang ON MatHang.MaMH = chitietdonhang.MaMH
LEFT JOIN donhang ON chitietdonhang.MaDH = donhang.MaDH
WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18';

-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
SELECT * FROM MatHang
LEFT JOIN loaihang ON MatHang.MaMh = chitietmathang.MaMH
WHERE GiaBan > 100 AND GiaBan < 300;

-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
SELECT * FROM MatHang
LEFT JOIN loaihang ON MatHang.MaLH = loaihang.MaLH
WHERE TenLH IN ('Mũ', 'Thắt lưng');

-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
SELECT * FROM DonHang
WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-17' OR CAST(ThoiGianDatHang AS DATE) = '2021-01-05';

-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
SELECT * FROM mathang
LEFT JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
ORDER BY GiaBan ASC;
-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT * FROM mathang
LEFT JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
ORDER BY GiaBan DESC;
-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
SELECT * FROM mathang
LEFT JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
ORDER BY GiaBan ASC, GiaMua DESC;
-- 14. Đếm số lượng các mặt hàng trong hệ thống
SELECT SUM(soluong) AS 'Tong so luong'
FROM mathang
LEFT JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH;

-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
SELECT SUM(soluong) AS 'So luong giay da nam'
FROM mathang
LEFT JOIN chitietdonhang ON mathang.MaMH = chitietdonhang.MaMH
LEFT JOIN donhang ON chitietdonhang.MaDH = donhang.MaDH
WHERE MatHang.TenMH = 'Giày da Nam' AND CAST(donhang.ThoiGianDatHang AS DATE) = '2020-12-18';

-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
--     MaLoai  TenLoai SoLuong
-- 	1       Giày    20
-- 	2       Áo      28

SELECT MaLoai, TenLoai, SUM(soluong) AS 'So Luong'
FROM LoaiHang;

-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT mathang.MaMH, mathang.TenMH, MAX(GiaBan)
FROM loaihang
LEFT JOIN mathang ON loaihang.MaLH = mathang.MaLH
LEFT JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
WHERE loaihang.TenLH = 'Giày dép';
-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
SELECT TenLH, MAX(GiaBan)
FROM loaihang
LEFT JOIN mathang ON loaihang.MaLH = mathang.MaLH
LEFT JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
GROUP BY loaihang.TenLH;
-- 19. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống

SELECT loaihang.TenLH, COUNT(loaihang.TenLH) AS 'So Luong' 
FROM mathang
LEFT JOIN loaihang
ON mathang.MaLH = loaihang.MaLH
GROUP BY (loaihang.TenLH);
-- 20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
--     Điều kiện tổng số lượng > 20 mặt hàng
SELECT loaihang.TenLH, COUNT(loaihang.TenLH) AS 'So Luong' 
FROM mathang
LEFT JOIN loaihang
ON mathang.MaLH = loaihang.MaLH
GROUP BY (loaihang.TenLH)
HAVING COUNT(loaihang.TenLH) > 3;
-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
SELECT loaihang.TenLH, COUNT(loaihang.TenLH) AS 'So Luong' 
FROM mathang
LEFT JOIN loaihang
ON mathang.MaLH = loaihang.MaLH
GROUP BY loaihang.TenLH
ORDER BY COUNT(loaihang.TenLH) DESC
LIMIT 0, 1;
-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT loaihang.TenLH, AVG(GiaBan)
FROM loaihang
LEFT JOIN mathang ON loaihang.MaLH = mathang.MaLH
LEFT JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
GROUP BY loaihang.MaLH;
-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
SELECT TenLH, SUM(SoLuong) AS 'Tong so luong'
FROM loaihang
LEFT JOIN mathang ON loaihang.MaLH = mathang.MaLH
LEFT JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
GROUP BY loaihang.MaLH
ORDER BY SUM(chitietmathang.SoLuong) DESC
LIMIT 0, 3;
-- 24. Liệt kê những mặt hàng có MaLH = 2 và thuộc đơn hàng 1
SELECT mathang.*, donhang.MaDH FROM mathang
LEFT JOIN chitietdonhang
ON mathang.MaMH = chitietdonhang.MaMH
LEFT JOIN donhang
ON chitietdonhang.MaDH = donhang.MaDH
WHERE mathang.MaLH = 2 AND donhang.MaDH = 1;
-- 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 18/12
SELECT * FROM mathang
LEFT JOIN chitietdonhang
ON mathang.MaMH = chitietdonhang.MaMH
LEFT JOIN donhang
ON chitietdonhang.MaDH = donhang.MaDH
WHERE mathang.MaLH = 2 AND donhang.ThoiGianDatHang LIKE '%12-18%';
-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
SELECT * FROM mathang
LEFT JOIN chitietdonhang
ON mathang.MaMH = chitietdonhang.MaMH
LEFT JOIN donhang
ON chitietdonhang.MaDH = donhang.MaDH
LEFT JOIN loaihang
ON mathang.MaLH = loaihang.MaLH
WHERE loaihang.TenLH = 'Mũ' AND donhang.ThoiGianDatHang <> '2019-02-14';
-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
UPDATE chitietmathang 
SET GiaBan = 199
WHERE  chitietmathang.MaMH IN (
SELECT mathang.MaMH FROM mathang
LEFT JOIN loaihang
ON mathang.MaLH = loaihang.MaLH
WHERE loaihang.TenLH = 'Áo'
);

-- 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)
--     Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
CREATE TABLE LoaiHang_BACKUP(MaLH INT, TenLH VARCHAR(255));
INSERT INTO loaihang_backup(MaLH, TenLH)
SELECT * FROM loaihang;
-- 29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11
SELECT * FROM mathang
LEFT JOIN chitietdonhang
ON mathang.MaMH = chitietdonhang.MaMH
LEFT JOIN donhang
ON chitietdonhang.MaDH = donhang.MaDH
WHERE MaLH = 2 AND donhang.ThoiGianDatHang LIKE '%12-18%';
-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'
SELECT *, SUM(chitietmathang.SoLuong) AS 'Số lượng tồn kho nhiều nhất' FROM loaihang
LEFT JOIN mathang
ON loaihang.MaLH = mathang.MaLH
LEFT JOIN chitietmathang
ON mathang.MaMH = chitietmathang.MaMH
WHERE loaihang.TenLH IN ('Áo', 'Quần')
GROUP BY (mathang.TenMH)
ORDER BY SUM(chitietmathang.SoLuong) DESC
LIMIT 0, 2;
-- 31. Tính tổng tiền cho đơn hàng 02
--     Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
SELECT donhang.MaDH, SUM(chitietmathang.SoLuong * chitietmathang.GiaBan) AS 'Tong tien' FROM donhang
LEFT JOIN chitietdonhang
ON donhang.MaDH = chitietdonhang.MaDH
LEFT JOIN mathang
ON chitietdonhang.MaMH = mathang.MaMH
LEFT JOIN chitietmathang
ON mathang.MaMH = chitietmathang.MaMH
WHERE donhang.MaDH = 2
GROUP BY donhang.MaDH;
-- 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
-- 	SoDH ChiTietDonHang           TongTien
--     02   TenMH:GiaBan:SoLuong     100