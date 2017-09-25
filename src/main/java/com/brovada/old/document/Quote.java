package com.brovada.old.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.Optional;

@Document
public class Quote {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public Date startDate;
    public Date endDate;
    public @Nullable QuoteResult result;
    // etc...

    public Quote() {}

    public Quote(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = new Date();
        this.endDate = new Date();
        this.endDate.setYear(2018);
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Optional<QuoteResult> getResult() {
        return Optional.ofNullable(result);
    }


    @Override
    public String toString() {
        return "Quote{" +
                "endDate=" + endDate +
                ", firstName='" + firstName + '\'' +
                ", id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startDate=" + startDate +
                '}';
    }

    public void setResult(@Nullable QuoteResult result) {
        this.result = result;
    }
}

