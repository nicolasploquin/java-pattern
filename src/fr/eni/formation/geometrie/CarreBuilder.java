package fr.eni.formation.geometrie;

import fr.eni.formation.geometrie.visitor.FigureParser;

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


    /* Design Pattern Visitor */
    private FigureParser visitor = null;

    public CarreBuilder fromSource(String source, FigureParser visitor){
        acceptParser(visitor);
        fromSource(source);
        return this;
    }

    public CarreBuilder fromSource(String source){

        double[] data = visitor.parseData(source);
        this.setOrigine(Point.createPoint(data[0], data[1]));
        this.setCote(data[2]);
        return this;
    }

    public CarreBuilder acceptParser(FigureParser visitor){
        this.visitor = visitor;
        return this;
    }
}