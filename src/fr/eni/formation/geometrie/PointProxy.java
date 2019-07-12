package fr.eni.formation.geometrie;


/**
 * Implémentation design pattern Proxy
 * Contrôle le pas de déplacement du point (< 10.0)
 */
public class PointProxy extends Point {

    public PointProxy() {
    }

    public PointProxy(double x, double y) {
        super(x, y);
    }

    public void deplacer(double dx, double dy){
        if (Math.abs(dx) < 10.0 && Math.abs(dy) < 10.0) {
            super.deplacer(dx,dy);
        }
    }

}
