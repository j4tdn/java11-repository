-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`KichCo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`KichCo` ;

CREATE TABLE IF NOT EXISTS `mydb`.`KichCo` (
  `MaKC` VARCHAR(10) NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaKC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LoaiHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LoaiHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LoaiHang` (
  `MaLH` INT NOT NULL,
  `TenLH` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MatHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`MatHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`MatHang` (
  `MaMH` INT NOT NULL,
  `TenMH` VARCHAR(255) NOT NULL,
  `MauSac` VARCHAR(255) NOT NULL,
  `MaLH` INT NOT NULL,
  PRIMARY KEY (`MaMH`),
  INDEX `fk_MatHang_LoaiHang1_idx` (`MaLH` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_LoaiHang1`
    FOREIGN KEY (`MaLH`)
    REFERENCES `mydb`.`LoaiHang` (`MaLH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ChiTietMatHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ChiTietMatHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ChiTietMatHang` (
  `MaKC` VARCHAR(10) NOT NULL,
  `MaMH` INT NOT NULL,
  `HinhAnh` VARCHAR(255) NOT NULL,
  `GiaBan` DOUBLE NOT NULL,
  `GiaMua` DOUBLE NOT NULL,
  `SoLuong` INT NOT NULL,
  PRIMARY KEY (`MaKC`, `MaMH`),
  INDEX `fk_KichCo_has_MatHang_MatHang1_idx` (`MaMH` ASC) VISIBLE,
  INDEX `fk_KichCo_has_MatHang_KichCo_idx` (`MaKC` ASC) VISIBLE,
  CONSTRAINT `fk_KichCo_has_MatHang_KichCo`
    FOREIGN KEY (`MaKC`)
    REFERENCES `mydb`.`KichCo` (`MaKC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_KichCo_has_MatHang_MatHang1`
    FOREIGN KEY (`MaMH`)
    REFERENCES `mydb`.`MatHang` (`MaMH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`KhachHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`KhachHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`KhachHang` (
  `MaKH` INT NOT NULL,
  `TenKH` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `DiaChi` VARCHAR(255) NOT NULL,
  `SDT` VARCHAR(255) NOT NULL,
  `MXH` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaKH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ChucVu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ChucVu` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ChucVu` (
  `MaCV` INT NOT NULL,
  `TenCV` VARCHAR(45) NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaCV`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`NhanVien`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`NhanVien` ;

CREATE TABLE IF NOT EXISTS `mydb`.`NhanVien` (
  `MaNV` INT NOT NULL,
  `TenNV` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `SoDienThoai` VARCHAR(255) NOT NULL,
  `DiaChi` VARCHAR(255) NOT NULL,
  `MatKhau` VARCHAR(255) NOT NULL,
  `MaCV` INT NOT NULL,
  PRIMARY KEY (`MaNV`),
  INDEX `fk_NhanVien_ChucVu1_idx` (`MaCV` ASC) VISIBLE,
  CONSTRAINT `fk_NhanVien_ChucVu1`
    FOREIGN KEY (`MaCV`)
    REFERENCES `mydb`.`ChucVu` (`MaCV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LoaiHinhThanhToan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LoaiHinhThanhToan` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LoaiHinhThanhToan` (
  `MaLHTH` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLHTH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TinhTrangDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TinhTrangDonHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TinhTrangDonHang` (
  `MaTT` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaTT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DonHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DonHang` (
  `MaDH` INT NOT NULL,
  `DiaChiGiaoHang` VARCHAR(255) NOT NULL,
  `SDTNguoiNhan` VARCHAR(255) NOT NULL,
  `ThoiGianDatHang` VARCHAR(255) NOT NULL,
  `PhiVanChuyen` VARCHAR(255) NOT NULL,
  `TongTien` VARCHAR(255) NOT NULL,
  `MaNV` INT NOT NULL,
  `MaKH` INT NOT NULL,
  `MaLHTT` INT NOT NULL,
  PRIMARY KEY (`MaDH`),
  INDEX `fk_DonHang_NhanVien1_idx` (`MaNV` ASC) VISIBLE,
  INDEX `fk_DonHang_KhachHang1_idx` (`MaKH` ASC) VISIBLE,
  INDEX `fk_DonHang_LoaiHinhThanhToan2_idx` (`MaLHTT` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `mydb`.`NhanVien` (`MaNV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_KhachHang1`
    FOREIGN KEY (`MaKH`)
    REFERENCES `mydb`.`KhachHang` (`MaKH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_LoaiHinhThanhToan2`
    FOREIGN KEY (`MaLHTT`)
    REFERENCES `mydb`.`LoaiHinhThanhToan` (`MaLHTH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`HoaDon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`HoaDon` ;

CREATE TABLE IF NOT EXISTS `mydb`.`HoaDon` (
  `MaHD` INT NOT NULL,
  `NgayXuatHD` DATE NOT NULL,
  `SoTienCanThanhToan` VARCHAR(255) NOT NULL,
  `MaDH` INT NOT NULL,
  PRIMARY KEY (`MaHD`),
  INDEX `fk_HoaDon_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_HoaDon_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `mydb`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ChiTietDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ChiTietDonHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ChiTietDonHang` (
  `MaDH` INT NOT NULL,
  `MaMH` INT NOT NULL,
  `SoLuong` INT NOT NULL,
  PRIMARY KEY (`MaDH`, `MaMH`),
  INDEX `fk_DonHang_has_MatHang_MatHang1_idx` (`MaMH` ASC) VISIBLE,
  INDEX `fk_DonHang_has_MatHang_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_has_MatHang_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `mydb`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_has_MatHang_MatHang1`
    FOREIGN KEY (`MaMH`)
    REFERENCES `mydb`.`MatHang` (`MaMH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ChiTietTinhTrangDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ChiTietTinhTrangDonHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ChiTietTinhTrangDonHang` (
  `MaDH` INT NOT NULL,
  `ThoiGian` DATE NOT NULL,
  `MaNV` INT NOT NULL,
  `MaTT` INT NOT NULL,
  PRIMARY KEY (`MaDH`, `MaTT`),
  INDEX `fk_DonHang_has_LoaiHinhThanhToan_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  INDEX `fk_ChiTietTinhTrangDonHang_NhanVien1_idx` (`MaNV` ASC) VISIBLE,
  INDEX `fk_ChiTietTinhTrangDonHang_TinhTrangDonHang1_idx` (`MaTT` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_has_LoaiHinhThanhToan_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `mydb`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ChiTietTinhTrangDonHang_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `mydb`.`NhanVien` (`MaNV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ChiTietTinhTrangDonHang_TinhTrangDonHang1`
    FOREIGN KEY (`MaTT`)
    REFERENCES `mydb`.`TinhTrangDonHang` (`MaTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
