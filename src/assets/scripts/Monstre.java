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

    private static final String idle = "zombie.idle";
    private static final String left = "zombie.left";
    private static final String right = "zombie.right";
    private static final String up = "zombie.up";
    private static final String down = "zombie.down";

     SpriteRenderer localSpriteRenderer;

    // FIXME: Impossible de détruire le GameObject entièrement (trigger + sprite renderer)
    public Monstre(int x, int y, int sante) {

        super(x, y, sante);

        name = "Monstre";

        transform.scale().setX(0.5f);
        transform.scale().setY(0.5f);


        localSpriteRenderer= new SpriteRenderer(idle+animationID,this);

        components.add(localSpriteRenderer);

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

            animationTimer += Time.deltaTime;

            if (animationTimer >= animationTime) {

                animationTimer = 0f;
                animIDIncr();
                localSpriteRenderer.setName(getAnimation());
            }

            randomMoveTimer += Time.deltaTime;

            transform.position().setX(transform.position().getX() + randomX * 5f * Time.deltaTime);
            transform.position().setY(transform.position().getY() + randomY * 5f * Time.deltaTime);
        } else {

            destroy();
        }
    }

    private String getAnimation(){

        if (randomX<0.3f&&(randomX>randomY)){
            return left+animationID;
        } else if(randomX>-0.3f&&(randomX>randomY)){
            return right+animationID;
        } else if (randomY<-0.1f){
            return down+animationID;
        } else if(randomY>0.1f){
            return up+animationID;
        }

        return idle+animationID;
    }
}
