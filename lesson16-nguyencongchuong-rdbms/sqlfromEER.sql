-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema football_field_management
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `football_field_management` ;

-- -----------------------------------------------------
-- Schema football_field_management
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `football_field_management` DEFAULT CHARACTER SET utf8 ;
USE `football_field_management` ;

-- -----------------------------------------------------
-- Table `football_field_management`.`Locality`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`Locality` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`Locality` (
  `idLocality` INT NOT NULL,
  `Ward` VARCHAR(255) NOT NULL,
  `District` VARCHAR(255) NOT NULL,
  `City` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idLocality`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`Customer` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`Customer` (
  `idCustomer` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `PhoneNumber` INT NOT NULL,
  `Address` VARCHAR(255) NOT NULL,
  `DateOfBirth` DATE NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `idLocality` INT NOT NULL,
  PRIMARY KEY (`idCustomer`),
  INDEX `fk_Customer_Locality1_idx` (`idLocality` ASC) VISIBLE,
  CONSTRAINT `fk_Customer_Locality1`
    FOREIGN KEY (`idLocality`)
    REFERENCES `football_field_management`.`Locality` (`idLocality`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`FootballTeam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`FootballTeam` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`FootballTeam` (
  `idTeam` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `PhoneNumber` INT NOT NULL,
  `Status` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idTeam`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`TeamMember`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`TeamMember` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`TeamMember` (
  `idCustomer` INT NOT NULL,
  `idTeam` INT NOT NULL,
  `Description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idCustomer`, `idTeam`),
  INDEX `fk_Customer_has_FootballTeam_FootballTeam1_idx` (`idTeam` ASC) VISIBLE,
  INDEX `fk_Customer_has_FootballTeam_Customer_idx` (`idCustomer` ASC) VISIBLE,
  CONSTRAINT `fk_Customer_has_FootballTeam_Customer`
    FOREIGN KEY (`idCustomer`)
    REFERENCES `football_field_management`.`Customer` (`idCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Customer_has_FootballTeam_FootballTeam1`
    FOREIGN KEY (`idTeam`)
    REFERENCES `football_field_management`.`FootballTeam` (`idTeam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`FootballPitches`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`FootballPitches` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`FootballPitches` (
  `idFootballPitches` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `PhoneNumber` INT NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `Address` VARCHAR(255) NOT NULL,
  `idLocality` INT NOT NULL,
  PRIMARY KEY (`idFootballPitches`),
  INDEX `fk_FootballPitches_Locality1_idx` (`idLocality` ASC) VISIBLE,
  CONSTRAINT `fk_FootballPitches_Locality1`
    FOREIGN KEY (`idLocality`)
    REFERENCES `football_field_management`.`Locality` (`idLocality`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`Position`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`Position` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`Position` (
  `idPosition` INT NOT NULL,
  `Description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idPosition`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`Staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`Staff` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`Staff` (
  `idStaff` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `PhoneNumber` INT NOT NULL,
  `Address` VARCHAR(255) NOT NULL,
  `idPosition` INT NOT NULL,
  PRIMARY KEY (`idStaff`),
  INDEX `fk_Staff_Position1_idx` (`idPosition` ASC) VISIBLE,
  CONSTRAINT `fk_Staff_Position1`
    FOREIGN KEY (`idPosition`)
    REFERENCES `football_field_management`.`Position` (`idPosition`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`ConditionFootballPitches`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`ConditionFootballPitches` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`ConditionFootballPitches` (
  `idCustomer` INT NOT NULL,
  `idFootballPitches` INT NOT NULL,
  `Description` VARCHAR(255) NOT NULL,
  `Comment` VARCHAR(255) NULL,
  `idStaff` INT NOT NULL,
  PRIMARY KEY (`idCustomer`, `idFootballPitches`),
  INDEX `fk_Customer_has_FootballPitches_FootballPitches1_idx` (`idFootballPitches` ASC) VISIBLE,
  INDEX `fk_Customer_has_FootballPitches_Customer1_idx` (`idCustomer` ASC) VISIBLE,
  INDEX `fk_ConditionFootballPitches_Staff1_idx` (`idStaff` ASC) VISIBLE,
  CONSTRAINT `fk_Customer_has_FootballPitches_Customer1`
    FOREIGN KEY (`idCustomer`)
    REFERENCES `football_field_management`.`Customer` (`idCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Customer_has_FootballPitches_FootballPitches1`
    FOREIGN KEY (`idFootballPitches`)
    REFERENCES `football_field_management`.`FootballPitches` (`idFootballPitches`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ConditionFootballPitches_Staff1`
    FOREIGN KEY (`idStaff`)
    REFERENCES `football_field_management`.`Staff` (`idStaff`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`SoccerMath`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`SoccerMath` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`SoccerMath` (
  `idTeam` INT NOT NULL,
  `idFootballPitches` INT NOT NULL,
  `Datetime` DATETIME NOT NULL,
  PRIMARY KEY (`idTeam`, `idFootballPitches`),
  INDEX `fk_FootballTeam_has_FootballPitches_FootballPitches1_idx` (`idFootballPitches` ASC) VISIBLE,
  INDEX `fk_FootballTeam_has_FootballPitches_FootballTeam1_idx` (`idTeam` ASC) VISIBLE,
  CONSTRAINT `fk_FootballTeam_has_FootballPitches_FootballTeam1`
    FOREIGN KEY (`idTeam`)
    REFERENCES `football_field_management`.`FootballTeam` (`idTeam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FootballTeam_has_FootballPitches_FootballPitches1`
    FOREIGN KEY (`idFootballPitches`)
    REFERENCES `football_field_management`.`FootballPitches` (`idFootballPitches`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;