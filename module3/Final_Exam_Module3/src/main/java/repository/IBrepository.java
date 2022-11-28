package repository;

import model.BClass;

import java.util.List;

public interface IBrepository {
    List<BClass> findAll();
}
