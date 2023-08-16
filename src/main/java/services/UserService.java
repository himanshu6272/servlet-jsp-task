package services;

import models.User;

import java.io.Serializable;
import java.util.List;

public interface UserService extends Serializable {
    int registerUser(User user);

    List<User> getAllUsers();
    User getUserByEmail(String email);
    User getUserById(int id);
    void updateUser(User user);
    void updateUserPassword(User user);

    void deleteUser(int id);

}
