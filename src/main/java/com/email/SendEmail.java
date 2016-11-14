package com.email;

import com.email.response.EmailServiceResponse;

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

       /*
        Properties properties = System.getProperties();
        properties.put("mail.smtp.ssl.enable", true);
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", true);*/

       //TODO Move these to properties file
        String host = "smtp.gmail.com";
        String username = "madjavaentfall16";
        String pass = "MadJava11";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.ssl.enable", true); // added this line
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", username);
        properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", 465);
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.from", email.getFromAddress());

        Session session = Session.getInstance(properties);
        StringWriter sw = new StringWriter();

        try {

            MimeMessage message = new MimeMessage(session);
            InternetAddress here = new InternetAddress(email.getFromAddress());
            try {
                here.setPersonal(email.getFromAddress());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            message.setFrom(here);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTargetAddress()));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress("amills76@gmail.com"));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress("siva.sajjala@gmail.com"));
            message.addRecipient(Message.RecipientType.BCC, new InternetAddress(email.getFromAddress()));
            message.setSubject(email.getSubject());
            message.setContent(email.getMessageBody(), "text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, username, pass );
            message.saveChanges();
            transport.sendMessage(message, message.getAllRecipients());

            response = EmailServiceResponse.SUCCESSFULLY_SENT;
        }catch (MessagingException mex) {
            response = mex.getMessage();
        }

        return response;
    }
}