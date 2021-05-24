package com.catapan.resource;

import com.catapan.model.User;
import com.catapan.model.dto.UserRequestDTO;
import com.catapan.model.dto.UserResponseDTO;
import com.catapan.service.UserService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/users")
public class UserResource {

    @Inject
    UserService userService;

    @Operation(summary = "Método para criar usuário")
    @APIResponse(
        responseCode = "201",
        content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = User.class, type = SchemaType.OBJECT)))
    @Tag(name = "user")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(UserRequestDTO userDTO) {
        UserResponseDTO userResponseDTO = userService.create(userDTO);
        return Response.status(Status.CREATED).entity(userResponseDTO).build();
    }
}
