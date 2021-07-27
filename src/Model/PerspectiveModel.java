package Model;

/**
 *
 */

import Observateur.PerspectiveObservable;

import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Gui.Vue.PerspectiveVue;

public class PerspectiveModel extends ModelBase implements Serializable {

	private static final long serialVersionUID = 1L;
	private static PerspectiveObservable persObservable = new PerspectiveObservable();
	
	private static PerspectiveModel instance;
	private static JLabel image;
    private static String path;
    private static int x;
    private static int y;
    private boolean ok = false;

    private PerspectiveModel() {
	}
    
    public static PerspectiveModel getInstance() {
    	if (instance == null) {
			instance = new PerspectiveModel();
			image = new JLabel(new ImageIcon());
			x = 0;
			y = 0;
			persObservable.ajouterObserver(new PerspectiveVue());
		}
    	return instance;
    }

    public JLabel getImage() {
        return image;
    }
    
    public void setImage(Icon image) {
    	PerspectiveModel.image.setIcon(image);
    	PerspectiveModel.persObservable.avertirLesObservers();
    }
    
    public void setTranslation(boolean okay) {
    	ok = okay;
    	PerspectiveModel.persObservable.avertirLesObservers();
    }
    
    public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}    
    
    public int getWidth() {
		return  PerspectiveModel.image.getIcon().getIconWidth();
	}

	public int getHeight() {
		return PerspectiveModel.image.getIcon().getIconHeight();
	}


	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		PerspectiveModel.path = path;
	}
	
	public int getX() {
		return x;
	}

	public static void setX(int x) {
		PerspectiveModel.x = x;
	}

	public int getY() {
		return y;
	}

	public static void setY(int y) {
		PerspectiveModel.y = y;
	}
	
	public PerspectiveObservable getPersObservable() {
		return persObservable;
	}

	public void setPersObservable(PerspectiveObservable persObservable) {
		PerspectiveModel.persObservable = persObservable;
	}
}
