package fr.eni.formation.geometrie;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class DessinFacade {
    private Dessin dessin = Dessin.getInstance();

    public void deplacerElement(Element element, double dx, double dy) {
        element.deplacer(dx, dy);
    }

    public Point dupliquerPoint(Point point) {
        return point.clone();
    }

    public double aireDessin() {
        return dessin.formes.stream()
                .filter(element -> element instanceof Figure)
                .mapToDouble(element -> ((Figure) element).aire())
                .sum();
    }

    public void deplacer(Point point, double dx, double dy, Action action) {
        switch (action) {
            case COPY:
                point.clone().deplacer(dx, dy);
            case MOVE:
                point.deplacer(dx, dy);
        }
    }

    public Figure creerFigure(Class<? extends Figure> type, String coords) {
        Figure fig = null;
        try {
            fig = type.getConstructor().newInstance();
        } catch ( InstantiationException
                | IllegalAccessException
                | NoSuchMethodException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
        switch (type.getSimpleName()) {
            case "Carre": // coords: x;y;cote
                double[] data = Arrays.stream(coords.split(";"))
                        .mapToDouble(str -> Double.parseDouble(str))
                        .toArray();
                ((Carre) fig).origine = Point.createPoint(data[0], data[1]);
                ((Carre) fig).cote = data[2];
        }

        return fig;

    }
}
