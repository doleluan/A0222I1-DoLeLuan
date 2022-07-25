package ss12_java_collection_framework.thuc_hanh.bai_1;
import java.util.*;
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(5, "Hoang");
        hashMap.put(9, "Khanh");
        hashMap.put(2, "Sy");
        hashMap.put(4, "Hop");
        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");

        Map<Integer, String> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));
    }
}
