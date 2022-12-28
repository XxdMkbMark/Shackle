package cn.qc9ff.shackleje.libgdx.screen;

import cn.qc9ff.shackleje.libgdx.actor.PlayerActor;
import cn.qc9ff.shackleje.libgdx.input.GameInputListener;
import cn.qc9ff.shackleje.libgdx.util.AssetsPath;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    private Stage stage;
    private TiledMap map;
    private TmxMapLoader loader;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera cam;
    private PlayerActor player;
    private Texture playerTexture;
    private SpriteBatch batch;

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        stage.addListener(new GameInputListener());
        //地图加载&渲染
        loader = new TmxMapLoader();
        map = loader.load("tile_map/0-1.tmx");

        renderer = new OrthogonalTiledMapRenderer(map, 1f);

        //加载游戏对象
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 800, 600);
        cam.update();

        batch = new SpriteBatch();
        playerTexture = new Texture(Gdx.files.internal(AssetsPath.GAME_SCREEN_PLAYER_TEXTURE));
        player = new PlayerActor(new TextureRegion(playerTexture));
        player.setPosition(150, 400);
        player.setScale(0.1f);

        stage.addActor(player);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(225f,225f,225f,0.4f);
        renderer.setView(cam);
        renderer.render();

        stage.act();
        stage.draw();

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
