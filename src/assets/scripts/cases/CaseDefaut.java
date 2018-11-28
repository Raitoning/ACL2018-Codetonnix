package assets.scripts.cases;

import assets.scripts.Heros;
import engine.gameobject.component.SpriteRenderer;

// FIXME: Impossible de détruire le GameObject entièrement.
public class CaseDefaut extends Case{

    public CaseDefaut(int x, int y){
        super(x,y);

        transform.position().setZ(2f);
        components.add(new SpriteRenderer("floor", this));
    }

    @Override
    public void action(Heros h) {

    }

    @Override
    public String toString() {
        return "0";
    }
}
