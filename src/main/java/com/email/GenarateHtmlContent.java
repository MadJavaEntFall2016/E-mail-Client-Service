package com.email;

import org.apache.commons.lang.WordUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 10/19/16.
 */
public class GenarateHtmlContent {

    public String getHtmlContent(String content) {

        String htmlBody = this.getHtmlBody(content);

        String htmlContent =

        " <!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> " +

        "<html xmlns=\"http://www.w3.org/1999/xhtml\"> " +

        "<head>" +

        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /> " +

        "</head>" +

        "<body>" +

            htmlBody +

        "</body>" +
        "</html> ";

        return htmlContent;


    }

    public String getHtmlBody(String body) {

        String htmlBody = "";

        String wrapper = WordUtils.wrap(body, 80);
        /**
            List<String> result = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new StringReader(wrapper))) {
                String line = reader.readLine();
                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
            } catch (IOException exc) {
                // quit
            }
        **/

        htmlBody = "<p>" + wrapper + "</p>";
        return htmlBody;
    }

}
