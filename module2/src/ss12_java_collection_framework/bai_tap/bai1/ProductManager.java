package ss12_java_collection_framework.bai_tap.bai1;
import java.util.*;
public class ProductManager {
    List<Product> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private static int idList = 1;
    public void addProduct(){
        while (true){
            System.out.println("(1) Nhap thong tin san pham can them/So Khac: Stop");
            int choose = Integer.parseInt(sc.nextLine());
            if (choose==1){
                int lastId = 0;
                if(list.size() > 0){
                    lastId = list.get(list.size() -1).getId();
                }
                int id = idList;
                System.out.println("Nhap ten san pham can them");
                String name = sc.nextLine();
                System.out.println("Nhap gia san pham can them");
                float price = Float.parseFloat(sc.nextLine());
                list.add(new Product(lastId + 1 ,name,price));
                idList++;
            }else {
                break;
            }
        }
    }
    public void findName(){
        if (list.size()!=0){
            System.out.println("Nhap ten can tim: ");
            String name = sc.nextLine();
            int dem =0;
            for (Product product:list){
                if (product.getName().equals(name)){
                    System.out.println(product);
                }
            }
            if (dem==0){
                System.out.println("Khong co ten san pham can tim");
            }
        }else {
            System.out.println("Danh sach rong");
        }
    }
    public void fixProdcut(){
        if (list.size()!=0){
            System.out.println("Nhap id san pham can sua: ");
            int id = Integer.parseInt(sc.nextLine());
            int dem =0;
            for (Product product : list){
                if (product.getId()==id){
                    System.out.println("Nhap ten can sua");
                    String newName = sc.nextLine();
                    System.out.println("Nhap gia can sua");
                    float newPrice = Float.parseFloat(sc.nextLine());
                    product.setName(newName);
                    product.setPrice(newPrice);
                    dem++;
                }
            }
            if (dem==0){
                System.out.println("Khong co id san pham nao can sua");
            }
            displayProduct();
        }else {
            System.out.println("Danh sach rong. Khong co gi de sua");
        }
    }
    public void sortUp(){
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getPrice() > o2.getPrice()){
                    return 1;
                }else if(o1.getPrice() == o2.getPrice()){
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        displayProduct();
    }
    public void sortDescending(){
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getPrice() < o2.getPrice()){
                    return 1;
                }else if(o1.getPrice() == o2.getPrice()){
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        displayProduct();
    }
    public int findId(int id){
        for (int i =0;i<this.list.size();i++){
            Product pr = this.list.get(i);
            if(pr.getId()==id){
                return i;
            }
        }
        return -1;
    }
    public void removeProdcut(){
        if (list.size()!=0){
            System.out.println("Nhap id san pham can xoa: ");
            int id = Integer.parseInt(sc.nextLine());
            int dem =0;
            if (findId(id)!=-1){
                list.remove(id);
            }else {
                System.out.println("id khong dung");
            }
            displayProduct();
        }else {
            System.out.println("Danh sach rong. Khong co gi de xoa");
        }

    }
    public void displayProduct(){
        for (Product product :list){
            System.out.println(product);
        }
    }
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct();
        productManager.displayProduct();
        productManager.fixProdcut();
//        productManager.removeProdcut();
        productManager.sortUp();
        productManager.sortDescending();
    }

}
