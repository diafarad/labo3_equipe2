package Commandes;

import Model.PerspectiveModel;

/**
 * Cette classe permet de faire un changement sur la grandeur de l’image en changeant
 * les valeur dans le model lors de l’utilisation de cette commande.
 *
 * @author Daniel Dumitru, diafara
 * @version ETE 2021 - TP3
 */

public class Zoom extends Commandes {

    private int zoomValeur;

    //*************************************************************************
    //Constructeurs
    public Zoom(PerspectiveModel perspectiveModel, int zoomValeur) {
        super(perspectiveModel);
        this.zoomValeur = zoomValeur;
    }

    //**************************************************************************
    //Méthodes

    /**
     * S’occupe de faire le changement dans le model et appel la mise à jour
     */
    @Override
    public void executer() {

        if (getPerspectiveModel() != null) {
            getCommandeHistory().push(new Zoom(this.getPerspectiveModel().clone(), this.zoomValeur));

            getPerspectiveModel().setZoom(this.zoomValeur);
            getPerspectiveModel().avertirLesObservers();
        }
    }
}
