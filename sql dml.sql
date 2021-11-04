COMMIT;
ROLLBACK;

INSERT INTO loaihang(MaLH, TenLoai)
VALUES(1, "Áo"),
	  (2, "Quần");
      
INSERT INTO loaihang(MaLH, TenLoai)
VALUES(3, "Mũ");

INSERT INTO MatHang (MaMH, TenMH, MauSac, MaLH)
VALUES(1, "Áo sơ mi nam", "Trắng", 1),
	  (2, "Áo sơ mi nữ", "Đen", 1);

-- disable all foreign keys check
SET FOREIGN_KEY_CHECKS = 0;      
INSERT INTO MatHang (MaMH, TenMH, MauSac, MaLH)
VALUES(3, "Mũ RedHat", "Đỏ", 3),
	  (4, "Mũ WhiteHat", "Trắng", 3);
SET FOREIGN_KEY_CHECKS = 1; 

-- safe mode
DELETE FROM LoaiHang
WHERE MaLH = 3;

ROLLBACK;

USE java11_shopping;
SELECT MaMH,
	   TenMH,
       MauSac,
       CONCAT(TenMH, '-', MauSac) AS ChiTiet,
       CURRENT_TIMESTAMP()  ThoiGian
FROM mathang
LIMIT 1, 5;
       
SELECT MaMH
FROM mathang
WHERE MaLH = 2

UNION ALL

SELECT MaLH
FROM loaihang;