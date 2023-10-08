package org.top.jsonapiexample.message;

// класс сообщения, содержащего входные данные для КВУР
// вида ax^2 + bx + c = 0
public class InputMessage implements Message {
    // поля - коэффициенты КВУР
    private Double a;
    private Double b;
    private Double c;

    public InputMessage() {}

    public InputMessage(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return a + "x^2 + " + b + "x + " + c + " = 0";
    }
}
