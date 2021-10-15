-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema java11_shopping
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `java11_shopping` ;

-- -----------------------------------------------------
-- Schema java11_shopping
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `java11_shopping` DEFAULT CHARACTER SET utf8 ;
USE `java11_shopping` ;

-- -----------------------------------------------------
-- Table `java11_shopping`.`KichCo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`KichCo` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`KichCo` (
  `MaKC` VARCHAR(10) NOT NULL,
  `MoTa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaKC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`LoaiHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`LoaiHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`LoaiHang` (
  `MaLoaiHang` INT NOT NULL,
  `TenLoaiHang` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLoaiHang`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`MatHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`MatHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`MatHang` (
  `MaMH` INT NOT NULL,
  `TenMatHang` VARCHAR(255) NOT NULL,
  `MauSac` VARCHAR(255) NOT NULL,
  `MaLoaiHang` INT NOT NULL,
  PRIMARY KEY (`MaMH`),
  INDEX `fk_MatHang_LoaiHang1_idx` (`MaLoaiHang` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_LoaiHang1`
    FOREIGN KEY (`MaLoaiHang`)
    REFERENCES `java11_shopping`.`LoaiHang` (`MaLoaiHang`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`ChiTietMatHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`ChiTietMatHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`ChiTietMatHang` (
  `MatHang_MaMH` INT NOT NULL,
  `KichCo_MaKC` VARCHAR(10) NOT NULL,
  `HinhAnh` VARCHAR(45) NOT NULL,
  `GiaBan` VARCHAR(255) NOT NULL,
  `GiaMua` DOUBLE NOT NULL,
  `SoLuong` INT NOT NULL,
  PRIMARY KEY (`MatHang_MaMH`, `KichCo_MaKC`),
  INDEX `fk_MatHang_has_KichCo_KichCo1_idx` (`KichCo_MaKC` ASC) VISIBLE,
  INDEX `fk_MatHang_has_KichCo_MatHang_idx` (`MatHang_MaMH` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_has_KichCo_MatHang`
    FOREIGN KEY (`MatHang_MaMH`)
    REFERENCES `java11_shopping`.`MatHang` (`MaMH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MatHang_has_KichCo_KichCo1`
    FOREIGN KEY (`KichCo_MaKC`)
    REFERENCES `java11_shopping`.`KichCo` (`MaKC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`TinhTrangDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`TinhTrangDonHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`TinhTrangDonHang` (
  `MaTT` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaTT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`ChucVu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`ChucVu` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`ChucVu` (
  `MaChucVu` INT NOT NULL,
  `TenChucVu` VARCHAR(255) NULL,
  `MoTa` VARCHAR(255) NULL,
  PRIMARY KEY (`MaChucVu`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`NhanVien`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`NhanVien` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`NhanVien` (
  `MaNhanVien` INT NOT NULL,
  `TenNV` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(45) NULL,
  `SDT` VARCHAR(255) NULL,
  `DiaChi` TEXT NULL,
  `MatKhau` VARCHAR(255) NULL,
  `MaCV` INT NOT NULL,
  PRIMARY KEY (`MaNhanVien`),
  INDEX `fk_NhanVien_ChucVu1_idx` (`MaCV` ASC) VISIBLE,
  CONSTRAINT `fk_NhanVien_ChucVu1`
    FOREIGN KEY (`MaCV`)
    REFERENCES `java11_shopping`.`ChucVu` (`MaChucVu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`KhachHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`KhachHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`KhachHang` (
  `MaKH` INT NOT NULL,
  `TenKH` VARCHAR(255) NULL,
  `Email` VARCHAR(255) NULL,
  `DiaChi` VARCHAR(255) NULL,
  `SDT` TEXT NULL,
  `MXH` VARCHAR(255) NULL,
  PRIMARY KEY (`MaKH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`LoaiHinhThanhToan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`LoaiHinhThanhToan` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`LoaiHinhThanhToan` (
  `MaLHTT` INT NOT NULL,
  `MoTa` VARCHAR(45) NULL,
  PRIMARY KEY (`MaLHTT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`DonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`DonHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`DonHang` (
  `MaDonHang` INT NOT NULL,
  `DiaChiGiaoHang` VARCHAR(255) NOT NULL,
  `SoDienThoaiNguoiNhan` VARCHAR(255) NOT NULL,
  `ThoiGianDatHang` DATETIME NOT NULL,
  `PhiVanChuyen` DOUBLE NOT NULL,
  `TongTien` DOUBLE NOT NULL,
  `MaNV` INT NOT NULL,
  `MaKH` INT NOT NULL,
  `MaLHTT` INT NOT NULL,
  PRIMARY KEY (`MaDonHang`),
  INDEX `fk_DonHang_NhanVien1_idx` (`MaNV` ASC) VISIBLE,
  INDEX `fk_DonHang_KhachHang1_idx` (`MaKH` ASC) VISIBLE,
  INDEX `fk_DonHang_LoaiHinhThanhToan1_idx` (`MaLHTT` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `java11_shopping`.`NhanVien` (`MaNhanVien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_KhachHang1`
    FOREIGN KEY (`MaKH`)
    REFERENCES `java11_shopping`.`KhachHang` (`MaKH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_LoaiHinhThanhToan1`
    FOREIGN KEY (`MaLHTT`)
    REFERENCES `java11_shopping`.`LoaiHinhThanhToan` (`MaLHTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`HoaDon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`HoaDon` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`HoaDon` (
  `MaHD` INT NOT NULL,
  `MaDH` INT NOT NULL,
  `NgayXuatHoaDon` DATETIME NULL,
  `SoTienCanThanhToan` DOUBLE NULL,
  PRIMARY KEY (`MaHD`),
  INDEX `fk_HoaDon_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_HoaDon_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java11_shopping`.`DonHang` (`MaDonHang`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`ChiTietDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`ChiTietDonHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`ChiTietDonHang` (
  `DonHang_MaDonHang` INT NOT NULL,
  `MatHang_MaMH` INT NOT NULL,
  `SoLuong` INT NULL,
  PRIMARY KEY (`DonHang_MaDonHang`, `MatHang_MaMH`),
  INDEX `fk_DonHang_has_MatHang_MatHang1_idx` (`MatHang_MaMH` ASC) VISIBLE,
  INDEX `fk_DonHang_has_MatHang_DonHang1_idx` (`DonHang_MaDonHang` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_has_MatHang_DonHang1`
    FOREIGN KEY (`DonHang_MaDonHang`)
    REFERENCES `java11_shopping`.`DonHang` (`MaDonHang`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_has_MatHang_MatHang1`
    FOREIGN KEY (`MatHang_MaMH`)
    REFERENCES `java11_shopping`.`MatHang` (`MaMH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`ChiTietTinhTrangDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`ChiTietTinhTrangDonHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`ChiTietTinhTrangDonHang` (
  `TinhTrangDonHang_MaTT` INT NOT NULL,
  `DonHang_MaDonHang` INT NOT NULL,
  `MaNV` INT NOT NULL,
  `ThoiGian` DATETIME NULL,
  PRIMARY KEY (`TinhTrangDonHang_MaTT`, `DonHang_MaDonHang`),
  INDEX `fk_TinhTrangDonHang_has_DonHang_DonHang1_idx` (`DonHang_MaDonHang` ASC) VISIBLE,
  INDEX `fk_TinhTrangDonHang_has_DonHang_TinhTrangDonHang1_idx` (`TinhTrangDonHang_MaTT` ASC) VISIBLE,
  INDEX `fk_ChiTietTinhTrangDonHang_NhanVien1_idx` (`MaNV` ASC) VISIBLE,
  CONSTRAINT `fk_TinhTrangDonHang_has_DonHang_TinhTrangDonHang1`
    FOREIGN KEY (`TinhTrangDonHang_MaTT`)
    REFERENCES `java11_shopping`.`TinhTrangDonHang` (`MaTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TinhTrangDonHang_has_DonHang_DonHang1`
    FOREIGN KEY (`DonHang_MaDonHang`)
    REFERENCES `java11_shopping`.`DonHang` (`MaDonHang`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ChiTietTinhTrangDonHang_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `java11_shopping`.`NhanVien` (`MaNhanVien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
