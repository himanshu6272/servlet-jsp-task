//package controllers;
//
//import models.Address;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class AddressController extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        List<Address> addresses = new ArrayList<>();
//
//        int counter = 1;
//        String streetName = "street"+ counter;
//        String cityName = "street"+ counter;
//        String stateName = "street"+ counter;
//        String zipName = "street"+ counter;
//        String countryName = "street"+ counter;
//        String street = req.getParameter(streetName);
//        String city = req.getParameter(cityName);
//        String state = req.getParameter(stateName);
//        String zip = req.getParameter(zipName);
//        String country = req.getParameter(countryName);
//        Address address = new Address(street,city,state,zip,country);
//        addresses.add(address);
//        counter = counter+1;
//
//        System.out.println(addresses);
//
//
//    }
//}
