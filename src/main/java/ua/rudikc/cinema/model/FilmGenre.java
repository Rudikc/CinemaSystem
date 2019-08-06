package ua.rudikc.cinema.model;

import java.util.Set;

public class FilmGenre {

    private int id;
    private String name;
    private Set<Film> films;

    public FilmGenre() {
    }

    public FilmGenre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
