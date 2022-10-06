package codegym.repository.impl;

import codegym.model.Email;
import codegym.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmailRepository implements IEmailRepository {
   private static List<Email> emails = new ArrayList<>();
    static {
        emails.add(new Email(1,"english",30,"aaa","bbbb"));
        emails.add(new Email(2,"english",30,"aaa","bbbb"));
    }
    @Override
    public List<Email> findAll() {
        return emails;
    }

    @Override
    public void update(Email email) {
        if (email.getId()==null){
            int lastId = emails.get(emails.size()-1).getId();
            email.setId(lastId);
            emails.add(email);
        }
        else {
            for (int i = 0; i < emails.size(); i++) {
                if(emails.get(i).getId() == email.getId()){
                    emails.set(i, email);
                    break;
                }
            }
        }
    }

    @Override
    public Email find(int id) {
        for(int i=0;i<emails.size();i++){
            if (emails.get(i).getId()==id){
                return emails.get(i);
            }
        }
        return  null;
    }

}
