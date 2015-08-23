package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import au.com.ionprogramming.ld33.gfx.Renderer;
import box2dLight.PointLight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
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
    private PointLight p;

    public Player(float x, float y, World world, Texture[] t, Lighting lighting){
        super(true, x, y, 0.9f, 1.8f, world, lighting, true, t[0], true);
        this.t = t[0];
        p = new PointLight(lighting.getRayHandler(), 256, new Color(1, 1, 1, 0.5f), 2f, x, y);
        p.attachToBody(body);
    }

    @Override
    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            flip = true;

            body.applyLinearImpulse(-0.1f, 0, body.getPosition().x, body.getPosition().y, true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            flip = false;

            body.applyLinearImpulse(0.1f, 0, body.getPosition().x, body.getPosition().y, true);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            body.applyLinearImpulse(0, 6f, body.getPosition().x, body.getPosition().y, true);
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
        batch.draw(Images.monster[sprite], body.getPosition().x - size.x / 2, body.getPosition().y - size.y / 2, size.x, size.y, 0, 0, Images.monster[sprite].getWidth(), Images.monster[sprite].getHeight(), flip, false);
    }

}
