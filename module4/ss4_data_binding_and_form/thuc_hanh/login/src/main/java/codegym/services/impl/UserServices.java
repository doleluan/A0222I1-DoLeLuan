package codegym.services.impl;

import codegym.model.Login;
import codegym.model.User;
import org.springframework.stereotype.Service;
import codegym.repository.IUserRepository;
import codegym.repository.impl.UserRepository;
import codegym.services.IUserServices;
@Service
public class UserServices implements IUserServices {
   private IUserRepository iUserRepository = new UserRepository();
    @Override
    public User checkLogin(Login login) {
        return iUserRepository.checkLogin(login);
    }
}
