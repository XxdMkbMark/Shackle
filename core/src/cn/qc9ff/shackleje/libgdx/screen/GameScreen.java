package cn.qc9ff.shackleje.libgdx.screen;

import cn.qc9ff.shackleje.level.Level;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    private Level level;
    private Stage stage;
    private TiledMap map;
    private TmxMapLoader loader;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera cam;

    @Override
    public void show() {
        loader = new TmxMapLoader();
        map = loader.load("tile_map/0-1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1f);
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 800, 600);
        cam.update();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(225f,225f,225f,0.4f);
        renderer.setView(cam);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        if(map != null){
            map.dispose();
            map = null;
        }

        if(renderer != null){
            renderer.dispose();
            renderer = null;
        }
    }
}
