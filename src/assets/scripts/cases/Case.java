package assets.scripts.cases;

import assets.scripts.Heros;
import engine.gameobject.GameObject;

public abstract class Case extends GameObject {

    private int posX, posY;

    public Case(int x, int y){
        posX = x;
        posY = y;

        transform.position().setX(x);
        transform.position().setY(y);
    }

    public abstract void action(Heros h);

    public boolean isSolid(){
        return false;
    }

    public boolean hasAction(){
        return false;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
