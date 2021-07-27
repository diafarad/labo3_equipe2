package Commande;

import Model.ImageModel;
import Model.ModelBase;
import Model.PerspectiveModel;

/**
 *
 */

public class Translation extends Commande {

    ModelBase model;
    int direction;

    public Translation(ModelBase m, int dir) {
        super(m);
        model = m;
        direction = dir;
    }

    @Override
    public boolean executer() {
    	backUp(); // Sauvergarde l'état du modele avant d'effectuer la commande 
    	boolean ok = false;
    	if (model instanceof ImageModel) {
    		ImageModel im = ImageModel.getInstance();
        	if (direction == 1) {
        		ImageModel.setX(im.getX()+10);
        		im.setTranslation(true);
        		ok = true;
    		}
        	if (direction == 2) {
        		ImageModel.setX(im.getX()-10);
        		im.setTranslation(true);
        		ok = true;
    		}
        	if (direction == 3) {
        		ImageModel.setY(im.getY()+10);
        		im.setTranslation(true);
        		ok = true;
    		}
        	if (direction == 4) {
        		ImageModel.setY(im.getY()-10);
        		im.setTranslation(true);
        		ok = true;
    		}
		}
    	if (model instanceof PerspectiveModel) {
    		PerspectiveModel pers = PerspectiveModel.getInstance();
        	if (direction == 1) {
        		PerspectiveModel.setX(pers.getX()+10);
        		pers.setTranslation(true);
        		ok = true;
    		}
        	if (direction == 2) {
        		PerspectiveModel.setX(pers.getX()-10);
        		pers.setTranslation(true);
        		ok = true;
    		}
        	if (direction == 3) {
        		PerspectiveModel.setY(pers.getY()+10);
        		pers.setTranslation(true);
        		ok = true;
    		}
        	if (direction == 4) {
        		PerspectiveModel.setY(pers.getY()-10);
        		pers.setTranslation(true);
        		ok = true;
    		}
		}    	
		return ok;
    }
    
    
}
