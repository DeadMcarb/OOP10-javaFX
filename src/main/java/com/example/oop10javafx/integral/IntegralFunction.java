package com.example.oop10javafx.integral;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;

public class IntegralFunction {
    private double start;
    private double end;
    private int nSteps;

    private double step;
    private DoubleUnaryOperator f;

    public IntegralFunction(double start, double end, int nSteps, DoubleUnaryOperator f) {
        this.start = start;
        this.end = end;
        this.nSteps = nSteps;
        this.f = f;
        step = (end - start) / nSteps;
    }

    public double calculate() {
        return IntStream.range(0, nSteps).mapToDouble(i -> start + i * step  +step/2).map(f).map(y -> y * step).sum();
    }
}
