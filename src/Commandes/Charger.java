package Commandes;

/**
 * Cette classe permet de charger les perspectives avec l’utilisation de la
 * sérialisation.
 *
 * @author Daniel Dumitru
 * @version ETE 2021 - TP3
 */


import Model.ImageModel;
import Model.PerspectiveModel;

import java.io.*;
import java.util.ArrayList;

public class Charger extends Commandes {

    private static final String SOURCE_SAUVEGARDE = "src/Temporaire/vues.ser";

    private ArrayList<PerspectiveModel> listePerspective;
    private ArrayList<PerspectiveModel> listePerspectiveTemporaire;

    //*************************************************************************
    //Constructeurs
    public Charger(ImageModel imageModel, ArrayList<PerspectiveModel> listePerspective) {
        super(imageModel);
        this.listePerspective = listePerspective;
    }

    //**************************************************************************
    //Méthodes

    /**
     * Permet de charger les perspectives avec l’utilisation de la
     * sérialisation.
     */
    private void chargerVues() {

        try {

            FileInputStream fileIn = new FileInputStream(SOURCE_SAUVEGARDE);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.listePerspectiveTemporaire = (ArrayList<PerspectiveModel>) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException f) {
            System.out.println("Aucune perspective trouvée");
            f.printStackTrace();
        }
    }

    /**
     * S’occupe de charger la sauvegarde et appel la mise à jour.
     */
    @Override
    public void executer() {

        if (!this.listePerspective.isEmpty()) {

            chargerVues();

            for (int i = 0; i < this.listePerspective.size(); i++) {

                this.listePerspective.get(i).setSourceImage(this.listePerspectiveTemporaire.get(i).getSourceImage());
                this.listePerspective.get(i).setPositionX(this.listePerspectiveTemporaire.get(i).getPositionX());
                this.listePerspective.get(i).setPositionY(this.listePerspectiveTemporaire.get(i).getPositionY());
                this.listePerspective.get(i).setZoom(this.listePerspectiveTemporaire.get(i).getZoom());
                this.listePerspective.get(i).avertirLesObservers();
            }

            this.getImageModel().setSourceImage(this.listePerspective.get(0).getSourceImage());
            this.getImageModel().avertirLesObservers();
        }
    }
}
