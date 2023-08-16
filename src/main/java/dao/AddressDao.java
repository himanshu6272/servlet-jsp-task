package dao;

import models.Address;
import org.apache.log4j.Logger;
import utils.ConnectionProvider;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDao implements Serializable {

    private static final long serialVersionUID = -1893173580745472716L;
    private static final Logger logger = Logger.getLogger(UserDao.class);
    private transient Connection connection = ConnectionProvider.getConnection();
//    public AddressDao(Connection connection){
//        this.connection = connection;
//    }


    public boolean save(Address address) throws SQLException {

        PreparedStatement preparedStatement = null;
        try {
            String query = "insert into address(user_id,street, city, state, zip, country) values(?, ?, ?, ?, ?, ?)";
            preparedStatement= this.connection.prepareStatement(query);
            preparedStatement.setInt(1, address.getUserId());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getState());
            preparedStatement.setString(5, address.getZip());
            preparedStatement.setString(6, address.getCountry());

            preparedStatement.executeUpdate();

            preparedStatement.close();
        }finally{
            try {
                preparedStatement.close();
            }catch (Exception e){
                logger.error(e);
            }

        }

        return true;

    }

    public List<Address> getByUserId(int userId) throws SQLException {
        List<Address> addresses = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            String query = "select * from address where user_id=?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                Address address = new Address();
                address.setId(set.getInt(1));
                address.setUserId(set.getInt(2));
                address.setStreet(set.getString(3));
                address.setCity(set.getString(4));
                address.setState(set.getString(5));
                address.setZip(set.getString(6));
                address.setCountry(set.getString(7));
                addresses.add(address);
            }
        }finally {
            try {
                preparedStatement.close();
            }catch (Exception e){
                logger.error(e);
            }
        }

        return addresses;
    }

    public boolean delete(int id) throws SQLException {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        try {
            String query = "delete from address where id=?";
            preparedStatement= this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag = true;
        }finally {
            try {
                preparedStatement.close();
            }catch (Exception e){
                logger.error(e);
            }
        }

        return flag;
    }

    public  boolean update(Address address) throws SQLException {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        try{
            String query = "update address set user_id=?, street=?, city=?, state=?, zip=?, country=? where id=?";
            preparedStatement= this.connection.prepareStatement(query);
            preparedStatement.setInt(1, address.getUserId());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getState());
            preparedStatement.setString(5, address.getZip());
            preparedStatement.setString(6, address.getCountry());
            preparedStatement.setInt(7, address.getId());
            preparedStatement.executeUpdate();

            flag = true;
        }finally {
            try {
                preparedStatement.close();
            }catch (Exception e){
                logger.error(e);
            }
        }
        return flag;
    }


}
