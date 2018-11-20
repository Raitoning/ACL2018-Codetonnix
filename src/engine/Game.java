package engine;

import assets.scripts.Fantome;
import assets.scripts.Heros;
import assets.scripts.Labyrinthe;
import assets.scripts.Monstre;
import engine.gameobject.GameObject;

import java.util.ArrayList;
import java.util.Random;

/**
 * <h1>Game</h1>
 * Temporary class supposed to represent a single level (Scene)
 * <p>
 * This class is mostly used for debugging purposes.
 * </p>
 *
 * @author  Raitoning
 * @version 2018-11-14
 * @since   2018-11-14
 */
public class Game {

    private ArrayList<GameObject> gameObjects;

    /** Constructs a new level. Only once should be used at run-time.
     *
     */
    public Game() {

        SpriteFactory.getInstance().addSprite("wall", "src/assets/textures/mur.png");
        SpriteFactory.getInstance().addSprite("floor", "src/assets/textures/sol.png");
        SpriteFactory.getInstance().addSprite("heros", "src/assets/textures/heros.png");
        SpriteFactory.getInstance().addSprite("ghost", "src/assets/textures/ghost/down0.png");
        SpriteFactory.getInstance().addSprite("zombie", "src/assets/textures/zombie/down0.png");
        SpriteFactory.getInstance().addSprite("magic", "src/assets/textures/magic.png");
        SpriteFactory.getInstance().addSprite("trap", "src/assets/textures/trap.png");
        SpriteFactory.getInstance().addSprite("passage", "src/assets/textures/passage.png");
        SpriteFactory.getInstance().addSprite("treasure", "src/assets/textures/treasure.png");

        Engine.getInstance().getPhysics().addLayer("World");
        Engine.getInstance().getPhysics().addLayer("Player");
        Engine.getInstance().getPhysics().addLayer("Monsters");

        gameObjects = new ArrayList<>();

        gameObjects.add(new Labyrinthe());
        gameObjects.add(new Heros(0,0, 100));
        ((Heros)findGameObjectByName("Player")).setLabyrinthe((Labyrinthe)findGameObjectByName("Labyrinthe"));

        Random random = new Random();

        for (int i = 0; i < 5; i++) {

            gameObjects.add(new Monstre(random.nextInt(50), random.nextInt(50), 100));
            gameObjects.add(new Fantome(random.nextInt(50), random.nextInt(50), 100));
        }
    }

    /** This function is called once every frame and updates every GameObjects in the level.
     *
     */
    public void update() {

        for (int i = 0; i < gameObjects.size(); i++) {

            gameObjects.get(i).update();
        }
    }

    public GameObject findGameObjectByName(String name) {

        for (int i = 0; i < gameObjects.size(); i++) {

            if (gameObjects.get(i).getName().equals(name)) {

                return gameObjects.get(i);
            }
        }

        return null;
    }
}
