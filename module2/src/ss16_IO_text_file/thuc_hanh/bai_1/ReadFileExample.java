package ss16_IO_text_file.thuc_hanh.bai_1;
import java.io.*;
import java.util.*;
public class ReadFileExample {
    public void readFileText(String filePath)  {
    try {
     //Doc file theo duong dan
     File file = new File(filePath);
//        Kiem tra neu file co ton tai hay khong thi nem ra ngoai le
     if (!file.exists()){
         throw new FileNotFoundException();
     }
//        Doc tung dong cua file va tien hanh cong lai
     BufferedReader br = new BufferedReader(new FileReader(file));
     String line = "";
     int sum = 0;
     while ((line = br.readLine()) !=null ){
         System.out.println(line);
         sum+=Integer.parseInt(line);
     }
     br.close();
        // Hiển thị ra màn hình tổng các số nguyên trong file
        System.out.println("Tổng = " + sum);
        }catch (Exception E){
        // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
        System.err.println("Fie không tồn tại or nội dung có lỗi!");
    }
    }
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readfileEx = new ReadFileExample();
        try {
            readfileEx.readFileText(path);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
