DELETE from nhanvien 
WHERE TenNV = 'Văn Hoàng';
-- = equal
-- LIKE 
-- xyz% startsWith  like 'Hoang%'
-- %xyz endsWith
-- %xyz% contains

DELETE from chucvu WHERE TenCV like 'Nhân viên giao hàng';
DELETE from mathang WHERE MaLH = 
(select MaLH from loaihang where TenLH like 'Mũ');
DELETE from mathang;


SELECT cast(ThoiGianDatHang as DATE) ThoiGianDatHang
from donhang where cast(ThoiGianDatHang as DATE)='2020-12-18';

DELETE from donhang
 where cast(ThoiGianDatHang as DATE)='2021-01-05';
/*=========================*/
UPDATE chucvu 
set tenCV='Bộ phận quản lý'
where MaCv=2;


ALTER TABLE donhang  
add GhiChu Text;

UPDATE donhang set Ghichu = 'Giao hang sau 10h'
where MaDH=1;

INSERT into chitiettinhtrangdonhang(MaDH,MaTT,MaNV,ThoiGian)
VALUES(1,5,2,'2020-12-16 20:20:40');

INSERT INTO hoadon(MaHD,MaDH,NgayXuatHoaDon,SoTienCanThanhToan)
VALUES(1,1,current_timestamp(),890);

UPDATE chitietmathang set giaban=199
where
maMH in (SELECT MaMH FROM mathang 
WHERE MaLH = (select MaLH from loaihang where TenLH like 'Áo')
);

-- Sao luu don hang.Copy toan bo du lieu tu bang DonHang vao bang SaoLuuDonHang
-- Cau truc 2 bang giong nhau
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
  `GhiChu` Text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- Copy data
INSERT INTO saoluudonhang(MaDH,DiaChiGiaoHang,SDTNguoiNhan,ThoiGianDatHang,PhiVanChuyen,TongTien,MaNV,MaKH,MaLHTT,GhiChu)
select (MaDH,DiaChiGiaoHang,SDTNguoiNhan,ThoiGianDatHang,PhiVanChuyen,TongTien,MaNV,MaKH,MaLHTT,GhiChu) FROM donhang;

-- ====================================
-- Giam 15k neu gia ban lon hon gia mua từ 30k tro len 
select *,if(GiaBan-GiaMua>=30, giaban-15,giaban) as giagiam
from chitietmathang;


-- Group_concat(column)
select group_concat(tenmathang) 
 from mathang;






-- BTVN

-- **Top 5 mặt hàng có giá bán cao nhất - Use limit
select mathang.*,chitietmathang.GiaBan from mathang 
join chitietmathang on mathang.MaMH=chitietmathang.MaMH
ORDER BY GiaBan DESC
LIMIT 5;
 
-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
select mathang.*, ROUND(0.8*giaban, 2) 
from chitietmathang ;


-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019 
select mh.MaMH,
	   ctmh.giaban,ctmh.giaban*0.8 as 'gia khuyen mai'
 FROM mathang mh
join chitietmathang ctmh
on mh.MaMH=ctmh.MaMH
WHERE curdate()='2021-11-06';






-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
SELECT * 
FROM MatHang
JOIN LoaiHang ON MatHang.MaLH = LoaiHang.MaLH
WHERE LoaiHang.TenLH = 'Thắt Lưng' OR LoaiHang.TenLH = 'Mũ';


-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
select * from donhang where cast(ThoiGianDatHang as DATE) in ('2019/11/28','2019/12/14');

select * from chitietmathang;

-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
-- Ma     ten    Soluong
--  1     giay   20
--  2     ao     28
 select loaihang.MaLH,tenlh, sum(soluong) 
 from loaihang
join mathang on mathang.MaLH=loaihang.MaLH
join chitietmathang on
mathang.MaMH=chitietmathang.MaMH
GROUP BY loaihang.MaLH;

-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày' 
select mathang.TenMH, chitietmathang.GiaBan from mathang
join chitietmathang on chitietmathang.MaMH=mathang.MaMH
join loaihang on loaihang.MaLH= mathang.MaLH
WHERE TenLH like '%Giày%'
ORDER BY GiaBan desc
limit 1
; 


-- 18. **Tìm thong tin mặt hàng có giá bán cao nhất của mỗi loại hàng ***
-- CTE: Commen table expression
WITH CTE_LoaiHang as (
SELECT loaihang.malh, max(GiaBan) as giabanMax FROM loaihang     -- Chon ra gia ban cao nhat cua moi loai                  
join mathang on mathang.Malh=loaihang.MaLH
 join chitietmathang on chitietmathang.MaMH=mathang.MaMH
GROUP BY loaihang.MaLH 
)
SELECT loaihang.MaLH, loaihang.TenLH,mathang.TenMH, chitietmathang.GiaBan from mathang 
join chitietmathang on chitietmathang.mamh = mathang.MaMH
join loaihang on loaihang.MaLH=mathang.MaLH
join CTE_LoaiHang on loaihang.MaLH
where chitietmathang.GiaBan = CTE_LoaiHang.giabanMax
;
select mathang.TenMH, chitietmathang.giaban from mathang join chitietmathang on mathang.MaMH=chitietmathang.MaMH;

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


--  19. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống

SELECT TenMH AS TenMatHang, SUM(ChiTietMatHang.SoLuong) AS SoLuong
FROM MatHang 
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
GROUP BY ChiTietMatHang.MaMH;

-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng 
-- B1: tìm so luong moi mat hang, vì mỗi mặt hàng có nhiều kích cỡ, mỗi kích cỡ sẽ có số lượng
WITH CTE_MatHang as (
select mh.MaMH, mh.TenMH, sum(SoLuong) soluong
from mathang mh 
join chitietmathang on mh.MaMH=chitietmathang.MaMH
 GROUP BY chitietmathang.MaMH
),
-- B2 tim so luong lon nhat cua moi loai hang
CTE_LoaiHang as(
SELECT mathang.MaLH, max(CTE_MatHang.soluong) soluongCaoNhat
from mathang  
join CTE_MatHang on mathang.MaMH=CTE_MatHang.MaMH
GROUP BY mathang.MaLH
)
select mh.MaLH ,mh.TenMH ,ctemh.soluong,ctelh.soluongcaonhat 'So luong cao nhat cua loai hang'
from mathang mh
join cte_loaihang ctelh on mh.MaLH=ctelh.maLH
join cte_mathang ctemh on ctemh.mamh=mh.mamh
where ctemh.soluong = ctelh.soluongcaonhat;





--  28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)
CREATE TABLE LoaiHang_BACKUP(
	MaLH int,
    TenLH VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
--      Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
INSERT INTO LoaiHang_BACKUP(MaLH, TenLH)
SELECT MaLH, TenLH 
FROM LoaiHang;

--  29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11

SELECT *
FROM MatHang 
JOIN ChiTietDonHang ON MatHang.MaMH = ChiTietDonHang.MaMH
JOIN DonHang ON DonHang.MaDH = ChiTietDonHang.MaDH
WHERE MaLH = 2 AND DATE_FORMAT(ThoiGianDatHang, '%d/%m') = '18/12';



-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần' 
WITH cte_MatHang as(
select loaihang.MaLH malh, mathang.MaMH maMH,mathang.TenMH tenmh,sum(SoLuong) as SoluongTon from loaihang join 
mathang on mathang.MaLH=loaihang.MaLH
JOIN chitietmathang on chitietmathang.MaMH=mathang.MaMH
where TenLH in ('Áo', 'Quần')
GROUP BY mathang.MaMH
),
cteLoaiHang as ( 
SELECT malh as malh, max(soluongton) as MaxSoLuong 
from cte_mathang
group by malh
)
SELECT  mathang.MaLH,lh.TenLH, mathang.MaMH,mathang.tenmh,ctemh.soluongton from 
mathang Join
cteLoaiHang ctelh on mathang.MaLH=ctelh.malh
join cte_matHang ctemh on mathang.MaMH=ctemh.mamh
join loaihang lh on lh.MaLH=ctelh.MaLH
where soluongton=maxSoLuong
;

select * from mathang join chitietmathang on mathang.MaMH=chitietmathang.MaMH;

-- 31. Tính tổng tiền cho đơn hàng 02
 --   Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng + phis van chuyen
 SELECT ctdh.MaDH, sum(ctdh.soluong * giaban)  +donhang.PhiVanChuyen
 from chitietdonhang ctdh
 join chitietmathang ctmh 
 on ctdh.MaMH=ctmh.MaMH
 join donhang on donhang.MaDH = ctdh.MaDH
 where donhang.madh = 2
 group by ctdh.MaDH
 ;
 
 
 

-- 32. Xuất thông tin cac don hang nhu sau
--  DonHang     ChitietDonHang          Tongtien
--  02          tenMH:kichco:giaBan:Soluong     100

select dh.MaDH,GROUP_CONCAT(concat(mh.tenmh,':', ctmh.MaKC,':',giaban,':', ctdh.soluong)SEPARATOR '-')CTDH, sum(ctmh.GiaBan*ctdh.SoLuong) + dh.PhiVanChuyen  from donhang dh
join chitietdonhang  ctdh on dh.MaDH=ctdh.MaDH
join mathang mh on mh.MaMH = ctdh.MaMH
join chitietmathang ctmh on ctmh.MaMH=mh.MaMH
group BY dh.MaDH;

-- *************************************************
-- Giam 15k neu gia ban lon hon gia mua từ 30k tro len 
select *,if(GiaBan-GiaMua>=30, giaban-15,giaban) as giagiam
from chitietmathang;
-- Group_concat(column)
select mathang.MaLH, group_concat(TenMH SEPARATOR ', ') 
 from mathang
 GROUP BY mathang.MaLH;





