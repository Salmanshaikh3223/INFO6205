package edu.neu.coe.info6205.threesum;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    @Test
    void testGetTriples0() {
        int[] array = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(array);  // Ensure the array is sorted
        ThreeSumQuadrithmic threeSumQuadrithmic = new ThreeSumQuadrithmic(array);
        Triple[] triples = threeSumQuadrithmic.getTriples();
        assertEquals(2, triples.length);  // We expect 2 unique triples
        assertTrue(Arrays.asList(triples).contains(new Triple(-1, -1, 2)));
        assertTrue(Arrays.asList(triples).contains(new Triple(-1, 0, 1)));
    }

    @Test
    void testGetTriples2() {
        int[] array = {1, 2, -2, -1};  // Case where no valid triples exist
        Arrays.sort(array);  // Ensure the array is sorted
        ThreeSumQuadrithmic threeSumQuadrithmic = new ThreeSumQuadrithmic(array);
        Triple[] triples = threeSumQuadrithmic.getTriples();
        assertEquals(0, triples.length);  // We expect no triples
    }

    @Test
    void testThreeSumQuadrithmic() {
        int[] array = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(array);  // Ensure the array is sorted
        ThreeSumQuadrithmic threeSum = new ThreeSumQuadrithmic(array);
        Triple[] triples = threeSum.getTriples();
        assertEquals(2, triples.length);  // We expect 2 unique triples
        assertTrue(Arrays.asList(triples).contains(new Triple(-1, 0, 1)));
        assertTrue(Arrays.asList(triples).contains(new Triple(-1, -1, 2)));
    }
}
