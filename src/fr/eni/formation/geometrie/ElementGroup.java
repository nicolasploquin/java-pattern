package fr.eni.formation.geometrie;

import java.util.LinkedList;
import java.util.List;

public class ElementGroup extends Element {

    public List<Element> contenu = new LinkedList<>();

    public ElementGroup() {
    }

    public ElementGroup add(Element element){
        contenu.add(element);
        return this;
    }
    public ElementGroup remove(Element element){
        contenu.remove(element);
        return this;
    }

    @Override
    public void deplacer(double dx, double dy) {
        contenu.stream().forEach(elem -> elem.deplacer(dx,dy) );
    }

    @Override
    public String toString() {
        return String.format("Groupe (%d éléments)", contenu.size());
    }
}
