package model;

import engine.Cmd;
import model.cases.CaseDefaut;
import model.cases.CaseMur;

public abstract class Personnage {

    protected int posX;
    protected int posY;
    protected int ptsVie;


    public Personnage(int posX, int posY, int ptsVie) {
        this.posX = posX;
        this.posY = posY;
        this.ptsVie = ptsVie;
    }

    protected void deplacer(Cmd input, Labyrinthe labyrinthe){
        //TODO:Border/Collision checks
        if (input.equals(Cmd.RIGHT)){
            if(posX/20+1 < labyrinthe.getNBCASES()) {
                if (!(labyrinthe.getCases()[posX / 20 + 1][posY / 20] instanceof CaseMur))
                    posX += 20;
            }
        } else if (input.equals(Cmd.LEFT)){
            if(posX/20-1 >= 0) {
                if (!(labyrinthe.getCases()[posX / 20 - 1][posY / 20] instanceof CaseMur))
                    posX -= 20;
            }
        } else if(input.equals(Cmd.UP)){
            if(posY/20-1 >= 0) {
                if (!(labyrinthe.getCases()[posX / 20][posY / 20 - 1] instanceof CaseMur))
                    posY -= 20;
            }
        }else if(input.equals(Cmd.DOWN)) {
            if(posY/20+1 < labyrinthe.getNBCASES()) {
                if (!(labyrinthe.getCases()[posX / 20][posY / 20 + 1] instanceof CaseMur))
                    posY += 20;
            }
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
