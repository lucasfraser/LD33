package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Random;

/**
 * Created by Sam on 24/08/2015.
 */
public class Turtle extends Entity{
    protected Random rand;

    public Turtle(float x, float y, World world, Lighting lighting){
        super(true, x, y, 1f, 1f, world, lighting, true, Images.turtleHat, false);
        rand = new Random();
        flipY = true;
        setSound("Sounds/turtle.mp3");
    }

    public void flipUp(){
        flipY = false;
    }

    public boolean isOnBack(){
        return flipY;
    }

    @Override
    public void update(){
        if(!flipY) {
            int i = rand.nextInt(1000);
            if (i == 0) {
                body.applyLinearImpulse(-1f, 0, body.getPosition().x, body.getPosition().y, true);
                flipX = false;
            } else if (i == 1) {
                body.applyLinearImpulse(1f, 0, body.getPosition().x, body.getPosition().y, true);
                flipX = true;
            }
        }
    }

}
