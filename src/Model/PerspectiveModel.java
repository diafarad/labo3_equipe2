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

    private String positionJpanel;

    //**************************************************************************
    //Constructeurs
    public PerspectiveModel(String positionJpanel) {
            this.positionJpanel = positionJpanel;
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
        PerspectiveModel clone = new PerspectiveModel(this.positionJpanel);
        clone.setPositionX(this.getPositionX());
        clone.setPositionY(this.getPositionY());
        clone.setZoom(this.getZoom());
        clone.setPositionJpanel(this.positionJpanel);
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

    public String getPositionJpanel() {
        return positionJpanel;
    }

    public void setPositionJpanel(String positionJpanel) {
        this.positionJpanel = positionJpanel;
    }
}
