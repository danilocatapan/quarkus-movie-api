package com.catapan.restclient;

import com.catapan.restclient.model.MovieIMDB;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "restclient-imdb-api")
@Produces(MediaType.APPLICATION_JSON)
public interface IMDBAPIRestClient {

    MovieIMDB search(@HeaderParam("x-rapidapi-key") String xRapidapiKey,
        @HeaderParam("x-rapidapi-key") String xRapidapiHost,
        @QueryParam("q") String query);
}
