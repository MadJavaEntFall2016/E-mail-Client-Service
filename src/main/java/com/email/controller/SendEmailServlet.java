package com.email.controller;

import com.email.webservice.EmailConsumer;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by student on 11/15/16.
 */
@WebServlet(
        name = "sendEmailServlet",
        urlPatterns = {"/sendEmailServlet"}
)

public class SendEmailServlet extends HttpServlet {
        private final Logger logger = Logger.getLogger(this.getClass());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("inside send email servlet @ post");
        this.doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String to = request.getParameter("recipient");
        String sub = request.getParameter("subject");
        String from = request.getParameter("email");
        String body = request.getParameter("emailBody");

        logger.info("to:" + to);
        logger.info("sub:" + sub);
        logger.info("from:" + from);
        logger.info("body:" + body);

        String message = "";
        HttpSession session = request.getSession();
        session.removeAttribute("message");

        EmailConsumer consumer = new EmailConsumer();
        try {
            message = consumer.sendEmailAPI(to, sub, from, body);
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);



    }
}
