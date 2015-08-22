package au.com.ionprogramming.ld33.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Sam on 22/08/2015.
 */
public class SpeechBubble {

    protected BitmapFont font = new BitmapFont();
    protected String text;
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected float progress = 0;

    public SpeechBubble(String text, float x, float y, float width, float height){
        font.setUseIntegerPositions(false);
        font.getData().setScale(0.02f, 0.02f);
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render(SpriteBatch batch, ShapeRenderer r){
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        r.begin(ShapeRenderer.ShapeType.Filled);
        r.setColor(1f, 1f, 1f, 0.3f);
            r.rect(x, y, width, 1);
        r.end();
        r.begin(ShapeRenderer.ShapeType.Line);
            r.setColor(1f, 1f, 1f, 0.5f);
            r.rect(x, y, width, height);
        r.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);
        batch.begin();
            font.draw(batch, text, x, y + height, 0, (int)progress, width, 0, true);
            if(progress < text.length()) {
                progress += 0.5f;
            }
        batch.end();
    }
}
