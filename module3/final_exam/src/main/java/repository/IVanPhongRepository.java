package repository;

import model.VanPhong;

import java.util.List;

public interface IVanPhongRepository {
    List<VanPhong> findAll();
}
