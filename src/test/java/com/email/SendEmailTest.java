package com.email;

import com.email.response.EmailServiceResponse;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by student on 11/3/16.
 */
public class SendEmailTest {

    private final Email email = new Email("realmej@hotmail.com", "DoNotReply@gmail.com", "Test Email", "This was a test of the email service");

    @Test
    public void sendEmailTest() throws Exception {

       /* SendEmail sendEmail = new SendEmail();
        String response = sendEmail.sendEmailMessage(email);

        assertEquals(response, EmailServiceResponse.SUCCESSFULLY_SENT, response );*/

    }
}