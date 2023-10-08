package org.top.cosinesspringapi.service;

import org.top.cosinesspringapi.message.ErrorMessage;
import org.top.cosinesspringapi.message.InputMessage;
import org.top.cosinesspringapi.message.Message;
import org.top.cosinesspringapi.message.OutputMessage;

public class Solver {
    public Message solve(InputMessage inputMessage) {
        Double a = inputMessage.getA();
        Double b = inputMessage.getB();
        Double corner = inputMessage.getCorner();
        String type = inputMessage.getType();

        if (type.contains("grad")) {
            Double c = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(Math.toRadians(corner)));
            return new OutputMessage(c);
        } else if (type.contains("rad")) {
            Double c = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(corner));
            return new OutputMessage(c);
        } else {
            return new ErrorMessage("Wrong type of corner");
        }
    }
}
