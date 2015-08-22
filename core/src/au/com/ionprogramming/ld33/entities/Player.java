package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Lucas on 3/08/2015.
 */
public class Player extends Entity{

    Texture t;

    public Player(float x, float y, float width, float height, World world, Texture t, Lighting lighting){
        super(true, x, y, width, height, world, lighting, true, Images.grass[1]);
        this.t = t;
    }

    private void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            body.applyLinearImpulse(-0.1f, 0, body.getPosition().x, body.getPosition().y, true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            body.applyLinearImpulse(0.1f, 0, body.getPosition().x, body.getPosition().y, true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            body.applyLinearImpulse(0, 0.1f, body.getPosition().x, body.getPosition().y, true);
        }

    }

    @Override
    public void render(ShapeRenderer r, SpriteBatch batch){

        update();

        batch.draw(t, body.getPosition().x - size.x/2, body.getPosition().y - size.y/2, size.x, size.y);

    }

}
