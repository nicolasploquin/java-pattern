package fr.eni.formation.geometrie;

public class Point extends Element implements Cloneable {

    public double x;
    public double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /** Factory Method */
    public static Point createPoint(double x, double y) {
        return new Point(x, y);
    }


    @Override
    public String toString() {
        return String.format("Point(%3.1f;%3.1f)", x, y);
    }

    @Override
    protected Point clone() {
        return createPoint(x, y);
    }

    @Override
    public void deplacer(double dx, double dy) {
        x += dx;
        y += dy;
        notifyObservers();
    }

}
