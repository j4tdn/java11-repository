-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema java11_soccer_yard_manager
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `java11_soccer_yard_manager` ;

-- -----------------------------------------------------
-- Schema java11_soccer_yard_manager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `java11_soccer_yard_manager` DEFAULT CHARACTER SET utf8 ;
USE `java11_soccer_yard_manager` ;

-- -----------------------------------------------------
-- Table `java11_soccer_yard_manager`.`yard_owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_soccer_yard_manager`.`yard_owner` ;

CREATE TABLE IF NOT EXISTS `java11_soccer_yard_manager`.`yard_owner` (
  `IdOwner` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `PhoneNumber` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`IdOwner`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_soccer_yard_manager`.`yard_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_soccer_yard_manager`.`yard_status` ;

CREATE TABLE IF NOT EXISTS `java11_soccer_yard_manager`.`yard_status` (
  `IdStatus` VARCHAR(25) NOT NULL,
  `Description` TEXT NOT NULL,
  PRIMARY KEY (`IdStatus`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_soccer_yard_manager`.`service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_soccer_yard_manager`.`service` ;

CREATE TABLE IF NOT EXISTS `java11_soccer_yard_manager`.`service` (
  `IdService` INT NOT NULL,
  `Description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`IdService`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_soccer_yard_manager`.`yard`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_soccer_yard_manager`.`yard` ;

CREATE TABLE IF NOT EXISTS `java11_soccer_yard_manager`.`yard` (
  `IdYard` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `Address` VARCHAR(522) NOT NULL,
  `IdOwner` INT NOT NULL,
  `IdStatus` VARCHAR(25) NOT NULL,
  `IdService` INT NOT NULL,
  PRIMARY KEY (`IdYard`),
  INDEX `fk_yard_yard_owner1_idx` (`IdOwner` ASC) VISIBLE,
  INDEX `fk_yard_yard_status1_idx` (`IdStatus` ASC) VISIBLE,
  INDEX `fk_yard_service1_idx` (`IdService` ASC) VISIBLE,
  CONSTRAINT `fk_yard_yard_owner1`
    FOREIGN KEY (`IdOwner`)
    REFERENCES `java11_soccer_yard_manager`.`yard_owner` (`IdOwner`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_yard_yard_status1`
    FOREIGN KEY (`IdStatus`)
    REFERENCES `java11_soccer_yard_manager`.`yard_status` (`IdStatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_yard_service1`
    FOREIGN KEY (`IdService`)
    REFERENCES `java11_soccer_yard_manager`.`service` (`IdService`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_soccer_yard_manager`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_soccer_yard_manager`.`customer` ;

CREATE TABLE IF NOT EXISTS `java11_soccer_yard_manager`.`customer` (
  `IdCustomer` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `PhoneNumber` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(64) NOT NULL,
  `SocialNetwork` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`IdCustomer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_soccer_yard_manager`.`teams`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_soccer_yard_manager`.`teams` ;

CREATE TABLE IF NOT EXISTS `java11_soccer_yard_manager`.`teams` (
  `IdTeam` VARCHAR(10) NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `IdCustomer` INT NOT NULL,
  PRIMARY KEY (`IdTeam`),
  INDEX `fk_teams_customer_idx` (`IdCustomer` ASC) VISIBLE,
  CONSTRAINT `fk_teams_customer`
    FOREIGN KEY (`IdCustomer`)
    REFERENCES `java11_soccer_yard_manager`.`customer` (`IdCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_soccer_yard_manager`.`Duration`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_soccer_yard_manager`.`Duration` ;

CREATE TABLE IF NOT EXISTS `java11_soccer_yard_manager`.`Duration` (
  `IdDuration` INT NOT NULL,
  `TimeStart` DATETIME NOT NULL,
  `TimeEnd` DATETIME NOT NULL,
  PRIMARY KEY (`IdDuration`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `java11_soccer_yard_manager`.`yard_order_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java11_soccer_yard_manager`.`yard_order_details` ;

CREATE TABLE IF NOT EXISTS `java11_soccer_yard_manager`.`yard_order_details` (
  `IdDuration` INT NOT NULL,
  `IdYard` INT NOT NULL,
  `IdTeam1` VARCHAR(10) NOT NULL,
  `IdTeam2` VARCHAR(10) NOT NULL,
  `Cost` DOUBLE NOT NULL,
  PRIMARY KEY (`IdDuration`, `IdYard`),
  INDEX `fk_Duration_has_yard_yard1_idx` (`IdYard` ASC) VISIBLE,
  INDEX `fk_Duration_has_yard_Duration1_idx` (`IdDuration` ASC) VISIBLE,
  INDEX `fk_Duration_has_yard_teams1_idx` (`IdTeam1` ASC) VISIBLE,
  INDEX `fk_Duration_has_yard_teams2_idx` (`IdTeam2` ASC) VISIBLE,
  CONSTRAINT `fk_Duration_has_yard_Duration1`
    FOREIGN KEY (`IdDuration`)
    REFERENCES `java11_soccer_yard_manager`.`Duration` (`IdDuration`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Duration_has_yard_yard1`
    FOREIGN KEY (`IdYard`)
    REFERENCES `java11_soccer_yard_manager`.`yard` (`IdYard`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Duration_has_yard_teams1`
    FOREIGN KEY (`IdTeam1`)
    REFERENCES `java11_soccer_yard_manager`.`teams` (`IdTeam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Duration_has_yard_teams2`
    FOREIGN KEY (`IdTeam2`)
    REFERENCES `java11_soccer_yard_manager`.`teams` (`IdTeam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
