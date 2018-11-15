package model.cases;

import model.Heros;

public abstract class Case {

    private int posX, posY;

    public Case(int x, int y){
        posX = x;
        posY = y;
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
