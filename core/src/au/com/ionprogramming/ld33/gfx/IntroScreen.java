package au.com.ionprogramming.ld33.gfx;

import au.com.ionprogramming.ld33.LD33Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Lucas on 22/08/2015.
 */
public class IntroScreen {

    private static int threshold = 0;

    public static void render(SpriteBatch batch){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        threshold++;
        batch.draw(Images.IPL, Gdx.graphics.getWidth()/2 - Images.IPL.getWidth()/2, Gdx.graphics.getHeight()/2 - Images.IPL.getHeight()/2 );

        if(threshold > 120){
            LD33Game.INTRO = false;
        }
    }

}
