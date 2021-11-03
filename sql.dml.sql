-- COMMIT;
-- ROLLBACK;
INSERT INTO LoaiHang(MaLH, TenLoai)
VALUES 	(1, "AO"),
		(2, "QUAN");
        
INSERT INTO LoaiHang(MaLH, TenLoai)
VALUES 	(3, "Mu");
		       

INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUES 	(1, "Ao So Mi Nam", "Vang", 1),
		(2, "Ao So Mi Nu", "Trang", 1);	

-- disvable all foreign keys check
SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUES 	(3, "Mu RedHat", "DO", 3),
		(4, "Mu WhiteHat", "Vang", 3);	
-- enable all foreign keys check
SET FOREIGN_KEY_CHECKS = 1;

-- safe mode 
-- sql: execution plan
DELETE FROM MatHang
WHERE MaMH = 4;

DELETE FROM LoaiHang
WHERE MaLH = 3;

ROLLBACK;


