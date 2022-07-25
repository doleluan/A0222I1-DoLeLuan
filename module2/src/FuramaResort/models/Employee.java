package FuramaResort.models;

public class Employee extends Person {
    private String employeeCode;
    private String level;
    private String location;
    private float salary;
    public Employee(){
        this.employeeCode ="";
        this.level="";
        this.location="";
        this.salary=0;
    }
    public Employee(String fullName, String dateOfbirth, boolean gender, int CMND, int phoneNumber, String email, String employeeCode, String level, String location, float salary) {
        super(fullName, dateOfbirth, gender, CMND, phoneNumber, email);
        this.employeeCode = employeeCode;
        this.level = level;
        this.location = location;
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeCode='" + employeeCode + '\'' +
                ", level='" + level + '\'' +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                ", fullName='" + fullName + '\'' +
                ", dateOfbirth='" + dateOfbirth + '\'' +
                ", gender=" + gender +
                ", CMND=" + CMND +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
