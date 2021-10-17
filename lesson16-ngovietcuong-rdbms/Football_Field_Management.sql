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
-- Table `football_field_management`.`Position`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`Position` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`Position` (
  `idPosition` INT NOT NULL,
  `NamePosition` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPosition`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`Staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`Staff` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`Staff` (
  `idStaff` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `PhoneNumber` INT NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `idPosition` INT NOT NULL,
  PRIMARY KEY (`idStaff`),
  INDEX `fk_Staff_Position_idx` (`idPosition` ASC) VISIBLE,
  CONSTRAINT `fk_Staff_Position`
    FOREIGN KEY (`idPosition`)
    REFERENCES `football_field_management`.`Position` (`idPosition`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`Member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`Member` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`Member` (
  `idMember` INT NOT NULL,
  `UserName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMember`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`Football Team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`Football Team` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`Football Team` (
  `idFootball Team` INT NOT NULL,
  `NameTeam` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFootball Team`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`Customer` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`Customer` (
  `idCustomer` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `PhoneNumber` INT NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `idMember` INT NOT NULL,
  `idFootball Team` INT NOT NULL,
  PRIMARY KEY (`idCustomer`),
  INDEX `fk_Customer_Member1_idx` (`idMember` ASC) VISIBLE,
  INDEX `fk_Customer_Football Team1_idx` (`idFootball Team` ASC) VISIBLE,
  CONSTRAINT `fk_Customer_Member1`
    FOREIGN KEY (`idMember`)
    REFERENCES `football_field_management`.`Member` (`idMember`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Customer_Football Team1`
    FOREIGN KEY (`idFootball Team`)
    REFERENCES `football_field_management`.`Football Team` (`idFootball Team`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`Service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`Service` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`Service` (
  `idService` INT NOT NULL,
  `NameService` VARCHAR(45) NOT NULL,
  `PriceService` INT NOT NULL,
  PRIMARY KEY (`idService`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`TypeFootballPitches`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`TypeFootballPitches` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`TypeFootballPitches` (
  `idTypeFootballPitches` INT NOT NULL,
  `NameType` VARCHAR(45) NULL,
  `PriceTypePitches` INT NULL,
  PRIMARY KEY (`idTypeFootballPitches`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`FootballPitches`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`FootballPitches` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`FootballPitches` (
  `idFootballPitches` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `idTypeFootballPitches` INT NOT NULL,
  PRIMARY KEY (`idFootballPitches`),
  INDEX `fk_FootballPitches_TypeFootballPitches1_idx` (`idTypeFootballPitches` ASC) VISIBLE,
  CONSTRAINT `fk_FootballPitches_TypeFootballPitches1`
    FOREIGN KEY (`idTypeFootballPitches`)
    REFERENCES `football_field_management`.`TypeFootballPitches` (`idTypeFootballPitches`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`Time`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`Time` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`Time` (
  `idTime` INT NOT NULL,
  `TimeBeginMatch` DATETIME NOT NULL,
  `TimeEndMatch` DATETIME NOT NULL,
  PRIMARY KEY (`idTime`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`Order` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`Order` (
  `idOrder` INT NOT NULL,
  `TimeCreated` DATETIME NOT NULL,
  `TotalMoney` INT NOT NULL,
  `idCustomer` INT NOT NULL,
  `idService` INT NOT NULL,
  `idFootballPitches` INT NOT NULL,
  `idStaff` INT NOT NULL,
  `idTime` INT NOT NULL,
  PRIMARY KEY (`idOrder`),
  INDEX `fk_Order_Customer1_idx` (`idCustomer` ASC) VISIBLE,
  INDEX `fk_Order_Service1_idx` (`idService` ASC) VISIBLE,
  INDEX `fk_Order_FootballPitches1_idx` (`idFootballPitches` ASC) VISIBLE,
  INDEX `fk_Order_Staff1_idx` (`idStaff` ASC) VISIBLE,
  INDEX `fk_Order_Time1_idx` (`idTime` ASC) VISIBLE,
  CONSTRAINT `fk_Order_Customer1`
    FOREIGN KEY (`idCustomer`)
    REFERENCES `football_field_management`.`Customer` (`idCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Service1`
    FOREIGN KEY (`idService`)
    REFERENCES `football_field_management`.`Service` (`idService`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_FootballPitches1`
    FOREIGN KEY (`idFootballPitches`)
    REFERENCES `football_field_management`.`FootballPitches` (`idFootballPitches`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Staff1`
    FOREIGN KEY (`idStaff`)
    REFERENCES `football_field_management`.`Staff` (`idStaff`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Time1`
    FOREIGN KEY (`idTime`)
    REFERENCES `football_field_management`.`Time` (`idTime`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`Bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`Bill` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`Bill` (
  `idBill` INT NOT NULL,
  `TimeCreated` DATETIME NOT NULL,
  `MoneyPay` INT NOT NULL,
  `idOrder` INT NOT NULL,
  PRIMARY KEY (`idBill`),
  INDEX `fk_Bill_Order1_idx` (`idOrder` ASC) VISIBLE,
  CONSTRAINT `fk_Bill_Order1`
    FOREIGN KEY (`idOrder`)
    REFERENCES `football_field_management`.`Order` (`idOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`FeedBack`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`FeedBack` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`FeedBack` (
  `idFeedBack` INT NOT NULL,
  `Comment` VARCHAR(45) NOT NULL,
  `idMember` INT NOT NULL,
  PRIMARY KEY (`idFeedBack`),
  INDEX `fk_FeedBack_Member1_idx` (`idMember` ASC) VISIBLE,
  CONSTRAINT `fk_FeedBack_Member1`
    FOREIGN KEY (`idMember`)
    REFERENCES `football_field_management`.`Member` (`idMember`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `football_field_management`.`ListFootballMatches`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `football_field_management`.`ListFootballMatches` ;

CREATE TABLE IF NOT EXISTS `football_field_management`.`ListFootballMatches` (
  `idFootballTeam` INT NOT NULL,
  `idTime` INT NOT NULL,
  `idFootballPitches` INT NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFootballTeam`, `idTime`),
  INDEX `fk_Football Team_has_Time_Time1_idx` (`idTime` ASC) VISIBLE,
  INDEX `fk_Football Team_has_Time_Football Team1_idx` (`idFootballTeam` ASC) VISIBLE,
  INDEX `fk_ListFootballMatches_FootballPitches1_idx` (`idFootballPitches` ASC) VISIBLE,
  CONSTRAINT `fk_Football Team_has_Time_Football Team1`
    FOREIGN KEY (`idFootballTeam`)
    REFERENCES `football_field_management`.`Football Team` (`idFootball Team`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Football Team_has_Time_Time1`
    FOREIGN KEY (`idTime`)
    REFERENCES `football_field_management`.`Time` (`idTime`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ListFootballMatches_FootballPitches1`
    FOREIGN KEY (`idFootballPitches`)
    REFERENCES `football_field_management`.`FootballPitches` (`idFootballPitches`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
