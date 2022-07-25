package FuramaResort.models;

public class Room extends Facility {
   private String freeService;
    public Room(){
        super();
        this.freeService="";
    }
    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceName, String usableArea, float rentalCosts, int maxPeople, String rentalType, String freeService) {
        super(serviceName, usableArea, rentalCosts, maxPeople, rentalType);
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", usableArea='" + usableArea + '\'' +
                ", rentalCosts=" + rentalCosts +
                ", maxPeople=" + maxPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
