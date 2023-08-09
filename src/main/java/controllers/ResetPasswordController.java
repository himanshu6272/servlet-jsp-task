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
import java.util.Base64;
@MultipartConfig
public class ResetPasswordController extends HttpServlet {
    private static final long serialVersionUID= 754203001383842251L;

    private UserService userService = new UserServiceImpl();
    private static final Logger logger = Logger.getLogger(ForgotPasswordController.class);

    private transient Base64.Encoder encoder = Base64.getEncoder();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String email = req.getParameter("email");
        logger.info(email);
        String password = req.getParameter("password");
        String encodedPassword = encoder.encodeToString(password.getBytes());
        if (email.equals("null")){
            resp.getWriter().println("Reset link has been expired, please generate new one!!");
        }else {
            User user = new User(email, encodedPassword);
            this.userService.updateUserPassword(user);
            resp.getWriter().println("reset");
        }
    }
}
