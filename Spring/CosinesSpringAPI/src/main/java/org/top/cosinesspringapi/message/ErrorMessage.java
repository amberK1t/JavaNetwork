package org.top.cosinesspringapi.message;

public class ErrorMessage implements Message{
    private String error;

    public ErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
