-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema java12_shopping
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `java12_shopping` ;

-- -----------------------------------------------------
-- Schema java12_shopping
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `java12_shopping` DEFAULT CHARACTER SET utf8 ;
USE `java12_shopping` ;

-- -----------------------------------------------------
-- Table `java12_shopping`.`KichCo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java12_shopping`.`KichCo` ;

CREATE TABLE IF NOT EXISTS `java12_shopping`.`KichCo` (
  `MaKC` VARCHAR(10) NOT NULL,
  `MoTa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaKC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java12_shopping`.`LoaiHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java12_shopping`.`LoaiHang` ;

CREATE TABLE IF NOT EXISTS `java12_shopping`.`LoaiHang` (
  `MaLH` INT NOT NULL,
  `TenLH` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java12_shopping`.`MatHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java12_shopping`.`MatHang` ;

CREATE TABLE IF NOT EXISTS `java12_shopping`.`MatHang` (
  `MaMH` INT NOT NULL,
  `TenMH` VARCHAR(255) NOT NULL,
  `MaSac` VARCHAR(255) NOT NULL,
  `MaLH` INT NOT NULL,
  PRIMARY KEY (`MaMH`),
  INDEX `fk_MatHang_LoaiHang1_idx` (`MaLH` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_LoaiHang1`
    FOREIGN KEY (`MaLH`)
    REFERENCES `java12_shopping`.`LoaiHang` (`MaLH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java12_shopping`.`ChiTietMatHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java12_shopping`.`ChiTietMatHang` ;

CREATE TABLE IF NOT EXISTS `java12_shopping`.`ChiTietMatHang` (
  `MaMH` INT NOT NULL,
  `MaKC` VARCHAR(10) NOT NULL,
  `HinhAnh` VARCHAR(255) NOT NULL,
  `GiaBan` DOUBLE NOT NULL,
  `GiaMua` INT NOT NULL,
  `SoLuong` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaMH`, `MaKC`),
  INDEX `fk_MatHang_has_KichCo_KichCo1_idx` (`MaKC` ASC) VISIBLE,
  INDEX `fk_MatHang_has_KichCo_MatHang_idx` (`MaMH` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_has_KichCo_MatHang`
    FOREIGN KEY (`MaMH`)
    REFERENCES `java12_shopping`.`MatHang` (`MaMH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MatHang_has_KichCo_KichCo1`
    FOREIGN KEY (`MaKC`)
    REFERENCES `java12_shopping`.`KichCo` (`MaKC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java12_shopping`.`KhachHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java12_shopping`.`KhachHang` ;

CREATE TABLE IF NOT EXISTS `java12_shopping`.`KhachHang` (
  `MaKH` INT NOT NULL,
  `TenKH` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `Diachi` VARCHAR(45) NULL,
  `SDT` VARCHAR(45) NULL,
  `MXH` VARCHAR(45) NULL,
  PRIMARY KEY (`MaKH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java12_shopping`.`LoaiHinhThanhToan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java12_shopping`.`LoaiHinhThanhToan` ;

CREATE TABLE IF NOT EXISTS `java12_shopping`.`LoaiHinhThanhToan` (
  `MaLHTT` INT NOT NULL,
  `Mota` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaLHTT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java12_shopping`.`ChucVu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java12_shopping`.`ChucVu` ;

CREATE TABLE IF NOT EXISTS `java12_shopping`.`ChucVu` (
  `MaCV` INT NOT NULL,
  `TenCV` VARCHAR(45) NULL,
  `MoTa` VARCHAR(45) NULL,
  PRIMARY KEY (`MaCV`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java12_shopping`.`NhanVien`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java12_shopping`.`NhanVien` ;

CREATE TABLE IF NOT EXISTS `java12_shopping`.`NhanVien` (
  `MaNV` INT NOT NULL,
  `TenNV` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `SDT` VARCHAR(45) NULL,
  `DiaChi` VARCHAR(45) NULL,
  `MatKhau` VARCHAR(45) NULL,
  `MaCV` INT NOT NULL,
  PRIMARY KEY (`MaNV`),
  INDEX `fk_NhanVien_ChucVu1_idx` (`MaCV` ASC) VISIBLE,
  CONSTRAINT `fk_NhanVien_ChucVu1`
    FOREIGN KEY (`MaCV`)
    REFERENCES `java12_shopping`.`ChucVu` (`MaCV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java12_shopping`.`DonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java12_shopping`.`DonHang` ;

CREATE TABLE IF NOT EXISTS `java12_shopping`.`DonHang` (
  `MaDH` INT NOT NULL,
  `DiaChiGiaoHang` VARCHAR(255) NOT NULL,
  `SDTNguoiNhan` VARCHAR(45) NOT NULL,
  `ThoiGianDatHang` DATETIME NOT NULL,
  `PhiVanChuyen` DOUBLE NOT NULL,
  `Tongtien` DOUBLE NOT NULL,
  `MaKH` INT NOT NULL,
  `MaLHTT` INT NOT NULL,
  `MaNV` INT NOT NULL,
  PRIMARY KEY (`MaDH`),
  INDEX `fk_DonHang_KhachHang1_idx` (`MaKH` ASC) VISIBLE,
  INDEX `fk_DonHang_LoaiHinhThanhToan1_idx` (`MaLHTT` ASC) VISIBLE,
  INDEX `fk_DonHang_NhanVien1_idx` (`MaNV` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_KhachHang1`
    FOREIGN KEY (`MaKH`)
    REFERENCES `java12_shopping`.`KhachHang` (`MaKH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_LoaiHinhThanhToan1`
    FOREIGN KEY (`MaLHTT`)
    REFERENCES `java12_shopping`.`LoaiHinhThanhToan` (`MaLHTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `java12_shopping`.`NhanVien` (`MaNV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java12_shopping`.`ChiTietDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java12_shopping`.`ChiTietDonHang` ;

CREATE TABLE IF NOT EXISTS `java12_shopping`.`ChiTietDonHang` (
  `MaDH` INT NOT NULL,
  `MaMH` INT NOT NULL,
  `SoLuong` INT NULL,
  PRIMARY KEY (`MaDH`, `MaMH`),
  INDEX `fk_MatHang_has_DonHang_DonHang1_idx` (`MaMH` ASC) VISIBLE,
  INDEX `fk_MatHang_has_DonHang_MatHang1_idx` (`MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_has_DonHang_MatHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java12_shopping`.`MatHang` (`MaMH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MatHang_has_DonHang_DonHang1`
    FOREIGN KEY (`MaMH`)
    REFERENCES `java12_shopping`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java12_shopping`.`HoaDon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java12_shopping`.`HoaDon` ;

CREATE TABLE IF NOT EXISTS `java12_shopping`.`HoaDon` (
  `MaHD` INT NOT NULL,
  `NgayXuatHD` DATE NULL,
  `SoTienCanThanhToan` DOUBLE NULL,
  `MaDH` INT NOT NULL,
  PRIMARY KEY (`MaHD`),
  INDEX `fk_HoaDon_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_HoaDon_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java12_shopping`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java12_shopping`.`TinhTrangDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java12_shopping`.`TinhTrangDonHang` ;

CREATE TABLE IF NOT EXISTS `java12_shopping`.`TinhTrangDonHang` (
  `MaTT` INT NOT NULL,
  `MoTa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaTT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java12_shopping`.`ChiTietTinhTrangDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java12_shopping`.`ChiTietTinhTrangDonHang` ;

CREATE TABLE IF NOT EXISTS `java12_shopping`.`ChiTietTinhTrangDonHang` (
  `MaTT` INT NOT NULL,
  `MaDH` INT NOT NULL,
  `ThoiGian` VARCHAR(45) NULL,
  `MaNV` INT NOT NULL,
  PRIMARY KEY (`MaTT`, `MaDH`),
  INDEX `fk_TinhTrangDonHang_has_DonHang_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  INDEX `fk_TinhTrangDonHang_has_DonHang_TinhTrangDonHang1_idx` (`MaTT` ASC) VISIBLE,
  INDEX `fk_ChiTietTinhTrangDonHang_NhanVien1_idx` (`MaNV` ASC) VISIBLE,
  CONSTRAINT `fk_TinhTrangDonHang_has_DonHang_TinhTrangDonHang1`
    FOREIGN KEY (`MaTT`)
    REFERENCES `java12_shopping`.`TinhTrangDonHang` (`MaTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TinhTrangDonHang_has_DonHang_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java12_shopping`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ChiTietTinhTrangDonHang_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `java12_shopping`.`NhanVien` (`MaNV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
