package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Lucas on 22/08/2015.
 */
public class Grass extends Entity {

    private Color color;

    public Grass(float x, float y, World world, Lighting lighting, int pos){
        super(false, x, y, 1, 1, world, lighting, true, Images.grass[pos]);
    }
}
