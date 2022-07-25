package hospital.models;

public class NormalPatient extends Patient {
    private float fees;

    public NormalPatient() {
        super();
        this.fees = 0;
    }

    @Override
    public String getInfo() {
        return this.numOder + "," + this.patientCode  + "," + this.patientName  + "," + this.hopitalizedDate
                + "," + this.dischargeDate  + "," + this.fees;
    }

    public NormalPatient(int numOder, String patientCode, String patientName, String hopitalizedDate, String dischargeDate, float fees) {
        super(numOder, patientCode, patientName, hopitalizedDate, dischargeDate);
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "NormalPatient{" +
                "fees=" + fees +
                ", numOder=" + numOder +
                ", patientCode='" + patientCode + '\'' +
                ", patientName='" + patientName + '\'' +
                ", hopitalizedDate='" + hopitalizedDate + '\'' +
                ", dischargeDate='" + dischargeDate + '\'' +
                '}';
    }
}

