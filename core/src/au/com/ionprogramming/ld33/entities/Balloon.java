package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Random;

/**
 * Created by Sam on 24/08/2015.
 */
public class Balloon extends Entity{
    protected Random rand;

    public Balloon(float x, float y, World world, Lighting lighting){
        super(true, x, y, 1f, 2f, world, lighting, true, Images.balloon, false);
        rand = new Random();
        body.setGravityScale(0.05f);
    }

    @Override
    public void update(){
        int i = rand.nextInt(100);
        if(i == 0){
            body.applyLinearImpulse(0, 0.2f, body.getPosition().x, body.getPosition().y, true);
        }
    }

    @Override
    public void render(ShapeRenderer r, SpriteBatch batch){
        batch.draw(tex, body.getPosition().x - size.x / 2, body.getPosition().y - size.y / 2, size.x, size.y, 0, 0, 16, 32, flipX, false);
    }

}
