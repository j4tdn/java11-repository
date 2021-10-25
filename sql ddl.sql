CREATE SCHEMA java11_shopping_manually CHAR SET utf8mb4;
USE java11_shopping_manually;
CREATE TABLE LoaiHang (
  MaLH INT NOT NULL,
  TenLoaiHang VARCHAR(255)  NOT NULL,
  constraint PK_LoaiHang PRIMARY KEY (MaLH));
  
CREATE TABLE MatHang (
  MaMH INT NOT NULL,
  TenMH VARCHAR(255) NOT NULL,
  MauSac VARCHAR(255) NOT NULL,
  MaLH INT  NOT NULL,
  
  CONSTRAINT FK_MatHang_LoaiHang FOREIGN KEY (MaLH) REFERENCES LoaiHang(MaLH)
  );
  
Alter TABLE MatHang ADD CONSTRAINT PK_Mat_Hang PRIMARY KEY (MaMH);

 Alter TABLE LoaiHang  ADD  NgayTao Date NOT NULL DEFAULT(curdate()); 

ALTER TABLE loaihang CHANGE NgayTao  CREATED DATE NOT NULL DEFAULT(curdate());

CREATE TABLE KichCo (
  MaKC VARCHAR(10),
  MoTa VARCHAR(255) NOT NULL,
  constraint PK_MaKC PRIMARY KEY (MaKC));
  
  CREATE TABLE ChiTietMatHang (
  MaMH INT,
  MaKC VARCHAR(10),
  HinhAnh VARCHAR(255) NOT NULL,
  GiaBan Double not null,
  GiaMua Double not null,
  Soluong int not null,
  
  constraint PK_ChiTietMatHang PRIMARY KEY (MaMH,MaKC),
  CONSTRAINT FK_ChiTietMatHang_MatHang FOREIGN KEY (MaMH) REFERENCES mathang(MaMH),
  CONSTRAINT FK_ChiTietMatHang_KichCo FOREIGN KEY (MaKC) REFERENCES KichCo(MaKC)
  );
  
  Alter table LoaiHang Drop Column CREATED;