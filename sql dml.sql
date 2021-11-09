COMMIT;
ROLLBACK;

INSERT INTO LoaiHang(MaLH, TenLoai) 
VALUES 	(1, "Áo"), 
		(2, "Quần");

INSERT INTO LoaiHang(MaLH, TenLoai) 
VALUES 	(3, "Mũ");

INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH) 
VALUES 	(1, "Áo sơ mi nam", "Trắng", 1), 
		(2, "Áo sơ mi nữ", "Đen", 1);

-- disable all foreign keys check 
SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO MatHang(MaMH, TenMH, MauSac, MaLH) 
VALUES 	(3, "Mũ RedHat", "Đỏ", 3), 
		(4, "Mũ WhiteHat", "Trắng", 3);
-- enable all foreign keys check 
SET FOREIGN_KEY_CHECKS = 1;

-- safe mode
-- sql: execution plan
EXPLAIN DELETE FROM MatHang
WHERE MaMH = 3;

DELETE FROM LoaiHang
WHERE MaLH = 3;

-- Cập nhật màu sắc của tất cả các mặt hàng có loại hàng = 2 thành màu xanh
UPDATE MatHang
SET MauSac = 'Xanh'
WHERE MaLH = 2;

-- MERGE - saveOrUpdate
-- INSERT - UPDATE 

-- JDBC executeQuery, executeUpdate
-- update >>> INSERT, UPDATE, DELETE
-- select >>> SELECT

-- Bai Tap
-- DELETE --
-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
DELETE FROM nhanvien 
WHERE MaNV LIKE '%Hoàng%';

-- 2. Xóa bộ phận giao hàng trong hệ thống
DELETE FROM chucvu 
WHERE TenCV = 'Nhân viên giao hàng';

-- 3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ 
-- SUB QUERY
DELETE FROM mathang 
WHERE MaLH = (SELECT MaLH 
			  FROM loaihang 
			  WHERE TenLH ='Mũ');

-- 4. Xóa tất cả các mặt hàng trong hệ thống
DELETE FROM mathang;

-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 18/12/2020. Thực hiện xóa các đơn hàng bị lỗi
DELETE FROM donhang 
WHERE CAST(ThoiGianDatHang AS DATE) = '2020-01-05';

-- UPDATE --
-- 1. Cập nhật tên mới cho chức vụ có MaCV = 2 thành 'Bộ phận quản lý'
UPDATE chucvu 
SET ten = 'Bộ phận quản lý'
WHERE MaCV = 2;

-- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'
ALTER TABLE DonHang 
ADD GhiChu TEXT;

UPDATE DonHang
SET GhiChu = 'Giao hàng sau 10H sáng'
WHERE MaDH = 1;

-- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật
--    MaTT = 03, TrangThai = 'Đã giao', ThoiGian = Thời gian hiện tại
SELECT * FROM DonHang WHERE MaDH = 1;
SELECT * FROM tinhtrangdonhang WHERE MoTa='Giao hàng thành công';
SELECT * FROM ChiTietTinhTrangDonHang;

INSERT INTO ChiTietTinhTrangDonHang(MaDH, MaTT, MaNV, ThoiGian)
VALUES(1, 5, 2, '2020-12-16 20:20:40');

-- 4. Cập nhật số tiền cần thanh toán trong bảng hóa đơn thành 890 cho đơn hàng 01
SELECT * FROM hoadon;
INSERT INTO HoaDon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
VALUES (1, 1, current_timestamp(), 890);

-- 5. Cập nhật tất cả các mặt hàng thuộc loại hàng là 'Áo' với giá bán là 199K
SELECT * FROM mathang;
SELECT * FROM loaihang;
SELECT * FROM ChiTietMatHang;

UPDATE ChiTietMatHang
SET GiaBan = 199
WHERE MaMH IN (SELECT MaMH 
			  FROM MatHang 
              WHERE MaLH = (SELECT MaLH 
						  FROM LoaiHang 
                          WHERE TenLH LIKE 'Áo'));

-- 6. Tạo 1 bảng SaoLuuDonHang. Copy toàn bộ dữ liệu từ bảng DonHang bỏ vào SaoLuu_DonHang
-- Cấu trúc 2 bảng giống nhau
CREATE TABLE `SaoLuuDonHang`(
  `MaDH` int(11) NOT NULL,
  `DiaChiGiaoHang` text NOT NULL,
  `SDTNguoiNhan` varchar(255) NOT NULL,
  `ThoiGianDatHang` datetime NOT NULL,
  `PhiVanChuyen` double NOT NULL,
  `TongTien` double NOT NULL,
  `MaNV` int(11) NOT NULL,
  `MaKH` int(11) NOT NULL,
  `MaLHTT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SELECT * FROM DonHang;
SELECT * FROM SaoLuuDonHang;

-- copy data
INSERT INTO 
SaoLuuDonHang
(
	MaDH,
    DiaChiGiaoHang,
    SDTNguoiNhan,
    ThoiGianDatHang,
    PhiVanChuyen,
    TongTien,
    MaNV,
    MaKH,
    MaLHTT
)
SELECT
(
	MaDH,
    DiaChiGiaoHang,
    SDTNguoiNhan,
    ThoiGianDatHang,
    PhiVanChuyen,
    TongTien,
    MaNV,
    MaKH,
    MaLHTT
)
FROM DonHang;








