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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;



import static cn.qc9ff.shackleje.ShackleApplication.WORLD_HEIGHT;
import static cn.qc9ff.shackleje.ShackleApplication.WORLD_WIDTH;

public class StartScreen implements Screen {

    private Stage stage;
    private SpriteBatch batch;
    private Sprite gameLabel;
    private Sprite backgroundTextures;
    private Button startGameButton;

    @Override
    public void show() {
        stage = new Stage(new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT));
        Gdx.input.setInputProcessor(stage);
        Button.ButtonStyle startButtonStyle = new Button.ButtonStyle();
        startButtonStyle.up = new TextureRegionDrawable(new Texture(AssetsPath.START_SCREEN_STAR_GAME_BUTTON_UP));
        startButtonStyle.down = new TextureRegionDrawable(new Texture(AssetsPath.START_SCREEN_STAR_GAME_BUTTON_DOWN));
        startGameButton = new Button(startButtonStyle);
        startGameButton.setPosition(200, 10);
        startGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("YEE");
            }
        });
        stage.addActor(startGameButton);

        batch = new SpriteBatch();
        gameLabel = new Sprite(new Texture(Gdx.files.internal(AssetsPath.START_SCREEN_GAME_LABEL_PATH)));
        gameLabel.setPosition(100, 10);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
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
        }
        if (stage != null) {
            stage.dispose();
        }
    }
}
