package at.htl.boundary;

import at.htl.control.PersonRepository;
import at.htl.entities.Person;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;

@Path("api/Person")
public class PersonEndpoint {
    @Inject
    PersonRepository personRepository;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addPerson(
            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("email") String email,
            @FormParam("phone") String phoneNumber) {
        var savedPerson = this.personRepository.addEntity(new Person(firstName, lastName, email,
                phoneNumber, new Timestamp(System.currentTimeMillis())));

        System.out.println("Thank you for using Quarkus");

        return Response.accepted().entity(savedPerson).build();
    }
}
