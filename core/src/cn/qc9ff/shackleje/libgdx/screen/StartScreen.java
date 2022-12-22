package cn.qc9ff.shackleje.libgdx.screen;

import cn.qc9ff.shackleje.libgdx.util.AssetsPath;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;



import static cn.qc9ff.shackleje.ShackleApplication.WORLD_HEIGHT;
import static cn.qc9ff.shackleje.ShackleApplication.WORLD_WIDTH;

public class StartScreen implements Screen {


    //<editor-fold desc="StartScreen成员声明">
    private Stage stage;
    private SpriteBatch batch;
    private Sprite gameLabel;
    private Sprite backgroundTextures;
    private Button startGameButton;
    private Button exitGameButton;
    private Button settingButton;
    //</editor-fold>

    //gameLabel预处理
    public void InitGameLabel(){
        gameLabel = new Sprite(new Texture(Gdx.files.internal(AssetsPath.START_SCREEN_GAME_LABEL_PATH)));
        gameLabel.setPosition(100, 450);
    }
    //背景图预处理
    public void InitBackgroundTextures(){

    }
    //开始游戏按钮预处理
    public void InitStartGameButton(){
        Button.ButtonStyle startButtonStyle = new Button.ButtonStyle();
        startButtonStyle.up = new TextureRegionDrawable(new Texture(AssetsPath.START_SCREEN_STAR_GAME_BUTTON_UP));
        startButtonStyle.down = new TextureRegionDrawable(new Texture(AssetsPath.START_SCREEN_STAR_GAME_BUTTON_DOWN));
        startGameButton = new Button(startButtonStyle);
        startGameButton.setPosition(200, 350);
        startGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("YEE");
            }
        });
        startGameButton.setWidth(200);
        startGameButton.setHeight(80);
    }
    //离开游戏按钮预处理
    public void InitExitGameButton(){
        Button.ButtonStyle startButtonStyle = new Button.ButtonStyle();
        startButtonStyle.up = new TextureRegionDrawable(new Texture(AssetsPath.START_SCREEN_EXIT_GAME_BUTTON_UP));
        startButtonStyle.down = new TextureRegionDrawable(new Texture(AssetsPath.START_SCREEN_EXIT_GAME_BUTTON_DOWN));
        exitGameButton = new Button(startButtonStyle);
        exitGameButton.setPosition(200, 250);
        exitGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("exit");
                Gdx.app.exit();
            }
        });
        exitGameButton.setWidth(200);
        exitGameButton.setHeight(80);
    }
    //设置按钮预处理
    public void InitSettingButton(){
        Button.ButtonStyle startButtonStyle = new Button.ButtonStyle();
        startButtonStyle.up = new TextureRegionDrawable(new Texture(AssetsPath.START_SCREEN_SETTING_BUTTON_UP));
        startButtonStyle.down = new TextureRegionDrawable(new Texture(AssetsPath.START_SCREEN_SETTING_BUTTON_DOWN));
        settingButton = new Button(startButtonStyle);
        settingButton.setPosition(200, 150);
        settingButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
                System.out.println("setting");
            }
        });
        settingButton.setWidth(200);
        settingButton.setHeight(80);
    }
    @Override
    public void show() {
        InitGameLabel();
        InitBackgroundTextures();
        InitStartGameButton();
        InitExitGameButton();
        InitSettingButton();
        stage = new Stage(new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT));
        Gdx.input.setInputProcessor(stage);

        stage.addActor(startGameButton);
        stage.addActor(exitGameButton);
        stage.addActor(settingButton);

        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();
        gameLabel.draw(batch);
        batch.end();

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
        if (batch != null) {
            batch.dispose();
            batch = null;
        }
        if (stage != null) {
            stage.dispose();
            stage = null;
        }
    }
}
