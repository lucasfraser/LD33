package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Lighting;
import au.com.ionprogramming.ld33.gfx.SpeechBubble;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;


public abstract class Entity {

	protected Vector2 loc;
	protected Vector2 size;
    protected Body body;
	protected Texture tex;
	protected SpeechBubble bubble;
	protected boolean flip = false;

	protected boolean speechActive;
	protected float talkDist = 2;

    public Entity(boolean moving, float x, float y, float width, float height, World world, Lighting lighting, boolean lockRotation, Texture texture, boolean rounded){

		tex = texture;

        loc = new Vector2(x, y);

		size = new Vector2(width, height);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(size.x / 2, size.y / 2);
		PolygonShape round = null;
		if(rounded) {
			round = new PolygonShape();
			round.set(new float[]{0 - size.x/2, size.y / 6- size.y/2,   0 - size.x/2, size.y- size.y/2,    size.x - size.x/2, size.y- size.y/2,    size.x - size.x/2, size.y/6- size.y/2,     ((size.x / 3) * 2) - size.x/2, 0- size.y/2,      (size.x / 3) - size.x/2, 0- size.y/2     });
		}

		BodyDef bodyDef = new BodyDef();

		bodyDef.position.set(loc.x + width/2 , loc.y + height / 2);
		bodyDef.fixedRotation = lockRotation;

        if(moving){
		    bodyDef.type = BodyDef.BodyType.DynamicBody;

			FixtureDef fixtureDef = new FixtureDef();
			if(rounded){
				fixtureDef.shape = round;
			}
			else {
				fixtureDef.shape = shape;
			}
			fixtureDef.density = 0.5f;
			fixtureDef.friction = 0.4f;
			fixtureDef.restitution = 0.3f;

			body = world.createBody(bodyDef);

			Fixture fixture = body.createFixture(fixtureDef);
        }
        else {
            bodyDef.type = BodyDef.BodyType.StaticBody;

			body = world.createBody(bodyDef);

			body.createFixture(shape, 0.0f);
       }

		shape.dispose();
    }

	public void update(){
	}

	public void render(ShapeRenderer r, SpriteBatch batch){
		batch.draw(tex, body.getPosition().x - size.x / 2, body.getPosition().y - size.y / 2, size.x, size.y, 0, 0, 16, 16, flip, false);
	}

	public void renderSpeechBubble(ShapeRenderer r, SpriteBatch batch, float playerX, float playerY){
		if(bubble != null && speechActive && (Math.abs(body.getPosition().x - playerX) < talkDist && Math.abs(body.getPosition().y - playerY) < talkDist)) {
			bubble.render(batch, r, body.getPosition().x - size.x/2, body.getPosition().y + size.y/2);
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

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
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
