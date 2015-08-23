package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Sam on 24/08/2015.
 */
public class Log extends BGEntity{

    public Log(float x, float y, World world, Lighting lighting){
        super( x, y, 2f, 1f, Images.log);
    }

}
