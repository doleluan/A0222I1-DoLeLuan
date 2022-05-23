package ss1_intro_to_java.bai_tap;
import java.util.*;
public class ConvertMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double vnd = 23000;
        double usd;
        System.out.println("Nhap vao usd");
        usd = Double.parseDouble(sc.nextLine());
        double quydoi = usd*vnd;
        System.out.println(usd + " to Vnd: " + quydoi);
    }
}
