package Commande;

/**
 *
 */

public class Invoker {

    private Commande commande;
    private CommandeHistory history = CommandeHistory.getInstance();

    public Invoker(){
    }

    public void setCommande(Commande com) {
    	this.commande = com;
    }
    
    public void executeCommande() {
    	if (this.commande.executer()) {
			history.push(commande);
		}    	
    }
}
