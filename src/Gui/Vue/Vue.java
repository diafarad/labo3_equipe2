package Gui.Vue;

/**
 *
 */
import Model.ModelBase;

import javax.swing.*;
import java.awt.*;

public abstract class Vue extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ModelBase model;
    //*************************************************************************
    //Constructeurs
    public Vue(ModelBase model){
        this.model = model;
    }
    
    public Vue(){
    }

    //**************************************************************************
    //Méthodes
    public Dimension getPrefferedSize()
    {
        return new Dimension(300, 300);
    }

    public Dimension getMinimumSize()
    {
        return getPrefferedSize();
    }

    //*************************************************************************
    //Getter et setter

    public ModelBase getModel() {
        return model;
    }

    public void setModel(ModelBase model) {
        this.model = model;
    }
}
