package repository;

import model.ObjectModel;

import java.sql.SQLException;
import java.util.List;

public interface IObjectRepository {
    boolean deleteById(int id);
    void add(ObjectModel object);
    List<ObjectModel> search (String search);
    List<ObjectModel> findAll();
    List<ObjectModel> sortName();
    ObjectModel findById(int id);
}
