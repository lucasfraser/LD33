package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import box2dLight.PointLight;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Random;

/**
 * Created by Sam on 23/08/2015.
 */
public class Firefly extends Entity{

    protected Random rand;
    protected PointLight p;

    public Firefly(float x, float y, World world, Lighting lighting){
        super(true, x, y, 0.05f, 0.05f, world, lighting, true, Images.firefly, false);
        body.setGravityScale(0);
        rand = new Random();
        p = new PointLight(lighting.getRayHandler(), 256, Color.GOLD, 0.5f, x, y);
        p.attachToBody(body);
    }

    public void update(){
        int i = rand.nextInt(80);
        if(i == 0){
            body.applyLinearImpulse(-0.001f, 0, body.getPosition().x, body.getPosition().y, true);
        }
        else if(i == 20){
            body.applyLinearImpulse(0.001f, 0, body.getPosition().x, body.getPosition().y, true);
        }
        else if(i == 40){
            body.applyLinearImpulse(0, -0.001f, body.getPosition().x, body.getPosition().y, true);
        }
        else if(i == 60){
            body.applyLinearImpulse(0, -0.001f, body.getPosition().x, body.getPosition().y, true);
        }
    }
}
