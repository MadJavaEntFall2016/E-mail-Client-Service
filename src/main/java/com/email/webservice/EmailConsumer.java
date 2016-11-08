package com.email.webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by student on 11/8/16.
 */
public class EmailConsumer {
    private final Logger log = Logger.getLogger(this.getClass());

    public String sendMail(String sub, String body, String to, String from) throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://localhost:8080/restAPI/email/" + sub + "/" + body + "/" + to + "/" + from);
        String response = target.request(MediaType.TEXT_PLAIN).get(String.class);

        return response;
    }

}
