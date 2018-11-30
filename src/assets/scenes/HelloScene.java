package assets.scenes;

import assets.scripts.Fantome;
import assets.scripts.Heros;
import assets.scripts.Labyrinthe;
import assets.scripts.Monstre;
import engine.scene.Scene;

import java.util.ArrayList;
import java.util.Random;

public class HelloScene extends Scene {

    private Heros heros;
    private Labyrinthe labyrinthe;

    public HelloScene() {

        super("HelloScene", 0);
    }

    public void load() {

        gameObjects = new ArrayList<>();

        heros = new Heros(0, 0, 10);
        labyrinthe = new Labyrinthe();

        addGameObject(heros);
        addGameObject(labyrinthe);

        heros.setLabyrinthe(labyrinthe);

        Random random = new Random();

        for (int i = 0; i < 5; i++) {

            gameObjects.add(new Monstre(random.nextInt(50), random.nextInt(50), 3));
            gameObjects.add(new Fantome(random.nextInt(50), random.nextInt(50), 2));
        }

        isLoaded = true;
    }
}
