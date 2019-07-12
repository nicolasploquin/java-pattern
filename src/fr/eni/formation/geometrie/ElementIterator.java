package fr.eni.formation.geometrie;

import java.util.List;

public class ElementIterator {

    private List<Element> contenu;
    public Element element = null;
    private int position = 0;

    public ElementIterator(List<Element> contenu) {
        this.contenu = contenu;
    }

    public boolean next(){
        if( contenu == null ) return false;
        if(position >= contenu.size()) {
            element = null;
            return false;
        }
        element = contenu.get(position++);
        if (element instanceof ElementGroup) {
            contenu.addAll(((ElementGroup) element).contenu);
            return next(); // ignorer les groupes
        }
        return true;
    }


}
