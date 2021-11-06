INSERT INTO loaihang(MaLH, TenLoai)
VALUE (1, "Áo"),
	  (2, "Quần");
      
INSERT INTO loaihang(MaLH, TenLoai)
VALUE (3, "Mũ");

INSERT INTO mathang(MaMH, TenMH, MauSac, MaLH)
VALUE (1, "Áo sơ mi nam", "Trắng", 1),
	  (2, "Áo sơ mi nữ", "Đen", 1);

-- disable all foreign keys check
SET FOREIGN_KEY_CHECKS = 0;      
INSERT INTO mathang(MaMH, TenMH, MauSac, MaLH)
VALUE (3, "Mũ RedHat", "Đỏ", 3),
	  (4, "Mũ WhiteHat", "Trắng", 3);
SET FOREIGN_KEY_CHECKS = 1;

-- safe mode
-- sql: execution plan
DELETE FROM mathang
WHERE MaMH = 4;

DELETE FROM LoaiHang
WHERE MaLH = 3;

ROLLBACK;

SELECT *
FROM MatHang;

-- Cập nhập màu sắc của tất cả các mặt hàng có loại hàng = 2 thành màu xanh
UPDATE MatHang
SET MauSac = 'Xanh'
WHERE MaLH = 2;

-- MERGE - saveOrUpdate
-- insert - update

-- update(new Item(2, 'Áo sơ mi', 'Trắng', 1))

SELECT  MaMH,
        TenMH,
        MauSac,
        concat(TenMH, ' - ', MauSac) ChiTiet,
        current_timestamp() ThoiGian
FROM mathang
LIMIT 1, 5;

-- Giảm 15k nếu giá bán lớn hơn giá mua 30k trở lên
SELECT *, if(GiaBan - GiaMua >= 30, GiaBan-15, GiaBan) GiaGiam
FROM chitietmathang;

SELECT *, if(GiaBan - GiaMua >= 30, GiaBan-15, GiaBan) GiaGiam
FROM chitietmathang
ORDER BY MaKC DESC, GiaBan ASC; -- default ASC

-- function count, sum, avg, min, max
-- count(column) >> return 1 row
SELECT  MaLH,
        COUNT(*) SoLuongLoaiHang
FROM mathang
GROUP BY MaLH
HAVING SoLuongMatHang > 2;






