package final_exam_module2.util;

import final_exam_module2.models.HocVien;
import final_exam_module2.models.NhanSu;
import final_exam_module2.models.NhanVien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    private static String PATH = "D:\\A0222I1-DoLeLuan\\module2\\src\\final_exam_module2\\data\\personal_records.csv";

    public List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    list.add(line);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeToFile(String path, List<NhanSu> nhanSus) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false));
            for (int i = 0; i < nhanSus.size(); i++) {
                bufferedWriter.write(String.valueOf(nhanSus.get(i).toData()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<NhanSu> readNhanSu() {
        List<String> strings = readFile(PATH);
        List<NhanSu> nhanSus = new ArrayList<>();
        for (String string : strings) {
            String[] tmp = string.split(",");
            if (tmp[0].equalsIgnoreCase("Hoc Vien")) {
                nhanSus.add(new HocVien(tmp[0],tmp[1], tmp[2], tmp[3], tmp[4], tmp[5],Float.parseFloat(tmp[6]),tmp[7],tmp[8]));
            } else if (tmp[0].equalsIgnoreCase("Nhan Vien")) {
                nhanSus.add(new NhanVien(tmp[0],tmp[1], tmp[2], tmp[3], tmp[4], tmp[5],Float.parseFloat(tmp[6]),tmp[7],tmp[8]));
            }
        }
        return nhanSus;
    }
}