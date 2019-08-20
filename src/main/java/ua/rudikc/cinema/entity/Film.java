package ua.rudikc.cinema.entity;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Film {

    private int id;
    private String name;
    private String director;
    private Date premiereDate;
    private LocalTime duration;
    private String posterPic;


    public Film() {
    }

    public Film(int id, String name, double imbdRating, String director, Date premiereDate, long budget, LocalTime duration, String posterPic) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.premiereDate = premiereDate;
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

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getPosterPic() {
        return posterPic;
    }

    public void setPosterPic(String posterPic) {
        this.posterPic = posterPic;
    }

    public static Builder newBuilder() {
        return new Film().new Builder();
    }

    public class Builder {
        private Builder() {

        }
        public Builder setDate(Date premiereDate){
            Film.this.premiereDate = premiereDate;
            return this;
        }

        public Builder setDirector(String director){
            Film.this.director = director;
            return this;
        }

        public Builder setDuration(String time) {
            Film.this.duration = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
            return this;
        }

        public Builder setPosterPic(String posterPic) {
            Film.this.posterPic = posterPic;
            return this;
        }

        public Builder setName(String name) {
            Film.this.name = name;
            return this;
        }

        public Builder setId(int id){
            Film.this.id = id;
            return this;
        }

        public Film build() {
            return Film.this;
        }
    }
}