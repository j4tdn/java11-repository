create table LoaiHang(
	MaLH int primary key, 
    TenLH varchar(255) not null
);

create table MatHang (
	MaMH int primary key, 
    TenMH varchar(255) not null, 
    MauSac varchar(255) not null,
    MaLH int not null,
    foreign key (MaLH) references LoaiHang(MaLH)
);


-- Thêm column NgayTao kiểu Date vào table LoaiHang --  
alter table LoaiHang add NgayTao Date not null;

-- 5. Thay đổi tên tên column NgayTao thành DATE_CREATED trong bảng LoaiHang --
alter table LoaiHang change NgayTao DATE_CREATED DATE;

-- 6. Tạo table DonHang, KhachHang --
 create table KhachHang(
	MaKH int primary key, 
    TenKH varchar(255) not null, 
    Email varchar(255) not null,
    DiaChi text
 );


