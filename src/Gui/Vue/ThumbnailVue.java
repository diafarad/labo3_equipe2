package Gui.Vue;

import java.awt.*;

import Gui.CadreVues;
import Model.ThumbnailModel;
import Observateur.ThumbnailObserver;

public class ThumbnailVue extends Vue implements ThumbnailObserver {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CadreVues cadreVues = CadreVues.getInstance();	
	ThumbnailModel thumbnailModel = ThumbnailModel.getInstance();
	private Image thumbnail;

	public ThumbnailVue() {
		setPanel();
    }
	
	public void setPanel() {
		setPreferredSize(new Dimension(150, 150));
		//setBounds(10, 104, 150, 150);
	}

	public Image getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
	}

	public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(thumbnailModel.getImg(), 0, 0,this);
    }

    @Override
    public void update() {
    	//System.out.println("UPDATE");
    	cadreVues.update();
    }
}
