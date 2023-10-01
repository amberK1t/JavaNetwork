package org.top.jsonapiexample.message;

import java.time.LocalDateTime;

// Класс описания строкового сообщения
public class StringMessage implements Message{
    private String message;         // текст сообщения
    private final LocalDateTime time;     // время создания сообщения

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
