package dao;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public boolean saveUser(User user) {
        boolean flag = false;

        try {
            String query = "insert into user(firstname, lastname, mobile, email, role, gender, dob, password) values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getMobile());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setString(7, user.getDob());
            preparedStatement.setString(8, user.getPassword());

            preparedStatement.executeUpdate();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    public int getUserIdByEmail(String email){
        int userId = 0;
        try {
            String query = "select user.id from user where email=?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()){
                userId = set.getInt(1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        return userId;
    }

    public List<User> getAll(){

        List<User> users = new ArrayList<>();
        try {
            String query = "select * from user";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                User user = new User(
                        set.getInt(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),
                        set.getString(6),
                        set.getString(7),
                        set.getString(8),
                        set.getString(9)
                );
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

}
