package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyFluppyBird;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = MyFluppyBird.WIDTH;
        config.height = MyFluppyBird.HEIGHT;
        config.title = MyFluppyBird.Title;
        new LwjglApplication(new MyFluppyBird(), config);
    }
}
