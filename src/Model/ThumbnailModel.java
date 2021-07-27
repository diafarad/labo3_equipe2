package Model;


import Observateur.ThumbnailObservable;

import java.awt.Image;
import java.io.Serializable;
import Gui.Vue.ThumbnailVue;

public class ThumbnailModel extends ModelBase implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ThumbnailObservable thbObservable = new ThumbnailObservable();

    private static ThumbnailModel instance;
    private static Image image;
    private int width = 100;
    private int height = 100;

    private ThumbnailModel() {
	}
    
    public static ThumbnailModel getInstance() {
    	if (instance == null) {
			instance = new ThumbnailModel();
			thbObservable.ajouterObserver(new ThumbnailVue());
		}
    	return instance;
    }

	public Image getImg() {
        return image;
    }

    public void setImage(Image image) {
    	Image newImage = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ThumbnailModel.image = newImage;
        if (ThumbnailModel.image != null) {
        	ThumbnailModel.thbObservable.avertirLesObservers();
		}
    }
    
    public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ThumbnailObservable getImgObservable() {
		return thbObservable;
	}

	public void setImgObservable(ThumbnailObservable imgObservable) {
		ThumbnailModel.thbObservable = imgObservable;
	}

}
