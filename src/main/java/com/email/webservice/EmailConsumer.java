package com.email.webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Properties;

/**
 * Created by student on 11/15/16.
 */
public class EmailConsumer {

    private final Logger log = Logger.getLogger(this.getClass());
    private Properties properties;


    public String sendEmailAPI(String to, String sub, String from, String body) throws Exception {
        properties = new Properties();

        try {
            properties.load (this.getClass().getResourceAsStream("/email.properties"));
        } catch (IOException ioe) {
            System.out.println("email.loadProperties()...Cannot load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("email.loadProperties()..." + e);
            e.printStackTrace();
        }
        Client client = ClientBuilder.newClient();
        String queryString1 = URLEncoder.encode(sub, "UTF-8");
        String queryString2 = URLEncoder.encode(body, "UTF-8");
        String queryString3 = URLEncoder.encode(to, "UTF-8");
        String queryString4 = URLEncoder.encode(from, "UTF-8");
        String encodedURL = queryString1 + "/" + queryString2 + "/" + queryString3 + "/" + queryString4;

        String url = properties.getProperty("emailSendURL") + encodedURL;
        //String url = properties.getProperty("emailSendURL")+ sub + "/" + body + "/" + to + "/" + from;
        WebTarget target =
                client.target(url);
        String response = target.request(MediaType.TEXT_PLAIN).get(String.class);
        return response;

    }
}
