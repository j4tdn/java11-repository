INSERT INTO LoaiHang(MaLH, TenLH)
VALUES(1, "Ao"),
	  (2, "Quan");
      
INSERT INTO LoaiHang(MaLH, TenLH)
VALUES(3, "Mu");

INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUES(1, "Ao somi nam", "Trang", 1),
	  (2, "Ao somi nu", "Den", 1);
        
-- disable all forein key check
SET FOREINKEY_KEY_CHECKS = 0;
INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUES(3, "Mu do", "Do", 3),
	  (4, "Mu trang", "Trang", 3);
-- enable all forein key check
SET FOREINKEY_KEY_CHECKS = 1;

-- safe mod
DELETE FROM MatHang
WHERE MaMH = 4;

DELETE FROM LoaiHang
WHERE MaLH = 3;	
ROLLBACK;

SELECT * 
FROM mathang;

-- concatenate (... Strings)
SELECT MaMH,
	   TenMH,
       MauSac,
       concat(TenMH, '-' , MauSac) AS ChiTiet,
       current_timestamp() ThoiGian
FROM mathang;

-- group concate(column)
SELECT GROUP_CONCAT(MaMH SEPARATOR '-')
FROM mathang;

SELECT DISTINCT MauSac
FROM mathang
LIMIT 5;

SELECT *, IF(GiaBan - GiaMua >= 30, GiaBan-15, GiaBan) GiaGiam
FROM chitietmathang
ORDER BY MaKC DESC, GiaBan ASC;

-- group by
SELECT * FROM mathang;
SELECT COUNT(MaMH) FROM mathang;

SELECT MaLH, COUNT(*) SoLuongMatHang
FROM mathang
WHERE MaLH IN (1, 3, 5)
GROUP BY MaLH
HAVING SoLuongMatHang > 2;

UPDATE mathang
SET MauSac = NULL
WHERE MaMH IN (2,5,7);

SELECT MaMH 
FROM mathang
WHERE MaLH = 2
UNION ALL
SELECT MaMH
FROM chitietdonhang;

-- phép kết - join
SELECT *FROM mathang;
SELECT *FROM loaihang;
INSERT INTO loaihang(MaLH, TenLH)
VALUES(6, 'Tất');
-- liệt kê tất cả các mặt hàng thuộc loại hàng là áo
SELECT * FROM mathang
WHERE MaLH = (SELECT MaLH FROM loaihang WHERE TenLH LIKE '%Áo%');

-- join
SELECT * 
FROM mathang
JOIN loaihang
ON mathang.MaLH = loaihang.MaLH
WHERE loaihang.TenLH LIKE '%Áo%';

-- right join
SELECT * 
FROM mathang
RIGHT JOIN loaihang
ON mathang.MaLH = loaihang.MaLH;

