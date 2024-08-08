package com.firuz.demo.advice;

import java.time.LocalDateTime;

public class ErrorDetails {
    private String statusCode;
    private String msg;
    private LocalDateTime when;
    
    
    public String getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public LocalDateTime getWhen() {
        return when;
    }
    public void setWhen(LocalDateTime when) {
        this.when = when;
    }
    
    
    public ErrorDetails(String statusCode, String msg, LocalDateTime when) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.when = when;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
