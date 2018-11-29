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


    // FIXME: Impossible de détruire le GameObject entièrement (trigger + sprite renderer)
    public Monstre(int x, int y, int sante) {

        super(x, y, sante);

        name = "Monstre";

        transform.scale().setX(0.5f);
        transform.scale().setY(0.5f);

        components.add(new SpriteRenderer("zombie", this));

        components.add(new BoxCollider2D("Monsters", this));

        trigger = new BoxCollider2D("Monsters", this);
        trigger.setTrigger(true);
        components.add(trigger);

        random = new Random();
    }

    @Override
    public void update() {
        super.update();

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

            destroy();
        }
    }

    @Override
    public void destroy() {
        super.destroy();

        trigger.destroy();
        trigger = null;
        collider.destroy();
        collider = null;

        random = null;

        for (int i = 0; i < components.size(); i++) {

            components.get(i).destroy();
        }
    }
}
