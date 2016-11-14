package com.email;

import com.email.response.EmailServiceResponse;

import javax.ws.rs.core.Response;

/**
 * Created by student on 10/24/16.
 */
public class EmailService {

    private Email email;

    public EmailService() {
    }

    public EmailService(Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Response sendMail() {

        // get html content
        GenarateHtmlContent content = new GenarateHtmlContent();
        String htmlContent = content.getHtmlBody(email.getMessageBody());

        //set html email body
        email.setMessageBody(htmlContent);

        //send email
        SendEmail sendMail = new SendEmail();
        String mailResponse = sendMail.sendEmailMessage(email);

        //process the response
        EmailServiceResponse response = new EmailServiceResponse();
        Response res = response.response(mailResponse);

        //return the response
        return res;
    }
}
