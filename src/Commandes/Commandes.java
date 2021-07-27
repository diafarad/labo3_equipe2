package Commandes;

/**
 * Cette classe abstraite est le parent de toute les commandes et elle s’occupe
 * du lancement des commandes.
 *
 * @author Daniel Dumitru
 * @version ETE 2021 - TP3
 */

import Model.ImageModel;
import Model.ModelBase;
import Model.PerspectiveModel;

import java.util.ArrayList;

public abstract class Commandes{

    private ImageModel imageModel;
    private PerspectiveModel perspectiveModel;
    private ArrayList<ModelBase> listeModel;
    private CommandeHistory commandeHistory = CommandeHistory.getInstance();

    public abstract void executer();

    //*************************************************************************
    //Constructeurs
    public Commandes(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public Commandes(PerspectiveModel perspectiveModel) {
        this.perspectiveModel = perspectiveModel;
    }

    public Commandes(ArrayList<ModelBase> listeModel) {
        this.listeModel = listeModel;
    }

    //**************************************************************************
    //Méthodes

    /**
     * Permet de lancer la commande.
     */
    public void executerCommande() {
        executer();
    }

    //**************************************************************************
    //Getter et setter
    public ImageModel getImageModel() {
        return imageModel;
    }

    public void setImageModel(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public PerspectiveModel getPerspectiveModel() {
        return perspectiveModel;
    }

    public void setPerspectiveModel(PerspectiveModel perspectiveModel) {
        this.perspectiveModel = perspectiveModel;
    }

    public ArrayList<ModelBase> getListeModel() {
        return listeModel;
    }

    public void setListeModel(ArrayList<ModelBase> listeModel) {
        this.listeModel = listeModel;
    }

    public CommandeHistory getCommandeHistory() {
        return commandeHistory;
    }

    public void setCommandeHistory(CommandeHistory commandeHistory) {
        this.commandeHistory = commandeHistory;
    }
}
