package com.email.webservice;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 11/16/16.
 */
public class EmailConsumerTest {

    EmailConsumer consumer = null;
    private final Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void setUp() throws Exception {
        consumer = new EmailConsumer();
    }

    @Test
    public void sendEmailAPI() throws Exception {
        String sub = "email from local";
        String body = "email from local";
        String from = "siva.sajjala@gmail.com";
        String to = "siva.kesava11@gmail.com";
        String message = consumer.sendEmailAPI(to, sub, from, body);
        assertEquals("email failed", message, "Email was successfully sent");

    }

}