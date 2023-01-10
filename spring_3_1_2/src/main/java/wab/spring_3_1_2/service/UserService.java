package wab.spring_3_1_2.service;



import wab.spring_3_1_2.model.User;

import java.util.List;

public interface UserService {
    List<User> getUser();
    User show (int id);
    void save (User user);
    void update(int id, User updatedUser);
    void delete(int id);
}
