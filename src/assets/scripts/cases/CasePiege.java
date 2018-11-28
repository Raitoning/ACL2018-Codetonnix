package assets.scripts.cases;

import assets.scripts.Heros;
import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.Collider;
import engine.gameobject.component.SpriteRenderer;

public class CasePiege extends Case {

    private BoxCollider2D trigger;
    private SpriteRenderer spriteRenderer;

    public CasePiege(int x, int y){
        super(x,y);

        transform.position().setZ(1f);

        spriteRenderer = new SpriteRenderer("floor", this);

        components.add(spriteRenderer);

        trigger = new BoxCollider2D("World", this);
        trigger.setTrigger(true);
        components.add(trigger);
    }

    @Override
    public void action(Heros h) {
        //Blesse le Joueur
        h.recieveDamage(1);
        spriteRenderer.setName("trap");
    }

    @Override
    public void onTriggerStay2D(Collider other) {

        if(other.getGameObject().getName().equals("Player")) {

            action((Heros)other.getGameObject());
        }
    }

    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public String toString() {
        return "4";
    }
}
