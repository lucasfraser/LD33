package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Lucas on 7/08/2015.
 */
public class Cube extends Entity {

    private Color color;

    public Cube(boolean moving, float x, float y, float width, float height, World world, Color col, Lighting lighting){
        super(moving, x, y, width, height, world, lighting, false, Images.grass[1], false);
        color = col;
    }

    @Override
    public void render(ShapeRenderer r, SpriteBatch batch){
        r.setColor(color);
        r.rect(body.getPosition().x - size.x/2, body.getPosition().y - size.y/2, size.x / 2, size.y / 2, size.x, size.y, 1, 1, (float)Math.toDegrees(body.getAngle()));

    }
}
