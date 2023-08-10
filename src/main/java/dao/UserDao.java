package dao;

import models.User;
import org.apache.log4j.Logger;
import utils.ConnectionProvider;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Serializable {

    private static final long serialVersionUID = -4360092092454209390L;
    private static final Logger logger = Logger.getLogger(UserDao.class);

    private transient Connection connection = ConnectionProvider.getConnection();

//    public UserDao(Connection connection) {
//        this.connection = connection;
//    }

    public boolean saveUser(User user) throws SQLException {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        try {
            String query = "insert into user(firstname, lastname, mobile, email, role, gender, dob, password, question, answer, filename) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement= this.connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getMobile());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setString(7, user.getDob());
            preparedStatement.setString(8, user.getPassword());
            preparedStatement.setString(9, user.getSecurityQuestion());
            preparedStatement.setString(10, user.getSecurityAnswer());
            preparedStatement.setString(11, user.getFileName());

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

    public User getByEmail(String email) throws SQLException {
        User user = new User();
        PreparedStatement preparedStatement = null;
        try {
            String query = "select * from user where email=?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()){
                user.setId(set.getInt(1));
                user.setFirstName(set.getString(2));
                user.setLastName(set.getString(3));
                user.setMobile(set.getString(4));
                user.setEmail(set.getString(5));
                user.setRole(set.getString(6));
                user.setGender(set.getString(7));
                user.setDob(set.getString(8));
                user.setPassword(set.getString(9));
                user.setSecurityQuestion(set.getString(10));
                user.setSecurityAnswer(set.getString(11));
                user.setFileName(set.getString(12));
            }



        }finally {
            try {
                preparedStatement.close();
            }catch (Exception e){
                logger.error(e);
            }
        }


        return user;
    }

    public List<User> getAll() throws SQLException {

        List<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            String query = "select * from user";
            preparedStatement = this.connection.prepareStatement(query);
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
                        set.getString(9),
                        set.getString(10),
                        set.getString(11),
                        set.getString(12)
                );
                users.add(user);
            }

        }finally {
            try {
                preparedStatement.close();
            }catch (Exception e){
                logger.error(e);
            }
        }
        return users;
    }

    public User getById(int id) throws SQLException {
        User user = new User();
        PreparedStatement preparedStatement = null;
        try {
            String query = "select * from user where id=?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()){
                user.setId(set.getInt(1));
                user.setFirstName(set.getString(2));
                user.setLastName(set.getString(3));
                user.setMobile(set.getString(4));
                user.setEmail(set.getString(5));
                user.setRole(set.getString(6));
                user.setGender(set.getString(7));
                user.setDob(set.getString(8));
                user.setPassword(set.getString(9));
                user.setSecurityQuestion(set.getString(10));
                user.setSecurityAnswer(set.getString(11));
                user.setFileName(set.getString(12));
            }



        }finally {
            try {
                preparedStatement.close();
            }catch (Exception e){
                logger.error(e);
            }
        }

        return user;

    }

    public boolean update(User user) throws SQLException {
        boolean flag = false;
        PreparedStatement preparedStatement = null;

        try {
            String query = "update user set firstname=?, lastname=?, mobile=?, email=?, role=?, gender=?, dob=?, password=?, question=?, answer=?, filename=? where id=?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getMobile());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setString(7, user.getDob());
            preparedStatement.setString(8, user.getPassword());
            preparedStatement.setString(9, user.getSecurityQuestion());
            preparedStatement.setString(10, user.getSecurityAnswer());
            preparedStatement.setString(11, user.getFileName());
            preparedStatement.setInt(12, user.getId());
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

    public boolean delete(int id) throws SQLException {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        try {
            String query = "delete from user where id=?";
            preparedStatement = this.connection.prepareStatement(query);
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

    public boolean updatePassword(User user) throws SQLException {
        boolean flag = false;
        PreparedStatement preparedStatement = null;

        try {
            String query = "update user set password=? where email=?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getEmail());
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
