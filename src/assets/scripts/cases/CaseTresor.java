package assets.scripts.cases;

import assets.scripts.Heros;
import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.Collider;
import engine.gameobject.component.SpriteRenderer;

public class CaseTresor extends Case{

    private BoxCollider2D trigger;

    public CaseTresor(int x, int y){
        super(x,y);

        transform.position().setZ(1f);

        components.add(new SpriteRenderer("treasure", this));

        trigger = new BoxCollider2D("World", this);
        trigger.setTrigger(true);
        components.add(trigger);
    }

    @Override
    public void action(Heros h) {
        //met fin au jeu
        System.out.println("Tu as vaincu !");
    }

    @Override
    public void onTriggerStay2D(Collider other) {

        if(other.getGameObject().getName().equals("Player")) {

            action((Heros)other.getGameObject());
        }
    }

    @Override
    public String toString() {
        return "5";
    }

    public boolean hasAction(){
        return true;
    }

    @Override
    public void destroy() {
        super.destroy();

        trigger.destroy();
        trigger = null;
    }
}
