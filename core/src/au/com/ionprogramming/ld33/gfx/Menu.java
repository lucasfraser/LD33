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

        batch.draw(Images.Title, Gdx.graphics.getWidth() / 2 - Images.Title.getWidth() / 2, Gdx.graphics.getHeight() / 2 - Images.Title.getHeight() / 2);

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            LD33Game.TITLE_SCREEN = false;
        }

    }
}
