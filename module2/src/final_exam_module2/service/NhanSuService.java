package final_exam_module2.service;

import final_exam_module2.exception.DuplicatePersonalRecordException;
import final_exam_module2.models.NhanSu;

import java.util.List;

public interface NhanSuService {
    public void create(NhanSu nhanSu) throws DuplicatePersonalRecordException;
    public void delete(String maDinhDanh) throws DuplicatePersonalRecordException;
    public List<NhanSu> findAll();
}
