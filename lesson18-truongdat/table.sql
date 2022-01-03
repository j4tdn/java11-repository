-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hib_comman_cache
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hib_comman_cache` ;

-- -----------------------------------------------------
-- Schema hib_comman_cache
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hib_comman_cache` DEFAULT CHARACTER SET utf8 ;
USE `hib_comman_cache` ;

-- -----------------------------------------------------
-- Table `hib_comman_cache`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hib_comman_cache`.`department` ;

CREATE TABLE IF NOT EXISTS `hib_comman_cache`.`department` (
  `dept_id` VARCHAR(10) NOT NULL,
  `dept_name` TEXT NOT NULL,
  PRIMARY KEY (`dept_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hib_comman_cache`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hib_comman_cache`.`employee` ;

CREATE TABLE IF NOT EXISTS `hib_comman_cache`.`employee` (
  `emp_id` VARCHAR(10) NOT NULL,
  `emp_name` TEXT NOT NULL,
  `age` INT NOT NULL,
  `salary` DOUBLE NOT NULL,
  `dept_id` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`emp_id`),
  INDEX `fk_employee_department_idx` (`dept_id` ASC) VISIBLE,
  CONSTRAINT `fk_employee_department`
    FOREIGN KEY (`dept_id`)
    REFERENCES `hib_comman_cache`.`department` (`dept_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hib_comman_cache`.`project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hib_comman_cache`.`project` ;

CREATE TABLE IF NOT EXISTS `hib_comman_cache`.`project` (
  `pro_id` VARCHAR(10) NOT NULL,
  `pro_name` TEXT NOT NULL,
  `budget` DOUBLE NOT NULL,
  `dept_id` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`pro_id`),
  INDEX `fk_project_department1_idx` (`dept_id` ASC) VISIBLE,
  CONSTRAINT `fk_project_department1`
    FOREIGN KEY (`dept_id`)
    REFERENCES `hib_comman_cache`.`department` (`dept_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hib_comman_cache`.`project_employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hib_comman_cache`.`project_employee` ;

CREATE TABLE IF NOT EXISTS `hib_comman_cache`.`project_employee` (
  `pro_id` VARCHAR(10) NOT NULL,
  `emp_id` VARCHAR(10) NOT NULL,
  `start_date` DATE NOT NULL,
  PRIMARY KEY (`pro_id`, `emp_id`),
  INDEX `fk_project_has_employee_employee1_idx` (`emp_id` ASC) VISIBLE,
  INDEX `fk_project_has_employee_project1_idx` (`pro_id` ASC) VISIBLE,
  CONSTRAINT `fk_project_has_employee_project1`
    FOREIGN KEY (`pro_id`)
    REFERENCES `hib_comman_cache`.`project` (`pro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_has_employee_employee1`
    FOREIGN KEY (`emp_id`)
    REFERENCES `hib_comman_cache`.`employee` (`emp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;