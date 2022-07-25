package hospital.util;

import hospital.models.NormalPatient;
import hospital.models.Patient;
import hospital.models.VIPPatient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    final static String pathFile = "D:\\A0222I1-DoLeLuan\\module2\\src\\hopital_management\\data\\medical_records.csv";
    public static List<String> readFileCSV(String pathFile){
        List<String> list = new ArrayList<>();
        try {
            File file = new File(pathFile);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line="";
            while ((line=br.readLine())!=null){
                list.add(line);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return  list;
    }
    public static  void writeFile(String path, List<Patient> patients){
        try {
            FileWriter fileWriter = new FileWriter(path,false);
            BufferedWriter bufferedWriter;
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Patient patient : patients ){
                bufferedWriter.write(String.valueOf(patient.getInfo()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<Patient> readPatient(){
        List<Patient> patients = new ArrayList<>();
        List<String> strings = readFileCSV(pathFile);
        String [] arr;
        for (int i =0;i<strings.size();i++){
            int count =0;
            for (int j=0;j<strings.get(i).length();j++){
                if (strings.get(i).charAt(j)==','){
                    count++;
                }
            }
            arr = strings.get(i).split(",");
            if (count==5){
                patients.add(new NormalPatient(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],arr[4],Float.parseFloat(arr[5])));
            }
            else if(count==6){
                patients.add(new VIPPatient(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],arr[4],Integer.parseInt(arr[5]),arr[6]));
            }
        }
        return  patients;
    }
}
