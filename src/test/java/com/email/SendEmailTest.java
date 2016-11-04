package com.email;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by student on 11/3/16.
 */
public class SendEmailTest {

    private final Email email = new Email("amills76@gmail.com", "DoNotReply@gmail.com", "Test Email", "This was a test of the email service");

    @Test
    public void sendEmailTest() throws Exception {

        SendEmail sendEmail = new SendEmail();
        String response = sendEmail.sendEmailMessage(email);

        assertNull(response, response);

    }
}