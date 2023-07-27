package dao;

import models.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressDao {
    private Connection connection;
    public AddressDao(Connection connection){
        this.connection = connection;
    }

    public boolean save(Address address){
        boolean flag = false;

        try {
            String query = "insert into address(user_id,street, city, state, zip, country) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, address.getUserId());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getState());
            preparedStatement.setString(5, address.getZip());
            preparedStatement.setString(6, address.getCountry());

            preparedStatement.executeUpdate();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;

    }

    public List<Address> getByUserId(int userId){
        List<Address> addresses = new ArrayList<>();
        try {
            String query = "select * from address where user_id=?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                Address address = new Address();
                address.setStreet(set.getString(3));
                address.setCity(set.getString(4));
                address.setState(set.getString(5));
                address.setZip(set.getString(6));
                address.setCountry(set.getString(7));
                addresses.add(address);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return addresses;
    }

}
