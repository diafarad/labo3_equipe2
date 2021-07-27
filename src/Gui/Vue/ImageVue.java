package Gui.Vue;

import Model.ImageModel;
import Observateur.ImageObserver;

import java.awt.*;
import java.awt.geom.AffineTransform;

import Gui.CadreVues;

public class ImageVue extends Vue implements ImageObserver {
	private static final long serialVersionUID = 1L;
	
	CadreVues cadreVues = CadreVues.getInstance();
	ImageModel imageModel = ImageModel.getInstance();

	public ImageVue() {
        setPanel();
    }
	
	public void setPanel() {
		setPreferredSize(new Dimension(300, 300));
		setBounds(170, 11, 346, 346);
	}

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        	
        if (imageModel.isOk()) {
            AffineTransform tx = new AffineTransform();
            
            tx.translate(imageModel.getX(), imageModel.getY());

            g2d.setTransform(tx);
            imageModel.getImage().getIcon().paintIcon(this, g2d, 0, 0);
            imageModel.setOk(false);
		}
        else {
        	imageModel.getImage().getIcon().paintIcon(this, g2d, 0, 0);
		}
    }

    @Override
    public void update() {
    	//System.out.println("UPDATE");
    	cadreVues.update();
    }
}
