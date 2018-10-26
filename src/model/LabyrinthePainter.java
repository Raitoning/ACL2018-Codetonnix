package model;

import engine.GamePainter;
import model.cases.Case;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LabyrinthePainter implements GamePainter {

    private final int WIDTH = 800, HEIGHT = 800;
    private Jeu jeu;

    /**
     * appelle constructeur
     *
     * @param j
     *            Jeu a déssiner
     */
    public LabyrinthePainter(Jeu j) {
        this.jeu = j;
    }

    @Override
    public void draw(BufferedImage im) {
        Graphics2D crayon = (Graphics2D) im.getGraphics();
        crayon.setColor(Color.YELLOW);
        Case[][] tmp = this.jeu.getLabyrinthe().getCases();
        for(int i = 0; i<tmp.length; i++ ){
            for(int j = 0; j< tmp[0].length; i++ ){
                crayon.fillRect(i*10,j*10,30,30);
            }
        }

        Heros heros = jeu.getHeros();
        crayon.setColor(Color.cyan);
        crayon.fillOval(heros.posX,heros.posY,30,30);
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
