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
     * Les images utilisées pour les boutons
     */
    protected String murPath = "/img/Mur.png";
    protected Image[] tableauPng;

    /**
     * Permet de creer les images
     */
    public ImageFactory() {
        try {
            this.tableauPng[0] = ImageIO.read(this.getClass().getResourceAsStream(murPath));
            //this.murPng = new ImageIcon(mur);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Image[] getTableauPng() {
        return tableauPng;
    }
}
