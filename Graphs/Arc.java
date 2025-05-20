package Graphs;
public class Arc implements Comparable<Arc> {
    private int origin;
    private int value;
    private int destination;

    public Arc(int origin, int value, int destination) {
        this.origin = origin;
        this.value = value;
        this.destination = destination;
    }

    public int origin() {
        return origin;
    }

    public int value() {
        return value;
    }

    public int destination() {
        return destination;
    }

    @Override
    public int compareTo(Arc other) {
        return Integer.compare(this.value, other.value);
    }
}