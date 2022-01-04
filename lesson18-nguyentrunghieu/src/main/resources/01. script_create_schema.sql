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


INSERT INTO `hib_comman_cache`.`department` (`dept_id`, `dept_name`) VALUES ('mgm-dn', 'mgm da nang');
INSERT INTO `hib_comman_cache`.`department` (`dept_id`, `dept_name`) VALUES ('mgm-by', 'mgm-bayern');
INSERT INTO `hib_comman_cache`.`department` (`dept_id`, `dept_name`) VALUES ('mgm-mu', 'mgm-munich');

INSERT INTO `hib_comman_cache`.`employee` (`emp_id`, `emp_name`, `age`, `salary`, `dept_id`) VALUES ('E1', 'Quyen', '26', '10', 'mgm-dn');
INSERT INTO `hib_comman_cache`.`employee` (`emp_id`, `emp_name`, `age`, `salary`, `dept_id`) VALUES ('E2', 'Hung', '27', '20', 'mgm-dn');
INSERT INTO `hib_comman_cache`.`employee` (`emp_id`, `emp_name`, `age`, `salary`, `dept_id`) VALUES ('E3', 'Duy', '26', '30', 'mgm-dn');
INSERT INTO `hib_comman_cache`.`employee` (`emp_id`, `emp_name`, `age`, `salary`, `dept_id`) VALUES ('E4', 'Nguyen', '30', '20', 'mgm-dn');
INSERT INTO `hib_comman_cache`.`employee` (`emp_id`, `emp_name`, `age`, `salary`, `dept_id`) VALUES ('E5', 'Sa', '29', '10', 'mgm-dn');
INSERT INTO `hib_comman_cache`.`employee` (`emp_id`, `emp_name`, `age`, `salary`, `dept_id`) VALUES ('E6', 'Hop', '28', '20', 'mgm-dn');
INSERT INTO `hib_comman_cache`.`employee` (`emp_id`, `emp_name`, `age`, `salary`, `dept_id`) VALUES ('E7', 'Nadia', '30', '10', 'mgm-mu');
INSERT INTO `hib_comman_cache`.`employee` (`emp_id`, `emp_name`, `age`, `salary`, `dept_id`) VALUES ('E8', 'Eric', '30', '30', 'mgm-mu');
INSERT INTO `hib_comman_cache`.`employee` (`emp_id`, `emp_name`, `age`, `salary`, `dept_id`) VALUES ('E9', 'Cris', '26', '20', 'mgm-by');
INSERT INTO `hib_comman_cache`.`employee` (`emp_id`, `emp_name`, `age`, `salary`, `dept_id`) VALUES ('E10', 'Top', '28', '30', 'mgm-by');

INSERT INTO `hib_comman_cache`.`project` (`pro_id`, `pro_name`, `budget`, `dept_id`) VALUES ('vp', 'volumn-plainning', '400', 'mgm-mu');
INSERT INTO `hib_comman_cache`.`project` (`pro_id`, `pro_name`, `budget`, `dept_id`) VALUES ('bo', 'bake-off', '260', 'mgm-mu');
INSERT INTO `hib_comman_cache`.`project` (`pro_id`, `pro_name`, `budget`, `dept_id`) VALUES ('bs', 'baking-schema', '420', 'mgm-by');
INSERT INTO `hib_comman_cache`.`project` (`pro_id`, `pro_name`, `budget`, `dept_id`) VALUES ('dc', 'dispo-controlling', '800', 'mgm-mu');
INSERT INTO `hib_comman_cache`.`project` (`pro_id`, `pro_name`, `budget`, `dept_id`) VALUES ('dl', 'dispol-list', '560', 'mgm-mu');
INSERT INTO `hib_comman_cache`.`project` (`pro_id`, `pro_name`, `budget`, `dept_id`) VALUES ('md', 'master-data', '360', 'mgm-by');
INSERT INTO `hib_comman_cache`.`project` (`pro_id`, `pro_name`, `budget`, `dept_id`) VALUES ('al', 'allocation', '600', 'mgm-mu');
INSERT INTO `hib_comman_cache`.`project` (`pro_id`, `pro_name`, `budget`, `dept_id`) VALUES ('a12', 'A12', '250', 'mgm-dn');
INSERT INTO `hib_comman_cache`.`project` (`pro_id`, `pro_name`, `budget`, `dept_id`) VALUES ('acc', 'accounting', '120', 'mgm-by');

INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('vp', 'E1', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('vp', 'E2', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('vp', 'E7', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('vp', 'E8', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('bo', 'E1', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('bo', 'E2', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('bo', 'E3', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('bo', 'E4', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('bo', 'E7', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('bs', 'E3', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('bs', 'E4', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('dc', 'E1', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('dc', 'E2', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('dc', 'E4', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('dl', 'E1', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('dl', 'E2', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('dl', 'E4', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('md', 'E1', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('md', 'E2', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('md', 'E3', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('md', 'E4', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('md', 'E5', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('md', 'E6', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('md', 'E7', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('md', 'E8', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('a12', 'E9', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('a12', 'E10', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('acc', 'E2', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('acc', 'E3', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('acc', 'E4', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('acc', 'E8', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('al', 'E5', '2021-04-09');
INSERT INTO `hib_comman_cache`.`project_employee` (`pro_id`, `emp_id`, `start_date`) VALUES ('al', 'E6', '2021-04-09');




