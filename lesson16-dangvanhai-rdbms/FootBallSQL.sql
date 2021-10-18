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
-- Table `mydb`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`role` ;

CREATE TABLE IF NOT EXISTS `mydb`.`role` (
  `id_role` INT NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`user` ;

CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `user_name` INT NOT NULL,
  `id_role` INT NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `full_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `phone_number` VARCHAR(20) NULL,
  `dob` DATE NULL,
  PRIMARY KEY (`user_name`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE,
  INDEX `fk_user_role_idx` (`id_role` ASC) VISIBLE,
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`id_role`)
    REFERENCES `mydb`.`role` (`id_role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`team` ;

CREATE TABLE IF NOT EXISTS `mydb`.`team` (
  `id_team` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_team`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`team_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`team_member` ;

CREATE TABLE IF NOT EXISTS `mydb`.`team_member` (
  `id_team` INT NOT NULL,
  `user_name` INT NOT NULL,
  `join_date` DATE NOT NULL,
  PRIMARY KEY (`join_date`),
  INDEX `fk_team_member_team1_idx` (`id_team` ASC) VISIBLE,
  INDEX `fk_team_member_user1_idx` (`user_name` ASC) VISIBLE,
  CONSTRAINT `fk_team_member_team1`
    FOREIGN KEY (`id_team`)
    REFERENCES `mydb`.`team` (`id_team`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_team_member_user1`
    FOREIGN KEY (`user_name`)
    REFERENCES `mydb`.`user` (`user_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`football_pitch_branch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`football_pitch_branch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`football_pitch_branch` (
  `id_football_pitch_branch` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  `address` VARCHAR(45) NOT NULL,
  `hotline` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_football_pitch_branch`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pitch_branch_manager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`pitch_branch_manager` ;

CREATE TABLE IF NOT EXISTS `mydb`.`pitch_branch_manager` (
  `description` VARCHAR(100) NOT NULL,
  `user_name` INT NOT NULL,
  `id_football_pitch_branch` INT NOT NULL,
  INDEX `fk_pitch_branch_manager_user1_idx` (`user_name` ASC) VISIBLE,
  INDEX `fk_pitch_branch_manager_football_pitch_branch1_idx` (`id_football_pitch_branch` ASC) VISIBLE,
  PRIMARY KEY (`user_name`, `id_football_pitch_branch`),
  CONSTRAINT `fk_pitch_branch_manager_user1`
    FOREIGN KEY (`user_name`)
    REFERENCES `mydb`.`user` (`user_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pitch_branch_manager_football_pitch_branch1`
    FOREIGN KEY (`id_football_pitch_branch`)
    REFERENCES `mydb`.`football_pitch_branch` (`id_football_pitch_branch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`football_pitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`football_pitch` ;

CREATE TABLE IF NOT EXISTS `mydb`.`football_pitch` (
  `id_football_pitch` INT NOT NULL,
  `id_football_pitch_branch` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id_football_pitch`),
  INDEX `fk_football_pitch_football_pitch_branch1_idx` (`id_football_pitch_branch` ASC) VISIBLE,
  CONSTRAINT `fk_football_pitch_football_pitch_branch1`
    FOREIGN KEY (`id_football_pitch_branch`)
    REFERENCES `mydb`.`football_pitch_branch` (`id_football_pitch_branch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`football_match`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`football_match` ;

CREATE TABLE IF NOT EXISTS `mydb`.`football_match` (
  `id_football_match` INT NOT NULL,
  `team_id_team1` INT NOT NULL,
  `team_id_team2` INT NOT NULL,
  `id_football_pitch` INT NOT NULL,
  `id_service_order` INT NOT NULL,
  `description` INT NULL,
  `score_team_1` INT NOT NULL DEFAULT 0,
  `score_team_2` INT NOT NULL DEFAULT 0,
  `id_user_order` INT NOT NULL,
  INDEX `fk_football_match_team1_idx` (`team_id_team2` ASC) VISIBLE,
  INDEX `fk_football_match_team2_idx` (`team_id_team1` ASC) VISIBLE,
  INDEX `fk_football_match_football_pitch1_idx` (`id_football_pitch` ASC) VISIBLE,
  PRIMARY KEY (`id_football_match`, `team_id_team1`, `team_id_team2`),
  UNIQUE INDEX `id_football_match_UNIQUE` (`id_football_match` ASC) VISIBLE,
  INDEX `fk_football_match_user1_idx` (`id_user_order` ASC) VISIBLE,
  CONSTRAINT `fk_football_match_team1`
    FOREIGN KEY (`team_id_team2`)
    REFERENCES `mydb`.`team` (`id_team`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_football_match_team2`
    FOREIGN KEY (`team_id_team1`)
    REFERENCES `mydb`.`team` (`id_team`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_football_match_football_pitch1`
    FOREIGN KEY (`id_football_pitch`)
    REFERENCES `mydb`.`football_pitch` (`id_football_pitch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_football_match_user1`
    FOREIGN KEY (`id_user_order`)
    REFERENCES `mydb`.`user` (`user_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`service` ;

CREATE TABLE IF NOT EXISTS `mydb`.`service` (
  `id_service` INT NOT NULL,
  `id_football_pitch_branch` INT NOT NULL,
  `price` DOUBLE NOT NULL,
  `description` TEXT NOT NULL,
  INDEX `fk_service_football_pitch_branch1_idx` (`id_football_pitch_branch` ASC) VISIBLE,
  PRIMARY KEY (`id_service`),
  CONSTRAINT `fk_service_football_pitch_branch1`
    FOREIGN KEY (`id_football_pitch_branch`)
    REFERENCES `mydb`.`football_pitch_branch` (`id_football_pitch_branch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`service_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`service_order` ;

CREATE TABLE IF NOT EXISTS `mydb`.`service_order` (
  `description` VARCHAR(45) NULL,
  `id_football_match` INT NOT NULL,
  `id_service` INT NOT NULL,
  INDEX `fk_service_order_football_match1_idx` (`id_football_match` ASC) VISIBLE,
  INDEX `fk_service_order_service1_idx` (`id_service` ASC) VISIBLE,
  PRIMARY KEY (`id_football_match`, `id_service`),
  CONSTRAINT `fk_service_order_football_match1`
    FOREIGN KEY (`id_football_match`)
    REFERENCES `mydb`.`football_match` (`id_football_match`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_order_service1`
    FOREIGN KEY (`id_service`)
    REFERENCES `mydb`.`service` (`id_service`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`football_match_bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`football_match_bill` ;

CREATE TABLE IF NOT EXISTS `mydb`.`football_match_bill` (
  `id_football_match_bill` INT NOT NULL,
  `id_football_match` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  `export_date` DATE NOT NULL,
  `total_price` DOUBLE NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_football_match_bill`),
  INDEX `fk_football_match_bill_football_match1_idx` (`id_football_match` ASC) VISIBLE,
  CONSTRAINT `fk_football_match_bill_football_match1`
    FOREIGN KEY (`id_football_match`)
    REFERENCES `mydb`.`football_match` (`id_football_match`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`feedback`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`feedback` ;

CREATE TABLE IF NOT EXISTS `mydb`.`feedback` (
  `user_name` INT NOT NULL,
  `id_football_match` INT NOT NULL,
  `content` TEXT NOT NULL,
  `score` INT NOT NULL,
  INDEX `fk_feedback_user1_idx` (`user_name` ASC) VISIBLE,
  INDEX `fk_feedback_football_match1_idx` (`id_football_match` ASC) VISIBLE,
  PRIMARY KEY (`user_name`, `id_football_match`),
  CONSTRAINT `fk_feedback_user1`
    FOREIGN KEY (`user_name`)
    REFERENCES `mydb`.`user` (`user_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_feedback_football_match1`
    FOREIGN KEY (`id_football_match`)
    REFERENCES `mydb`.`football_match` (`id_football_match`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
