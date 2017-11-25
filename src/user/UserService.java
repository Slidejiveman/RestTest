package user;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {

   UserDBDao userDBDao = new UserDBDao();

   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_JSON)
   public List<User> getUsersXML() throws Exception{
      return userDBDao.getAllUsers();
   }	
}
