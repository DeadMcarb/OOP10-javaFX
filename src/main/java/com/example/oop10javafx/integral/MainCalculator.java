package com.example.oop10javafx.integral;

public class MainCalculator {

    private double totalResult;
    private int finished;

    public MainCalculator() {
    }

    public MyPair calculateAll(int nPieces, int nThreads) {
        double a = 1.0;
        double b = Math.sqrt(2.0);


        double delta = (b - a) / nThreads;
        totalResult = 0;
        finished = 0;
        long startTime = System.currentTimeMillis();


        for (int i = 0; i < nThreads; i++) {
            RunnableIntegralCalculator calculator = new RunnableIntegralCalculator(
                    a + i * delta,
                    a + i * delta + delta,
                    nPieces / nThreads,
                    x -> Math.sqrt(2-x*x), this);
            new Thread(calculator).start();
        }
        try {
            synchronized (this) {
                while (finished < nThreads) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted");
        }
        long finishTime = System.currentTimeMillis();

        return new MyPair(totalResult, finishTime - startTime);
    }



    public synchronized void send(double v) {
        totalResult += v;
        finished++;
        notify();
    }


}