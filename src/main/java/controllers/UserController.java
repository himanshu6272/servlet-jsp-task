package controllers;

import dao.UserDao;
import models.Address;
import models.User;
import services.AddressService;
import services.AddressServiceImpl;
import services.UserService;
import services.UserServiceImpl;
import utils.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        User user = new User(firstname,lastname,mobile,email,role,dob,gender,password);
        this.userService.registerUser(user);

        int counter = 1;
        boolean flag = true;
        while (flag) {
            String strCounter = String.valueOf(counter);
            String counterValueName = "count" + strCounter;
            String counterValue = req.getParameter(counterValueName);
            if (counterValue == null) {
                flag = false;
            }
            counter = counter + 1;
        }

        UserDao userDao = new UserDao(ConnectionProvider.getConnection());
        int userId = userDao.getUserIdByEmail(email);
        for (int i=1;i<counter-1;i++){
            String strId = String.valueOf(i);
            String streetName = "street" + strId;
            String cityName = "city" + strId;
            String stateName = "state" + strId;
            String zipName = "zip" + strId;
            String countryName = "country" + strId;
            String street = req.getParameter(streetName);
            String city = req.getParameter(cityName);
            String state = req.getParameter(stateName);
            String zip = req.getParameter(zipName);
            String country = req.getParameter(countryName);
            Address address = new Address(userId, street, city, state, zip, country);
            this.addressService.saveAddress(address);
        }
    }
}
