package ss17_binaryfile_serialization.thuc_hanh.bai_2;
import java.io.*;
import java.io.Serializable;
import java.util.*;
public class Student implements Serializable {
    private int id;

    private String name;

    private String address;

    public Student() {
    }

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public static void writeToFile(String path, List<Student> students) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(students);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile("D:\\A0222I1-DoLeLuan\\module2\\src\\ss17_binaryfile_serialization\\thuc_hanh\\bai_2\\student.txt", students);
        List<Student> studentDataFromFile = readDataFromFile("D:\\A0222I1-DoLeLuan\\module2\\src\\ss17_binaryfile_serialization\\thuc_hanh\\bai_2\\student.txt");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }
}