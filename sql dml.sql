INSERT INTO LoaiHang(MaLH, TenLoai)
values (1, 'Áo'),
	(2, 'Quần');

INSERT INTO KichCo(MaKC, MoTa)
values (1, 200),
(2, 300);

INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
values (1, 'Áo sơ mi nam', 'Trắng', 1),
(2, 'Áo sơ mi nữ', 'Đen', 1);


SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH)
values (3, 'Áo sơ mi nam', 'Trắng', 3),
(4, 'Áo sơ mi nữ', 'Đen', 4);


SET FOREIGN_KEY_CHECKS = 0;

DELETE FROM MatHang where MaMH = 3;

SELECT MaMH, TenMH, MauSac, concat(TenMH, ' - ', MauSac) ChiTiet, current_timestamp() ThoiGian
FROM MatHang;

-- Giảm 15k nếu giá bán lớn hơn giá mua 30k trở lên
SELECT *, IF(GiaBan - GiaMua >=30, GiaBan - 15, GiaBan) GiaGiam
FROM ChiTietMatHang;

