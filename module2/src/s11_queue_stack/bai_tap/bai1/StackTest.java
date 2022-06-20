package s11_queue_stack.bai_tap.bai1;
import java.util.*;
public class StackTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack <Integer> stack = new Stack();
        System.out.println("Nhap so luong phan tu");
           int size;
        int [] arrayNumber = new int [size = Integer.parseInt(sc.nextLine())];
        for (int i=0;i<arrayNumber.length;i++){
            System.out.println("Nhap gia tri phan tu: ");
            arrayNumber[i] = Integer.parseInt(sc.nextLine());
            stack.push(arrayNumber[i]);
        }
        for (int i=0;i<arrayNumber.length;i++){
//            arrayNumber[i]=stack.pop();
            System.out.print(arrayNumber[i] +"\t");
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop() + " ");
        }
    }
}
