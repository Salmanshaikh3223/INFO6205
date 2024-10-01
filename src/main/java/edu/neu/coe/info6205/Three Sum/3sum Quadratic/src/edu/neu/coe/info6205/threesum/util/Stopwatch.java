package edu.neu.coe.info6205.util;

public class Stopwatch {
    private final long start;

    public Stopwatch() {
        start = System.nanoTime();
    }

    public double elapsedTime() {
        long now = System.nanoTime();
        return (now - start) / 1e9;  // Return time in seconds
    }
}
