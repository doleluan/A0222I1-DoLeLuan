package s11_queue_stack.bai_tap.bai1;
import java.util.*;
public class wStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stackString = new Stack<>();
        String str;
        str = sc.nextLine();
        String[] strArray = str.split(" ");
        for (int i=0;i<strArray.length;i++){
            if (!strArray[i].equals("")){
                stackString.push(strArray[i]);
            }
        }
        while (!stackString.isEmpty()){
            System.out.print(stackString.pop());
        }
    }
}
