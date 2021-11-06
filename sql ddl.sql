-- 1. Tạo cơ sở dữ liệu java11_shopping_manually
CREATE SCHEMA java11_shopping_manually CHAR SET utf8mb4;
USE java11_shopping_manually;
-- 2. Tạo table MatHang, LoaiHang
CREATE TABLE LoaiHang(
MaLH INT,
TenLoai VARCHAR(255) NOT NULL,
CONSTRAINT PK_LoaiHang PRIMARY KEY (MaLH)
);
CREATE TABLE MatHang(
MaMH INT,
TenMH VARCHAR(255) NOT NULL,
MauSac VARCHAR(255) NOT NULL,
MaLH INT NOT NULL,
CONSTRAINT FK_MatHang_LoaiHang FOREIGN KEY (MaLH) REFERENCES LoaiHang(MaLH) 
);
-- 3. Tạo ràng buộc PK, FK cho 2 tables trên
-- 4. Thêm column NgayTao kiểu Date vào table LoaiHang
-- 5. Thay đổi tên tên column NgayTao thành DATE_CREATED trong bảng LoaiHang
-- 6. Tạo table DonHang, KhachHang
-- 7. Tạo table ChiTietDonHang
-- 8. Tạo ràng buộc PK, FK trong bảng ChiTietDonHang
-- 9. Xóa column DATE_CREATED trong table LoaiHang

-- 10. Truncate table
