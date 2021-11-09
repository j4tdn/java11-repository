USe java11_shopping_manually;

CREATE SCHEMA IF NOT EXISTS `java11_shopping_manually` DEFAULT CHARACTER SET utf8mb4 ;

CREATE TABLE LoaiHang(
	MaLH INT ,
    TenLH VARCHAR(50) NOT NULL,
	 CONSTRAINT PK_LoaiHang  PRIMARY KEY (MaLH)
);

CREATE TABLE MatHang (
	MaMH INT ,
    TenMH VARCHAR(50)  NOT NULL,
    MauSac VARCHAR(50) NOT NULL,
    MaLH INT NOT NULL,
	CONSTRAINT PK_MatHang  PRIMARY KEY (MaMH),
	CONSTRAINT FK_MatHang_LoaiHang FOREIGN KEY (MaLH) REFERENCES LoaiHang(MaLH)
);

alter table LoaiHang add NgayTao date not null default(curdate());

alter table LoaiHang change NgayTao Date_CREATE date default(curdate());

CREATE TABLE KichCo (
	MaKC INT,
    MoTa VARCHAR(50) NOT NULL,
    CONSTRAINT  PK_KichCo PRIMARY KEY (MaKC) 
);

CREATE TABLE ChiTietMatHang(
	MaMH INT,
    MaKC INT,
    HinhAnh VARCHAR(50) NOT NULL,
    GiaBan DOUBLE NOT NULL,
    GiaMua DOUBLE NOT NULL,
    SoLuong INT NOT NULL,
    CONSTRAINT PK_ChiTietMatHang PRIMARY KEY(MaMH, MaKC),
   CONSTRAINT FK_ChiTietMatHang_MatHang FOREIGN KEY (MaMH) REFERENCES MatHang(MaMH),
    CONSTRAINT FK_ChiTietMatHang_KichCo FOREIGN KEY (MaKC) REFERENCES KichCo(MaKC)    
);

ALTER TABLE LoaiHang DROP COLUMN Date_CREATE;


