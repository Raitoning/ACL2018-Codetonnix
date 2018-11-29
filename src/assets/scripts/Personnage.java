package assets.scripts;

import engine.Game;
import engine.SpriteReference;
import engine.gameobject.GameObject;
import engine.gameobject.component.SpriteRenderer;

public abstract class Personnage extends GameObject {

    protected int posX;
    protected int posY;
    protected int ptsVie;
    protected int ptsVieMax;
    protected boolean invincible;
    protected boolean warped = false;
    protected float invincibleTimer;
    protected float invincibleTime = 0.2f;
    protected float animationTimer;
    protected float animationTime = 0.15f;
    protected int animationID;
    protected GameObject healthBarObject;
    protected GameObject healthBarMaxObject;

    public Personnage(int posX, int posY, int ptsVie) {

        this.posX = posX;
        this.posY = posY;
        this.ptsVie = ptsVie;
        this.ptsVieMax = ptsVie;
        this.invincible = false;
        animationTimer=0f;
        healthBarMaxObject = new GameObject();
        healthBarMaxObject.addComponent(new SpriteRenderer("healthBarMax", healthBarMaxObject));
        healthBarMaxObject.getTransform().scale().setX(1f);
        healthBarMaxObject.getTransform().scale().setY(.1f);

        healthBarObject = new GameObject(transform.position().getX(), transform.position().getY(), transform.position().getZ());
        healthBarObject.addComponent(new SpriteRenderer("healthBar", healthBarObject));
        healthBarObject.getTransform().scale().setX(1f);
        healthBarObject.getTransform().scale().setY(0.1f);

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

    @Override
    public void update() {
        healthBarMaxObject.getTransform().setPosition(transform.position().getX(),transform.position().getY()-0.5f,-1);
        healthBarObject.getTransform().setPosition(transform.position().getX(),transform.position().getY()-0.5f,-2);
        healthBarObject.getTransform().scale().setX((float)ptsVie/(float)ptsVieMax);
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

    protected void animIDIncr(){
        animationID +=1;
        if (animationID>3){
            animationID =0;
        }
    }

    @Override
    public void destroy() {

        transform.setPosition(-999f, -999f, -999f);
    }
}
