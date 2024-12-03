package org.Sebastian.quarkus.test.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.Sebastian.quarkus.test.model.ErrorResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;

@ApplicationScoped
@Path("peso-to-dolar")
public class PesoToDolarResource {

    private BigDecimal dolarConvertion = BigDecimal.valueOf(1100.0);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("convertion/{peso}")
    public Response PesoToDolarConvert(@PathParam("peso") BigDecimal peso) {

        try {
            if(BigDecimal.ZERO.equals(peso)){
                return Response
                .ok()
                .entity("$0")
                .build();
            }
            if(peso.compareTo(BigDecimal.ZERO) < 0 ){
                return Response
                .status(Status.BAD_REQUEST)
                .entity(new ErrorResponse(400,"bad-request", "Can't convert a negative value"))
                .build();
            }
    
            return Response
            .ok()
            .entity("$" + (peso.divide(dolarConvertion, 3, RoundingMode.CEILING)))
            .build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
            .entity(new ErrorResponse(500, "not-found", e.getMessage()))
            .build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("convertion/{dolar}")
    public Response updateDolarConvertion(@PathParam("dolar") BigDecimal dolar) {

        try {
            if(dolar.compareTo(BigDecimal.ZERO) < 0 || BigDecimal.ZERO.equals(dolar)){
                return Response
                .status(Status.BAD_REQUEST)
                .entity(new ErrorResponse(400,"bad-request", "Dolar value must be greater than 0"))
                .build();
            }
            dolarConvertion = dolar;

            return Response
            .ok()
            .entity("Dolar convertion updated to:" + dolarConvertion)
            .build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
            .entity(new ErrorResponse(500, "not-found", e.getMessage()))
            .build();
        }
    }
}
