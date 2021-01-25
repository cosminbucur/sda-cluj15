create database if not exists jdbc_tutorial;

use jdbc_tutorial;

CREATE TABLE `jdbc_tutorial`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `author` VARCHAR(45) NULL,
  `publish_date` DATE NULL,
  PRIMARY KEY (`id`));
