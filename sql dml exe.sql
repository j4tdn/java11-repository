-- B. DELETE
-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
DELETE FROM NhanVien
Where TenNV = '%Hoang';

SELECT * FROM NhanVien;

-- 2. Xóa bộ phận giao hàng trong hệ thống
-- 3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ
DELETE FROM MatHang
WHERE MaLH in (SELECT MaLH FROM LoaiHang WHERE TenLH LIKE 'Mũ');
-- 4. Xóa tất cả các mặt hàng trong hệ thống
-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 18/12/2020.
-- Thực hiện xóa các đơn hàng bị lỗi

SELECT * from DonHang
where cast(ThoiGianDatHang as date) = str_to_date('18/12/2020', '%d/%m/%y');

-- ======================= REFRESH DATA =======================
-- C. UPDATE
-- 1. Cập nhật tên mới cho phòng ban có MaPB = 2 thành 'Bộ phận quản lý'
UPDATE ChucVu
SET TenCV = 'Bộ phận quản lý'
WHERE MaCV = 2;
-- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'
ALTER TABLE DonHang
ADD GhiChu TEXT;
UPDATE DonHang
SET GhiChu = 'Giao hàng sau 10h sáng'
WHERE MaDH = 1;
-- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật
-- MaTT = 03, TrangThai = 'Đã giao', ThoiGian = Thời gian hiện tại
-- 4. Cập nhật số tiền cần thanh toán trong bảng hóa đơn thành 890 cho đơn hàng 01
SELECT * FROM HoaDon;
INSERT INTO HoaDon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
values(1,1,current_timestamp(), 890);
-- 5. Cập nhật tất cả các mặt hàng thuộc loại hàng là 'Mũ' với giá bán là 199K
UPDATE ChiTietMatHang
SET GiaBan = '199'
WHERE MaMH in (SELECT MaMH FROM MatHang WHERE MaLH 
	IN (SELECT MaLH FROM LoaiHang WHERE TenLH LIKE 'Mũ')
);

-- 6. Tạo 1 bảng SaoLuuDonHang. coppy toàn bộ dữ liệu từ bảng DonHang 
CREATE TABLE `SaoLuuDonHang` (
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
  
INSERT INTO SaoLuuDonHang (MaDH,DiaChiGiaoHang,SDTNguoiNhan,ThoiGianDatHang,
PhiVanChuyen,TongTien,MaNV,MaKH,MaLHTT)
(SELECT MaDH,DiaChiGiaoHang,SDTNguoiNhan,ThoiGianDatHang,
PhiVanChuyen,TongTien,MaNV,MaKH,MaLHTT  FROM DonHang)