package Gui;

/**
 *
 */

import Commande.Invoker;
import Commande.Translation;
import Commande.Undo;
import Commande.ZoomIn;
import Commande.ZoomOut;
import Gui.Vue.ImageVue;
import Gui.Vue.PerspectiveVue;
import Gui.Vue.ThumbnailVue;
import Gui.Vue.Vue;
import Model.ImageModel;
import Model.PerspectiveModel;
import Observateur.PerspectiveObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PanneauPrincipalVue extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int LIGNE_PANNEAUX_PRINCIPAL = 1;
    private static final int COLONNE_PANNEAUX_PRINCIPAL = 2;

    //private ImageModel imageModel = ImageModel.getInstance();
    

    private ThumbnailVue thumbnailGauche = new ThumbnailVue();
    private Vue imageCentre = new ImageVue();
    private Vue perspectiveDroite = new PerspectiveVue();

    private JPanel sousPanneauCentre = new JPanel();
    private JPanel sousPanneauDroite = new JPanel();
    
    ImageModel imageModel = ImageModel.getInstance();
    PerspectiveModel perspectiveModel =  PerspectiveModel.getInstance();

    private Invoker invoker;
    

    //**************************************************************************
    //Constructeurs

    /**
     *
     */
    public PanneauPrincipalVue() {

        setLayout(new GridLayout(LIGNE_PANNEAUX_PRINCIPAL, COLONNE_PANNEAUX_PRINCIPAL));
        sousPanneauGauche();
        sousPanneauCentre();
        sousPanneauDroit();
        invoker = new Invoker();
    }

    //**************************************************************************
    //Méthodes

    /**
     *
     */
    private void sousPanneauGauche() {
    	//thumbnailGauche.setThumbnail(imageModel.getImage());
        add(this.thumbnailGauche);
    }

    /**
     *
     */
    private void sousPanneauCentre() {
        
        JButton zoomIn = new JButton(new ImageIcon("src/Ressources/zoomin.png"));
        JButton zoomOut = new JButton(new ImageIcon("src/Ressources/zoomout.png"));
        JButton undo = new JButton(new ImageIcon("src/Ressources/undo.png"));
        JButton redo = new JButton(new ImageIcon("src/Ressources/redo.png"));

        this.sousPanneauCentre.add(undo, BorderLayout.NORTH);
        this.sousPanneauCentre.add(redo, BorderLayout.NORTH);
        this.sousPanneauCentre.add(zoomIn, BorderLayout.NORTH);
        this.sousPanneauCentre.add(zoomOut, BorderLayout.NORTH);

        zoomIn.addActionListener((ActionEvent e) -> {	
			//Invoke Command
        	invoker.setCommande(new ZoomIn(imageModel));
        	invoker.executeCommande();
		});
        
        zoomOut.addActionListener((ActionEvent e) -> {
        	//Invoke command
        	invoker.setCommande(new ZoomOut(imageModel));
        	invoker.executeCommande();
        });
        
        undo.addActionListener((ActionEvent e) -> {
        	//Invoke command
        	invoker.setCommande(new Undo(imageModel));
        	invoker.executeCommande();
        });

        this.sousPanneauCentre.add(this.imageCentre, BorderLayout.CENTER);

        JButton right = new JButton(new ImageIcon("src/Ressources/right.png"));
        JButton left = new JButton(new ImageIcon("src/Ressources/left.png"));
        JButton top = new JButton(new ImageIcon("src/Ressources/top.png"));
        JButton bottom = new JButton(new ImageIcon("src/Ressources/bottom.png"));
        
      
        right.addActionListener((ActionEvent e) -> {	
			//Invoke Command
        	invoker.setCommande(new Translation(imageModel,1));
        	invoker.executeCommande();
		});
        
        left.addActionListener((ActionEvent e) -> {	
			//Invoke Command
        	invoker.setCommande(new Translation(imageModel,2));
        	invoker.executeCommande();
		});
        
        top.addActionListener((ActionEvent e) -> {	
			//Invoke Command
        	invoker.setCommande(new Translation(imageModel,3));
        	invoker.executeCommande();
		});
        
        bottom.addActionListener((ActionEvent e) -> {	
			//Invoke Command
        	invoker.setCommande(new Translation(imageModel,4));
        	invoker.executeCommande();
		});

        this.sousPanneauCentre.add(right, BorderLayout.SOUTH);
        this.sousPanneauCentre.add(left, BorderLayout.SOUTH);
        this.sousPanneauCentre.add(top, BorderLayout.SOUTH);
        this.sousPanneauCentre.add(bottom, BorderLayout.SOUTH);


        add(this.sousPanneauCentre);
    }

    /**
     *
     */
    private void sousPanneauDroit() {

        this.perspectiveModel.getPersObservable().ajouterObserver((PerspectiveObserver) this.perspectiveDroite);

        JButton zoomIn = new JButton(new ImageIcon("src/Ressources/zoomin.png"));
        JButton zoomOut = new JButton(new ImageIcon("src/Ressources/zoomout.png"));
        JButton undo = new JButton(new ImageIcon("src/Ressources/undo.png"));
        JButton redo = new JButton(new ImageIcon("src/Ressources/redo.png"));

        this.sousPanneauDroite.add(undo, BorderLayout.NORTH);
        this.sousPanneauDroite.add(redo, BorderLayout.NORTH);
        this.sousPanneauDroite.add(zoomIn, BorderLayout.NORTH);
        this.sousPanneauDroite.add(zoomOut, BorderLayout.NORTH);

        zoomIn.addActionListener((ActionEvent e) -> {	
			//Invoke Command
        	invoker.setCommande(new ZoomIn(perspectiveModel));
        	invoker.executeCommande();
		});
        
        zoomOut.addActionListener((ActionEvent e) -> {	
			//Invoke Command
        	invoker.setCommande(new ZoomOut(perspectiveModel));
        	invoker.executeCommande();
		});
        

        this.sousPanneauDroite.add(this.perspectiveDroite, BorderLayout.CENTER);

        JButton right = new JButton(new ImageIcon("src/Ressources/right.png"));
        JButton left = new JButton(new ImageIcon("src/Ressources/left.png"));
        JButton top = new JButton(new ImageIcon("src/Ressources/top.png"));
        JButton bottom = new JButton(new ImageIcon("src/Ressources/bottom.png"));
        
        right.addActionListener((ActionEvent e) -> {	
			//Invoke Command
        	invoker.setCommande(new Translation(perspectiveModel,1));
        	invoker.executeCommande();
        });
        
        left.addActionListener((ActionEvent e) -> {	
			//Invoke Command
        	invoker.setCommande(new Translation(perspectiveModel,2));
        	invoker.executeCommande();

        });
        
        top.addActionListener((ActionEvent e) -> {	
			//Invoke Command
        	invoker.setCommande(new Translation(perspectiveModel,3));
        	invoker.executeCommande();

        });
        
        bottom.addActionListener((ActionEvent e) -> {	
			//Invoke Command
        	invoker.setCommande(new Translation(perspectiveModel,4));
        	invoker.executeCommande();
        });

        this.sousPanneauDroite.add(right, BorderLayout.SOUTH);
        this.sousPanneauDroite.add(left, BorderLayout.SOUTH);
        this.sousPanneauDroite.add(top, BorderLayout.SOUTH);
        this.sousPanneauDroite.add(bottom, BorderLayout.SOUTH);

        add(this.sousPanneauDroite);
    }
    
}
