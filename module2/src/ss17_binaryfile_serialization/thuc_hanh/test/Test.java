package ss17_binaryfile_serialization.thuc_hanh.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        // Tạo một đối tượng InputStream: Luồng đọc một file.
        InputStream is = new FileInputStream("D:\\A0222I1-DoLeLuan\\module2\\src\\ss17_binaryfile_serialization\\thuc_hanh\\test\\testCodegym.txt");

        int i = -1;

        // Đọc lần lượt các byte (8bit) trong luồng và lưu vào biến i
        // Khi đọc ra giá trị -1 nghĩa là kết thúc luồng.
        while ((i = is.read()) != -1) {
            System.out.print((char)i);
        }
        is.close();
    }
}
