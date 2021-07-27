package Commandes;

import Model.PerspectiveModel;

import java.awt.*;

/**
 * Cette classe permet de faire un changement sur la position de l’image en
 * changeant les valeur dans le model lors de l’utilisation de cette commande.
 *
 * @author Daniel Dumitru, diafara
 * @version ETE 2021 - TP3
 */

public class Translation extends Commandes {

    private Point point;

    //*************************************************************************
    //Constructeurs
    public Translation(PerspectiveModel perspectiveModel, Point point) {
        super(perspectiveModel);
        this.point = point;
    }

    //**************************************************************************
    //Méthodes

    /**
     * S’occupe de faire le changement dans le model et appel la mise à jour
     */
    @Override
    public void executer() {

        if (getPerspectiveModel() != null) {

            getCommandeHistory().push(new Translation(this.getPerspectiveModel().clone(), this.point));

            getPerspectiveModel().setPositionX(this.point.getX());
            getPerspectiveModel().setPositionY(this.point.getY());
            getPerspectiveModel().avertirLesObservers();
        }
    }
}
