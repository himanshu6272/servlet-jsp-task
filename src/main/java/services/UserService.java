package services;

import models.User;

import java.util.List;

public interface UserService {
    void registerUser(User user);

    List<User> getAllUsers();
}
