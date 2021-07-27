package Gui;

/**
 * Le cadre principal du projet avec les caractéristiques d’initialisation
 *
 * @author Daniel Dumitru
 * @version ETE 2021 - TP3
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CadreVues extends JFrame implements Runnable {

    //Constante
    private static final int CADRE_LARGEUR = 1050;
    private static final int CADRE_HAUTEUR = 475;
    private static final String NOM_CADRE = "Lab 3 : Patrons, patrons, patrons...";

    //**************************************************************************
    //Constructeurs
    public CadreVues() {

    }

    //**************************************************************************
    //Méthodes

    /**
     * Permet de lancer la configuration
     */
    @Override
    public void run() {

        configurerFrame();
    }

    /**
     * Configurer la fenêtre
     */
    public void configurerFrame() {

        //Dimension cadre
        setPreferredSize(new Dimension(CADRE_LARGEUR, CADRE_HAUTEUR));
        pack();
        setLocationRelativeTo(null);
        setTitle(NOM_CADRE);

        //Ajout d'un Jpanel avec les composants
        add(new PanneauPrincipalVue());

        // ajoute une gestion du EXIT par confirmation pop-up
        this.addWindowListener(new WindowAdapter() {

            // gestionnaire d'événement
            public void windowClosing(WindowEvent we) {

                int result = JOptionPane.showConfirmDialog(null, "Quitter ?", "Confirmation : ", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else if (result == JOptionPane.NO_OPTION) {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }

        });

        // rend visible
        setVisible(true);
    }
}
