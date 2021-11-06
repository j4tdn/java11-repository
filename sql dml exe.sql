-- B. DELETE
-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
   DELETE FROM NhanVien
   WHERE TenNV LIKE '%Hoàng%';
-- 2. Xóa bộ phận giao hàng trong hệ thống
   DELETE FROM ChucVu
   WHERE TenCV LIKE 'Nhân viên giao hàng';
-- 3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ
   DELETE FROM MatHang
   WHERE MaLH = (SELECT MaLH 
                 FROM LoaiHang 
                 WHERE TenLH = 'Mũ');
-- 4. Xóa tất cả các mặt hàng trong hệ thống
   DELETE FROM MatHang;
-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 23/11/2019
   -- Thực hiện xóa các đơn hàng bị lỗi
   -- ThoiGianDatHang: DateTime = Date + Time
   -- ThoiGianDatHang = 'VARCHAR - DATE'
   -- WHERE ThoiGianDatHang LIKE '2020-12-18%';
   DELETE FROM DonHang
   WHERE CAST(ThoiGianDatHang AS DATE) = STR_TO_DATE('17-12-2020','%d-%m-%Y');

-- ======================= REFRESH DATA =======================
-- C. UPDATE
-- 1. Cập nhật tên mới cho phòng ban có MaPB = 2 thành 'Bộ phận quản lý'
   UPDATE ChucVu
   SET TenCV = 'Bộ phận quản lý'
   WHERE MaCV = 2;
-- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'
ALTER TABLE DonHang
ADD GhiChu TEXT;
UPDATE DonHang
SET GhiChu = 'Giao hàng sau 10h sáng'
WHERE MaDH = 1;
SELECT * FROM DonHang;

-- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật
  -- MaTT = 03, TrangThai = 'Đã giao', ThoiGian = Thời gian hiện tại
  SELECT * FROM DonHang WHERE MaDH = 1;
  SELECT * FROM TinhTrangDonHang;
  SELECT * FROM ChiTietTinhTrangDonHang;
  
  INSERT INTO chitiettinhtrangdonhang(MaDH, MaTT, MaNV, ThoiGian)
  VALUES(1,5,2, '2020-12-16 20:20:40');
-- 4. Cập nhật số tiền cần thanh toán trong bảng hóa đơn thành 890 cho đơn hàng 01
   SELECT * FROM HoaDon;
   INSERT INTO HoaDon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
   VALUES(1, 1, current_timestamp(), 890);
-- 5. Cập nhật tất cả các mặt hàng thuộc loại hàng là 'Mũ' với giá bán là 199K
   UPDATE ChiTietMatHang
   SET GiaBan = 199
   WHERE MaMH IN (SELECT MaLH FROM LoaiHang WHERE TenLH LIKE 'Áo');
CREATE TABLE `SaoLuuDonHang` (
  `MaDH` int(11) NOT NULL,
  `DiaChiGiaoHang` text NOT NULL,
  `SDTNguoiNhan` varchar(255) NOT NULL,
  `ThoiGianDatHang` datetime NOT NULL,
  `PhiVanChuyen` double NOT NULL,
  `TongTien` double NOT NULL,
  `MaNV` int(11) NOT NULL,
  `MaKH` int(11) NOT NULL,
  `MaLHTT` int(11) NOT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SELECT * FROM DonHang;
SELECT * FROM SaoLuuDonHang;

INSERT INTO SaoLuuDonHang(MaDH, 
                          DiaChiGiaoHang, 
                          SDTNguoiNhan, 
                          ThoiGianDatHang, 
                          PhiVanChuyen,
                          TongTien, 
                          MaNV, 
                          MaKH, 
                          MaLHTT)
SELECT (
        MaDH, 
        DiaChiGiaoHang, 
        SDTNguoiNhan, 
        ThoiGianDatHang, 
        PhiVanChuyen, 
        TongTien,
        MaNV,
        MaKH,
        MaLHTT);
   
-- ==========================SELECT==============================
-- 1. Toàn bộ thông tin các loại hàng
    SELECT * FROM LoaiHang;
    -- Mặt hàng thuộc loại hàng là 'Thắt lưng'
    SELECT *
    FROM LoaiHang lh
    JOIN MatHang mh
    ON lh.MaLH = mh.MaLH
    WHERE lh.TenLH LIKE '%Thắt Lưng%';
    
    SELECT *
    FROM MatHang
    WHERE MaLH = (SELECT MaLH 
                  FROM loaihang
                  WHERE TenLH LIKE '%Thắt Lưng%');
    -- Top 5 mặt hàng có giá bán cao nhất
    SELECT mh.*,
		   ctmh.GiaBan
    FROM chitietmathang ctmh
    JOIN chitietmathang ON chitietmathang.MaMH = mathang.MaMH
    ORDER BY GiaBan DESC 
   LIMIT 0,5;
-- 2. Đơn hàng
	-- Được bán trong ngày 28/11/2019
    SELECT * FROM DonHang
   WHERE  date(ThoiGianDatHang) = '2019-11-28';
   
    -- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
      SELECT * FROM DonHang
   WHERE  CAST(ThoiGianDatHang AS DATE) BETWEEN '28/11/2019' AND '02/12/2019';
    -- Được bán trong tháng 11/2019
    SELECT * FROM DonHang
    WHERE MONTH(ThoiGianDatHang) = 11
    AND YEAR(ThoiGianDatHang) = 2019;
    
    -- Được giao hàng tại Hòa Khánh
    
    SELECT * FROM DonHang
    WHERE DiaChiGiaoHang LIKE 'Hòa Khánh';
-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân

 SELECT *, GiaBan *0.8 AS  GiaMoi
 FROM ChiTietMatHang;
-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
 SELECT mh.MaMH,
        ctmh.GiaBan,
        ctmh.GiaBan * 0.8 GiaBanKhuyenMai,
        curdate() NgayBan
 FROM MatHang mh
 JOIN ChiTietMatHang ctmh
 ON mh.MaMH = ctmh.MaMH
 WHERE curdate() = '2021-11-06';

-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
-- 14. Đếm số lượng các mặt hàng trong hệ thống
-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
   -- MaLoai  TenLoai SoLuong
   -- 1       Giày    20
   -- 2       Áo      28
   SELECT lh.MaLH,
          lh.TenLH,
          SUM(ctmh.SoLuong) SoLuongMatHang
         -- mh.TenMH,
		 -- ctmh.MaKC,
		 -- ctmh.SoLuong
         
   FROM loaihang lh
   JOIN MatHang mh
   ON lh.MaLH = mh.MaLH
   JOIN ChiTietMatHang ctmh
   ON mh.MaMH = ctmh.MaMH
   GROUP BY lh.MaLH;
   
   
-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
  WITH CTE_LoaiHang AS (
     SELECT lh.MaLH,
          lh.TenLH,
          MAX(ctmh.GiaBan) GiaBanCaoNhat
         
   FROM loaihang lh
   JOIN MatHang mh
   ON lh.MaLH = mh.MaLH
   JOIN ChiTietMatHang ctmh
   ON mh.MaMH= ctmh.MaMH
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
-- 20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
    -- Điều kiện tổng số lượng > 20 mặt hàng
 
 SELECT lh.MaLH,
		lh.TenLH,
          MAX(cte.SoLuongMatHang) SoLuongCaoNhat
   FROM loaihang lh
   JOIN MatHang mh
   ON lh.MaLH = mh.MaLH
   JOIN ChiTietMatHang ctmh
   ON mh.MaMH = ctmh.MaMH
   GROUP BY lh.MaLH
   HAVING SoLuongMatHang > 20;
-- ==============================================================
-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
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
SELECT * FROM mathang;
-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
SELECT lh.MaLH,
	   lh.TenLH
FROM LoaiHang lh
JOIN MatHang mh
ON lh.MaLH = mh.MaLH
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
GROUP BY mh.MaLH
ORDER BY SoLuong DESC
LIMIT 3;

-- 24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100
-- 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11
-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
select * from MatHang mh 
Join loaihang lh 
On mh.maLH = lh.MaLH
where lh.TenLH = "Mũ" 
            and MaMH not in (
            select MaMH from donhang dh Join chitietdonhang ctdh On dh.maDH = ctdh.maDH
			where dh.ThoiGianDatHang LIKE "2020-02-14%"
            );
-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
UPDATE ChiTietMatHang
   SET GiaBan = 199
   WHERE MaMH IN (SELECT MaLH FROM LoaiHang WHERE TenLH = 'Áo');
-- 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)
   -- Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
-- 29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11
SELECT mh.MaMH,
       mh.TenMH,
       SUM(ctmh.SoLuong) SoLuong
FROM MatHang mh
JOIN ChiTietMatHang ctmh
ON mh.MaMH = ctmh.MaMH
WHERE mh.MaLH IN (SELECT MaLH FROM loaihang 
				  WHERE TenLH IN('Áo','Quần'))
GROUP BY mh.MaMH
ORDER BY SoLuong DESC
LIMIT 2;
-- 31. Tính tổng tiền cho đơn hàng 02

   -- Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
-- 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
   -- SoDH ChiTietDonHang           TongTien
   -- 02   TenMH:GiaBan:SoLuong     100
   
   SELECT dh.MaDH,
   GROUP_CONCAT(concat(mh.TenMH, ':',ctmh.MaKC,':',ctmh.GiaBan,':',ctdh.SoLuong) SEPARATOR '-') ThongTinDonHang,
   dh.PhiVanChuyen,
   SUM(ctdh.SoLuong * ctmh.GiaBan) + dh.PhiVanChuyen TongTien
   FROM ChiTietMatHang ctmh
   JOIN MatHang mh
   ON ctmh.MaMH = mh.MaMH
   JOIN ChiTietDonHang ctdh
   ON ctmh.MaMH = ctdh.MaMH
   JOIN DonHang dh
   ON dh.MaDH = ctdh.MaDH
 GROUP BY dh.MaDH;
 SELECT * FROM donhang;