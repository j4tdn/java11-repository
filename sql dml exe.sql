-- ======================= REFRESH DATA =======================

-- B. DELETE
-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
DELETE FROM nhanvien
WHERE TenNV LIKE '%Hoàng%';
-- = equals
-- LIKE
-- xyz% startWith
-- %xyz endWith

-- 2. Xóa bộ phận giao hàng trong hệ thống
DELETE FROM chucvu
WHERE TenCV LIKE 'Nhân viên giao hàng';

-- 3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ
-- SUB QUERY
DELETE FROM mathang
WHERE MaLH = (SELECT MaLH
			  FROM loaihang
			  WHERE TenLH = 'Mũ');

-- 4. Xóa tất cả các mặt hàng trong hệ thống
DELETE FROM mathang;

-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 23/11/2019
--    Thực hiện xóa các đơn hàng bị lỗi
-- CAST(ThoiGianDatHang AS DATE) = str_to_date('17-12-2021','%d-%m-%y');

SELECT CAST(ThoiGianDatHang AS DATE) ThoiGianDatHang FROM donhang;
DELETE FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) = '2021-12-17'; -- default format: y-m-d

-- ======================= REFRESH DATA =======================
-- C. UPDATE
-- 1. Cập nhật tên mới cho chức vụ có MaCV = 2 thành 'Bộ phận quản lý'
UPDATE chucvu
SET TenCV = 'Bộ phận quản lý'
WHERE MaCV = 2;

-- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'
ALTER TABLE donhang
ADD GhiChu TEXT;
UPDATE donhang
SET GhiChu = 'Giao hàng sau 10H sáng'
WHERE MaDH = 1;

-- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật trạng thái
SELECT * FROM donhang WHERE MaDH = 1;
SELECT * FROM tinhtrangdonhang;
SELECT * FROM chitiettinhtrangdonhang;

INSERT INTO chitiettinhtrangdonhang(MaDH, MaTT, MaNV, ThoiGian)
VALUE(1,5,2,'2020-12-16 20:20:40');

-- 4. Xuất hóa đơn cho đơn hàng 01 với số tiền cần thanh toán là 890
SELECT * FROM hoadon;
INSERT INTO hoadon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
VALUE (1,2,CURRENT_TIMESTAMP(), 890);

-- 5. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng là 'Mũ' với giá bán là 199K
select * from loaihang;
select * from mathang;
SELECT * FROM chitietmathang;
UPDATE chitietmathang
SET GiaBan = 199
WHERE MaMH IN (SELECT MaMH 
		      FROM mathang
			  WHERE MaLH = (SELECT MaLH FROM loaihang WHERE TenLH LIKE '%Áo%'));
              
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

SELECT * FROM donhang;
SELECT * FROM SaoLuuDonHang;

-- copy data
INSERT INTO SaoLuuDonHang
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
SELECT (
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
FROM donhang;
-- ======================= REFRESH DATA =======================
-- D. SELECT - SLIDE 25-44
-- 1. Toàn bộ thông tin các loại hàng
SELECT * FROM loaihang;

    -- Mặt hàng thuộc loại hàng là 'Thắt lưng'
    SELECT *
    FROM loaihang lh
	JOIN mathang mh
	ON lh.MaLH = mh.MaLH
    WHERE lh.TenLH LIKE '%Thắt lưng%' ;
    
    SELECT *
    FROM MatHang
	WHERE MaMH = (SELECT MaMH
                  FROM loaihang
                  WHERE TenLH like '%Thắt lưng%');

    -- Top 5 mặt hàng có giá bán cao nhất
	SELECT  mh.*,
            ctmh.GiaBan
    FROM chitietmathang ctmh
    JOIN mathang mh
	ON ctmh.MaMH = mh.MaMH
	ORDER BY ctmh.GiaBan DESC
    LIMIT 5;
    
-- 2. Đơn hàng
SELECT * FROM donhang;
SELECT * FROM chitietdonhang;
SELECT * FROM chitiettinhtrangdonhang;
SELECT * FROM hoadon;
SELECT * FROM tinhtrangdonhang;

	-- Được bán trong ngày 28/11/2019
    SELECT * FROM donhang
    WHERE DATE(ThoiGianDatHang) = '2020-12-18'; 
    
    -- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
    SELECT * FROM donhang
    WHERE DATE(ThoiGianDatHang) BETWEEN '2020-12-18' AND '2021-01-06';
    
    -- Được bán trong tháng 11/2019
    SELECT * FROM donhang
    WHERE DATE_FORMAT(ThoiGianDatHang, "%Y %m %d") = '2020-12-18';
    
    SELECT *
    FROM donhang
    WHERE MONTH(ThoiGianDatHang) = '11' AND YEAR(ThoiGianDatHang) = '2019';
    
    -- Được giao hàng tại Hòa Khánh
    SELECT * FROM donhang
    WHERE DiaChiGiaoHang LIKE '%Hòa Khanh%';
    
-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
SELECT * FROM chitietmathang;

SELECT *, round(GiaBan*0.8, 2) as GiaMoi
FROM chitietmathang;

-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
SELECT * FROM donhang;
SELECT * FROM chitietdonhang;
SELECT * FROM chitietmathang;

SELECT  mh.MaMH,
        ctmh.GiaBan,
        ctmh.GiaBan * 0.8 GiaBanKhuyenMai,
        curdate() NgayBan
FROM mathang mh
JOIN chitietmathang ctmh
ON mh.MaMH = ctmh.MaMH
WHERE curdate() = '2020-12-18';

SELECT *, round(GiaBan*0.8, 2) as GiaMoi
FROM chitietmathang
WHERE MaMH IN (SELECT MaMH
               FROM chitietdonhang
               WHERE MaDH IN (SELECT MaDH
                              FROM donhang
                              WHERE date(donhang.ThoiGianDatHang) = '2020-12-18'));

-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.

-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
SELECT * FROM donhang;
SELECT * FROM chitietdonhang;
SELECT * FROM mathang;

SELECT  MaMH,
        TenMH,
        ThoiGianDatHang
FROM donhang DH
INNER JOIN chitietdonhang USING (MaDH)
INNER JOIN mathang USING (MaMH)
WHERE date(DH.ThoiGianDatHang) = '2020-12-18';

-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
SELECT * FROM mathang;
SELECT * FROM chitietmathang;

SELECT * FROM mathang MH
JOIN chitietmathang CT
ON MH.MaMH = CT.MaMH
WHERE CT.GiaBan BETWEEN '100' AND '300';

SELECT * FROM mathang
WHERE MaMH IN ( SELECT MaMH FROM chitietmathang
                WHERE GiaBan BETWEEN '100' AND '300');

-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
SELECT * FROM mathang;
SELECT * FROM loaihang;

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
            SUM(ctmh.SoLuong) as SoLuongMatHang
    FROM mathang
    INNER JOIN loaihang lh USING (MaLH)
    INNER JOIN chitietmathang ctmh USING (MaMH)
    GROUP BY MaLH;
    
    SELECT  lh.MaLH,
            lh.TenLH,
            SUM(ctmh.SoLuong) SoLuongMatHang
            -- mh.TenMH,
            -- ctmh.MaKC,
            -- ctmh.SoLuong
    FROM loaihang lh
    JOIN mathang mh
        ON lh.MaLH = mh.MaLH
    JOIN chitietmathang ctmh
        ON mh.MaMH = ctmh.MaMH
    GROUP BY lh.MaLH ;
    
-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT  TenLH,
        TenMH,
        MAX(GiaBan) GiaBanCaoNhat
FROM mathang
INNER JOIN loaihang USING (MaLH)
INNER JOIN chitietmathang USING (MaMH)
WHERE TenLH like '%Quần%';

-- 18. Tìm thông tin mặt hàng có giá bán cao nhất của mỗi loại hàng
SELECT  lh.MaLH,
        lh.TenLH,
        MAX(ctmh.GiaBan) GiaBanCaoNhat
FROM mathang mh
INNER JOIN loaihang lh
    USING (MaLH)
INNER JOIN chitietmathang ctmh
    USING (MaMH)
GROUP BY lh.MaLH;

-- CTE: COMMON TABLE EXPRESSION
WITH CTE_LoaiHang AS (
    SELECT  lh.MaLH,
            lh.TenLH,
            MAX(ctmh.GiaBan) GiaBanCaoNhat
    FROM mathang mh
    INNER JOIN loaihang lh
        USING (MaLH)
    INNER JOIN chitietmathang ctmh
        USING (MaMH)
    GROUP BY lh.MaLH
)
SELECT  lh.MaLH,
        lh.TenLH,
        mh.MaMH,
        mh.TenMH,
        ctmh.GiaBan,
        ctmh.MaKC,
        lh.GiaBanCaoNhat
FROM CTE_LoaiHang lh
JOIN mathang mh
    ON mh.MaLH = lh.MaLH
JOIN chitietmathang ctmh
    ON mh.MaMH = ctmh.MaMH
WHERE ctmh.GiaBan = lh.GiaBanCaoNhat;


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
-- B1: Tìm tổng số lượng nhiều nhất của mỗi loại hàng
SELECT * FROM chitietmathang;
WITH CTE_MatHang AS(
-- SoLuongMatHang của mỗi mặt hàng
    SELECT  mh.MaMH,
            mh.TenMH,
            sum(ctmh.SoLuong) SoLuongMatHang
    FROM mathang mh
    JOIN chitietmathang ctmh
        ON mh.MaMH = ctmh.MaMH
    GROUP BY mh.MaMH
),
CTE_LoaiHang AS(
-- SoLuongCaoNhat của mỗi loại hàng
SELECT  mh.MaLH,
        max(cte.SoLuongMatHang) SoLuongCaoNhat
FROM mathang mh
JOIN CTE_MatHang cte
    ON mh.MaMH = cte.MaMH
GROUP BY mh.MaLH
)
SELECT  ctelh.MaLH,
        mh.MaMH,
        ctemh.TenMH,
        ctemh.SoLuongMatHang
FROM CTE_MatHang ctemh
JOIN mathang mh
    ON ctemh.MaMH = mh.MaMH
JOIN CTE_LoaiHang ctelh
    ON ctelh.MaLH = mh.MaLH
WHERE ctemh.SoLuongMatHang = ctelh.SoLuongCaoNhat;

-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT  MaLH,
        TenLH,
        AVG(GiaBan) GiaBanTrungBinh
FROM mathang
INNER JOIN loaihang USING (MaLH)
INNER JOIN chitietmathang USING (MaMH)
GROUP BY MaLH;

-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
SELECT  mh.MaLH,
        MAX(ctmh.SoLuong) SoLuong
FROM loaihang lh
INNER JOIN mathang mh USING (MaLH)
INNER JOIN chitietmathang ctmh USING (MaMH)
GROUP BY mh.MaLH
ORDER BY SoLuong DESC
LIMIT 3;

-- 24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100

-- 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11

-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
SELECT * FROM MatHang m 
JOIN loaihang p ON m.maLH = p.MaLH
WHERE p.TenLH = "Mũ" 
AND MaMH NOT IN (SELECT MaMH
                 FROM donhang d
                 JOIN chitietdonhang n
                 ON d.maDH = n.maDH
                 WHERE d.ThoiGianDatHang LIKE "2020-02-14%");
                 
-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
UPDATE chitietmathang
SET GiaBan = 199
WHERE MaMH IN  (SELECT MaMH
                FROM mathang WHERE MaLH =  (SELECT MaLH
                                            FROM loaihang
                                            WHERE TenLH = 'Áo'));

-- 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)
    -- Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
    CREATE TABLE LoaiHang_BACKUP(
        MaLH int,
        TenLH VARCHAR(255)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;

    INSERT INTO LoaiHang_BACKUP(
        MaLH,
        TenLH
    )
    SELECT (
        MaLH,
        TenLH
    )
FROM loaihang;

-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'
  -- B1: Tìm số lượng hàng còn lại của mỗi mặt hàng thuộc loại hàng 'Áo', 'Quần'
  -- B2: ORDER BY SoLuongTon DESC
  -- B3: LIMIT 2;
SELECT  mh.MaMH,
        mh.TenMH,
        SUM(ctmh.SoLuong) SoLuong
FROM mathang mh
INNER JOIN chitietmathang ctmh USING (MaMH)
WHERE mh.MaLH IN (SELECT MaLH FROM loaihang
                  WHERE TenLH IN ('Áo', 'Quần'))  
GROUP BY mh.MaMH
ORDER BY SoLuong DESC
LIMIT 2;

-- 31. Tính tổng tiền cho đơn hàng 02
    -- Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
    SELECT  dh.MaDH,
            GROUP_CONCAT(concat(mh.TenMH,' :', ctmh.MaKC,':',ctmh.GiaBan,':', ctdh.SoLuong) SEPARATOR ' - ') ThongTinDonHang,
            dh.PhiVanChuyen,
            SUM(ctmh.GiaBan*ctdh.SoLuong) + dh.PhiVanChuyen TongTien
    FROM chitietmathang ctmh
    JOIN mathang mh
        ON ctmh.MaMH = mh.MaMH
    JOIN chitietdonhang ctdh
        ON ctmh.MaMH = ctdh.MaMH
    JOIN donhang dh
        ON ctdh.MaDH = dh.MaDH
    GROUP BY dh.MaDH;
    
-- 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
    -- SoDH ChiTietDonHang           TongTien
    -- 02   TenMH:GiaBan:SoLuong     100
 