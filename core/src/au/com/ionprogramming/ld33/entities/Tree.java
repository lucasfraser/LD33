package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Random;

/**
 * Created by Sam on 24/08/2015.
 */
public class Tree extends BGEntity{

    public Tree(float x, float y, World world, Lighting lighting, int type){
        super( x, y, 3f, 4f, Images.tree[type]);
    }

}
