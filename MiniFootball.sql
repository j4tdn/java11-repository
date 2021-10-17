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
-- Table `mydb`.`TinhTrangDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TinhTrangDonHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TinhTrangDonHang` (
  `MaTT` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaTT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ChucVu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ChucVu` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ChucVu` (
  `MaCV` INT NOT NULL,
  `TenCV` VARCHAR(255) NOT NULL,
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
  `SDT` VARCHAR(255) NOT NULL,
  `DiaChi` TEXT NOT NULL,
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
-- Table `mydb`.`KhachHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`KhachHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`KhachHang` (
  `MaKH` INT NOT NULL,
  `TenKH` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `DiaChi` TEXT NOT NULL,
  `SDT` VARCHAR(255) NOT NULL,
  `MXH` VARCHAR(255) NULL,
  PRIMARY KEY (`MaKH`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LoaiHinhThanhToan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LoaiHinhThanhToan` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LoaiHinhThanhToan` (
  `MaLHTT` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLHTT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DonHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DonHang` (
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
    REFERENCES `mydb`.`NhanVien` (`MaNV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_KhachHang1`
    FOREIGN KEY (`MaKH`)
    REFERENCES `mydb`.`KhachHang` (`MaKH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_LoaiHinhThanhToan1`
    FOREIGN KEY (`MaLHTT`)
    REFERENCES `mydb`.`LoaiHinhThanhToan` (`MaLHTT`)
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
  `SoLuong` INT NULL,
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
-- Table `mydb`.`HoaDon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`HoaDon` ;

CREATE TABLE IF NOT EXISTS `mydb`.`HoaDon` (
  `MaHD` INT NOT NULL,
  `MaDH` INT NOT NULL,
  `NgayXuatHoaDon` DATETIME NULL,
  `SoTienCanThanhToan` DOUBLE NULL,
  PRIMARY KEY (`MaHD`),
  INDEX `fk_HoaDon_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_HoaDon_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `mydb`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ChiTietTinhTrangDonHang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ChiTietTinhTrangDonHang` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ChiTietTinhTrangDonHang` (
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
    REFERENCES `mydb`.`DonHang` (`MaDH`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DonHang_has_TinhTrangDonHang_TinhTrangDonHang1`
    FOREIGN KEY (`MaTT`)
    REFERENCES `mydb`.`TinhTrangDonHang` (`MaTT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ChiTietTinhTrangDonHang_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `mydb`.`NhanVien` (`MaNV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Client` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Client` (
  `idClient` INT NOT NULL,
  `NameClient` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `phoneNumber` VARCHAR(255) NOT NULL,
  `socialNetwork` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idClient`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Position`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Position` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Position` (
  `idPosition` INT NOT NULL,
  ` Position` VARCHAR(255) NULL,
  PRIMARY KEY (`idPosition`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Staff` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Staff` (
  `idStaff` INT NOT NULL,
  `NameStaff` VARCHAR(45) NOT NULL,
  `idPosition` INT NOT NULL,
  PRIMARY KEY (`idStaff`),
  INDEX `fk_Staff_Position1_idx` (`idPosition` ASC) VISIBLE,
  CONSTRAINT `fk_Staff_Position1`
    FOREIGN KEY (`idPosition`)
    REFERENCES `mydb`.`Position` (`idPosition`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Order` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Order` (
  `idOrder` INT NOT NULL,
  `Time` DATETIME NOT NULL,
  `Price` VARCHAR(45) NULL,
  `Client_idClient` INT NOT NULL,
  `Staff_idStaff` INT NOT NULL,
  PRIMARY KEY (`idOrder`),
  INDEX `fk_Order_Client1_idx` (`Client_idClient` ASC) VISIBLE,
  INDEX `fk_Order_Staff1_idx` (`Staff_idStaff` ASC) VISIBLE,
  CONSTRAINT `fk_Order_Client1`
    FOREIGN KEY (`Client_idClient`)
    REFERENCES `mydb`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Staff1`
    FOREIGN KEY (`Staff_idStaff`)
    REFERENCES `mydb`.`Staff` (`idStaff`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BranchPitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`BranchPitch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`BranchPitch` (
  `idbranchPitch` INT NOT NULL,
  `Address` VARCHAR(45) NULL,
  PRIMARY KEY (`idbranchPitch`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TypeOfPitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TypeOfPitch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TypeOfPitch` (
  `idTypeOfPitch` INT NOT NULL,
  `Type` VARCHAR(255) NULL,
  `Decription` VARCHAR(255) NULL,
  PRIMARY KEY (`idTypeOfPitch`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Pitch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Pitch` (
  `idPitch` INT NOT NULL,
  `NamePitch` VARCHAR(255) NULL,
  `branchPitch_idbranchPitch` INT NOT NULL,
  `TypeOfPitch_idTypeOfPitch` INT NOT NULL,
  PRIMARY KEY (`idPitch`),
  INDEX `fk_Pitch_branchPitch1_idx` (`branchPitch_idbranchPitch` ASC) VISIBLE,
  INDEX `fk_Pitch_TypeOfPitch1_idx` (`TypeOfPitch_idTypeOfPitch` ASC) VISIBLE,
  CONSTRAINT `fk_Pitch_branchPitch1`
    FOREIGN KEY (`branchPitch_idbranchPitch`)
    REFERENCES `mydb`.`BranchPitch` (`idbranchPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pitch_TypeOfPitch1`
    FOREIGN KEY (`TypeOfPitch_idTypeOfPitch`)
    REFERENCES `mydb`.`TypeOfPitch` (`idTypeOfPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Service` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Service` (
  `idService` INT NOT NULL,
  `NameService` VARCHAR(45) NOT NULL,
  `Price` VARCHAR(45) NOT NULL,
  `Decription` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idService`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DetailService`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DetailService` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DetailService` (
  `Service_idService` INT NOT NULL,
  `Order_idOrder` INT NOT NULL,
  `Quantity` INT NULL,
  PRIMARY KEY (`Service_idService`, `Order_idOrder`),
  INDEX `fk_Service_has_Order_Order1_idx` (`Order_idOrder` ASC) VISIBLE,
  INDEX `fk_Service_has_Order_Service1_idx` (`Service_idService` ASC) VISIBLE,
  CONSTRAINT `fk_Service_has_Order_Service1`
    FOREIGN KEY (`Service_idService`)
    REFERENCES `mydb`.`Service` (`idService`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Service_has_Order_Order1`
    FOREIGN KEY (`Order_idOrder`)
    REFERENCES `mydb`.`Order` (`idOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`StatusPitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`StatusPitch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`StatusPitch` (
  `idStatusPitch` INT NOT NULL,
  `Status` VARCHAR(45) NULL,
  PRIMARY KEY (`idStatusPitch`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DetailOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DetailOrder` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DetailOrder` (
  `Order_idOrder` INT NOT NULL,
  `Pitch_idPitch` INT NOT NULL,
  `Quantity` INT NULL,
  `StatusPitch_idStatusPitch` INT NOT NULL,
  PRIMARY KEY (`Order_idOrder`, `Pitch_idPitch`),
  INDEX `fk_Order_has_Pitch_Pitch1_idx` (`Pitch_idPitch` ASC) VISIBLE,
  INDEX `fk_Order_has_Pitch_Order1_idx` (`Order_idOrder` ASC) VISIBLE,
  INDEX `fk_DetailOrder_StatusPitch1_idx` (`StatusPitch_idStatusPitch` ASC) VISIBLE,
  CONSTRAINT `fk_Order_has_Pitch_Order1`
    FOREIGN KEY (`Order_idOrder`)
    REFERENCES `mydb`.`Order` (`idOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_has_Pitch_Pitch1`
    FOREIGN KEY (`Pitch_idPitch`)
    REFERENCES `mydb`.`Pitch` (`idPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetailOrder_StatusPitch1`
    FOREIGN KEY (`StatusPitch_idStatusPitch`)
    REFERENCES `mydb`.`StatusPitch` (`idStatusPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Match`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Match` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Match` (
  `idMatch` INT NOT NULL,
  `NameMatch` VARCHAR(255) NULL,
  `Time` DATETIME NULL,
  `idTeam` VARCHAR(45) NULL,
  PRIMARY KEY (`idMatch`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SoccerTeam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`SoccerTeam` ;

CREATE TABLE IF NOT EXISTS `mydb`.`SoccerTeam` (
  `idSoccerTeam` INT NOT NULL,
  `NameTeam` VARCHAR(45) NULL,
  PRIMARY KEY (`idSoccerTeam`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DetailMatch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DetailMatch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DetailMatch` (
  `Match_idMatch` INT NOT NULL,
  `SoccerTeam_idSoccerTeam` INT NOT NULL,
  PRIMARY KEY (`Match_idMatch`),
  INDEX `fk_Match_has_Pitch_Match1_idx` (`Match_idMatch` ASC) VISIBLE,
  INDEX `fk_DetailMatch_SoccerTeam1_idx` (`SoccerTeam_idSoccerTeam` ASC) VISIBLE,
  CONSTRAINT `fk_Match_has_Pitch_Match1`
    FOREIGN KEY (`Match_idMatch`)
    REFERENCES `mydb`.`Match` (`idMatch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetailMatch_SoccerTeam1`
    FOREIGN KEY (`SoccerTeam_idSoccerTeam`)
    REFERENCES `mydb`.`SoccerTeam` (`idSoccerTeam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DetailMatch_has_DetailOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DetailMatch_has_DetailOrder` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DetailMatch_has_DetailOrder` (
  `DetailMatch_Match_idMatch` INT NOT NULL,
  `DetailOrder_Order_idOrder` INT NOT NULL,
  `DetailOrder_Pitch_idPitch` INT NOT NULL,
  PRIMARY KEY (`DetailMatch_Match_idMatch`, `DetailOrder_Order_idOrder`, `DetailOrder_Pitch_idPitch`),
  INDEX `fk_DetailMatch_has_DetailOrder_DetailOrder1_idx` (`DetailOrder_Order_idOrder` ASC, `DetailOrder_Pitch_idPitch` ASC) VISIBLE,
  INDEX `fk_DetailMatch_has_DetailOrder_DetailMatch1_idx` (`DetailMatch_Match_idMatch` ASC) VISIBLE,
  CONSTRAINT `fk_DetailMatch_has_DetailOrder_DetailMatch1`
    FOREIGN KEY (`DetailMatch_Match_idMatch`)
    REFERENCES `mydb`.`DetailMatch` (`Match_idMatch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetailMatch_has_DetailOrder_DetailOrder1`
    FOREIGN KEY (`DetailOrder_Order_idOrder` , `DetailOrder_Pitch_idPitch`)
    REFERENCES `mydb`.`DetailOrder` (`Order_idOrder` , `Pitch_idPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
