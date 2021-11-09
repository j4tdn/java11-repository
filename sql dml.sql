COMMIT;
ROLLBACK;

INSERT INTO LoaiHang(MaLH, TenLH)
VALUES(1, "Áo"),
		(2, "Quần"),
        (3,"Mũ");	

INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUES(1, "Áo sơ mi nam", "Trắng", 1),
	(2, "Áo sơ mi nam", "Đen", 1);
    
 -- disable all foreign keys check
SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUES(3, "Mũ redhart", "Đỏ", 3),
 	(4, "Mũ whitehart", "Trắng", 3);    
    
SET FOREIGN_KEY_CHECKS = 1;   

SELECT * FROM MatHang;
SELECT * FROM LoaiHang;
-- safe mode
-- sql : execution  plan
EXPLAIN DELETE FROM MatHang
WHERE MaMH = 3;

-- CASCATE
DELETE FROM LoaiHang
WHERE MaLH = 3;
