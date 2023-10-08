package org.top.cosinesspringapi.message;

public class OutputMessage implements Message {
    private final Double c;

    public OutputMessage(Double c) {
        this.c = c;
    }

    public Double getC() {
        return c;
    }

    @Override
    public String toString() {
        return "side of the triangle = " + c;
    }
}
