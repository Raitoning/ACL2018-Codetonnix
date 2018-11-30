package engine.scene;

import java.util.ArrayList;

public class SceneManager {

    private static SceneManager instance;

    private ArrayList<Scene> scenes;
    private Scene activeScene;
    private boolean isUnloading = false;

    private SceneManager() {

        scenes = new ArrayList<>();
        activeScene = null;
    }

    public void update() {

        if(!isUnloading) {

            if(activeScene != null) {

                activeScene.update();
            }
        }
    }

    public void loadScene(String name) {

        if (activeScene != null) {

            activeScene.unload();
        }

        for (int i = 0; i < scenes.size(); i++) {

            if(scenes.get(i).getName().equals(name)) {

                scenes.get(i).load();
                activeScene = scenes.get(i);
            }
        }
    }

    public void unloadActiveScene() {

        isUnloading = true;
        activeScene.unload();
        activeScene = null;
        isUnloading = false;
    }

    public void addScene(Scene scene) {

        if(!scenes.contains(scene)) {

            scenes.add(scene);
        }
    }

    public void addScene(Scene scene, int index) {

        if(!scenes.contains(scene)) {

            scenes.add(index, scene);
        }
    }

    public Scene getActiveScene() {

        return activeScene;
    }

    public void startGame() {

        if(scenes.size() != 0) {

            activeScene = scenes.get(0);
            activeScene.load();
        }
    }

    public static SceneManager getInstance() {

        if(instance == null) {

            instance = new SceneManager();
        }

        return instance;
    }
}
