package codegym.model;

import java.util.Objects;

public class Email {
    private Integer id;
    private String languages;
    private Integer size;
    private String filter;
    private String signature;
    public Email(){

    }

    public Integer getId() {
        return id;
    }

    public Email(Integer id, String languages, Integer size, String filter, String signature) {
        this.id = id;
        this.languages = languages;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Email(String language, Integer size, String filter, String signature) {
        this.languages = language;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return id.equals(email.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
