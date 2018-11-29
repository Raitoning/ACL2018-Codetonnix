package assets.scripts;

import engine.Mathf;
import engine.Time;
import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.Collider;
import engine.gameobject.component.SpriteRenderer;
import engine.input.Input;

public class Fantome extends Personnage {

    private BoxCollider2D trigger;
    private Heros heros;

    SpriteRenderer localSpriteRenderer;

    private static final String idle = "ghost.idle";
    private static final String left = "ghost.left";
    private static final String right = "ghost.right";
    private static final String up = "ghost.up";
    private static final String down = "ghost.down";

    public Fantome(int x, int y, int sante) {

        super(x, y, sante);

        name = "Fantome";

        transform.scale().setX(0.5f);
        transform.scale().setY(0.5f);

        localSpriteRenderer= new SpriteRenderer(idle+animationID,this);

        addComponent(localSpriteRenderer);

        trigger = new BoxCollider2D("Monsters", this);
        trigger.setTrigger(true);
        addComponent(trigger);
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
            animationTimer += Time.deltaTime;

            if (animationTimer >= animationTime) {

                animationTimer = 0f;
                animIDIncr();
                localSpriteRenderer.setName(getAnimation());
            }

            if(heros == null) {

                heros = (Heros)findByName("Player");
            } else {

                transform.position().setX(Mathf.lerp(transform.position().getX(),
                        heros.getTransform().position().getX(), Time.deltaTime));
                transform.position().setY(Mathf.lerp(transform.position().getY(),
                        heros.getTransform().position().getY(), Time.deltaTime));
        }

        } else {

            destroy();
        }
    }

    private String getAnimation(){

        if (transform.position().getX()-heros.getTransform().position().getX()>0.3f){
            return left+animationID;
        } else if(transform.position().getX()-heros.getTransform().position().getX()<-0.3f){
            return right+animationID;
        } else if (transform.position().getY()-heros.getTransform().position().getY()>-0.1f){
            return down+animationID;
        } else if(transform.position().getY()-heros.getTransform().position().getY()<0.1f){
            return up+animationID;
        }

        return idle+animationID;
    }
}
