/**
 *
 */
package Gui.Vue;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Commandes.*;
import Gui.PanneauPrincipalVue;
import Model.ImageModel;
import Model.ModelBase;
import Model.PerspectiveModel;

/**
 * @author diafara
 * MenuFentre.java
 * 23 juil. 2021
 * 10:14:31
 */
public class MenuFenetre extends JMenuBar {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final String MENU_FICHIER_TITRE = "Fichier";
    private static final String MENU_FICHIER_CHARGER = "Ouvrir";
    private static final String MENU_FICHIER_SAVE = "Sauvegarder";
    private static final String MENU_FICHIER_CHARGER_SAUVEGARDE = "Charger " + "Sauvegarde";
    private static final String MENU_FICHIER_QUITTER = "Quitter";
    private static final String MENU_OPTION_TITRE = "Options";
    private static final String MENU_OPTION_UNDO = "Undo";
    private static final String MENU_OPTION_REDO = "Redo";

    private ImageModel modelThumbnailGauche;
    private PerspectiveModel modelPerspectiveCentre;
    private PerspectiveModel modelPerspectiveDroite;

    private ArrayList<ModelBase> listeModel = new ArrayList<>();

    /**
     *
     */
    public MenuFenetre(ImageModel modelThumbnailGauche, PerspectiveModel modelPerspectiveCentre, PerspectiveModel modelPerspectiveDroite) {

        this.modelThumbnailGauche = modelThumbnailGauche;
        this.modelPerspectiveCentre = modelPerspectiveCentre;
        this.modelPerspectiveDroite = modelPerspectiveDroite;
        this.listeModel.add(modelThumbnailGauche);
        this.listeModel.add(modelPerspectiveCentre);
        this.listeModel.add(modelPerspectiveDroite);

        menu();
    }

    private void menu() {
        JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
        JMenu menuOption = new JMenu(MENU_OPTION_TITRE);

        JMenuItem menuOuvrir = new JMenuItem(MENU_FICHIER_CHARGER);
        JMenuItem menuSave = new JMenuItem(MENU_FICHIER_SAVE);
        JMenuItem menuCharger = new JMenuItem(MENU_FICHIER_CHARGER_SAUVEGARDE);
        JMenuItem menuQuitter = new JMenuItem(MENU_FICHIER_QUITTER);
        JMenuItem menuUndo = new JMenuItem(MENU_OPTION_UNDO);
        JMenuItem menuRedo = new JMenuItem(MENU_OPTION_REDO);

        menuOuvrir.addActionListener((ActionEvent e) -> {
            new Invoker(new Load(this.listeModel));
        });

        menuSave.addActionListener((ActionEvent e) -> {
            new Invoker(new Sauvegarder(this.modelThumbnailGauche, new ArrayList<>(Arrays.asList(this.modelPerspectiveCentre, this.modelPerspectiveDroite))));
        });

        menuCharger.addActionListener((ActionEvent e) -> {
            new Invoker(new Charger(this.modelThumbnailGauche, new ArrayList<>(Arrays.asList(this.modelPerspectiveCentre, this.modelPerspectiveDroite))));
        });

        menuUndo.addActionListener((ActionEvent e) -> {
            new Invoker(new Undo(PanneauPrincipalVue.getListPerspective()));
        });

        menuRedo.addActionListener((ActionEvent e) -> {
            //Invoke Command
        });

        menuQuitter.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        menuFichier.add(menuOuvrir);
        menuFichier.add(menuSave);
        menuFichier.add(menuCharger);
        menuFichier.add(menuQuitter);
        menuOption.add(menuUndo);
        menuOption.add(menuRedo);

        add(menuFichier);
        add(menuOption);
    }
}
