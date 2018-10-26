package model;

import engine.Cmd;

public abstract class Personnage {

    protected int posX;
    protected int posY;
    protected int ptsVie;


    public Personnage(int posX, int posY, int ptsVie) {
        this.posX = posX;
        this.posY = posY;
        this.ptsVie = ptsVie;
    }

    protected void deplacer(Cmd input){
        //TODO:Border/Collision checks
        if (input.equals(Cmd.RIGHT)){
            posX+=1;
        } else if (input.equals(Cmd.LEFT)){
            posX-=1;
        } else if(input.equals(Cmd.UP)){
            posY-=1;
        }else if(input.equals(Cmd.DOWN)) {
            posY+=1;
        }
    }

    abstract void attaquer(Cmd input);


    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getPtsVie() {
        return ptsVie;
    }
}
