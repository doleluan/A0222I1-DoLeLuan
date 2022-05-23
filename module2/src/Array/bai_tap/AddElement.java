package Array.bai_tap;
import java.util.*;
public class AddElement {
    public static void Addelement(int [] arr, int index, int number){
            for (int i=arr.length-1;i>index;i--){
                arr[i] = arr[i-1];
            }
            arr[index] = number;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
    public static void main(String[] args) {
        int[] array;
        int size;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Input size");
            size = Integer.parseInt(sc.nextLine());
        } while (size <= 0 || size > 20);
        array = new int[size];
        int [] array1 = new int[array.length+1];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Input element array[" + i + "] ");
            array[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        for (int i=0;i<array.length;i++){
            array1[i] = array[i];
        }
        int position,number;
        System.out.println("\nNhap vao vi tri can them");
        position = Integer.parseInt(sc.nextLine());
        System.out.println("\nNhap vao so can them");
        number = Integer.parseInt(sc.nextLine());
        if (position<0 || position>array1.length-1){
            System.out.println("\nKhong the them");
        }else {
            Addelement(array1,position,number);
        }
    }
}
