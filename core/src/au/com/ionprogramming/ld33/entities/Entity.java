package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Lighting;
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

    public Entity(boolean moving, float x, float y, float width, float height, World world, Lighting lighting, boolean lockRotation, Texture texture){

		tex = texture;

        loc = new Vector2(x, y);

		size = new Vector2(width, height);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(size.x / 2, size.y/ 2);

		BodyDef bodyDef = new BodyDef();

		bodyDef.position.set(loc.x + width/2 , loc.y + height / 2);
		bodyDef.fixedRotation = lockRotation;

        if(moving){
		    bodyDef.type = BodyDef.BodyType.DynamicBody;

			FixtureDef fixtureDef = new FixtureDef();
			fixtureDef.shape = shape;
			fixtureDef.density = 0.5f;
			fixtureDef.friction = 0.4f;
			fixtureDef.restitution = 0.6f;

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

	public void render(ShapeRenderer r, SpriteBatch batch){

		System.out.println(body.getPosition().x +", " + body.getPosition().y);

		batch.draw(tex, body.getPosition().x - size.x/2, body.getPosition().y - size.y/2, size.x, size.y, 0, 0, 16, 16, false, false);

	}
}
