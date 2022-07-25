package FuramaResort.models;

public class House extends Facility {
    private int roomStandard;
    private int numberFloors;

    public House() {
        super();
        this.roomStandard = 0;
        this.numberFloors = 0;
    }

    public House(String serviceName, String usableArea, float rentalCosts, int maxPeople, String rentalType, int roomStandard, int numberFloors) {
        super(serviceName, usableArea, rentalCosts, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public int getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(int roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandard=" + roomStandard +
                ", numberFloors=" + numberFloors +
                ", serviceName='" + serviceName + '\'' +
                ", usableArea='" + usableArea + '\'' +
                ", rentalCosts=" + rentalCosts +
                ", maxPeople=" + maxPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
