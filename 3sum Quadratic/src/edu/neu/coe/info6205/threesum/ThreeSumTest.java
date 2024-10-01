package edu.neu.coe.info6205.threesum;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    @Test
    void testGetTriples0() {
        int[] array = {-1, 0, 1, 2, -1, -4};
        ThreeSumQuadratic threeSumQuadratic = new ThreeSumQuadratic(array);
        List<Triple> triples = threeSumQuadratic.getThreeSumQuadratic();
        assertEquals(2, triples.size());
        assertTrue(triples.contains(new Triple(-1, -1, 2)));
        assertTrue(triples.contains(new Triple(-1, 0, 1)));
    }

    @Test
    void testGetTriples1() {
        int[] array = {0, 0, 0, 0};
        ThreeSumQuadratic threeSumQuadratic = new ThreeSumQuadratic(array);
        List<Triple> triples = threeSumQuadratic.getThreeSumQuadratic();
        assertEquals(1, triples.size());
        assertTrue(triples.contains(new Triple(0, 0, 0)));
    }
    @Test
    void testGetTriples2() {
        int[] array = {1, 2, -2, -1};
        ThreeSumQuadratic threeSumQuadratic = new ThreeSumQuadratic(array);
        List<Triple> triples = threeSumQuadratic.getThreeSumQuadratic();
        assertEquals(0, triples.size()); // Expect no valid triples
    }

}
