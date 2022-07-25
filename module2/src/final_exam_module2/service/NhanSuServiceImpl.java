package final_exam_module2.service;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import final_exam_module2.exception.DuplicatePersonalRecordException;
import final_exam_module2.models.NhanSu;
import final_exam_module2.service.NhanSuService;
import final_exam_module2.util.ReadAndWrite;
import phone_management.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class NhanSuServiceImpl implements NhanSuService {
    private static String PATH = "D:\\A0222I1-DoLeLuan\\module2\\src\\final_exam_module2\\data\\personal_records.csv";
    ReadAndWrite readAndWrite = new ReadAndWrite();
    List<NhanSu> nhanSus = new ArrayList<>();
    public NhanSuServiceImpl(){
        nhanSus = readAndWrite.readNhanSu();
    }
    @Override
    public void create(NhanSu nhanSu) throws DuplicatePersonalRecordException {
//        for (int i=0;i<nhanSus.size();i++){
//            if (nhanSus.get(i).getMaDinhDanh().equalsIgnoreCase(nhanSu.getMaDinhDanh())){
//                throw new DuplicatePersonalRecordException("Ma dinh danh da ton tai");
//            }
//        }
        nhanSus.add(nhanSu);
        readAndWrite.writeToFile(PATH,nhanSus);
    }
    @Override
    public void delete(String maDinhDanh) throws DuplicatePersonalRecordException {
        for (int i=0;i<nhanSus.size();i++){
            if (nhanSus.get(i).getMaDinhDanh().equalsIgnoreCase(maDinhDanh)){
                nhanSus.remove(i);
                readAndWrite.writeToFile(PATH,nhanSus);
                return;
            }
        }
        throw new DuplicatePersonalRecordException(maDinhDanh + "khong ton tai");
    }

    @Override
    public List<NhanSu> findAll() {
        return nhanSus;
    }
}

