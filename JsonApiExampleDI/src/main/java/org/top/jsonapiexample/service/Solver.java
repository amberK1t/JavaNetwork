package org.top.jsonapiexample.service;

import org.springframework.stereotype.Service;
import org.top.jsonapiexample.message.InputMessage;
import org.top.jsonapiexample.message.OutputMessage;

// интерфейс решателя КВУР
@Service
public interface Solver {
    OutputMessage solve(InputMessage input);
}
