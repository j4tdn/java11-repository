-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema vanhoa-football
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `vanhoa-football` ;

-- -----------------------------------------------------
-- Schema vanhoa-football
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vanhoa-football` DEFAULT CHARACTER SET utf8 ;
USE `vanhoa-football` ;

-- -----------------------------------------------------
-- Table `vanhoa-football`.`KhungGio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vanhoa-football`.`KhungGio` ;

CREATE TABLE IF NOT EXISTS `vanhoa-football`.`KhungGio` (
  `MaKG` INT NOT NULL,
  `ThoiGianBatDau` DATETIME NOT NULL,
  `ThoiGianKetThuc` DATETIME NOT NULL,
  PRIMARY KEY (`MaKG`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vanhoa-football`.`ChuSan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vanhoa-football`.`ChuSan` ;

CREATE TABLE IF NOT EXISTS `vanhoa-football`.`ChuSan` (
  `MaCS` INT NOT NULL,
  `TenCS` VARCHAR(45) NOT NULL,
  `SDT` INT NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaCS`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vanhoa-football`.`TinhTrangSan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vanhoa-football`.`TinhTrangSan` ;

CREATE TABLE IF NOT EXISTS `vanhoa-football`.`TinhTrangSan` (
  `MaTT` INT NOT NULL,
  `TinhTrang` VARCHAR(45) NOT NULL,
  `MoTa` VARCHAR(255) NULL,
  `TinhTrangSancol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaTT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vanhoa-football`.`SanBong`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vanhoa-football`.`SanBong` ;

CREATE TABLE IF NOT EXISTS `vanhoa-football`.`SanBong` (
  `MaSan` INT NOT NULL,
  `MaCS` INT NOT NULL,
  `MaTT` INT NOT NULL,
  `TenSan` VARCHAR(255) NOT NULL,
  `DiaChi` VARCHAR(255) NOT NULL,
  `LoaiSan` VARCHAR(45) NOT NULL,
  `Gia` DOUBLE NOT NULL,
  PRIMARY KEY (`MaSan`),
  INDEX `fk_SanBong_ChuSan_idx` (`MaCS` ASC) VISIBLE,
  INDEX `fk_SanBong_TinhTrangSan1_idx` (`MaTT` ASC) VISIBLE,
  CONSTRAINT `fk_SanBong_ChuSan`
    FOREIGN KEY (`MaCS`)
    REFERENCES `vanhoa-football`.`ChuSan` (`MaCS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SanBong_TinhTrangSan1`
    FOREIGN KEY (`MaTT`)
    REFERENCES `vanhoa-football`.`TinhTrangSan` (`MaTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vanhoa-football`.`NguoiDaiDienDoiBong`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vanhoa-football`.`NguoiDaiDienDoiBong` ;

CREATE TABLE IF NOT EXISTS `vanhoa-football`.`NguoiDaiDienDoiBong` (
  `MaDD` INT NOT NULL,
  `Ten` VARCHAR(255) NOT NULL,
  `SDT` INT NOT NULL,
  `DiaChi` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaDD`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vanhoa-football`.`DoiBong`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vanhoa-football`.`DoiBong` ;

CREATE TABLE IF NOT EXISTS `vanhoa-football`.`DoiBong` (
  `MaDB` INT NOT NULL,
  `MaDD` INT NOT NULL,
  `TenDoi` VARCHAR(45) NOT NULL,
  `MoTa` VARCHAR(255) NULL,
  PRIMARY KEY (`MaDB`),
  INDEX `fk_DoiBong_NguoiDaiDienDoiBong1_idx` (`MaDD` ASC) VISIBLE,
  CONSTRAINT `fk_DoiBong_NguoiDaiDienDoiBong1`
    FOREIGN KEY (`MaDD`)
    REFERENCES `vanhoa-football`.`NguoiDaiDienDoiBong` (`MaDD`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vanhoa-football`.`DatSan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vanhoa-football`.`DatSan` ;

CREATE TABLE IF NOT EXISTS `vanhoa-football`.`DatSan` (
  `MaDS` INT NOT NULL,
  `NgayDat` DATETIME NOT NULL,
  `MaKG` INT NOT NULL,
  `MaDB` INT NOT NULL,
  `SanBong_MaSan` INT NOT NULL,
  PRIMARY KEY (`MaDS`),
  INDEX `fk_DatSan_KhungGio1_idx` (`MaKG` ASC) VISIBLE,
  INDEX `fk_DatSan_DoiBong1_idx` (`MaDB` ASC) VISIBLE,
  INDEX `fk_DatSan_SanBong1_idx` (`SanBong_MaSan` ASC) VISIBLE,
  CONSTRAINT `fk_DatSan_KhungGio1`
    FOREIGN KEY (`MaKG`)
    REFERENCES `vanhoa-football`.`KhungGio` (`MaKG`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DatSan_DoiBong1`
    FOREIGN KEY (`MaDB`)
    REFERENCES `vanhoa-football`.`DoiBong` (`MaDB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DatSan_SanBong1`
    FOREIGN KEY (`SanBong_MaSan`)
    REFERENCES `vanhoa-football`.`SanBong` (`MaSan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vanhoa-football`.`TranDauCho`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vanhoa-football`.`TranDauCho` ;

CREATE TABLE IF NOT EXISTS `vanhoa-football`.`TranDauCho` (
  `MaSan` INT NOT NULL,
  `MaDB` INT NOT NULL,
  `MoTa` VARCHAR(45) NULL,
  `MaKG` INT NOT NULL,
  PRIMARY KEY (`MaSan`, `MaDB`),
  INDEX `fk_SanBong_has_DoiBong_DoiBong1_idx` (`MaDB` ASC) VISIBLE,
  INDEX `fk_SanBong_has_DoiBong_SanBong1_idx` (`MaSan` ASC) VISIBLE,
  INDEX `fk_TranDauCho_KhungGio1_idx` (`MaKG` ASC) VISIBLE,
  CONSTRAINT `fk_SanBong_has_DoiBong_SanBong1`
    FOREIGN KEY (`MaSan`)
    REFERENCES `vanhoa-football`.`SanBong` (`MaSan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SanBong_has_DoiBong_DoiBong1`
    FOREIGN KEY (`MaDB`)
    REFERENCES `vanhoa-football`.`DoiBong` (`MaDB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TranDauCho_KhungGio1`
    FOREIGN KEY (`MaKG`)
    REFERENCES `vanhoa-football`.`KhungGio` (`MaKG`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
