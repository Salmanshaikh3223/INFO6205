package edu.neu.coe.info6205.threesum;

import edu.neu.coe.info6205.util.Stopwatch;  // Import custom Stopwatch class
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumQuadratic {
    private final int[] array;

    public ThreeSumQuadratic(int[] array) {
        this.array = array;
    }

    public List<Triple> getThreeSumQuadratic() {
        List<Triple> result = new ArrayList<>();
        Arrays.sort(array);  // Sorting the array to apply the two-pointer technique

        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;  // Skip duplicate values
            }
            int left = i + 1;
            int right = array.length - 1;
            int target = -array[i];

            while (left < right) {
                int sum = array[left] + array[right];
                if (sum == target) {
                    result.add(new Triple(array[i], array[left], array[right]));
                    left++;
                    right--;
                    while (left < right && array[left] == array[left - 1]) left++;  // Skip duplicates
                    while (left < right && array[right] == array[right + 1]) right--;  // Skip duplicates
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    // Main method to manually test and time the function
    public static void main(String[] args) {
        // Print a header
        System.out.println("Timing ThreeSumQuadratic:");

        // Use the doubling method for testing multiple values of N
        int[] testSizes = {100, 200, 400, 800, 1600};  // Five values for N

        // Loop through each N
        for (int N : testSizes) {
            int[] array = generateRandomArray(N);  // Generate random array of size N

            // Start timing using the custom Stopwatch
            Stopwatch stopwatch = new Stopwatch();
            ThreeSumQuadratic threeSum = new ThreeSumQuadratic(array);
            List<Triple> results = threeSum.getThreeSumQuadratic();
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
