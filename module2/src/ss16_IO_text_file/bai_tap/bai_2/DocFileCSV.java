package ss16_IO_text_file.bai_tap.bai_2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;
public class DocFileCSV {
    public static List<Nation> readCSV(String path){
        List <Nation> list = new ArrayList<>();
        try{
            File file = new File(path);
            if (!file.exists()){
                throw  new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line="";
            while ((line=br.readLine())!=null){
                String[] temp  = line.split(",");
                list.add(new Nation(temp[0],temp[1],temp[2]));
            }
        br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }

    public static void main(String[] args) {
        List <Nation> list = readCSV("D:\\A0222I1-DoLeLuan\\module2\\src\\ss16_IO_text_file\\bai_tap\\bai_2\\file.csv");
        for (Nation nation : list){
            System.out.println(nation);
        }
    }
}
