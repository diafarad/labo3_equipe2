package Commande;

/**
 *
 *
 *
 */

import Model.ModelBase;

public abstract class Commande {

    private static ModelBase model;
    private static ModelBase backUp;

    public Commande(){
    }
    
    public Commande(ModelBase model){
        Commande.model = model;
    }
    
    public void backUp() {
    	backUp = model;
    }
    
    public static ModelBase undo() {
    	model = backUp;
    	return model;
    }

    public abstract boolean executer();
    

}
