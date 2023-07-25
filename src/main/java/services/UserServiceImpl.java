package services;

import controllers.UserController;
import dao.UserDao;
import models.User;
import org.apache.log4j.Logger;
import utils.ConnectionProvider;

import java.util.List;

public class UserServiceImpl implements UserService{
    public static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    public UserDao userDao = new UserDao(ConnectionProvider.getConnection());
    public void registerUser(User user) {
        if (userDao.saveUser(user)){
            logger.info("user saved successfully");
        }else {
            logger.info("something went wrong");
        }
    }

    public List<User> getAllUsers() {
        List<User> users = this.userDao.getAll();
        return users;
    }
}
