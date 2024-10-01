package edu.neu.coe.info6205.threesum;

import edu.neu.coe.info6205.util.Stopwatch;  // Import the custom Stopwatch class from the util package
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSumQuadrithmic {
    private final int[] a;
    private final int length;

    public ThreeSumQuadrithmic(int[] a) {
        this.a = a;
        this.length = a.length;
    }

    /**
     * Get an array of Triples where the sum of three elements is zero.
     * This implementation uses O(N^2 log N) time.
     *
     * @return an array of Triples where the sum of the three elements is zero.
     */
    public Triple[] getTriples() {
        List<Triple> triples = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                Triple triple = getTriple(i, j);
                if (triple != null) {
                    triples.add(triple);
                }
            }
        }
        Collections.sort(triples);  // Sorting the result
        return triples.stream().distinct().toArray(Triple[]::new);
    }

    private Triple getTriple(int i, int j) {
        int index = Arrays.binarySearch(a, -a[i] - a[j]);
        if (index >= 0 && index > j) {
            return new Triple(a[i], a[j], a[index]);
        } else {
            return null;
        }
    }

    // Main method to manually test the ThreeSumQuadrithmic implementation with timing using the doubling method.
    public static void main(String[] args) {
        System.out.println("Timing ThreeSumQuadrithmic:");

        int[] testSizes = {100, 200, 400, 800, 1600};  // Five values for N as required
        for (int N : testSizes) {
            int[] array = generateRandomArray(N);  // Generate random array of size N
            Arrays.sort(array);  // Sort the array before passing to the algorithm

            // Start timing
            Stopwatch stopwatch = new Stopwatch();
            ThreeSumQuadrithmic threeSum = new ThreeSumQuadrithmic(array);
            Triple[] results = threeSum.getTriples();
            double time = stopwatch.elapsedTime();  // Get the elapsed time

            // Print the results
            System.out.printf("N = %d, Time = %.3f seconds, Triples found = %d%n", N, time, results.length);
        }
    }

    private static int[] generateRandomArray(int N) {
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 20000) - 10000;  // Random values between -10000 and 10000
        }
        return array;
    }
}
