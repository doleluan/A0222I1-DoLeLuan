package Array.bai_tap;
import java.util.*;
public class RemoveElement {
    public static void removeIndex(int [] arr,int index) {
        if (index < 0) index = 0;
        else if (index > arr.length - 1) index = arr.length - 1;
        for (int i = index; i < arr.length; i++) {
            if (i==arr.length-1){
                arr[i] = 0;
            }else {
                arr[i] = arr[i + 1];
            }
        }
    }
        public static void main (String[]args){
            int[] array;
            int size;
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("Input size");
                size = Integer.parseInt(sc.nextLine());
            } while (size <= 0 || size > 20);
            array = new int[size];
            for (int i = 0; i < array.length; i++) {
                System.out.println("Input element array[" + i + "] ");
                array[i] = Integer.parseInt(sc.nextLine());
            }
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + "\t");
            }
            int number;
            System.out.println("\nNhap vi tri can xoa");
            number = Integer.parseInt(sc.nextLine());
            removeIndex(array,number);
            System.out.println("Mang sau khi xoa la: ");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + "\t");
            }
        }
    }
