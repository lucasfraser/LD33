package au.com.ionprogramming.ld33.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Lucas on 3/08/2015.
 */
public class Physics {

    private World world;
    private Box2DDebugRenderer debugRenderer;

    private float accumulator = 0;

    public Physics(){
        world = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();
    }

    public void render(OrthographicCamera cam){
        debugRenderer.render(world, cam.combined);
    }

    public void doPhysicsStep(float deltaTime) {
        // fixed time step
        // max frame time to avoid spiral of death (on slow devices)
        float frameTime = Math.min(deltaTime, 0.25f);
        accumulator += frameTime;
        while (accumulator >= 1/45f) {

            world.step(1/45f,6, 2);
            accumulator -= 1/45f;
        }
    }

    public World getWorld(){
        return world;
    }

}
