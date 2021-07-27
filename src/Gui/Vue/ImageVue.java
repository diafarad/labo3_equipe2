package Gui.Vue;

/**
 * Cette classe s’occupe d’appliquer les changements d’une vue normal
 * lors d’une mise à jour.
 *
 * @author Daniel Dumitru, diafara
 * @version ETE 2021 - TP3
 */

import Model.ImageModel;
import Observateurs.ImageObserver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageVue extends Vue implements ImageObserver {

    private static final int POSITION_Y_DEBUT = 40;
    private static final int POSITION_X_DEBUT = 0;

    private static final int HAUTEUR_IMAGE_DEFAUT = 316;
    private static final int LARGEUR_IMAGE_DEFAUT = 316;

    //*************************************************************************
    //Constructeurs
    public ImageVue(ImageModel modelThumbnail) {

        super(modelThumbnail);
        setPreferredSize(getPrefferedSize());
    }

    //**************************************************************************
    //Méthodes

    /**
     * Permet de dessiner l'image
     *
     * @param g, l’endroit où dessiner
     */
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        try {
            
            if (getModelThumbnail().getSourceImage() != null) {
                Image image = ImageIO.read(new File(getModelThumbnail().getSourceImage()));
                g.drawImage(image, POSITION_X_DEBUT, POSITION_Y_DEBUT, HAUTEUR_IMAGE_DEFAUT, LARGEUR_IMAGE_DEFAUT, this);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implémentation pour permettre la mise à jour
     */
    @Override
    public void avertir() {
        repaint();
    }
}
