package com.email;

/**
 * Created by student on 10/19/16.
 */
public class GenarateHtmlContent {

    private String body;

    public GenarateHtmlContent() {
    }

    public GenarateHtmlContent(String body) {
        this.body = body;
    }

    public String getHtmlContent(String content) {

        String htmlBody = this.getHtmlBody(content);

        String htmlString =

        " <!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> " +

        "<html xmlns=\"http://www.w3.org/1999/xhtml\"> " +

        "<head>" +

        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /> " +

        "</head>" +

        "<body>" +

            htmlBody +

        "</body>" +
        "</html> ";

        return htmlString;


    }

    public String getHtmlBody(String body) {

        String htmlBody = "";
        return htmlBody;


    }
}
