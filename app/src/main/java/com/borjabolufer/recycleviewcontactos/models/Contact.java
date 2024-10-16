package com.borjabolufer.recycleviewcontactos.models;

public class Contact {
    private final String name;
    private final String firstSurname;
    private final String secondSurname;
    private final String phone1;
    private final String phone2;
    private final String email;

    public Contact(String name, String firstSurname, String secondSurname, String phone1, String phone2, String email) {
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
