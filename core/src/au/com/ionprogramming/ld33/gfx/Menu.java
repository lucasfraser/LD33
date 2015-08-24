package au.com.ionprogramming.ld33.gfx;

import au.com.ionprogramming.ld33.LD33Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Lucas on 22/08/2015.
 */
public class Menu {
    public static void render(SpriteBatch batch) {
        Gdx.gl.glClearColor(0f, 0f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.draw(Images.Title, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0, 0, Images.Title.getWidth(), Images.Title.getHeight(), false, false);

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            LD33Game.TITLE_SCREEN = false;
        }

    }
}
