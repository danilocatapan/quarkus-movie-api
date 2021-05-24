package com.catapan.service;

import com.catapan.model.Movie;
import com.catapan.repository.MovieRepository;
import com.catapan.restclient.IMDBAPIRestClient;
import com.catapan.restclient.model.MovieIMDB;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class MovieService {

    @ConfigProperty(name = "x-rapidapi-key")
    String xRapidapiKey;

    @ConfigProperty(name = "x-rapidapi-host")
    String xRapidapiHost;

    @Inject
    MovieRepository movieRepository;

    @Inject
    @RestClient
    IMDBAPIRestClient imdbapiRestClient;

    @Transactional
    public MovieIMDB search(String query) {

        MovieIMDB movieIMDB = imdbapiRestClient.search(xRapidapiKey, xRapidapiHost, query);

        save(movieIMDB);

        return movieIMDB;
    }

    private void save(MovieIMDB movieIMDB) {
        List<Movie> movies = new ArrayList<>();

        movieIMDB.getDescriptionIMDBList().forEach(m -> {
            Movie movieDatabase = movieRepository.findIMDBId(m.getIdIMDB());

            if (movieDatabase == null && m.getQualifier() != null) {
                movies.add(new Movie(m));
            }

            movieRepository.persist(movies);
        });
    }

    public List<Movie> list() {
        return movieRepository.list();
    }

    public List<Movie> listBestRated() {
        return movieRepository.listBestRated();
    }
}
