package com.email.webservice;

import com.cdmr.entity.Customer;
import com.cdmr.persistence.CustomerDao;
import com.email.EmailService;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Siva Sajjala on 10/27/16.
 */
@Path("/email")
public class Email {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Method to send an email
     * @param subject
     * @param messageBody
     * @param toAddress
     * @param fromAddress
     * @return response
     */

    @GET
    @Path("{subject}/{body}/{to}/{from}")
    @Produces({"text/plain"})
    @Consumes({"text/plain"})
    public Response getCustomer(@PathParam("subject") String subject,
                                @PathParam("body") String messageBody,
                                @PathParam("to") String toAddress,
                                @PathParam("from") String fromAddress) {

        com.email.Email email = new com.email.Email(toAddress,fromAddress,subject,messageBody);

        EmailService service = new EmailService(email);
        Response response = service.sendMail();
        return response;
    }

}
