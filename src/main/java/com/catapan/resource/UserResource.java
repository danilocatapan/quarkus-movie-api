package com.catapan.resource;

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

@Path("/users")
public class UserResource {

    @Inject
    UserService userService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(UserRequestDTO userDTO) {
        UserResponseDTO userResponseDTO = userService.create(userDTO);
        return Response.status(Status.CREATED).entity(userResponseDTO).build();
    }
}
