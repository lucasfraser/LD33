package au.com.ionprogramming.ld33.entities;

import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import box2dLight.PointLight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Lucas on 3/08/2015.
 */
public class Player extends Entity{

    Texture t;
    private PointLight p;

    public Player(float x, float y, World world, Lighting lighting){
        super(true, x, y, 0.9f, 1.8f, world, lighting, true, Images.monster[0], true);
        this.t = Images.monster[0];
        p = new PointLight(lighting.getRayHandler(), 256, new Color(1, 1, 1, 0.7f), 2f, x, y);
        body.setGravityScale(0.5f);
        p.attachToBody(body);
    }

    @Override
    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            flipX = true;
            body.applyLinearImpulse(-0.1f, 0, body.getPosition().x, body.getPosition().y, true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            flipX = false;
            body.applyLinearImpulse(0.1f, 0, body.getPosition().x, body.getPosition().y, true);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            body.applyLinearImpulse(0, 3f, body.getPosition().x, body.getPosition().y, true);
        }
    }

    int tick = 0;
    int sprite = 0;

    @Override
    public void render(ShapeRenderer r, SpriteBatch batch){
        tick++;
        if(tick > 10){
            tick = 0;
            if(sprite < 3){
                sprite++;
            }
            else{
                sprite = 0;
            }
        }
        batch.draw(Images.monster[sprite], body.getPosition().x - size.x / 2, body.getPosition().y - size.y / 2, size.x, size.y, 0, 0, Images.monster[sprite].getWidth(), Images.monster[sprite].getHeight(), flipX, false);
    }

}
