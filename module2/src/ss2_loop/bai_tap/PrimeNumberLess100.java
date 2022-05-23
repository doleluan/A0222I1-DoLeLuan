package ss2_loop.bai_tap;
import java.util.*;
public class PrimeNumberLess100 {
    public static boolean checkPrime(int number){
        if (number<2) return false;
        if (number==2) return  true;
        for (int i=2;i<=Math.sqrt(number);i++){
            if (number%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cac so nguyen to nho hon 100 la: ");
        int i=0;
        String str ="";
        while (i<100){
            if (checkPrime(i)){
                str+=i+" ";
            }
            i++;
        }
        System.out.println(str);
    }
}
