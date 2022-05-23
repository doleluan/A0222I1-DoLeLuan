package ss2_loop.bai_tap;
import java.util.*;
public class PrimeNumber {
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
        System.out.println("Input number");
        int number = Integer.parseInt(sc.nextLine());
        int count=1,i=0;
        String str ="";
        while (count<=number){
            if (checkPrime(i)){
                str+=i+" ";
                count++;
            }
            i++;
        }
        System.out.println(str);
    }
}
