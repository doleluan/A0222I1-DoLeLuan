package product.models;

public abstract class Product {
    private int id;
    private String code;
    private String name;
    private Double price;
    private String manufacturer;
    private String type;
    public Product(){};
    public Product(String type,int id, String code, String name, Double price, String manufacturer) {
        this.type = type;
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
    public  String getInfo(){
        return String.format("%s,%s,%s,%s,%s,%s",type,id,code,name,price,manufacturer);
    };
}
