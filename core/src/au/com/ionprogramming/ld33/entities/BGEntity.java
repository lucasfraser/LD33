package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Lighting;
import au.com.ionprogramming.ld33.gfx.SpeechBubble;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;


public abstract class BGEntity {

	protected Vector2 loc;
	protected Vector2 size;
	protected Texture tex;
	protected SpeechBubble bubble;
	protected boolean flip = false;

	protected boolean speechActive;
	protected float talkDist = 2;

    public BGEntity(float x, float y, float width, float height, Texture texture){
		tex = texture;
        loc = new Vector2(x, y);
		size = new Vector2(width, height);
    }

	public void update(){
	}

	public void render(ShapeRenderer r, SpriteBatch batch){
		batch.draw(tex, loc.x, loc.y, size.x, size.y, 0, 0, 16, 16, flip, false);
	}

	public void renderSpeechBubble(ShapeRenderer r, SpriteBatch batch, float playerX, float playerY){
		if(bubble != null && speechActive && (Math.abs(loc.x + size.x/2 - playerX) < talkDist && Math.abs(loc.y + size.y/2 - playerY) < talkDist)) {
			bubble.render(batch, r, loc.x, loc.y + size.y);
		}
		else if(bubble != null){
			bubble.resetProgress();
		}
	}

	public Vector2 getLoc() {
		return loc;
	}

	public void setLoc(Vector2 loc) {
		this.loc = loc;
	}

	public Vector2 getSize() {
		return size;
	}

	public void setSize(Vector2 size) {
		this.size = size;
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}

	public void setSpeechBubble(SpeechBubble bubble){this.bubble = bubble;}

	public SpeechBubble getSpeechBubble(){return bubble;}

	public boolean isSpeechActive() {
		return speechActive;
	}

	public void setSpeechActive(boolean speechActive) {
		this.speechActive = speechActive;
	}
}
