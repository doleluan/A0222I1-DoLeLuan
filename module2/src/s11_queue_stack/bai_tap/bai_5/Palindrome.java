package s11_queue_stack.bai_tap.bai_5;
import java.util.*;
public class Palindrome {
    public static void main(String[] args) {
        Stack <Character> stack = new Stack<>();
        Queue <Character> queue = new LinkedList<>();
        String str;
        System.out.println("Nhap chuoi");
        str = new Scanner(System.in).nextLine();
        for (int i=0;i<str.length();i++){
            stack.push(str.charAt(i));
            queue.add(str.charAt(i));
        }
        String str1="";
        String str2="";
        while (!stack.isEmpty()){
            str1+=stack.pop();
        }
        while (!queue.isEmpty()){
            str2+=queue.remove();
        }
        if (str1.equals(str2)){
            System.out.println("Day la chuoi Palindrome");
        }else {
            System.out.println("Day khong phai la chuoi Palindrome");
        }
    }
}
