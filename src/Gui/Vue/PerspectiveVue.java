package Gui.Vue;

/**
 *
 */

import Observateur.PerspectiveObserver;

import java.awt.*;
import java.awt.geom.AffineTransform;

import Gui.CadreVues;
import Model.PerspectiveModel;

public class PerspectiveVue extends Vue implements PerspectiveObserver {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CadreVues cadreVues = CadreVues.getInstance();
	PerspectiveModel perspectiveModel = PerspectiveModel.getInstance();

	public PerspectiveVue() {
        setPanel();
    }

    public void setPanel() {
    	setPreferredSize(new Dimension(300, 300));
		setBounds(526, 11, 346, 346);
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
    	
        if (perspectiveModel.isOk()) {
            AffineTransform tx = new AffineTransform();
            
            tx.translate(perspectiveModel.getX(), perspectiveModel.getY());

            g2d.setTransform(tx);
            perspectiveModel.getImage().getIcon().paintIcon(this, g2d, 0, 0);
            perspectiveModel.setOk(false);
		}
        else {
        	perspectiveModel.getImage().getIcon().paintIcon(this, g2d, 0, 0);
		}
    }

    @Override
    public void update() {
    	//System.out.println("UPDATE");
    	cadreVues.update();
    }

}
