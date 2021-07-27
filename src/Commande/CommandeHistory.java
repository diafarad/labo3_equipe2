/**
 * 
 */
package Commande;

import java.util.ArrayList;
import java.util.List;

import Model.ImageModel;
import Model.ModelBase;
import Model.PerspectiveModel;

/**
 * @author diafara
 * CommandeHistory.java
 * 25 juil. 2021
 * 14:15:52
 */
public class CommandeHistory {
	
	private static CommandeHistory instance;	
	private List<Commande> history = new ArrayList<>();
	
	private CommandeHistory() {
		
	}
	
	public static CommandeHistory getInstance() {
		if (instance == null) {
			instance = new CommandeHistory();
		}
		return instance;
	}
	
	public void push(Commande com) {
		history.add(com);
	}
	
	public Commande pop() {
		return history.get(history.size()-1);
	}
	
	public void undo() {
		ModelBase model = Commande.undo();
		if (model instanceof ImageModel) {
			ImageModel imageModel = ImageModel.getInstance();
			imageModel.setImage(model.getImage().getIcon());
		}
		else if (model instanceof PerspectiveModel) {
			PerspectiveModel perspectiveModel = PerspectiveModel.getInstance();
			perspectiveModel.setImage(model.getImage().getIcon());
		}
	}

}
