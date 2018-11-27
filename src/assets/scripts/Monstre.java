package assets.scripts;

import engine.Time;
import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.SpriteRenderer;

import java.util.Random;

public class Monstre extends Personnage {

    private BoxCollider2D trigger;
    private BoxCollider2D collider;

    private float randomMoveTime = 1f;
    private float randomMoveTimer;

    private float randomX;
    private float randomY;

    private Random random;


    public Monstre(int x, int y, int sante) {

        super(x, y, sante);

        name = "Monstre";

        transform.scale().setX(0.5f);
        transform.scale().setY(0.5f);

        addComponent(new SpriteRenderer("zombie", this));

        collider = new BoxCollider2D("Monsters", this);
        addComponent(collider);

        trigger = new BoxCollider2D("Monsters", this);
        addComponent(trigger);

        random = new Random();
    }

    @Override
    public void update() {

        if (ptsVie>0){

        if(invincible) {

            invincibleTimer += Time.deltaTime;

            if (invincibleTimer >= invincibleTime) {

                invincibleTimer = 0f;
                invincible = false;
            }
        }

        if(randomMoveTimer >= randomMoveTime) {

            randomMoveTimer = 0f;

            randomX = random.nextFloat();
            randomX *= 2f;
            randomX -= 1f;

            randomY = random.nextFloat();
            randomY *= 2f;
            randomY -= 1f;
        }

        randomMoveTimer += Time.deltaTime;

        transform.position().setX(transform.position().getX() + randomX * 5f * Time.deltaTime);
        transform.position().setY(transform.position().getY() + randomY * 5f * Time.deltaTime);
        } else {
            transform.position().setX(-500);
            transform.position().setY(-500);
        }
    }

    @Override
    public void destroy() {
        super.destroy();

        trigger.destroy();
        collider.destroy();
    }
}
