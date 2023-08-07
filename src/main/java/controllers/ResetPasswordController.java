package controllers;

import models.User;
import org.apache.log4j.Logger;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

public class ResetPasswordController extends HttpServlet {

    UserService userService = new UserServiceImpl();
    private static final Logger logger = Logger.getLogger(ForgotPasswordController.class);

    Base64.Encoder encoder = Base64.getEncoder();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String encodedPassword = encoder.encodeToString(password.getBytes());
        logger.info(email);
        logger.info(password);
        logger.info(encodedPassword);

        User user = new User(email, encodedPassword);
        this.userService.updateUserPassword(user);
        resp.getWriter().println("<h3>Password reset Successfully!! click here to goto on login page<a href='login.jsp'>click here</a></h3>");
    }
}
