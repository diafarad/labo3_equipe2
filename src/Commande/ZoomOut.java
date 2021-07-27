/**
 * 
 */
package Commande;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Model.ImageModel;
import Model.ModelBase;
import Model.PerspectiveModel;

/**
 * @author diafara
 * ZoomIn.java
 * 25 juil. 2021
 * 12:10:25
 */
public class ZoomOut extends Commande {
	/**
	 * @param imageModel
	 */
	private static final int level = 50;
	ModelBase model;
	
	public ZoomOut(ModelBase m) {
		super(m);
		model = m;
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public boolean executer() {
		// TODO Auto-generated method stub
		backUp(); // Sauvergarde l'état du modele avant d'effectuer la commande
		if (model instanceof ImageModel) {
			try {
				ImageModel im = ImageModel.getInstance();
				int w = im.getWidth() - level;
				int h = im.getHeight() - level;
				File file = new File(im.getPath());
				Image img = ImageIO.read(file);
				ImageIcon ic = new ImageIcon(zoom(w, h, img));
				im.setImage(ic);
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		else {
			try {
				PerspectiveModel im = PerspectiveModel.getInstance();
				int w = im.getWidth() - level;
				int h = im.getHeight() - level;
				File file = new File(im.getPath());
				Image img = ImageIO.read(file);
				ImageIcon ic = new ImageIcon(zoom(w, h, img));
				im.setImage(ic);
			return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
	}
	
	public Image zoom(int w, int h, Image img) {
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(img,0,0,w,h,null);
		g.dispose();
		return bi;
	}
}
