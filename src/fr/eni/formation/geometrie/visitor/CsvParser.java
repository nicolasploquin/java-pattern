package fr.eni.formation.geometrie.visitor;

import fr.eni.formation.geometrie.Carre;
import fr.eni.formation.geometrie.Point;

import java.util.Arrays;

public class CsvParser implements FigureParser {
//    static {
//        Main.setParser(new CsvParser());
//    }


    @Override
    public double[] parseData(String source) {
        return Arrays.stream(source.split(";"))
                .mapToDouble(str -> Double.parseDouble(str))
                .toArray();
    }
}
