-- 1 delete
DELETE FROM nhanvien
WHERE TenNV LIKE '%Hoàng%';

-- = equals
-- LIKE
-- xyz% startWith
-- %xyz endWith
-- %xyz% contains

-- 2
DELETE FROM chucvu
WHERE TenCV LIKE 'Nhân viên giao hàng';

-- 3
DELETE FROM mathang
WHERE MaLH = (SELECT MaLH 
			FROM loaihang
			WHERE TenLH = 'Mũ'); 

-- 4
DELETE FROM mathang;


-- 5
-- CAST(thoigiandathang AS DATE) = STR_TO_DATE('2020-12-28', '%d-%m-%Y')
SELECT * FROM donhang;
DELETE FROM donhang
WHERE CAST(thoigiandathang AS DATE) = '2021-12-28';

-- 1 UPDATE
UPDATE chucvu
SET tencv ='Bộ phận quản lý'
WHERE Macv = 2;

-- 2
ALTER TABLE donhang
ADD GhiChu TEXT;
SELECT * FROM donhang;
UPDATE donhang
SET GhiChu = 'Giao hàng sau 10h sáng'
WHERE MaDH = 1;

-- 3
SELECT * FROM donhang WHERE MaDH = 1;
SELECT * FROM tinhtrangdonhang;
SELECT * FROM chitiettinhtrangdonhang;

INSERT INTO chitiettinhtrangdonhang(MaDH, MaTT, MaNV, ThoiGian)
VALUE (1,5,2,'2020-12-16 20:20:40');

-- 4
SELECT * FROM hoadon;
INSERT INTO hoadon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
VALUE(1, 1, current_timestamp(), 890);

-- 5
UPDATE chitietmathang
SET GiaBan = 199
WHERE MaNH IN (SELECT MaMH 
				FROM  mathang
                WHERE MaLH = (SELECT MaLH 
								FROM loaihang 
                                WHERE TenLH LIKE 'Áo'));
SELECT * FROM chitietmathang;

-- 6. tao 1 bảng SaoLuuDonHang. Copy toàn bộ dữ liệu từ bảng DonHang bỏ vào SaoLuuDonHang
CREATE TABLE `saoluudonhang` (
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
SELECT * FROM saoluudonhang;

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


-- SELECT
-- 1:Toàn bộ thông tin các loại hàng
-- Mặt hàng thuộc loại hàng là 'Thắt lưng'
SELECT *
FROM loaihang lh 
JOIN mathang mh ON lh.MaLH = mh.MaLH
WHERE lh.TenLH LIKE '%Thắt lưng%';
-- Top 5 mặt hàng có giá bán cao nhất
SELECT * 
FROM loaihang lh 
JOIN mathang mh ON lh.MaLH = mh.MaLH
JOIN chitietmathang ctmh ON ctmh.MaMH = mh.MaMH
ORDER BY GiaBan DESC
LIMIT 5;

-- 2. Đơn hàng
	-- Được bán trong ngày 28/11/2019
SELECT * 
FROM donhang
WHERE CAST(thoigiandathang AS DATE) = '2021-11-28'; 
	-- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
SELECT * 
FROM donhang
WHERE CAST(thoigiandathang AS DATE) BETWEEN '2021-11-28' and '2021-12-2';
	-- Được bán trong tháng 11/2019
SELECT * 
FROM donhang
WHERE MONTH(ThoiGianDatHang)=11 AND YEAR(ThoiGianDatHang)=2019;
	-- Được giao hàng tại Hòa Khánh
SELECT * 
FROM donhang
WHERE DiaChiGiaoHang like '%Hòa Khánh%';

-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
SELECT *, round(giaban * 0.8, 2) sale
FROM chitietmathang;

-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
SELECT *, ctmh.GiaBan*0.8 sale20
FROM mathang mh
JOIN chitietmathang ctmh ON ctmh.MaMH = mh.MaMH
WHERE curdate() = '2019-11-25'; 

-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
SELECT DISTINCT mathang.MauSac
FROM mathang;

-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
SELECT  mh.MaMH, mh.TenMH, dh.ThoiGianDatHang
FROM mathang mh 
JOIN chitietdonhang ctdh ON mh.MaMH = ctdh.MaMH
JOIN donhang dh ON dh.MaDH = ctdh.MaDH
WHERE CAST(thoigiandathang AS DATE) = '2021-11-23';  

-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
SELECT * 
FROM mathang mh 
JOIN chitietmathang ctmh ON mh.MaMH = ctmh.MaMH 
WHERE ctmh.GiaBan BETWEEN 100 and 300 ;

-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
SELECT * FROM mathang
WHERE MaLH = (SELECT MaLH 
			FROM loaihang
			WHERE TenLH LIKE '%Mũ%' and '%Thắt lưng%' ); 

-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
SELECT * 
FROM donhang
WHERE CAST(thoigiandathang AS DATE) BETWEEN '2021-11-28' and '2021-12-14'; 

-- ==============================================================

-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
SELECT * 
FROM mathang mh 
JOIN chitietmathang ctmh ON mh.MaMH = ctmh.MaMH 
ORDER BY ctmh.GiaBan ASC;

-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT * 
FROM mathang mh JOIN chitietmathang ctmh ON mh.MaMH = ctmh.MaMH 
ORDER BY ctmh.GiaMua DESC;

-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
SELECT * 
FROM mathang mh 
JOIN chitietmathang ctmh ON mh.MaMH = ctmh.MaMH 
ORDER BY ctmh.GiaBan ASC, 
		 ctmh.GiaMua DESC;
         
-- 14. Đếm số lượng các mặt hàng trong hệ thống
SELECT sum(chitietmathang.SoLuong) tongsoluong
FROM chitietmathang;

-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
SELECT * 
FROM mathang mh 
JOIN chitietdonhang ctdh ON mh.MaMH = ctdh.MaDH
JOIN donhang dh ON dh.MaDH = ctdh.MaDH
WHERE mh.TenMH LIKE '%Giày da Nam%' and CAST(thoigiandathang AS DATE) = '2021-11-23'; 

-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
--     MaLoai  TenLoai SoLuong
-- 	1       Giày    20
-- 	2       Áo      28
SELECT lh.MaLH, lh.TenLH, sum(ctmh.SoLuong) soluong
FROM loaihang lh 
JOIN mathang mh ON lh.MaLH = mh.MaLH
JOIN chitietmathang ctmh ON ctmh.MaMH = mh.MaMH
GROUP BY lh.MaLH;

-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT * 
FROM loaihang lh 
JOIN mathang mh ON lh.MaLH = mh.MaLH
JOIN chitietmathang ctmh ON ctmh.MaMH = mh.MaMH
WHERE lh.TenLH LIKE '%Giày%'
ORDER BY ctmh.GiaBan DESC
LIMIT 1;

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
SELECT lh.MaLH,lh.TenLH,mh.TenMH,
		sum(ctmh.SoLuong) tongsoluong
FROM loaihang lh 
JOIN mathang mh ON lh.MaLH = mh.MaLH
JOIN chitietmathang ctmh ON ctmh.MaMH = mh.MaMH
GROUP BY lh.MaLH;

-- 20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
--     Điều kiện tổng số lượng > 20 mặt hàng
SELECT lh.MaLH,lh.TenLH,
	sum(ctmh.SoLuong) tongsoluong
FROM loaihang lh 
JOIN mathang mh ON lh.MaLH = mh.MaLH
JOIN chitietmathang ctmh ON ctmh.MaMH = mh.MaMH
WHERE ctmh.SoLuong > 20
GROUP BY lh.MaLH;

-- ==============================================================

-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
WITH CTE_MatHang AS (
-- Số lượng mặt hàng lớn nhất của mỗi mặt hàng
   SELECT mh.MaMH,
          mh.TenMH,
          sum(ctmh.SoLuong) SoLuongMatHang
   FROM MatHang mh
   JOIN ChiTietMatHang ctmh
   ON mh.MaMH = ctmh.MaMH
   GROUP BY mh.MaMH
),
CTE_LoaiHang AS (
-- Số lượng mặt hàng lớn nhất của mỗi loại hàng
SELECT mh.MaLH,
       max(cte.SoLuongMatHang) SoLuongCaoNhat
FROM MatHang mh
JOIN CTE_MatHang cte
ON mh.MaMH = cte.MaMH
GROUP BY mh.MaLH
)
SELECT * 
FROM CTE_MatHang ctemh
JOIN MatHang mh
	ON ctemh.MaMH = mh.MaMH
JOIN CTE_LoaiHang ctelh
	ON mh.MaLH = ctelh.MaLH
WHERE ctemh.SoLuongMatHang = ctelh.SoLuongCaoNhat;

-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT lh.MaLH,lh.TenLH,
	avg(ctmh.GiaBan) giabantrungbinh
FROM loaihang lh 
JOIN mathang mh ON lh.MaLH = mh.MaLH
JOIN chitietmathang ctmh ON ctmh.MaMH = mh.MaMH
GROUP BY lh.MaLH;

-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
SELECT lh.MaLH,lh.TenLH,
	sum(ctmh.SoLuong) tongsoluong
FROM loaihang lh 
JOIN mathang mh ON lh.MaLH = mh.MaLH
JOIN chitietmathang ctmh ON ctmh.MaMH = mh.MaMH
GROUP BY lh.MaLH
ORDER BY sum(ctmh.SoLuong) DESC
LIMIT 3;

-- 24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100
SELECT * 
FROM mathang mh 
JOIN chitietdonhang ctdh ON mh.MaMH = ctdh.MaMH
WHERE mh.MaLH = 2 AND ctdh.MaDH = 100100;

-- 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11
SELECT * 
FROM mathang mh 
JOIN chitietdonhang ctdh ON mh.MaMH = ctdh.MaMH
JOIN donhang dh ON dh.MaDH = ctdh.MaDH
WHERE mh.MaLH = 2 AND CAST(dh.ThoiGianDatHang AS DATE) = '2021-11-28'; 

-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
SELECT * 
FROM loaihang lh 
JOIN mathang mh ON lh.MaLH = mh.MaLH 
JOIN chitietdonhang ctdh ON mh.MaMH = ctdh.MaMH
JOIN donhang dh ON dh.MaDH = ctdh.MaDH
WHERE lh.TenLH LIKE '%Mũ%' AND CAST(dh.ThoiGianDatHang AS DATE) <> '2019-02-14';

-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
UPDATE chitietmathang ctmh 
JOIN mathang mh ON ctmh.MaMH = mh.MaMH
JOIN loaihang lh ON lh.MaLH = mh.MaLH
SET ctmh.giaBan = 200
WHERE lh.TenLH Like 'Ao';

-- 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai) >> Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP ??
CREATE TABLE LoaiHang_BACKUP(
MaLH INT PRIMARY KEY,
TenLH VARCHAR(255) NOT NULL);

INSERT INTO LoaiHang_BACKUP(MaLH, TenLH)
SELECT *
FROM loaihang;
SELECT * FROM loaihang_backup;

-- 29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11
SELECT * 
FROM  mathang mh JOIN chitietdonhang ctdh ON mh.MaMH = ctdh.MaMH
				JOIN donhang dh ON dh.MaDH = ctdh.MaDH
WHERE mh.MaLH = 2 AND mh.TenMH LIKE '%T-Shirt%' AND CAST(dh.ThoiGianDatHang AS DATE) = '2020-11-23';

-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'
SELECT lh.MaLH,lh.TenLH,mh.TenMH,max(ctmh.SoLuong) tonkho
FROM loaihang lh JOIN mathang mh ON lh.MaLH = mh.MaLH
				JOIN chitietmathang ctmh ON ctmh.MaMH = mh.MaMH
WHERE lh.TenLH LIKE '%Ao%' 
UNION 
SELECT lh.MaLH,lh.TenLH,mh.TenMH,max(ctmh.SoLuong)
FROM loaihang lh JOIN mathang mh ON lh.MaLH = mh.MaLH
				JOIN chitietmathang ctmh ON ctmh.MaMH = mh.MaMH
WHERE lh.TenLH LIKE '%Quan%';

    
