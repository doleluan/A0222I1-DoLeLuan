package ss17_binaryfile_serialization.thuc_hanh.object_output_stream;

import java.io.*;

public class ObjectOutputStreamExample {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream("D:\\A0222I1-DoLeLuan\\module2\\src\\ss17_binaryfile_serialization\\thuc_hanh\\object_output_stream\\product.txt"));
            Product product = new Product(1, "IPhone 12", 2800000, "New");
            os.writeObject(product);
            os.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            os.close();
        }
        System.out.println("Success!");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("D:\\A0222I1-DoLeLuan\\module2\\src\\ss17_binaryfile_serialization\\thuc_hanh\\object_output_stream\\product.txt"));
            Product product = (Product) ois.readObject();
            System.out.println(product);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            ois.close();
        }
    }
}
