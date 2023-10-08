package org.top.jsonapiexample.message;

// класс сообщения, содержащего решение для КВУР
public class OutputMessage implements Message {
    // поля - решение КВУР
    private final Integer  rootsCount;    // кол-во корней
    private final Double x1;              // сами корни
    private final Double x2;

    public OutputMessage(Integer rootsCount, Double x1, Double x2) {
        this.rootsCount = rootsCount;
        this.x1 = x1;
        this.x2 = x2;
    }

    public Integer getRootsCount() {
        return rootsCount;
    }

    public Double getX1() {
        return x1;
    }

    public Double getX2() {
        return x2;
    }

    @Override
    public String toString() {
        return "OutputMessage{" +
                "rootsCount=" + rootsCount +
                ", x1=" + x1 +
                ", x2=" + x2 +
                '}';
    }
}
