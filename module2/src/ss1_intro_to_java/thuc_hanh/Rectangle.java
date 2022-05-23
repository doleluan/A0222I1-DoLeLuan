package ss1_intro_to_java.thuc_hanh;
import java.util.*;
public class Rectangle {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner scanner = new Scanner(System.in);//Khai báo đối tượng Scanner

        System.out.println("Enter width: ");
        width = Float.parseFloat(scanner.nextLine());//Nhập chiều rộng

        System.out.println("Enter height: ");
        height = Float.parseFloat(scanner.nextLine());//Nhập chiều dài

        float area = width * height;

        System.out.println("Area is: " + area);
    }
}
