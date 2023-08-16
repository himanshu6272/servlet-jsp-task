package controllers;

import models.User;
import org.apache.log4j.Logger;
import services.UserService;
import services.UserServiceImpl;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;

public class ValidationServlet implements Filter {
    private final static Logger logger = Logger.getLogger(ValidationServlet.class);
    private UserService userService = new UserServiceImpl();
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        Object objId = session.getAttribute("updateUserId");
        int id = 0;
        if (objId == null){
            logger.info("New user");
        }else {
            id = (int) objId;
        }
        String emailId = req.getParameter("email");
        if (emailId==null && id != 0){
            emailId = this.userService.getUserById(id).getEmail();
        }
        boolean firstname = req.getParameter("firstname").matches("^[A-Z,a-z]{2,8}$");
        boolean lastname = req.getParameter("lastname").matches("^[A-Z,a-z]{2,8}$");
        boolean email = emailId.matches("^[A-Za-z0-9+_.-]+@(.+)$");
        boolean mobile = req.getParameter("mobile").matches("^[0-9]{1,11}$");
        boolean password = req.getParameter("password").matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
        String role = req.getParameter("role");
        if (role == null){
            role = this.userService.getUserById(id).getRole();
        }
        String gender = req.getParameter("gender");
        String question = req.getParameter("security-que");
        String answer = req.getParameter("security-answer");
        Part profilePhoto = req.getPart("profile-photo");

        String[] street = req.getParameterValues("street");
        String[] city = req.getParameterValues("city");
        String[] state = req.getParameterValues("state");
        String[] zip = req.getParameterValues("zip");
        String[] country = req.getParameterValues("country");


        User user = this.userService.getUserByEmail(emailId);
        String existEmail = user.getEmail();
        if (existEmail == null){
            existEmail = "existEmail";
        }

        if(street == null){
            response.getWriter().write("please add at least one address");
        }else {
            for (int i = 0; i < street.length; i++) {
                System.out.println(street[i]);
                if (street[i].equals("") || city[i].equals("") || state[i].equals("") || zip[i].equals("") || country[i].equals("")){
                    response.getWriter().write("please fill all the address field");
                    return;
                }
            }
        }

        if (!firstname){
            response.getWriter().write("please fill valid firstname");
        } else if (!lastname) {
            response.getWriter().write("please fill valid lastname");
        } else if (!email) {
            response.getWriter().write("please fill valid email");
        } else if (!mobile) {
            response.getWriter().write("please fill valid mobile");
        } else if (!password) {
            response.getWriter().write("please fill valid password");
        } else if (role == null) {
            response.getWriter().write("please select the role");
        } else if (gender == null) {
            response.getWriter().write("please select the gender");
        } else if (question == null) {
            response.getWriter().write("please select the role question");
        } else if (answer == null) {
            response.getWriter().write("please fill the answer");
        }else if (profilePhoto == null) {
            response.getWriter().write("please upload the profile photo");
        }else if (existEmail.equals(emailId) && id == 0){
            response.getWriter().write("exist");
        }
        else {
            chain.doFilter(request,response);
        }

    }
}
