package com.example.oop10javafx.integral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
class IntegralFunctionTest {


    IntegralFunction fun;
    double EPS = 1e-6;
    @Test
    void testCalculate() {
        double a = 1.0;
        double b = Math.sqrt(2.0);
        int nSteps = 1000000000;

        fun = new IntegralFunction (a,b, nSteps, x -> Math.sqrt(2-x*x));

        double expected = 0.28539816;
        assertEquals(expected, fun.calculate(), EPS);
    }
}