package services;

import model.ObjectModel;
import repository.ObjectRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectServices implements  IObjectServices {
    private ObjectRepository objectRepository = new ObjectRepository();
    @Override
    public boolean deleteById(int id) {
        return objectRepository.deleteById(id);
    }

    @Override
    public Map<String, String> add(ObjectModel object) {
        Map <String,String> map = new HashMap<>();

        objectRepository.add(object);
        return  map;
    }

    @Override
    public List<ObjectModel> search(String search) {
        return objectRepository.search(search);
    }

    @Override
    public List<ObjectModel> findAll() {
        return  objectRepository.findAll();
    }

    @Override
    public List<ObjectModel> sortName() {
        return objectRepository.sortName();
    }

    @Override
    public ObjectModel findById(int id) {
        return objectRepository.findById(id);
    }
}
