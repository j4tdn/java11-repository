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
  `CustomerID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(45) NULL,
  `PhoneNumber` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CustomerID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FootballPitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`FootballPitch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`FootballPitch` (
  `PitchID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Type` VARCHAR(45) NOT NULL,
  `Price` DOUBLE NOT NULL,
  `CustomerID` INT NOT NULL,
  PRIMARY KEY (`PitchID`),
  INDEX `fk_FootballPitch_Customer1_idx` (`CustomerID` ASC) VISIBLE,
  CONSTRAINT `fk_FootballPitch_Customer1`
    FOREIGN KEY (`CustomerID`)
    REFERENCES `mydb`.`Customer` (`CustomerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Team` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Team` (
  `TeamID` VARCHAR(45) NOT NULL,
  `TeamName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`TeamID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TeamMember`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TeamMember` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TeamMember` (
  `Customer_CustomerID` INT NOT NULL,
  `Team_TeamID` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Customer_CustomerID`, `Team_TeamID`),
  INDEX `fk_Customer_has_Team_Team1_idx` (`Team_TeamID` ASC) VISIBLE,
  INDEX `fk_Customer_has_Team_Customer_idx` (`Customer_CustomerID` ASC) VISIBLE,
  CONSTRAINT `fk_Customer_has_Team_Customer`
    FOREIGN KEY (`Customer_CustomerID`)
    REFERENCES `mydb`.`Customer` (`CustomerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Customer_has_Team_Team1`
    FOREIGN KEY (`Team_TeamID`)
    REFERENCES `mydb`.`Team` (`TeamID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PitchStatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PitchStatus` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PitchStatus` (
  `PitchID` INT NOT NULL,
  `Status` VARCHAR(45) NOT NULL,
  `TimeStart` DATETIME NOT NULL,
  `TimeEnd` DATETIME NULL,
  INDEX `fk_PitchStatus_FootballPitch1_idx` (`PitchID` ASC) VISIBLE,
  CONSTRAINT `fk_PitchStatus_FootballPitch1`
    FOREIGN KEY (`PitchID`)
    REFERENCES `mydb`.`FootballPitch` (`PitchID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Owner` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Owner` (
  `OwnerID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `PhoneNumber` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`OwnerID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Employee` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Employee` (
  `EmployeeID` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `PhoneNumber` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  PRIMARY KEY (`EmployeeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FootballCenter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`FootballCenter` ;

CREATE TABLE IF NOT EXISTS `mydb`.`FootballCenter` (
  `OwnerID` INT NOT NULL,
  `PitchID` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Address` VARCHAR(45) NULL,
  `PhoneNumber` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `EmployeeID` INT NOT NULL,
  PRIMARY KEY (`OwnerID`, `PitchID`),
  INDEX `fk_Owner_has_FootballPitch_FootballPitch1_idx` (`PitchID` ASC) VISIBLE,
  INDEX `fk_Owner_has_FootballPitch_Owner1_idx` (`OwnerID` ASC) VISIBLE,
  INDEX `fk_FootballCenter_Employee1_idx` (`EmployeeID` ASC) VISIBLE,
  CONSTRAINT `fk_Owner_has_FootballPitch_Owner1`
    FOREIGN KEY (`OwnerID`)
    REFERENCES `mydb`.`Owner` (`OwnerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Owner_has_FootballPitch_FootballPitch1`
    FOREIGN KEY (`PitchID`)
    REFERENCES `mydb`.`FootballPitch` (`PitchID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FootballCenter_Employee1`
    FOREIGN KEY (`EmployeeID`)
    REFERENCES `mydb`.`Employee` (`EmployeeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
