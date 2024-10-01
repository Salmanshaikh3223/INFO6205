package edu.neu.coe.info6205.threesum;

import edu.neu.coe.info6205.util.Stopwatch;
import java.util.ArrayList;
import java.util.List;

public class ThreeSumCubic {
    private final int[] array;

    public ThreeSumCubic(int[] array) {
        this.array = array;
    }

    public List<Triple> getThreeSumCubic() {
        List<Triple> result = new ArrayList<>();

        // Cubic time complexity O(N^3) with three nested loops
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        result.add(new Triple(array[i], array[j], array[k]));
                    }
                }
            }
        }
        return result;
    }

    // Main method to manually test the cubic algorithm using the doubling method
    public static void main(String[] args) {
        System.out.println("Timing ThreeSumCubic:");

        // Five values for N (doubling method)
        int[] testSizes = {100, 200, 400, 800, 1600};

        // Loop through each N and generate random arrays, time the execution
        for (int N : testSizes) {
            int[] array = generateRandomArray(N);  // Generate random array of size N

            // Start timing
            Stopwatch stopwatch = new Stopwatch();
            ThreeSumCubic threeSum = new ThreeSumCubic(array);
            List<Triple> results = threeSum.getThreeSumCubic();
            double time = stopwatch.elapsedTime();  // Get the elapsed time

            // Print the results
            System.out.printf("N = %d, Time = %.3f seconds, Triples found = %d%n", N, time, results.size());
        }
    }

    // Utility method to generate an array of random integers
    private static int[] generateRandomArray(int N) {
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 20000) - 10000;  // Random values between -10000 and 10000
        }
        return array;
    }
}
