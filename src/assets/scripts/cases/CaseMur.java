package assets.scripts.cases;

import assets.scripts.Heros;
import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.SpriteRenderer;

public class CaseMur extends Case {

    private BoxCollider2D collider;
    private SpriteRenderer sr;

    public CaseMur(int x, int y){
        super(x,y);

        transform.position().setZ(1f);
        sr = new SpriteRenderer("wall", this);
        components.add(sr);

        collider = new BoxCollider2D("World", this);
        collider.setIsStatic(true);
        components.add(collider);
    }

    @Override
    public void action(Heros h) {

    }

    public void setSr(String s) {
        this.sr.setName(s);
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
