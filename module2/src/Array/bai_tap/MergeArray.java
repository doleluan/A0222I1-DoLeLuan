package Array.bai_tap;
import java.util.*;
public class MergeArray {
    public static Scanner sc = new Scanner(System.in);
    public static   int[] inputArray(int size){
       int [] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Input element array[" + i + "] ");
            array[i] = Integer.parseInt(sc.nextLine());
        }
        return array;
    }
    public static void outputArray(int []arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int size;
        do {
            System.out.println("Input size");
            size = Integer.parseInt(sc.nextLine());
        } while (size <= 0 || size > 20);
        int [] arr1 = inputArray(size);
        do {
            System.out.println("Input size");
            size = Integer.parseInt(sc.nextLine());
        } while (size <= 0 || size > 20);
        int [] arr2 = inputArray(size);
        outputArray(arr1);
        outputArray(arr2);
        int []arr3 = new int[arr1.length + arr2.length];
        for (int i=0;i<arr1.length;i++){
            arr3[i] = arr1[i];
        }
        for (int i=0;i<arr2.length;i++){
            arr3[arr1.length + i] = arr2[i];
        }
        System.out.println("\nSau khi gop mang la: ");
        outputArray(arr3);
    }
}
