package ss17_binaryfile_serialization.bai_tap.bai_1;
import ss17_binaryfile_serialization.thuc_hanh.bai_2.Student;

import java.io.*;
import java.util.*;
public class Main {
    static  Scanner sc = new Scanner(System.in);
    static String path = "D:\\A0222I1-DoLeLuan\\module2\\src\\ss17_binaryfile_serialization\\bai_tap\\bai_1\\result.txt";
//Ghi file
    public static void writeFile(String path,List<Product> products) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream  = new ObjectOutputStream(new FileOutputStream(path));
                objectOutputStream.writeObject(products);
        objectOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    Them san pham
    public static  void addProduct(List<Product> products){
        System.out.println("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Manufactor: ");
        String manu = sc.nextLine();
        System.out.println("Price: ");
        float price = Float.parseFloat(sc.nextLine());
        products.add(new Product(id,name,manu,price));
        writeFile(path,products);
    }
//    Doc file
    public  static void readFile(String path, List<Product> products){
        try {
            ObjectInputStream ob= new ObjectInputStream(new FileInputStream(path));
            products = (List<Product>) ob.readObject();
            ob.close();
        }catch (NullPointerException techmaster1) {
            System.out.println("loi");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static  List<Product>  readDataFromFile(String path){
        List<Product> products = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Mobile","SamSung",2000));
        products.add(new Product(2,"Mobile","Iphone",2500));
        products.add(new Product(3,"TV","Nokia",3000));
        writeFile(path,products);
        products = readDataFromFile(path);
        for (Product product :products){
            System.out.println(product);
        }
    }
}
