package product.models;

public class Export extends Product{
    private Double exportPrice;
    private String importContry;
    public Export(){
        super();
    }

    public Export(Double exportPrice, String importContry) {
        this.exportPrice = exportPrice;
        this.importContry = importContry;
    }

    public Export(String type,int id, String code, String name, Double price, String manufacturer, Double exportPrice, String importContry) {
        super(type,id, code, name, price, manufacturer);
        this.exportPrice = exportPrice;
        this.importContry = importContry;
    }

    public Double getExportPrice() {
        return exportPrice;
    }

    public String getImportContry() {
        return importContry;
    }

    @Override
    public String toString() {
        return "Export{" +
                "exportPrice=" + exportPrice +
                ", importContry='" + importContry + '\'' +
                '}' + super.toString();
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s",super.getInfo(),exportPrice,importContry);
    }
}
