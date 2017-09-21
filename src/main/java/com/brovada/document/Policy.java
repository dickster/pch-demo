package com.brovada.document;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.List;

@Document
// TODO : rename QuoteGroup, Quotes...?
public class Policy {

    @Id
    public String id;

    private List<String> quotes = Lists.newArrayList();
    private String primaryQuote = null;
    private Date created;
    // TODO : turn this into a list of comment objects (each having user/date/text/links/attachments etc..)
    private String comments;
    private @Nullable
    String policyNumber; // reference to real, bound policy in system.

    public Policy() {
        created = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }

    public String getPrimaryQuote() {
        return primaryQuote;
    }

    public void setPrimaryQuote(String primaryQuote) {
        this.primaryQuote = primaryQuote;
    }

    public Date getCreated() {
        return created;
    }

    public Policy withQuote(String quoteId) {
        if (primaryQuote==null) {
            return withPrimaryQuote(quoteId);
        }
        else {
            quotes.add(quoteId);
            return this;
        }
    }

    public Policy withPrimaryQuote(String quoteId) {
        quotes.add(primaryQuote = quoteId);
        return this;
    }

    public Policy removeQuote(String quoteId) {
        Preconditions.checkState(quotes.contains(quoteId));
// is this condition legal?       Preconditions.checkState(quoteId==primaryQuote && quotes.size()==1);
        quotes.remove(quoteId);
        return this;
    }

}

