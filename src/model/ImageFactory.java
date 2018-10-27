package model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;

public class ImageFactory {

    /**
     * Les images utilisées pour les cases
     */
    protected String murPath = "/img/mur.png";
    protected String solPath = "/img/sol.png";
    protected String herosPath = "/img/heros.png";
    protected Image[] tableauPng;

    /**
     * Permet de creer les images
     */
    public ImageFactory() {
        try {
            this.tableauPng = new Image[3];
            this.tableauPng[0] = ImageIO.read(this.getClass().getResourceAsStream(solPath));
            this.tableauPng[1] = ImageIO.read(this.getClass().getResourceAsStream(murPath));
            this.tableauPng[2] = ImageIO.read(this.getClass().getResourceAsStream(herosPath));
            //this.murPng = new ImageIcon(mur);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Image[] getTableauPng() {
        return tableauPng;
    }
}
