-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mypantrydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mypantrydb` ;

-- -----------------------------------------------------
-- Schema mypantrydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mypantrydb` DEFAULT CHARACTER SET utf8 ;
USE `mypantrydb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(60) NOT NULL,
  `last_name` VARCHAR(60) NOT NULL,
  `email` VARCHAR(1000) NULL,
  `role` ENUM('STANDARD', 'ADMIN') NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `enabled` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(100) NOT NULL,
  `stock_picture` VARCHAR(5000) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grocery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `grocery` ;

CREATE TABLE IF NOT EXISTS `grocery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `product_name` VARCHAR(100) NOT NULL,
  `amount` DECIMAL(4,2) NULL,
  `date_purchased` DATE NULL,
  `expiration_date` DATE NULL,
  `date_opened` DATE NULL,
  `amount_used` DECIMAL(4,2) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_grocery_category_idx` (`category_id` ASC),
  INDEX `fk_grocery_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_grocery_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grocery_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS mypantryuser;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'mypantryuser' IDENTIFIED BY 'mypantryuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'mypantryuser';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `mypantrydb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `role`, `username`, `password`, `enabled`) VALUES (1, 'Rich', 'Wasek', 'rideburtonrw@gmail.com', 'ADMIN', 'rwasek', '$2a$10$8rBl.s.hwvnq1pbik7dXmeaXKtd5tb606h9TqxCOmhi9kNd8eliPS', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `role`, `username`, `password`, `enabled`) VALUES (2, 'Demo', 'User', NULL, 'STANDARD', 'mypantry', '$2a$10$yogE/hia0oafncLYnYOa2uua2DrxOqZfx8HHrZZ4bEDjVpWC2elUC', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `mypantrydb`;
INSERT INTO `category` (`id`, `category_name`, `stock_picture`) VALUES (1, 'Vegetable', NULL);
INSERT INTO `category` (`id`, `category_name`, `stock_picture`) VALUES (2, 'Fruit', NULL);
INSERT INTO `category` (`id`, `category_name`, `stock_picture`) VALUES (3, 'Dairy', NULL);
INSERT INTO `category` (`id`, `category_name`, `stock_picture`) VALUES (4, 'Meat', NULL);
INSERT INTO `category` (`id`, `category_name`, `stock_picture`) VALUES (5, 'Frozen', NULL);
INSERT INTO `category` (`id`, `category_name`, `stock_picture`) VALUES (6, 'Pantry', NULL);
INSERT INTO `category` (`id`, `category_name`, `stock_picture`) VALUES (7, 'Snacks', NULL);
INSERT INTO `category` (`id`, `category_name`, `stock_picture`) VALUES (8, 'Drinks', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `grocery`
-- -----------------------------------------------------
START TRANSACTION;
USE `mypantrydb`;
INSERT INTO `grocery` (`id`, `category_id`, `user_id`, `product_name`, `amount`, `date_purchased`, `expiration_date`, `date_opened`, `amount_used`) VALUES (1, 6, 1, 'Loaf of Bread', 1, '2020-11-21', NULL, '2020-11-21', .2);
INSERT INTO `grocery` (`id`, `category_id`, `user_id`, `product_name`, `amount`, `date_purchased`, `expiration_date`, `date_opened`, `amount_used`) VALUES (2, 1, 1, 'Lettuce Box', 1, '2020-11-21', NULL, NULL, NULL);
INSERT INTO `grocery` (`id`, `category_id`, `user_id`, `product_name`, `amount`, `date_purchased`, `expiration_date`, `date_opened`, `amount_used`) VALUES (3, 4, 1, 'Frozen Pork Links', 1, '2020-11-21', NULL, NULL, NULL);
INSERT INTO `grocery` (`id`, `category_id`, `user_id`, `product_name`, `amount`, `date_purchased`, `expiration_date`, `date_opened`, `amount_used`) VALUES (4, 6, 2, 'Loaf of Bread', NULL, '2020-12-25', '2021-01-10', NULL, NULL);
INSERT INTO `grocery` (`id`, `category_id`, `user_id`, `product_name`, `amount`, `date_purchased`, `expiration_date`, `date_opened`, `amount_used`) VALUES (5, 1, 2, 'Brocolli', NULL, '2020-12-25', '2021-01-05', NULL, NULL);
INSERT INTO `grocery` (`id`, `category_id`, `user_id`, `product_name`, `amount`, `date_purchased`, `expiration_date`, `date_opened`, `amount_used`) VALUES (6, 2, 2, 'Grapes', NULL, '2020-12-25', '2021-01-05', NULL, NULL);
INSERT INTO `grocery` (`id`, `category_id`, `user_id`, `product_name`, `amount`, `date_purchased`, `expiration_date`, `date_opened`, `amount_used`) VALUES (7, 3, 2, 'Milk', NULL, '2020-12-25', '2021-01-10', NULL, NULL);
INSERT INTO `grocery` (`id`, `category_id`, `user_id`, `product_name`, `amount`, `date_purchased`, `expiration_date`, `date_opened`, `amount_used`) VALUES (8, 4, 2, 'Steak', NULL, '2020-12-25', '2021-01-01', NULL, NULL);
INSERT INTO `grocery` (`id`, `category_id`, `user_id`, `product_name`, `amount`, `date_purchased`, `expiration_date`, `date_opened`, `amount_used`) VALUES (9, 5, 2, 'Frozen Pizza', NULL, '2020-12-25', '2021-12-25', NULL, NULL);
INSERT INTO `grocery` (`id`, `category_id`, `user_id`, `product_name`, `amount`, `date_purchased`, `expiration_date`, `date_opened`, `amount_used`) VALUES (10, 7, 2, 'Popcorn', NULL, '2020-12-25', '2021-12-25', NULL, NULL);
INSERT INTO `grocery` (`id`, `category_id`, `user_id`, `product_name`, `amount`, `date_purchased`, `expiration_date`, `date_opened`, `amount_used`) VALUES (11, 8, 2, 'Seltzer 12-Pack', NULL, '2020-12-25', '2022-12-25', NULL, NULL);

COMMIT;

