package services;

import model.MatBang;
import repository.IMatBangRepository;
import repository.MatBangRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatBangServices implements  IMatBangServices{
    private IMatBangRepository matBangRepository = new MatBangRepository();
    @Override
    public List<MatBang> findAll() {
        return matBangRepository.findAll();
    }

    @Override
    public Map<String, String> add(MatBang matBang) {
        Map <String,String> map= new HashMap<>();
        matBangRepository.add(matBang);
        return  map;
    }

    @Override
    public MatBang findById(int id) {
        return matBangRepository.findById(id);
    }

    @Override
    public boolean deleteById(int id) {
        return matBangRepository.deleteById(id);
    }
}
