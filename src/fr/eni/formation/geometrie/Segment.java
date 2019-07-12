package fr.eni.formation.geometrie;

public class Segment extends Element implements Cloneable {

    public Point origine;
    public Point destination;

    public Segment() {
    }

    public Segment(Point origine, Point destination) {
        this.origine = origine;
        this.destination = destination;
        this.origine.subscribe(this);
        this.destination.subscribe(this);
    }

    public double longueur() {
        return Math.sqrt(
                (origine.x - destination.x) * (origine.x - destination.x)
                + (origine.y - destination.y) * (origine.y - destination.y)
        );
    }

    @Override
    protected Segment clone() {
        return new Segment(origine.clone(), destination.clone());
    }

    @Override
    public String toString() {
        return String.format("Segment[%s; %s; l=%4.1f]", origine, destination, longueur());
    }

    @Override
    public void deplacer(double dx, double dy) {
        origine.deplacer(dx,dy);
        destination.deplacer(dx,dy);
    }

    @Override
    public void update() {
        System.out.printf("Une des extrémités a été déplacée. La longueur est %6.1f\n", longueur());
    }
}
