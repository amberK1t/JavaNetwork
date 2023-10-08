package org.top.cosinesspringapi.message;


public class InputMessage implements Message{
    private Double a;
    private Double b;
    private Double corner;
    private String type;

    public InputMessage() {}

    public InputMessage(Double a, Double b, Double corner, String type) {
        this.a = a;
        this.b = b;
        this.corner = corner;
        this.type = type;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getCorner() {
        return corner;
    }

    public void setCorner(double corner) {
        this.corner = corner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "a = " + a + " - b = " + b + " - Corner = " + corner;
    }
}
