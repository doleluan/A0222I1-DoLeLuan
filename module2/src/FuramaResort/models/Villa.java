package FuramaResort.models;

public class Villa extends Facility{
   private int roomStandard;
   private float poolArea;
   private int numberFloors;
    public Villa(){
        super();
        this.roomStandard=0;
        this.poolArea = 0;
        this.numberFloors=0;
    }

    public Villa(String serviceName, String usableArea, float rentalCosts, int maxPeople, String rentalType, int roomStandard, float poolArea, int numberFloors) {
        super(serviceName, usableArea, rentalCosts, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public int getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(int roomStandard) {
        this.roomStandard = roomStandard;
    }

    public float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandard=" + roomStandard +
                ", poolArea=" + poolArea +
                ", numberFloors=" + numberFloors +
                ", serviceName='" + serviceName + '\'' +
                ", usableArea='" + usableArea + '\'' +
                ", rentalCosts=" + rentalCosts +
                ", maxPeople=" + maxPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
