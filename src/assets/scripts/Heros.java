package assets.scripts;

import engine.Engine;
import engine.Mathf;
import engine.Time;
import engine.Vector2;
import engine.gameobject.GameObject;
import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.Camera;
import engine.gameobject.component.Collider;
import engine.gameobject.component.SpriteRenderer;
import engine.input.Input;
import engine.scene.SceneManager;

import java.awt.event.KeyEvent;

public class Heros extends Personnage {

    private BoxCollider2D collider2D;
    private BoxCollider2D trigger2D;

    private float invincibleTime = 1f;

    private float warpedTimer;
    private float unableToWarpTime = 1f;

    private boolean isDashing ;
    private boolean canDash;
    private float dashAttackTime;
    private float dashAttackTimer = 0.15f;
    private float dashAttackCooldown = 0.9f;


    private boolean activeMagic;
    private float magicEffectTimer;
    private float magicEffectDuration = 10f;

    private int strength =1;

    private float speed;

    private GameObject cameraObject;
    private Camera camera;
    private Camera minimap;
    private Labyrinthe labyrinthe;

    public Heros(int posX, int posY, int ptsVie) {
        super(posX, posY, ptsVie);

        canDash = true;
        isDashing = false;
        dashAttackTime = 0f;
        speed = 5f;

        transform.scale().setX(0.5f);
        transform.scale().setY(0.5f);

        name = "Player";

        components.add(new SpriteRenderer("heros", this));

        collider2D = new BoxCollider2D("Player", this);
        components.add(collider2D);

        trigger2D = new BoxCollider2D("Player", this);
        trigger2D.setTrigger(true);
        components.add(trigger2D);

        cameraObject = new GameObject();
        camera = new Camera(10f, 0f, 2f, cameraObject);
        minimap = new Camera(15f, 0f, 2f, cameraObject);
        minimap.setMinRenderArea(new Vector2(0.75f, 0.75f));
        minimap.setRenderPriority(-2);
        cameraObject.addComponent(camera);
        cameraObject.addComponent(minimap);
    }

    @Override
    public void update() {

        if(isAlive()) {

            if(invincible) {

                invincibleTimer += Time.deltaTime;

                if (invincibleTimer >= invincibleTime) {

                    invincibleTimer = 0f;
                    invincible = false;
                }
            }

            if(warped) {

                warpedTimer += Time.deltaTime;

                if (warpedTimer >= unableToWarpTime) {

                    warpedTimer = 0f;
                    warped = false;
                }
            }

            if(activeMagic) {

                magicEffectTimer += Time.deltaTime;

                if (magicEffectTimer >= magicEffectDuration) {

                    strength = 1;
                    speed = 5f;
                    activeMagic = false;
                }
            }

            if(Input.getKey(KeyEvent.VK_SPACE)) {

                attaquer();
            }

            if (!canDash) {

                dashAttackTime += Time.deltaTime;

                if (dashAttackTime >= dashAttackCooldown) {

                    dashAttackTime = 0f;
                    canDash = true;
                }
            }

            if (isDashing) {

                dashAttackTime += Time.deltaTime;

                if (dashAttackTime >= dashAttackTimer) {

                    dashAttackTime = 0f;
                    isDashing = false;
                    canDash = false;
                    speed = 5f;
                }
            }

            transform.position().setX(transform.position().getX() + Input.getAxis("Horizontal") * speed * Time.deltaTime);
            transform.position().setY(transform.position().getY() + Input.getAxis("Vertical") * speed * Time.deltaTime);


            cameraObject.getTransform().position().setX(Mathf.clamp(transform.position().getX(), ((camera.getOrthographicSize() * Engine.getInstance().getRenderer().getAspectRatio()) / 2f) - 0.5f, labyrinthe.getNBCASES() + 0.5f - camera.getOrthographicSize()));

            cameraObject.getTransform().position().setY(Mathf.clamp(transform.position().getY(), camera.getOrthographicSize() / 2f, labyrinthe.getNBCASES() - (camera.getOrthographicSize() / 2f)) - 0.5f);
        }

        if(Input.getKey(KeyEvent.VK_SPACE)) {

            cameraObject.destroy();
            cameraObject = null;
            SceneManager.getInstance().unloadActiveScene();
        }
    }

    public void magicHeal(int amount){
        if (ptsVie + amount <= this.ptsVieMax){
            this.ptsVie += amount;
        }else{
            this.ptsVie = this.ptsVieMax;
        }

    }

    public void magicBuff(boolean str){
        if(!activeMagic) {
            activeMagic = true;

            if (str) {
                this.strength += 1;
            } else {
                this.speed += 1.3f;
            }
        }
    }

    @Override
    public void onTriggerStay2D(Collider other) {

        if(other.getGameObject().getName().equals("Fantome") || other.getGameObject().getName().equals("Monstre")) {
            if (!isDashing){
                recieveDamage(1);}
            else {
                ((Personnage)other.getGameObject()).recieveDamage(strength);
            }
        }
    }

    public boolean isAlive() {

        return ptsVie > 0;
    }

    public void setLabyrinthe(Labyrinthe labyrinthe) {

        this.labyrinthe = labyrinthe;
        transform.position().setX(labyrinthe.getNBCASES() / 2);
        transform.position().setY(labyrinthe.getNBCASES() / 2);
    }

    private void attaquer() {

        if (canDash&&!isDashing) {

            isDashing = true;
            invincible = true;
            speed *= 2;
        }
    }

    @Override
    public void destroy() {
        super.destroy();

        labyrinthe.destroy();
        labyrinthe = null;
    }
}
