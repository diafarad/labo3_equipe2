/**
 * 
 */
package Commande;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import Model.ImageModel;
import Model.PerspectiveModel;
import Model.ThumbnailModel;

/**
 * @author diafara
 * Load.java
 * 25 juil. 2021
 * 16:52:29
 */
public class Load extends Commande {

	private ThumbnailModel thumbnailModel = ThumbnailModel.getInstance();
	private ImageModel imageModel = ImageModel.getInstance();
	private PerspectiveModel perspectiveModel = PerspectiveModel.getInstance();
	
	/**
	 * @param model
	 */
	public Load() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean executer() {
		// TODO Auto-generated method stub
		try {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Sélectionnez une image");
			fileChooser.setAcceptAllFileFilterUsed(false);
	
			FileNameExtensionFilter pngFiltre = new FileNameExtensionFilter(".png", "png");
			FileNameExtensionFilter jpgFiltre = new FileNameExtensionFilter(".jpg", "jpg");
			FileNameExtensionFilter jpegFiltre = new FileNameExtensionFilter(".jpeg", "jpeg");
			fileChooser.addChoosableFileFilter(pngFiltre);
			fileChooser.addChoosableFileFilter(jpgFiltre);
			fileChooser.addChoosableFileFilter(jpegFiltre);
	
			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				Image img = ImageIO.read(file);
				ImageIcon ic = new ImageIcon(img);
				thumbnailModel.setImage(img);
				imageModel.setImage(ic);
				imageModel.setPath(file.getAbsolutePath());
				perspectiveModel.setImage(ic);
				perspectiveModel.setPath(file.getAbsolutePath());
			}
			return true;
		} catch (IOException e) {
			// TODO: handle exception
		}
		return false;
	}

}
