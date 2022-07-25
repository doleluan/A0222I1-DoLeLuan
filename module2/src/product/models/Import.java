package product.models;

public class Import extends Product {
    private Double importPrices;
    private String importProvince;
    private float importTax;
    public Import(){
        super();
    }

    public Import(String type,int id, String code, String name, Double price, String manufacturer, Double importPrices, String importProvince, float importTax) {
        super(type,id, code, name, price, manufacturer);
        this.importPrices = importPrices;
        this.importProvince = importProvince;
        this.importTax = importTax;
    }

    public Double getImportPrices() {
        return importPrices;
    }

    public void setImportPrices(Double importPrices) {
        this.importPrices = importPrices;
    }

    public String getImportProvince() {
        return importProvince;
    }

    public void setImportProvince(String importProvince) {
        this.importProvince = importProvince;
    }

    public float getImportTax() {
        return importTax;
    }

    public void setImportTax(float importTax) {
        this.importTax = importTax;
    }

    @Override
    public String toString() {
        return "Import{" +
                "importPrices=" + importPrices +
                ", importProvince='" + importProvince + '\'' +
                ", importTax=" + importTax +
                '}' + super.toString();
    }
    public String getInfo(){
        return String.format("%s,%s,%s,%s",super.getInfo(),importPrices,importProvince,importTax);
    }
}
