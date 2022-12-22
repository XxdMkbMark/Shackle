package cn.qc9ff.shackleje.libgdx.input;

import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case 51:{   //W
                break;
            }
            case 47:{   //S
                break;
            }
            case 29:{   //A
                break;
            }
            case 32:{   //D
                break;
            }
            default:{
                break;
            }
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
