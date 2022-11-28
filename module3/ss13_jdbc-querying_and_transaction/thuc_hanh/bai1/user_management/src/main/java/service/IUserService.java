package service;

import model.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<User> findAll();
    User findById(int id);
    Map<String,String> add (User user);
    boolean delete (int id);
    List<User> findByAll(String name, String email, String country);
    void edit(User user);
    List<User> findByCountry(String country);
    List<User> sortName();
}
