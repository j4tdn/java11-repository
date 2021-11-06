-- D. SELECT - SLIDE 25-44
-- 1. Toàn bộ thông tin các loại hàng
    -- Mặt hàng thuộc loại hàng là 'Thắt lưng'
    -- Top 5 mặt hàng có giá bán cao nhất
    
Select * 
from Mathang 
where MaLH = (select MaLH From LoaiHang Where TenLH = "Thắt lưng");

Select mh.*, GiaBan
from chitietmathang ct join mathang mh
 on ct.MaMH = mh.MaMH
 order by GiaBan Desc limit 5;
    
-- 2. Đơn hàng
-- Được bán trong ngày 28/11/2019
select * from donhang
where thoigiandathang LIKE "2019-11-28%";

SELECT * FROM donhang
WHERE CAST(thoigiandathang AS DATE) = '2021-11-28'; 

    -- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
select * from donhang
where  "2019-11-28%" < thoigiandathang < "2019-12-02%";   

select * FROM donhang
WHERE CAST(thoigiandathang AS DATE) BETWEEN '2021-11-28' and '2021-12-02';

    -- Được bán trong tháng 11/2019
select * from donhang
where thoigiandathang LIKE "2020-12%";  

SELECT * FROM donhang
WHERE MONTH(ThoiGianDatHang)=11 AND YEAR(ThoiGianDatHang)=2019;

    -- Được giao hàng tại Hòa Khánh
select * from donhang
where DiaChiGiaoHang LIKE "%Hòa Khánh";  
-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
Select *,GiaBan*0.8 as GiaMoi from chitietmathang;
Select round(GiaMoi,2) from chitietmathang;
-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019 
select (GiaBan*0.8) as GiaMoi from chitietmathang
where MaMH = (select MaMH 
				From chitietdonhang 
                Where MaDH = (select MaDH from donhang where thoigiandathang LIKE "2020-12-18%"));
select mh.MaMH,
	   ct.GiaBan,
       ct.GiaBan*0.8 GiaBanKhuyenMai,
       curdate() NgayBan
from mathang mh
join chitietmathang ct
on mh.MaMH = ct.MaMH
where curdate() = '2019-11-25';                
-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
select Distinct MauSac from mathang;
-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
select m.maMH, TenMH, p.ThoiGianDatHang from MatHang m 
			inner Join ChiTietDonHang n On m.maMH = n.maMH
			inner Join DonHang p On n.maDH = p.maDH
where thoigiandathang LIKE "2019-11-23%";
-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
select m.maMH, TenMH, GiaBan from MatHang m 
			inner Join ChiTietMatHang n On m.maMH = n.maMH
where 100<Giaban<300;
-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
	select m.maMH, TenMH, TenLH from MatHang m 
			inner Join LoaiHang n On m.maLH = n.maLH
	where TenLH = "Mũ" AND TenLH = "Thắt lưng";
-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
	select m.maMH, TenMH, p.ThoiGianDatHang from MatHang m 
			inner Join ChiTietDonHang n On m.maMH = n.maMH
			inner Join DonHang p On n.maDH = p.maDH
where thoigiandathang = "2019-11-28%" and thoigiandathang = "2019-12-14%";
-- ==============================================================
-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
Select * from Mathang m join chitietmathang c
on m.MaMH = c.MaMH order by GiaBan asc ;
-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
Select * from Mathang m join chitietmathang c
on m.MaMH = c.MaMH order by GiaMua desc ;
-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
Select * from Mathang m join chitietmathang c
on m.MaMH = c.MaMH 
group by GiaMua, GiaBan
order by GiaMua desc, GiaBan asc;
-- 14. Đếm số lượng các mặt hàng trong hệ thống
select count(*) from mathang; 
-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
select count(*) from MatHang m 
			inner Join ChiTietDonHang n On m.maMH = n.maMH
			inner Join DonHang p On n.maDH = p.maDH
 where thoigiandathang LIKE "2019-11-23%" and TenMH = "Giày da Nam"; 

-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
--    MaLoai  TenLoai SoLuong
--	1       Giày    20
--	2       Áo      28
SELECT lh.MaLH, TenLH, sum(ctmh.SoLuong) as SoLuong from MatHang m 
			inner Join loaihang lh On m.maLH = lh.MaLH
			inner Join chitietmathang ctmh On m.maMH = ctmh.maMH
            group by m.MaLH; 
            

-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
Select * from Mathang m 
join chitietmathang c on m.MaMH = c.MaMH
join loaihang l on m.MaLH = l.MaLH
where TenLH = "Giày dép"
order by GiaBan desc limit 1;
-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
select TenMH, TenLH, max(GiaBan) as GiaMax from MatHang m 
			Join loaihang lh On m.maLH = lh.MaLH
			Join chitietmathang ctmh On m.maMH = ctmh.maMH
            group by m.MaMH; 
            
-- CTE: COMMON TABLE EXPRESSION
WITH CTE_LoaiHang AS (
	SELECT  lh.MaLH,
			lh.TenLH,
			MAX(ctmh.GiaBan) GiaBanCaoNhat
	FROM LoaiHang lh
	JOIN MatHang mh
		ON lh.MaLH = mh.MaLH
	JOIN ChiTietMatHang ctmh
		ON mh.MaMH = ctmh.MaMH
	GROUP BY lh.MaLH
)
SELECT lh.MaLH,
       lh.TenLH,
       mh.MaMH,
       mh.TenMH,
       ctmh.GiaBan,
       ctmh.MaKC,
       lh.GiaBanCaoNhat
FROM CTE_LoaiHang lh
JOIN MatHang mh
	ON mh.MaLH = lh.MaLH
JOIN ChiTietMatHang ctmh
	ON mh.MaMH = ctmh.MaMH 
WHERE ctmh.GiaBan = lh.GiaBanCaoNhat;            
             
-- 19. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
select TenMH, TenLH, sum(n.SoLuong) as Total from MatHang m 
			Join loaihang p On m.maLH = p.MaLH
			Join chitietmathang n On m.maMH = n.maMH
            group by n.MaMH; 
-- 20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
--    Điều kiện tổng số lượng > 20 mặt hàng
select TenMH, TenLH, sum(n.SoLuong) as Total from MatHang m 
			Join loaihang p On m.maLH = p.MaLH
			Join chitietmathang n On m.maMH = n.maMH
            group by m.MaMH
            having Total > 20; 

-- ==============================================================
-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
-- CTE: COMMON TABLE EXPRESSION
WITH CTE_MatHang AS (
-- Số lượng mặt hàng lớn nhất của mỗi mặt hàng
   SELECT mh.MaMH,
          mh.TenMH,
          sum(ctmh.SoLuong) SoLuongMatHang
   FROM MatHang mh
   JOIN ChiTietMatHang ctmh
   ON mh.MaMH = ctmh.MaMH
   GROUP BY mh.MaMH
),
CTE_LoaiHang AS (
-- Số lượng mặt hàng lớn nhất của mỗi loại hàng
SELECT mh.MaLH,
       max(cte.SoLuongMatHang) SoLuongCaoNhat
FROM MatHang mh
JOIN CTE_MatHang cte
ON mh.MaMH = cte.MaMH
GROUP BY mh.MaLH
)
SELECT * 
FROM CTE_MatHang ctemh
JOIN MatHang mh
	ON ctemh.MaMH = mh.MaMH
JOIN CTE_LoaiHang ctelh
	ON mh.MaLH = ctelh.MaLH
WHERE ctemh.SoLuongMatHang = ctelh.SoLuongCaoNhat;
          
 
-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
select TenLH, sum(n.GiaBan)/count(n.MaMH) as averagePrice from MatHang m 
			Join loaihang p On m.maLH = p.MaLH
			Join chitietmathang n On m.maMH = n.maMH
            group by TenLH;
-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
select m.MaLH, p.TenLH, sum(n.SoLuong) as soluong from MatHang m 
			Join loaihang p On m.MaLH = p.MaLH
			Join chitietmathang n On m.maMH = n.maMH
            group by m.MaLH
            order by soluong desc
            limit 3
            ;
-- 24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100
select * from MatHang m 
			Join loaihang p On m.maLH = p.MaLH
			Join chitietdonhang n On m.maMH = n.maMH
            where m.MaLH = 2 and n.MaDH = 1001000;
-- 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11
select * from MatHang m 
			Join chitietdonhang n On m.maMH = n.maMH
			Join donhang d On n.maDH = d.MaDH
            where m.MaLH = 2 and d.ThoiGianDatHang LIKE "%11-28%";
-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
select * from MatHang m 
			Join loaihang p On m.maLH = p.MaLH
            where p.TenLH = "Mũ" 
            and MaMH not in (
            select MaMH from donhang d Join chitietdonhang n On d.maDH = n.maDH
			where d.ThoiGianDatHang LIKE "2020-02-14%"
            );
-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
update chitietmathang
set Giaban = 199
where MaMH in (
		select MaMH from mathang m 
        Join loaihang l on m.MaLH = l.MaLH
        where TenLH = "Áo"
);
-- 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)
--     Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
CREATE TABLE LoaiHang_BACKUP(
	MaLH int,
    TenLH VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
--      Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
insert into LoaiHang_BACKUP(MaLH, TenLH)
SELECT MaLH, TenLH 
FROM LoaiHang;

select * from LoaiHang_BACKUP;
-- 29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11
select * from MatHang m 
			Join chitietdonhang n On m.maMH = n.maMH
			Join donhang d On n.maDH = d.MaDH
            where m.MaLH = 2 and d.ThoiGianDatHang LIKE "%11-23%";
-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'

-- 31. Tính tổng tiền cho đơn hàng 02
--    Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
select d.MaDH, sum(n.GiaBan * p.SoLuong) + d.PhiVanChuyen TotalPrice from donhang d
			Join chitietdonhang p On d.MaDH = p.MaDH
			Join chitietmathang n On p.maMH = n.maMH
            group by d.MaDH;
-- 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
-- 	SoDH ChiTietDonHang           TongTien
--    02   TenMH:GiaBan:SoLuong     100
select d.MaDH as SoDH, concat(m.TenMH,':', n.GiaBan,':',p.SoLuong) as ChiTietDonHang, 
(n.GiaBan * p.SoLuong) as TongTien from hoadon d
			Join chitietdonhang p On d.MaDH = p.MaDH
			Join chitietmathang n On p.maMH = n.maMH
            join mathang m on n.MaMH = m.MaMH
            group by d.MaDH;

 