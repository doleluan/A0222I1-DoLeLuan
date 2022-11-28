package services;

import model.VanPhong;
import repository.IVanPhongRepository;
import repository.VanPhongRepository;

import java.util.List;

public class VanPhongServices implements IVanPhongServices{
    private IVanPhongRepository vanPhongRepository = new VanPhongRepository();
    @Override
    public List<VanPhong> findAll() {
        return vanPhongRepository.findAll();
    }
}
