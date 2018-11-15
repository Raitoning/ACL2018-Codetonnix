package model;

import engine.Cmd;
import model.cases.CaseDefaut;
import model.cases.CaseMur;

public abstract class Personnage {

    protected int posX;
    protected int posY;
    protected int ptsVie;
    protected boolean invincible;


    public Personnage(int posX, int posY, int ptsVie) {
        this.posX = posX;
        this.posY = posY;
        this.ptsVie = ptsVie;
        this.invincible = false;
    }

    protected void deplacer(Cmd input, Labyrinthe labyrinthe){
        //TODO:Border/Collision checks
        if (input.equals(Cmd.RIGHT)){
            if(posX/20+1 < labyrinthe.getNBCASES()) {
                if (!(labyrinthe.getCases()[posX / 20 + 1][posY / 20].isSolid()))
                    posX += 20;
            }
        } else if (input.equals(Cmd.LEFT)){
            if(posX/20-1 >= 0) {
                if (!(labyrinthe.getCases()[posX / 20 - 1][posY / 20].isSolid()))
                    posX -= 20;
            }
        } else if(input.equals(Cmd.UP)){
            if(posY/20-1 >= 0) {
                if (!(labyrinthe.getCases()[posX / 20][posY / 20 - 1].isSolid()))
                    posY -= 20;
            }
        }else if(input.equals(Cmd.DOWN)) {
            if(posY/20+1 < labyrinthe.getNBCASES()) {
                if (!(labyrinthe.getCases()[posX / 20][posY / 20 + 1].isSolid()))
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

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setPos(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public int getPtsVie() {
        return ptsVie;
    }

    public void repostion(Labyrinthe l, int posx ,int posy){

        int x = posx;
        int y = posy;

        while (l.getCases()[x/20][y/20].isSolid()){
            y=+20;
            if(l.getCases()[x/20][y/20].isSolid())
                x=+20;
        }

        this.posX = x;
        this.posY = y;

    }

    public void setPtsVie(int ptsVie) {
        this.ptsVie = ptsVie;
    }

    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean invincible) {
        this.invincible = invincible;
    }
}
