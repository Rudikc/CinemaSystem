package ua.rudikc.cinema.dao.sqlimplementation;

public enum Queries {

    //FilmSqlDao queries
    GET_ALL_ACTUAL_FILMS("SELECT * FROM cinema_db.films WHERE is_actual = 1"),
    GET_FILM("SELECT * FROM cinema_db.films WHERE film_id = ?"),
    GET_ALL_FILMS("SELECT * FROM cinema_db.films"),
    GET_FILM_BY_NAME("SELECT * FROM cinema_db.films WHERE film_name = ?"),
    DELETE_FILM("DELETE FROM cinema_db.films WHERE film_id = ?"),
    UPDATE_FILM("UPDATE cinema_db.films SET film_name=?,director=?,premiere_date=?,duration=?,poster_pic=? WHERE film_id =?"),
    INSERT_FILM("INSERT INTO cinema_db.films (film_name,director,premiere_date,duration,poster_pic) VALUES (?,?,?,?,?)"),

    //FilmGenreSqlDao queries
    GET_FILM_GENRE("SELECT * FROM cinema_db.film_genres WHERE film_genre_id = ?"),
    GET_ALL_FILM_GENRES("SELECT * FROM cinema_db.film_genres"),
    GET_FILM_GENRE_BY_NAME("SELECT * FROM cinema_db.film_genres WHERE film_genre_name = ?"),
    UPDATE_FILM_GENRE("UPDATE cinema_db.film_genres SET film_genre_name=? WHERE film_genre_id=?"),
    DELETE_FILM_GENRE("DELETE FROM cinema_db.film_genres WHERE film_genre_id = ?"),
    INSERT_FILM_GENRE("INSERT INTO cinema_db.film_genres (film_genre_name) VALUES (?)"),

    //OrderSqlDao queries
    GET_ORDER("SELECT * FROM cinema_db.orders WHERE order_id =?"),
    GET_ALL_ORDERS("SELECT * FROM cinema_db.orders"),
    DELETE_ORDER("DELETE FROM cinema_db.orders WHERE order_id =?"),
    GET_USERS_ORDERS("SELECT * FROM cinema_db.orders WHERE user_id =?"),
    INSERT_ORDER("INSERT INTO cinema_db.orders (user_id,price,order_time) VALUES (?,?,?)"),
    UPDATE_ORDER("UPDATE cinema_db.orders SET user_id = ?,price = ?, order_time = ?"),

    //SeanceSqlDao queries
    GET_SEANCES_BY_DATE("SELECT * FROM cinema_db.seances WHERE DATE(seance_start) = ?"),
    GET_SEANCE("SELECT * FROM cinema_db.seances WHERE seance_id = ?"),
    GET_ALL_SEANCES("SELECT * FROM cinema_db.seances"),
    DELETE_SEANCE("DELETE FROM cinema_db.seances WHERE seance_id = ?"),
    UPDATE_SEANCE("UPDATE cinema_db.seances SET seance_start=?,seance_end=?,film_id=?,ticket_price=? WHERE seance_id=?"),
    INSERT_SEANCE("INSERT INTO cinema_db.seances (seance_start,seance_end,film_id,ticket_price) VALUES (?,?,?,?)"),

    //SeatSqlDao queries
    GET_ALL_SEATS("SELECT * FROM cinema_db.seats"),
    GET_SEAT("SELECT * FROM cinema_db.seats WHERE seat_id =?"),
    DELETE_SEAT("DELETE FROM cinema_db.seats WHERE seat_id =?"),
    INSERT_SEAT("INSERT INTO cinema_db.seats(seat_row,seat_place,seat_type_id) VALUES(?,?,?)"),
    UPDATE_SEAT("UPDATE cinema_db.seats SET seat_row=?,seat_place=?,seat_type_id = ? WHERE seat_id = ?"),

    //SeatTypeSqlDao queries
    GET_ALL_SEAT_TYPES("SELECT * FROM cinema_db.seat_types"),
    GET_SEAT_TYPE("SELECT * FROM cinema_db.seat_types WHERE seat_type_id=?"),
    UPDATE_SEAT_TYPE("UPDATE cinema_db.seat_types SET seat_type = ?,price_multiplier = ? WHERE seat_type_id = ?"),
    DELETE_SEAT_TYPE("DELETE FROM cinema_db.seat_types WHERE seat_type_id = ?"),
    INSERT_SEAT_TYPE("INSERT INTO  cinema_db.seat_types (seat_type,price_multiplier) VALUES (?,?)"),

    //TicketSqlDao queries
    GET_ALL_TICKETS_BY_SESSION_ID("SELECT * FROM cinema_db.tickets WHERE seance_id = ?"),
    GET_ALL_TICKETS_BY_ORDER_ID("SELECT * FROM cinema_db.tickets WHERE order_id = ?"),
    GET_ALL_TICKETS("SELECT * FROM cinema_db.tickets"),
    GET_TICKET("SELECT * FROM cinema_db.tickets WHERE ticket_id = ?"),
    INSERT_TICKET("INSERT INTO cinema_db.tickets (seat_id,order_id,seance_id) VALUES (?,?,?)"),
    DELETE_TICKET("DELETE FROM cinema_db.tickets WHERE ticket_id=?"),
    UPDATE_TICKET("UPDATE cinema_db.tickets SET seat_id=?,order_id=?,seance_id=? WHERE ticket_id=?"),

    //UserSqlDao queries
    GET_USER("SELECT * FROM cinema_db.users WHERE user_id = ?"),
    GET_ALL_USERS("SELECT * FROM cinema_db.users"),
    GET_USER_BY_EMAIL_AND_PASSWORD("SELECT * FROM cinema_db.users WHERE email = ? AND password = ?"),
    GET_USER_BY_EMAIL("SELECT * FROM cinema_db.users WHERE email = ?"),
    UPDATE_USERS_ROLE("UPDATE cinema_db.users SET user_role = ? WHERE user_id = ?"),
    UPDATE_USER("UPDATE cinema_db.users SET password=?, email=? ,first_name=?, last_name=?, user_role=?, phone=? WHERE user_id=?"),
    DELETE_USER("DELETE FROM cinema_db.users WHERE user_id = ?"),
    INSERT_USER("INSERT INTO cinema_db.users (password,email,first_name,last_name,user_role,phone) VALUES (?,?,?,?,?,?)");


    private String query;

    Queries(String query) {
        this.query = query;
    }

    String getQuery() {
        return query;
    }
}
