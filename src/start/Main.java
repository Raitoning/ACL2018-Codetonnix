package start;

import model.Heros;
import model.HerosController;
import model.Jeu;
import model.HerosPainter;
import engine.GameEngineGraphical;


/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		Jeu game = new Jeu("helpFilePacman.txt", new Heros(0,0,25));

		HerosPainter painter = new HerosPainter(game);
		HerosController controller = new HerosController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}

}
