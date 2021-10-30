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




      
      
      
      