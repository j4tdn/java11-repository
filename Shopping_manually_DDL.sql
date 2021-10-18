Create database java11_shopping_manually char set utf8mb4;
use java11_shopping_manually;
create table LoaiHang(
	MaLH int,
    TenLoai nvarchar(255) not null,
    constraint PK_LoaiHang primary key (MaLH)
);
create table MatHang(
	MaMatHang int primary key,
    TenMatHang nvarchar(255) not null,
    MaLH int not null,
    MauSac nvarchar(255) not null,
    constraint FK_MatHang_LoaiHang Foreign key (MaLH) References LoaiHang(MaLH)
);
alter table LoaiHang
Add NgayTao date null default(curdate()) ;

Alter table LoaiHang
change Ngaytao Date_Create date not null default(curdate()) ;

create table Kichco(
	MaKC varchar(10),
    Mota nvarchar(255) not null,
    constraint PK_MaKC primary key (MaKC)
);
create table ChiTietMatHang(
	MaMH int,
    MaKC varchar(10),
    HinhAnh varchar(255) not null,
    GiaBan double not null,
    GiaMua double not null,
    SoLuong int not null,
    constraint PK_ChiTietMatHang primary key (MaMH, MaKC),
    constraint FK_Chitietmathang_MatHang foreign key(MAMH) references MatHang(MaMatHang),
	constraint FK_Chitietmathang_KichCo foreign key(MaKC) references Kichco(MaKC)
);

alter table LoaiHang
drop column Date_Create
