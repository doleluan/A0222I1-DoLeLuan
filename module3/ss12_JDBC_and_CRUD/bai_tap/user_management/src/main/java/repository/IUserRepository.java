package repository;

import model.User;

import java.util.List;
import java.util.Map;

public interface IUserRepository {
    List<User> findAll();
    User findById(int id);
    List<User> findByCountry(String country);
    void add (User user);
    boolean delete (int id);
    List<User> findByAll(String name, String email, String country);
    void edit(User user);
    List<User> sortName();
}
