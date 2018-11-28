package assets.scripts.cases;

import assets.scripts.Heros;
import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.SpriteRenderer;

public class CaseMur extends Case {

    private BoxCollider2D collider;

    public CaseMur(int x, int y){
        super(x,y);

        transform.position().setZ(1f);

        components.add(new SpriteRenderer("wall", this));

        collider = new BoxCollider2D("World", this);
        collider.setIsStatic(true);
        components.add(collider);
    }

    @Override
    public void action(Heros h) {

    }

    @Override
    public String toString() {
        return "1";
    }


    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public void destroy() {
        super.destroy();

        collider.destroy();
        collider = null;
    }
}
