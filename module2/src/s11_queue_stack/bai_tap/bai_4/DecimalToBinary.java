package s11_queue_stack.bai_tap.bai_4;
import java.util.*;
public class DecimalToBinary {
    public static void main(String[] args) {
        Stack <Integer> res = new Stack<>();
        System.out.println("Nhap so can chuyen doi");
        int number = new Scanner(System.in).nextInt();
        while(number!=0){
            res.push(number%2);
            number/=2;
        }
        while (!res.isEmpty()){
            System.out.print(res.pop());
        }
    }

}
