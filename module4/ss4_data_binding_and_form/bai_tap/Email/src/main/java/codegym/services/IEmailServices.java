package codegym.services;

import codegym.model.Email;

import java.util.List;

public interface IEmailServices {
    List<Email> findALL();
    void update(Email email);
    Email find(int id);
}
