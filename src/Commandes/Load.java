/**
 *
 */
package Commandes;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import Model.ImageModel;
import Model.ModelBase;
import Model.PerspectiveModel;

/**
 * @author diafara
 * Load.java
 * 25 juil. 2021
 * 16:52:29
 */
public class Load extends Commandes {

    public Load(ArrayList<ModelBase> listeModel) {
        super(listeModel);
    }

    @Override
    public void executer() {
        // TODO Auto-generated method stub
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

            for (int i = 0; i < getListeModel().size(); i++) {

                if (getListeModel().get(i) instanceof ImageModel) {

                    ((ImageModel) getListeModel().get(i)).setSourceImage(file.getAbsolutePath());
                    ((ImageModel) getListeModel().get(i)).avertirLesObservers();
                } else {
                    ((PerspectiveModel) getListeModel().get(i)).setSourceImage(file.getAbsolutePath());
                    ((PerspectiveModel) getListeModel().get(i)).avertirLesObservers();
                }
            }
        }
    }
}
