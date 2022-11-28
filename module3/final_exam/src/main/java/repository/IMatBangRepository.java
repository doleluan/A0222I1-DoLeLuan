package repository;

import model.MatBang;

import java.util.List;

public interface IMatBangRepository {
    List<MatBang> findAll() ;
    void add(MatBang matBang);
    MatBang findById(int id);
    boolean deleteById(int id);
}
