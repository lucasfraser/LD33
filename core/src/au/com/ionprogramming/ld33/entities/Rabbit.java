package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Random;

/**
 * Created by Sam on 24/08/2015.
 */
public class Rabbit extends Entity{
    protected Random rand;

    public Rabbit(float x, float y, World world, Lighting lighting){
        super(true, x, y, 1f, 1f, world, lighting, true, Images.rabbitBig, false);
        rand = new Random();
        setSound("Sounds/rabbit.mp3");
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
        else if(i == 2){
            body.applyLinearImpulse(0, -1f, body.getPosition().x, body.getPosition().y, true);
        }
        else if(i == 3){
            body.applyLinearImpulse(0, 1f, body.getPosition().x, body.getPosition().y, true);
        }
    }

}
