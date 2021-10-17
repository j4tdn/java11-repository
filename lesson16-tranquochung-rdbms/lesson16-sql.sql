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
-- Table `mydb`.`Team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Team` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Team` (
  `Id_Team` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `Address` VARCHAR(255) NOT NULL,
  `Phone` VARCHAR(255) NOT NULL,
  `Point` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Id_Team`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Client` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Client` (
  `Id_Client` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `Address` VARCHAR(255) NOT NULL,
  `Phone` VARCHAR(255) NOT NULL,
  `Team_Id_Team` INT NOT NULL,
  PRIMARY KEY (`Id_Client`),
  INDEX `fk_Client_Team1_idx` (`Team_Id_Team` ASC) VISIBLE,
  CONSTRAINT `fk_Client_Team1`
    FOREIGN KEY (`Team_Id_Team`)
    REFERENCES `mydb`.`Team` (`Id_Team`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Staff` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Staff` (
  `Id_Staff` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `Address` VARCHAR(255) NOT NULL,
  `Phone` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Id_Staff`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Status` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Status` (
  `Id_Status` INT NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Id_Status`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Yard`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Yard` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Yard` (
  `Id_Yard` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `Address` VARCHAR(255) NOT NULL,
  `Owner` VARCHAR(255) NOT NULL,
  `YardType` VARCHAR(255) NOT NULL,
  `Id_Status` INT NOT NULL,
  PRIMARY KEY (`Id_Yard`, `Id_Status`),
  INDEX `fk_Yard_Status_idx` (`Id_Status` ASC) VISIBLE,
  CONSTRAINT `fk_Yard_Status`
    FOREIGN KEY (`Id_Status`)
    REFERENCES `mydb`.`Status` (`Id_Status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Duration`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Duration` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Duration` (
  `idDuration` INT NOT NULL,
  `TimeStart` DATETIME NOT NULL,
  `TimeEnd` DATETIME NOT NULL,
  PRIMARY KEY (`idDuration`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Pitch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Pitch` (
  `Id_Client` INT NOT NULL,
  `Id_Yard` INT NOT NULL,
  `DatePitch` DATE NOT NULL,
  `Time` TIME NOT NULL,
  `Id_Staff` INT NOT NULL,
  `Duration_idDuration` INT NOT NULL,
  PRIMARY KEY (`Id_Client`, `Id_Yard`),
  INDEX `fk_Client_has_Yard_Yard1_idx` (`Id_Yard` ASC) VISIBLE,
  INDEX `fk_Client_has_Yard_Client1_idx` (`Id_Client` ASC) VISIBLE,
  INDEX `fk_Pitch_Staff1_idx` (`Id_Staff` ASC) VISIBLE,
  INDEX `fk_Pitch_Duration1_idx` (`Duration_idDuration` ASC) VISIBLE,
  CONSTRAINT `fk_Client_has_Yard_Client1`
    FOREIGN KEY (`Id_Client`)
    REFERENCES `mydb`.`Client` (`Id_Client`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Client_has_Yard_Yard1`
    FOREIGN KEY (`Id_Yard`)
    REFERENCES `mydb`.`Yard` (`Id_Yard`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pitch_Staff1`
    FOREIGN KEY (`Id_Staff`)
    REFERENCES `mydb`.`Staff` (`Id_Staff`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pitch_Duration1`
    FOREIGN KEY (`Duration_idDuration`)
    REFERENCES `mydb`.`Duration` (`idDuration`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
