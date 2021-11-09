CREATE SCHEMA java11_shopping_manually CHAR SET utf8mb4;
USE java11_shopping_manually;
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

ALTER TABLE MatHang
ADD constraint PK_MatHang primary key (MaMH);

alter table LoaiHang
add NgayTao date not null default(curdate());

alter table LoaiHang
change NgayTao CREATED date not null default(curdate());

create table KichCo(
	MaKC varchar(10),
    MoTa varchar(255) not null,
    constraint PK_KichCo primary key (MaKC)
);
create table ChiTietMatHang(
	MaMH INT,
    MaKC varchar(10),
    HinhAnh varchar(255) not null,
    GiaBan double not null,
    GiaMua double not null,
    SoLuong int not null,
    constraint PK_ChiTietMatHang primary key (MaMH, MaKC),
    constraint PK_ChiTietMatHang_MatHang foreign key (MaMH) references MatHang(MaMH),
    constraint PK_ChiTietMatHang_KichCo foreign key (MaKC) references KichCo(MaKC)
    );
    
alter table LoaiHang drop column CREATED;
