package main;

import Gui.CadreVues;

public class Main {

    public static void main(String[] args) {

        /*
        TheWindow w = new TheWindow();
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X wont close the window with out this line
        w.setSize(900,400);
        w.setVisible(true);

         */

        CadreVues cadreVues = CadreVues.getInstance();
        cadreVues.run();
    }
}
