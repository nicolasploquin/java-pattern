package fr.eni.formation.geometrie;

public class CarreBuilder {

    public Point origine;
    public double cote;

    public CarreBuilder setOrigine(Point origine) {
        this.origine = origine;
        return this;
    }

    public CarreBuilder setCote(double cote) {
        this.cote = cote;
        return this;
    }

    public CarreBuilder setCote(Segment cote) {
        this.origine = cote.origine;
        this.cote = cote.longueur();
        return this;
    }

    public Carre build() {
        return new Carre(origine, cote);
    }
}