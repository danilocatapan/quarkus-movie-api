package com.catapan;

import com.catapan.restclient.IMDBAPIRestClient;
import com.catapan.restclient.model.MovieIMDB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/moveis")
public class MovieResource {

    @ConfigProperty(name = "x-rapidapi-key")
    String xRapidapiKey;

    @ConfigProperty(name = "x-rapidapi-host")
    String xRapidapiHost;

    @Inject
    @RestClient
    IMDBAPIRestClient imdbapiRestClient;

    @GET
    @Path("/search/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public MovieIMDB search(@PathParam("query") String query) {
        return imdbapiRestClient.search(xRapidapiKey, xRapidapiHost, query);
    }
}