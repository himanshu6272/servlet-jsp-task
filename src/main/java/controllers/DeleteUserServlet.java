package controllers;

import models.User;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DeleteUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.removeAttribute("users");
        int id = Integer.parseInt(req.getParameter("userId"));
        this.userService.deleteUser(id);
        List<User> users = this.userService.getAllUsers();
        session.setAttribute("users", users);
        resp.sendRedirect("admin.jsp");
    }
}
