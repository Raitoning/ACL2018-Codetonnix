package assets.scripts;

import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.SpriteRenderer;

public class Fantome extends Personnage {

    private BoxCollider2D trigger;
    private BoxCollider2D collider;

    public Fantome(int x, int y, int sante) {

        super(x, y, sante);

        name = "Fantome";

        transform.scale().setX(0.5f);
        transform.scale().setY(0.5f);

        addComponent(new SpriteRenderer("ghost", this));

        collider = new BoxCollider2D("Monsters", this);
        addComponent(collider);

//        trigger = new BoxCollider2D("Monsters", this);
//        addComponent(trigger);
    }

    @Override
    public void destroy() {
        super.destroy();

        trigger.destroy();
        collider.destroy();
    }
}
