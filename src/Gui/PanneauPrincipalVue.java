package Gui;

/**
 * Cette classe agit comme le panneau des vues principal en ayant notamment les
 * gestionnaires d’action et les différents sous panneau des vues.
 *
 * @author Daniel Dumitru
 * @version ETE 2021 - TP3
 */

import Gui.Vue.ImageVue;
import Gui.Vue.MenuFenetre;
import Gui.Vue.PerspectiveVue;
import Gui.Vue.Vue;
import Model.ImageModel;
import Model.ModelBase;
import Model.PerspectiveModel;
import Observateurs.ImageObserver;
import Observateurs.PerspectiveObserver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class PanneauPrincipalVue extends JPanel {

    private static final int LIGNE_PANNEAUX_PRINCIPAL = 1;
    private static final int COLONNE_PANNEAUX_PRINCIPAL = 3;

    private ImageModel modelThumbnailGauche = new ImageModel();
    private static PerspectiveModel modelPerspectiveCentre = new PerspectiveModel("Centre");
    private static PerspectiveModel modelPerspectiveDroite = new PerspectiveModel("Droite");

    private static final ArrayList<ModelBase> listPerspective = new ArrayList<>(Arrays.asList(modelPerspectiveCentre, modelPerspectiveDroite));

    private Vue thumbnailGauche = new ImageVue(this.modelThumbnailGauche);
    private Vue perspectiveCentre = new PerspectiveVue(modelPerspectiveCentre);
    private Vue perspectiveDroite = new PerspectiveVue(modelPerspectiveDroite);

    private JPanel jPanelPanneauEtMenu = new JPanel();

    private MenuFenetre menu = new MenuFenetre(this.modelThumbnailGauche, modelPerspectiveCentre, modelPerspectiveDroite);

    //**************************************************************************
    //Constructeurs

    public PanneauPrincipalVue() {

        //Pour avertir lors du changement
        this.modelThumbnailGauche.ajouterObserver((ImageObserver) this.thumbnailGauche);
        modelPerspectiveCentre.ajouterObserver((PerspectiveObserver) this.perspectiveCentre);
        modelPerspectiveDroite.ajouterObserver((PerspectiveObserver) this.perspectiveDroite);

        setLayout(new BorderLayout());
        this.jPanelPanneauEtMenu.setLayout(new GridLayout(LIGNE_PANNEAUX_PRINCIPAL, COLONNE_PANNEAUX_PRINCIPAL));
        barMenu();
        sousPanneauGauche();
        sousPanneauCentre();
        sousPanneauDroite();
        add(this.jPanelPanneauEtMenu, BorderLayout.CENTER);

    }

    //**************************************************************************
    //Méthodes

    /**
     * Le sous panneau avec l'image par défaut
     */
    private void sousPanneauGauche() {

        this.jPanelPanneauEtMenu.add(this.thumbnailGauche);
    }

    /**
     * Le sous panneau avec la première perspective
     */
    private void sousPanneauCentre() {

        this.jPanelPanneauEtMenu.add(this.perspectiveCentre);
    }

    /**
     * Le sous panneau avec la deuxième perspective
     */
    private void sousPanneauDroite() {

        this.jPanelPanneauEtMenu.add(this.perspectiveDroite);
    }

    /**
     * Le menu avec certaines commandes
     */
    private void barMenu() {

        add(this.menu, BorderLayout.NORTH);
    }

    //**************************************************************************
    //Getter et setter

    public static ArrayList<ModelBase> getListPerspective() {
        return listPerspective;
    }
}
