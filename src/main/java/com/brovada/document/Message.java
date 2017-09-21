package com.brovada.document;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Message {
    private String from;
    private String text;
    private Date when;
    private /*internal only*/ String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    // should only be set by controller..make this package protected?
    public Message sentTo(String to) {
        this.to = to;
        return this;
    }
}
