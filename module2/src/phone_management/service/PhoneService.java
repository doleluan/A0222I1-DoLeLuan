package phone_management.service;

import phone_management.exception.NotFoundException;
import phone_management.models.Phone;
import phone_management.util.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class PhoneService {
    List<Phone> phones = new ArrayList<>();
    ReadAndWrite readAndWrite = new ReadAndWrite();
    private static String PATH = "D:\\A0222I1-DoLeLuan\\module2\\src\\phone_management\\data\\data.csv";
    public PhoneService(){
        phones = readAndWrite.readPhone();
    }
    public void addPhone(Phone phone){
        int lastId=0;
        if (phones.size()>0){
            lastId = phones.get(phones.size()-1).getId();
        }
        phone.setId(lastId+1);
        phones.add(phone);
        readAndWrite.writeToFile(PATH,phones);
    }
    public void deletePhone(int id) throws NotFoundException {
        for (int i=0;i<phones.size();i++){
            if (phones.get(i).getId()==id){
                phones.remove(i);
                readAndWrite.writeToFile(PATH,phones);
                return;
            }
        }
    throw new NotFoundException(id + "Not exits");
    }
    public List<Phone> displayPhones(){
        return phones;
    }
    public List <Phone> searchName(String name){
        List<Phone> temp = new ArrayList<>();
        for (int i=0;i<phones.size();i++){
            if (phones.get(i).getName().equalsIgnoreCase(name)){
                temp.add(phones.get(i));
            }
        }
        return  temp;
    }
}
