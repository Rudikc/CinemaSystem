package ua.rudikc.cinema.model;

public class FilmFilmGenre {

    private Film film;
    private FilmGenre filmGenre;

    public FilmFilmGenre() {
    }

    public FilmFilmGenre(Film film, FilmGenre filmGenre) {
        this.film = film;
        this.filmGenre = filmGenre;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public FilmGenre getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(FilmGenre filmGenre) {
        this.filmGenre = filmGenre;
    }
}
