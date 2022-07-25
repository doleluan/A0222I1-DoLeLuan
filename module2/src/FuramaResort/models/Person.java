package FuramaResort.models;

import java.time.LocalDate;

public abstract class Person {
   protected String fullName;
   protected String dateOfbirth;
   protected  boolean gender;
   protected int CMND;
   protected int phoneNumber;
   protected String email;
   public Person(){
      this.fullName ="";
      this.dateOfbirth = "";
      this.gender=true;
      this.CMND=0;
      this.phoneNumber=0;
      this.email="";
   }
   public String getFullName() {
      return fullName;
   }

   public void setFullName(String fullName) {
      this.fullName = fullName;
   }

   public Person(String fullName, String dateOfbirth, boolean gender, int CMND, int phoneNumber, String email) {
      this.fullName = fullName;
      this.dateOfbirth = dateOfbirth;
      this.gender = gender;
      this.CMND = CMND;
      this.phoneNumber = phoneNumber;
      this.email = email;
   }

   public String getDateOfbirth() {
      return dateOfbirth;
   }

   public void setDateOfbirth(String dateOfbirth) {
      this.dateOfbirth = dateOfbirth;
   }

   public boolean isGender() {
      return gender;
   }

   public void setGender(boolean gender) {
      this.gender = gender;
   }

   public int getCMND() {
      return CMND;
   }

   public void setCMND(int CMND) {
      this.CMND = CMND;
   }

   public int getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(int phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
