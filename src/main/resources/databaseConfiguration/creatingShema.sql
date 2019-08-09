CREATE SCHEMA IF NOT EXISTS `cinema_db` DEFAULT CHARACTER SET utf8 ;

USE `cinema_db` ;

DROP TABLE IF EXISTS `cinema_db`.`film_genres` ;

CREATE TABLE IF NOT EXISTS `cinema_db`.`film_genres` (
  `film_genre_id` INT(11) NOT NULL AUTO_INCREMENT,
  `film_genre_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`film_genre_id`),
  UNIQUE INDEX `film_genere_id_UNIQUE` (`film_genre_id` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`film_genre_name` ASC) VISIBLE);

CREATE TABLE IF NOT EXISTS `cinema_db`.`films` (
  `film_id` INT(11) NOT NULL AUTO_INCREMENT,
  `film_name` VARCHAR(70) NOT NULL,
  `director` VARCHAR(45) NOT NULL,
  `premiere_date` DATE NOT NULL,
  `duration` TIME NOT NULL,
  `poster_pic` VARCHAR(45) NOT NULL,
  `is_actual` TINYINT(4) NOT NULL,
  PRIMARY KEY (`film_id`),
  UNIQUE INDEX `film_id_UNIQUE` (`film_id` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`film_name` ASC) VISIBLE);

CREATE TABLE IF NOT EXISTS `cinema_db`.`films_film_genres` (
  `film_id` INT(11) NOT NULL,
  `film_genere_id` INT(11) NOT NULL,
  PRIMARY KEY (`film_id`, `film_genere_id`),
  INDEX `fk_films_has_film_generes_film_generes1_idx` (`film_genere_id` ASC) VISIBLE,
  INDEX `fk_films_has_film_generes_films1_idx` (`film_id` ASC) VISIBLE,
  CONSTRAINT `fk_films_has_film_generes_film_generes1`
    FOREIGN KEY (`film_genere_id`)
    REFERENCES `cinema_db`.`film_genres` (`film_genre_id`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_films_has_film_generes_films1`
    FOREIGN KEY (`film_id`)
    REFERENCES `cinema_db`.`films` (`film_id`)
    ON DELETE CASCADE);

CREATE TABLE IF NOT EXISTS `cinema_db`.`users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `user_role` ENUM('ADMIN', 'USER', 'GUEST') NOT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE);

CREATE TABLE IF NOT EXISTS `cinema_db`.`orders` (
  `order_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `price` DOUBLE NOT NULL,
  `order_time` DATETIME NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE INDEX `orders_id_UNIQUE` (`order_id` ASC) VISIBLE,
  INDEX `fk_orders_users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `cinema_db`.`users` (`user_id`));

CREATE TABLE IF NOT EXISTS `cinema_db`.`seat_types` (
  `seat_types_id` INT(11) NOT NULL AUTO_INCREMENT,
  `seat_type` VARCHAR(45) NOT NULL,
  `price_multiplier` DOUBLE NOT NULL,
  PRIMARY KEY (`seat_types_id`),
  UNIQUE INDEX `seat_types_id_UNIQUE` (`seat_types_id` ASC) VISIBLE);

CREATE TABLE IF NOT EXISTS `cinema_db`.`seats` (
  `seat_id` INT(11) NOT NULL AUTO_INCREMENT,
  `seat_row` INT(11) NOT NULL,
  `seat_place` INT(11) NOT NULL,
  `seat_types_id` INT(11) NOT NULL,
  PRIMARY KEY (`seat_id`),
  UNIQUE INDEX `hall_id_UNIQUE` (`seat_id` ASC) VISIBLE,
  INDEX `fk_seats_seat_types1_idx` (`seat_types_id` ASC) VISIBLE,
  CONSTRAINT `fk_seats_seat_types1`
    FOREIGN KEY (`seat_types_id`)
    REFERENCES `cinema_db`.`seat_types` (`seat_types_id`));

CREATE TABLE IF NOT EXISTS `cinema_db`.`sessions` (
  `session_id` INT(11) NOT NULL AUTO_INCREMENT,
  `session_start` DATETIME NOT NULL,
  `session_end` DATETIME NOT NULL,
  `film_id` INT(11) NOT NULL,
  `ticket_price` DOUBLE NOT NULL,
  PRIMARY KEY (`session_id`),
  UNIQUE INDEX `session_id_UNIQUE` (`session_id` ASC) VISIBLE,
  INDEX `fk_sessions_films1_idx` (`film_id` ASC) VISIBLE,
  CONSTRAINT `fk_sessions_films1`
    FOREIGN KEY (`film_id`)
    REFERENCES `cinema_db`.`films` (`film_id`));

CREATE TABLE IF NOT EXISTS `cinema_db`.`tickets` (
  `ticket_id` INT(11) NOT NULL AUTO_INCREMENT,
  `seat_id` INT(11) NOT NULL,
  `order_id` INT(11) NOT NULL,
  `session_id` INT(11) NOT NULL,
  PRIMARY KEY (`ticket_id`),
  UNIQUE INDEX `ticket_id_UNIQUE` (`ticket_id` ASC) VISIBLE,
  INDEX `fk_tickets_seats_idx` (`seat_id` ASC) VISIBLE,
  INDEX `fk_tickets_orders1_idx` (`order_id` ASC) VISIBLE,
  INDEX `fk_tickets_sessions1_idx` (`session_id` ASC) VISIBLE,
  CONSTRAINT `fk_tickets_orders1`
    FOREIGN KEY (`order_id`)
    REFERENCES `cinema_db`.`orders` (`order_id`),
  CONSTRAINT `fk_tickets_seats`
    FOREIGN KEY (`seat_id`)
    REFERENCES `cinema_db`.`seats` (`seat_id`),
  CONSTRAINT `fk_tickets_sessions1`
    FOREIGN KEY (`session_id`)
    REFERENCES `cinema_db`.`sessions` (`session_id`));
