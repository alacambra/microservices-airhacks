package com.airhacks.micro.flights.boundary;

import java.util.concurrent.TimeUnit;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("flights")
//@Produces({MediaType.APPLICATION_JSON})
public class FlightResource {

    @Inject
    FlightService fs;

    @GET
    public void getFlights(@Suspended AsyncResponse response) {
        response.setTimeout(100, TimeUnit.DAYS);
        response.setTimeoutHandler((r) -> {
            Response response1 = Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
            r.resume(response1);
        });
        response.resume(fs.flight());

    }

}
