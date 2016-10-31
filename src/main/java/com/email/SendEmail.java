package com.email;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Created by student on 10/22/16.
 */
public class SendEmail {

    public String sendEmailMessage(Email email) {

        String response = " ";
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        StringWriter sw = new StringWriter();



        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(email.getFromAddress()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTargetAddress()));
            message.setSubject(email.getSubject());
            message.setContent(email.getMessageBody(), "text/html");

            Transport.send(message);

            response = "Email was successfully sent";
        }catch (MessagingException mex) {
            response = mex.getMessage();
        }

        return response;
    }
}