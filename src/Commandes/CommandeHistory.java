package Commandes;

/**
 * Cette classe est un gestionnaire de commande qui mémorise les commandes effectuées et permet de les défaire.
 *
 * @author Alex Lim
 * @version ETE 2021 - TP3
 */


import java.util.ArrayList;
import java.util.List;

public class CommandeHistory {
    private static CommandeHistory instance = new CommandeHistory();

    private List<Commandes> history;

    private CommandeHistory() {
        history = new ArrayList<Commandes>();
    }

    public static CommandeHistory getInstance() {
        return instance;
    }

    public void push(Commandes com) {

        history.add(com);
    }

    public Commandes undo() {

        Commandes com = history.get(history.size() - 1);
        history.remove(history.size() - 1);
        return com;
    }

    public Commandes getCommande(Commandes com) {
        for (Commandes c : history) {
            if (c.equals(com)) {
                return c;
            }
        }

        return null;
    }

    public int sizeListeCommandes() {
        return history.size();
    }
}
