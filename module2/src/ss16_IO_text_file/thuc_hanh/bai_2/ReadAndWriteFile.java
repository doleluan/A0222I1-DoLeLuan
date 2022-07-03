package ss16_IO_text_file.thuc_hanh.bai_2;
import java.io.*;
import java.util.*;
public class ReadAndWriteFile {
    public List<Integer> readFile(String path){
        List <Integer> numbers = new ArrayList<>();
        try{
            File file = new File(path);
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line=br.readLine())!=null){
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return numbers;
    }
    public void writerFile(String path, int max){
        try {
            FileWriter writer = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Gia tri lon nhat la: " + max);
            bufferedWriter.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\text.txt");
        int max = findMax(numbers);
        readAndWriteFile.writerFile("D:\\ketqua.txt", max);
    }
}
