package assets.scripts;

import engine.Mathf;
import engine.Time;
import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.Collider;
import engine.gameobject.component.SpriteRenderer;

public class Fantome extends Personnage {

    private BoxCollider2D trigger;
    private Heros heros;

    public Fantome(int x, int y, int sante) {

        super(x, y, sante);

        name = "Fantome";

        transform.scale().setX(0.5f);
        transform.scale().setY(0.5f);

        addComponent(new SpriteRenderer("ghost", this));

        trigger = new BoxCollider2D("Monsters", this);
        trigger.setTrigger(true);
        addComponent(trigger);
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

        if(heros == null) {

            heros = (Heros)findByName("Player");
        } else {

            transform.position().setX(Mathf.lerp(transform.position().getX(),
                    heros.getTransform().position().getX(), Time.deltaTime));
            transform.position().setY(Mathf.lerp(transform.position().getY(),
                    heros.getTransform().position().getY(), Time.deltaTime));
        }

        } else {
            //TODO: Upgrade
            transform.position().setX(-500);
            transform.position().setY(-500);
        }
    }

    @Override
    public void destroy() {
        super.destroy();

        trigger.destroy();
    }
}
