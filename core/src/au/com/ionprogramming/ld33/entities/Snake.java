package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Random;

/**
 * Created by Sam on 24/08/2015.
 */
public class Snake extends Entity{

    public Snake(float x, float y, World world, Lighting lighting){
        super(true, x, y, 1f, 1f, world, lighting, true, Images.snake, false);
    }

}
