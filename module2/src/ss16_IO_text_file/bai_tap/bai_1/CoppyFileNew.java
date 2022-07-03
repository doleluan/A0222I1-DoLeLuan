package ss16_IO_text_file.bai_tap.bai_1;
import java.io.*;
import java.util.*;
public class CoppyFileNew {
    public static List<String> readFile(String path){
        List <String> list = new ArrayList<>();
        try{
            File file = new File(path);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line ="";
            while ((line=br.readLine())!=null){
                list.add(line);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }
    public static void writeFile(String path, List<String> list){
        try {
            FileWriter fileWriter = new FileWriter(path,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String str : list ){
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    static  String pathInput = "D:\\A0222I1-DoLeLuan\\module2\\src\\ss16_IO_text_file\\bai_tap\\bai_1\\input.txt";
    static  String pathOutput = "D:\\A0222I1-DoLeLuan\\module2\\src\\ss16_IO_text_file\\bai_tap\\bai_1\\ouput.txt";
    public static void main(String[] args) {
        List<String> str = readFile(pathInput);
        writeFile(pathOutput,str);
    }
}
