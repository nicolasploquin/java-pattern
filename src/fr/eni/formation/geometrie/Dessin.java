package fr.eni.formation.geometrie;

import java.util.LinkedList;
import java.util.List;

public class Dessin {

    private static Dessin instance;

    public List<Element> formes = new LinkedList<>();

    private Dessin(){

    }

    public Dessin getInstance() {
        if(instance == null) instance = new Dessin();
        return instance;
    }
}
