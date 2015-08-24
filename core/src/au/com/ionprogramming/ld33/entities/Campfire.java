package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import box2dLight.PointLight;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Sam on 24/08/2015.
 */
public class Campfire extends BGEntity{

    private int a = 0;
    private int i = 0;
    protected PointLight p;

    public Campfire(float x, float y, World world, Lighting lighting){
        super( x, y, 1f, 1f, Images.fire[0]);
        p = new PointLight(lighting.getRayHandler(), 256, new Color(1, 0.35f, 0, 1f), 3f, x+0.5f, y+0.5f);
    }

    @Override
    public void render(ShapeRenderer r, SpriteBatch batch){
        a++;
        if( a > 7){
            a = 0;
            i++;
            if(i > 2){
                i = 0;
            }
        }
        batch.draw(Images.fire[i], loc.x, loc.y, size.x, size.y, 0, 0, 16, 16, flip, false);
    }

}
