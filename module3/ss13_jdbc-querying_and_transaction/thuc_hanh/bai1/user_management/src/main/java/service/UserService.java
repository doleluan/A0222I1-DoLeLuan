package service;

import common.Valitadtion;
import jdk.nashorn.internal.ir.IfNode;
import model.User;
import repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements  IUserService {
    private UserRepository userRepository = new UserRepository();
    @Override
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        return  userList;
    }

    @Override
    public User findById(int id) {
       return userRepository.findById(id);
    }

    @Override
    public Map<String,String> add(User user) {
        Map<String,String> map = new HashMap<>();
        if (user.getCountry().equals("")){
            map.put("country","Country không được rỗng");
        }
        if (user.getName().equals("")){
            map.put("name","Name không được rỗng");
        }
        if (user.getEmail().equals("")){
            map.put("email","Email không được rỗng");
        }else if (!Valitadtion.checkEmail(user.getEmail())){
            map.put("email","Email không hợp lệ");
        }
        if (map.isEmpty()){
            userRepository.add(user);
        }
        return map;
    }

    @Override
    public boolean delete(int id) {
       return userRepository.delete(id);
    }

    @Override
    public List<User> findByAll(String name, String email, String country) {
        return null;
    }

    @Override
    public void edit(User user) {
        userRepository.edit(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return  userRepository.findByCountry(country);
    }

    @Override
    public List<User> sortName() {
        return  userRepository.sortName();
    }
}
