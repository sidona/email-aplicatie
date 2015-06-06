package net.unitbv.email.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: sidona
 * Date: 6/6/15
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */

public class Welcome extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("username");
        out.print("Welcome "+n);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome.html");
        dispatcher.forward(request,response);
        out.close();
    }

}
