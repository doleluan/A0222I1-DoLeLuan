package codegym.repository;

import codegym.model.Login;
import codegym.model.User;

public interface IUserRepository {
    public  User checkLogin(Login login);
}