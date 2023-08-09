package controllers;

import models.User;
import org.apache.log4j.Logger;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@MultipartConfig
public class ForgotPasswordController extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    private static final Logger logger = Logger.getLogger(ForgotPasswordController.class);

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String question = req.getParameter("security-que");
        String answer = req.getParameter("security-answer");
        logger.info(email);
        logger.info(question);
        logger.info(answer);

        User user = this.userService.getUserByEmail(email);
        if (user.getEmail()==null){
            resp.getWriter().println("User does not exist with this email");
        }else if(user.getSecurityQuestion().equals(question) && user.getSecurityAnswer().equals(answer)){
            logger.info("http://localhost:9899/ServletJspTask/reset.jsp?email="+email+"");
            resp.getWriter().println("sent");
        }else if (!Objects.equals(user.getSecurityQuestion(), question)){
            resp.getWriter().println("Please enter valid security question!");
        }else if (!Objects.equals(user.getSecurityAnswer(), answer)){
            resp.getWriter().println("Please enter valid security answer!");
        }

    }
}
