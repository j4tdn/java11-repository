-- CREATE SCHEMA java11_shopping_manually CHAR SET utf8mb4;
-- USE java11_shopping_manually;

CREATE TABLE LoaiHang(
	MaLH VARCHAR(10),
	TenLoai VARCHAR(255) NOT NULL,
	CONSTRAINT PK_LoaiHang PRIMARY KEY (MaLH)
);

CREATE TABLE MatHang(
	MaMH VARCHAR(10),
    TenMH VARCHAR(255) NOT NULL,
    MauSac VARCHAR(255) NOT NULL,
    maLH VARCHAR(10),
    CONSTRAINT FK_MatHang_LoaiHang FOREIGN KEY (MaLH) REFERENCES LoaiHang(MaLH)
);

ALTER TABLE MatHang
ADD CONSTRAINT PK_MatHang PRIMARY KEY (MaMH);

ALTER TABLE LoaiHang ADD NgayTao DATE NOT NULL DEFAULT(curdate());

ALTER TABLE LoaiHang 
CHANGE NgayTao CREATED DATE NOT NULL DEFAULT (curdate());

CREATE TABLE KichCo(
MaKC VARCHAR(10),
MoTa VARCHAR(255)
);

ALTER TABLE kichco ADD CONSTRAINT PK_MatHang PRIMARY KEY (MaKC);

CREATE TABLE ChiTietMatHang(
MaMH VARCHAR(10),
MaKC VARCHAR(10),
HinhAnh VARCHAR(255) NOT NULL,
GiaBan DOUBLE NOT NULL,
GiaMua DOUBLE NOT NULL,
SoLuong INT NOT NULL,
CONSTRAINT PK_ChiTietMatHang PRIMARY KEY (MaMH, MaKC),
CONSTRAINT FK_ChiTietMatHang_MaMH FOREIGN KEY (MaMH) REFERENCES MatHang(MaMH),
CONSTRAINT FK_ChiTietMatHang_KichCo FOREIGN KEY (MaKC) REFERENCES KichCo(MaKC)
);

ALTER TABLE LoaiHang DROP COLUMN CREATED;

ROLLBACK;

-- MERGE - saveOrUpdate
-- INSERT - UPDATE 



-- Phân biệt Truncate(not rollback, no filter) và Delete(rollback, filter(where))
-- Trancate hiệu xuất lớn hơn Delete không có điều kiện

-- JDBC executeQuery, executeUpdate
-- update >> INSERT, UPDATE, DELETE
-- SELECT >> SELECT

