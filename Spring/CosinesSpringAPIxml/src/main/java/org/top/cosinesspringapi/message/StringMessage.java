package org.top.cosinesspringapi.message;

import java.time.LocalDateTime;

public class StringMessage implements Message {
    private String message;
    private final LocalDateTime time;

    public StringMessage(String message) {
        this.message = message;
        this.time = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
