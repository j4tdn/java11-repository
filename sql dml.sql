INSERT INTO LoaiHang (MaLH, TenLoai)
VALUES(1, "Ao"),
	  (2, "Quan");
INSERT INTO LoaiHang (MaLH, TenLoai)
VALUES(3, "Qan"),
	  (4, "Mu");
INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUES(1, "so mi nam", "do", 1),
	  (2, "so mi nu", "trang", 1);
-- disable all foreign keys check 
SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
VALUES(3, "quan chip nam", "do", 3),
	  (4, "mu tai beo", "trang", 3);
-- enable all foreign keys check 
SET FOREIGN_KEY_CHECKS = 1;
-- safe mode
DELETE FROM mathang;
ROLLBACK;
COMMIT;

SELECT MaMH,
	   TenMH,
       MauSac,
       concat(TenMH, '-', MauSac) ChiTiet,
       current_timestamp() ThoiGian
FROM mathang;
-- distinct: riêng biệt
SELECT DISTINCT MauSac 
FROM mathang
LIMIT 1, 5;
SELECT *, GiaBan * 0.9 as GiaMoi
FROM chitietmathang
ORDER BY MaKC DESC, GiaBan ASC;
SELECT *, COUNT(MaMH) FROM mathang
GROUP BY MauSac;
SELECT GROUP_CONCAT(TenMH SEPARATOR ' - '),
	   MaLH
FROM mathang
GROUP BY MaLH;