package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Random;

/**
 * Created by Sam on 24/08/2015.
 */
public class Fox extends Entity{
    protected Random rand;
    protected boolean hungry = false;

    public Fox(float x, float y, World world, Lighting lighting){
        super(true, x, y, 1f, 1f, world, lighting, true, Images.fox, false);
        rand = new Random();
        setSound("Sounds/fox.mp3");
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
        else if(i == 3){
            body.applyLinearImpulse(0, 0.1f, body.getPosition().x, body.getPosition().y, true);
        }
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }
}
