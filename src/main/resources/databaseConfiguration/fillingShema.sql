--users
insert into `cinema_db`.`users` (`password`, `email`, `first_name`, `last_name`, `user_role`, `phone`) values ('-2121287765', 'mrudikc@gmail.com', 'Max', 'Rudichenko', 'ADMIN', '+380935349104')
insert into `cinema_db`.`users` (`password`, `email`, `first_name`, `last_name`, `user_role`, `phone`) values ( 'user12345', 'userId@gmail.com', 'User', 'Userovich', 'USER')

-- seat types
INSERT INTO `cinema_db`.`seat_types` (`seat_type_id`, `seat_type`, `price_multiplier`) VALUES ('1', 'standart', '1');
INSERT INTO `cinema_db`.`seat_types` (`seat_type_id`, `seat_type`, `price_multiplier`) VALUES ('2', 'vip', '1.25');

--seats in hall
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('1', '1', '1', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('2', '1', '2', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('3', '1', '3', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('4', '1', '4', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('5', '1', '5', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('6', '1', '6', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('7', '1', '7', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('8', '1', '8', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('9', '1', '9', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('10', '2', '1', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('11', '2', '2', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('12', '2', '3', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('13', '2', '4', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('14', '2', '5', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('15', '2', '6', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('16', '2', '7', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('17', '2', '8', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('18', '2', '9', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('19', '3', '1', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('20', '3', '2', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('21', '3', '3', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('22', '3', '4', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('23', '3', '5', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('24', '3', '6', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('25', '3', '7', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('26', '3', '8', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('27', '3', '9', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('28', '4', '1', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('29', '4', '2', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('30', '4', '3', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('31', '4', '4', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('32', '4', '5', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('33', '4', '6', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('34', '4', '7', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('35', '4', '8', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('36', '4', '9', '1');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('37', '5', '1', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('38', '5', '2', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('39', '5', '3', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('40', '5', '4', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('41', '5', '5', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('42', '5', '6', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('43', '5', '7', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('44', '5', '8', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('45', '5', '9', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('46', '6', '1', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('47', '6', '2', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('48', '6', '3', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('49', '6', '4', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('50', '6', '5', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('51', '6', '6', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('52', '6', '7', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('53', '6', '8', '2');
INSERT INTO `cinema_db`.`seats` (`seat_id`, `seat_row`, `seat_place`, `seat_type_id`) VALUES ('54', '6', '9', '2');

--films
INSERT INTO `cinema_db`.`films` (`film_id`, `film_name`, `director`, `premiere_date`, `duration`, `poster_pic`, `is_actual`) VALUES ('1', 'Король лев', 'Джон Фавро', '2019-07-18', '01:58:00', 'lion_king_v2.jpg', '1');
INSERT INTO `cinema_db`.`films` (`film_id`, `film_name`, `director`, `premiere_date`, `duration`, `poster_pic`, `is_actual`) VALUES ('2', 'Человек-паук: Вдали от дома', 'Джон Уоттс', '2019-07-04', '02:09:00', 'spider_man_2.jpg', '1');
INSERT INTO `cinema_db`.`films` (`film_id`, `film_name`, `director`, `premiere_date`, `duration`, `poster_pic`, `is_actual`) VALUES ('3', 'Секреты домашних животных 2', 'Крис Рено', '2019-07-01', '01:25:00', 'animal_secrets.jpg', '1');

--seances
INSERT INTO `cinema_db`.`seances` (`seance_id`, `seance_start`, `seance_end`, `film_id`, `ticket_price`) VALUES ('1', '2019-08-12 10:00:00', '2019-08-12 12:00:00', '1', '90');
INSERT INTO `cinema_db`.`seances` (`seance_id`, `seance_start`, `seance_end`, `film_id`, `ticket_price`) VALUES ('2', '2019-08-12 12:15:00', '2019-08-12 14:15:00', '2', '90');
INSERT INTO `cinema_db`.`seances` (`seance_id`, `seance_start`, `seance_end`, `film_id`, `ticket_price`) VALUES ('3', '2019-08-12 14:30:00', '2019-08-12 16:30:00', '3', '120');
