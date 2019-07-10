package fr.eni.formation.geometrie;

public class Segment extends Element {

    public Point origine;
    public Point destination;


    public double longueur() {
        return Math.sqrt(
                (origine.x - destination.x) * (origine.x - destination.x)
                + (origine.y - destination.y) * (origine.y - destination.y)
        );
    }
}
