/**
 *
 */
package Commandes;


import Model.ModelBase;
import Model.PerspectiveModel;

import java.util.ArrayList;

/**
 * @author diafara
 * Load.java
 * 25 juil. 2021
 * 16:52:29
 */
public class Undo extends Commandes {

    /**
     * @param listeModel
     */
    public Undo(ArrayList<ModelBase> listeModel) {
        super(listeModel);
    }

    @Override
    public void executer() {

        if (getListeModel().size() != 0 && getCommandeHistory().sizeListeCommandes() > 0) {

            Commandes avant = getCommandeHistory().undo();

            for (int i = 0; i < getListeModel().size(); i++) {

                if(avant.getPerspectiveModel().getPositionJpanel().equals(((PerspectiveModel)getListeModel().get(i)).getPositionJpanel())){

                    ((PerspectiveModel)getListeModel().get(i)).setPositionX(avant.getPerspectiveModel().getPositionX());
                    ((PerspectiveModel)getListeModel().get(i)).setPositionY(avant.getPerspectiveModel().getPositionY());
                    ((PerspectiveModel)getListeModel().get(i)).setZoom(avant.getPerspectiveModel().getZoom());

                    ((PerspectiveModel)getListeModel().get(i)).avertirLesObservers();
                }
            }
        }
    }
}
