package fr.eni.formation.geometrie;

public class Carre extends FigureAdapter {

    public Point origine;
    public double cote;

    public Carre() {
    }

    public Carre(Point origine, double cote){
        this.origine = origine;
        this.cote = cote;
    }

    @Override
    public double aire() {
        return cote * cote;
    }

    @Override
    public double perimetre() {
        return 4 * cote;
    }

    @Override
    public String toString() {
        return String.format("Carre[%s; %6.1f]", origine, cote);
    }
}
