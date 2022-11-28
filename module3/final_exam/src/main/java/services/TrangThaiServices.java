package services;

import model.TrangThai;
import repository.ITrangThaiRepository;
import repository.TrangThaiRepository;

import java.util.List;

public class TrangThaiServices implements ITrangThaiServices {
    private ITrangThaiRepository trangThaiRepository = new TrangThaiRepository();
    @Override
    public List<TrangThai> findAll() {
        return trangThaiRepository.findAll();
    }
}
