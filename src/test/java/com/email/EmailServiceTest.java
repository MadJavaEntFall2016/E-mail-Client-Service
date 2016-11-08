package com.email;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

/**
 * Created by student on 11/8/16.
 */
public class EmailServiceTest {
    private final Logger logger = Logger.getLogger(this.getClass());
    EmailService emailService = null;

    @Before
    public void setUp() {
        Email email = new Email("siva.sajjala@gmail.com","siva.sajjala@gmail.com","test", "test email");

        emailService = new EmailService(email);
    }

    @Test
    public void sendMail() throws Exception {
        Response response = emailService.sendMail();
        assertNotNull("unable to send email", response);
    }

}