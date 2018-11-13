package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.Cmd;
import engine.GamePainter;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class HerosPainter implements GamePainter {

	/**
	 * la taille des cases
	 */
	protected static final int WIDTH = 800;
	protected static final int HEIGHT = 800;

    private Jeu jeu;
	private Heros heros;

	/**
	 * appelle constructeur parent
	 * 
	 * @param game
	 *            Jeu a déssiner (temporairement uniquement le heros)
	 */
	public HerosPainter(Jeu game) {
	    this.jeu = game;
        this.heros = game.getHeros();
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
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
