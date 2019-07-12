package fr.eni.formation.geometrie;

public class Cercle extends FigureAdapter {

    public Point centre;
    public double rayon;

    public Cercle() {
    }

    public Cercle(Point centre, double rayon) {
        this.centre = centre;
        this.rayon = rayon;
    }

    @Override
    public double aire() {
        return Math.PI * rayon * rayon;
    }

    @Override
    public double perimetre() {
        return Math.PI * 2.0 * rayon;
    }

    @Override
    public void deplacer(double dx, double dy) {
        centre.deplacer(dx, dy);
    }

    @Override
    public String toString() {
        return String.format("Cercle[%s; %6.1f]", centre, rayon);
    }
}
