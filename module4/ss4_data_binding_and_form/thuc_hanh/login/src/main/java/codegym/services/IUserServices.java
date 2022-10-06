package codegym.services;

import codegym.model.Login;
import codegym.model.User;

public interface IUserServices {
    public User checkLogin(Login login);
}
