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
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaKC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`LoaiHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`LoaiHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`LoaiHang` (
  `MaLH` INT NOT NULL,
  `TenLH` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`MatHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`MatHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`MatHang` (
  `MaMH` INT NOT NULL,
  `TenMH` VARCHAR(255) NOT NULL,
  `MauSac` VARCHAR(255) NOT NULL,
  `MaLH` INT NOT NULL,
  PRIMARY KEY (`MaMH`),
  INDEX `fk_MatHang_LoaiHang1_idx` (`MaLH` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_LoaiHang1`
    FOREIGN KEY (`MaLH`)
    REFERENCES `java11_shopping`.`LoaiHang` (`MaLH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`ChiTietMatHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`ChiTietMatHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`ChiTietMatHang` (
  `MaMH` INT NOT NULL,
  `MaKC` VARCHAR(10) NOT NULL,
  `HinhAnh` VARCHAR(255) NOT NULL,
  `GiaBan` DOUBLE NOT NULL,
  `GiaMua` DOUBLE NOT NULL,
  `SoLuong` INT NOT NULL,
  PRIMARY KEY (`MaMH`, `MaKC`),
  INDEX `fk_MatHang_has_KichCo_KichCo1_idx` (`MaKC` ASC) VISIBLE,
  INDEX `fk_MatHang_has_KichCo_MatHang_idx` (`MaMH` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_has_KichCo_MatHang`
    FOREIGN KEY (`MaMH`)
    REFERENCES `java11_shopping`.`MatHang` (`MaMH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MatHang_has_KichCo_KichCo1`
    FOREIGN KEY (`MaKC`)
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
  `MaCV` INT NOT NULL,
  `TenCV` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaCV`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`NhanVien`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`NhanVien` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`NhanVien` (
  `MaNV` INT NOT NULL,
  `TenNV` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `SDT` VARCHAR(255) NOT NULL,
  `DiaChi` TEXT NOT NULL,
  `MatKhau` VARCHAR(255) NOT NULL,
  `MaCV` INT NOT NULL,
  PRIMARY KEY (`MaNV`),
  INDEX `fk_NhanVien_ChucVu1_idx` (`MaCV` ASC) VISIBLE,
  CONSTRAINT `fk_NhanVien_ChucVu1`
    FOREIGN KEY (`MaCV`)
    REFERENCES `java11_shopping`.`ChucVu` (`MaCV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`KhachHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`KhachHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`KhachHang` (
  `MaKH` INT NOT NULL,
  `TenKH` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `DiaChi` TEXT NOT NULL,
  `SDT` VARCHAR(255) NOT NULL,
  `MXH` VARCHAR(255) NULL,
  PRIMARY KEY (`MaKH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`LoaiHinhThanhToan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`LoaiHinhThanhToan` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`LoaiHinhThanhToan` (
  `MaLHTT` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLHTT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`DonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`DonHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`DonHang` (
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
  CONSTRAINT `fk_DonHang_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `java11_shopping`.`NhanVien` (`MaNV`)
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
-- Table `java11_shopping`.`ChiTietDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`ChiTietDonHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`ChiTietDonHang` (
  `MaDH` INT NOT NULL,
  `MaMH` INT NOT NULL,
  `SoLuong` INT NULL,
  PRIMARY KEY (`MaDH`, `MaMH`),
  INDEX `fk_DonHang_has_MatHang_MatHang1_idx` (`MaMH` ASC) VISIBLE,
  INDEX `fk_DonHang_has_MatHang_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_has_MatHang_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java11_shopping`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_has_MatHang_MatHang1`
    FOREIGN KEY (`MaMH`)
    REFERENCES `java11_shopping`.`MatHang` (`MaMH`)
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
    REFERENCES `java11_shopping`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_shopping`.`ChiTietTinhTrangDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`ChiTietTinhTrangDonHang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`ChiTietTinhTrangDonHang` (
  `MaDH` INT NOT NULL,
  `MaTT` INT NOT NULL,
  `MaNV` INT NOT NULL,
  `ThoiGian` DATETIME NULL,
  PRIMARY KEY (`MaDH`, `MaTT`),
  INDEX `fk_DonHang_has_TinhTrangDonHang_TinhTrangDonHang1_idx` (`MaTT` ASC) VISIBLE,
  INDEX `fk_DonHang_has_TinhTrangDonHang_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  INDEX `fk_ChiTietTinhTrangDonHang_NhanVien1_idx` (`MaNV` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_has_TinhTrangDonHang_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java11_shopping`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_has_TinhTrangDonHang_TinhTrangDonHang1`
    FOREIGN KEY (`MaTT`)
    REFERENCES `java11_shopping`.`TinhTrangDonHang` (`MaTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ChiTietTinhTrangDonHang_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `java11_shopping`.`NhanVien` (`MaNV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
