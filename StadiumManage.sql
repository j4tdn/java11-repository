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
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Customer` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `idCustomer` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Phone` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `Address` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  PRIMARY KEY (`idCustomer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Position`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Position` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Position` (
  `idPosition` INT NOT NULL,
  `Description` VARCHAR(45) NULL,
  `Title` VARCHAR(45) NULL,
  PRIMARY KEY (`idPosition`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Staff` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Staff` (
  `idStaff` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `Phone` VARCHAR(45) NULL,
  `Position_idPosition` INT NOT NULL,
  PRIMARY KEY (`idStaff`),
  INDEX `fk_Staff_Position_idx` (`Position_idPosition` ASC) VISIBLE,
  CONSTRAINT `fk_Staff_Position`
    FOREIGN KEY (`Position_idPosition`)
    REFERENCES `mydb`.`Position` (`idPosition`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BranchStadium`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`BranchStadium` ;

CREATE TABLE IF NOT EXISTS `mydb`.`BranchStadium` (
  `IdBranch` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Address` VARCHAR(45) NULL,
  PRIMARY KEY (`IdBranch`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`StadiumType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`StadiumType` ;

CREATE TABLE IF NOT EXISTS `mydb`.`StadiumType` (
  `idStadiumType` INT NOT NULL,
  `Desctiption` VARCHAR(45) NULL,
  PRIMARY KEY (`idStadiumType`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PriceStadium`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PriceStadium` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PriceStadium` (
  `idPriceStadium` INT NOT NULL,
  `Time` VARCHAR(45) NULL,
  `Price` VARCHAR(45) NULL,
  PRIMARY KEY (`idPriceStadium`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`StatusStadium`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`StatusStadium` ;

CREATE TABLE IF NOT EXISTS `mydb`.`StatusStadium` (
  `idStatusStadium` INT NOT NULL,
  `Time` DATETIME NULL,
  `Status` VARCHAR(45) NULL,
  PRIMARY KEY (`idStatusStadium`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Stadium`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Stadium` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Stadium` (
  `idStadium` INT NOT NULL,
  `Location` VARCHAR(45) NULL,
  `StadiumType` INT NOT NULL,
  PRIMARY KEY (`idStadium`),
  INDEX `fk_Stadium_StadiumType1_idx` (`StadiumType` ASC) VISIBLE,
  CONSTRAINT `fk_Stadium_StadiumType1`
    FOREIGN KEY (`StadiumType`)
    REFERENCES `mydb`.`StadiumType` (`idStadiumType`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Detail_Stadium`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Detail_Stadium` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Detail_Stadium` (
  `ID_DetaiStadiuml` VARCHAR(45) NOT NULL,
  `Stadium_idStadium` INT NOT NULL,
  `PriceStadium_idPriceStadium` INT NOT NULL,
  `StatusStadium_idStatusStadium` INT NOT NULL,
  `BranchStadium_IdBranch` INT NOT NULL,
  INDEX `fk_Stadium_has_PriceStadium_PriceStadium1_idx` (`PriceStadium_idPriceStadium` ASC) VISIBLE,
  INDEX `fk_Stadium_has_PriceStadium_Stadium1_idx` (`Stadium_idStadium` ASC) VISIBLE,
  INDEX `fk_Stadium_has_PriceStadium_StatusStadium1_idx` (`StatusStadium_idStatusStadium` ASC) VISIBLE,
  INDEX `fk_Detai_Stadium_BranchStadium1_idx` (`BranchStadium_IdBranch` ASC) VISIBLE,
  PRIMARY KEY (`ID_DetaiStadiuml`),
  CONSTRAINT `fk_Stadium_has_PriceStadium_Stadium1`
    FOREIGN KEY (`Stadium_idStadium`)
    REFERENCES `mydb`.`Stadium` (`idStadium`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Stadium_has_PriceStadium_PriceStadium1`
    FOREIGN KEY (`PriceStadium_idPriceStadium`)
    REFERENCES `mydb`.`PriceStadium` (`idPriceStadium`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Stadium_has_PriceStadium_StatusStadium1`
    FOREIGN KEY (`StatusStadium_idStatusStadium`)
    REFERENCES `mydb`.`StatusStadium` (`idStatusStadium`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detai_Stadium_BranchStadium1`
    FOREIGN KEY (`BranchStadium_IdBranch`)
    REFERENCES `mydb`.`BranchStadium` (`IdBranch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Service` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Service` (
  `idService` INT NOT NULL,
  `NameService` VARCHAR(45) NULL,
  `Price` VARCHAR(45) NULL,
  `Status` VARCHAR(45) NULL,
  PRIMARY KEY (`idService`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Order` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Order` (
  `idOrder` INT NOT NULL,
  `Time` DATETIME NULL,
  `Total` DOUBLE NULL,
  `IDCustomer` INT NOT NULL,
  `idStaff` INT NOT NULL,
  PRIMARY KEY (`idOrder`),
  INDEX `fk_Order_Customer1_idx` (`IDCustomer` ASC) VISIBLE,
  INDEX `fk_Order_Staff1_idx` (`idStaff` ASC) VISIBLE,
  CONSTRAINT `fk_Order_Customer1`
    FOREIGN KEY (`IDCustomer`)
    REFERENCES `mydb`.`Customer` (`idCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Staff1`
    FOREIGN KEY (`idStaff`)
    REFERENCES `mydb`.`Staff` (`idStaff`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ServiceDetail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ServiceDetail` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ServiceDetail` (
  `idServiceDetail` INT NOT NULL,
  `Quantity` VARCHAR(45) NULL,
  `Service_idService` INT NOT NULL,
  PRIMARY KEY (`idServiceDetail`),
  INDEX `fk_ServiceDetail_Service1_idx` (`Service_idService` ASC) VISIBLE,
  CONSTRAINT `fk_ServiceDetail_Service1`
    FOREIGN KEY (`Service_idService`)
    REFERENCES `mydb`.`Service` (`idService`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DetailOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DetailOrder` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DetailOrder` (
  `IDStadiuml` VARCHAR(45) NOT NULL,
  `idOrder` INT NOT NULL,
  `idServiceDetail` INT NOT NULL,
  PRIMARY KEY (`IDStadiuml`, `idOrder`),
  INDEX `fk_Detail_Stadium_has_Order_Order1_idx` (`idOrder` ASC) VISIBLE,
  INDEX `fk_Detail_Stadium_has_Order_Detail_Stadium1_idx` (`IDStadiuml` ASC) VISIBLE,
  INDEX `fk_DetailOrder_ServiceDetail1_idx` (`idServiceDetail` ASC) VISIBLE,
  CONSTRAINT `fk_Detail_Stadium_has_Order_Detail_Stadium1`
    FOREIGN KEY (`IDStadiuml`)
    REFERENCES `mydb`.`Detail_Stadium` (`ID_DetaiStadiuml`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detail_Stadium_has_Order_Order1`
    FOREIGN KEY (`idOrder`)
    REFERENCES `mydb`.`Order` (`idOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetailOrder_ServiceDetail1`
    FOREIGN KEY (`idServiceDetail`)
    REFERENCES `mydb`.`ServiceDetail` (`idServiceDetail`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SoccerTeam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`SoccerTeam` ;

CREATE TABLE IF NOT EXISTS `mydb`.`SoccerTeam` (
  `idSoccerTeam` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `District` VARCHAR(45) NULL,
  `Status` VARCHAR(45) NULL,
  PRIMARY KEY (`idSoccerTeam`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SoccerMatch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`SoccerMatch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`SoccerMatch` (
  `idSoccerMatch` INT NOT NULL,
  `NameMatch` VARCHAR(45) NULL,
  `Time` DATETIME NULL,
  `IdTeam` VARCHAR(45) NULL,
  PRIMARY KEY (`idSoccerMatch`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`detailMatch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`detailMatch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`detailMatch` (
  `SoccerMatch_idSoccerMatch` INT NOT NULL,
  `SoccerTeam_idSoccerTeam` INT NOT NULL,
  `Time` DATETIME NULL,
  `IdStadium` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`SoccerMatch_idSoccerMatch`, `SoccerTeam_idSoccerTeam`),
  INDEX `fk_SoccerMatch_has_SoccerTeam_SoccerTeam1_idx` (`SoccerTeam_idSoccerTeam` ASC) VISIBLE,
  INDEX `fk_SoccerMatch_has_SoccerTeam_SoccerMatch1_idx` (`SoccerMatch_idSoccerMatch` ASC) VISIBLE,
  INDEX `fk_detailMatch_Detail_Stadium1_idx` (`IdStadium` ASC) VISIBLE,
  CONSTRAINT `fk_SoccerMatch_has_SoccerTeam_SoccerMatch1`
    FOREIGN KEY (`SoccerMatch_idSoccerMatch`)
    REFERENCES `mydb`.`SoccerMatch` (`idSoccerMatch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SoccerMatch_has_SoccerTeam_SoccerTeam1`
    FOREIGN KEY (`SoccerTeam_idSoccerTeam`)
    REFERENCES `mydb`.`SoccerTeam` (`idSoccerTeam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detailMatch_Detail_Stadium1`
    FOREIGN KEY (`IdStadium`)
    REFERENCES `mydb`.`Detail_Stadium` (`ID_DetaiStadiuml`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
