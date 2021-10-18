-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema managefootballpitch
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema managefootballpitch
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `managefootballpitch` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `managefootballpitch` ;

-- -----------------------------------------------------
-- Table `managefootballpitch`.`staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `managefootballpitch`.`staff` (
  `idStaff` INT NOT NULL,
  `NameStaff` VARCHAR(45) NOT NULL,
  `PhoneNumber` VARCHAR(45) NULL DEFAULT NULL,
  `Address` VARCHAR(255) NOT NULL,
  `salary(VND/month)` DOUBLE NOT NULL,
  `gender` BIT(1) NULL DEFAULT NULL,
  `Description` VARCHAR(255) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idStaff`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `managefootballpitch`.`pitch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `managefootballpitch`.`pitch` (
  `idPitch` INT NOT NULL,
  `Address` VARCHAR(255) NOT NULL,
  `IDTime` INT NULL DEFAULT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `price(VND/h)` DOUBLE NOT NULL,
  `typePitch` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPitch`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `managefootballpitch`.`time`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `managefootballpitch`.`time` (
  `idTime` INT NOT NULL,
  `startTime` VARCHAR(45) NOT NULL,
  `endTime` VARCHAR(45) NULL DEFAULT NULL,
  `Status` INT NOT NULL,
  PRIMARY KEY (`idTime`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `managefootballpitch`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `managefootballpitch`.`customer` (
  `idCustomer` INT NOT NULL,
  `NameCustomer` VARCHAR(45) NOT NULL,
  `PhoneNumber` VARCHAR(45) NOT NULL,
  `owe` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCustomer`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `managefootballpitch`.`service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `managefootballpitch`.`service` (
  `idService` INT NOT NULL,
  `nameService` VARCHAR(255) NOT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`idService`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `managefootballpitch`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `managefootballpitch`.`order` (
  `idOrder` INT NOT NULL,
  `idPitch` INT NOT NULL,
  `idCustomer` INT NOT NULL,
  `IdTime` INT NOT NULL,
  `idService` INT NOT NULL,
  `TimeCreateOrder` DATETIME NOT NULL,
  `IDStaff` INT NOT NULL,
  PRIMARY KEY (`idOrder`),
  INDEX `fk_order_pitch_idx` (`idPitch` ASC) VISIBLE,
  INDEX `fk _order_time_idx` (`IdTime` ASC) VISIBLE,
  INDEX `fk_order_customer_idx` (`idCustomer` ASC) VISIBLE,
  INDEX `fk_order_service_idx` (`idService` ASC) VISIBLE,
  INDEX `fk_order_staff_idx` (`IDStaff` ASC) VISIBLE,
  CONSTRAINT `fk_order_pitch`
    FOREIGN KEY (`idPitch`)
    REFERENCES `managefootballpitch`.`pitch` (`idPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk _order_time`
    FOREIGN KEY (`IdTime`)
    REFERENCES `managefootballpitch`.`time` (`idTime`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_customer`
    FOREIGN KEY (`idCustomer`)
    REFERENCES `managefootballpitch`.`customer` (`idCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_service`
    FOREIGN KEY (`idService`)
    REFERENCES `managefootballpitch`.`service` (`idService`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_staff`
    FOREIGN KEY (`IDStaff`)
    REFERENCES `managefootballpitch`.`staff` (`idStaff`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `managefootballpitch`.`bill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `managefootballpitch`.`bill` (
  `idBill` INT NOT NULL,
  `idOrder` INT NOT NULL,
  `timeEnd` DATETIME NOT NULL,
  `idService` INT NOT NULL,
  `total(VND)` DOUBLE NOT NULL,
  `timeofBill` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idStaff` INT NOT NULL,
  PRIMARY KEY (`idBill`),
  INDEX `fk_bill_staff_idx` (`idStaff` ASC) VISIBLE,
  INDEX `gk_bill_order_idx` (`idOrder` ASC) VISIBLE,
  CONSTRAINT `fk_bill_staff`
    FOREIGN KEY (`idStaff`)
    REFERENCES `managefootballpitch`.`staff` (`idStaff`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `gk_bill_order`
    FOREIGN KEY (`idOrder`)
    REFERENCES `managefootballpitch`.`order` (`idOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `managefootballpitch`.`bill_has_service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `managefootballpitch`.`bill_has_service` (
  `bill_idBill` INT NOT NULL,
  `service_idService` INT NOT NULL,
  `number` INT NOT NULL,
  `cost` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`bill_idBill`, `service_idService`),
  INDEX `fk_bill_has_service_service1_idx` (`service_idService` ASC) VISIBLE,
  INDEX `fk_bill_has_service_bill1_idx` (`bill_idBill` ASC) VISIBLE,
  CONSTRAINT `fk_bill_has_service_bill1`
    FOREIGN KEY (`bill_idBill`)
    REFERENCES `managefootballpitch`.`bill` (`idBill`),
  CONSTRAINT `fk_bill_has_service_service1`
    FOREIGN KEY (`service_idService`)
    REFERENCES `managefootballpitch`.`service` (`idService`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `managefootballpitch`.`statuspitch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `managefootballpitch`.`statuspitch` (
  `idstatusPitch` INT NOT NULL,
  `idTeamA` INT NOT NULL,
  `idTeamB` INT NULL DEFAULT NULL,
  `statusPitch` INT NOT NULL,
  `IdPitch` INT NULL DEFAULT NULL,
  `Description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idstatusPitch`),
  INDEX `fk_status_pitch_idx` (`IdPitch` ASC) VISIBLE,
  CONSTRAINT `fk_status_pitch`
    FOREIGN KEY (`IdPitch`)
    REFERENCES `managefootballpitch`.`pitch` (`idPitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
