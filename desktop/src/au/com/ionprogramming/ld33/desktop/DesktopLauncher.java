package au.com.ionprogramming.ld33.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import au.com.ionprogramming.ld33.LD33Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Ectoplasm Isn't Everything";
//		config.backgroundFPS = 0;
//		config.foregroundFPS = 0;
		config.vSyncEnabled = true;
		new LwjglApplication(new LD33Game(), config);

	}
}
