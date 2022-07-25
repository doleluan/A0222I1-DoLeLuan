package hospital.models;

import phone_management.util.ReadAndWrite;

public abstract class Patient {
    protected int numOder;
    protected String patientCode;
    protected String patientName;
    protected String hopitalizedDate;
    protected String dischargeDate;
    public Patient(){
        this.numOder=0;
        this.patientCode="";
        this.patientName="";
        this.hopitalizedDate="";
        this.dischargeDate="";
    }
    public Patient(int numOder, String patientCode, String patientName, String hopitalizedDate, String dischargeDate) {
        this.numOder = numOder;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.hopitalizedDate = hopitalizedDate;
        this.dischargeDate = dischargeDate;
    }

    public int getNumOder() {
        return numOder;
    }

    public void setNumOder(int numOder) {
        this.numOder = numOder;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getHopitalizedDate() {
        return hopitalizedDate;
    }

    public void setHopitalizedDate(String hopitalizedDate) {
        this.hopitalizedDate = hopitalizedDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
    abstract public String getInfo();
}
