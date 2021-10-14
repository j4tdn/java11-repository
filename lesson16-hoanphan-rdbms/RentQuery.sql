-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema rent_pitches
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `rent_pitches` ;

-- -----------------------------------------------------
-- Schema rent_pitches
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rent_pitches` DEFAULT CHARACTER SET utf8 ;
USE `rent_pitches` ;

-- -----------------------------------------------------
-- Table `rent_pitches`.`Owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rent_pitches`.`Owner` ;

CREATE TABLE IF NOT EXISTS `rent_pitches`.`Owner` (
  `idOwner` INT NOT NULL,
  `Name` VARCHAR(255) NULL,
  `Sdt` VARCHAR(45) NULL,
  PRIMARY KEY (`idOwner`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rent_pitches`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rent_pitches`.`User` ;

CREATE TABLE IF NOT EXISTS `rent_pitches`.`User` (
  `idUser` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `sdt` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `Diachi` TEXT NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rent_pitches`.`TypePitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rent_pitches`.`TypePitch` ;

CREATE TABLE IF NOT EXISTS `rent_pitches`.`TypePitch` (
  `idTypePitch` INT NOT NULL,
  `NameTypePitch` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTypePitch`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rent_pitches`.`Pitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rent_pitches`.`Pitch` ;

CREATE TABLE IF NOT EXISTS `rent_pitches`.`Pitch` (
  `idPitch` INT NOT NULL,
  `Status` VARCHAR(45) NULL,
  `DiaChi` VARCHAR(45) NULL,
  `idOwner` INT NOT NULL,
  `idTypePitch` INT NOT NULL,
  PRIMARY KEY (`idPitch`),
  INDEX `fk_Pitch_Owner_idx` (`idOwner` ASC) VISIBLE,
  INDEX `fk_Pitch_TypePitch1_idx` (`idTypePitch` ASC) VISIBLE,
  CONSTRAINT `fk_Pitch_Owner`
    FOREIGN KEY (`idOwner`)
    REFERENCES `rent_pitches`.`Owner` (`idOwner`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pitch_TypePitch1`
    FOREIGN KEY (`idTypePitch`)
    REFERENCES `rent_pitches`.`TypePitch` (`idTypePitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rent_pitches`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rent_pitches`.`Order` ;

CREATE TABLE IF NOT EXISTS `rent_pitches`.`Order` (
  `idOrder` INT ZEROFILL NOT NULL,
  `RentTime` VARCHAR(45) NOT NULL,
  `TotalPrice` VARCHAR(45) NOT NULL,
  `idOwner` INT NOT NULL,
  `idUser` INT NOT NULL,
  PRIMARY KEY (`idOrder`),
  INDEX `fk_Order_Owner1_idx` (`idOwner` ASC) VISIBLE,
  INDEX `fk_Order_User1_idx` (`idUser` ASC) VISIBLE,
  CONSTRAINT `fk_Order_Owner1`
    FOREIGN KEY (`idOwner`)
    REFERENCES `rent_pitches`.`Owner` (`idOwner`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_User1`
    FOREIGN KEY (`idUser`)
    REFERENCES `rent_pitches`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rent_pitches`.`DetailRent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rent_pitches`.`DetailRent` ;

CREATE TABLE IF NOT EXISTS `rent_pitches`.`DetailRent` (
  `idOrder` INT ZEROFILL NOT NULL,
  `idPitch` INT NOT NULL,
  `discount` VARCHAR(45) NULL,
  `FullFee` VARCHAR(45) NULL,
  PRIMARY KEY (`idOrder`, `idPitch`),
  INDEX `fk_Order_has_Pitch_Pitch1_idx` (`idPitch` ASC) VISIBLE,
  INDEX `fk_Order_has_Pitch_Order1_idx` (`idOrder` ASC) VISIBLE,
  CONSTRAINT `fk_Order_has_Pitch_Order1`
    FOREIGN KEY (`idOrder`)
    REFERENCES `rent_pitches`.`Order` (`idOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_has_Pitch_Pitch1`
    FOREIGN KEY (`idPitch`)
    REFERENCES `rent_pitches`.`Pitch` (`idPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rent_pitches`.`Feedback`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rent_pitches`.`Feedback` ;

CREATE TABLE IF NOT EXISTS `rent_pitches`.`Feedback` (
  `idUser` INT NOT NULL,
  `idOwner` INT NOT NULL,
  `start` INT NULL,
  `comment` TEXT NULL,
  PRIMARY KEY (`idUser`, `idOwner`),
  INDEX `fk_User_has_Owner_Owner1_idx` (`idOwner` ASC) VISIBLE,
  INDEX `fk_User_has_Owner_User1_idx` (`idUser` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Owner_User1`
    FOREIGN KEY (`idUser`)
    REFERENCES `rent_pitches`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Owner_Owner1`
    FOREIGN KEY (`idOwner`)
    REFERENCES `rent_pitches`.`Owner` (`idOwner`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
