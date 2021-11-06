--B. DELETE
--1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
 delete from nhanvien
 where TenNV LIKE "%Hoàng%"
 -- = equal
 --LIKE
 -- xyz% startwith
 -- %xyz endwith
2. Xóa bộ phận giao hàng trong hệ thống
delete from chucvu
 where TenCV LIKE "Nhân viên giao hàng"
3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ
delete from mathang
 where MaLH = (select MaLH From LoaiHang Where TenLH = "Mũ");
4. Xóa tất cả các mặt hàng trong hệ thống
DELETE FROM mathang;
5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 23/11/2019
   Thực hiện xóa các đơn hàng bị lỗi
   delete from donhang
   where thoigiandathang LIKE "2020-12-18%";
   
   --cach2:
      delete from donhang
   where CAST(thoigiandathang AS DATE) = STR_TO_DATE("2020-12-18");
   
 ----UPDATE  
   1. Cập nhật tên mới cho chuc vu có MaCV = 2 thành 'Bộ phận quản lý'
UPDATE chucvu 
SET 
    TenCV = "Bộ phận quản lý"
WHERE
    MaCV = 2;
2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'
Alter table Donhang
add GhiChu TEXT ; 

UPDATE DonHang 
SET 
    GhiChu = "Giao hàng sau 10H sáng"
WHERE
    MaDH = 1;

3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật
   MaTT = 03, TrangThai = 'Đã giao', ThoiGian = Thời gian hiện tại
 UPDATE chucvu 
SET 
    MaTT = 3, 
WHERE
    MaDH = 1;  
    
select * from tinhtrangdonhang;
--****
insert into Chitietdonhang(MaDH,MaTT,MaNV,Thoigian)
values(1,5,2,'2020-12-16 20:20:40');
   
4. xuất hóa đơn cho đơn hàng 01 số tiền 890k
insert into hoadon(MaHD,MaDH,Ngayxuathoadon, SoTienCanThanhToan)
values(1,1,current_timestamp(),890);

select current_timestamp();
5. Cập nhật tất cả các mặt hàng thuộc loại hàng là 'Mũ' với giá bán là 199K
update chitietmathang
set GiaBan = 199
 where MaMH IN  (select MaMH 
				From Mathang 
                Where MaLH = (select MaLH from LoaiHang where tenLH = "Áo"));
                
6. tạo một bảng SaoLuuDonHang copy toàn bộ dữ liệu từ bảng đơn hàng bo vào bảng saoluudonhang
--cau truc hai bang giong nhau
CREATE TABLE `SaoLuuDonHang` (
  `MaDH` INT NOT NULL,
  `DiaChiGiaoHang` VARCHAR(45) NOT NULL,
  `SDTNguoiNhan` VARCHAR(45) NOT NULL,
  `ThoiGianDatHang` VARCHAR(45) NOT NULL,
  `PhiVanChuyen` VARCHAR(45) NOT NULL,
  `TongTien` VARCHAR(45) NOT NULL,
  `MaKH` INT NOT NULL,
  `MaNV` INT NOT NULL,
  `MaLHTT` INT NOT NULL
) ENGINE = InnoDB DEfault charset = utf8;          

select * from DonHang;
select * from SaoLuuDonHang;   
-- copy data
insert into saoluudonhang(MaDH,DiaChiGiaoHang,SDTNguoiNhan,ThoiGianDatHang,PhiVanChuyen,TongTien,MaNV,MaKH,MaLHTT)
select MaDH,DiaChiGiaoHang,SDTNguoiNhan,ThoiGianDatHang,PhiVanChuyen,TongTien,MaNV,MaKH,MaLHTT from donhang