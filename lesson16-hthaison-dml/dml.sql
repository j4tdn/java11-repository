	use java11_shopping;
	-- A. INSERT
	-- Sử dụng bảng dữ liệu mẫu. Thực hiện thêm dữ liệu vào cơ sở dữ liệu cho table
	-- Mathang
	-- + LoaiHang
	-- + Sử dụng refresh-insertt-data.sql để refresh data

	-- ======================= REFRESH DATA =======================

	-- B. DELETE
	-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
		delete from nhanvien where TenNv like '%Hoàng%';
	-- 2. Xóa bộ phận giao hàng trong hệ thống
	-- SET FOREIGN_KEY_CHECKS = 0;
		Delete from chucvu
		where TenCV like 'Nhân viên giao hàng';
	-- 3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ
		delete from mathang where MaLH in (select MaLH from loaihang where TenLH like '%Mũ%');
	-- 4. Xóa tất cả các mặt hàng trong hệ thống	
	delete from mathang;
	-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 23/11/2019
	SET SQL_SAFE_UPDATES=0;
		Select Cast(ThoiGianDatHang as Date) ThoiGiandathang from donhang;
		delete from donhang
		where cast(thoigiandathang as date) = '2021-01-05';
	-- Thực hiện xóa các đơn hàng bị lỗi

	-- ======================= REFRESH DATA =======================
	-- C. UPDATE
	-- 1. Cập nhật tên mới cho phòng ban có MaPB = 2 thành 'Bộ phận quản lý'
		update chucvu set TenCV = 'Bộ Phận quản lý' where MaCV = 2;
	-- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'
		alter table donhang add ghichu text;
			update donhang set ghichu = 'Giao hàng sau 10h sáng' where MaDH = 1;
	-- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật
	--    MaTT = 03, TrangThai = 'Đã giao', ThoiGian = Thời gian hiện tại
		select * from tinhtrangdonhang;
		select * from chitiettinhtrangdonhang;
		insert into tinhtrangdonhang values (6,'Đã giao');
		update chitiettinhtrangdonhang set  MaTT = (select MaTT from tinhtrangdonhang where MoTa like '%đã giao%') and Thoigian = '2021-11-2 9:54:22' where MaDH = 3;
	-- 4. Cập nhật số tiền cần thanh toán trong bảng hóa đơn thành 890 cho đơn hàng 01
		 insert into HoaDon
		 values(1,1, current_timestamp(), 890);
	 -- 5. Cập nhật tất cả các mặt hàng thuộc loại hàng là 'Mũ' với giá bán là 199K
		 update mathang set giaban = 199000 where MaLH in (select MaLH from loaihang where TenLH like '%Mũ%');
	-- ======================= REFRESH DATA =======================
	-- D. SELECT - SLIDE 25-44
	-- 1. Toàn bộ thông tin các loại hàng
		-- Mặt hàng thuộc loại hàng là 'Thắt lưng'
		select * from mathang where MaLH in (select * from loaihang where tenlh like '%Thắt lưng%');
		-- Top 5 mặt hàng có giá bán cao nhất
		select * from mathang 
				a join chitietmathang b on a.MaMH  = b.MaMH
				order by Giaban  Desc Limit 5;
	-- 2. Đơn hàng
		-- Được bán trong ngày 28/11/2019
		select * from hoadon;
		select * from hoadon where NgayXuatHoaDon like '2019-11-28';
		-- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
		select * from hoadon where cast(ngayxuathoadon as date) between '2019-11-28' and '2019-12-02';
		-- Được bán trong tháng 11/2019
				select * from hoadon where cast(ngayxuathoadon as date) between '2019-11-1' and '2019-11-30';
		-- Được giao hàng tại Hòa Khánh
			select * from donhang where DiaChiGiaoHang like '%Hòa Khánh%';
	-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
		SELECT *, GiaBan * 0.8 as 'Gia Khuyen Mai'
		FROM chitietmathang;    
	-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
		
	-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
		Select distinct MauSac from mathang;
	-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
		Select m.MaMH, TenMH, ThoiGianDatHang 
		from Mathang  m 
		inner join chitietdonhang c on m.mamh = c.mamh
		inner join donhang as dh on c.madh = dh.madh
		where cast(ThoiGianDatHang as date) = '2019-11-23';
	-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
		Select * from mathang
		inner join chitietmathang on mathang.MaMH = chitietmathang.MaMH
		where giaban between 100 and 300;
		
	-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
		select * from mathang mh
		inner join chitietmathang ct on mh.MaMH = ct.MaMH 
		where ct.loaihang like 'Mũ' or 'thắt lưng';
	-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
		select * from donhang 
		where cast(thoigiandathang as date) = '2019-11-28' or cast(ThoiGianDatHang as date) = '2019-21-14';
	-- ==============================================================
	-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
		select * from mathang m inner join chitietmathang c 
		on m.MaMH = c.MaMH order by giaban asc ;
	-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
		select * from mathang m inner join chitietmathang c 
		on m.MaMH = c.MaMH order by giamua desc;
	-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
		select * from mathang m inner join chitietmathang c 
		on m.MaMH = c.MaMH order by giaban asc, giamua desc;
	-- 14. Đếm số lượng các mặt hàng trong hệ thống
		select count(*) as soluong from mathang;
	-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
		Select count(*)
		from Mathang  m 
		inner join chitietdonhang c on m.mamh = c.mamh
		inner join donhang as dh on c.madh = dh.madh
		where cast(ThoiGianDatHang as date) = '2019-11-23';
	-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
		select l.mal, l.tenlh, count(m.malh) as SoLuong
		from loaihang l
		inner join mathang m on l.malh = m.MaLH
		group by l.MaLH;
	--     MaLoai  TenLoai SoLuong
	-- 	1       Giày    20
	-- 	2       Áo      28
	-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
		select * from mathang m 
		inner join chitietmathang c on m.MaMH = c.MaMH
		where malh in (select malh from loaihang where TenLH like'%Giày%')
		order by giaban desc limit 1;
	-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
		select * from mathang m
		inner join chitietmathang c on m.MaMH = c.MaMH
		where c.giaban in 
		(select  max(c.giaban) as giabancaonhat from mathang m
		inner join chitietmathang c on m.MaMH = c.MaMH 
		inner join loaihang l on m.malh = l.MaLH
		group by l.TenLH);
	-- 19. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
		select tenlh, sum(Soluong) as soluong from mathang m
		inner join chitietmathang c on m.MaMH = c.MaMH
		inner join loaihang l on m.malh = l.MaLH
		group by l.malh;
	-- 20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
	 --    Điều kiện tổng số lượng > 20 mặt hàng
		select tenlh, sum(Soluong) as Soluong 
		from mathang m 
		inner join chitietmathang c on c.MaMH = m.MaMH
		inner join loaihang l on l.malh = m.malh
		group by l.malh
		having tongSl > 20;
	-- ==============================================================
	-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
		select m.tenMH, l.tenLh, max(SoLuong) as SlMax 
		from mathang mathang
		inner join chitietmathang c on m.MaMH  = c.MaMH
		inner join loaihang l on m.MaLH = m.MaLH
		group by l.MaLH;
	-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
		select TenLH. avg(giaban) as Trungbinh from mathang mathang
		inner join chitietmathang c on m.MaMH = c.MaMH
		inner join loaihang l on m.malh = l.MaLH
		group by l.maLH;
		
	-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
		
	-- 24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100
		select * from mathang mathang
		inner join chitietdonhang c on m.MaMH = c.MaMH
		where m.malh = 2 and c.MaDH = 100100;
	-- 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11
		select * from chitietmathang c
		inner join mathang m on c.mamh = m.mamh
		where malh =2 and cast(thoigiandathang as date) = '2019-11-18';
	-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
		select * from mathang m
		where m.MaLH in (select malh from loaihang where TenLH like '%Mũ%')
		and m.MaMH not in
		(select m.MaMH
		 from donhang d
		 inner join chitietdonhang c on d.madh - c.MaDH
		 inner join mathang m on m.MaMH = c.mamh
		 inner join loaihang l on m.MaLH = l.MaLH
		 where tenlh like '%Mũ%' and cast(thoigiandathang as date) = '2019-02-14');
	-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
		update chitietmathang set giaban = 199
		where mamh in (select mamh from mathang where malh = (select malh from Loaihang where tenlh like '%áo%'));
	-- 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)
	--     Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
	-- 29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11
		select * from mathang m
		inner join chitietdonhang c on m.MaMH = c.MaMH
		inner join chitiettinhtrangdonhang ct on c.MaDH = ct.MaDH
		where m.MaLH = 2 and day(ct.thoigian) = 23 and month(cd.thoigian) = 11;
	-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'
		
	-- 31. Tính tổng tiền cho đơn hàng 02
	--     Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
	select d.MaDH, SUM(cm.GiaBan * cd.SoLuong) as TongTien
	from DonHang d
	inner join ChiTietDonHang cd on cd.MaDH = d.MaDH
	inner join ChiTietMatHang  cm on cm.MaMH = cd.MaMH
	group by d.MaDH;
	-- 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
	-- 	SoDH ChiTietDonHang           TongTien
	--    02   TenMH:GiaBan:SoLuong     100
	select * from mathang m
	inner join chitietmathang ct on m.mamh - ct.mamh
	inner join chitietdonhang cd on ct.MaMH = cd.MaMH
	inner join donhang d on cd.MaDH = d.MaDH
	where ct.MaDH = 2;
	-- tạo 1 bảng sao lưu đơn hàng copy dữ liệu từ bảng đơn hàng sang

	CREATE TABLE `saoluudonhang` (
	  `MaDH` int(11) NOT NULL,
	  `DiaChiGiaoHang` text NOT NULL,
	  `SDTNguoiNhan` varchar(255) NOT NULL,
	  `ThoiGianDatHang` datetime NOT NULL,
	  `PhiVanChuyen` double NOT NULL,
	  `TongTien` double NOT NULL,
	  `MaNV` int(11) NOT NULL,
	  `MaKH` int(11) NOT NULL,
	  `MaLHTT` int(11) NOT NULL,
	  PRIMARY KEY (`MaDH`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	insert into saoluudonhang
	select * from donhang;