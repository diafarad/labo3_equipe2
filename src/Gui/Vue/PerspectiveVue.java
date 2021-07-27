package Gui.Vue;

/**
 * Cette classe s’occupe d’appliquer les changements d’une vue en perspective
 * lors d’une mise à jour.
 *
 * @author Daniel Dumitru, diafara
 * @version ETE 2021 - TP3
 */

import Commandes.Invoker;
import Commandes.Translation;
import Commandes.Undo;
import Commandes.Zoom;
import Gui.PanneauPrincipalVue;
import Model.PerspectiveModel;
import Observateurs.PerspectiveObserver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class PerspectiveVue extends Vue implements PerspectiveObserver {

    private static final int MIN_Y = 40;

    private int positionZoom = 0;
    private final static int ZOOM_SAUT = 15;
    private int positionX = 0;
    private int positionY = 0;
    private final static int POSITION_SAUT = 10;

    private JPanel jPanelImage = new JPanel();

    //*************************************************************************
    //Constructeurs
    public PerspectiveVue(PerspectiveModel perspectiveModel) {

        super(perspectiveModel);
        setPreferredSize(getPrefferedSize());
        this.jPanelImage.setPreferredSize(getPrefferedSize());
        this.jPanelImage.setOpaque(false);

        initialisation();
    }

    //**************************************************************************
    //Méthodes

    /**
     * Un sous panneau avec les éléments d'une image avec perspective
     */
    private void initialisation() {

        JButton zoomIn = new JButton(new ImageIcon("src/Ressources/zoomin.png"));
        JButton zoomOut = new JButton(new ImageIcon("src/Ressources/zoomout.png"));
        JButton undo = new JButton(new ImageIcon("src/Ressources/undo.png"));
        JButton redo = new JButton(new ImageIcon("src/Ressources/redo.png"));

        add(undo, BorderLayout.NORTH);
        add(redo, BorderLayout.NORTH);
        add(zoomIn, BorderLayout.NORTH);
        add(zoomOut, BorderLayout.NORTH);

        zoomIn.addActionListener((ActionEvent e) -> {

            new Invoker(new Zoom(getModelPerspective(), this.positionZoom =
                    this.positionZoom + ZOOM_SAUT));
        });

        zoomOut.addActionListener((ActionEvent e) -> {
            new Invoker(new Zoom(getModelPerspective(), this.positionZoom =
                    this.positionZoom - ZOOM_SAUT));
        });

        undo.addActionListener((ActionEvent e) -> {
            new Invoker(new Undo(PanneauPrincipalVue.getListPerspective()));
        });

        add(this.jPanelImage, BorderLayout.CENTER);

        JButton right = new JButton(new ImageIcon("src/Ressources/right.png"));
        JButton left = new JButton(new ImageIcon("src/Ressources/left.png"));
        JButton top = new JButton(new ImageIcon("src/Ressources/top.png"));
        JButton bottom = new JButton(new ImageIcon("src/Ressources/bottom.png"));


        right.addActionListener((ActionEvent e) -> {

            new Invoker(new Translation(getModelPerspective(),
                    new Point(this.positionX = this.positionX + POSITION_SAUT,
                            this.positionY)));
        });

        left.addActionListener((ActionEvent e) -> {
            new Invoker(new Translation(getModelPerspective(),
                    new Point(this.positionX = this.positionX - POSITION_SAUT, this.positionY)));

        });

        top.addActionListener((ActionEvent e) -> {
            new Invoker(new Translation(getModelPerspective(),
                    new Point(this.positionX, this.positionY =
                            this.positionY - POSITION_SAUT)));

        });

        bottom.addActionListener((ActionEvent e) -> {
            new Invoker(new Translation(getModelPerspective(), new Point(this.positionX, this.positionY =
                    this.positionY + POSITION_SAUT)));

        });

        add(right, BorderLayout.SOUTH);
        add(left, BorderLayout.SOUTH);
        add(top, BorderLayout.SOUTH);
        add(bottom, BorderLayout.SOUTH);

    }

    /**
     * Permet de dessiner l'image
     *
     * @param g, l’endroit où dessiner
     */
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        try {
            if (getModelPerspective().getSourceImage() != null) {
                this.positionX = (int)getModelPerspective().getPositionX();
                this.positionY = (int)getModelPerspective().getPositionY();
                this.positionZoom = getModelPerspective().getZoom();
                Image image = ImageIO.read(new File(getModelPerspective().getSourceImage()));
                g.drawImage(image, (int) getModelPerspective().getPositionX(), (int) getModelPerspective().getPositionY() + MIN_Y, getModelPerspective().getZoom(), getModelPerspective().getZoom(), this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implémentation pour permettre la mise à jour
     */
    @Override
    public void avertir() {

        repaint();
    }
}
