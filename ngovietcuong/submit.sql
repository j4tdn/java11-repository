-- D. SELECT 
-- 1. Toàn bộ thông tin các loại hàng
SELECT *
FROM LoaiHang;

-- Mặt hàng thuộc loại hàng là 'Thắt lưng'
SELECT *
FROM MatHang
WHERE MaLH = ( SELECT MaLH
			   FROM LoaiHang
			   WHERE TenLH = 'Thắt Lưng' );
-- Top 5 mặt hàng có giá bán cao nhất
SELECT mh.*, ctmh.GiaBan
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
WHERE ThoiGianDatHang BETWEEN DATE('2020-12-17')
					  AND DATE('2020-12-19');
 
-- Được bán trong tháng 12/2020
SELECT dh.MaDH, hd.NgayXuatHoaDon, hd.SoTienCanThanhToan
FROM DonHang dh
JOIN HoaDon hd
ON dh.MaDH = hd.MaDH
WHERE CAST(NgayXuatHoaDon AS DATE) LIKE '2020-12%';
                      
-- Được giao hàng tại Hòa Khánh
SELECT *
FROM DonHang
WHERE DiaChiGiaoHang LIKE '%Hòa Khánh';

-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%
SELECT mh.MaMH, mh.TenMH, ctmh.GiaBan, ctmh.GiaBan * 0.8 AS GiaKhuyenMai
FROM MatHang mh 
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH;

-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 18/12/2020
SELECT dh.MaDH,  dh.ThoiGianDatHang,hd.NgayXuatHoaDon, dh.TongTien * 0.8 AS TongTien
FROM DonHang dh
JOIN HoaDon hd
ON dh.MaDH = hd.MaDH
WHERE CAST(dh.ThoiGianDatHang AS DATE) LIKE '2020-12-18%';

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
WHERE CAST(ThoiGianDatHang AS DATE) IN ('2020-12-18%', '2021-01-05');

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
SELECT mh.MaLH, lh.TenLH, COUNT(mh.MaLH) AS SoLuong 
FROM LoaiHang lh
JOIN MatHang mh
ON mh.MaLH = lh.MaLH
GROUP BY mh.MaLH;

-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT mh.TenMH, lh.TenLH, MAX(ctmh.GiaBan) AS GiaBan
FROM LoaiHang lh
JOIN MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
ON mh.MaLH = lh.MaLH
WHERE lh.TenLH = 'Giày dép';

-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
SELECT lh.MaLH, lh.TenLH, mh.TenMH, MAX(ctmh.GiaBan) AS GiaBan
FROM LoaiHang lh
JOIN MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
ON mh.MaLH = lh.MaLH
GROUP BY lh.MaLH;

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
SELECT lh.MaLH, mh.TenMH, MAX(ctmh.SoLuong) AS SoLuong 
FROM LoaiHang lh
JOIN MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
ON mh.MaLH = lh.MaLH
GROUP BY lh.MaLH;

-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT lh.MaLH, lh.TenLH, AVG(ctmh.GiaBan) AS GiaBanTrungBinh 
FROM LoaiHang lh
JOIN MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
ON mh.MaLH = lh.MaLH
GROUP BY lh.MaLH;

-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
-- 24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100
-- 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11
-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
-- 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)
--    Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
-- 29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11
-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'
-- 31. Tính tổng tiền cho đơn hàng 02
--    Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
-- 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
-- 	SoDH ChiTietDonHang           TongTien
--    02   TenMH:GiaBan:SoLuong     100