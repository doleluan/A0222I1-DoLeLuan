package services;

import model.ObjectModel;

import java.util.List;
import java.util.Map;

public interface IObjectServices {
    boolean deleteById(int id);
    Map<String,String> add(ObjectModel object);
    List<ObjectModel> search (String search);
    List<ObjectModel> findAll();
    List<ObjectModel> sortName();
    ObjectModel findById(int id);
}
