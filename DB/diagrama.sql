-- MySQL Script generated by MySQL Workbench
-- Sat Sep 23 15:38:54 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bbdatabase
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bbdatabase` ;

-- -----------------------------------------------------
-- Schema bbdatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bbdatabase` DEFAULT CHARACTER SET utf8 ;
USE `bbdatabase` ;

-- -----------------------------------------------------
-- Table `bbdatabase`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdatabase`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `fullname` VARCHAR(200) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `birthday` DATE NOT NULL,
  `phone_number` VARCHAR(10) NOT NULL,
  `role` TINYINT NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bbdatabase`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdatabase`.`categories` (
  `categories_id` INT NOT NULL AUTO_INCREMENT,
  `sale` TINYINT NOT NULL,
  `outstanding` TINYINT NOT NULL,
  PRIMARY KEY (`categories_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bbdatabase`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdatabase`.`products` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `price` INT NOT NULL,
  `size` VARCHAR(45) NOT NULL,
  `stock` INT NOT NULL,
  `hide` INT NOT NULL,
  `description` VARCHAR(300) NOT NULL,
  `product_photo` BLOB NOT NULL,
  `fk_categories_id` INT NOT NULL,
  `flavor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `fk_products_categories1_idx` (`fk_categories_id` ASC) VISIBLE,
  CONSTRAINT `fk_products_categories1`
    FOREIGN KEY (`fk_categories_id`)
    REFERENCES `bbdatabase`.`categories` (`categories_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bbdatabase`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdatabase`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `purchase_date` DATE NOT NULL,
  `total_amount` INT NOT NULL,
  `fk_user_id` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE INDEX `order_id_UNIQUE` (`order_id` ASC) VISIBLE,
  INDEX `fk_orders_users_idx` (`fk_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_users`
    FOREIGN KEY (`fk_user_id`)
    REFERENCES `bbdatabase`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bbdatabase`.`orders_has_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bbdatabase`.`orders_has_products` (
  `quantity` INT NOT NULL,
  `fk_order_id` INT NOT NULL,
  `fk_product_id` INT NOT NULL,
  `price_product` INT NOT NULL,
  INDEX `fk_orders_has_products_orders1_idx` (`fk_order_id` ASC) VISIBLE,
  INDEX `fk_orders_has_products_products1_idx` (`fk_product_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_has_products_orders1`
    FOREIGN KEY (`fk_order_id`)
    REFERENCES `bbdatabase`.`orders` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_products_products1`
    FOREIGN KEY (`fk_product_id`)
    REFERENCES `bbdatabase`.`products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
