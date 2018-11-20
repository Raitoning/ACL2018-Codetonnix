package assets.scripts.cases;

import assets.scripts.Heros;
import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.Collider;
import engine.gameobject.component.SpriteRenderer;

public class CasePiege extends Case {

    private boolean active;
    private BoxCollider2D trigger;

    public CasePiege(int x, int y){
        super(x,y);
        active = false;

        transform.position().setZ(1f);

        components.add(new SpriteRenderer("trap", this));

        trigger = new BoxCollider2D("World", this);
        trigger.setTrigger(true);
        components.add(trigger);
    }

    @Override
    public void action(Heros h) {
        //Blesse le Joueur
        h.setPtsVie(h.getPtsVie()-1);
        h.setInvincible(true);
        active = true;
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
