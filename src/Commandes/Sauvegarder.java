package Commandes;

/**
 * Cette classe permet de sauvegarder les perspectives avec l’utilisation de la
 * sérialisation.
 *
 * @author Daniel Dumitru
 * @version ETE 2021 - TP3
 */

import Model.ImageModel;
import Model.PerspectiveModel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Sauvegarder extends Commandes {

    private static final String SOURCE_SAUVEGARDE = "src/Temporaire/vues.ser";

    private ArrayList<PerspectiveModel> listePerspective;

    //*************************************************************************
    //Constructeurs
    public Sauvegarder(ImageModel imageModel, ArrayList<PerspectiveModel> listePerspective) {
        super(imageModel);
        this.listePerspective = listePerspective;
    }

    //**************************************************************************
    //Méthodes

    /**
     *Permet de sauvegarder les perspectives avec l’utilisation de la
     *sérialisation.
     *
     * Source : https://www.tutorialspoint.com/java/java_serialization.htm
     */
    private void sauvegarderVues() {

        try {
            FileOutputStream fileOut = new FileOutputStream(SOURCE_SAUVEGARDE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.listePerspective);
            out.close();
            fileOut.close();
            System.out.println("Sauvegarde dans : " + SOURCE_SAUVEGARDE);

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * S’occupe de faire la sauvegarde et appel la mise à jour.
     */
    @Override
    public void executer() {
        sauvegarderVues();

        for (PerspectiveModel model : listePerspective) {
            model.avertirLesObservers();
        }
    }
}
