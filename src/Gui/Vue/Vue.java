package Gui.Vue;

/**
 * Cette classe abstraite agit comme parent aux différents types de vues.
 *
 * @author Daniel Dumitru
 * @version ETE 2021 - TP3
 */

import Model.ImageModel;
import Model.PerspectiveModel;

import javax.swing.*;
import java.awt.*;

public abstract class Vue extends JPanel {

    private static final int DIMENSION_PANNEAU_LARGEUR = 315;
    private static final int DIMENSION_PANNEAU_HAUTEUR = 315;

    private ImageModel modelThumbnail;
    private PerspectiveModel modelPerspective;

    //*************************************************************************
    //Constructeurs
    public Vue(ImageModel modelThumbnail) {
        this.modelThumbnail = modelThumbnail;
    }

    public Vue(PerspectiveModel perspectiveModel) {
        this.modelPerspective = perspectiveModel;
    }

    //**************************************************************************
    //Méthodes

    public Dimension getPrefferedSize() {

        return new Dimension(DIMENSION_PANNEAU_LARGEUR, DIMENSION_PANNEAU_HAUTEUR);
    }

    public Dimension getMinimumSize() {
        return getPrefferedSize();
    }

    //*************************************************************************
    //Getter et setter

    public ImageModel getModelThumbnail() {
        return modelThumbnail;
    }

    public void setModelThumbnail(ImageModel modelThumbnail) {
        this.modelThumbnail = modelThumbnail;
    }

    public PerspectiveModel getModelPerspective() {
        return modelPerspective;
    }

    public void setModelPerspective(PerspectiveModel modelPerspective) {
        this.modelPerspective = modelPerspective;
    }
}
