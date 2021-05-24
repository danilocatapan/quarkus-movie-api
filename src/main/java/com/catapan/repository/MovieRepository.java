package com.catapan.repository;

import com.catapan.model.Movie;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie> {

    public List<Movie> list() {
        return listAll();
    }

    public Movie findIMDBId(String imdbId) {
        return find("imdbId", imdbId).firstResult();
    }

    public List<Movie> listBestRated() {
        Long value = 2000L;
        return find("rank < :value", Parameters.with("value", value)).list();
    }
}
