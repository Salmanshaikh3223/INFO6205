package edu.neu.coe.info6205.threesum;

import java.util.Objects;

public class Triple implements Comparable<Triple> {
    private final int a;
    private final int b;
    private final int c;

    public Triple(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static int sum(Triple triple) {
        return triple.a + triple.b + triple.c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple triple = (Triple) o;
        return a == triple.a && b == triple.b && c == triple.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ")";
    }

    @Override
    public int compareTo(Triple other) {
        if (this.a != other.a) {
            return Integer.compare(this.a, other.a);
        } else if (this.b != other.b) {
            return Integer.compare(this.b, other.b);
        } else {
            return Integer.compare(this.c, other.c);
        }
    }
}
