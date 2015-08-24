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
public class Alpaca extends Entity{
    protected Random rand;

    public Alpaca(float x, float y, World world, Lighting lighting){
        super(true, x, y, 1f, 2f, world, lighting, true, Images.alpaca, false);
        rand = new Random();
        setSound("Sounds/alpaca.mp3");
    }

    @Override
    public void update(){
        int i = rand.nextInt(400);
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
        batch.draw(tex, body.getPosition().x - size.x / 2, body.getPosition().y - size.y / 2, size.x, size.y, 0, 0, 16, 32, flipX, false);
    }

}
