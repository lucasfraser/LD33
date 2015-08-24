package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Sam on 24/08/2015.
 */
public class Roots extends BGEntity{

    public Roots(float x, float y, World world, Lighting lighting, int type){
        super( x, y, 1f, 1f, Images.roots[type]);
    }

}
