package cn.qc9ff.shackleje;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import cn.qc9ff.shackleje.ShackleApplication;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(30);
		config.setWindowedMode(1024, 768);
		config.setTitle("Shackle-JEG");
		config.setWindowIcon("icon.png");
		config.setResizable(false);
		new Lwjgl3Application(ShackleApplication.getInstance(), config);
	}
}
