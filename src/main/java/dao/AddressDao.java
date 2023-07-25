package dao;

import models.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

}
