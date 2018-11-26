package assets.scripts;

import engine.Engine;
import engine.Mathf;
import engine.Time;
import engine.Vector2;
import engine.gameobject.GameObject;
import engine.gameobject.component.BoxCollider2D;
import engine.gameobject.component.Camera;
import engine.gameobject.component.SpriteRenderer;
import engine.input.Input;

import java.awt.event.KeyEvent;

public class Heros extends Personnage {

    private BoxCollider2D collider2D;
    private BoxCollider2D trigger2D;
    private float invincibleTimer;
    private float invincibleTime = 1f;

    private float warpedTimer;
    private float unableToWarpTime = 1f;

    private boolean isDashing ;
    private boolean canDash;
    private float dashAttackTime;
    private float dashAttackTimer = 0.15f;
    private float dashAttackCooldown = 0.9f;

    private GameObject cameraObject;
    private Camera camera;
    private Camera minimap;
    private Labyrinthe labyrinthe;

    public Heros(int posX, int posY, int ptsVie) {
        super(posX, posY, ptsVie);

        canDash = true;
        isDashing = false;
        dashAttackTime = 0f;

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
        camera.getGameObject().addComponent(camera);
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
                }
                transform.position().setX(transform.position().getX() + Input.getAxis("Horizontal") * 10f * Time.deltaTime);
                transform.position().setY(transform.position().getY() + Input.getAxis("Vertical") * 10f * Time.deltaTime);
            }

            if (!isDashing) {

                transform.position().setX(transform.position().getX() + Input.getAxis("Horizontal") * 5f * Time.deltaTime);
                transform.position().setY(transform.position().getY() + Input.getAxis("Vertical") * 5f * Time.deltaTime);
            }

            cameraObject.getTransform().position().setX(Mathf.clamp(transform.position().getX(), ((camera.getOrthographicSize() * Engine.getInstance().getRenderer().getAspectRatio()) / 2f) - 0.5f, labyrinthe.getNBCASES() + 0.5f - camera.getOrthographicSize()));

            cameraObject.getTransform().position().setY(Mathf.clamp(transform.position().getY(), camera.getOrthographicSize() / 2f, labyrinthe.getNBCASES() - (camera.getOrthographicSize() / 2f)) - 0.5f);
        }
    }

    @Override
    public void setPtsVie(int ptsVie) {

        if(!invincible) {

            this.ptsVie = ptsVie;
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
        }
    }
}
