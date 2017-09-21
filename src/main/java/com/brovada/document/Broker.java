package com.brovada.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Broker {

    @Id
    public String id;

    private String firstName;
    private String lastName;
    private String number;
    private String desc;

    public Broker() {}

    public Broker(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = "" +(int)(Math.random()*1000);
        this.desc = makeDesc();
    }

    private String makeDesc() {
        return firstName + " " + lastName + "  (" + number + ")";
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public Broker getNumber(String number) {
        this.number = number;
        return this;
    }

    @Override
    public String toString() {
        return "Broker{" +
                "firstName='" + firstName + '\'' +
                ", id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getDesc() {
        return desc;
    }

}

