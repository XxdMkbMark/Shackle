package cn.qc9ff.shackleje;

import cn.qc9ff.shackleje.libgdx.screen.GameScreen;
import cn.qc9ff.shackleje.libgdx.screen.MenuScreen;
import cn.qc9ff.shackleje.libgdx.screen.StartScreen;
import cn.qc9ff.shackleje.libgdx.util.AssetsPath;
import cn.qc9ff.shackleje.libgdx.util.ScreenType;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class ShackleApplication extends Game {

	//<editor-fold desc="单例声明">
	private ShackleApplication(){}
	private static ShackleApplication instance = new ShackleApplication();
	public static ShackleApplication getInstance(){
		return instance;
	}
	//<editor-fold>
	public static final float WORLD_WIDTH = 1024;
	public static final float WORLD_HEIGHT = 760;

	public static final int PlayerMoveSpeed = 3;
	private StartScreen startScreen;
	private GameScreen gameScreen;
	private MenuScreen menuScreen;
	private ScreenType type;


	public void ChangeScreen(ScreenType nextType){
		switch (nextType){
			case START:{
				startScreen = new StartScreen();
				setScreen(startScreen);
				break;
			}
			case GAME:{
				gameScreen = new GameScreen("tile_map/0-1.tmx");
				setScreen(gameScreen);
				break;
			}
			case MENU:{
				menuScreen = new MenuScreen();
				setScreen(menuScreen);
			}
		}
		disposeScreen(getScreen(type));
		type = nextType;
	}

	public void disposeScreen(Screen screen){
		if(screen != null){
			screen.dispose();
			screen = null;
		}
	}

	public Screen getScreen(ScreenType type){
		switch (type){
			case START: return this.startScreen;
			case GAME: return this.gameScreen;
			case MENU: return this.menuScreen;
		}
		return null;
	}

	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		type = ScreenType.START;
		startScreen = new StartScreen();
		setScreen(startScreen);
	}

	@Override
	public void dispose () {
		super.dispose();
		disposeScreen(startScreen);
		disposeScreen(gameScreen);
		disposeScreen(menuScreen);
	}


}
