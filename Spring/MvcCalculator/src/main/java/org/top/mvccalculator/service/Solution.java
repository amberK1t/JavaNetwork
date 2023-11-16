package org.top.mvccalculator.service;

public class Solution {
    private String requiredSide;

    public Solution() {}

    public Solution(String requiredSide) {
        this.requiredSide = requiredSide;
    }

    public String getRequiredSide() {
        return requiredSide;
    }

    public void setRequiredSide(String requiredSide) {
        this.requiredSide = requiredSide;
    }

    public String toString() {
        return requiredSide;
    }

}
