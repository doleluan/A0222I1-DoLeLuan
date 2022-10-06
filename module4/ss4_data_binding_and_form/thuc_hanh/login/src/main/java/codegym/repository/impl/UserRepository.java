package codegym.repository.impl;

import codegym.model.Login;
import codegym.model.User;
import org.springframework.stereotype.Repository;
import codegym.repository.IUserRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository implements IUserRepository {
    static List<User> users = new ArrayList<>();
    static {
        users.add(new User("john","123456","John","john@codegym.vn",10));
        users.add(new User("bill","123456","Bill","bill@codegym.vn",10));
        users.add(new User("mike","123456","Mike","mike@codegym.vn",10));
    }

    @Override
    public User checkLogin(Login login) {
        for (User u: users) {
            if(u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
