package org.top.mvccalculator.service;

public class InputData {
    private Double firstSide;
    private Double secondSide;
    private Double  corner;
    private String typeCorner;

    public InputData() {}

    public InputData(Double firstSide, Double secondSide, Double corner, String typeCorner) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.corner = corner;
        this.typeCorner = typeCorner;
    }

    public Double getFirstSide() {
        return firstSide;
    }

    public void setFirstSide(Double firstSide) {
        this.firstSide = firstSide;
    }

    public Double getSecondSide() {
        return secondSide;
    }

    public void setSecondSide(Double secondSide) {
        this.secondSide = secondSide;
    }

    public Double getCorner() {
        return corner;
    }

    public void setCorner(Double corner) {
        this.corner = corner;
    }

    public String getTypeCorner() {
        return typeCorner;
    }

    public void setTypeCorner(String typeCorner) {
        this.typeCorner = typeCorner;
    }

    @Override
    public String toString() {
        return "\n\tFirst side - " + firstSide + "\n\t Second side - " + secondSide + "\n\t Corner - " + corner + "\n\t Corner type - " + typeCorner;
    }
}
