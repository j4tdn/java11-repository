CREATE SCHEMA java11_shopping_manually CHAR SET utf8mb4;
USE java11_shopping_manually;

CREATE TABLE LoaiHang(
	MALH INT,
    TenLoai VARCHAR(255) NOT NULL,
    CONSTRAINT PK_LoaiHang PRIMARY KEY (MaLH)
);

CREATE TABLE MatHang(
	MaMH INT,
    TenMH VARCHAR(255) NOT NULL,
    MauSac VARCHAR(255) NOT NULL,
    MaLH INT NOT NULL, 
    CONSTRAINT PK_MatHang_LoaiHang FOREIGN KEY (MaLH) REFERENCES LoaiHang(MaLH)
);

	-- 3
ALTER TABLE MatHang
ADD CONSTRAINT PK_MatHang PRIMARY KEY (MaMH);
 
	-- 4
ALTER TABLE LoaiHang 
ADD NgayTao DATE NOT NULL DEFAULT(curdate());

	-- 5
ALTER TABLE LoaiHang 
CHANGE NgayTao CREATED DATE NOT NULL DEFAULT(curdate());

	-- 6
CREATE TABLE KichCo(
	MaKC VARCHAR(10),
    MoTa VARCHAR(255) NOT NULL,
    CONSTRAINT PK_KichCo PRIMARY KEY (MaKC)
);
	
    -- 7
CREATE TABLE ChiTietMatHang(
	MaMH INT,
    MaKC VARCHAR(10),
    HinhAnh VARCHAR(255) NOT NULL,
    GiaBan DOUBLE NOT NULL,
    GiaMua DOUBLE NOT NULL,
    SoLuong INT NOT NULL,
    CONSTRAINT PK_ChiTietMatHang PRIMARY KEY (MaMH, MaKC),
	CONSTRAINT FK_ChiTietMatHang_MatHang FOREIGN KEY (MaMH) REFERENCES MatHang(MaMH),
	CONSTRAINT FK_ChiTietMatHang_KichCo FOREIGN KEY (MaKC) REFERENCES KichCo(MaKC)
);

	-- 9
ALTER TABLE LoaiHang DROP COLUMN CREATED;
	
	-- 10:   phan biet Truncate (not rollback, no filter, faster ) --  Delete (rollback, filter(where))
	
