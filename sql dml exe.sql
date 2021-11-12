-- B. DELETE
-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM nhanvien
WHERE TenNV LIKE '%hoàng%';
-- = equals
-- xyz% startwidth
-- %xyz endwidth
-- %xyz% contains note keyword like
-- 2. Xóa bộ phận giao hàng trong hệ thống
DELETE FROM chucvu 
WHERE TenCV LIKE 'Nhân viên giao hàng';
-- 3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ
DELETE FROM mathang
WHERE MaLH = (SELECT MaLH FROM loaihang WHERE TenLH = 'Mũ');
-- 4. Xóa tất cả các mặt hàng trong hệ thống
DELETE FROM mathang;
-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 23/11/2019
--  Thực hiện xóa các đơn hàng bị lỗi
SELECT CAST(ThoiGianDatHang AS DATE) thoigiandathang FROM donhang;
DELETE FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18';
-- ======================= REFRESH DATA =======================
-- C. UPDATE
-- 1. Cập nhật tên mới cho chuc vu có MaCV = 2 thành 'Bộ phận quản lý'
UPDATE chucvu
SET TenCV = 'Bộ phận quản lý'
WHERE MaCV = 2;
-- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'
ALTER TABLE donhang
ADD GhiChu TEXT;
UPDATE donhang
SET GhiChu = 'giao hàng sau 10h sáng'
WHERE MaDH = 1;
-- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật
SELECT * FROM donhang WHERE MaDH =1;
SELECT * FROM tinhtrangdonhang;
SELECT * FROM chitiettinhtrangdonhang;
INSERT INTO chitiettinhtrangdonhang(MaDH, MaTT, MaNV, ThoiGian)
VALUES(1, 5, 2, '2020-12-16 20:20:40');
-- 4. Cập nhật số tiền cần thanh toán trong bảng hóa đơn thành 890 cho đơn hàng 01
SELECT * FROM hoadon;
INSERT INTO hoadon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
VALUES (1, 1, current_timestamp(), 890);
-- 5. Cập nhật tất cả các mặt hàng thuộc loại hàng là 'Mũ' với giá bán là 199K
UPDATE chitietmathang
SET GiaBan = 199
WHERE MaMH =  (SELECT MaDH
			   FROM chitietdonhang
               WHERE MaLH = (SELECT MaLH FROM loaihang WHERE TenLH LIKE 'Áo'));
SELECT * FROM chitietmathang;
SELECT * FROM loaihang;

-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
SELECT mh.TenMH, ctmh.GiaBan
FROM mathang mh
JOIN chitietmathang ctmh ON mh.MaMH = ctmh.MaMH
WHERE ctmh.GiaBan IN (SELECT MAX(ctmh.GiaBan)
FROM loaihang lh
JOIN mathang mh
	ON lh.MaLH = mh.MaLH
JOIN chitietmathang ctmh
	ON mh.MaMH = ctmh.MaMH
GROUP BY lh.MaLH);
-- 18. OUTPUT 
-- 	   CTE: COMMON TABLE EXPRESSION

WITH CTE_LoaiHang AS(
	SELECT lh.MaLH, lh.TenLH, MAX(ctmh.GiaBan) 'GiaBanCaoNhat'
	FROM loaihang lh
	JOIN mathang mh
		ON lh.MaLH = mh.MaLH
	JOIN chitietmathang ctmh
		ON mh.MaMH = ctmh.MaMH
	GROUP BY lh.MaLH
)
SELECT lh.MaLH,
	   lh.TenLH,
       mh.MaMH,
       mh.TenMH,
       ctmh.GiaBan
FROM CTE_LoaiHang lh
JOIN mathang mh 
	ON lh.MaLH = mh.MaLH
JOIN chitietmathang ctmh 
	ON ctmh.MaMH = mh.MaMH
WHERE ctmh.GiaBan = lh.GiaBanCaoNhat;



