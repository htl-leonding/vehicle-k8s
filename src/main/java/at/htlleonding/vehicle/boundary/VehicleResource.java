package at.htlleonding.vehicle.boundary;

import at.htlleonding.vehicle.entity.Vehicle;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;


@Path("/vehicle")
public class VehicleResource {

    @GET
    @Path("{id}")
    @Produces({
            MediaType.APPLICATION_JSON
            , MediaType.APPLICATION_XML
    })
    public Vehicle find(@PathParam("id") long id) {
        return new Vehicle("Opel " + id, "Commodore");
    }

    @GET
    @Produces({
            MediaType.APPLICATION_JSON
    })
    public List<Vehicle> findAll() {
        List<Vehicle> all = new ArrayList<>();
        all.add(find(42));
        return all;
    }

    @GET
    @Path("myjson")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject myCustomJsonObject() {
        JsonObject myObject = Json.createObjectBuilder()
                .add("first-name", "Bertl")
                .add("last-name", "Balazs")
                .build();
        return myObject;
    }

    @GET
    @Path("myresponse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response myCustomResponse(@QueryParam("no") Integer no) {
        if(no == 1) {
            return Response.ok(
                            new Vehicle("Opel", "Karl")
                    )
                    .header("MY_HEADER_ENTRY", "java is cool")
                    .build();
        } else {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

}
