-- D. SELECT - SLIDE 25-44
-- 1. Toàn bộ thông tin các loại hàng
-- Mặt hàng thuộc loại hàng là 'Thắt lưng'
SELECT * FROM mathang
WHERE MaLH = (SELECT MaLH FROM loaihang WHERE TenLH LIKE 'Thắt lưng');
-- Top 5 mặt hàng có giá bán cao nhất
SELECT a.MaMH, TenMH, MauSac, MaKC, GiaBan FROM mathang a
		 JOIN chitietmathang b ON a.MaMH = b.MaMH
		 ORDER BY GiaBan DESC
LIMIT 5;
-- 2. Đơn hàng
-- Được bán trong ngày 28/11/2019
SELECT * FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18';
-- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
SELECT * FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) BETWEEN '2020-12-17' AND '2020-12-18';
-- Được bán trong tháng 11/2019
SELECT * FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) LIKE '%2020-12%';
-- Được giao hàng tại Hòa Khánh
SELECT * FROM donhang
WHERE DiaChiGiaoHang LIKE '%Hòa Khánh%';
-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
SELECT *, GiaBan * 0.8 as 'Gia Khuyen Mai'
FROM chitietmathang;
-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
SELECT *, GiaBan * 0.8 FROM chitietmathang
WHERE MaMH IN (SELECT MaMH 
			   FROM chitietdonhang 
               WHERE MaDH 
		   IN (SELECT MaDH 
			   FROM donhang 
               WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18'));
-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
SELECT DISTINCT MauSac FROM mathang;
-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 2020-12-18
SELECT * FROM mathang
WHERE MaMH IN (SELECT MaDH FROM chitietdonhang
			   WHERE  MaDH 
               IN (SELECT MaDH FROM donhang WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18')); 
-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
SELECT * FROM mathang
WHERE MaMH IN (SELECT MaMH FROM chitietmathang
			  WHERE GiaBan BETWEEN 100 AND 300);
-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
SELECT * FROM mathang
WHERE MaLH IN (SELECT MaLH FROM loaihang
			   WHERE TenLH LIKE '%Mũ%' OR TenLH LIKE '%Thắt lưng%');
-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
SELECT * FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18' OR CAST(ThoiGianDatHang AS DATE) = '2020-12-17';
-- ==============================================================
-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
SELECT * FROM chitietmathang
ORDER BY GiaBan;
-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT * FROM chitietmathang
ORDER BY GiaMua DESC;
-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
SELECT * FROM chitietmathang
ORDER BY GiaBan ASC, GiaMua DESC;
-- 14. Đếm số lượng các mặt hàng trong hệ thống
SELECT SUM(soluong) FROM chitietmathang;
-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
SELECT SUM(soluong) 'Giày da Nam(soluong)' 
FROM chitietdonhang
WHERE MaMH IN (SELECT MaMH 
			   FROM mathang 
               WHERE TenMH LIKE 'Giày da Nam')
AND   MaDH IN (SELECT MaDH 
			   FROM donhang 
               WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18');
-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
-- MaLoai  TenLoai SoLuong
-- 1       Giày    20
-- 2       Áo      28
SELECT a.MaLH, TenLH, SUM(SoLuong) 'số lượng theo loại'
FROM loaihang a JOIN mathang b ON a.MaLH = b.MaLH
				JOIN chitietmathang c ON b.MaMH = c.MaMH
GROUP BY a.MaLH;
-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT tenMH 'loại giày có giá cao nhất', MAX(GiaBan)
FROM loaihang a JOIN mathang b ON a.MaLH = b.MaLH
				JOIN chitietmathang c ON b.MaMH = c.MaMH
WHERE TenLH LIKE '%Giày%'
GROUP BY TenLH;
-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
SELECT tenMH 'mat hang', MAX(GiaBan)
FROM loaihang a JOIN mathang b ON a.MaLH = b.MaLH
				JOIN chitietmathang c ON b.MaMH = c.MaMH
GROUP BY TenLH;
-- 19. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
SELECT tenMH 'mat hang', SUM(SoLuong)
FROM loaihang a JOIN mathang b ON a.MaLH = b.MaLH
				JOIN chitietmathang c ON b.MaMH = c.MaMH
GROUP BY TenLH;
-- 20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
--    Điều kiện tổng số lượng > 20 mặt hàng
SELECT tenMH 'mat hang', SUM(SoLuong)
FROM loaihang a JOIN mathang b ON a.MaLH = b.MaLH
				JOIN chitietmathang c ON b.MaMH = c.MaMH
GROUP BY TenLH
HAVING SUM(soluong) > 140;
-- ==============================================================
-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
SELECT tenMH 'mat hang', MAX(SoLuong)
FROM loaihang a JOIN mathang b ON a.MaLH = b.MaLH
				JOIN chitietmathang c ON b.MaMH = c.MaMH;
-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT tenMH 'mat hang', AVG(SoLuong)
FROM loaihang a JOIN mathang b ON a.MaLH = b.MaLH
				JOIN chitietmathang c ON b.MaMH = c.MaMH
GROUP BY TenLH;
-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
SELECT tenMH 'mat hang', MAX(SoLuong)
FROM loaihang a JOIN mathang b ON a.MaLH = b.MaLH
				JOIN chitietmathang c ON b.MaMH = c.MaMH
GROUP BY TenLH
ORDER BY MAX(SoLuong) DESC
LIMIT 3;
-- 24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100
SELECT *
FROM loaihang a JOIN mathang b ON a.MaLH = b.MaLH
				JOIN chitietdonhang c ON b.MaMH = c.MaMH
WHERE a.MaLH = 2;
-- 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11
SELECT a.MaLH ,TenMH, ThoiGianDatHang
FROM loaihang a JOIN mathang b 		  ON a.MaLH = b.MaLH
				JOIN chitietdonhang c ON b.MaMH = c.MaMH
                JOIN donhang d 		  ON c.MaDH = d.MaDH
WHERE a.MaLH = 2 AND CAST(ThoiGianDatHang AS DATE) = '2020-12-18';
-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
SELECT 'không có mũ'
FROM mathang a  JOIN loaihang b 	  ON a.MaLH = b.MaLH
WHERE TenLH LIKE '%Mũ%'
AND MaMH NOT IN (SELECT MaMH FROM chitietdonhang c 
                JOIN donhang d ON c.MaDH = d.MaDH
				WHERE TenLH LIKE '%Mũ%' AND CAST(ThoiGianDatHang AS DATE) = '2020-12-17')
				;
-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
UPDATE chitietmathang
SET GiaBan = 199
WHERE MaMH IN (SELECT MaMH
			   FROM mathang
			   WHERE MaLH = (SELECT MaLH
							 FROM loaihang
							 WHERE TenLH LIKE '%Mũ%'));
-- 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)
CREATE TABLE LoaiHang_BACKUP (
MaLH INT NULL,
TenLH VARCHAR(255) NULL);
--    Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
INSERT INTO loaihang_backup(MaLH, TenLH)
SELECT MaLH, TenLH
FROM loaihang;
SELECT * FROM loaihang_backup;
-- 29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11
SELECT * FROM mathang
WHERE MaLH = 2 AND MaMH IN (SELECT MaMH
							FROM chitietdonhang
							WHERE MaDH IN (SELECT MaDH 
										   FROM donhang
										   WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18'));
-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'
SELECT a.MaMH, TenMH, MauSac, MaKC, SoLuong 
FROM mathang a JOIN chitietmathang b ON a.MaMH = b.MaMH
ORDER BY SoLuong DESC
LIMIT 2;
-- 31. Tính tổng tiền cho đơn hàng 02
-- Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
SELECT SUM(b.SoLuong * c.GiaMua) 'tong tien'
FROM donhang a JOIN chitietdonhang b ON a.MaDH = b.MaDH
			   JOIN chitietmathang c ON b.MaMH = c.MaMH
WHERE a.MaDH = 2;
-- 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
-- 	SoDH ChiTietDonHang           TongTien
--    02   TenMH:GiaBan:SoLuong     100
SELECT a.MaDH 'soDH', concat(d.tenMH, ' : ', c.GiaBan, ' : ', b.soluong ) ,SUM(b.SoLuong * c.GiaMua) 'tong tien'
FROM donhang a JOIN chitietdonhang b ON a.MaDH = b.MaDH
			   JOIN chitietmathang c ON b.MaMH = c.MaMH
               JOIN mathang d		 ON c.MaMH = d.MaMH
WHERE a.MaDH = 2;

