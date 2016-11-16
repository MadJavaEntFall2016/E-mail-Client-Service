package com.email.controller;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 11/16/16.
 */
public class SendEmailServletTest {
    private  SendEmailServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private final Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void setUp() throws Exception{
        servlet = new SendEmailServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void doPost() throws Exception {

        request.addParameter("recipient", "siva.sajjala@gmail.com");
        request.addParameter("subject", "email from local");
        request.addParameter("email", "siva.kesava11@gmail.com");
        request.addParameter("emailBody", "email from local");
        servlet.doPost(request, response);
        String message = (String) request.getAttribute("message");

        assertEquals("email failed", message, "Email was successfully sent");

    }

}