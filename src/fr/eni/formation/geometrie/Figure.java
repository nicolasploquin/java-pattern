package fr.eni.formation.geometrie;

public abstract class Figure extends Element {

    public abstract double aire();
    public abstract double perimetre();

    @Override
    public void deplacer(double dx, double dy) {
        throw new UnsupportedOperationException();
    }
}
