package com.brovada.old.document;

import com.google.common.collect.Lists;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class QuoteResult {

    private static int SUCCESS = 0;
    private static int TIMEOUT = 1;
    private static int INVALID_DATA = 2;

    private double totalPremium;
    private Date created;
    private List<String> notes = Lists.newArrayList();
    private long status;
    private Date expiry;
    private String quoteMethod;
    private String referrer;


    public static QuoteResult success(double totalPremium) {
        return new QuoteResult(SUCCESS).withTotalPremium(totalPremium);
    }

    public static QuoteResult timeout() {
        return new QuoteResult(TIMEOUT);
    }

    public static QuoteResult invalid() {
        return new QuoteResult(INVALID_DATA);
    }

    private QuoteResult(long status) {
        this.created = new Date();
    }

    public QuoteResult withTotalPremium(double total){
        this.totalPremium = total;
        return this;
    }

    public QuoteResult expiring(Date expiry) {
        this.expiry = expiry;
        return this;
    }

    public double getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(double totalPremium) {
        this.totalPremium = totalPremium;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public String getQuoteMethod() {
        return quoteMethod;
    }

    public void setQuoteMethod(String quoteMethod) {
        this.quoteMethod = quoteMethod;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }


    // TODO : add other getter/setters...
}
