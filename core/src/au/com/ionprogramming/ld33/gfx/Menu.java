package au.com.ionprogramming.ld33.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Lucas on 22/08/2015.
 */
public class Menu {
    public static void render(SpriteBatch batch) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.draw(Images.IPL, Gdx.graphics.getWidth() / 2 - Images.IPL.getWidth() / 2, Gdx.graphics.getHeight() / 2 - Images.IPL.getHeight() / 2);

    }
}
