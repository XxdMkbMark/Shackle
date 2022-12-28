package cn.qc9ff.shackleje.libgdx.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.nio.channels.AcceptPendingException;

public class PlayerActor extends Actor {
    protected TextureRegion region;
    public PlayerActor(TextureRegion region) {
        super();
        this.region = region;

        setSize();
    }

    public void setSize(){
        setSize(this.region.getRegionWidth(), this.region.getRegionHeight());
    }

    public TextureRegion getRegion() {
        return region;
    }

    public void setRegion(TextureRegion region) {
        this.region = region;
        setSize();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (region == null || !isVisible()) {
            return;
        }

        batch.draw(
                region,
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation()
        );
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
