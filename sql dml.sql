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