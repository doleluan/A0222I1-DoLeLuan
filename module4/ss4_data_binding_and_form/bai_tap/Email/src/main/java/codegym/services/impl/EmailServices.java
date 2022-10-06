package codegym.services.impl;

import codegym.model.Email;
import codegym.repository.IEmailRepository;
import codegym.services.IEmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmailServices implements IEmailServices {
    @Autowired
    private IEmailRepository iEmailRepository;
    @Override
    public List<Email> findALL() {
        return iEmailRepository.findAll();
    }

    @Override
    public void update(Email email) {
        iEmailRepository.update(email);
    }

    @Override
    public Email find(int id) {
        return  iEmailRepository.find(id);
    }
}
