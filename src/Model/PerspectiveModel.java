package Model;

/**
 * Cette classe agit comme le modéle d'une image pouvant subir les commandes
 * Zoom ou Translation.
 *
 * @author Daniel Dumitru, diafara
 * @version ETE 2021 - TP3
 */

import Observateurs.PerspectiveObservable;

import java.io.Serializable;

public class PerspectiveModel extends PerspectiveObservable implements Serializable, ModelBase {

    private String sourceImage;

    private int zoom = 0;
    private double positionX = 0;
    private double positionY = 0;

    //**************************************************************************
    //Constructeurs
    public PerspectiveModel() {

    }

    //**************************************************************************
    //Méthode

    /**
     *
     * Permet de retourner une copie
     * @return
     */
    public PerspectiveModel clone()
    {
        PerspectiveModel clone = new PerspectiveModel();
        clone.setPositionX(this.getPositionX());
        clone.setPositionY(this.getPositionY());
        clone.setZoom(this.getZoom());
        return clone;
    }

    //**************************************************************************
    //Getter et setter

    public String getSourceImage() {
        return sourceImage;
    }

    public void setSourceImage(String sourceImage) {
        this.sourceImage = sourceImage;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }
}
