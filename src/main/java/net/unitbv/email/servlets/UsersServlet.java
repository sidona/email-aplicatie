package net.unitbv.email.servlets;

import net.unitbv.email.dao.UsersDao;
import net.unitbv.email.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsersServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDao usersDao = new UsersDao();
        List<User> users = usersDao.getUsers();
        request.setAttribute("users", users);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/users.jsp");
        dispatcher.forward(request,response);
    }

}
