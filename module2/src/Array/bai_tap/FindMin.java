package Array.bai_tap;
import java.util.*;
public class FindMin {
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
        int min =arr1[0];
        for (int i=0;i<arr1.length;i++){
            if (min>arr1[i]){
                min = arr1[i];
            }
        }
        System.out.println("Phan tu nho nhat trong mang la: " + min);
    }
}
