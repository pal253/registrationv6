package com.api6.payload;

import java.util.Date;

public class ErrorDto {
    private String Message;
    private Date date ;
    private String uri;

    public ErrorDto(String message, Date date, String uri) {
        Message = message;
        this.date = date;
        this.uri = uri;
    }

    public String getMessage() {
        return Message;
    }

    public Date getDate() {
        return date;
    }

    public String getUri() {
        return uri;
    }
}
