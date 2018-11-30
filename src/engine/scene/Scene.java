package engine.scene;

import engine.gameobject.GameObject;

import java.util.ArrayList;

public class Scene {

    protected String name;
    private static int numberOfScenes = 0;
    private int id;
    protected ArrayList<GameObject> gameObjects;
    protected boolean isLoaded = false;

    public Scene(String name, int index) {

        this.name = name;

        gameObjects = new ArrayList<>();
        id = numberOfScenes;
        numberOfScenes++;

        SceneManager.getInstance().addScene(this, index);
    }

    protected void addGameObject(GameObject gameObject) {

        gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject) {

        gameObjects.remove(gameObject);
    }

    public String getName() {

        return name;
    }

    public void update() {

        if(isLoaded) {

            for (int i = 0; i < gameObjects.size(); i++) {

                gameObjects.get(i).update();
            }
        }
    }

    public int getId() {

        return id;
    }

    public int numberOfGameObjects() {

        return gameObjects.size();
    }

    public GameObject getGameObjectByName(String name) {

        for (int i = 0; i < gameObjects.size(); i++) {

            if(gameObjects.get(i).getName().equals(name)) {

                return gameObjects.get(i);
            }
        }

        return null;
    }

    public void unload() {

        isLoaded = false;

        for (int i = 0; i < gameObjects.size(); i++) {

            gameObjects.get(i).destroy();
        }

        gameObjects.clear();
//        gameObjects = null;
    }

    public void load() {}
}
