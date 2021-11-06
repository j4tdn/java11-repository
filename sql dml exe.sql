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

