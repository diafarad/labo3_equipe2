package Model;


import Observateur.ImageObservable;

import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Gui.Vue.ImageVue;

public class ImageModel extends ModelBase implements Serializable {

	private static final long serialVersionUID = 1L;
	private static ImageObservable imgObservable = new ImageObservable();

    private static ImageModel instance;
    private static JLabel image;
    private static String path;
    private static int x;
    private static int y;
    private boolean ok = false;

    private ImageModel() {
	}
    
    public static ImageModel getInstance() {
    	if (instance == null) {
			instance = new ImageModel();
			image = new JLabel(new ImageIcon());
			x = 0;
			y = 0;
			imgObservable.ajouterObserver(new ImageVue());
		}
    	return instance;
    }

	public JLabel getImage() {
        return image;
    }

    public void setImage(Icon image) {
        ImageModel.image.setIcon(image);
        ImageModel.imgObservable.avertirLesObservers();
    }
    
    public void setTranslation(boolean okay) {
    	ok = okay;
    	ImageModel.imgObservable.avertirLesObservers();
    }
    
    public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public int getWidth() {
		return  ImageModel.image.getIcon().getIconWidth();
	}

	public int getHeight() {
		return ImageModel.image.getIcon().getIconHeight();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		ImageModel.path = path;
	}

	public int getX() {
		return x;
	}

	public static void setX(int x) {
		ImageModel.x = x;
	}

	public int getY() {
		return y;
	}

	public static void setY(int y) {
		ImageModel.y = y;
	}

	public ImageObservable getImgObservable() {
		return imgObservable;
	}

	public void setImgObservable(ImageObservable imgObservable) {
		ImageModel.imgObservable = imgObservable;
	}

}
