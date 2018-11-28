package assets.scripts.cases;

import assets.scripts.Heros;
import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.Collider;
import engine.gameobject.component.SpriteRenderer;

public class CasePassage extends Case {

    private CasePassage link;
    private BoxCollider2D trigger;

    public CasePassage(int x, int y){
        super(x,y);

        transform.position().setZ(1f);

        components.add(new SpriteRenderer("passage", this));

        trigger = new BoxCollider2D("World", this);
        trigger.setTrigger(true);
        components.add(trigger);
    }

    public CasePassage(int x, int y, CasePassage link) {

        this(x, y);

        this.link = link;
        link.link(this);
    }

    @Override
    public void onTriggerStay2D(Collider other) {

        if(other.getGameObject().getName().equals("Player")) {

            action((Heros)other.getGameObject());
        }
    }

    public void link(CasePassage link) {

        this.link = link;
    }

    public CasePassage getLink() {
        return link;
    }

    @Override
    public void action(Heros h) {

        h.warp(link.getPosX(), link.getPosY());
    }

    @Override
    public String toString() {
        return "3";
    }

    public boolean hasAction(){
        return true;
    }

    @Override
    public void destroy() {
        super.destroy();

        trigger = null;
        link = null;
    }
}
