-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema java11_footballfieldbooking
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `java11_footballfieldbooking` ;

-- -----------------------------------------------------
-- Schema java11_footballfieldbooking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `java11_footballfieldbooking` DEFAULT CHARACTER SET utf8 ;
USE `java11_footballfieldbooking` ;

-- -----------------------------------------------------
-- Table `java11_footballfieldbooking`.`Owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_footballfieldbooking`.`Owner` ;

CREATE TABLE IF NOT EXISTS `java11_footballfieldbooking`.`Owner` (
  `OwnerID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `PhoneNumber` VARCHAR(20) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`OwnerID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_footballfieldbooking`.`FootballCenter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_footballfieldbooking`.`FootballCenter` ;

CREATE TABLE IF NOT EXISTS `java11_footballfieldbooking`.`FootballCenter` (
  `FootballCenterID` INT NOT NULL,
  `Address` VARCHAR(100) NOT NULL,
  `NumberOfFields` INT NOT NULL,
  `OwnerID` INT NOT NULL,
  PRIMARY KEY (`FootballCenterID`),
  INDEX `fk_FootballCenter_Owner_idx` (`OwnerID` ASC) VISIBLE,
  CONSTRAINT `fk_FootballCenter_Owner`
    FOREIGN KEY (`OwnerID`)
    REFERENCES `java11_footballfieldbooking`.`Owner` (`OwnerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_footballfieldbooking`.`FieldType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_footballfieldbooking`.`FieldType` ;

CREATE TABLE IF NOT EXISTS `java11_footballfieldbooking`.`FieldType` (
  `FieldTypeID` INT NOT NULL,
  `Size` INT NOT NULL,
  `GrassType` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`FieldTypeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_footballfieldbooking`.`FootballField`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_footballfieldbooking`.`FootballField` ;

CREATE TABLE IF NOT EXISTS `java11_footballfieldbooking`.`FootballField` (
  `FootballFieldID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Rating` DOUBLE NOT NULL,
  `FootballCenterID` INT NOT NULL,
  `FieldTypeID` INT NOT NULL,
  PRIMARY KEY (`FootballFieldID`),
  INDEX `fk_FootballField_FootballCenter1_idx` (`FootballCenterID` ASC) VISIBLE,
  INDEX `fk_FootballField_FieldType1_idx` (`FieldTypeID` ASC) VISIBLE,
  CONSTRAINT `fk_FootballField_FootballCenter1`
    FOREIGN KEY (`FootballCenterID`)
    REFERENCES `java11_footballfieldbooking`.`FootballCenter` (`FootballCenterID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FootballField_FieldType1`
    FOREIGN KEY (`FieldTypeID`)
    REFERENCES `java11_footballfieldbooking`.`FieldType` (`FieldTypeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_footballfieldbooking`.`Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_footballfieldbooking`.`Employee` ;

CREATE TABLE IF NOT EXISTS `java11_footballfieldbooking`.`Employee` (
  `EmployeeID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `PhoneNumber` VARCHAR(20) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `FootballCenterID` INT NOT NULL,
  PRIMARY KEY (`EmployeeID`),
  INDEX `fk_Employee_FootballCenter1_idx` (`FootballCenterID` ASC) VISIBLE,
  CONSTRAINT `fk_Employee_FootballCenter1`
    FOREIGN KEY (`FootballCenterID`)
    REFERENCES `java11_footballfieldbooking`.`FootballCenter` (`FootballCenterID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_footballfieldbooking`.`Service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_footballfieldbooking`.`Service` ;

CREATE TABLE IF NOT EXISTS `java11_footballfieldbooking`.`Service` (
  `ServiceID` INT NOT NULL,
  `ServiceName` VARCHAR(45) NOT NULL,
  `Price` DOUBLE NOT NULL,
  `FootballFieldID` INT NOT NULL,
  PRIMARY KEY (`ServiceID`),
  INDEX `fk_Service_FootballField1_idx` (`FootballFieldID` ASC) VISIBLE,
  CONSTRAINT `fk_Service_FootballField1`
    FOREIGN KEY (`FootballFieldID`)
    REFERENCES `java11_footballfieldbooking`.`FootballField` (`FootballFieldID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_footballfieldbooking`.`FootballTeam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_footballfieldbooking`.`FootballTeam` ;

CREATE TABLE IF NOT EXISTS `java11_footballfieldbooking`.`FootballTeam` (
  `FootballTeamID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `NumberOfMembers` INT NOT NULL,
  PRIMARY KEY (`FootballTeamID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_footballfieldbooking`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_footballfieldbooking`.`User` ;

CREATE TABLE IF NOT EXISTS `java11_footballfieldbooking`.`User` (
  `UserID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `PhoneNumber` VARCHAR(20) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UserID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_footballfieldbooking`.`FootballTeamDetail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_footballfieldbooking`.`FootballTeamDetail` ;

CREATE TABLE IF NOT EXISTS `java11_footballfieldbooking`.`FootballTeamDetail` (
  `FootballTeamID` INT NOT NULL,
  `UserID` INT NOT NULL,
  PRIMARY KEY (`FootballTeamID`, `UserID`),
  INDEX `fk_FootballTeam_has_User_User1_idx` (`UserID` ASC) VISIBLE,
  INDEX `fk_FootballTeam_has_User_FootballTeam1_idx` (`FootballTeamID` ASC) VISIBLE,
  CONSTRAINT `fk_FootballTeam_has_User_FootballTeam1`
    FOREIGN KEY (`FootballTeamID`)
    REFERENCES `java11_footballfieldbooking`.`FootballTeam` (`FootballTeamID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FootballTeam_has_User_User1`
    FOREIGN KEY (`UserID`)
    REFERENCES `java11_footballfieldbooking`.`User` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_footballfieldbooking`.`Booking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_footballfieldbooking`.`Booking` ;

CREATE TABLE IF NOT EXISTS `java11_footballfieldbooking`.`Booking` (
  `BookingID` INT NOT NULL,
  `UserID` INT NOT NULL,
  PRIMARY KEY (`BookingID`),
  INDEX `fk_Booking_User1_idx` (`UserID` ASC) VISIBLE,
  CONSTRAINT `fk_Booking_User1`
    FOREIGN KEY (`UserID`)
    REFERENCES `java11_footballfieldbooking`.`User` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_footballfieldbooking`.`Time`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_footballfieldbooking`.`Time` ;

CREATE TABLE IF NOT EXISTS `java11_footballfieldbooking`.`Time` (
  `TimeID` INT NOT NULL,
  `StartTime` DATETIME NULL,
  `EndTime` DATETIME NULL,
  PRIMARY KEY (`TimeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_footballfieldbooking`.`BookingDetail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_footballfieldbooking`.`BookingDetail` ;

CREATE TABLE IF NOT EXISTS `java11_footballfieldbooking`.`BookingDetail` (
  `FootballFieldID` INT NOT NULL,
  `BookingID` INT NOT NULL,
  `TimeID` INT NOT NULL,
  `FootballTeamID` INT NOT NULL,
  PRIMARY KEY (`FootballFieldID`, `BookingID`),
  INDEX `fk_FootballField_has_Booking_Booking1_idx` (`BookingID` ASC) VISIBLE,
  INDEX `fk_FootballField_has_Booking_FootballField1_idx` (`FootballFieldID` ASC) VISIBLE,
  INDEX `fk_BookingDetail_Duration1_idx` (`TimeID` ASC) VISIBLE,
  INDEX `fk_BookingDetail_FootballTeam1_idx` (`FootballTeamID` ASC) VISIBLE,
  CONSTRAINT `fk_FootballField_has_Booking_FootballField1`
    FOREIGN KEY (`FootballFieldID`)
    REFERENCES `java11_footballfieldbooking`.`FootballField` (`FootballFieldID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FootballField_has_Booking_Booking1`
    FOREIGN KEY (`BookingID`)
    REFERENCES `java11_footballfieldbooking`.`Booking` (`BookingID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BookingDetail_Duration1`
    FOREIGN KEY (`TimeID`)
    REFERENCES `java11_footballfieldbooking`.`Time` (`TimeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BookingDetail_FootballTeam1`
    FOREIGN KEY (`FootballTeamID`)
    REFERENCES `java11_footballfieldbooking`.`FootballTeam` (`FootballTeamID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_footballfieldbooking`.`Message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_footballfieldbooking`.`Message` ;

CREATE TABLE IF NOT EXISTS `java11_footballfieldbooking`.`Message` (
  `MessageID` INT NOT NULL,
  `Content` VARCHAR(200) NOT NULL,
  `UserID` INT NOT NULL,
  PRIMARY KEY (`MessageID`),
  INDEX `fk_Message_User1_idx` (`UserID` ASC) VISIBLE,
  CONSTRAINT `fk_Message_User1`
    FOREIGN KEY (`UserID`)
    REFERENCES `java11_footballfieldbooking`.`User` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
