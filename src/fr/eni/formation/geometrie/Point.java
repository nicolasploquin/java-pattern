package fr.eni.formation.geometrie;

public class Point extends Element {

    public double x;
    public double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Point(%3.1f,%3.1f)", x, y);
    }
}
