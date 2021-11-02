-- 1. Tạo cơ sở dữ liệu java11_shopping_manually
CREATE SCHEMA java11_shopping_manually DEFAULT CHARACTER SET utf8 ;
USE java11_shopping_manually ;

-- 2. Tạo table MatHang, LoaiHang
-- 3. Tạo ràng buộc PK, FK cho 2 tables trên

CREATE TABLE LoaiHang (
  MaLH INT NOT NULL,
  TenLH VARCHAR(255) NOT NULL,
  PRIMARY KEY (MaLH)
  );
  
  CREATE TABLE MatHang (
  MaMH INT NOT NULL,
  TenMH VARCHAR(255) NOT NULL,
  MauSac VARCHAR(255) NOT NULL,
  MaLH INT NOT NULL,
  PRIMARY KEY (MaMH),
  constraint fk_mh foreign key (MaLH) references LoaiHang(MaLH)
 );
 
-- 4. Thêm column NgayTao kiểu Date vào table LoaiHang
alter table LoaiHang add NgayTao Date ;

-- 5. Thay đổi tên tên column NgayTao thành DATE_CREATED trong bảng LoaiHang
alter table LoaiHang change NgayTao DATE_CREATED Date;
-- 6. Tạo table KichCo, ChiTietMatHang

CREATE TABLE KichCo (
  MaKC VARCHAR(10) NOT NULL,
  MoTa VARCHAR(45) NOT NULL,
  PRIMARY KEY (MaKC)
  );
  
  CREATE TABLE ChiTietMatHang (
  MaMH INT NOT NULL,
  MaKC VARCHAR(10) NOT NULL,
  HinhAnh VARCHAR(255) NOT NULL,
  GiaBan DOUBLE NOT NULL,
  GiaMua INT NOT NULL,
  SoLuong VARCHAR(45) NOT NULL,
  constraint pk_chitiet primary key (MaMH,MaKC),
  constraint fk_chitiet_mh foreign key (MaMH) references MatHang(MaMH),
  constraint fk_chitiet_kc foreign key (MaKC) references KichCo(MaKC)
);

-- 9. Xóa column DATE_CREATED trong table LoaiHang

alter table LoaiHang drop column DATE_CREATED;
-- 10. Truncate table







 


