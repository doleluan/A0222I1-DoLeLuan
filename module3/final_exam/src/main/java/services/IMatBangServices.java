package services;

import model.MatBang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IMatBangServices {
    List<MatBang> findAll() ;
    Map<String,String> add (MatBang matBang);
    MatBang findById(int id);
    boolean deleteById(int id);
}
