package edu.neu.coe.info6205.threesum;

import edu.neu.coe.info6205.util.Stopwatch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.Arrays;

public class ThreeSumQuadraticWithCalipers implements ThreeSum {

    private final int[] a;
    private final int length;

    public ThreeSumQuadraticWithCalipers(int[] ints) {
        this.a = ints;
        this.length = ints.length;
    }

    @Override
    public Triple[] getTriples() {
        List<Triple> triples = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            triples.addAll(calipers(a, i, Triple::sum));
        }
        Collections.sort(triples);
        return triples.stream().distinct().toArray(Triple[]::new);  // Remove duplicates
    }

    public static List<Triple> calipers(int[] a, int i, Function<Triple, Integer> function) {
        List<Triple> triples = new ArrayList<>();
        int left = i + 1;
        int right = a.length - 1;

        while (left < right) {
            Triple triple = new Triple(a[i], a[left], a[right]);
            int sum = function.apply(triple);
            if (sum == 0) {
                triples.add(triple);
                left++;
                right--;
                // Skip duplicates
                while (left < right && a[left] == a[left - 1]) left++;
                while (left < right && a[right] == a[right + 1]) right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        return triples;
    }
}
