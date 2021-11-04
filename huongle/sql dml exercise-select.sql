-- ======================= REFRESH DATA =======================
-- D. SELECT - SLIDE 25-44
-- 1. Toàn bộ thông tin các loại hàng
    -- Mặt hàng thuộc loại hàng là 'Thắt lưng'
    SELECT * FROM loaihang LH
	JOIN mathang MH
	ON LH.MaLH = MH.MaLH
    WHERE TenLH like '%Thắt lưng%' ;
    
    SELECT * FROM chitietmathang
	WHERE MaMH IN (SELECT MaMH
					FROM mathang
					WHERE MaLH IN (SELECT MaLH FROM loaihang WHERE TenLH like '%Thắt lưng%'));

    -- Top 5 mặt hàng có giá bán cao nhất
	SELECT * FROM chitietmathang CT
    JOIN mathang MH
	ON CT.MaMH = MH.MaMH
	ORDER BY CT.GiaBan desc
    LIMIT 5;
    
-- 2. Đơn hàng
	-- Được bán trong ngày 28/11/2019
    SELECT * FROM donhang
    WHERE date(ThoiGianDatHang) LIKE '%2020-12-18%'; 
    
    -- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
    SELECT * FROM donhang
    WHERE date(ThoiGianDatHang) BETWEEN '2020-12-18' AND '2021-01-06';
    
    -- Được bán trong tháng 11/2019
    SELECT * FROM donhang
    WHERE date_format(ThoiGianDatHang, "%m") = '12';
    
    -- Được giao hàng tại Hòa Khánh
    SELECT * FROM donhang
    WHERE DiaChiGiaoHang LIKE '%Hòa Khanh%';
    
-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
SELECT *, round(GiaBan*0.8, 2) as GiaMoi
FROM chitietmathang;

-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
SELECT *, round(GiaBan*0.8, 2) as GiaMoi
FROM chitietmathang
WHERE MaMH IN (SELECT MaMH
               FROM chitietdonhang
               WHERE MaDH IN (SELECT MaDH
                              FROM donhang
                              WHERE date(donhang.ThoiGianDatHang) = '2020-12-18'));

-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
SELECT DISTINCT MauSac 
FROM mathang;

-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
SELECT  MaMH,
        TenMH,
        ThoiGianDatHang
FROM donhang DH
INNER JOIN chitietdonhang USING (MaDH)
INNER JOIN mathang USING (MaMH)
WHERE date(DH.ThoiGianDatHang) = '2020-12-18';

-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
SELECT * FROM mathang MH
JOIN chitietmathang CT
ON MH.MaMH = CT.MaMH
WHERE CT.GiaBan BETWEEN '100' AND '300';

SELECT * FROM mathang
WHERE MaMH IN ( SELECT MaMH FROM chitietmathang
                WHERE GiaBan BETWEEN '100' AND '300');

-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
SELECT * FROM loaihang
INNER JOIN mathang USING (MaLH)
WHERE loaihang.TenLH IN ('Mũ', 'Thắt lưng');

SELECT * FROM loaihang
INNER JOIN mathang USING (MaLH)
WHERE loaihang.TenLH = 'Mũ'
OR loaihang.TenLH = 'Thắt lưng';

-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
SELECT * FROM donhang
WHERE date(ThoiGianDatHang) IN ('2020-12-18', '2021-01-05');

-- ==============================================================
-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
SELECT * FROM chitietmathang CT
INNER JOIN mathang USING (MaMH)
ORDER BY CT.GiaBan asc;

-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT * FROM chitietmathang CT
INNER JOIN mathang USING (MaMH)
ORDER BY CT.GiaMua desc;

-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
SELECT * FROM chitietmathang
ORDER BY GiaBan asc, SoLuong desc;

-- 14. Đếm số lượng các mặt hàng trong hệ thống
SELECT COUNT(*) as SoLuongCacMatHang
FROM chitietmathang;

-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
SELECT TenMH, ThoiGianDatHang, SoLuong FROM donhang
INNER JOIN chitietdonhang USING (MaDH)
INNER JOIN mathang USING (MaMH)
WHERE mathang.TenMH LIKE '%Giày da Nam%'
AND date (donhang.ThoiGianDatHang) = '2020-12-18';

-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
    -- MaLoai  TenLoai SoLuong
    -- 1       Giày    20
    -- 2       Áo      28
    SELECT  MaLH as MaLoai,
            TenLH as TenLoai,
            count(MaMH) as SoLuong
    FROM mathang
    INNER JOIN loaihang USING (MaLH)
    GROUP BY MaLH;
    
-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT  TenLH,
        TenMH,
        MAX(GiaBan) GiaBanCaoNhat
FROM mathang
INNER JOIN loaihang USING (MaLH)
INNER JOIN chitietmathang USING (MaMH)
WHERE TenLH like '%Quần%';

-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
SELECT DISTINCT MaMH, 
                TenMH, 
                GiaBan, 
                MaLH
FROM mathang
INNER JOIN chitietmathang USING (MaMH)
INNER JOIN loaihang USING (MaLH)
WHERE GiaBan IN (SELECT MAX(GiaBan)
                 FROM mathang
                 INNER JOIN chitietmathang USING (MaMH)
                 INNER JOIN loaihang USING (MaLH)
                 GROUP BY MaLH)
GROUP BY MaLH;

-- 19. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
SELECT  MaLH,
        TenLH,
        SUM(SoLuong) TongSoLuongMatHang
FROM mathang
INNER JOIN loaihang USING (MaLH)
INNER JOIN chitietmathang USING (MaMH)
GROUP BY MaLH;

-- 20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
    -- Điều kiện tổng số lượng > 200 mặt hàng
    SELECT  MaLH,
            TenLH,
            SUM(SoLuong) TongSoLuongMatHang
    FROM mathang
    INNER JOIN loaihang USING (MaLH)
    INNER JOIN chitietmathang USING (MaMH)
    GROUP BY MaLH
    HAVING TongSoLuongMatHang > 200;

-- ==============================================================
-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
SELECT  MaMH,
        TenMH,
        MaLH,
        SoLuong
FROM mathang
INNER JOIN loaihang USING (MaLH)
INNER JOIN chitietmathang USING (MaMH)
WHERE SoLuong IN (SELECT MAX(SoLuong)
                    FROM mathang
                    INNER JOIN chitietmathang USING (MaMH)
                    INNER JOIN loaihang USING (MaLH)
                    GROUP BY MaLH);

-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT  MaLH,
        TenLH,
        AVG(GiaBan) GiaBanTrungBinh
FROM mathang
INNER JOIN loaihang USING (MaLH)
INNER JOIN chitietmathang USING (MaMH)
GROUP BY MaLH;

-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại

-- 24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100

-- 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11
-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
-- 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)
    -- Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
-- 29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11
-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'
-- 31. Tính tổng tiền cho đơn hàng 02
    -- Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
-- 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
    -- SoDH ChiTietDonHang           TongTien
    -- 02   TenMH:GiaBan:SoLuong     100