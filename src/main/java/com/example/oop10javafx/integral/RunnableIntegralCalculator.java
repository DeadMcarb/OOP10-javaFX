package com.example.oop10javafx.integral;

import java.util.function.DoubleUnaryOperator;

public class RunnableIntegralCalculator implements Runnable {

    private MainCalculator mainCalculator;

    private IntegralFunction integralFunction;

    public RunnableIntegralCalculator(double start, double end, int nSteps, DoubleUnaryOperator f, MainCalculator mainCalculator) {
        integralFunction = new IntegralFunction(start, end, nSteps, f);
        this.mainCalculator = mainCalculator;
    }

    @Override
    public void run() {
        double v = integralFunction.calculate();
        mainCalculator.send(v);
    }
}