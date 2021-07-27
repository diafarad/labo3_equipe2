package Model;

/**
 * Cette classe agit comme le modéle d'une image n'ayant pas la commande Zoom
 * ou Translation.
 *
 * @author Daniel Dumitru, diafara
 * @version ETE 2021 - TP3
 */

import Observateurs.ImageObservable;

import java.io.Serializable;

public class ImageModel extends ImageObservable implements Serializable, ModelBase {

    private String sourceImage;

    //*************************************************************************
    //Constructeurs
    public ImageModel() {

    }

    //*************************************************************************
    //Getter et Setter


    public String getSourceImage() {
        return sourceImage;
    }

    public void setSourceImage(String sourceImage) {
        this.sourceImage = sourceImage;
    }
}
