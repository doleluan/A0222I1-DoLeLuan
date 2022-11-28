package services;

import model.BClass;
import repository.BRepository;
import repository.IBrepository;

import java.util.List;

public class BServices implements IBServices {
    IBrepository iBrepository = new BRepository();
    @Override
    public List<BClass> findAll() {
        return iBrepository.findAll();
    }
}
