/**
 * 
 */
package Gui;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Commande.Invoker;
import Commande.Load;
/**
 * @author diafara
 * MenuFentre.java
 * 23 juil. 2021
 * 10:14:31
 */
public class MenuFenetre extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MENU_FICHIER_TITRE = "Fichier";
	private static final String MENU_FICHIER_CHARGER = "Ouvrir";
	private static final String MENU_FICHIER_SAVE = "Sauvegarder";
	private static final String MENU_FICHIER_QUITTER = "Quitter";
	private static final String MENU_OPTION_TITRE = "Options";
	private static final String MENU_OPTION_UNDO = "Undo";
	private static final String MENU_OPTION_REDO = "Redo";
	
	Invoker invoker = new Invoker();
	
	/**
	 * 
	 */
	public MenuFenetre() {
		// TODO Auto-generated constructor stub
		menu();
	}
	
	private void menu() {
		JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
		JMenu menuOption = new JMenu(MENU_OPTION_TITRE);
		
		JMenuItem menuOuvrir = new JMenuItem(MENU_FICHIER_CHARGER);
		JMenuItem menuSave = new JMenuItem(MENU_FICHIER_SAVE);
		JMenuItem menuQuitter = new JMenuItem(MENU_FICHIER_QUITTER);
		JMenuItem menuUndo = new JMenuItem(MENU_OPTION_UNDO);
		JMenuItem menuRedo = new JMenuItem(MENU_OPTION_REDO);
		
		menuOuvrir.addActionListener((ActionEvent e) -> {
				invoker.setCommande(new Load());
				invoker.executeCommande();
		});
		
		menuSave.addActionListener((ActionEvent e) -> {
			//Invoke Command
		});
		
		menuUndo.addActionListener((ActionEvent e) -> {
			//Invoke Command
		});
		
		menuRedo.addActionListener((ActionEvent e) -> {
			//Invoke Command
		});
		
		menuQuitter.addActionListener((ActionEvent e) -> {
			System.exit(0);
		});

		menuFichier.add(menuOuvrir);
		menuFichier.add(menuSave);
		menuFichier.add(menuQuitter);
		menuOption.add(menuUndo);
		menuOption.add(menuRedo);

		add(menuFichier);
		add(menuOption);

	}
}
