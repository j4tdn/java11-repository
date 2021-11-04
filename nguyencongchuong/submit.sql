-- SELECT
-- 1. Toàn bộ thông tin các loại hàng
-- Mặt hàng thuộc loại hàng là 'Thắt lưng'
SELECT * FROM mathang
WHERE MaLH in (SELECT MaLH FROM loaihang WHERE TenLH LIKE '%Thắt lưng%');

-- Top 5 mặt hàng có giá bán cao nhất
SELECT m.MaMH, TenMH, GiaBan 
FROM mathang m JOIN chitietmathang c ON m.MaMH = c.MaMH
ORDER BY c.GiaBan DESC
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
SELECT l.MaLH AS MaLoai, TenLH AS TenLoai, COUNT(m.MaLH) AS SoLuong
FROM mathang m JOIN loaihang l ON m.MaLH = l.MaLH
GROUP BY m.MaLH;

-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT m.MaMH, TenMH, TenLH, MAX(GiaBan)
FROM loaihang l JOIN mathang m ON l.MaLH = m.MaLH
JOIN chitietmathang c ON m.MaMH = c.MaMH
WHERE TenLH LIKE '%Giày%';

-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
SELECT m.MaMH, TenMH, TenLH, MAX(GiaBan)
FROM loaihang l JOIN mathang m ON l.MaLH = m.MaLH
JOIN chitietmathang c ON m.MaMH = c.MaMH
GROUP BY l.MaLH;

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
SELECT TenLH, MAX(SoLuong) 
FROM loaihang l JOIN mathang m ON l.MaLH = m.MaMH
JOIN chitietmathang c ON m.MaMH = c.MaMH
GROUP BY l.MaLH;

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