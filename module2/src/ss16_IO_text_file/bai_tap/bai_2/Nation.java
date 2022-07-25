package ss16_IO_text_file.bai_tap.bai_2;
import java.util.*;
public class Nation {
    String id;
    String code;
    String name;
    public  Nation(){
        this.id = "0";
        this.code = "VN";
        this.name = "Viet Nam";
    }
    public  Nation(String id,String code,String name){
        this.id = id;
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Nation{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public  String getInfo(){
        return this.id + "," + this.code +"," + this.name;
    }
}
