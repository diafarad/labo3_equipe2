/**
 *
 */
package Commandes;


import Model.PerspectiveModel;

/**
 * @author diafara
 * Load.java
 * 25 juil. 2021
 * 16:52:29
 */
public class Undo extends Commandes {

    /**
     * @param perspectiveModel
     */
    public Undo(PerspectiveModel perspectiveModel) {
        super(perspectiveModel);
    }

    @Override
    public void executer() {

        if (getPerspectiveModel() != null && getCommandeHistory().sizeListeCommandes() != 0) {

            Commandes avant = getCommandeHistory().undo();

            getPerspectiveModel().setPositionX(avant.getPerspectiveModel().getPositionX());
            getPerspectiveModel().setPositionY(avant.getPerspectiveModel().getPositionY());
            getPerspectiveModel().setZoom(avant.getPerspectiveModel().getZoom());

            getPerspectiveModel().avertirLesObservers();
        }
    }
}
