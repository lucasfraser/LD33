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
public class Cow extends Entity{
    protected Random rand;

    public Cow(float x, float y, World world, Lighting lighting){
        super(true, x, y, 2f, 1f, world, lighting, true, Images.cow, false);
        rand = new Random();

    }

    @Override
    public void update(){
        int i = rand.nextInt(800);
        if(i == 0){
            body.applyLinearImpulse(-1f, 0, body.getPosition().x, body.getPosition().y, true);
            flipX = false;
        }
        else if(i == 1){
            body.applyLinearImpulse(1f, 0, body.getPosition().x, body.getPosition().y, true);
            flipX = true;
        }
    }

    @Override
    public void render(ShapeRenderer r, SpriteBatch batch){
        batch.draw(tex, loc.x, loc.y, size.x, size.y, 0, 0, 32, 16, flipX, false);
    }

}
