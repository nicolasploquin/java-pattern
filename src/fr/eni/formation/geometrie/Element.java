package fr.eni.formation.geometrie;

import fr.eni.formation.geometrie.observer.Observable;
import fr.eni.formation.geometrie.observer.Observer;

import java.util.Comparator;

/** Item graphique (point, segment, carre, cercle, figure...) */
public abstract class Element extends Observable implements Observer {

    public abstract void deplacer(double dx, double dy);


    public static class ElementComparator implements Comparator<Element> {

        @Override
        public int compare(Element o1, Element o2) {
            return o1.hashCode() - o2.hashCode();
        }
    }

    public static int hashCodeCompare(Element o1, Element o2) {
        return o1.hashCode() - o2.hashCode();
    }
}
