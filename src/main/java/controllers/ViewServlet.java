package controllers;

import models.Address;
import models.User;
import org.apache.log4j.Logger;
import services.AddressService;
import services.AddressServiceImpl;
import services.UserService;
import services.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class ViewServlet extends HttpServlet {

    private static final long serialVersionUID= -6601341627645607229L;

    private static final Logger logger = Logger.getLogger(ValidationServlet.class);

    private transient Base64.Decoder decoder = Base64.getDecoder();
    private UserService userService = new UserServiceImpl();

    private AddressService addressService = new AddressServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("userId"));
//        int adminId = Integer.parseInt(req.getParameter("adminId"));
//        String role = req.getParameter("role");
        HttpSession session = req.getSession();
        session.setAttribute("updateUserId", id);
        User user = this.userService.getUserById(id);
        byte[] bytes = decoder.decode(user.getPassword());
        String decodedPassword = new String(bytes);
        logger.info(decodedPassword);

            User user1 = new User(
                    user.getId(), user.getFirstName(), user.getLastName(), user.getMobile(), user.getEmail(),
                    user.getRole(), user.getDob(), user.getGender(), decodedPassword, user.getSecurityQuestion(), user.getSecurityAnswer(), user.getFileName()
            );

            List<Address> addresses = this.addressService.getAddressByUserId(id);
            session.setAttribute("user", user1);
            session.setAttribute("addresses", addresses);
            resp.sendRedirect("view.jsp");


    }
}
