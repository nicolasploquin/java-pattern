package fr.eni.formation.geometrie;

public class Main {

    public static void main(String[] args) {

        Point p1 = new Point(1.0, 6.0);
        Point p2 = new Point(2.0, 7.0);
        Point p3 = new Point(3.0, 8.0);

        Segment s1 = new Segment(p1, p2);

        Carre ca1 = new Carre(p3, 4);
        Carre ca2 = new CarreBuilder()
                .setCote(s1)
                .build();
        Carre ca3 = new CarreBuilder()
                .setOrigine(p2)
                .setCote(8.0)
                .build();

    }


}
