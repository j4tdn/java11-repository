SET FOREIGN_KEY_CHECKS = 0;
SET FOREIGN_KEY_CHECKS = 1;

-- B. DELETE
-- 1. Xóa nhân viên có tên 'Văn Hoàng' trong hệ thống
DELETE
FROM NHANVIEN
WHERE TENNV LIKE '%Hoàng%';
-- = equals
-- LIKE
-- xyz% startsWith
-- %xyz endsWith
-- %xyz% contains

-- 2. Xóa bộ phận giao hàng trong hệ thống
SELECT *
FROM CHUCVU;
DELETE
FROM CHUCVU
WHERE TENCV LIKE 'Nhán viên giao hàng';

-- 3. Xóa tất cả các mặt hàng thuộc loại hàng là mũ
-- SUB QUERY
SELECT MALH
FROM LOAIHANG
WHERE TENLH = 'Mũ';

DELETE
FROM MATHANG
WHERE MALH = (SELECT MALH
              FROM LOAIHANG
              WHERE TENLH = 'Mũ');
-- 4. Xóa tất cả các mặt hàng trong hệ thống
DELETE
FROM MATHANG;

-- 5. Vì hệ thống bị lỗi. Hủy tất cả các đơn hàng ngày 18/12/2020
--    Thực hiện xóa các đơn hàng bị lỗi
-- ThoiGianDatHang = 'VARCHAR'
-- ThoiGianDatHang LIKE '2020-12-18%'
-- CAST(ThoiGianDatHang AS DATE) = STR_TO_DATE('17-12-2020', '%d-%m-%Y')
-- LOOSED, DYNAMIC TYPE

SELECT *
FROM DONHANG;
DELETE
FROM DONHANG
WHERE CAST(THOIGIANDATHANG AS DATE) = "2020-12-18%";


-- C. UPDATE
-- 1. Cập nhật tên mới cho phòng ban có MaPB = 2 thành 'Bộ phận quản lý'
UPDATE CHUCVU
SET TENCV = 'Bộ phận quản lý'
WHERE MACV = 2;

-- 2. Cập nhật ghi chú của đơn hàng 01 thành 'Giao hàng sau 10H sáng'
ALTER TABLE DONHANG
    ADD GHICHU TEXT;
SELECT *
FROM DONHANG;
UPDATE DONHANG
SET GHICHU = 'Giao hàng sau 10H sáng'
WHERE MADH = 1;

-- 3. Đơn hàng 01 đã được giao hàng thành công. Thực hiện cập nhật
--    MaTT = 03, TrangThai = 'Đã giao', ThoiGian = Thời gian hiện tại
SELECT *
FROM DONHANG
WHERE MADH = 1;
SELECT *
FROM TINHTRANGDONHANG;
SELECT *
FROM CHITIETTINHTRANGDONHANG;

INSERT INTO CHITIETTINHTRANGDONHANG(MADH, MATT, MANV, THOIGIAN)
VALUES (1, 5, 2, '2020-12-16 20:20:40');

-- 4. Cập nhật số tiền cần thanh toán trong bảng hóa đơn thành 890 cho đơn hàng 01
SELECT *
FROM HOADON;
INSERT INTO HOADON(MAHD, MADH, NGAYXUATHOADON, SOTIENCANTHANHTOAN)
VALUES (1, 1, CURRENT_TIMESTAMP(), 890);

-- 5. Cập nhật tất cả các mặt hàng thuộc loại hàng là 'Mũ' với giá bán là 199K
SELECT *
FROM MATHANG;
SELECT *
FROM CHITIETMATHANG;
UPDATE CHITIETMATHANG
SET GIABAN = 199
WHERE MAMH IN (SELECT MAMH
               FROM MATHANG
               WHERE MALH = (SELECT MALH
                             FROM LOAIHANG
                             WHERE TENLH LIKE 'Áo'));

-- 6. Tạo 1 bảng SaoLuuDonHang. Copy toàn bộ dữ liệu từ bàng DonHang bỏ vào SaoLuuDonHang
-- Cấu trúc 2 bảng giống nhau

CREATE TABLE `SaoLuuDonHang`
(
    `MaDH`            INT(11)      NOT NULL,
    `DiaChiGiaoHang`  TEXT         NOT NULL,
    `SDTNguoiNhan`    VARCHAR(255) NOT NULL,
    `ThoiGianDatHang` DATETIME     NOT NULL,
    `PhiVanChuyen`    DOUBLE       NOT NULL,
    `TongTien`        DOUBLE       NOT NULL,
    `MaNV`            INT(11)      NOT NULL,
    `MaKH`            INT(11)      NOT NULL,
    `MaLHTT`          INT(11)      NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;

SELECT *
FROM DONHANG;
SELECT *
FROM SAOLUUDONHANG;

-- copy data
INSERT INTO SAOLUUDONHANG(MADH, DIACHIGIAOHANG, SDTNGUOINHAN, THOIGIANDATHANG, PHIVANCHUYEN, TONGTIEN, MANV, MAKH,
                          MALHTT)
SELECT MADH,
       DIACHIGIAOHANG,
       SDTNGUOINHAN,
       THOIGIANDATHANG,
       PHIVANCHUYEN,
       TONGTIEN,
       MANV,
       MAKH,
       MALHTT
FROM DONHANG;

# ======================= REFRESH DATA =======================
# D. SELECT - SLIDE 25-44
# 1. Toàn bộ thông tin các loại hàng
#     -- Mặt hàng thuộc loại hàng là 'Thắt lưng'

SELECT *
FROM MATHANG
WHERE MALH = (SELECT MALH FROM LOAIHANG WHERE TENLH LIKE '%Thắt lưng%');

#     -- Top 5 mặt hàng có giá bán cao nhất
SELECT MH.*,
       CT.GIABAN
FROM MATHANG MH
JOIN CHITIETMATHANG CT
     ON MH.MAMH = CT.MAMH
ORDER BY CT.GIABAN
LIMIT 5;

# 2. Đơn hàng
# 	-- Được bán trong ngày 28/11/2019
SELECT *
FROM DONHANG
WHERE CAST(THOIGIANDATHANG AS DATE) = '2019-11-28';

#     -- Được bán từ ngày 28/11/2019 đến ngày 02/12/2019
SELECT *
FROM DONHANG
WHERE CAST(THOIGIANDATHANG AS DATE) BETWEEN '2019-11-28' AND '2019-12-02';

#     -- Được bán trong tháng 11/2019
SELECT *
FROM DONHANG
WHERE CAST(THOIGIANDATHANG AS DATE) BETWEEN '2019-11-1' AND '2019-11-30';

#     -- Được giao hàng tại Hòa Khánh
SELECT *
FROM DONHANG
WHERE CAST(THOIGIANDATHANG AS DATE) LIKE '%Hoà Khánh%';


# 3. Giá của toàn bộ các mặt hàng sau khi được khuyến mãi 20%, làm tròn 2 chữ số thập phân
SELECT *,
       ROUND(GIABAN * 0.8, 2) GIABANSAUKHUYENMAI
FROM CHITIETMATHANG;

# 4. Giảm giá 20% tất cả các mặt hàng trong ngày 25/11/2019
SELECT MH.*,
       ROUND(CTMH.GIABAN * 0.8, 2) GIABANKHUYENMAI,
       DH.THOIGIANDATHANG
FROM MATHANG MH
JOIN CHITIETMATHANG CTMH
     ON MH.MAMH = CTMH.MAMH
JOIN CHITIETDONHANG CTDH
     ON MH.MAMH = CTDH.MAMH
JOIN DONHANG DH
     ON CTDH.MADH = DH.MADH
WHERE CAST(DH.THOIGIANDATHANG AS DATE) = '2019-11-25';

# 5. Liệt kê tất cả các màu sắc của sản phẩm có bán trong cửa hàng.
SELECT DISTINCT MAUSAC
FROM MATHANG;

# 7. Liệt kê tất cả các mặt hàng (MaMH, TenMH, ThoiGianDatHang) được bán trong ngày 23/11/2019
SELECT MH.*
FROM MATHANG MH
JOIN CHITIETDONHANG CTDH
     ON MH.MAMH = CTDH.MAMH
JOIN DONHANG DH
     ON CTDH.MADH = DH.MADH
WHERE CAST(DH.THOIGIANDATHANG AS DATE) = '2019-11-23';

# 8. Liệt kê các mặt hàng có giá bán từ 100 - 300
SELECT *
FROM MATHANG
WHERE MAMH IN (SELECT MAMH
               FROM CHITIETMATHANG
               WHERE GIABAN BETWEEN 100 AND 300);

# 9. Liệt kê tất cả các mặt hàng thuộc loại hàng là 'Mũ' và 'Thắt lưng'
SELECT *
FROM MATHANG
WHERE MALH IN (SELECT MALH
               FROM LOAIHANG
               WHERE TENLH IN ('Mũ', 'Thắt Lưng'));

# 10. Liệt kê các đơn hàng được đặt trong ngày (28/11/2019, 14/12/2019)
SELECT *
FROM DONHANG
WHERE CAST(THOIGIANDATHANG AS DATE) IN ('2019-11-28', '2019-12-14');

# ==============================================================
# 11. Sắp xếp các mặt hàng với giá bán tăng dần
SELECT *
FROM CHITIETMATHANG
ORDER BY GIABAN;

# 12. Sắp xếp các mặt hàng với giá mua giảm dần
SELECT *
FROM CHITIETMATHANG
ORDER BY GIAMUA DESC;


# 13. Sắp xếp các mặt hàng với giá bán tăng dần, giá mua giảm dần
SELECT *
FROM CHITIETMATHANG
ORDER BY GIABAN, GIAMUA DESC;

# 14. Đếm số lượng các mặt hàng trong hệ thống
SELECT COUNT(*) SOLUONGMATHANG
FROM MATHANG;

# 15. Số lượng 'Giày da Nam' được bán trong ngày 23/11/2019
SELECT SUM(SOLUONG)
FROM CHITIETDONHANG CTDH
JOIN MATHANG MH
     ON CTDH.MAMH = MH.MAMH
JOIN DONHANG DH
     ON CTDH.MADH = DH.MADH
WHERE CAST(DH.THOIGIANDATHANG AS DATE) = '2019-11-23';

# 16. Đếm số lượng các mặt hàng theo từng loại hàng
#     MaLoai  TenLoai SoLuong
# 	1       Giày    20
# 	2       Áo      28
SELECT LH.MALH,
       LH.TENLH,
       SUM(CTMH.SOLUONG) SOLUONGMATHANG
FROM LOAIHANG LH
JOIN MATHANG MH
     ON LH.MALH = MH.MALH
JOIN CHITIETMATHANG CTMH
     ON CTMH.MAMH = MH.MAMH
GROUP BY MH.MALH;

# 17. Tìm mặt hàng có giá bán cao nhất trong loại hàng 'Giày'
SELECT MH.*, CTMH.MAKC, CTMH.GIABAN
FROM MATHANG MH
JOIN LOAIHANG LH
     ON MH.MALH = LH.MALH
JOIN CHITIETMATHANG CTMH
     ON MH.MAMH = CTMH.MAMH
WHERE LH.TENLH = 'Giày dép'
ORDER BY CTMH.GIABAN
LIMIT 1;

# 18. Tìm mặt hàng có giá bán cao nhất của mỗi loại hàng
-- CTE: COMMON TABLE EXPRESSION
WITH CTE_LOAIHANG AS (
    SELECT LH.MALH,
           LH.TENLH,
           MAX(CTMH.GIABAN) GIABANCAONHAT
    FROM LOAIHANG LH
    JOIN MATHANG MH
         ON LH.MALH = MH.MALH
    JOIN CHITIETMATHANG CTMH
         ON MH.MAMH = CTMH.MAMH
    GROUP BY LH.MALH
)
SELECT LH.MALH,
       LH.TENLH,
       MH.MAMH,
       MH.TENMH,
       CTMH.GIABAN,
       CTMH.MAKC,
       LH.GIABANCAONHAT
FROM CTE_LOAIHANG LH
JOIN MATHANG MH
     ON MH.MALH = LH.MALH
JOIN CHITIETMATHANG CTMH
     ON MH.MAMH = CTMH.MAMH
WHERE CTMH.GIABAN = LH.GIABANCAONHAT;

# 19. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
SELECT MH.*,
       SUM(CTMH.SOLUONG) TONGSOLUONG
FROM MATHANG MH
JOIN CHITIETMATHANG CTMH
     ON MH.MAMH = CTMH.MAMH
GROUP BY MAMH;

# 20. Hiển thị tổng số lượng mặt hàng của mỗi loại hàng trong hệ thống
#     Điều kiện tổng số lượng > 20 mặt hàng
SELECT MH.*,
       SUM(CTMH.SOLUONG) TONGSOLUONG
FROM MATHANG MH
JOIN CHITIETMATHANG CTMH
     ON MH.MAMH = CTMH.MAMH
GROUP BY MAMH
HAVING TONGSOLUONG > 20;

# ==============================================================
# 21. Hiển thị mặt hàng có số lượng nhiều nhất trong mỗi loại hàng
WITH CTE_MATHANG AS (
    -- Số lượng mặt hàng lớn nhất của mỗi mặt hàng
    SELECT MH.MAMH,
           MH.TENMH,
           SUM(CTMH.SOLUONG) SOLUONGMATHANG
    FROM MATHANG MH
    JOIN CHITIETMATHANG CTMH
         ON MH.MAMH = CTMH.MAMH
    GROUP BY MH.MAMH
),
     CTE_LOAIHANG AS (
         -- Số lượng mặt hàng lớn nhất của mỗi loại hàng
         SELECT MH.MALH,
                MAX(CTE.SOLUONGMATHANG) SOLUONGCAONHAT
         FROM MATHANG MH
         JOIN CTE_MATHANG CTE
              ON MH.MAMH = CTE.MAMH
         GROUP BY MH.MALH
     )
SELECT *
FROM CTE_MATHANG CTEMH
JOIN MATHANG MH
     ON CTEMH.MAMH = MH.MAMH
JOIN CTE_LOAIHANG CTELH
     ON MH.MALH = CTELH.MALH
WHERE CTEMH.SOLUONGMATHANG = CTELH.SOLUONGCAONHAT;


# 22. Hiển thị giá bán trung bình của mỗi loại hàng
SELECT LH.MALH, AVG(CTMH.GIABAN) GIABANTRUNGBINH
FROM MATHANG MH
JOIN LOAIHANG LH
     ON MH.MALH = LH.MALH
JOIN CHITIETMATHANG CTMH
     ON MH.MAMH = CTMH.MAMH
GROUP BY LH.MALH;

# 23. In ra 3 loại hàng có số lượng hàng còn lại nhiều nhất ở thời điểm hiện tại
SELECT LH.MALH,
       SUM(CTMH.SOLUONG) SOLUONGCONLAI
FROM MATHANG MH
JOIN LOAIHANG LH
     ON MH.MALH = LH.MALH
JOIN CHITIETMATHANG CTMH
     ON MH.MAMH = CTMH.MAMH
GROUP BY LH.MALH
ORDER BY SOLUONGCONLAI DESC
LIMIT 3;

# 24. Liệt kê những mặt hàng có MaLoai = 2 và thuộc đơn hàng 100100
SELECT MH.*, LH.MALH, CTDH.MADH
FROM LOAIHANG LH
JOIN MATHANG MH
     ON LH.MALH = MH.MALH
JOIN CHITIETDONHANG CTDH
     ON CTDH.MAMH = MH.MAMH
WHERE LH.MALH = 2
  AND CTDH.MADH = 100100;

# 25. Tìm những mặt hàng có Mã Loại = 2 và đã được bán trong ngày 28/11
SELECT MH.*,
       DH.THOIGIANDATHANG
FROM MATHANG MH
JOIN CHITIETDONHANG CTDH
     ON MH.MAMH = CTDH.MAMH
JOIN DONHANG DH
     ON DH.MADH = CTDH.MADH
WHERE MH.MALH = 2
  AND CAST(DH.THOIGIANDATHANG AS DATE) LIKE '%11-28';

# 26. Liệt kê những mặt hàng là 'Mũ' không bán được trong ngày 14/02/2019
SELECT MH.*,
       DH.THOIGIANDATHANG
FROM MATHANG MH
JOIN CHITIETDONHANG CTDH
     ON MH.MAMH = CTDH.MAMH
JOIN DONHANG DH
     ON CTDH.MADH = DH.MADH
WHERE MH.TENMH LIKE '%Mũ%'
  AND CAST(DH.THOIGIANDATHANG AS DATE) <> '2019-02-14';

# 27. Cập nhật giá bán của tất cả các mặt hàng thuộc loại hàng 'Áo' thành 199
UPDATE CHITIETMATHANG
SET GIABAN = 199
WHERE MAMH IN (SELECT MAMH
               FROM MATHANG
               WHERE MALH = (SELECT MALH
                             FROM LOAIHANG
                             WHERE TENLH LIKE 'Áo'));

# 28. Backup data. Tạo table LoaiHang_BACKUP(MaLoai, TenLoai)
#     Sao chép dữ liệu từ bảng LoaiHang sang LoaiHang_BACKUP
CREATE TABLE LOAIHANG_BACKUP
(
    MALH  INT,
    TENLH VARCHAR(255)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;

INSERT INTO LOAIHANG_BACKUP(MALH, TENLH)
SELECT MALH, TENLH
FROM LOAIHANG;

# 29. Tìm những mặt hàng có Mã Loại = 2 (T-Shirt) và đã được bán trong ngày 23/11
SELECT MH.*, DH.THOIGIANDATHANG
FROM MATHANG MH
JOIN CHITIETDONHANG CTDH
     ON MH.MAMH = CTDH.MAMH
JOIN DONHANG DH
     ON DH.MADH = CTDH.MADH
WHERE MH.MALH = 2
  AND CAST(DH.THOIGIANDATHANG AS DATE) LIKE '%11-23';

# 30. Liệt kê 2 sản phẩm (có số lượng tồn kho nhiều nhất) của loại hàng 'Áo' và 'Quần'
SELECT mh.MAMH,
       MH.TENMH,
       sum(CTMH.SOLUONG) SOLUONG
FROM MATHANG MH
JOIN CHITIETMATHANG CTMH
     ON MH.MAMH = CTMH.MAMH
WHERE MH.MALH IN (SELECT MALH
                  FROM LOAIHANG
                  WHERE TENLH IN ('Áo', 'Quần'))
GROUP BY MH.MAMH
ORDER BY SOLUONG DESC
LIMIT 2;

# 31. Tính tổng tiền cho đơn hàng 02
#     Với tổng tiền được tính bằng tổng các sản phẩm và số lượng của sản phẩm tương ứng
SELECT SUM(CTDH.SOLUONG * CTMH.GIABAN) TONGTIEN
FROM CHITIETDONHANG CTDH
JOIN CHITIETMATHANG CTMH
     ON CTDH.MAMH = CTMH.MAMH
WHERE CTDH.MADH = 2;

# 32. Xuất thông tin hóa đơn của đơn hàng 02 với thông tin như sau.
# 	SoDH ChiTietDonHang           TongTien
#     02   TenMH:GiaBan:SoLuong     100
SELECT CTDH.MADH,
       CONCAT(MH.TENMH, ':', CTMH.GIABAN, ':', CTMH.MAKC, ':', CTDH.SOLUONG) CHITIETDONHANG,
       (CTDH.SOLUONG * CTMH.GIABAN)                                          TONGTIEN
FROM CHITIETDONHANG CTDH
JOIN CHITIETMATHANG CTMH
     ON CTDH.MAMH = CTMH.MAMH
JOIN MATHANG MH
     ON CTMH.MAMH = MH.MAMH
WHERE CTDH.MADH = 2;

