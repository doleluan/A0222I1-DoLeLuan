package ss17_binaryfile_serialization.thuc_hanh.output_stream_example;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamExample {
    public static void main(String[] args) throws Exception {
        OutputStream outputStream = new FileOutputStream("D:\\A0222I1-DoLeLuan\\module2\\src\\ss17_binaryfile_serialization\\thuc_hanh\\output_stream_example\\output.txt");
        // Tạo một mảng byte ,ta sẽ ghi các byte này vào file nói trên .
        byte[] bytes = new byte[] { 'C', 'o', 'd', 'e', 'G', 'y', 'm' };

        // Ghi lần lượt các ký tự vào luồng
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            // Ghi ký tự vào luồng
            outputStream.write(b);
        }
        // Đóng luồng đầu ra lại việc ghi xuống file hoàn tất.
        outputStream.close();
    }

}
