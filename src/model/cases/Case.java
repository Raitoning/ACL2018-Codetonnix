package model.cases;

public abstract class Case {

    private int posX, posY;

    public Case(int x, int y){
        posX = x;
        posY = y;
    }

    abstract void action();

}
