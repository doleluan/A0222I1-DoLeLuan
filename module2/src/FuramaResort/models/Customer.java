package FuramaResort.models;

public class Customer extends Person {
    private String customerCode;
    private String typeCustomer;
    private String address;
    public Customer(){
        this.customerCode="";
        this.typeCustomer="";
        this.address="";
    }
}
