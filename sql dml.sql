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
      
-- Disable all foreign keys check
SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUES(3, "Mũ RedHat", "Đỏ", 3),
	  (4, "Mũ WhiteHat", "Trắng", 3);
      
-- Enable all foreign keys check
SET FOREIGN_KEY_CHECKS = 1;

-- Safe mode
-- SQL: Excution plan
DELETE FROM MatHang 
WHERE MaMH = 3;

DELETE FROM LoaiHang 
WHERE MaLH = 3;

-- concatenate(... strings)
SELECT DISTINCT MaMH,
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
SELECT *,IF(GiaBan - GiaMua >= 30, GiaBan - 30, GiaBan) GiaGiam 
FROM ChiTietMatHang
ORDER BY MaKC DESC, GiaBan ASC; -- default: ASC

-- group by


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
 
UPDATE MatHang
SET MauSac = NULL
WHERE MaMH IN (2,5,7);

-- 3, 4, 5
SELECT MaMH
FROM MatHang
WHERE MaLH = 2
UNION ALL
-- 1,1,2,3,4,6,8
SELECT MaMH
FROM ChiTietDonHang;
-- Sẽ ra kết quả là 3,4,5,1,2,6,8 vì có 1,3,4 là trùng nhau
-- Nếu muốn ra kết quả đầy đủ là 3,4,5,1,1,2,3,4,6,8 thì dùng UNION ALL

-- Phép kết - JOIN
-- Liệt kê tất cả các mặt hàng thuộc loại hàng là Áo
INSERT INTO LoaiHang(MaLH, TenLH)
VALUES(6, 'Tất');

SELECT *
FROM MatHang
WHERE MaLH = ( SELECT MaLH FROM LoaiHang WHERE TenLH LIKE '%Áo%' );

SELECT mh.*,
	   lh.TenLH
FROM MatHang mh
JOIN LoaiHang lh
ON mh.MaLH = lh.MaLH
WHERE lh.TenLH LIKE '%Áo%';

SELECT mh.*,
	   lh.TenLH
FROM MatHang mh
RIGHT JOIN LoaiHang lh
ON mh.MaLH = lh.MaLH;





    
     
     