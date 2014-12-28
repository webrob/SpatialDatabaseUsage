package ngdemo.web.rest;


import ngdemo.domain.User;
import ngdemo.service.contract.UserService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Singleton
public class UserRestService {

    @Inject
    private UserService userService;

    @GET
    @Path("numberOfUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public int getNumberOfUsers() {
        return userService.getNumberOfUsers();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsersInJSON() {
        return userService.getAllUsers();
    }



    /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUser(@QueryParam("a") MyClass json) {
        return userService.getAllUsers();
    }
    */

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") int id) {
        return userService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User create(User user) {
        return userService.createNewUser(user);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User update(User user) {
        return userService.update(user);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") int id) {
        userService.remove(id);
    }
}
