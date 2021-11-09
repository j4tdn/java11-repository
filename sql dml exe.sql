-- A. INSERT
-- Sử dụng bảng dữ liệu mẫu. Thực hiện thêm dữ liệu vào cơ sở dữ liệu cho table
-- + Mathang
-- + LoaiHang
-- + Sử dụng refresh-insertt-data.sql để refresh data

-- ======================= REFRESH DATA =======================

-- B. DELETE
-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống

-- 2. Xóa bộ phận giao hàng trong hệ thống
DELETE FROM ChucVu
WHERE TenCV LIKE 'Nhân viên giao hàng';

-- 3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ
SELECT *
FROM LoaiHang;

-- SUB QUERY
DELETE FROM MatHang
WHERE MALH = (SELECT MALH FROM LoaiHang WHERE TenLH = 'Mũ');

-- 4. Xóa tất cả các mặt hàng trong hệ thống
DELETE FROM MatHang;

-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 18/12/2020
-- 		Thực hiện xóa các đơn hàng bị lỗi
-- LOSSED, DYNAMIC TYPE
SELECT * FROM DonHang;
DELETE FROM DonHang
-- WHERE ThoiGianDatHang LIKE '2020-12-2018%';
-- WHERE CAST(ThoiGianDatHang AS DATE) = STR_TO_DATE('18-12-2020%', '%d-%m-%Y');
WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18'; -- default format: y-m-d
-- ======================= REFRESH DATA =======================
-- C. UPDATE
-- 1. Cập nhật tên mới cho phòng ban có MaPB = 2 thành 'Bộ phận quản lý'
UPDATE ChucVu
SET TenCV = 'Bộ phận quản lý'
WHERE MaCV = 2;

-- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'

-- ALTER TABLE DonHang
-- ADD GhiChu TEXT; 
UPDATE DonHang
SET GhiChu = 'Giao hàng sau 10H'
WHERE MaDH = 1; 

-- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật trạng thái
--    MaTT = 03, TrangThai = 'Đã giao', ThoiGian = Thời gian hiện tại
SELECT * FROM DonHang WHERE MaDH = 1;
SELECT * FROM TinhTrangDonHang;
SELECT * FROM ChiTietTinhTrangDonHang;

INSERT INTO ChiTietTinhTrangDonHang(MaDH, MaTT, MaNV, ThoiGian)
VALUES(1, 5, 2, '2020-12-16 20:20:40');

-- 4. Xuất hóa đơn cho đơn hàng 01 với số tiền cần thanh toán là 890
SELECT * FROM HoaDon;
INSERT INTO HoaDon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
VALUES (1, 1, current_timestamp(), 890);

-- 5. Cập nhật tất cả các mặt hàng thuộc loại hàng là 'Mũ' với giá bán là 199K
UPDATE ChiTietMatHang
SET GiaBan =199
WHERE MaMH IN (SELECT MaMH 
				FROM MatHang
				WHERE MaLH = (SELECT MaLH FROM LoaiHang WHERE TenLH LIKE 'Áo'));
SELECT * FROM ChiTietMatHang;

-- 6. Tạo 1 bảng SaoLuuDonHang. Copy toàn bộ dữ liệu từ bảng DonHang bỏ vào SaoLuuDonHang
-- Cấu trúc 2 bảng giống nhau

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

SELECT * FROM DonHang;
SELECT * FROM SaoLuuDonHang;

-- copy data
INSERT INTO SaoLuuDonHang(MaDH,DiaChiGiaoHang,SDTNguoiNhan,ThoiGianDatHang,PhiVanChuyen,TongTien,MaNV,MaKH,MaLHTT)
SELECT MaDH,DiaChiGiaoHang,SDTNguoiNhan,ThoiGianDatHang,PhiVanChuyen,TongTien,MaNV,MaKH,MaLHTT
-- ======================= REFRESH DATA =======================
-- D. SELECT - SLIDE 25-44
-- 1. Toàn bộ thông tin các loại hàng
    -- Mặt hàng thuộc loại hàng là 'Thắt lưng'
    -- Top 5 mặt hàng có giá bán cao nhất
-- 2. Đơn hàng
	-- Được bán trong ngày 28/11/2019
    -- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
    -- Được bán trong tháng 11/2019
    -- Được giao hàng tại Hòa Khánh
-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
-- ==============================================================
-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
-- 14. Đếm số lượng các mặt hàng trong hệ thống
-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
--     MaLoai  TenLoai SoLuong
-- 	1       Giày    20
-- 	2       Áo      28
-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
-- 19. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
-- 20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
--     Điều kiện tổng số lượng > 20 mặt hàng
-- ==============================================================
-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
-- 24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100
-- 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11
-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
-- 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)
--     Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
-- 29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11
-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'
-- 31. Tính tổng tiền cho đơn hàng 02
--     Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
-- 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
--  	SoDH ChiTietDonHang           TongTien
--      02   TenMH:GiaBan:SoLuong     100
