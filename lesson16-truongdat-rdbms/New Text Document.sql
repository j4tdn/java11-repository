-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema java11_sanbongmini
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `java11_sanbongmini` ;

-- -----------------------------------------------------
-- Schema java11_sanbongmini
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `java11_sanbongmini` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema java11_shopping
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `java11_shopping` ;

-- -----------------------------------------------------
-- Schema java11_shopping
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `java11_shopping` DEFAULT CHARACTER SET utf8 ;
USE `java11_sanbongmini` ;

-- -----------------------------------------------------
-- Table `java11_sanbongmini`.`FootballPlayer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_sanbongmini`.`FootballPlayer` ;

CREATE TABLE IF NOT EXISTS `java11_sanbongmini`.`FootballPlayer` (
  `idFootballPlayer` INT NOT NULL,
  `nameFootballPlayer` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `mainRole` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idFootballPlayer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_sanbongmini`.`Owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_sanbongmini`.`Owner` ;

CREATE TABLE IF NOT EXISTS `java11_sanbongmini`.`Owner` (
  `idOwner` INT NOT NULL,
  `nameOwner` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idOwner`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_sanbongmini`.`FootballFieldInfomation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_sanbongmini`.`FootballFieldInfomation` ;

CREATE TABLE IF NOT EXISTS `java11_sanbongmini`.`FootballFieldInfomation` (
  `idFootballFieldInfomation` INT NOT NULL,
  `nameFootballField` VARCHAR(255) NOT NULL,
  `location` VARCHAR(255) NOT NULL,
  `idOwner` INT NOT NULL,
  PRIMARY KEY (`idFootballFieldInfomation`),
  INDEX `fk_FootballFieldInfomation_Owner1_idx` (`idOwner` ASC) VISIBLE,
  CONSTRAINT `fk_FootballFieldInfomation_Owner1`
    FOREIGN KEY (`idOwner`)
    REFERENCES `java11_sanbongmini`.`Owner` (`idOwner`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_sanbongmini`.`FootballTeam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_sanbongmini`.`FootballTeam` ;

CREATE TABLE IF NOT EXISTS `java11_sanbongmini`.`FootballTeam` (
  `idFootballTeam` INT NOT NULL,
  `nameFootballTeam` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`idFootballTeam`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_sanbongmini`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_sanbongmini`.`Order` ;

CREATE TABLE IF NOT EXISTS `java11_sanbongmini`.`Order` (
  `idOrder` INT NOT NULL,
  `dateOrder` VARCHAR(255) NOT NULL,
  `idOwner` INT NOT NULL,
  `idFootballPlayer` INT NOT NULL,
  `idFootballTeam` INT NOT NULL,
  `totalPrice` DOUBLE NOT NULL,
  PRIMARY KEY (`idOrder`),
  INDEX `fk_Order_Owner1_idx` (`idOwner` ASC) VISIBLE,
  INDEX `fk_Order_FootballPlayer1_idx` (`idFootballPlayer` ASC) VISIBLE,
  INDEX `fk_Order_FootballTeam1_idx` (`idFootballTeam` ASC) VISIBLE,
  CONSTRAINT `fk_Order_Owner1`
    FOREIGN KEY (`idOwner`)
    REFERENCES `java11_sanbongmini`.`Owner` (`idOwner`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_FootballPlayer1`
    FOREIGN KEY (`idFootballPlayer`)
    REFERENCES `java11_sanbongmini`.`FootballPlayer` (`idFootballPlayer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_FootballTeam1`
    FOREIGN KEY (`idFootballTeam`)
    REFERENCES `java11_sanbongmini`.`FootballTeam` (`idFootballTeam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_sanbongmini`.`Serivice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_sanbongmini`.`Serivice` ;

CREATE TABLE IF NOT EXISTS `java11_sanbongmini`.`Serivice` (
  `idService` INT NOT NULL,
  `nameSerivce` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`idService`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_sanbongmini`.`MemberRole`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_sanbongmini`.`MemberRole` ;

CREATE TABLE IF NOT EXISTS `java11_sanbongmini`.`MemberRole` (
  `idFootballPlayer` INT NOT NULL,
  `idFootballTeam` INT NOT NULL,
  `role` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idFootballPlayer`, `idFootballTeam`),
  INDEX `fk_FootballPlayer_has_FootballTeam_FootballTeam1_idx` (`idFootballTeam` ASC) VISIBLE,
  INDEX `fk_FootballPlayer_has_FootballTeam_FootballPlayer_idx` (`idFootballPlayer` ASC) VISIBLE,
  CONSTRAINT `fk_FootballPlayer_has_FootballTeam_FootballPlayer`
    FOREIGN KEY (`idFootballPlayer`)
    REFERENCES `java11_sanbongmini`.`FootballPlayer` (`idFootballPlayer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FootballPlayer_has_FootballTeam_FootballTeam1`
    FOREIGN KEY (`idFootballTeam`)
    REFERENCES `java11_sanbongmini`.`FootballTeam` (`idFootballTeam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_sanbongmini`.`Bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_sanbongmini`.`Bill` ;

CREATE TABLE IF NOT EXISTS `java11_sanbongmini`.`Bill` (
  `idBill` INT NOT NULL,
  `dateOfBill` DATETIME NULL,
  `paymentAmount` DOUBLE NULL,
  `idOrder` INT NOT NULL,
  PRIMARY KEY (`idBill`),
  INDEX `fk_Bill_Order1_idx` (`idOrder` ASC) VISIBLE,
  CONSTRAINT `fk_Bill_Order1`
    FOREIGN KEY (`idOrder`)
    REFERENCES `java11_sanbongmini`.`Order` (`idOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_sanbongmini`.`OrderStatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_sanbongmini`.`OrderStatus` ;

CREATE TABLE IF NOT EXISTS `java11_sanbongmini`.`OrderStatus` (
  `idFootballFieldInfomation` INT NOT NULL,
  `idOrder` INT NOT NULL,
  `startDatetime` DATETIME NULL,
  `endDatetime` DATETIME NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`idFootballFieldInfomation`, `idOrder`),
  INDEX `fk_FootballFieldInfomation_has_Order_Order1_idx` (`idOrder` ASC) VISIBLE,
  INDEX `fk_FootballFieldInfomation_has_Order_FootballFieldInfomatio_idx` (`idFootballFieldInfomation` ASC) VISIBLE,
  CONSTRAINT `fk_FootballFieldInfomation_has_Order_FootballFieldInfomation1`
    FOREIGN KEY (`idFootballFieldInfomation`)
    REFERENCES `java11_sanbongmini`.`FootballFieldInfomation` (`idFootballFieldInfomation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FootballFieldInfomation_has_Order_Order1`
    FOREIGN KEY (`idOrder`)
    REFERENCES `java11_sanbongmini`.`Order` (`idOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_sanbongmini`.`UsingSeriviceStatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_sanbongmini`.`UsingSeriviceStatus` ;

CREATE TABLE IF NOT EXISTS `java11_sanbongmini`.`UsingSeriviceStatus` (
  `Serivice_idService` INT NOT NULL,
  `Order_idOrder` INT NOT NULL,
  `starReview` DOUBLE NULL,
  `commentReview` VARCHAR(255) NULL,
  `startUsing` DATETIME NULL,
  `endUsing` DATETIME NULL,
  PRIMARY KEY (`Serivice_idService`, `Order_idOrder`),
  INDEX `fk_Serivice_has_Order_Order1_idx` (`Order_idOrder` ASC) VISIBLE,
  INDEX `fk_Serivice_has_Order_Serivice1_idx` (`Serivice_idService` ASC) VISIBLE,
  CONSTRAINT `fk_Serivice_has_Order_Serivice1`
    FOREIGN KEY (`Serivice_idService`)
    REFERENCES `java11_sanbongmini`.`Serivice` (`idService`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Serivice_has_Order_Order1`
    FOREIGN KEY (`Order_idOrder`)
    REFERENCES `java11_sanbongmini`.`Order` (`idOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `java11_shopping` ;

-- -----------------------------------------------------
-- Table `java11_shopping`.`khachhang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`khachhang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`khachhang` (
  `MaKH` INT NOT NULL,
  `TenKH` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `DiaChi` TEXT NOT NULL,
  `SDT` VARCHAR(255) NOT NULL,
  `MXH` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`MaKH`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `java11_shopping`.`loaihinhthanhtoan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`loaihinhthanhtoan` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`loaihinhthanhtoan` (
  `MaLHTT` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLHTT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `java11_shopping`.`chucvu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`chucvu` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`chucvu` (
  `MaCV` INT NOT NULL,
  `TenCV` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaCV`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `java11_shopping`.`nhanvien`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`nhanvien` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`nhanvien` (
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
    REFERENCES `java11_shopping`.`chucvu` (`MaCV`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `java11_shopping`.`donhang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`donhang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`donhang` (
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
  CONSTRAINT `fk_DonHang_KhachHang1`
    FOREIGN KEY (`MaKH`)
    REFERENCES `java11_shopping`.`khachhang` (`MaKH`),
  CONSTRAINT `fk_DonHang_LoaiHinhThanhToan1`
    FOREIGN KEY (`MaLHTT`)
    REFERENCES `java11_shopping`.`loaihinhthanhtoan` (`MaLHTT`),
  CONSTRAINT `fk_DonHang_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `java11_shopping`.`nhanvien` (`MaNV`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `java11_shopping`.`loaihang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`loaihang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`loaihang` (
  `MaLH` INT NOT NULL,
  `TenLH` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaLH`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `java11_shopping`.`mathang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`mathang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`mathang` (
  `MaMH` INT NOT NULL,
  `TenMH` VARCHAR(255) NOT NULL,
  `MauSac` VARCHAR(255) NOT NULL,
  `MaLH` INT NOT NULL,
  PRIMARY KEY (`MaMH`),
  INDEX `fk_MatHang_LoaiHang1_idx` (`MaLH` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_LoaiHang1`
    FOREIGN KEY (`MaLH`)
    REFERENCES `java11_shopping`.`loaihang` (`MaLH`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `java11_shopping`.`chitietdonhang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`chitietdonhang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`chitietdonhang` (
  `MaDH` INT NOT NULL,
  `MaMH` INT NOT NULL,
  `SoLuong` INT NULL DEFAULT NULL,
  PRIMARY KEY (`MaDH`, `MaMH`),
  INDEX `fk_DonHang_has_MatHang_MatHang1_idx` (`MaMH` ASC) VISIBLE,
  INDEX `fk_DonHang_has_MatHang_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_DonHang_has_MatHang_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java11_shopping`.`donhang` (`MaDH`),
  CONSTRAINT `fk_DonHang_has_MatHang_MatHang1`
    FOREIGN KEY (`MaMH`)
    REFERENCES `java11_shopping`.`mathang` (`MaMH`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `java11_shopping`.`kichco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`kichco` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`kichco` (
  `MaKC` VARCHAR(10) NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaKC`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `java11_shopping`.`chitietmathang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`chitietmathang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`chitietmathang` (
  `MaMH` INT NOT NULL,
  `MaKC` VARCHAR(10) NOT NULL,
  `HinhAnh` VARCHAR(255) NOT NULL,
  `GiaBan` DOUBLE NOT NULL,
  `GiaMua` DOUBLE NOT NULL,
  `SoLuong` INT NOT NULL,
  PRIMARY KEY (`MaMH`, `MaKC`),
  INDEX `fk_MatHang_has_KichCo_KichCo1_idx` (`MaKC` ASC) VISIBLE,
  INDEX `fk_MatHang_has_KichCo_MatHang_idx` (`MaMH` ASC) VISIBLE,
  CONSTRAINT `fk_MatHang_has_KichCo_KichCo1`
    FOREIGN KEY (`MaKC`)
    REFERENCES `java11_shopping`.`kichco` (`MaKC`),
  CONSTRAINT `fk_MatHang_has_KichCo_MatHang`
    FOREIGN KEY (`MaMH`)
    REFERENCES `java11_shopping`.`mathang` (`MaMH`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `java11_shopping`.`tinhtrangdonhang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`tinhtrangdonhang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`tinhtrangdonhang` (
  `MaTT` INT NOT NULL,
  `MoTa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`MaTT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `java11_shopping`.`chitiettinhtrangdonhang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`chitiettinhtrangdonhang` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`chitiettinhtrangdonhang` (
  `MaDH` INT NOT NULL,
  `MaTT` INT NOT NULL,
  `MaNV` INT NOT NULL,
  `ThoiGian` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`MaDH`, `MaTT`),
  INDEX `fk_DonHang_has_TinhTrangDonHang_TinhTrangDonHang1_idx` (`MaTT` ASC) VISIBLE,
  INDEX `fk_DonHang_has_TinhTrangDonHang_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  INDEX `fk_ChiTietTinhTrangDonHang_NhanVien1_idx` (`MaNV` ASC) VISIBLE,
  CONSTRAINT `fk_ChiTietTinhTrangDonHang_NhanVien1`
    FOREIGN KEY (`MaNV`)
    REFERENCES `java11_shopping`.`nhanvien` (`MaNV`),
  CONSTRAINT `fk_DonHang_has_TinhTrangDonHang_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java11_shopping`.`donhang` (`MaDH`),
  CONSTRAINT `fk_DonHang_has_TinhTrangDonHang_TinhTrangDonHang1`
    FOREIGN KEY (`MaTT`)
    REFERENCES `java11_shopping`.`tinhtrangdonhang` (`MaTT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `java11_shopping`.`hoadon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_shopping`.`hoadon` ;

CREATE TABLE IF NOT EXISTS `java11_shopping`.`hoadon` (
  `MaHD` INT NOT NULL,
  `MaDH` INT NOT NULL,
  `NgayXuatHoaDon` DATETIME NULL DEFAULT NULL,
  `SoTienCanThanhToan` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`MaHD`),
  INDEX `fk_HoaDon_DonHang1_idx` (`MaDH` ASC) VISIBLE,
  CONSTRAINT `fk_HoaDon_DonHang1`
    FOREIGN KEY (`MaDH`)
    REFERENCES `java11_shopping`.`donhang` (`MaDH`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
