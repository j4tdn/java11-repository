-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
DELETE FROM nhanvien 
WHERE TENNV = "Văn Hoàng";

-- 2. Xóa bộ phận giao hàng trong hệ thống
DELETE FROM chucvu
WHERE TENCV = "Nhân viên giao hàng";

-- 3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ
-- 4. Xóa tất cả các mặt hàng trong hệ thống
-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 23/11/2019
  --  Thực hiện xóa các đơn hàng bị lỗi
