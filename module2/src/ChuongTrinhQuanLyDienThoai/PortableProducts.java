package ChuongTrinhQuanLyDienThoai;
public class PortableProducts extends Mobile {
    private String nation;
    private String status;
    public PortableProducts(){
        super();
        this.nation ="";
        this.status ="";
    }
    public PortableProducts(int id,String name,float price, String manufactor,String nation,String status){
        super(id,name,price,manufactor);
        this.nation = nation;
        this.status = status;
    }
    public void setNation(String nation){
        this.nation = nation;
    }
    public String getNation(){
        return  this.nation;
    }
    public  void setStatus(String status){
        this.status = status;
    }
    public  String getStatus(){
        return  this.status;
    }
    public void input(){
        super.input();
        System.out.println("Nhap quoc gia: ");
        this.nation = scanner.nextLine();
        System.out.println("Nhap trang thai: ");
        this.status = scanner.nextLine();
    }
    @Override
    public String toString() {
        return  super.toString() + "PortableProducts: " +
                "nation='" + nation + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
