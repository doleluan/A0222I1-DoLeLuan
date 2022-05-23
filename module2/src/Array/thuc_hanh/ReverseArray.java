package Array.thuc_hanh;
import java.util.*;
public class ReverseArray {
    public static void main(String[] args) {
        int [] array;
        int size;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Input size");
            size = Integer.parseInt(sc.nextLine());
        }while (size <=0 || size>20);
        array = new int[size];
        for (int i=0;i<array.length;i++){
            System.out.println("Input element array["+i+"] " );
            array[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i=0;i<array.length;i++){
            System.out.print("array["+i+"]" + array[i] + "\t");
        }
        int end = array.length-1;
        int head=0;
        while (head<array.length/2){
            int temp = array[head];
            array[head] = array[end];
            array[end] = temp;
            end--;
            head++;
        }
        System.out.println("\nSau khi dao nguoc la");
        for (int i=0;i<array.length;i++){
            System.out.print("array["+i+"]" + array[i] + "\t");
        }
    }
}
