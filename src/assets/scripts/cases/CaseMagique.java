package assets.scripts.cases;

import assets.scripts.Heros;
import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.Collider;
import engine.gameobject.component.SpriteRenderer;

public class CaseMagique extends Case{

    private BoxCollider2D trigger;

    private boolean active;

    public CaseMagique(int x, int y){

        super(x,y);
        transform.position().setZ(1f);
        active = false;

        components.add(new SpriteRenderer("magic", this));

        trigger = new BoxCollider2D("World", this);
        trigger.setTrigger(true);
        components.add(trigger);
    }

    @Override
    public void action(Heros h) {
        //Fait quelquechose
        if(!active){
            h.setPtsVie(h.getPtsVie()+1);
            this.active = true;
        }
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
        return "2";
    }
}
