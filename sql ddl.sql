CREATE SCHEMA `java11_shopping_manually`;

CREATE TABLE `MatHang`
(
    `MaMH`   INT          NOT NULL,
    `TenMH`  VARCHAR(255) NOT NULL,
    `MauSac` VARCHAR(255) NOT NULL,
    `MaLH`   INT          NOT NULL,
    CONSTRAINT PRIMARY KEY (`MaMH`),
    CONSTRAINT `fk_MatHang_LoaiHang1` FOREIGN KEY (`MaLH`) REFERENCES `LoaiHang` (`MaLH`)
);

CREATE TABLE `LoaiHang`
(
    `MaLH`  INT          NOT NULL,
    `TenLH` VARCHAR(255) NOT NULL,
    CONSTRAINT PRIMARY KEY (`MaLH`)
);

ALTER TABLE `LoaiHang`
    ADD `NgayTao` DATE;
ALTER TABLE `LoaiHang`
    CHANGE `NgayTao` `DATE_CREATED` DATE;

CREATE TABLE `DonHang`
(
    `MaDH`            INT          NOT NULL,
    `DiaChiGiaoHang`  TEXT         NOT NULL,
    `SDTNguoiNhan`    VARCHAR(255) NOT NULL,
    `ThoiGianDatHang` DATETIME     NOT NULL,
    `PhiVanChuyen`    DOUBLE       NOT NULL,
    `TongTien`        DOUBLE       NOT NULL,
    `MaNV`            INT          NOT NULL,
    `MaKH`            INT          NOT NULL,
    `MaLHTT`          INT          NOT NULL
)