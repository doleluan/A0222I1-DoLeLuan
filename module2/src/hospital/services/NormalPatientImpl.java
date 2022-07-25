package hospital.services;

import hospital.models.Patient;
import hospital.util.ReadAndWrite;

import java.util.List;

public class NormalPatientImpl implements PatientServices {

    @Override
    public void addPatient() {
        List<Patient> patients = ReadAndWrite.readPatient();
    }

    @Override
    public void deletePatient() {

    }

    @Override
    public void displayPatient() {

    }
}
