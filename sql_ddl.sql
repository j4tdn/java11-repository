-- 1. Tạo cơ sở dữ liệu java11_shopping_manually
CREATE SCHEMA java11_shopping_manually CHAR SET utf8mb4;
-- 2. Tạo table MatHang, LoaiHang
USE java11_shopping_manually;
CREATE Table MatHang(
  MaMH INT primary key,
  TenMH VARCHAR(255) not null,
  MauSac VARCHAR(255) not null,
  MaLH INT NOT NULL,
  CONSTRAINT FK_MatHang_LoaiHang Foreign key(MaLH) REFERENCES LoaiHang(MaLH)
);

CREATE Table LoaiHang(
  MaLH INT,
  TenLH VARCHAR(255) NOT NULL,
  CONSTRAINT PK_LoaiHang PRIMARY KEY (MaLH)
);

-- 3. Tạo ràng buộc PK, FK cho 2 tables trên
-- 4. Thêm column NgayTao kiểu Date vào table LoaiHang
ALTER TABLE LoaiHang ADD NgayTao Date not null default(curdate());
-- 5. Thay đổi tên tên column NgayTao thành DATE_CREATED trong bảng LoaiHang
ALTER TABLE LoaiHang CHANGE NgayTao DATE_CREATED Date not null default(curdate());
-- 6. Tạo table KichCo
CREATE TABLE KichCo(
	MaKC varchar(10),
    MoTa varchar(255),
    CONSTRAINT PK_KichCo PRIMARY KEY (MaKC) 
);
-- 7. Tạo table ChiTietMatHang
CREATE TABLE ChiTietMatHang(
	MaMH INT,
    MaKC varchar(10),
    HinhAnh varchar(255) NOT NULL,
    GiaBan DOUBLE NOT NULL,
    GiaMua DOUBLE NOT NULL,
    SoLuong INT NOT NULL,
    CONSTRAINT PK_ChiTieyMatHang PRIMARY KEY (MaMH, MaKC) ,
    CONSTRAINT FK_ChiTietMatHang_MatHang Foreign key(MaMH) REFERENCES MatHang(MaMH),
	CONSTRAINT FK_ChiTietMatHang_KichCo Foreign key(MaKC) REFERENCES KichCo(MaKC)

);
-- 8. Tạo ràng buộc PK, FK trong bảng ChiTietDonHang
-- 9. Xóa column DATE_CREATED trong table LoaiHang
ALTER TABLE LoaiHang
DROP COLUMN DATE_CREATED;
-- 10. Truncate table
-- Phân biệt truncate(not rollback, no filter) và delete(rollback, filter(Where)) 
-- 11 hien thi all
Select * from information_schema.tables
where TABLE_SCHEMA = 'java11_shopping_manually';