COMMIT;
ROLLBACK;

INSERT INTO LoaiHang(MaLH, TenLoai)
VALUES(1, "Áo"),
      (2, "Quần");
      
INSERT INTO LoaiHang(MaLH, TenLoai)
VALUES(3, "Mũ");

INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUES(1, "Áo sơ mi nam", "Trắng", 1),
      (2, "Áo sơ mi nữ", "Đen", 1);

-- disable all foreign keys check
SET FOREIGN_KEY_CHECKS = 0;      
INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUES(3, "Mũ RedHat", "Đỏ", 3),
      (4, "Mũ WhiteHat", "Trắng", 3);
-- enable all foreign keys check
SET FOREIGN_KEY_CHECKS = 1; 

-- safe mode
-- sql: execution plan
DELETE FROM MatHang
WHERE MaMH = 4;

DELETE FROM LoaiHang
WHERE MaLH = 3;

ROLLBACK;

SELECT *
FROM MatHang;

-- Cập nhật màu sắc của tất cả các mặt hàng có loại hàng = 2 thành màu xanh
UPDATE MatHang
SET MauSac = 'Xanh'
WHERE MaLH = 2;

-- MERGE - saveOrUpdate
-- INSERT - UPDATE

-- saveOrUpdate(new Item(2, 'Áo sơ mi', 'Trắng', 1))

-- JDBC executeQuery, executeUpdate
-- update >> INSERT, UPDATE, DELETE
-- select >> SELECT


SELECT *
FROM MatHang;

-- concatenate(... strings)
SELECT MaMH,
       TenMH,
       MauSac,
       concat(TenMH, '-', MauSac) ChiTiet,
       current_timestamp() ThoiGian
FROM MatHang
LIMIT 1, 5;

-- group_concat(column)
SELECT GROUP_CONCAT(TenMH SEPARATOR '-'),
	   MaLH
FROM MatHang
GROUP BY MaLH;

-- Giảm 15K nếu giá bán lớn hơn giá mua 30K trở lên
SELECT *, IF(GiaBan - GiaMua >= 30, GiaBan-15, GiaBan) GiaGiam
FROM ChiTietMatHang
ORDER BY MaKC DESC, GiaBan ASC; -- default ASC

-- group by
SELECT *
FROM MatHang;

-- function count, sum, avg, min, max
-- count(column) >> return 1 row
SELECT MaLH,
       COUNT(*) SoLuongMatHang,
       GROUP_CONCAT(TenMH SEPARATOR ', ') MatHang
FROM MatHang
WHERE MaLH IN (1,3,5)
GROUP BY MaLH
HAVING SoLuongMatHang >= 2
ORDER BY MaMH DESC;


SELECT *
FROM MatHang;

UPDATE MatHang
SET MauSac = NULL
WHERE MaMH IN (2,5,7);

-- 3,4,5
SELECT MaMH
FROM MatHang
WHERE MaLH = 2
UNION ALL
SELECT MaMH
FROM ChiTietDonHang;
-- 1,1,2,3,4,6,8


-- Phép kết - JOIN
SELECT * FROM MatHang;
SELECT * FROM LoaiHang;
INSERT INTO LoaiHang(MaLH, TenLH)
VALUES(6, 'Tất');
-- Liệt kê tất cả các mặt hàng thuộc loại hàng là Áo
SELECT *
FROM MatHang
WHERE MaLH = (SELECT MaLH FROM LoaiHang WHERE TenLH LIKE '%Áo%');

SELECT mh.*,
       lh.TenLH
FROM MatHang mh
JOIN LoaiHang lh
ON mh.MaLH = lh.MaLH
WHERE lh.TenLH LIKE '%Áo';

SELECT mh.*,
       lh.TenLH
FROM MatHang mh
RIGHT JOIN LoaiHang lh
ON mh.MaLH = lh.MaLH;














      
      
      
      