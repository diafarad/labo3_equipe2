/**
 * 
 */
package Gui;

import javax.swing.JPanel;

import Gui.Vue.ThumbnailVue;
/**
 * @author diafara
 * Test.java
 * 25 juil. 2021
 * 11:17:40
 */
public class Test extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ThumbnailVue thumbnail = new ThumbnailVue();
	//private Vue imageVue = new ImageVue(imageModel);
	//private Vue perspectiveVue = new PerspectiveVue(perspectiveModel);
	
	public Test() {
		setLayout(null);
		
		add(thumbnail);
		//add(imageVue);
		//add(perspectiveVue);
	}
	
	public void panelThumbnail() {
		add(thumbnail);
	}
}
