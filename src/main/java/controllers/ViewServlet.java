package controllers;

import models.Address;
import models.User;
import services.AddressService;
import services.AddressServiceImpl;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    private AddressService addressService = new AddressServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("userId"));
        System.out.println(id);
        User user = this.userService.getUserById(id);

        if (user.getRole().equals("ADMIN")){
            List<User> users = this.userService.getAllUsers();
            req.setAttribute("users", users);
            req.setAttribute("admin", user);
            req.getRequestDispatcher("admin.jsp").forward(req,resp);
        }else {
            List<Address> addresses = this.addressService.getAddressByUserId(id);
            req.setAttribute("user", user);
            req.setAttribute("addresses", addresses);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view.jsp");
            requestDispatcher.forward(req,resp);
        }

    }
}
