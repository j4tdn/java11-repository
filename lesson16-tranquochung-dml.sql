-- 1 Toàn bộ thông tin các loại hàng
-- Mặt hàng thuộc loại hàng thắc lưng
SELECT mathang.*, chitietmathang.*
FROM mathang JOIN loaihang ON mathang.MaLH = loaihang.MaLH 
	 JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
WHERE TenLH LIKE 'Thắt Lưng';

-- Top 5 mặt hàng có giá bán cao nhất
SELECT *
FROM mathang JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
ORDER BY GiaBan DESC 
LIMIT 5;

-- 2 Đơn hàng
-- Được bán trong ngày 28/11/2019
SELECT *
FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) = '2019/11/28';
-- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
SELECT * 
FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) BETWEEN '2019/11/28' AND '2019/12/02';
-- Được bán trong tháng 11/2019
SELECT *
FROM donhang
WHERE MONTH(ThoiGianDatHang) = '11' AND YEAR(ThoiGianDatHang) = '2019';
-- Được giao hàng tại Hòa Khánh
SELECT * 
FROM donhang
WHERE DiaChiGiaoHang LIKE 'Hòa Khánh';

-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
SELECT mathang.MaMH, mathang.TenMH, ROUND(GiaBan * 20 / 100, 2) AS GiaBan 
FROM mathang JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH;

-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
SELECT donhang.MaDH, mathang.TenMH, chitietmathang.GiaBan AS GIABANDAU, (chitietmathang.GiaBan * 20 / 100) AS GIAGIAM
FROM donhang JOIN chitietdonhang ON donhang.MaDH = chitietdonhang.MaDH 
	 JOIN mathang ON mathang.MaMH = chitietdonhang.MaMH
     JOIN chitietmathang ON chitietmathang.MaMH = mathang.MaMH
WHERE DATE(ThoiGianDatHang) = '2020/12/18';

-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
SELECT DISTINCT MauSac
FROM mathang;

-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
SELECT DISTINCT mathang.MaMH, TenMH, ThoiGianDatHang
FROM donhang JOIN chitietdonhang ON donhang.MaDH = chitietdonhang.MaDH 
	 JOIN mathang ON mathang.MaMH = chitietdonhang.MaMH
WHERE CAST(ThoiGianDatHang AS DATE) = '2020/12/18';

-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
SELECT chitietmathang.*
FROM mathang JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
WHERE GiaBan BETWEEN 100 AND 300;

-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
SELECT mathang.*
FROM mathang JOIN loaihang ON mathang.MaLH = loaihang.MaLH
WHERE TenLH LIKE 'Mũ' OR TenLH LIKE 'Thắt lưng';

-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
SELECT *
FROM donhang
WHERE DATE(ThoiGianDatHang) BETWEEN '2019/11/28' AND '2019/12/14';

-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
SELECT mathang.*
FROM mathang JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
ORDER BY GiaBan ASC;

-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT mathang.*
FROM mathang JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
ORDER BY GiaMua ASC;

-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
SELECT mathang.*
FROM mathang JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
ORDER BY GiaBan ASC, GIAMUA DESC;

-- 14. Đếm số lượng các mặt hàng trong hệ thống
SELECT COUNT(*) AS SOLUONG
FROM mathang;

-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
SELECT COUNT(*) AS 'SL Giày da Nam'
FROM donhang JOIN chitietdonhang ON donhang.MaDH = chitietdonhang.MaDH
	 JOIN mathang ON mathang.MaMH = chitietdonhang.MaMH
     JOIN loaihang ON loaihang.MaLH = mathang.MaLH
WHERE CAST(ThoiGianDatHang AS DATE) = '2019/11/23' AND TenMH= 'Giày da Nam';

-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
--    MaLoai  TenLoai SoLuong
-- 	   1       Giày    20
--     2       Áo      28
SELECT DISTINCT loaihang.MaLH AS MaLoai, loaihang.TenLH AS TenLoai, COUNT(*) AS SoLuong
FROM mathang JOIN loaihang ON mathang.MaLH = loaihang.MaLH
	 JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
GROUP BY loaihang.MaLH;

-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT mathang.*
FROM loaihang JOIN mathang ON loaihang.MaLH = mathang.MaLH
	 JOIN chitietmathang ON chitietmathang.MaMH = mathang.MaMH
WHERE TenLH LIKE 'Giày'
ORDER BY GiaBan DESC
LIMIT 1;

-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng >>> Chưa làm xong
SELECT mathang.MaLH, mathang.MaMH, TenLH, GiaBan
FROM loaihang JOIN mathang ON loaihang.MaLH = mathang.MaLH
	 JOIN chitietmathang ON chitietmathang.MaMH = mathang.MaMH
GROUP BY loaihang.MaLH
HAVING GiaBan 
ORDER BY GiaBan DESC;

-- 19. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
SELECT loaihang.MaLH, SUM(SoLuong) AS SOLUONG
FROM loaihang JOIN mathang ON loaihang.MaLH = mathang.MaLH
	 JOIN chitietmathang ON chitietmathang.MaMH = mathang.MaMH
GROUP BY loaihang.MaLH;

-- 20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống >> Điều kiện tổng số lượng > 20 mặt hàng
SELECT loaihang.MaLH, COUNT(*) AS SOLUONG
FROM loaihang JOIN mathang ON loaihang.MaLH = mathang.MaLH
	 JOIN chitietmathang ON chitietmathang.MaMH = mathang.MaMH
GROUP BY loaihang.MaLH
HAVING COUNT(*) > 20;

-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng

-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT loaihang.MaLH, loaihang.TenLH, AVG(GiaBan) AS 'Giá Bán Trung Bình'
FROM loaihang JOIN mathang ON loaihang.MaLH = mathang.MaLH
	 JOIN chitietmathang ON chitietmathang.MaMH = mathang.MaMH
GROUP BY loaihang.MaLH;

-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
SELECT LoaiHang.MaLH, SUM(ChiTietMatHang.SoLuong) AS SoLuong
FROM MatHang JOIN LoaiHang ON MatHang.MaLH = LoaiHang.MaLH
     JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
GROUP BY LoaiHang.MaLH
ORDER BY SOLUONG
LIMIT 3;

-- 24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100
SELECT mathang.*
FROM mathang JOIN chitietdonhang ON mathang.MaMH = chitietdonhang.MaMH
WHERE MaLH = 2 AND MaDH = 1;

-- 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11
SELECT mathang.*
FROM mathang JOIN chitietdonhang ON mathang.MaMH = chitietdonhang.MaMH
	 JOIN donhang ON donhang.MaDH = chitietdonhang.MaDH
WHERE MaLH = 2 AND DAY(ThoiGianDatHang) = 28 AND MONTH(ThoiGianDatHang) = 11;

-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
SELECT mathang.*
FROM mathang JOIN chitietdonhang ON mathang.MaMH = chitietdonhang.MaMH
	 JOIN donhang ON donhang.MaDH = chitietdonhang.MaDH
     JOIN loaihang ON loaihang.MaLH = mathang.MaLH
WHERE TenLH LIKE 'Mũ' AND CAST(ThoiGianDatHang AS DATE) = '2019/02/14';

-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
UPDATE chitietmathang
SET chitietmathang.GiaBan = 199
WHERE chitietmathang.MaMH IN ( SELECT MaMH
							   FROM mathang JOIN loaihang ON mathang.MaLH = loaihang.MaLH
                               WHERE TenLH LIKE 'Áo');
                               
-- 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai) >> Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP ??
CREATE TABLE LoaiHang_BACKUP(
 MaLH INT PRIMARY KEY,
 TenLH VARCHAR(255) NOT NULL);

INSERT INTO LoaiHang_BACKUP(MaLH, TenLH)
SELECT (MaLH, TenLH)
FROM loaihang;
SELECT * FROM loaihang_backup;

-- 29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11
SELECT *
FROM mathang JOIN donhang ON chitietdonhang.MaDH = donhang.MaDH
WHERE MaLH = 2 AND DAY(ThoiGianDatHang) = 23 AND MONTH(ThoiGianDatHang) = 11;

-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần' ???
SELECT loaihang.MaLH, TenLH, SOLUONG
FROM mathang JOIN loaihang ON mathang.MaLH = loaihang.MaLH
	 JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
WHERE TenLH LIKE 'Áo' OR TenLH LIKE 'Quần'
GROUP BY loaihang.MaLH
HAVING SoLuong = MAX;
-- 31. Tính tổng tiền cho đơn hàng 02 >> Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng

-- 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
--	  SoDH ChiTietDonHang           TongTien
--    02   TenMH:GiaBan:SoLuong     100
SELECT COUNT(HoaDon.MaDH) AS SoDH, CONCAT(GROUP_CONCAT(MatHang.TenMH, GiaBan, ChiTietDonHang.SoLuong)) AS ChiTietDonHang, SUM(GiaBan) AS TongTien
FROM HoaDon JOIN DonHang ON hoadon.MaDH = donhang.MaDH
		 JOIN chitietdonhang ON chitietdonhang.MaDH = donhang.MaDH
		 JOIN MatHang ON ChiTietDonHang.MaMH = MatHang.MaMH
		 JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
WHERE MaDH = 02
GROUP BY MaDH;