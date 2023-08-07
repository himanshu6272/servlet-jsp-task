package controllers;

import models.Address;
import models.User;
import org.apache.log4j.Logger;
import services.AddressService;
import services.AddressServiceImpl;
import services.UserService;
import services.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@MultipartConfig
public class AuthController extends HttpServlet {

    private static final Logger log = Logger.getLogger(AuthController.class);
    public UserService userService = new UserServiceImpl();

    private AddressService addressService = new AddressServiceImpl();

    Base64.Decoder decoder = Base64.getDecoder();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        log.info(email);
        String password = req.getParameter("password");
        log.info(password);
        User existingUser = this.userService.getUserByEmail(email);
        log.info(existingUser);
        log.info(existingUser.getId());
        if (existingUser.getId() == 0){
            resp.getWriter().write("User does not exist with this email, please create one!!");
            return;
        }
        String existingUserPassword = existingUser.getPassword();
        log.info(existingUserPassword);
        byte[] bytes = decoder.decode(existingUserPassword);
        String decodedPassword = new String(bytes);
        log.info(decodedPassword);
        HttpSession session = req.getSession();



        if (password.equals(decodedPassword)){
            if (existingUser.getRole().equals("ADMIN")){
                List<User> users = this.userService.getAllUsers();
                List<User> userList = new ArrayList<>();

                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getId() == existingUser.getId()){
                        continue;
                    }
                    userList.add(users.get(i));
                }
                session.setAttribute("users", userList);
                session.setAttribute("admin", existingUser);
                resp.getWriter().write("admin");
            }else {
                List<Address> addresses = this.addressService.getAddressByUserId(existingUser.getId());
                session.setAttribute("user", existingUser);
                session.setAttribute("addresses", addresses);
                resp.getWriter().write("user");
            }
        }else {
            log.error("Invalid Credentials");
            resp.getWriter().write("Invalid Credentials");
        }

    }
}
