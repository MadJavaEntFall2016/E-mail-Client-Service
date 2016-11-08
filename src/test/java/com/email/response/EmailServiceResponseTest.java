package com.email.response;

import org.junit.Before;
import org.junit.Test;

import javax.mail.MessagingException;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

/**
 * Created by student on 11/4/16.
 */
public class EmailServiceResponseTest {
    private static String EXCEPTION_MESSAGE  = "Could not connect to SMTP host: localhost, port: 25";
    private static int STATUS_CODE = 200;



    @Test
    public void successfulResponseTest() throws Exception {
           Response response = EmailServiceResponse.response(EmailServiceResponse.SUCCESSFULLY_SENT);
            assertEquals("Response was not successful", EmailServiceResponse.SUCCESSFULLY_SENT, response.getEntity());
    }

    @Test
    public void exceptionResponseTest() throws Exception {
        Response response = EmailServiceResponse.response(new MessagingException(EXCEPTION_MESSAGE).getMessage());
        String shortExceptionResponse = ((String) response.getEntity()).substring(0,50);
        assertEquals("Response Exception not being returned", EXCEPTION_MESSAGE.substring(0,50), shortExceptionResponse);
        assertEquals("Response Status is incorrect", STATUS_CODE, response.getStatus());
    }

}