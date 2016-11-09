package com.email.webservice;

import com.email.*;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 11/9/16.
 */
public class EmailConsumerTest {
    private final Logger logger = Logger.getLogger(this.getClass());
    EmailConsumer consumer = null;

    @Before
    public void setUp() {
        consumer = new EmailConsumer();
    }
    @Test
    public void sendMail() throws Exception {

        String response = consumer.sendMail("test", "test email", "siva.sajjala@gmail.com","siva.sajjala@gmail.com");
        assertEquals("email test failed", response, "Email was successfully sent");

    }

}