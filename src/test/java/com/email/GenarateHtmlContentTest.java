package com.email;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 10/27/16.
 */
public class GenarateHtmlContentTest {

    GenarateHtmlContent getHtml = null;
    private final Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void setUp() {
        getHtml = new GenarateHtmlContent();
    }

    @Test
    public void getHtmlContent() throws Exception {

        String body = getHtml.getHtmlContent("hellow this is siva");
        logger.info("HTML content:" + body);

        assertNotNull("unable to generate html content", body);

    }

}