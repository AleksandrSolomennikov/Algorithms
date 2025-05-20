package Graphs;

public class Vertex {
    private int name;
    private int distance;

    public Vertex(int name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public int getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setName(int name) {
        this.name = name;
    }
}
