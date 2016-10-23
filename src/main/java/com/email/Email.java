package com.email;

/**
 * Created by student on 10/22/16.
 */
public class Email {
    private String targetAddress;
    private String fromAddress;
    private String subject;
    private String messageBody;

    public Email() {}

    public String getTargetAddress(){
        return targetAddress;
    }

    public void setTargetAddress(String targetAddress){
        this.targetAddress = targetAddress;
    }

    public String getFromAddress(){
        return fromAddress;
    }

    public void setFromAddress(String fromAddress){
        this.fromAddress = fromAddress;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }
    public String getMessageBody(){
        return messageBody;
    }
    public void setMessageBody(String messageBody){
        this.messageBody = messageBody;
    }

}