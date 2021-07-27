package Observateur;

/**
 * Classe abstraite du patron Observable
 *
 * @author Daniel Dumitru
 * @version ETE 2021 - TP3
 */


import java.util.ArrayList;

public class ImageObservable {

    //Liste des observers
    private ArrayList<ImageObserver> observers = new ArrayList<ImageObserver>();

    /**
     * Méthode pour attacher un Observer
     *
     * @param observer
     */
    public void ajouterObserver(ImageObserver observer) {

        observers.add(observer);
    }

    /**
     * Méthode pour compter tous les observers
     */
    public int compterObservers() {
        return observers.size();
    }

    /**
     * Méthode pour effacer tous les observers
     */
    public void effacerObservers(){
        observers.clear();
    }

    /**
     * Méthode pour avertir tous les observers
     */
    public void avertirLesObservers() {

        for (ImageObserver observer : observers)
            observer.update();
    }
}


