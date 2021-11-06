INSERT INTO LoaiHang(MaLH, TenLoai)
VALUES(1, "Áo"),
      (2, "Quần");
INSERT INTO LoaiHang(MaLH, TenLoai)
VALUES (3, "Mũ");
INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUES(1, "Áo sơ mi nam", "Trắng", 1),
      (2, "Áo sơ mi nữ", "Đen", 1);
      
-- disable all foreign keys check 
SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUE(3, "Mũ RedHat", "Đỏ", 3),
	(4, "Mũ WhileHat", "Trắng", 3);
-- enable all foreign keys check 
SET FOREIGN_KEY_CHECKS = 1;

-- safe mode

SELECT * FROM MatHang;
SELECT MaMH,
       TenMH,
       MauSac,
       concat(TenMH, '-', MauSac) ChiTiet,
       current_timestamp() ThoiGian
FROM MatHang
LIMIT 1,5; 
-- giảm 15k nếu giá bán lớn hơn giá mua 30k trở lên
SELECT *, IF(GiaBan - GiaMua >= 30,GiaBan - 15,GiaBan) GiaGiam
 FROM ChiTietMatHang;
 
 SELECT * FROM MatHang;
 SELECT COUNT(MauSac) 
 FROM MatHang;
 
 SELECT MaLH,
		COUNT (*) SoLuongMatHang,
        GROUP_CONCAT(TenMH SEPARATOR '-')
 FROM MatHang
 WHERE MaLH IN (1,3,5)
 GROUP BY MaLH 
 HAVING SoLuongMatHang >= 2
 ORDER BY MaMH DESC;
 
 -- group_concat
 SELECT GROUP_CONCAT (TenMH SEPARATOR '-');
 
 
 UPDATE MatHang
 SET MauSac = 'null'
 WHERE MaMH IN (2,5,7);
 
 
 SELECT MaMH
 FROM MatHang
 WHERE MaLH = 2
 UNION ALL
 SELECT MaMH
 FROM ChiTietDonHang;
 
 -- Phép kết - JOIN
 SELECT * FROM MatHang;
 SELECT * FROM LoaiHang;
 
 INSERT INTO LoaiHang(MaLH,TenLH)
 VALUES(6, 'Tất');
 -- Liệt kê tất cả các mặt hàng thuộc loại hàng áo
 SELECT mh.*,
        lh.TenLH
 FROM MatHang mh
 JOIN LoaiHang lh
 ON mh.MaLH = lh.MaLH
 WHERE lh.TenLH LIKE '%Áo';
 
 SELECT mh.*,
        lh.TenLH
 FROM MatHang mh
 JOIN LoaiHang lh
 ON mh.MaLH = lh.MaLH