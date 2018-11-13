package model;

import engine.Cmd;

public class Heros extends Personnage {


    public Heros(int posX, int posY, int ptsVie) {
        super(posX, posY, ptsVie);
    }

    public boolean isAlive(){
        if (ptsVie>=0){
            return  true;
        }
        return false;
    }

    @Override
    void attaquer(Cmd input) {

    }
}
