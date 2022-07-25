package hospital.models;
public class VIPPatient extends Patient {
    private int vipType;
    private String vipTerm;
    public VIPPatient(){
        this.vipType=0;
        this.vipTerm="";
    }

    @Override
    public String getInfo() {
        return this.numOder + "," + this.patientCode  + "," + this.patientName  + "," + this.hopitalizedDate
                + "," + this.dischargeDate  + "," + this.vipType  +"," + this.vipTerm;
    }

    public VIPPatient(int vipType, String vipTerm) {
        this.vipType = vipType;
        this.vipTerm = vipTerm;
    }

    public VIPPatient(int numOder, String patientCode, String patientName, String hopitalizedDate, String dischargeDate, int vipType, String vipTerm) {
        super(numOder, patientCode, patientName, hopitalizedDate, dischargeDate);
        this.vipType = vipType;
        this.vipTerm = vipTerm;
    }
    @Override
    public String toString() {
        return "VIPPatient{" +
                "vipType=" + vipType +
                ", vipTerm='" + vipTerm + '\'' +
                ", numOder=" + numOder +
                ", patientCode='" + patientCode + '\'' +
                ", patientName='" + patientName + '\'' +
                ", hopitalizedDate='" + hopitalizedDate + '\'' +
                ", dischargeDate='" + dischargeDate + '\'' +
                '}';
    }
}
