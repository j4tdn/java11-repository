INSERT INTO LoaiHang(MaLH, TenLoai)
VALUE(1, "Áo"),
	 (2, "Quần");

INSERT INTO LoaiHang(MaLH, TenLoai)
VALUE(3, "Mũ");

INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUE(1, "Áo sơ mi nam", "Trắng", 1),
	 (2, "Áo sơ mi nư", "Trắng", 1);

-- disable all for foreign keys check 
SET FOREIGN_KEY_CHECKS = 0;  
INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUE(3, "Mũ RedHat", "Đỏ", 3),
	 (4, "Mũ WhiteHat", "Trắng", 3);
-- enable all for foreign keys check 
SET FOREIGN_KEY_CHECKS = 1;  
