package com.catapan.resource;

import com.catapan.model.Movie;
import com.catapan.restclient.model.MovieIMDB;
import com.catapan.service.MovieService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/moveis")
public class MovieResource {

    @Inject
    MovieService movieService;

    @Operation(summary = "Método para buscar filmes")
    @APIResponse(
	responseCode = "200",
	content = @Content(mediaType = MediaType.APPLICATION_JSON,
	schema = @Schema(implementation = MovieIMDB.class, type = SchemaType.ARRAY)))
    @Tag(name = "movie")
    @GET
    @Path("/search/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public MovieIMDB search(@PathParam("query") String query) {
        return movieService.search(query);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> list() {
        return movieService.list();
    }

    @GET
    @Path("/listBestRated")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> listBestRated(){
        return movieService.listBestRated();
    }
}