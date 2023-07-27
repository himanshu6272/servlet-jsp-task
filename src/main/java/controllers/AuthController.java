package controllers;

import models.User;
import org.apache.log4j.Logger;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AuthController extends HttpServlet {

    private static final Logger log = Logger.getLogger(AuthController.class);
    public UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User existingUser = this.userService.getUserByEmail(email);
        String existingUserPassword = existingUser.getPassword();

        if (existingUser != null && password.equals(existingUserPassword)){
            if (existingUser.getRole().equals("ADMIN")){
                List<User> users = this.userService.getAllUsers();
                req.setAttribute("users", users);
                RequestDispatcher dispatcher = req.getRequestDispatcher("admin.jsp");
                dispatcher.forward(req,resp);
            }else {
                req.setAttribute("user", existingUser);
                RequestDispatcher dispatcher = req.getRequestDispatcher("view.jsp");
                dispatcher.forward(req,resp);
            }
        }else {
            log.error("Invalid Credentials");
        }

    }
}
