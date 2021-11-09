-- 1. Tạo cơ sở dữ liệu java11_shopping_manually
CREATE DATABASE java11_shopping_manually CHAR SET utf8mb4;
USE java11_shopping_manually;

-- 2, 3 Tạo table MatHang, LoaiHang, tạo ràng buộc

CREATE TABLE LoaiHang (
  MaLH INT,
  TenLoai VARCHAR(255) NOT NULL,
  CONSTRAINT PK_LoaiHang PRIMARY KEY (MaLH)
);
  
CREATE TABLE MatHang(
  MaMH INT,
  TenMH VARCHAR(255) NOT NULL,
  MauSac VARCHAR(255) NOT NULL,
  MaLH INT NOT NULL,
  CONSTRAINT FK_MatHang_LoaiHang FOREIGN KEY (MaLH) REFERENCES LoaiHang (MaLH)
);

ALTER TABLE MatHang 
ADD CONSTRAINT PK_MatHang PRIMARY KEY (MaMH);

-- 4
ALTER TABLE LoaiHang 
ADD NgayTao DATE NOT NULL DEFAULT(curdate());

-- 5
ALTER TABLE LoaiHang 
CHANGE NgayTao DATE_CREATED DATE NOT NULL DEFAULT(curdate());

-- 6
CREATE TABLE KichCo(
  MaKC VARCHAR(10),
  TenMH VARCHAR(255) NOT NULL,
  CONSTRAINT PK_LoaiHang PRIMARY KEY (MaKC)
);

-- 7 - 8
CREATE TABLE ChiTietMatHang(
  MaMH INT,
  MaKC VARCHAR(10),
  HinhAnh VARCHAR(255) NOT NULL,
  GiaBan DOUBLE NOT NULL, 
  GiaMua DOUBLE NOT NULL, 
  SoLuong INT NOT NULL,
  CONSTRAINT PK_ChiTietMatHang PRIMARY KEY (MaMH, MaKC), 
  CONSTRAINT FK_ChiTietMatHang_MatHang FOREIGN KEY (MaMH) REFERENCES MatHang (MaMH),
  CONSTRAINT FK_ChiTietMatHang_KichCo FOREIGN KEY (MaKC) REFERENCES KichCo (MaKC)
);
    
-- 9
ALTER TABLE LoaiHang DROP COLUMN DATE_CREATED;

-- 10. truncate table

-- 11. Hiển thị các bảng dữ liệu
SELECT * FROM information_schema.tables
WHERE TABLE_SCHEMA = 'java11_shopping_manually';








