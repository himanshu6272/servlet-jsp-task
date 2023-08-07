package services;

import models.User;

import java.util.List;

public interface UserService {
    int registerUser(User user);

    List<User> getAllUsers();
    User getUserByEmail(String email);
    User getUserById(int id);
    void updateUser(User user);
    void updateUserPassword(User user);

    void deleteUser(int id);

}
