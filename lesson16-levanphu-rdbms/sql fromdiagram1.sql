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
-- Table `mydb`.`DichVu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DichVu` (
  `MaDV` INT NOT NULL,
  `ThemNuocGiaiKhat` VARCHAR(45) NOT NULL,
  `ThemGioChoi` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaDV`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SanBong`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`SanBong` (
  `DiaChiSan` TEXT(255) NOT NULL,
  `TenChuSan` VARCHAR(255) NOT NULL,
  `SoDienThoai` TEXT NOT NULL,
  PRIMARY KEY (`DiaChiSan`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ThongTinSanBong`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ThongTinSanBong` (
  `MaSan` INT NOT NULL,
  `LoaiSan` TEXT(255) NOT NULL,
  `ThoiGianBatDau` DATETIME NOT NULL,
  `ThoiGianKetThuc` DATETIME NOT NULL,
  `Gia` TEXT NOT NULL,
  `MaDV` INT NOT NULL,
  `DiaChiSan` TEXT(255) NOT NULL,
  PRIMARY KEY (`MaSan`),
  INDEX `fk_ThongTinSanBong_DichVu1_idx` (`MaDV` ASC) VISIBLE,
  INDEX `fk_ThongTinSanBong_SanBong1_idx` (`DiaChiSan` ASC) VISIBLE,
  CONSTRAINT `fk_ThongTinSanBong_DichVu1`
    FOREIGN KEY (`MaDV`)
    REFERENCES `mydb`.`DichVu` (`MaDV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ThongTinSanBong_SanBong1`
    FOREIGN KEY (`DiaChiSan`)
    REFERENCES `mydb`.`SanBong` (`DiaChiSan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ThongTinNguoiDat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ThongTinNguoiDat` (
  `MaND` INT NOT NULL,
  `TenND` VARCHAR(255) NOT NULL,
  `SoDienThoai` DOUBLE NOT NULL,
  PRIMARY KEY (`MaND`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LichDatSan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LichDatSan` (
  `MaDS` INT NOT NULL,
  `LichDatSancol` VARCHAR(2555) NOT NULL,
  `LichDatSancol1` VARCHAR(45) NOT NULL,
  `_MaND` INT NOT NULL,
  PRIMARY KEY (`MaDS`, `_MaND`),
  INDEX `fk_LichDatSan_ThongTinNguoiDat1_idx` (`_MaND` ASC) VISIBLE,
  CONSTRAINT `fk_LichDatSan_ThongTinNguoiDat1`
    FOREIGN KEY (`_MaND`)
    REFERENCES `mydb`.`ThongTinNguoiDat` (`MaND`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ChiTietLichDat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ChiTietLichDat` (
  `MaSan` INT NOT NULL,
  `MaDS` INT NOT NULL,
  `TenND` INT NOT NULL,
  `ThoiGianBatDau` DATETIME NOT NULL,
  `ThoiGianKetThuc` DATETIME NOT NULL,
  PRIMARY KEY (`MaSan`, `MaDS`),
  INDEX `fk_ThongTinSanBong_has_LichDatSan_LichDatSan1_idx` (`MaDS` ASC) VISIBLE,
  INDEX `fk_ThongTinSanBong_has_LichDatSan_ThongTinSanBong_idx` (`MaSan` ASC) VISIBLE,
  CONSTRAINT `fk_ThongTinSanBong_has_LichDatSan_ThongTinSanBong`
    FOREIGN KEY (`MaSan`)
    REFERENCES `mydb`.`ThongTinSanBong` (`MaSan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ThongTinSanBong_has_LichDatSan_LichDatSan1`
    FOREIGN KEY (`MaDS`)
    REFERENCES `mydb`.`LichDatSan` (`MaDS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TrangThaiSan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TrangThaiSan` (
  `MaTT` INT NOT NULL,
  `TrangThai` VARCHAR(255) NOT NULL,
  `MaSan` INT NOT NULL,
  PRIMARY KEY (`MaTT`),
  INDEX `fk_TrangThaiSan_ThongTinSanBong1_idx` (`MaSan` ASC) VISIBLE,
  CONSTRAINT `fk_TrangThaiSan_ThongTinSanBong1`
    FOREIGN KEY (`MaSan`)
    REFERENCES `mydb`.`ThongTinSanBong` (`MaSan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LichThiDau`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LichThiDau` (
  `MaLTD` INT NOT NULL,
  `DoiThiDau` VARCHAR(45) NOT NULL,
  `ThoiGianBatDau` DATETIME NOT NULL,
  `ThoiGianKetThuc` DATETIME NOT NULL,
  `MaSan` INT NOT NULL,
  PRIMARY KEY (`MaLTD`),
  INDEX `fk_LichThiDau_ThongTinSanBong1_idx` (`MaSan` ASC) VISIBLE,
  CONSTRAINT `fk_LichThiDau_ThongTinSanBong1`
    FOREIGN KEY (`MaSan`)
    REFERENCES `mydb`.`ThongTinSanBong` (`MaSan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
