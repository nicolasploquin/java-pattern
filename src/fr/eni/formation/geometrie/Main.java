package fr.eni.formation.geometrie;

import fr.eni.formation.geometrie.visitor.CsvParser;
import fr.eni.formation.geometrie.visitor.FigureParser;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Dessin dessin = Dessin.getInstance();

        Point p1 = new PointProxy(1.0, 6.0);
        Point p2 = Point.createPoint(2.0, 7.0);
        Point p3 = Point.createPoint(3.0, 8.0);
        dessin.formes.add(p1);
        dessin.formes.add(p2);
        dessin.formes.add(p3);

        Segment s1 = new Segment(p1, p2);
        dessin.formes.add(s1);

        Carre ca1 = new Carre(p3, 4);
        Carre ca2 = new CarreBuilder()
                .setCote(s1)
                .build();
        Carre ca3 = new CarreBuilder()
                .setOrigine(p2.clone())
                .setCote(8.0)
                .build();
        dessin.formes.add(ca1);
        dessin.formes.add(ca2);
        dessin.formes.add(ca3);

        dessin.print();

        Point p4 = p1;
        Point p5 = p1.clone();

        System.out.println(p4);
        System.out.println(p5);
        p1.x = 10.0;
        System.out.println(p4);
        System.out.println(p5);

        System.out.println(p1);
        p1.deplacer(2.0, 3.0);
        System.out.println(p1);
        p1.deplacer(12.0, 23.0);
        System.out.println(p1);

        Cercle ce1 = new Cercle(p5.clone(), 4.0);

        System.out.printf("%s périmètre=%6.1f, aire=%6.1f\n", ca1, ca1.perimetre(), ca1.aire() );
        System.out.printf("%s périmètre=%6.1f, aire=%6.1f\n", ce1, ce1.perimetre(), ce1.aire() );

        System.out.println(ce1);
        DessinFacade dessinService = new DessinFacade();
        dessinService.deplacerElement(ce1, -5.0, -5.0);
        System.out.println(ce1);

        ElementGroup gr1 = new ElementGroup();
        gr1.add(s1.clone());
        gr1.add(p2.clone());
        gr1.add(new Carre(p3.clone(),58.0));
        dessin.formes.add(gr1);

        System.out.println("--- Dessin ---");

        ElementIterator iterator = dessin.iterator();
        while(iterator.next()){
            System.out.println(iterator.element);
        }

        Figure fig = dessinService.creerFigure(Carre.class, "7.0;3.0;12.3");
        gr1.add(fig);
        System.out.println(fig);
        FigureParser visitor = new CsvParser();
        Carre ca4 = new CarreBuilder()
                .acceptParser(visitor)
//                .acceptParser(CsvParser::parseData)
                .fromSource("-4.0;23.0;2.8")
                .build();

        dessin.formes.stream().forEach( element -> {
            System.out.println(element);
        } );
        dessin.formes.stream().forEach( Main::afficheElement );
        dessin.formes.stream().forEach( System.out::println );

        dessin.formes.sort(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });
        dessin.formes.sort(new Element.ElementComparator());
        dessin.formes.sort(Element::hashCodeCompare);

    }

    public static void afficheElement(Element element){
        System.out.println(element);
    }


}
