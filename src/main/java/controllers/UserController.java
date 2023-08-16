package controllers;

import models.Address;
import models.User;
import services.AddressService;
import services.AddressServiceImpl;
import services.UserService;
import services.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@MultipartConfig
public class UserController extends HttpServlet {

    private static final long serialVersionUID= 3522684328714479049L;
    public UserService userService = new UserServiceImpl();
    public AddressService addressService = new AddressServiceImpl();
    private transient Base64.Encoder encoder = Base64.getEncoder();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object userObjId = session.getAttribute("updateUserId");
        int updateUserId = 0;
        if (userObjId != null){
            updateUserId = (int) userObjId;
        }

//        ---------getting all form fields---------


        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        if (email == null){
            email = this.userService.getUserById(updateUserId).getEmail();
        }
        String mobile = req.getParameter("mobile");
        String password = req.getParameter("password");
        String encodedPassword = encoder.encodeToString(password.getBytes());
        String role = req.getParameter("role");
        if (role == null){
            role = this.userService.getUserById(updateUserId).getRole();
        }
        String dob = req.getParameter("dob");
        String gender = req.getParameter("gender");
        String question = req.getParameter("security-que");
        String answer = req.getParameter("security-answer");
        Part profilePhoto = req.getPart("profile-photo");
        String fileName = profilePhoto.getSubmittedFileName();

//        ---------getting all address fields---------

        String[] street = req.getParameterValues("street");
        String[] city = req.getParameterValues("city");
        String[] state = req.getParameterValues("state");
        String[] zip = req.getParameterValues("zip");
        String[] country = req.getParameterValues("country");

        if(userObjId == null){
            User user = new User(firstname,lastname,mobile,email,role,dob,gender,encodedPassword, question, answer, fileName);
            if (this.userService.registerUser(user) == 1){
                String path = getServletContext().getRealPath("") + "profilePhotos";
                profilePhoto.write(path+File.separator+fileName);
            }
            int userId = this.userService.getUserByEmail(email).getId();
            for (int i=0;i< street.length;i++){
                Address address = new Address(userId, street[i], city[i], state[i], zip[i], country[i]);
                this.addressService.saveAddress(address);
            }
        resp.getWriter().write("done");
        }else {
            String[] addressId = req.getParameterValues("addressId");
            User user = new User(updateUserId, firstname,lastname,mobile,email,role,dob,gender,encodedPassword, question, answer, fileName);
            this.userService.updateUser(user);
            String path = getServletContext().getRealPath("") + "profilePhotos";
//            File file = new File(path);
            profilePhoto.write(path+File.separator+fileName);
            for (int i = 0; i < street.length; i++) {

                if (addressId == null) {
                        Address address = new Address(updateUserId, street[i], city[i], state[i], zip[i], country[i]);
                        this.addressService.saveAddress(address);
                    } else {
                        if (Objects.equals(addressId[i], "")){
                            Address address = new Address(updateUserId, street[i], city[i], state[i], zip[i], country[i]);
                            this.addressService.saveAddress(address);
                        }else {
                            int aId = Integer.parseInt(addressId[i]);
                            Address address = new Address(aId, updateUserId, street[i], city[i], state[i], zip[i], country[i]);
                            this.addressService.updateAddress(address);
                        }
                    }
                }

            session.removeAttribute("user");
            session.removeAttribute("addresses");
            User user1 = this.userService.getUserById(updateUserId);
            List<Address> addresses = this.addressService.getAddressByUserId(updateUserId);
            session.setAttribute("user", user1);
            session.setAttribute("addresses", addresses);
            resp.getWriter().write("updated");
        }

    }


}
