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
  `IdCustomer` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `PhoneNumber` VARCHAR(255) NOT NULL,
  `Mount` INT NOT NULL,
  PRIMARY KEY (`IdCustomer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Service` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Service` (
  `idService` INT NOT NULL,
  `Description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idService`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Manager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Manager` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Manager` (
  `idManager` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idManager`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Status Pitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Status Pitch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Status Pitch` (
  `idStatus Pitch` INT NOT NULL,
  `Description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idStatus Pitch`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Time`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Time` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Time` (
  `idTime` INT NOT NULL,
  `TimeStart` DATETIME NOT NULL,
  `TimeEnd` DATETIME NOT NULL,
  PRIMARY KEY (`idTime`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Bill` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Bill` (
  `idBill` INT NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  `Manager_idManager` INT NOT NULL,
  PRIMARY KEY (`idBill`),
  INDEX `fk_Bill_Manager1_idx` (`Manager_idManager` ASC) VISIBLE,
  CONSTRAINT `fk_Bill_Manager1`
    FOREIGN KEY (`Manager_idManager`)
    REFERENCES `mydb`.`Manager` (`idManager`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Football_Pitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Football_Pitch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Football_Pitch` (
  `idFootball_Pitch` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `Address` VARCHAR(255) NOT NULL,
  `Type Pitch` INT NOT NULL,
  `Cost` DOUBLE NOT NULL,
  `IdCustomer` INT NOT NULL,
  `IdService` INT NOT NULL,
  `IdManager` INT NOT NULL,
  `IdStatus Pitch` INT NOT NULL,
  `IdTime` INT NOT NULL,
  `IdBill` INT NOT NULL,
  PRIMARY KEY (`idFootball_Pitch`),
  INDEX `fk_Football_Pitch_Customer_idx` (`IdCustomer` ASC) VISIBLE,
  INDEX `fk_Football_Pitch_Service1_idx` (`IdService` ASC) VISIBLE,
  INDEX `fk_Football_Pitch_Manager1_idx` (`IdManager` ASC) VISIBLE,
  INDEX `fk_Football_Pitch_Status Pitch1_idx` (`IdStatus Pitch` ASC) VISIBLE,
  INDEX `fk_Football_Pitch_Time1_idx` (`IdTime` ASC) VISIBLE,
  INDEX `fk_Football_Pitch_Bill1_idx` (`IdBill` ASC) VISIBLE,
  CONSTRAINT `fk_Football_Pitch_Customer`
    FOREIGN KEY (`IdCustomer`)
    REFERENCES `mydb`.`Customer` (`IdCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Football_Pitch_Service1`
    FOREIGN KEY (`IdService`)
    REFERENCES `mydb`.`Service` (`idService`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Football_Pitch_Manager1`
    FOREIGN KEY (`IdManager`)
    REFERENCES `mydb`.`Manager` (`idManager`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Football_Pitch_Status Pitch1`
    FOREIGN KEY (`IdStatus Pitch`)
    REFERENCES `mydb`.`Status Pitch` (`idStatus Pitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Football_Pitch_Time1`
    FOREIGN KEY (`IdTime`)
    REFERENCES `mydb`.`Time` (`idTime`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Football_Pitch_Bill1`
    FOREIGN KEY (`IdBill`)
    REFERENCES `mydb`.`Bill` (`idBill`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
