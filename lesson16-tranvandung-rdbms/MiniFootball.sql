-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema minifootball
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `minifootball` ;

-- -----------------------------------------------------
-- Schema minifootball
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `minifootball` DEFAULT CHARACTER SET utf8 ;
USE `minifootball` ;

-- -----------------------------------------------------
-- Table `minifootball`.`StatusPitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minifootball`.`StatusPitch` ;

CREATE TABLE IF NOT EXISTS `minifootball`.`StatusPitch` (
  `idStatusPitch` INT NOT NULL,
  `Description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idStatusPitch`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minifootball`.`Pitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minifootball`.`Pitch` ;

CREATE TABLE IF NOT EXISTS `minifootball`.`Pitch` (
  `idPitch` INT NOT NULL,
  `NamePitch` VARCHAR(45) NOT NULL,
  `Size` INT NOT NULL,
  `idStatusPitch` INT NOT NULL,
  PRIMARY KEY (`idPitch`),
  INDEX `fk_Pitch_ConditionPitch_idx` (`idStatusPitch` ASC) VISIBLE,
  CONSTRAINT `fk_Pitch_ConditionPitch`
    FOREIGN KEY (`idStatusPitch`)
    REFERENCES `minifootball`.`StatusPitch` (`idStatusPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minifootball`.`Client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minifootball`.`Client` ;

CREATE TABLE IF NOT EXISTS `minifootball`.`Client` (
  `idClient` INT NOT NULL,
  `NameClient` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `PhoneNumber` VARCHAR(45) NOT NULL,
  `Age` INT NOT NULL,
  PRIMARY KEY (`idClient`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minifootball`.`Staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minifootball`.`Staff` ;

CREATE TABLE IF NOT EXISTS `minifootball`.`Staff` (
  `idStaff` INT NOT NULL,
  `NameStaff` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `PhoneNumber` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `DateOfBirth` DATETIME NOT NULL,
  PRIMARY KEY (`idStaff`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minifootball`.`OrderPitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minifootball`.`OrderPitch` ;

CREATE TABLE IF NOT EXISTS `minifootball`.`OrderPitch` (
  `idOrderPitch` INT NOT NULL,
  `BookingTime` DATETIME NOT NULL,
  `TotalMoney` VARCHAR(45) NOT NULL,
  `idClient` INT NOT NULL,
  `idStaff` INT NOT NULL,
  PRIMARY KEY (`idOrderPitch`),
  INDEX `fk_OrderPitch_Client1_idx` (`idClient` ASC) VISIBLE,
  INDEX `fk_OrderPitch_Staff1_idx` (`idStaff` ASC) VISIBLE,
  CONSTRAINT `fk_OrderPitch_Client1`
    FOREIGN KEY (`idClient`)
    REFERENCES `minifootball`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderPitch_Staff1`
    FOREIGN KEY (`idStaff`)
    REFERENCES `minifootball`.`Staff` (`idStaff`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minifootball`.`DetailsOrderPitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minifootball`.`DetailsOrderPitch` ;

CREATE TABLE IF NOT EXISTS `minifootball`.`DetailsOrderPitch` (
  `idPitch` INT NOT NULL,
  `idOrderPitch` INT NOT NULL,
  `Quantity` INT NOT NULL,
  PRIMARY KEY (`idPitch`, `idOrderPitch`),
  INDEX `fk_Pitch_has_OrderPitch_OrderPitch1_idx` (`idOrderPitch` ASC) VISIBLE,
  INDEX `fk_Pitch_has_OrderPitch_Pitch1_idx` (`idPitch` ASC) VISIBLE,
  CONSTRAINT `fk_Pitch_has_OrderPitch_Pitch1`
    FOREIGN KEY (`idPitch`)
    REFERENCES `minifootball`.`Pitch` (`idPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pitch_has_OrderPitch_OrderPitch1`
    FOREIGN KEY (`idOrderPitch`)
    REFERENCES `minifootball`.`OrderPitch` (`idOrderPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minifootball`.`Bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minifootball`.`Bill` ;

CREATE TABLE IF NOT EXISTS `minifootball`.`Bill` (
  `idBill` INT NOT NULL,
  `ExportDate` DATETIME NOT NULL,
  `TotalMoney` VARCHAR(45) NOT NULL,
  `idOrderPitch` INT NOT NULL,
  `idClient` INT NOT NULL,
  PRIMARY KEY (`idBill`),
  INDEX `fk_Bill_OrderPitch1_idx` (`idOrderPitch` ASC) VISIBLE,
  INDEX `fk_Bill_Client1_idx` (`idClient` ASC) VISIBLE,
  CONSTRAINT `fk_Bill_OrderPitch1`
    FOREIGN KEY (`idOrderPitch`)
    REFERENCES `minifootball`.`OrderPitch` (`idOrderPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bill_Client1`
    FOREIGN KEY (`idClient`)
    REFERENCES `minifootball`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minifootball`.`DetailsStatusOrderPitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minifootball`.`DetailsStatusOrderPitch` ;

CREATE TABLE IF NOT EXISTS `minifootball`.`DetailsStatusOrderPitch` (
  `idOrderPitch` INT NOT NULL,
  `idStatusPitch` INT NOT NULL,
  `idStaff` INT NOT NULL,
  `TimeEdit` DATETIME NOT NULL,
  PRIMARY KEY (`idOrderPitch`, `idStatusPitch`),
  INDEX `fk_OrderPitch_has_StatusPitch_StatusPitch1_idx` (`idStatusPitch` ASC) VISIBLE,
  INDEX `fk_OrderPitch_has_StatusPitch_OrderPitch1_idx` (`idOrderPitch` ASC) VISIBLE,
  INDEX `fk_DetailsStatusOrderPitch_Staff1_idx` (`idStaff` ASC) VISIBLE,
  CONSTRAINT `fk_OrderPitch_has_StatusPitch_OrderPitch1`
    FOREIGN KEY (`idOrderPitch`)
    REFERENCES `minifootball`.`OrderPitch` (`idOrderPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderPitch_has_StatusPitch_StatusPitch1`
    FOREIGN KEY (`idStatusPitch`)
    REFERENCES `minifootball`.`StatusPitch` (`idStatusPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetailsStatusOrderPitch_Staff1`
    FOREIGN KEY (`idStaff`)
    REFERENCES `minifootball`.`Staff` (`idStaff`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minifootball`.`Match`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minifootball`.`Match` ;

CREATE TABLE IF NOT EXISTS `minifootball`.`Match` (
  `idMatch` INT NOT NULL,
  `NameMatch` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMatch`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minifootball`.`DetailsMatch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minifootball`.`DetailsMatch` ;

CREATE TABLE IF NOT EXISTS `minifootball`.`DetailsMatch` (
  `idMatch` INT NOT NULL,
  `idPitch` INT NOT NULL,
  `idClient` INT NOT NULL,
  `Quantity` INT NOT NULL,
  `TimeMatch` DATETIME NOT NULL,
  `ListMatch` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMatch`, `idPitch`),
  INDEX `fk_Match_has_Pitch_Pitch1_idx` (`idPitch` ASC) VISIBLE,
  INDEX `fk_Match_has_Pitch_Match1_idx` (`idMatch` ASC) VISIBLE,
  INDEX `fk_DetailsMatch_Client1_idx` (`idClient` ASC) VISIBLE,
  CONSTRAINT `fk_Match_has_Pitch_Match1`
    FOREIGN KEY (`idMatch`)
    REFERENCES `minifootball`.`Match` (`idMatch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_has_Pitch_Pitch1`
    FOREIGN KEY (`idPitch`)
    REFERENCES `minifootball`.`Pitch` (`idPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetailsMatch_Client1`
    FOREIGN KEY (`idClient`)
    REFERENCES `minifootball`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
