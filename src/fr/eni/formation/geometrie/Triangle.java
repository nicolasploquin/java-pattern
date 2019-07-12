package fr.eni.formation.geometrie;

public class Triangle extends FigureAdapter {

    public Point sommet;
    public Segment base;


    /**
     * par déterminant de deux vecteurs : abs| (xb-xa)*(yc-ya) - (xc-xa)*(yb-ya) | / 2
     * a sommet ; b base origine ; c base destination
     */
    @Override
    public double aire(){
        return Math.abs(
                    (base.origine.x - sommet.x) * (base.destination.y - sommet.y)
                  - (base.destination.x - sommet.x) * (base.origine.y - sommet.y)
        ) / 2.0;
    }
}
