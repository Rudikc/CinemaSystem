package ua.rudikc.cinema.model;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

public class Film {

    private int id;
    private String name;
    private double imbdRating;
    private String director;
    private Date premiereDate;
    private long budget;
    private Time duration;
    private Set<FilmGenre> genres;
    private String posterPic;


    public Film() {
    }

    public Film(int id, String name, double imbdRating, String director, Date premiereDate, long budget, Time duration, String posterPic) {
        this.id = id;
        this.name = name;
        this.imbdRating = imbdRating;
        this.director = director;
        this.premiereDate = premiereDate;
        this.budget = budget;
        this.duration = duration;
        this.posterPic = posterPic;
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

    public double getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(double imbdRating) {
        this.imbdRating = imbdRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getPosterPic() {
        return posterPic;
    }

    public void setPosterPic(String posterPic) {
        this.posterPic = posterPic;
    }

    public Set<FilmGenre> getGenres() {
        return genres;
    }

    public void setGenres(Set<FilmGenre> genres) {
        this.genres = genres;
    }
}