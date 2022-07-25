package phone_management.models;
public class AuthenticPhone extends Phone {
    private String durationByYear;
    private String durationByCode;
    public AuthenticPhone(){

    }
    public AuthenticPhone(int id, String name, Double price, String manufacturer, String durationByYear, String durationByCode) {
        super(id, name, price, manufacturer);
        this.durationByYear = durationByYear;
        this.durationByCode = durationByCode;
    }

    public String getDurationByYear() {
        return durationByYear;
    }

    public void setDurationByYear(String durationByYear) {
        this.durationByYear = durationByYear;
    }

    public String getDurationByCode() {
        return durationByCode;
    }

    public void setDurationByCode(String durationByCode) {
        this.durationByCode = durationByCode;
    }

    @Override
    public String toString() {
        return "AuthenticPhone{" +
                "durationByYear='" + durationByYear + '\'' +
                ", durationByCode='" + durationByCode + '\'' +
                '}' + super.toString();
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,1",this.getId(),this.getName(),this.getPrice(),this.getManufacturer(),this.getDurationByYear(),this.getDurationByCode());
    }
}
