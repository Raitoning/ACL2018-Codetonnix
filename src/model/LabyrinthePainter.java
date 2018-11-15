package model;

import engine.GamePainter;
import model.cases.Case;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LabyrinthePainter implements GamePainter {

    private final int WIDTH = 1000, HEIGHT = 1000, TAILLECASE = 20;
    private Jeu jeu;
    private ImageFactory images;

    /**
     * appelle constructeur
     *
     * @param j
     *            Jeu a déssiner
     */
    public LabyrinthePainter(Jeu j, ImageFactory imgf) {
        this.jeu = j;
        this.images = imgf;
    }

    @Override
    public void draw(BufferedImage im) {
        Graphics2D crayon = (Graphics2D) im.getGraphics();
        crayon.setColor(Color.YELLOW);
        for(int i = 0; i<this.jeu.getLabyrinthe().getCases().length; i++ ){
            for(int j = 0; j< this.jeu.getLabyrinthe().getCases()[0].length; j++ ){
                if(this.jeu.getLabyrinthe().getCases()[i][j].toString() == "0") crayon.drawImage(images.getTableauPng()[0],i*TAILLECASE,j*TAILLECASE, null);
                if(this.jeu.getLabyrinthe().getCases()[i][j].toString() == "1") crayon.drawImage(images.getTableauPng()[1],i*TAILLECASE,j*TAILLECASE, null);

                if(this.jeu.getLabyrinthe().getCases()[i][j].toString() == "2") crayon.drawImage(images.getTableauPng()[3],i*TAILLECASE,j*TAILLECASE, null);
                if(this.jeu.getLabyrinthe().getCases()[i][j].toString() == "3") crayon.drawImage(images.getTableauPng()[4],i*TAILLECASE,j*TAILLECASE, null);
                if(this.jeu.getLabyrinthe().getCases()[i][j].toString() == "4") crayon.drawImage(images.getTableauPng()[5],i*TAILLECASE,j*TAILLECASE, null);
                if(this.jeu.getLabyrinthe().getCases()[i][j].toString() == "5") crayon.drawImage(images.getTableauPng()[6],i*TAILLECASE,j*TAILLECASE, null);
            }
        }
        Heros heros = jeu.getHeros();
        crayon.setColor(Color.cyan);
        crayon.drawImage(images.getTableauPng()[2], heros.posX,heros.posY,null);
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
}
