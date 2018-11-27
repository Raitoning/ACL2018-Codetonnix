package assets.scripts.cases;

import assets.scripts.Heros;
import engine.Time;
import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.Collider;
import engine.gameobject.component.SpriteRenderer;

import java.util.Random;

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
            Random r = new Random();
            int n = r.nextInt(30);

            if (n< 10 ) {
                h.magicHeal(r.nextInt(3)+1);//Heal me
            } else if (n<20){
                h.magicBuff(true); //Damage Boost
            } else {
                h.magicBuff(false);//Speed Boost
            }
            active = true;
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
