package wab.spring_3_1_2.dao;


import wab.spring_3_1_2.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUser();
    User show (int id);
    void save (User user);
    void update(User updatedUser);
    void delete(int id);
}
