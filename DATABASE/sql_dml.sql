-- B. DELETE
-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
delete from nhanvien 
where TENNV LIKE 'Hoàng';

-- =      equals
-- LIKE 
-- xyz%   startWidth
-- %xyz   endWidth

-- 2. Xóa bộ phận giao hàng trong hệ thống
delete from chucvu 
where TenCV LIKE 'Nhân viên giao hàng';

-- 3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ
delete m
from mathang m
inner join loaihang l on m.MaLH = l.MaLH
where TenLH='Mũ';

-- SUBQUERY
delete from mathang
where MaLH=(select MaLH 
			from Loaihang 
            where TenLH='Mũ');

-- 4. Xóa tất cả các mặt hàng trong hệ thống
select * from donhang;
delete from donhang
where cast(thoigiandathang as date) = '2020-12-18';

-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 23/11/2019
--    Thực hiện xóa các đơn hàng bị lỗi


-- C. UPDATE
-- 1. Cập nhật tên mới cho chucvu có MaCV = 2 thành 'Bộ phận quản lý'
update chucvu
 set TenCV='Bộ phận quản lý' 
 where MaCV=2;
-- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'
alter table donhang
add GhiChu Text;
select * from donhang;
update donhang set GhiChu = 'Giao hàng sau 10H sáng'
where MaDH =1;

-- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật
--    MaTT = 03, TrangThai = 'Đã giao', ThoiGian = Thời gian hiện tại
select * from donhang where MaDH=1;
select * from tinhtrangdonhang;
select * from chitiettinhtrangdonhang;

insert into chitiettinhtrangdonhang (MaDH,MaTT,MaNV,Thoigian)
values (1,5,2,'2020-12-16 20:20:40');



-- 4. Cập nhật số tiền cần thanh toán trong bảng hóa đơn thành 890 cho đơn hàng 01
select * from hoadon;
insert into hoadon(MaHD,MaDH,NgayXuatHoaDon,SoTienCanThanhToan) 
values (1,1,curent_timestamp(),890);

-- 5. Cập nhật tất cả các mặt hàng thuộc loại hàng là 'Mũ' với giá bán là 199K
update ChiTietMatHang
set GiaBan = 199
where MaMH in ( select MaMH 
					from mathang 
                    where MaLH = (select MaLH from Loaihang where TenLH='Áo'));


-- 6. 

