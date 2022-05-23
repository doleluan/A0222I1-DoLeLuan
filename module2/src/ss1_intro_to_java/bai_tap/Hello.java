package ss1_intro_to_java.bai_tap;
import java.util.*;
public class Hello {
    public static void main(String[] args) {
        String name ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your name: ");
        name = sc.nextLine();
        System.out.println("Hello " + name);
    }
}
