/**
 * 
 */
package Commande;

import Model.ModelBase;

/**
 * @author diafara
 * Load.java
 * 25 juil. 2021
 * 16:52:29
 */
public class Undo extends Commande {
	
	CommandeHistory history = CommandeHistory.getInstance();
	ModelBase model;

	/**
	 * @param model
	 */
	public Undo(ModelBase m) {
		super(m);
		model = m;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean executer() {
		history.undo();
		return true;
	}

}
