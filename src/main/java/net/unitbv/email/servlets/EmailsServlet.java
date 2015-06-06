package net.unitbv.email.servlets;

import net.unitbv.email.dao.EmailDao;
import net.unitbv.email.model.Email;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class EmailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        EmailDao emailDao = new EmailDao();
        List<Email> emails = emailDao.getEmails(userId);
        request.setAttribute("emails", emails);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/emails.jsp");
        dispatcher.forward(request, response);
    }
}
