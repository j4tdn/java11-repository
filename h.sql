-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`KichCo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`KichCo` (
  `MaKC` VARCHAR(10) NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaKC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LoaiHang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LoaiHang` (
  `MaLH` INT NOT NULL,
  `TenLH` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MatHang`
-- -----------------------------------------------------
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
CREATE TABLE IF NOT EXISTS `mydb`.`ChiTietMatHang` (
  `MaMH` INT NOT NULL,
  `MaKC` VARCHAR(10) NOT NULL,
  `HinhAnh` VARCHAR(45) NOT NULL,
  `GiaBan` DOUBLE NOT NULL,
  `GiaMua` DOUBLE NOT NULL,
  `SoLuong` INT NOT NULL,
  PRIMARY KEY (`MaMH`, `MaKC`),
  INDEX `fk_MatHang_has_KichCo_KichCo1_idx` (`MaKC` ASC) VISIBLE,
  INDEX `fk_MatHang_has_KichCo_MatHang_idx` (`MaMH` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_has_KichCo_MatHang`
    FOREIGN KEY (`MaMH`)
    REFERENCES `mydb`.`MatHang` (`MaMH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MatHang_has_KichCo_KichCo1`
    FOREIGN KEY (`MaKC`)
    REFERENCES `mydb`.`KichCo` (`MaKC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LoaiHinhThanhToan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LoaiHinhThanhToan` (
  `MaLHTT` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLHTT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TinhTrangDonHang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TinhTrangDonHang` (
  `MaTT` INT NOT NULL,
  `MoTa` VARCHAR(45) NULL,
  PRIMARY KEY (`MaTT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ChucVu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ChucVu` (
  `MaCV` INT NOT NULL,
  `TenCV` VARCHAR(255) NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  `ChucVucol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaCV`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`KhachHang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`KhachHang` (
  `MaKH` INT NOT NULL,
  `TenKH` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `DiaChi` INT NOT NULL,
  `SoDienThoai` FLOAT NOT NULL,
  `MXH` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaKH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`NhanVien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`NhanVien` (
  `MaNV` INT NOT NULL,
  `TenNV` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `SoDienThoai` VARCHAR(45) NOT NULL,
  `DiaChi` VARCHAR(45) NOT NULL,
  `MatKhau` VARCHAR(45) NOT NULL,
  `MaCV` INT NOT NULL,
  PRIMARY KEY (`MaNV`, `MaCV`),
  INDEX `fk_NhanVien_ChucVu1_idx` (`MaCV` ASC) VISIBLE,
  CONSTRAINT `fk_NhanVien_ChucVu1`
    FOREIGN KEY (`MaCV`)
    REFERENCES `mydb`.`ChucVu` (`MaCV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DonHang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DonHang` (
  `MaDH` INT NOT NULL,
  `DiaChiGiaoHang` VARCHAR(45) NOT NULL,
  `SDTNguoiNhan` VARCHAR(45) NULL,
  `ThoiGianDatHang` VARCHAR(45) NULL,
  `PhiVanChuyen` VARCHAR(45) NULL,
  `TongTien` VARCHAR(45) NOT NULL,
  `KhachHang_MaKH` INT NOT NULL,
  `NhanVien_MaNV` INT NOT NULL,
  `NhanVien_MaCV` INT NOT NULL,
  `LoaiHinhThanhToan_MaLHTT` INT NOT NULL,
  PRIMARY KEY (`MaDH`),
  INDEX `fk_DonHang_KhachHang1_idx` (`KhachHang_MaKH` ASC) VISIBLE,
  INDEX `fk_DonHang_NhanVien1_idx` (`NhanVien_MaNV` ASC, `NhanVien_MaCV` ASC) VISIBLE,
  INDEX `fk_DonHang_LoaiHinhThanhToan1_idx` (`LoaiHinhThanhToan_MaLHTT` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_KhachHang1`
    FOREIGN KEY (`KhachHang_MaKH`)
    REFERENCES `mydb`.`KhachHang` (`MaKH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_NhanVien1`
    FOREIGN KEY (`NhanVien_MaNV` , `NhanVien_MaCV`)
    REFERENCES `mydb`.`NhanVien` (`MaNV` , `MaCV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_LoaiHinhThanhToan1`
    FOREIGN KEY (`LoaiHinhThanhToan_MaLHTT`)
    REFERENCES `mydb`.`LoaiHinhThanhToan` (`MaLHTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ChiTietTinhTrangDonHang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ChiTietTinhTrangDonHang` (
  `MaTT` INT NOT NULL,
  `MaDH` INT NOT NULL,
  `MaNv` INT NOT NULL,
  `ThoiGian` DATETIME NOT NULL,
  PRIMARY KEY (`MaTT`, `MaDH`),
  INDEX `fk_TinhTrangDonHang_has_DonHang_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  INDEX `fk_TinhTrangDonHang_has_DonHang_TinhTrangDonHang1_idx` (`MaTT` ASC) VISIBLE,
  CONSTRAINT `fk_TinhTrangDonHang_has_DonHang_TinhTrangDonHang1`
    FOREIGN KEY (`MaTT`)
    REFERENCES `mydb`.`TinhTrangDonHang` (`MaTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TinhTrangDonHang_has_DonHang_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `mydb`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
