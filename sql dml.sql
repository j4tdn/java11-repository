
COMMIT;
ROLLBACK;

INSERT INTO LoaiHang(MaLH, TenLoai)
VALUE(1, "Áo"),
	 (2, "Quần");

INSERT INTO LoaiHang(MaLH, TenLoai)
VALUE(3, "Mũ");
     
INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH) 
VALUE(1, "Áo sơ mi nam", "Trắng", 1),
	 (2, "Áo sơ mi nữ", "Đen", 1);

-- disable all foreign keys check
SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUES(3, "Mũ RedHalt", "Red", 3),
      (4, "Mũ WhiteHalt", "Red", 3);
-- enable all foreign keys check
SET FOREIGN_KEY_CHECKS = 1;

-- safe mode
-- sql: execution plan
EXPLAIN DELETE FROM MatHang
WHERE MaMH = 3;

ALTER TABLE `java11_shopping_manually`.`mathang` 
DROP FOREIGN KEY `FK_MatHang_LoaiHang`;
ALTER TABLE `java11_shopping_manually`.`mathang` 
ADD CONSTRAINT `FK_MatHang_LoaiHang`
  FOREIGN KEY (`maLH`)
  REFERENCES `java11_shopping_manually`.`loaihang` (`MaLH`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
