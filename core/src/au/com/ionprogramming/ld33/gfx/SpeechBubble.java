package au.com.ionprogramming.ld33.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;

/**
 * Created by Sam on 22/08/2015.
 */
public class SpeechBubble {

    protected BitmapFont font;
    protected GlyphLayout glyph;
    protected String text;
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected float fullHeight;
    protected float progress = 0;
    protected float border = 0.1f;
    protected Color textCol;
    protected Color boxCol;

    public SpeechBubble(String text, float width){
        textCol = Color.WHITE;
        boxCol = new Color(0f, 0f, 0f, 0.5f);
        font = new BitmapFont();
        glyph = new GlyphLayout();
        font.setUseIntegerPositions(false);
        font.getData().setScale(0.02f, 0.02f);
        this.text = text;
        this.width = width;
        glyph.setText(font, text, 0, text.length() - 1, Color.FOREST, width, Align.left, true, null);
        fullHeight = glyph.height;
    }

    public SpeechBubble(String text, float width, Color textCol, Color boxCol){
        this.textCol = textCol;
        this.boxCol = boxCol;
        font = new BitmapFont();
        glyph = new GlyphLayout();
        font.setUseIntegerPositions(false);
        this.text = text;
        this.width = width;
        glyph.setText(font, text, 0, text.length() - 1, textCol, width, Align.left, true, null);
        fullHeight = glyph.height;
    }

    public void render(SpriteBatch batch, ShapeRenderer r, float x, float y){
        glyph.setText(font, text, 0, (int) progress, textCol, width, Align.left, true, null);
        height = glyph.height;
        if(progress < text.length()) {
            progress += 0.5f;
        }

        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        r.begin(ShapeRenderer.ShapeType.Filled);
            r.setColor(boxCol);
            r.rect(x - border, y + fullHeight - height, width + border * 2, height);
            r.rect(x, y - border + fullHeight - height, width, border);
            r.rect(x, y + fullHeight, width, border);
            r.arc(x, y + fullHeight, border, 90, 90);
            r.arc(x, y + fullHeight - height, border, 180, 90);
            r.arc(x + width, y + fullHeight, border, 0, 90);
            r.arc(x + width, y + fullHeight - height, border, 270, 90);
        r.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);

        batch.begin();
            font.draw(batch, glyph, x, y + fullHeight);
        batch.end();
    }
}
