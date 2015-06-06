package net.unitbv.email.servlets;

import net.unitbv.email.dao.EmailDao;
import net.unitbv.email.model.Email;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class EmailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailId = request.getParameter("email");

        Email email = null;
        if (emailId != null) {
            EmailDao emailDao = new EmailDao();
            email = emailDao.getEmail(emailId);
        } else {
            email = new Email();
        }

        request.setAttribute("email", email);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/email.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sender = request.getParameter("sender");
        String receiver = request.getParameter("receiver");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");

        Email email = new Email();
        email.setSenderId(sender);
        email.setReceiverId(receiver);
        email.setSubject(subject);
        email.setBody(body);

        EmailDao emailDao = new EmailDao();
        emailDao.saveEmail(email);
    }
}
