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
-- Table `mydb`.`LoaiSan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LoaiSan` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LoaiSan` (
  `MaLoai` INT NOT NULL,
  `TenLoai` VARCHAR(45) NULL,
  PRIMARY KEY (`MaLoai`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`QuanLy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`QuanLy` ;

CREATE TABLE IF NOT EXISTS `mydb`.`QuanLy` (
  `MaQL` INT NOT NULL,
  `TenQL` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  PRIMARY KEY (`MaQL`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SanBong`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`SanBong` ;

CREATE TABLE IF NOT EXISTS `mydb`.`SanBong` (
  `MaSB` INT NOT NULL,
  `TenSB` VARCHAR(45) NULL,
  `DiaChi` VARCHAR(45) NULL,
  `SDT` VARCHAR(45) NULL,
  `MaQL` INT NOT NULL,
  PRIMARY KEY (`MaSB`),
  INDEX `fk_SanBong_QuanLy1_idx` (`MaQL` ASC) VISIBLE,
  CONSTRAINT `fk_SanBong_QuanLy1`
    FOREIGN KEY (`MaQL`)
    REFERENCES `mydb`.`QuanLy` (`MaQL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`KhachHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`KhachHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`KhachHang` (
  `MaKH` INT NOT NULL,
  `TenKH` VARCHAR(45) NULL,
  `SDT` INT NULL,
  `DiaChi` VARCHAR(45) NULL,
  PRIMARY KEY (`MaKH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MatSan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`MatSan` ;

CREATE TABLE IF NOT EXISTS `mydb`.`MatSan` (
  `MaMS` INT NOT NULL,
  `MatSancol` VARCHAR(45) NULL,
  `LoaiSan` INT NOT NULL,
  `MaSB` INT NOT NULL,
  `MaKH` INT NOT NULL,
  PRIMARY KEY (`MaMS`),
  INDEX `fk_MatSan_LoaiSan_idx` (`LoaiSan` ASC) VISIBLE,
  INDEX `fk_MatSan_SanBong1_idx` (`MaSB` ASC) VISIBLE,
  INDEX `fk_MatSan_KhachHang1_idx` (`MaKH` ASC) VISIBLE,
  CONSTRAINT `fk_MatSan_LoaiSan`
    FOREIGN KEY (`LoaiSan`)
    REFERENCES `mydb`.`LoaiSan` (`MaLoai`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MatSan_SanBong1`
    FOREIGN KEY (`MaSB`)
    REFERENCES `mydb`.`SanBong` (`MaSB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MatSan_KhachHang1`
    FOREIGN KEY (`MaKH`)
    REFERENCES `mydb`.`KhachHang` (`MaKH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TinhTrangSan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TinhTrangSan` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TinhTrangSan` (
  `MaTT` INT NOT NULL,
  `ThoiGianBatDau` VARCHAR(255) NULL,
  `ThoiGianKetThuc` VARCHAR(45) NULL,
  `TinhTrang` TINYINT NULL,
  `TinhTrangSancol` VARCHAR(45) NULL,
  `MaMS` INT NOT NULL,
  PRIMARY KEY (`MaTT`),
  INDEX `fk_TinhTrangSan_MatSan1_idx` (`MaMS` ASC) VISIBLE,
  CONSTRAINT `fk_TinhTrangSan_MatSan1`
    FOREIGN KEY (`MaMS`)
    REFERENCES `mydb`.`MatSan` (`MaMS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ThongKe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ThongKe` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ThongKe` (
  `MaTK` INT NOT NULL,
  `TenKH` VARCHAR(45) NULL,
  `MaMS` INT NOT NULL,
  `ThoiGianBatDau` VARCHAR(45) NULL,
  `ThoiGianKetThuc` VARCHAR(45) NULL,
  PRIMARY KEY (`MaTK`),
  INDEX `fk_ThongKe_MatSan1_idx` (`MaMS` ASC) VISIBLE,
  CONSTRAINT `fk_ThongKe_MatSan1`
    FOREIGN KEY (`MaMS`)
    REFERENCES `mydb`.`MatSan` (`MaMS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
