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
-- Table `mydb`.`StatusPitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`StatusPitch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`StatusPitch` (
  `Time` DATETIME NOT NULL,
  `Status` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Time`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Pitch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Pitch` (
  `IdPitch` INT NOT NULL,
  `Time` DATETIME NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Address` TEXT NULL,
  `Price` INT NULL,
  PRIMARY KEY (`IdPitch`),
  INDEX `fk_Pitch_StatusPitch1_idx` (`Time` ASC) VISIBLE,
  CONSTRAINT `fk_Pitch_StatusPitch1`
    FOREIGN KEY (`Time`)
    REFERENCES `mydb`.`StatusPitch` (`Time`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`User` ;

CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `IdUser` INT NOT NULL,
  `UserName` VARCHAR(45) NULL,
  `Name` VARCHAR(45) NULL,
  `PhoneNumber` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  PRIMARY KEY (`IdUser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`StatusOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`StatusOrder` ;

CREATE TABLE IF NOT EXISTS `mydb`.`StatusOrder` (
  `IdStatusOrder` INT NOT NULL,
  `Description` VARCHAR(45) NULL,
  PRIMARY KEY (`IdStatusOrder`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Order` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Order` (
  `IdOrder` INT NOT NULL,
  `IdUser` INT NOT NULL,
  `IdPitch` INT NOT NULL,
  `IdStatusOrder` INT NOT NULL,
  `TimeOrder` VARCHAR(45) NULL,
  PRIMARY KEY (`IdOrder`),
  INDEX `fk_Order_User_idx` (`IdUser` ASC) VISIBLE,
  INDEX `fk_Order_Pitch1_idx` (`IdPitch` ASC) VISIBLE,
  INDEX `fk_Order_StatusOrder1_idx` (`IdStatusOrder` ASC) VISIBLE,
  CONSTRAINT `fk_Order_User`
    FOREIGN KEY (`IdUser`)
    REFERENCES `mydb`.`User` (`IdUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Pitch1`
    FOREIGN KEY (`IdPitch`)
    REFERENCES `mydb`.`Pitch` (`IdPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_StatusOrder1`
    FOREIGN KEY (`IdStatusOrder`)
    REFERENCES `mydb`.`StatusOrder` (`IdStatusOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Bill` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Bill` (
  `IdBill` INT NOT NULL,
  `TimeCreated` VARCHAR(45) NULL,
  `Order_IdOrder` INT NOT NULL,
  PRIMARY KEY (`IdBill`),
  INDEX `fk_Bill_Order1_idx` (`Order_IdOrder` ASC) VISIBLE,
  CONSTRAINT `fk_Bill_Order1`
    FOREIGN KEY (`Order_IdOrder`)
    REFERENCES `mydb`.`Order` (`IdOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FeedBack`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`FeedBack` ;

CREATE TABLE IF NOT EXISTS `mydb`.`FeedBack` (
  `IdFeedBack` INT NOT NULL,
  `Comment` TEXT NULL,
  PRIMARY KEY (`IdFeedBack`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FeedBackOfUsers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`FeedBackOfUsers` ;

CREATE TABLE IF NOT EXISTS `mydb`.`FeedBackOfUsers` (
  `IdUser` INT NOT NULL,
  `IdFeedBack` INT NOT NULL,
  PRIMARY KEY (`IdUser`, `IdFeedBack`),
  INDEX `fk_User_has_FeedBack_FeedBack1_idx` (`IdFeedBack` ASC) VISIBLE,
  INDEX `fk_User_has_FeedBack_User1_idx` (`IdUser` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_FeedBack_User1`
    FOREIGN KEY (`IdUser`)
    REFERENCES `mydb`.`User` (`IdUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_FeedBack_FeedBack1`
    FOREIGN KEY (`IdFeedBack`)
    REFERENCES `mydb`.`FeedBack` (`IdFeedBack`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
