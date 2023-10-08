package org.top.jsonapiexample.service;

import org.top.jsonapiexample.message.InputMessage;
import org.top.jsonapiexample.message.OutputMessage;

// Класс, обеспечивающий решение КВУР
public class Solver {

    // статический метод решения КВУР
    // принимает на вход объект с коэффициентами
    // возвращает объект решения КВУР
    public static OutputMessage solve(InputMessage input) {
        Double a = input.getA();
        Double b = input.getB();
        Double c = input.getC();
        if (a == null || b == null || c == null || a == 0) {
            // выбросить исключение
            throw new IllegalArgumentException("invalid coefficients");
        }
        // решение КВУР
        double D = b * b - 4 * a * c;
        if (D == 0) {
            double x = -b / (2 * a);
            return new OutputMessage(1, x, x);
        }
        if (D > 0) {
            double d = Math.sqrt(D);
            double x1 = (-b - d) / (2 * a);
            double x2 = (-b + d) / (2 * a);
            return new OutputMessage(2, x1, x2);
        }
        return new OutputMessage(0, null, null);
    }
}
