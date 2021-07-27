/**
 * 
 */
package Model;


import javax.swing.Icon;
import javax.swing.JLabel;


/**
 * @author diafara
 * ModelBase.java
 * 25 juil. 2021
 * 15:16:14
 */
public abstract class ModelBase {
	private JLabel image;
	@SuppressWarnings("unused")
	private static ModelBase instance;
    
    public JLabel getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image.setIcon(image);
    }
}
