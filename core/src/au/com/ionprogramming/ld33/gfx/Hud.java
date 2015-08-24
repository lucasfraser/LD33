package au.com.ionprogramming.ld33.gfx;

import au.com.ionprogramming.ld33.logic.Logic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Lucas on 24/08/2015.
 */
public class Hud {

    public static void render(SpriteBatch batch, Logic logic){

        batch.begin();
        batch.draw(Images.black, 0, 0, Gdx.graphics.getWidth(), 50, 0, 0, 1, 1, false, false);


        if(logic.isHaveBalloon()){
            batch.draw(Images.balloon, 10, 5, 20, 40, 0, 0, 16, 32, false, false);
        }

        if(logic.isHaveCarrot()){
            batch.draw(Images.carrot, 50, 5, 40, 40, 0, 0, 16, 16, false, false);
        }

        if(logic.isHaveBottle()){
            batch.draw(Images.hwb, 100, 5, 40, 40, 0, 0, 16, 16, false, false);
        }

        if(logic.isHaveDuckling()){
            batch.draw(Images.duckSmall, 150, 5, 40, 40, 0, 0, 16, 16, false, false);
        }

        if(logic.isHaveLolly()){
            batch.draw(Images.lolly, 200, 5, 40, 40, 0, 0, 16, 16, false, false);
        }

        if(logic.isHaveManure()){
            batch.draw(Images.poo, 250, 5, 40, 40, 0, 0, 16, 16, false, false);
        }

        if(logic.isHaveScarf()){
            batch.draw(Images.scarf, 300, 5, 40, 40, 0, 0, 16, 16, false, false);
        }

        if(logic.isHaveMilk()){
            batch.draw(Images.milk, 350, 5, 40, 40, 0, 0, 16, 16, false, false);
        }

        if(logic.isHaveScones()){
            batch.draw(Images.scone, 4900, 5, 40, 40, 0, 0, 16, 16, false, false);
        }

        batch.end();
    }
}
