package FuramaResort.models;

public abstract class Facility {
        protected String serviceName;
        protected String usableArea;
        protected float rentalCosts;
        protected int maxPeople;
        protected String rentalType;
        public Facility(){
            this.serviceName = "";
            this.usableArea = "";
            this.rentalCosts = 0;
            this.maxPeople = 0;
            this.rentalType ="";
        }
    public Facility(String serviceName, String usableArea, float rentalCosts, int maxPeople, String rentalType) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(String usableArea) {
        this.usableArea = usableArea;
    }

    public float getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(float rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", usableArea='" + usableArea + '\'' +
                ", rentalCosts=" + rentalCosts +
                ", maxPeople=" + maxPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}

