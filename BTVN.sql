--  1. Toàn bộ thông tin các loại hàng
-- Mặt hàng thuộc loại hàng là 'Thắt lưng'

Select * from mathang WHERE MaLH = (select MaLH from loaihang where TenLH='Thắt lưng');

-- **Top 5 mặt hàng có giá bán cao nhất - Use limit
select mathang.MaMH , TenMH, giaban  FROM mathang 
join chitietmathang on chitietmathang.MaMH = mathang.MaMH
where chitietmathang.MaMH in (select  chitietmathang.mamh FROM chitietmathang ORDER BY GiaBan asc ) limit 1,5;
 
-- 2. Đơn hàng
	-- Được bán trong ngày 28/11/2019
    -- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
    -- Được bán trong tháng 11/2019
    -- Được giao hàng tại Hòa Khánh
select donhang.* from donhang WHERE cast(ThoiGianDatHang as DATE)='2020-12-18';
select * from donhang WHERE ThoiGianDatHang BETWEEN cast('2019-11-28' as DATE) and cast('2019-12-2' as DATE) ;
select * from donhang WHERE month(thoigiandathang)=12 and year(thoigiandathang)=2019;
 select * from donhang WHERE DiaChiGiaoHang like '%Hoà Khánh%';
 

-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
select ROUND(0.8*giaban, 2) from chitietmathang;
-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019 /////////////////////////////////////////////////////



-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
select DISTINCT mausac from mathang;


-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
SELECT donhang.madh, tenmh,ThoiGianDatHang from donhang 
JOIN chitietdonhang on chitietdonhang.MaDH=donhang.MaDH
JOIN mathang on chitietdonhang.MaMH = mathang.MaMH
WHERE cast(ThoiGianDatHang as DATE)='2020-12-18';
-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
SELECT MatHang.MaMH, TenMH, GiaBan 
FROM MatHang
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
WHERE GiaBan BETWEEN 100 AND 300;
-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
SELECT * 
FROM MatHang
JOIN LoaiHang ON MatHang.MaLH = LoaiHang.MaLH
WHERE LoaiHang.TenLH = 'Thắt Lưng' OR LoaiHang.TenLH = 'Mũ';
-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
select * from donhang where cast(ThoiGianDatHang as DATE) in ('2019/11/28','2019/12/14');

-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
select * from mathang 
JOIN chitietmathang on chitietmathang.MaMH=mathang.MaMH
ORDER BY GiaBan asc;
-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT TenMH, GiaMua
FROM ChiTietMatHang 
JOIN MatHang ON MatHang.MaMH = ChiTietMatHang.MaMH
ORDER BY GiaMua DESC;
-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
select * from mathang 
JOIN chitietmathang on chitietmathang.MaMH=mathang.MaMH
ORDER BY GiaBan asc, giamua desc;
-- 14. Đếm số lượng các mặt hàng trong hệ thống
select COUNT(*) from mathang;

-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
select count(mathang.MaMH) from donhang 
join chitietdonhang on donhang.MaDH=chitietdonhang.MaDH
join mathang on mathang.MaMH=chitietdonhang.MaMH
join loaihang on loaihang.MaLH=mathang.MaLH
WHERE cast(ThoiGianDatHang as DATE) = '2019/11/23'
and TenLH='Giày da Nam';

-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
select loaihang.MaLH,tenlh, count(mathang.mamh) from loaihang
join mathang on mathang.MaLH=loaihang.MaLH
GROUP BY loaihang.MaLH;

-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày' 
select mathang.TenMH, chitietmathang.GiaBan from mathang
join chitietmathang on chitietmathang.MaMH=mathang.MaMH
join loaihang on loaihang.MaLH= mathang.MaLH
WHERE TenLH like '%Giày%'
ORDER BY GiaBan desc
limit 1
; 

-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng///////////////////////////////////////////


--  19. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống

SELECT TenMH AS TenMatHang, SUM(ChiTietMatHang.SoLuong) AS SoLuong
FROM MatHang 
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
GROUP BY ChiTietMatHang.MaMH;

-- 20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống Điều kiện tổng số lượng > 20 mặt hàng
select tenlh, COUNT(mamh) as 'so luong' from mathang
join loaihang on mathang.MaLH=loaihang.MaLHsaoluudonhangsaoluudonhang
GROUP BY loaihang.maLh HAVING count(mamh)>20;

-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng /////////////////////////////////
SELECT loaihang.malh, loaihang.TenLH, mathang.MaMH, mathang.TenMH, sum(chitietmathang.SoLuong) from mathang
JOIN loaihang on loaihang.MaLH = mathang.MaLH
join chitietmathang on chitietmathang.MaMH=mathang.MaMH
GROUP BY loaihang.MaLH;


-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT loaihang.MaLH,loaihang.TenLH, AVG(chitietmathang.giaban) from mathang
JOIN loaihang on loaihang.MaLH = mathang.MaLH
join chitietmathang on chitietmathang.MaMH=mathang.MaMH
GROUP BY loaihang.MaLH;

-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại  /////////////////////////top3
SELECT loaihang.MaLH,loaihang.TenLH, sum(chitietmathang.SoLuong) as 'tong' from mathang
JOIN loaihang on loaihang.MaLH = mathang.MaLH
join chitietmathang on chitietmathang.MaMH=mathang.MaMH
GROUP BY loaihang.MaLH ORDER BY  'tong' desc; 

--  24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100


SELECT *
FROM MatHang
JOIN ChiTietDonHang ON MatHang.MaMH = ChiTietDonHang.MaMH
WHERE MaLH = 2 AND ChiTietDonHang.MaDH = 1;

--  25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11


SELECT *
FROM MatHang
JOIN ChiTietDonHang ON MatHang.MaMH = ChiTietDonHang.MaMH
JOIN DonHang ON DonHang.MaDH = ChiTietDonHang.MaDH
WHERE MaLH = 2 AND date_format(ThoiGianDatHang, '%d/%m') = '18/12';

--  26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019


SELECT * 
FROM MatHang 
JOIN LoaiHang ON LoaiHang.MaLH = MatHang.MaLH 
WHERE LoaiHang.TenLH = 'Áo' AND MaMH NOT IN (SELECT MaMH
											 FROM DonHang
                                             JOIN ChiTietDonHang ON ChiTietDonHang.MaDH = DonHang.MaDH
											 WHERE CAST(ThoiGianDatHang AS DATE) = '2020-12-18');

--  27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199


UPDATE ChiTietMatHang 
SET GiaBan = 199
WHERE MaMH IN (
				SELECT MaMH 
				FROM MatHang
				JOIN LoaiHang ON LoaiHang.MaLH = MatHang.MaLH
				WHERE TenLH = 'Áo'
			  );

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



-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần' //////////////////////



-- 31. Tính tổng tiền cho đơn hàng 02
 --   Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
 SELECT DonHang.MaDH, SUM(ChiTietMatHang.GiaBan * ChiTietDonHang.SoLuong) AS TongTien
FROM DonHang
JOIN ChiTietDonHang ON ChiTietDonHang.MaDH = DonHang.MaDH
JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = ChiTietDonHang.MaMH
GROUP BY DonHang.MaDH;
-- 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
SELECT d.MaDH AS  SoDH, concat(m.TenMH,':', n.GiaBan,':',p.SoLuong) AS ChiTietDonHang, 
(n.GiaBan * p.SoLuong) AS TongTien from hoadon d
			JOIN chitietdonhang p ON d.MaDH = p.MaDH
			JOIN chitietmathang n ON p.maMH = n.maMH
            JOIN mathang m ON n.MaMH = m.MaMH
            GROUP BY d.MaDH;


-- *************************************************
-- Giam 15k neu gia ban lon hon gia mua từ 30k tro len 
select *,if(GiaBan-GiaMua>=30, giaban-15,giaban) as giagiam
from chitietmathang;
-- Group_concat(column)
select mathang.MaLH, group_concat(TenMH SEPARATOR ', ') 
 from mathang
 GROUP BY mathang.MaLH;

