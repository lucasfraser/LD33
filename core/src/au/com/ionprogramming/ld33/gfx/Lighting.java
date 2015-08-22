package au.com.ionprogramming.ld33.gfx;


import au.com.ionprogramming.ld33.logic.Physics;
import box2dLight.DirectionalLight;
import box2dLight.PointLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Lucas on 3/08/2015.
 */

public class Lighting {

    private RayHandler rayHandler;

    public Lighting(Physics phys){

        rayHandler = new RayHandler(phys.getWorld());

        rayHandler.setAmbientLight(new Color(0.3f, 0.3f, 0.3f, 0.3f));


//
//        addPointLight(10, 10, 30, new Color(1,0,0,1), true, phys.getWorld());
//
//        addPointLight(40, 25, 30, new Color(0,1,0,1), true, phys.getWorld());
//
//        addPointLight(20, 15, 30, new Color(0,0,1,1), true, phys.getWorld());
//
//        addPointLight(2, 45, 30, new Color(61, 0, 142, 255), true, phys.getWorld());
         new DirectionalLight(rayHandler, 512, new Color(0.4f, 0.2f, 0.2f, 0.5f), 300);

        rayHandler.setShadows(false);

    }

    public void render(OrthographicCamera cam){



        rayHandler.setCombinedMatrix(cam.combined);
        rayHandler.updateAndRender();
    }

    public void addPointLight(float x, float y, float raduis, Color col, boolean isSolid, World w){

        if(isSolid){
            Body body;
            Vector2 size = new Vector2(0.5f, 0.5f);
            PolygonShape shape = new PolygonShape();
            shape.setAsBox(size.x, size.y);

            BodyDef bodyDef = new BodyDef();

            bodyDef.position.set(x , y);

            bodyDef.type = BodyDef.BodyType.StaticBody;

            body = w.createBody(bodyDef);

            body.createFixture(shape, 0.0f);

            shape.dispose();

        }

        new PointLight(rayHandler, 256, col, raduis, x, y);
    }


}
