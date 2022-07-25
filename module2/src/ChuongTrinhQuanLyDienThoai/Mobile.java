package ChuongTrinhQuanLyDienThoai;
import java.util.*;
public abstract class Mobile {
    static Scanner scanner = new Scanner(System.in);
    protected int id;
    protected String name;
    protected float price;
    protected  String manufactor;
    public Mobile(){
        this.id = 0;
        this.name = "No Name";
        this.price = 0;
        this.manufactor = "No Name";
    }
    public  Mobile(int id,String name,float price, String manufactor){
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufactor = manufactor;
    }
    public void input(){
        System.out.println("Nhap ten san pham: ");
        this.name = scanner.nextLine();
        System.out.println("Nhap gia san pham:  ");
        this.price = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhap ten hang san xuat");
        this.manufactor = scanner.nextLine();
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufactor='" + manufactor + '\'' + ", Type ";
    }
}
