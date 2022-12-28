package cn.qc9ff.shackleje.libgdx.input;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class GameInputListener extends InputListener {
    @Override
    public boolean keyDown(InputEvent event, int keycode) {
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
}
