package org.top.mvccalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CosinesTheoremSolver implements Solver {

    public Solution solve(InputData inputData) throws Exception {
        Double firstSide = inputData.getFirstSide();
        Double secondSide = inputData.getSecondSide();
        Double corner = inputData.getCorner();
        String typeCorner = inputData.getTypeCorner();

        double requiredSide;

        if (inputData.getFirstSide() > 0 && inputData.getSecondSide() > 0 && inputData.getCorner() > 0) {
            if (typeCorner.equals("град")) {
                requiredSide = Math.sqrt(firstSide * firstSide + secondSide * secondSide - 2 * firstSide * secondSide * Math.cos(Math.toRadians(corner)));
                return new Solution(String.valueOf(requiredSide));
            } else if (typeCorner.equals("рад")) {
                requiredSide = Math.sqrt(firstSide * firstSide + secondSide * secondSide - 2 * firstSide * secondSide * Math.cos(corner));
                return new Solution(String.valueOf(requiredSide));
            } else {
                throw new Exception("wrong corner type");
            }
        } else {
            return new Solution("Только положительные числа");
        }

    }
}
