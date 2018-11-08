package model.cases;

public abstract class Case {

    private int posX, posY;

    public Case(int x, int y){
        posX = x;
        posY = y;
    }

    public abstract void action();

    public boolean isSolid(){
        return false;
    }

    public boolean hasAction(){
        return false;
    }

}
