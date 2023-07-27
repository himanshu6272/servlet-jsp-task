package controllers;

import dao.UserDao;
import models.Address;
import models.User;
import services.AddressService;
import services.AddressServiceImpl;
import services.UserService;
import services.UserServiceImpl;
import utils.ConnectionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserController extends HttpServlet {
    public UserService userService = new UserServiceImpl();
    public AddressService addressService = new AddressServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        String dob = req.getParameter("dob");
        String gender = req.getParameter("gender");

        String strId = req.getParameter("userId");



        String[] street = req.getParameterValues("street");
        String[] city = req.getParameterValues("city");
        String[] state = req.getParameterValues("state");
        String[] zip = req.getParameterValues("zip");
        String[] country = req.getParameterValues("country");

        if(strId == null){
            User user = new User(firstname,lastname,mobile,email,role,dob,gender,password);
            this.userService.registerUser(user);
            int userId = this.userService.getUserByEmail(email).getId();

            for (int i=0;i< street.length;i++){
                Address address = new Address(userId, street[i], city[i], state[i], zip[i], country[i]);
                this.addressService.saveAddress(address);
            }
            resp.sendRedirect("login.jsp");
        }else {
            int id = Integer.parseInt(strId);
            User user = new User(id, firstname,lastname,mobile,email,role,dob,gender,password);
            this.userService.updateUser(user);
            User user1 = this.userService.getUserById(id);
            req.setAttribute("user", user1);
            req.getRequestDispatcher("view.jsp").forward(req,resp);
        }

    }


}
