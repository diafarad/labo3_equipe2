package Commandes;

/**
 * Cette classe s’occuper de faire l’invocation des commandes lors de l’utilisation
 * d’une commande dans une vue.
 *
 * @author Daniel Dumitru, diafara
 * @version ETE 2021 - TP3
 */

public class Invoker {

    private Commandes commandes;

    //*************************************************************************
    //Constructeurs
    public Invoker() {
    }

    public Invoker(Commandes commandes) {

        this.commandes = commandes;
        this.commandes.executerCommande();
    }
}
