package codegym.repository;

import codegym.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> findAll();
    void update(Email email);
    Email find(int id);
}
