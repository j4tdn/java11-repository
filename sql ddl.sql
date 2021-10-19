-- 1. Tạo cơ sở dữ liệu java11_shopping_manually
CREATE SCHEMA java11_shopping_manually_2 CHAR SET utf8mb4;
USE java11_shopping_manually_2;
-- 2. Tạo table MatHang, LoaiHang --
CREATE TABLE LoaiHang(
	MaLH int, 
    TenLoai VARCHAR(255) NOT NULL,
    CONSTRAINT PK_LOAIHANG PRIMARY KEY (MaLH)
);
-- 3. Tạo ràng buộc PK, FK cho 2 tables trên --
CREATE TABLE MatHang (
	MaMH INT,
    TenMH VARCHAR(255) NOT NULL, 
    MauSac VARCHAR(255) NOT NULL,
    MaLH INT NOT NULL,
    CONSTRAINT FK_MatHang_LoaiHang FOREIGN KEY (MaLH) REFERENCES LoaiHang(MaLH),
	CONSTRAINT PK_MatHang PRIMARY KEY (MaMH)
);
-- 4. Thêm column NgayTao kiểu Date vào table LoaiHang --
ALTER TABLE LoaiHang ADD NgayTao Date NOT NULL DEFAULT(current_date());
-- 5. Thay đổi tên tên column NgayTao thành DATE_CREATED trong bảng LoaiHang

ALTER TABLE LoaiHang
CHANGE NgayTao CREATE_DATE DATE NOT NULL DEFAULT(curdate());

-- 6. Tạo table KichCo
CREATE TABLE KichCo(
	MaKC VARCHAR(10),
    MoTa VARCHAR(255) NOT NULL,
    CONSTRAINT PK_KichCo PRIMARY KEY (MaKC)
);

-- 7. Tạo table ChiTietDonHang
-- 8. Tạo ràng buộc PK, FK trong bảng ChiTietDonHang

CREATE TABLE ChiTietMatHang(
	MaMH INT,
    MaKC VARCHAR(10),
    HinhAnh VARCHAR(255) NOT NULL,
    GiaBan DOUBLE NOT NULL,
    GiaMua DOUBLE NOT NULL,
    SoLuong INT NOT NULL,
    CONSTRAINT PK_ChiTietMatHang PRIMARY KEY(MaMH, MaKC),
    CONSTRAINT FK_ChiTietMatHang_MatHang FOREIGN KEY(MaMH) REFERENCES MatHang(MaMH),
    CONSTRAINT FK_ChiTietMatHang_KichCo FOREIGN KEY(MaKC) REFERENCES KichCo(MaKC)
);

-- 9. Xóa column DATE_CREATED trong table LoaiHang
	ALTER TABLE LoaiHang DROP COLUMN CREATE_DATE;
    
-- 10. Truncate table
 