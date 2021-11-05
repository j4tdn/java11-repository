SET FOREIGN_KEY_CHECKS = 0;

-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
DELETE FROM nhanvien 
WHERE TENNV = "Văn Hoàng";

-- 2. Xóa bộ phận giao hàng trong hệ thống
DELETE FROM chucvu
WHERE TENCV = "Nhân viên giao hàng";

-- 3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ
DELETE FROM mathang 
Where MaLH = (SELECT MaLH
				FROM LoaiHang
                Where TenLH = "Mũ");

-- 4. Xóa tất cả các mặt hàng trong hệ thống
TRUNCATE mathang;

-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 18/12/2020
  --  Thực hiện xóa các đơn hàng bị lỗi
DELETE FROM donhang
Where  CAST(ThoiGianDatHang AS DATE ) = "2020-12-18";


	-- UPDATE -- 
 -- 1. Cập nhật tên mới cho phòng ban có MaPB = 2 thành 'Bộ phận quản lý'
Update ChucVu
SET TenCV = "Bộ phận quản lý"
Where MaCV = 2;
 
 -- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'
 ALTER TABLE DonHang ADD GhiChu TEXT;
 
 UPDATE DonHang
 SET GhiChu = 'Giao Hàng sau 10h sáng'
 WHERE MaDH = 1;
 -- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật
 INSERT INTO ChiTietTinhTrangDonHang(MaDH, MaTT, MaNV, ThoiGian)
 VALUES (1, 5, 2, '2020-10-30 20:20:40');
  -- MaTT = 03, TrangThai = 'Đã giao', ThoiGian = Thời gian hiện tại
 -- 4. Cập nhật số tiền cần thanh toán trong bảng hóa đơn thành 890 cho đơn hàng 01
 INSERT INTO HoaDon(MaHD, MaDH, NgayXuatHoaDon, SoTienCanThanhToan)
 VALUES(1, 1, current_timestamp(), 890);
 
 -- 5. Cập nhật tất cả các mặt hàng thuộc loại hàng là 'Mũ' với giá bán là 199K
 UPDATE ChiTietMatHang
 SET GiaBan = 199 
 WHERE MaMH IN (SELECT MaMH
				FROM MatHang
				WHERE MaLH = 
                (SELECT MaLH FROM LoaiHang WHERE TenLH LIKE 'Áo'));
 
-- 6. BACKUP : Tạo bảng  SaoLuuDonHang.Copy toàn dữ liệu từ bảng Đơn Hàng 
CREATE TABLE IF NOT EXISTS SaoLuuDonHang (
  `MaDH` INT NOT NULL,
  `DiaChiGiaoHang` TEXT NOT NULL,
  `SDTNguoiNhan` VARCHAR(255) NOT NULL,
  `ThoiGianDatHang` DATETIME NOT NULL,
  `PhiVanChuyen` DOUBLE NOT NULL,
  `TongTien` DOUBLE NOT NULL,
  `MaNV` INT NOT NULL,
  `MaKH` INT NOT NULL,
  `MaLHTT` INT NOT NULL,
  PRIMARY KEY (`MaDH`),
  INDEX `fk_DonHang_NhanVien1_idx` (`MaNV` ASC) VISIBLE,
  INDEX `fk_DonHang_KhachHang1_idx` (`MaKH` ASC) VISIBLE,
  INDEX `fk_DonHang_LoaiHinhThanhToan1_idx` (`MaLHTT` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_NhanVien2`
    FOREIGN KEY (`MaNV`)
    REFERENCES `java11_shopping`.`NhanVien` (`MaNV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_KhachHang2`
    FOREIGN KEY (`MaKH`)
    REFERENCES `java11_shopping`.`KhachHang` (`MaKH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_LoaiHinhThanhToan2`
    FOREIGN KEY (`MaLHTT`)
    REFERENCES `java11_shopping`.`LoaiHinhThanhToan` (`MaLHTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB; 

-- copy data 
INSERT INTO SaoLuuDonHang(MaDH,DiaChiGiaoHang,SDTNguoiNhan,ThoiGianDatHang,PhiVanChuyen,TongTien,MaNV,MaKH,MaLHTT)
SELECT MaDH,DiaChiGiaoHang,SDTNguoiNhan,ThoiGianDatHang,PhiVanChuyen,TongTien,MaNV,MaKH,MaLHTT FROM DonHang;


-- 1. Toàn bộ thông tin các loại hàng
    -- Mặt hàng thuộc loại hàng là 'Thắt lưng'
    -- Top 5 mặt hàng có giá bán cao nhất
SELECT *
FROM loaihang;

SELECT * 
FROM mathang
JOIN loaihang ON mathang.MaLH = loaihang.MaLH
WHERE TenLH = "Thắt lưng"; 

SELECT *
FROM mathang
ORDER BY mathang.GiaBan DESC
LIMIT 5;
    
-- 2. Đơn hàng
	-- Được bán trong ngày 28/11/2019
    -- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
    -- Được bán trong tháng 11/2019
    -- Được giao hàng tại Hòa Khánh
    
   SELECT * FROM donhang;  
   
   SELECT * 
  FROM donhang
  WHERE CAST(NgayTao AS DATE) = "2020-12-18";
  
  
  SELECT * 
  FROM donhang
  WHERE CAST(NgayTao AS DATE) >= "2020-12-17" and CAST(NgayTao AS DATE) <= "2020-12-18";
  
  SELECT * 
  FROM donhang
  WHERE MONTH(NgayTao) = 12 and YEAR(NgayTao) = 2020;
   
   SELECT * 
  FROM donhang
  WHERE DiaChiGiaoHang LIKE '%Hòa Khánh%'; 
   
    
-- 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân

SELECT mathang.MaMH, TenMH, (GiaBan * 0.8) GiaKhuyenMai
 FROM mathang
 JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH;
-- 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
SELECT mathang.MaMH, TenMH, (GiaBan * 0.8) GiaKhuyenMai
 FROM donhang
 JOIN chitietdonhang ON donhang.MaDH = chitietdonhang.MaDH
 JOIN mathang ON chitietdonhang.MaMH = mathang.MaMH
 JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
 WHERE cast(ThoiGianDatHang AS DATE) = "2020-12-17";

-- 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
SELECT MauSac
FROM mathang
GROUP BY MauSac;

-- 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
SELECT mathang.MaMH, mathang.TenMH, donhang.ThoiGianDatHang
FROM  mathang
JOIN chitietdonhang ON mathang.MaMH = chitietdonhang.MaMH
JOIN donhang ON chitietdonhang.MaDH = donhang.MaDH
WHERE CAST(ThoiGianDatHang AS DATE) = "2019-11-23";

-- 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
SELECT * 
FROM mathang
JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
Where GiaBan >= 100 AND GiaBan <= 300;

-- 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
SELECT * 
FROM mathang
JOIN loaihang ON mathang.MaLH = loaihang.MaLH
Where loaihang.TenLH LIKE "Mũ%" OR loaihang.TenLH LIKE "Thắt lưng%";

-- 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
SELECT * 
FROM donhang
WHERE CAST(ThoiGianDatHang AS DATE) = "2019-11-28" OR  CAST(ThoiGianDatHang AS DATE) = "2019-12-14";


-- 11. Sắp xếp các mặt hàng với giá bán tăng dần
SELECT mathang.MaMH, mathang.TenMH, chitietmathang.GiaBan 
FROM mathang
JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
ORDER BY chitietmathang.GiaBan ASC;

-- 12. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT mathang.MaMH, mathang.TenMH, chitietmathang.GiaMua 
FROM mathang
JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
ORDER BY chitietmathang.GiaBan DESC;

-- 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
SELECT mathang.MaMH, mathang.TenMH, chitietmathang.GiaBan 
FROM mathang
JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
ORDER BY chitietmathang.GiaBan ASC;

SELECT mathang.MaMH, mathang.TenMH, chitietmathang.GiaMua 
FROM mathang
JOIN chitietmathang ON mathang.MaMH = chitietmathang.MaMH
ORDER BY chitietmathang.GiaBan DESC;

-- 14. Đếm số lượng các mặt hàng trong hệ thống
SELECT COUNT(mathang.TenMH) AS SoLuongMatHang 
FROM mathang;


-- 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
SELECT COUNT(mathang.MaMH)
FROM mathang
JOIN chitietdonhang ON mathang.MaMH = chitietdonhang.MaMH
JOIN donhang ON donhang.MaDH = chitietdonhang.MaDH
WHERE CAST(ThoiGianDatHang AS DATE) = "2019-11-23" AND mathang.TenMH = "Giày da Nam" ;

-- 16. Đếm số lượng các mặt hàng theo từng loại hàng
  --  MaLoai  TenLoai SoLuong
  -- 1       Giày    20
  -- 2       Áo      28
  
  SELECT mathang.MaLH, loaihang.TenLH, COUNT(mathang.MaLH) AS SoLuong
  FROM mathang
  JOIN loaihang ON mathang.MaLH = loaihang.MaLH
  GROUP BY mathang.MaLH;
  
-- 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT *
FROM mathang
JOIN chitietmathang ON  mathang.MaMH = chitietmathang.MaMH
ORDER BY chitietmathang.GiaBan DESC
LIMIT 1;

-- 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
SELECT mathang.MaMH, mathang.TenMH, mathang.MaLH, chitietmathang.GiaBan
FROM mathang
JOIN chitietmathang ON  mathang.MaMH = chitietmathang.MaMH
GROUP BY mathang.MaLH
ORDER BY chitietmathang.GiaBan DESC;


-- 19. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
	SELECT TenMH AS TenMatHang, SUM(ChiTietMatHang.SoLuong) AS SoLuong FROM MatHang 
   JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
   GROUP BY ChiTietMatHang.MaMH;


-- --20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
   -- Điều kiện tổng số lượng > 20 mặt hàng
 SELECT TenMH AS TenMatHang, SUM(ChiTietMatHang.SoLuong) AS SoLuong FROM MatHang 
    JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
    GROUP BY ChiTietMatHang.MaMH
	HAVING SoLuong > 30;


-- 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
   SELECT TenLH, TenMH;
-- 22. Hiển thị giá bán trung bình của mỗi loại hàng
   SELECT TenLH, SUM(ChiTietMatHang.GiaBan)/COUNT(ChiTietMatHang.MaMH) AS GiaBanTB FROM LoaiHang
   JOIN MatHang ON LoaiHang.MaLH = MatHang.MaLH
   JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
   GROUP BY TenLH;
   
-- 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
   SELECT MatHang.MaLH AS MaLoai, TenLH AS TenLoai, SUM(ChiTietMatHang.SoLuong) AS SoLuong FROM MatHang 
   JOIN LoaiHang ON MatHang.MaLH = LoaiHang.MaLH
   JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH
   GROUP BY MatHang.MaLH
   ORDER BY SoLuong DESC
   LIMIT 0,3;
   
-- 24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100
  SELECT * FROM MatHang
  JOIN ChiTietDonHang ON MatHang.MaMH = ChiTietDonHang.MaMH
  WHERE MaLH = 2 AND ChiTietDonHang.MaDH = 1;
  
-- 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11
  SELECT * FROM MatHang
  JOIN ChiTietDonHang ON MatHang.MaMH = ChiTietDonHang.MaMH
  JOIN DonHang ON DonHang.MaDH = ChiTietDonHang.MaDH
  WHERE MaLH = 2 AND date_format(ThoiGianDatHang, '%d/%m') = '18/12';

-- 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
  SELECT * FROM MatHang 
  JOIN LoaiHang ON LoaiHang.MaLH = MatHang.MaLH 
  WHERE LoaiHang.TenLH = 'Mũ' AND CAST(ThoiGianDatHang AS DATE) = '14/02/2019';
 
-- 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
   UPDATE ChiTietMatHang
   SET GiaBan = 199
   WHERE MaMH IN (SELECT MaLH FROM  LoaiHang WHERE TenLH LIKE 'Áo');
   
-- 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)

CREATE TABLE LoaiHang_BACKUP(
	MaLH int,
    TenLH VARCHAR(255)
   )ENGINE=InnoDB DEFAULT CHARSET=utf8;
   -- Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
   INSERT INTO LoaiHang_BACKUP(MaLH, TenLH)
   SELECT MaLH, TenLH FROM LoaiHang;
    
-- 29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11
   SELECT * FROM MatHang 
   JOIN ChiTietDonHang ON MatHang.MaMH = ChiTietDonHang.MaMH
   JOIN DonHang ON DonHang.MaDH = ChiTietDonHang.MaDH
   WHERE MaLH = 2 AND DATE_FORMAT(ThoiGianDatHang, '%d/%m') = '18/12';
   
-- 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'
   SELECT TenLH, TenMH;
-- 31. Tính tổng tiền cho đơn hàng 02
   SELECT DonHang.MaDH, SUM(ChiTietMatHang.GiaBan * ChiTietDonHang.SoLuong) AS TongTien FROM DonHang
   JOIN ChiTietDonHang ON ChiTietDonHang.MaDH = DonHang.MaDH
   JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = ChiTietDonHang.MaMH
   GROUP BY DonHang.MaDH;
   -- Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
     
-- 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
   -- SoDH ChiTietDonHang           TongTien
   -- 02   TenMH:GiaBan:SoLuong     100
   
   SELECT HoaDon.MaDH AS SoDH, 
	   CONCAT(MatHang.TenMH, ':' , ChiTietMatHang.GiaBan, ':', ChiTietDonHang.SoLuong) AS ChiTietDonHang, 
       (ChiTietMatHang.GiaBan * ChiTietDonHang.SoLuong) AS TongTien
   FROM HoaDon
   JOIN ChiTietDonHang ON ChiTietDonHang.MaDH = HoaDon.MaDH
   JOIN MatHang ON ChiTietDonHang.MaMH = MatHang.MaMH
   JOIN ChiTietMatHang ON ChiTietMatHang.MaMH = MatHang.MaMH


