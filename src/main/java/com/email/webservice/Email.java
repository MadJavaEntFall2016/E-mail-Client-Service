package com.email.webservice;

import com.email.EmailService;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
    @Path("/{subject}/{body}/{to}/{from}")
    @Produces({"text/plain"})
    @Consumes({"text/plain"})
    public Response getCustomer(@PathParam("subject") String subject,
                                @PathParam("body") String messageBody,
                                @PathParam("to") String toAddress,
                                @PathParam("from") String fromAddress) {

        String sub = "";
        String body = "";
        String fromemail = "";
        String toemail = "";
        try {
            sub = URLDecoder.decode(subject, "UTF-8");
            body = URLDecoder.decode(messageBody, "UTF-8");
            fromemail = URLDecoder.decode(fromAddress, "UTF-8");
            toemail = URLDecoder.decode(toAddress, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        com.email.Email email = new com.email.Email(toemail,fromemail,sub,body);

        EmailService service = new EmailService(email);
        Response response = service.sendMail();
        return response;
    }

}
