package controllers;

import services.AddressService;
import services.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAddressServlet extends HttpServlet {

    private AddressService addressService = new AddressServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("addId");
        if (strId != null){
            int id = Integer.parseInt(strId);
            this.addressService.deleteAddress(id);
        }

    }
}
