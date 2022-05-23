package Array.bai_tap;
import java.util.*;
public class DemSoLanXuatHienCuaKyTuTrongChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi");
        String str = sc.nextLine();
        System.out.println("Nhap ky tu");
        char s = sc.next().charAt(0);
        int count = 0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==s){
                count++;
            }
        }
        System.out.println(count);
    }
}
