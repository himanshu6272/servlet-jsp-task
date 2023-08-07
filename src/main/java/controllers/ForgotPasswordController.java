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

public class ForgotPasswordController extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    private static final Logger logger = Logger.getLogger(ForgotPasswordController.class);

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String question = req.getParameter("security-que");
        String answer = req.getParameter("security-answer");
        String password = req.getParameter("password");

        resp.setContentType("text/html");

        User user = this.userService.getUserByEmail(email);

        if(user != null && user.getSecurityQuestion().equals(question) && user.getSecurityAnswer().equals(answer)){
            logger.info("http://localhost:9899/ServletJspTask/reset.jsp?email="+email+"");
            resp.getWriter().println("<h3>Password reset link is sent to the logs, click here to goto on login page<a href='login.jsp'>click here</a></h3>");
        }else {
            resp.getWriter().println("<h3>User does not exist with this email, click here to goto on login page<a href='login.jsp'>click here</a></h3>");
        }


    }
}
