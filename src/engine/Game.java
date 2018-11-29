package engine;

import assets.scenes.HelloScene;
import assets.scripts.Fantome;
import assets.scripts.Heros;
import assets.scripts.Labyrinthe;
import assets.scripts.Monstre;
import engine.exception.GameObjectNotFoundException;
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
 * @version 2018.11.26
 * @since   2018.11.14
 */
public class Game {

    private ArrayList<GameObject> gameObjects;

    /** Constructs a new level. Only once should be used at run-time.
     *
     */
    public Game() {

        SpriteFactory.getInstance().addSprite("wall", "src/assets/textures/mur.png");
        SpriteFactory.getInstance().addSprite("wallup", "src/assets/textures/murup.png");
        SpriteFactory.getInstance().addSprite("floor", "src/assets/textures/sol.png");

        /* LEGACY
        SpriteFactory.getInstance().addSprite("heros", "src/assets/textures/heros.png");
              */

        /* Hero */

        //IDLE
        SpriteFactory.getInstance().addSprite("hero.idle0", "src/assets/textures/hero/idle0.png");
        SpriteFactory.getInstance().addSprite("hero.idle1", "src/assets/textures/hero/idle1.png");
        SpriteFactory.getInstance().addSprite("hero.idle2", "src/assets/textures/hero/idle2.png");
        SpriteFactory.getInstance().addSprite("hero.idle3", "src/assets/textures/hero/idle3.png");

        //LEFT
        SpriteFactory.getInstance().addSprite("hero.left0", "src/assets/textures/hero/left0.png");
        SpriteFactory.getInstance().addSprite("hero.left1", "src/assets/textures/hero/left1.png");
        SpriteFactory.getInstance().addSprite("hero.left2", "src/assets/textures/hero/left2.png");
        SpriteFactory.getInstance().addSprite("hero.left3", "src/assets/textures/hero/left3.png");
        SpriteFactory.getInstance().addSprite("hero.leftA", "src/assets/textures/hero/leftAttackStance.png");


        //RIGHT
        SpriteFactory.getInstance().addSprite("hero.right0", "src/assets/textures/hero/right0.png");
        SpriteFactory.getInstance().addSprite("hero.right1", "src/assets/textures/hero/right1.png");
        SpriteFactory.getInstance().addSprite("hero.right2", "src/assets/textures/hero/right2.png");
        SpriteFactory.getInstance().addSprite("hero.right3", "src/assets/textures/hero/right3.png");
        SpriteFactory.getInstance().addSprite("hero.rightA", "src/assets/textures/hero/rightAttackStance.png");

        //UP
        SpriteFactory.getInstance().addSprite("hero.up0", "src/assets/textures/hero/up0.png");
        SpriteFactory.getInstance().addSprite("hero.up1", "src/assets/textures/hero/up1.png");
        SpriteFactory.getInstance().addSprite("hero.up2", "src/assets/textures/hero/up2.png");
        SpriteFactory.getInstance().addSprite("hero.up3", "src/assets/textures/hero/up3.png");

        //DOWN
        SpriteFactory.getInstance().addSprite("hero.down0", "src/assets/textures/hero/down0.png");
        SpriteFactory.getInstance().addSprite("hero.down1", "src/assets/textures/hero/down1.png");
        SpriteFactory.getInstance().addSprite("hero.down2", "src/assets/textures/hero/down2.png");
        SpriteFactory.getInstance().addSprite("hero.down3", "src/assets/textures/hero/down3.png");

        //ANIMATION
        SpriteFactory.getInstance().addSprite("hero.anim0", "src/assets/textures/hero/anim0.png");
        SpriteFactory.getInstance().addSprite("hero.anim1", "src/assets/textures/hero/anim1.png");
        SpriteFactory.getInstance().addSprite("hero.anim2", "src/assets/textures/hero/anim2.png");
        SpriteFactory.getInstance().addSprite("hero.anim3", "src/assets/textures/hero/anim2.png");



        SpriteFactory.getInstance().addSprite("ghost", "src/assets/textures/ghost/down0.png");
        SpriteFactory.getInstance().addSprite("zombie", "src/assets/textures/zombie/down0.png");
        SpriteFactory.getInstance().addSprite("magic", "src/assets/textures/magic.png");
        SpriteFactory.getInstance().addSprite("trap", "src/assets/textures/trap.png");
        SpriteFactory.getInstance().addSprite("passage", "src/assets/textures/passage.png");
        SpriteFactory.getInstance().addSprite("treasure", "src/assets/textures/treasure.png");
        SpriteFactory.getInstance().addSprite("healthBar", "src/assets/textures/healthBar.png");
        SpriteFactory.getInstance().addSprite("healthBarMax", "src/assets/textures/healthBarMax.png");

        Engine.getInstance().getPhysics().addLayer("World");
        Engine.getInstance().getPhysics().addLayer("Player");
        Engine.getInstance().getPhysics().addLayer("Monsters");

        gameObjects = new ArrayList<>();

        new HelloScene();

//        gameObjects.add(new Heros(0,0, 10));
//
//        gameObjects.add(new Labyrinthe());
//        ((Heros)findGameObjectByName("Player")).setLabyrinthe((Labyrinthe)findGameObjectByName("Labyrinthe"));
//
//        Random random = new Random();
//
//        for (int i = 0; i < 5; i++) {
//
//            gameObjects.add(new Monstre(random.nextInt(50), random.nextInt(50), 3));
//            gameObjects.add(new Fantome(random.nextInt(50), random.nextInt(50), 2));
//        }
    }

    /** This function is called once every frame and updates every GameObjects in the level.
     *
     */
    public void update() {

        for (int i = 0; i < gameObjects.size(); i++) {

            gameObjects.get(i).update();
        }
    }

    /** Return a GameObject given it's name if it exists, or throws an UnknownGameObjectException otherwise.
     *
     * @param name The name of the GameObject to search.
     * @return The first GameObject with name, or null if it doesn't exists and throws an UnknownGameObjectException Exception.
     */
    public GameObject findGameObjectByName(String name) {

        for (int i = 0; i < gameObjects.size(); i++) {

            if (gameObjects.get(i).getName().equals(name)) {

                return gameObjects.get(i);
            }
        }

        try {

            throw new GameObjectNotFoundException(name);
        } catch (GameObjectNotFoundException e) {

            e.printStackTrace();
        }
        return null;
    }
}
