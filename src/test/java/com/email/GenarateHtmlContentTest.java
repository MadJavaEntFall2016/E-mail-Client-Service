package com.email;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 10/27/16.
 */
public class GenarateHtmlContentTest {

    GenarateHtmlContent getHtml = null;

    @Before
    public void setUp() {
        getHtml = new GenarateHtmlContent();
    }

    @Test
    public void getHtmlContent() throws Exception {

        String body = getHtml.getHtmlContent("hellow this is siva");
        assertNotNull("unable to generate html content", body);

    }

}