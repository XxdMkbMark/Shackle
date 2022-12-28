package cn.qc9ff.shackleje.libgdx.screen;

import cn.qc9ff.shackleje.ShackleApplication;
import cn.qc9ff.shackleje.libgdx.actor.PlayerActor;
import cn.qc9ff.shackleje.libgdx.util.AssetsPath;
import cn.qc9ff.shackleje.libgdx.util.CollisionUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {
    private Stage stage;
    private SpriteBatch batch;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera cam;
    //private Vector3 pot;
    private PlayerActor player;
    private Texture playerTexture;

    private final Array<Rectangle> rectangleList = new Array<>();
    //<editor-fold desc="a">


    public GameScreen(String gameMapPath) {
        map = new TmxMapLoader().load(gameMapPath);
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        //地图加载&渲染

        renderer = new OrthogonalTiledMapRenderer(map, 1f);

        //加载游戏对象
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 1024, 768);
        cam.position.set(0, 0, 0);
        cam.update();

//        pot = new Vector3();
//        pot.set(0, 0, 0);
        getTiles(0, 0, 1000, 1000, rectangleList);

        batch = new SpriteBatch();
        playerTexture = new Texture(Gdx.files.internal(AssetsPath.GAME_SCREEN_PLAYER_TEXTURE));
        player = new PlayerActor(new TextureRegion(playerTexture));
        player.setPosition(0, 0);
        player.setScale(0.1f);

        stage.addActor(player);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(225f,225f,225f,0.4f);
        renderer.setView(cam);
        renderer.render();

        processInput();
        collisionTest();
        //System.out.println(pot.toString());
        cam.position.set(player.getX(), player.getY(), 0);
        cam.update();

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

        if(stage != null){
            stage.dispose();
            stage = null;
        }

        if(playerTexture != null){
            playerTexture.dispose();
            playerTexture = null;
        }

        if(batch != null){
            batch.dispose();
            batch = null;
        }
    }

    //<editor-fold>

    private void processInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            player.move(0, ShackleApplication.PlayerMoveSpeed);
            //pot.y += ShackleApplication.PlayerMoveSpeed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            player.move(0, -1 * ShackleApplication.PlayerMoveSpeed);
            //pot.y -= ShackleApplication.PlayerMoveSpeed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            player.move(-1 * ShackleApplication.PlayerMoveSpeed, 0);
            //pot.x -= ShackleApplication.PlayerMoveSpeed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            player.move(ShackleApplication.PlayerMoveSpeed, 0);
            //pot.x += ShackleApplication.PlayerMoveSpeed;
        }
    }


    private void resetCamera() {
        //重置相机位置
        if (Gdx.input.isKeyPressed(Input.Keys.R)) {
            cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
            cam.zoom = 1;
            cam.rotate(0, 0, 0, 1);
        }
    }

    private void collisionTest(){
        for(Rectangle rectangle : rectangleList){
            if(CollisionUtils.isReCollision(player, rectangle)){
                System.out.println("Collision!");
            }
        }
    }

    private Pool<Rectangle> rectPool = new Pool<Rectangle>() {
        @Override
        protected Rectangle newObject () {
            return new Rectangle();
        }
    };

    private void getTiles (int startX, int startY, int endX, int endY, Array<Rectangle> tiles) {
        TiledMapTileLayer layer = (TiledMapTileLayer)map.getLayers().get(1);
        rectPool.freeAll(tiles);
        tiles.clear();
        for (int y = startY; y <= endY; y++) {
            for (int x = startX; x <= endX; x++) {
                TiledMapTileLayer.Cell cell = layer.getCell(x, y);
                if (cell != null) {
                    Rectangle rect = rectPool.obtain();
                    rect.set(x, y, 1, 1);
                    tiles.add(rect);
                }
            }
        }
    }



}
