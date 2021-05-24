package com.catapan.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_movies")
public class UserMovie implements Serializable {

    @Id
    private Long id;

    @EmbeddedId
    protected UserMoviePK userMoviePK;

    private int rate;

    private boolean watchlist;

    private boolean isAlreadyWatched;

    @JoinColumn(name = "movie_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Movie movie;

    public UserMoviePK getUserMoviePK() {
        return userMoviePK;
    }

    public void setUserMoviePK(UserMoviePK userMoviePK) {
        this.userMoviePK = userMoviePK;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public boolean isWatchlist() {
        return watchlist;
    }

    public void setWatchlist(boolean watchlist) {
        this.watchlist = watchlist;
    }

    public boolean isAlreadyWatched() {
        return isAlreadyWatched;
    }

    public void setAlreadyWatched(boolean alreadyWatched) {
        isAlreadyWatched = alreadyWatched;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
