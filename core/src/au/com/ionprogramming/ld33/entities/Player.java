package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import au.com.ionprogramming.ld33.gfx.Renderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Lucas on 3/08/2015.
 */
public class Player extends Entity{

    Texture t;

    boolean flip;

    public Player(float x, float y, float width, float height, World world, Texture[] t, Lighting lighting){
        super(true, x, y, width, height, world, lighting, true, t[0], true);
        this.t = t[0];
    }

    private void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            flip = true;

            body.applyLinearImpulse(-0.1f, 0, body.getPosition().x, body.getPosition().y, true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            flip = false;

            body.applyLinearImpulse(0.1f, 0, body.getPosition().x, body.getPosition().y, true);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            body.applyLinearImpulse(0, 8f, body.getPosition().x, body.getPosition().y, true);
        }

        Renderer.px = body.getPosition().x - size.x/2;
        Renderer.py = body.getPosition().y - size.y/2;
    }

    int tick = 0;
    int sprite = 0;

    @Override
    public void render(ShapeRenderer r, SpriteBatch batch){
        tick++;

        if(tick > 10 && body.isAwake()){
            tick = 0;
            if(sprite < 3){
                sprite++;
            }
            else{
                sprite = 0;
            }
        }
        update();


        batch.draw(Images.monster[sprite], body.getPosition().x - size.x/2, body.getPosition().y - size.y/2, size.x, size.y, 0, 0, Images.monster[sprite].getWidth(), Images.monster[sprite].getHeight(), flip, false);
    }

}
