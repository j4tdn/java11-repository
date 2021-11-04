-- 1. Toàn bộ thông tin các loại hàng
-- Mặt hàng thuộc loại hàng là 'Thắt lưng'
SELECT * FROM mathang
WHERE MaLH = (SELECT MaLH FROM loaihang WHERE TenLH LIKE 'Thắt lưng');

-- Top 5 mặt hàng có giá bán cao nhất
SELECT * FROM chitietmathang CT
JOIN mathang MH
ON CT.MaMH = MH.MaMH
ORDER BY CT.GiaBan desc
LIMIT 5;

-- 2. Đơn hàng
-- Được bán trong ngày 28/11/2019
SELECT * FROM donhang
WHERE date(ThoiGianDatHang) = '2020-12-18';
-- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
SELECT * FROM donhang
WHERE date(ThoiGianDatHang) BETWEEN '2020-12-17' AND '2020-12-18';
-- Được bán trong tháng 12/2019
SELECT * FROM donhang
WHERE date(ThoiGianDatHang) LIKE '%2020-12%';
-- Được giao hàng tại Hòa Khánh
SELECT * FROM donhang
WHERE DiaChiGiaoHang LIKE '%Hòa Khánh%';

-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
SELECT DISTINCT MauSac FROM mathang;

-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 2020-12-18
SELECT * FROM mathang
WHERE MaMH IN (SELECT MaDH FROM chitietdonhang
			   WHERE  MaDH 
               IN (SELECT MaDH FROM donhang WHERE date(ThoiGianDatHang) = '2020-12-18')); 
               
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
WHERE date(ThoiGianDatHang) = '2020-12-18' OR date(ThoiGianDatHang) = '2020-12-14';

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
SELECT COUNT(MaMH) FROM mathang;

-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
SELECT COUNT(MaMH)
FROM mathang
WHERE TenMH LIKE '%Giày da Nam%';

-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT tenMH 'loại giày có giá cao nhất', MAX(GiaBan)
FROM loaihang a JOIN mathang b ON a.MaLH = b.MaLH
				JOIN chitietmathang c ON b.MaMH = c.MaMH
WHERE TenLH LIKE '%Giày%';

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
HAVING SUM(soluong) > 20;

-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
SELECT tenMH 'mat hang', MAX(SoLuong)
FROM loaihang a JOIN mathang b ON a.MaLH = b.MaLH
				JOIN chitietmathang c ON b.MaMH = c.MaMH
GROUP BY TenLH;

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
