package Observateur;

/**
 * Classe abstraite du patron Observable
 *
 * @author Daniel Dumitru
 * @version ETE 2021 - TP3
 */


import java.util.ArrayList;

public class ThumbnailObservable {

    //Liste des observers
    private ArrayList<ThumbnailObserver> observers = new ArrayList<ThumbnailObserver>();

    /**
     * M�thode pour attacher un Observer
     *
     * @param observer
     */
    public void ajouterObserver(ThumbnailObserver observer) {

        observers.add(observer);
    }

    /**
     * M�thode pour compter tous les observers
     */
    public int compterObservers() {
        return observers.size();
    }

    /**
     * M�thode pour effacer tous les observers
     */
    public void effacerObservers(){
        observers.clear();
    }

    /**
     * M�thode pour avertir tous les observers
     */
    public void avertirLesObservers() {

        for (ThumbnailObserver observer : observers)
            observer.update();
    }
}


