package Array.thuc_hanh;
import java.util.*;
public class FindMax {
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
        int max = array[0], index=0;
        for (int i=0;i<array.length;i++){
            if (array[i]>max){
                max = array[i];
                index=i;
            }
        }
        System.out.println("\nMax is: " + max + " at index " + index);
    }
}
