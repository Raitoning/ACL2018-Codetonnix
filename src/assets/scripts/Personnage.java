package assets.scripts;

import engine.gameobject.GameObject;

public abstract class Personnage extends GameObject {

    protected int posX;
    protected int posY;
    protected int ptsVie;
    protected int ptsVieMax;
    protected boolean invincible;
    protected boolean warped = false;
    protected float invincibleTimer;
    protected float invincibleTime = 0.2f;

    public Personnage(int posX, int posY, int ptsVie) {

        this.posX = posX;
        this.posY = posY;
        this.ptsVie = ptsVie;
        this.ptsVieMax = ptsVie;
        this.invincible = false;

        transform.position().setX(posX);
        transform.position().setY(posY);
    }

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

        while (l.getCases()[x / 20][y / 20].isSolid()){

            y =+ 20;

            if(l.getCases()[x / 20][y / 20].isSolid()) {

                x=+20;
            }
        }

        this.posX = x;
        this.posY = y;

    }

    public void recieveDamage(int damage){
        if(!invincible) {

            ptsVie -= damage;
            invincible = true;

        }
    }

    public void warp(int x, int y) {

        if(!warped) {

            posX = x;
            posY = y;

            transform.position().setX(x);
            transform.position().setY(y);

            warped = true;
        }
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

    @Override
    public void destroy() {
        super.destroy();
    }
}
